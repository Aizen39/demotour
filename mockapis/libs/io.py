'''IO module read/write content of a file'''

from json import load, dump

def read(filename):
    """
    :param filename: Input file
    :type filename: str
    :return: JSON file
    :rtype: dict
    """
    with open(filename) as file:
        return load(file)

def write(filename, data):
    """
    :param filename: Ouput file
    :type filename: str
    :param data: JSON file
    :type data: dict
    """
    with open(filename, 'w') as file:
        dump(data, file)

def cprint(color, out):
    """
    :param color: Ascii format color
    :type color: str
    :param output: content to print
    :type output: str
    """
    print('{}{}\33[0m'.format(color, out))

class Colors:
    END = '\33[0m'
    BOLD = '\33[1m'
    BLINK = '\33[5m'
    GREEN = '\33[32m'
    RED = '\33[31m'
    GREY = '\33[38;5;242m'
    BG_GREEN =  '\33[7;49;32m'
