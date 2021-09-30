Shared hooks
------------

The `.git/` directory, is not part of the sources in the version control system
because it contains platform and user specific elements.
The solution is to create a versioned directory, for example `.githooks/`,
to shared the hook scripts and configure `git` so that folder is the new folder hook :

`$ git config core.hooksPath .githooks`

That's it !

Portability
-----------

Hooks might be written in all language.
Instead of `Bash` and any shell script language, best choice is indeed a portable language.
File hooks must have a script free-language form without extensions : like `pre-commit` and not `pre-commit.py`.

The `Python` documentation for Windows systems includes a section about the well known *Shebang lines* on Unix-like systems :
https://docs.python.org/3/using/windows.html#shebang-lines.

`#! /usr/bin/python`

`#! /usr/bin/env python`

The best choice is the second option which allows also virtual environments usage.
