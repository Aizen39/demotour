"""Branching unit tests"""

from libs.branching import validate

def test_validate_feature():
    """Test validate feature/_"""
    assert validate('feature/_')

def test_not_validate_feature_special_char():
    """Test not validate feature/*$"""
    assert not validate('feature/*$')

def test_not_validate_develop():
    """Test not validate develop"""
    assert not validate('develop')

def test_not_validate_master():
    """Test not validate master"""
    assert not validate('master')
