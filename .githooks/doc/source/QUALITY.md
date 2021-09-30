Tests
-----

**Requirements**

`pip install pytest pytest-coverage coverage`

Run the tests of th coverage

`pytest --cov=libs --cov-report html libs/*.py`

Analysis
--------

**Requirements**

`pip install pylint`

Run the analysis

`pylint pre-commit commit-msg libs`
