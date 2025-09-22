"""
week 2: python loops 

Write a python function that determines whether a whole number greater than one is prime. 
    --> A prime is divisible only by itself and 1 (not a product of two smaller natural numbers). 
    --> Test the remainder of the division with all primes up to the square root of the argument n.

"""

def is_prime(op_num): 

    counter_no = 2

    while (counter_no < op_num): 

        if (op_num % counter_no == 0 ): 
            return False

        counter_no += 1

    return True

if __name__ == "__main__":
    assert is_prime(2) == True
    assert is_prime(4) == False
    assert is_prime(29) == True
    assert is_prime(53) == True
    assert is_prime(54) == False

    print("Passed all tests")