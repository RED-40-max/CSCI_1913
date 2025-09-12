"""
week 2: python loops 

Write a python function called hex_to_rgb 
    --> gets as argument a hex code in the string format "#F54927" 
    --> returns the equivalent RGB code in a tuple of integers format (245, 73, 39)

Hint: The base of a hexadecimal system is 16, 
we want to convert a two digit hex code to decimal integer. 
    For example
        you can convert "CF" to python using the int() built-in function 
            --> like so int("CF", 16)

Submit your solution colors.py to the in-class exercise in gradescope.

"""

def hex_to_rgb(Op_num): 


    #F54927
    First_n = Op_num[1:3] #(F5)4927
    Second_n = Op_num[3:5] #F5(49)27
    Third_n = Op_num[5:] #F549(27)

    First_n = int(First_n, 16)
    Second_n = int(Second_n, 16)
    Third_n = int(Third_n, 16)

    fin_rgb_set = (First_n, Second_n, Third_n)

    return fin_rgb_set

if __name__ == "__main__":
    assert hex_to_rgb("#F54927") == (245, 73, 39)
    assert hex_to_rgb("#000000") == (0, 0, 0)
    assert hex_to_rgb("#FFFFFF") == (255, 255, 255)
    assert hex_to_rgb("#70B578") == (112, 181, 120)

    print("Passed all tests")
