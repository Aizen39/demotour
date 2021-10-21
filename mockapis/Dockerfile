FROM python:3.8-slim-buster

RUN pip install --upgrade pip

COPY . .

RUN pip install -r requirements.txt

ENV MOCK_CONFIG=default

CMD [ "./api.py"]

