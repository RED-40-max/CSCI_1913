"""
week 2: python loops 

Write a python function called factorial that uses a loop 
    --> calculate factorial of a non-negative integer n (n!)
        --> A factorial is the product of a given positive integer 
        --> and all the positive integers smaller than it down to 1:
            5!=5*4*3*2*1=120

    --> The factorial of 0 (0!) is defined as 1.

"""

def factorial(n): 

    factorial_total = 1

    while( n > 0): 
        factorial_total *= n 
        n -= 1

    return factorial_total


if __name__ == '__main__':
    assert factorial(0) == 1
    assert factorial(5) == 120
    assert factorial(7) == 5040

