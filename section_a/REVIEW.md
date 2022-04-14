## Code Review

---

### Code review for Python Task (Option 1)

---

#### Correctness:
* The logic used in the code is sound enough to accomplish the task objective. But the
code is not functional, that is, it throws an error. Please refer to the stack trace
for the error and debug your program. More specifically, pay attention to line 5 of
your code.

#### Efficiency:
* The use of a class was not necessary for this task, the simple use of a function
was good enough to complete the task. The use of a dictionary in line 3 proves quite
efficient for grouping the anagrams together and so is the use of the sorted string
as a key on line 5 for every list item.

#### Style:
* The lack of proper indentation goes against the python's syntax and language rules.
Properly indent the code so that it will follow the rules. Line two needs to be
backwards indented while lines 3-10 need to be forward indented. For more on the Python
language coding style: [Python Code Style](https://docs.python-guide.org/writing/style/)

#### Documentation:
* Your code is not documented, so it makes harder for anyone to understand what your
code is doing without having to go through it line by line. The use of comments
and/or docstrings simplifies code readability thus resulting in a clean and readable
code. For more information about documenting your code:
[Python Docstrings and comments](https://pythonsimplified.com/python-docstrings-and-its-importance/)

The overall code has sound logic and its efficient in accomplishing its objective, but
there's still room for improvement in terms of the code style and documentation. Great
job nonetheless.