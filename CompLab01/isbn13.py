"""
Computer Lab 01: ISBN 13
Author: Roshinikitha Somasundram (worked alone)
Project Summery: checks if an ISBN input is valid 
and Computes a complete ISBN given an input. 

Notes 
-------------------------------------------------
* ISBN check (positions 1..n, L-to-R):
    sumodd  = sum(digit at positions 1, 3, 5 ect)
        even indexs (0, 2, 4)
    sumeven = sum(digit at positions 2, 4, 6, ect)
        odd indexes (1, 3, 5)

    total = sumodd + (sumeven * 3) 

    Valid iff total % 10 == 0

* ISBN make 
    * calculate the digits, if there was one space left at the end 
    * brute-force 0..9 and check if it is true, untill it gets true out

"""
 

def check_isbn13(isbn): 
    """ Checks if a int is valid ISBN-13, returns true if it's valid, and false if it's not
        - takes integer type 
        - returns boolean 
        - uses total = sumodd + (sumeven * 3) 
        - if total is dividable by 10, returns true, otherwise false. 
        - reject if 
            -> negetive input 
            -> an input with >13 digits
    """

    # inital variables 
    sumodd = 0
    sumeven = 0
    str_isbn = str(isbn) #conversion to string
    Length_of_isbn = len(str_isbn) # length of ISBN
    digits_done = 1 # what position digit we are at 

    #inital rejection
    if (isbn < 0): #if is negetive
        return False 
    elif (Length_of_isbn > 13): # if is over 13
        return False

    #cycling thorugh all the digits in the ISBN
    while(Length_of_isbn >= digits_done):

        #adds digit to sumodd or sumeven  
        if (digits_done % 2 ==0): 
            sumeven += int(str_isbn[digits_done - 1]) 
        else: 
            sumodd += int(str_isbn[digits_done - 1])

        digits_done += 1 # moves up a digit from the left

    total = sumodd + (sumeven * 3)  #calculates the ISBN checking total 
    
    #final return function
    if (total % 10 == 0): # if the total is divisiable by 10, 
        return True
    else: 
        return False


def make_isbn13(number): 
    """
    add a digit at the end of the input to make  a valid isbn 13 
        - takes int input 
        - returns a number 
        - loops i throught numbers 0 - 9 
            -> calls check_isbn13(number * 10) + i 
                * what this dose, is it takes the number, and moves 
                each digit up one place (leaving room at the end for a 0)
                * then it adds i to the end and checks if this number is valid 
                * loops thorught all numbers untill it gets to something it likes / is true 
    
    """

    if (len(str(number)) >= 13): # if it is 13 digits or more, invalid input
        return -1 
    elif (number < 0): # otherwise if it is negetive number, also invalid input 
        return -1

    # calling with (number * 10) becuse when we add the number at the end to make it an isbn, 
    # all the other numbers will shift over one digit 
    # add i at the end to check number 0-9 / just replace the last number 

    # brute force tactic 
    for i in range (10): 
        Is_valid = check_isbn13((number *10 + i))
        
        # if it ends up being valid
        if (Is_valid):  
            return (number *10 +  i) #return that number 

#test functions 
if __name__ == "__main__":
    assert check_isbn13(9783161484100) == True
    assert check_isbn13(9783361484100) == False
    assert check_isbn13(1134685992) == False
    assert check_isbn13(9780321356680) == True
    assert check_isbn13(97802016162241) == False
    assert make_isbn13(978013468599) == 9780134685991
    assert make_isbn13(978149204034) == 9781492040347
    assert make_isbn13(0) == 0
    assert make_isbn13(4) == 42
    print("Passed all tests")
