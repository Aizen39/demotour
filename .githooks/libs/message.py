"""
Look for format errors in a commit line.

Each string literral below reflect both the rule and the format error message.
The single function :func:`~check_rules`

"""

MISSING_SUBJECT="Missing subject"
LIMIT_SUBJECT_50 = "Limit the subject line to 50 characters"
SEPARATE_SUBJECT_BODY = "Separate subject from body with a blank line"
WRAP_BODY_72 = "Wrap the body at 72 characters"
NO_PERIOD_END_OF_SUBJECT = "Do not end the subject line with a period"
CAPITALIZE_SUBJECT = "Capitalize the subject line"

def check_rules(lineno, line, num_lines):
    """
    Inspect the format of a commit message line.



    :param lineno: number line
    :type lineno: int
    :param line: line content
    :type lineno: str
    :param num_lines: number of lines in the file
    :type lineno: int
    :return: error message or False
    """
    if lineno == 0:
        if not line:
            return MISSING_SUBJECT
        if len(line) > 50:
            return LIMIT_SUBJECT_50
        if line and not line[0].isupper() :
            return CAPITALIZE_SUBJECT
        if len(line) - 1 == line.rfind('.'):
            return NO_PERIOD_END_OF_SUBJECT
    if num_lines > 1:
        if lineno == 1:
            if line:
                return SEPARATE_SUBJECT_BODY
        if not line.startswith('#'):
            if len(line) > 72:
                return WRAP_BODY_72
    return False
