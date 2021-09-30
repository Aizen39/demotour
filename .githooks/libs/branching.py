"""
Provide analytic tool to inspect branch name :

- Define a PATTERN which reflect Git-Flow conception.
- Retrieve the current branch name and validate it matchs the defined PATTERN.
"""

import re
from subprocess import Popen, PIPE

PATTERN = r"^(feature|bugfix|release|hotfix)\/[a-z0-9._-]+$"
REGEX = re.compile(PATTERN)

def git(args):
    """
    Call 'git' command as a subprocess.

    Intercept and decode the ouput.
    Return a strip string `utf-8` encoded.

    :param args: command line arguments
    :type args: str
    :return: standard ouput of the command
    :rtype: str
    """
    args = ['git'] + args
    cmd = Popen(args, stdout=PIPE)
    out = cmd.stdout.read()
    out = out.decode('utf-8', 'replace').strip()
    return out

def git_branch():
    """
    Get the name of the git current branch.

    Use :func:`~git`

    :return: git branch name
    :rtype: str
    """
    return git(['rev-parse', '--abbrev-ref', 'HEAD'])

def validate(branch):
    """
    :param branch: branch name
    :type branch: str
    :return: match pattern
    """
    return REGEX.match(branch)
