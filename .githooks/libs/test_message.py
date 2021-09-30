"""
Commit message format checks unit tests
"""

from libs.message import check_rules
from libs.message import MISSING_SUBJECT, LIMIT_SUBJECT_50
from libs.message import NO_PERIOD_END_OF_SUBJECT, CAPITALIZE_SUBJECT
from libs.message import SEPARATE_SUBJECT_BODY, WRAP_BODY_72

def test_missing_subject():
    """Test MISSING_SUBJECT"""
    msg = ''
    error = check_rules(0, msg, 1)
    assert error == MISSING_SUBJECT

def test_limit_subject_50():
    """Test LIMIT_SUBJECT_50"""
    msg = 'MessageMessageMessageMessageMessageMessageMessageMessage'
    error = check_rules(0, msg, 1)
    assert error == LIMIT_SUBJECT_50

def test_no_period_end_of_subject():
    """Test NO_PERIOD_END_OF_SUBJECT"""
    msg = 'Message.'
    error = check_rules(0, msg, 1)
    assert error == NO_PERIOD_END_OF_SUBJECT

def test_capitalize_subject():
    """Test CAPITALIZE_SUBJECT"""
    msg = 'message'
    error = check_rules(0, msg, 1)
    assert error == CAPITALIZE_SUBJECT

def test_separate_subject_body():
    """Test SEPARATE_SUBJECT_BODY"""
    msg = """Subject
    Body
    """
    error = check_rules(1, msg, 2)
    assert error == SEPARATE_SUBJECT_BODY

def test_wrap_body_72():
    """Test WRAP_BODY_72"""
    msg = """Subject

    MessageMessageMessageMessageMessageMessageMessageMessageMessageMessageMessage
    """
    error = check_rules(2, msg, 3)
    assert error == WRAP_BODY_72
