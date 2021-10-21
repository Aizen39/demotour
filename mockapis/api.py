#! /usr/bin/env python3

"""Mock API"""

from os import environ
from libs.io import read
from flask import Flask, jsonify, make_response, request, abort
from flask_httpauth import HTTPTokenAuth
from datetime import datetime as dt

try:
    filename = environ['MOCK_CONFIG'] if environ['MOCK_CONFIG'] else 'default'
except KeyError:
    filename = 'default'

config = read("scenarios/{}.json".format(filename))

CREDENTIALS = config['credentials']
valid_tokens = ['c142be996b21641104df3397f2c91a0c']

app = Flask(__name__)
auth = HTTPTokenAuth()

@app.route('/token', methods=['POST'])
def token():
    """
    Retrieve the basic 'Authorization header'
    compare to 'CREDENTIALS' value.

    :return: Token or '400 Bad Request'
    """
    body = request.json
    if not body or not 'client_secret' in body :
        return make_response(
            jsonify({'error': 'Authentication failed, missing client_secret'}), 400)
    elif body['client_secret'] == CREDENTIALS :
            return generate_response(config['token'])
    else:
        return make_response(
            jsonify({'error': 'Authentication failed, wrong client_secret'}), 400)

@app.route('/api/customers', methods=['GET'])
#@auth.login_required
def get_customers():
    """
    Accept only a GET request.
    A valid token is required.

    :return: json response
    """
    body, code = generate_response(config["customers"])
    return jsonify(body), code

@app.route('/api/orders', methods=['GET'])
#@auth.login_required
def get_orders():
    """
    Accept only a GET request.
    A valid token is required.

    :return: json response
    """
    body, code = generate_response(config["orders"])
    return jsonify(body), code

@app.route('/api/customers/<int:id_customer>/orders', methods=['GET'])
#@auth.login_required
def get_orders_by(id_customer):
    """
    Accept only a GET request.
    A valid token is required.

    :return: json response
    """
    body, code = generate_response(config["orders"])
    orders = [o for o in body if o['idCustomer'] == id_customer]
    return jsonify(orders), code

def generate_response(config):
    code = config["code"]
    if code in range(400, 600):
        abort(code)
    data = read("resources/{}.json".format(config["data"]))
    error = config["error"]
    if data :
        return data, code
    return error, code

@auth.verify_token
def verify_token(header):
    """
    Verify if the token pass in 'Authorization' header is a known token.
    """
    print(header)
    if header in valid_tokens:
        return header
    return None

@auth.error_handler
def unauthorized():
    """
    Basic 401 error handling.
    """
    return make_response(jsonify({'error': 'Unauthorized access'}), 401)

#@app.after_request
def after_request(response):
    """
    Logging after every request.
    """
    app.logger.info(
        "\n\n---> [%s] %s %s %s %s %s %s %s \n%s %s",
        dt.utcnow().strftime("%d/%b/%Y:%H:%M:%S.%f")[:-3],
        request.method,
        request.path,
        request.scheme,
        response.status,
        response.content_length,
        request.referrer,
        request.user_agent,
        request.headers,
        request.data
    )
    app.logger.info(
        "\n\n<--- [%s] %s \n%s %s",
        dt.utcnow().strftime("%d/%b/%Y:%H:%M:%S.%f")[:-3],
        '\n',
	response.headers,
        response.data
    )
    return response

if __name__ == '__main__':
    app.run(debug=True, host='0.0.0.0', ssl_context='adhoc')