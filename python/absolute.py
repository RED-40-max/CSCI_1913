"""
Week 2: More Python 

Write a Python function called absolute that takes one numeric argument (integer or float) n
- returns the absolute value of n: if n is positive, it results n, 
- if n is negative, it returns n * -1
"""

def absolute(n): 
    if (n > 0): 
        return n 
    else:
        return (n * -1)
