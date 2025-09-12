"""
week 2: python loops 

Write a python function that determines whether a whole number greater than one is prime. 
    --> A prime is divisible only by itself and 1 (not a product of two smaller natural numbers). 
    --> Test the remainder of the division with all primes up to the square root of the argument n.

"""


def is_prime(op_num): 

    Is_really_prime = true # assumes it is prime at first 
    sq_of_n = (op_num ** (0.5)) 
    counter_no = 2

    while (counter_no < sq_of_n): 
        divi_n = op_num /sq_of_n

        if (divi_n % 1 > 1): 


        counter_no += 1


    return 