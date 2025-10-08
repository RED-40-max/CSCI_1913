"""
Computer Lab 04: The Pricebook
Author: Roshinikitha Somasundram (worked alone)

Project Summery: various functions that take in a pricebook to then do various operations on 
sorted and unsorted pricebooks to find, update, and calculate certain values. 
"""

def is_sorted(pricebook): 
    """ Checks if the pricebook is sorted by name (index 1) 
        --> inputs a list of tuples 
        * checks if list is empty 
            --> if so return True 
        * checks if in order 
        --> outputs a booleean result
    """
    if not(pricebook): #if the list is empty, we assume it's sorted
        return True 
    
    for index_y in range(len(pricebook) - 1): 

        if (pricebook[index_y][1] > pricebook[index_y + 1][1]): #if at any point in the list, a smaller value is before a larger value, 
            #it is not sorted
            return False 

    return True 

def price_average(pricebook): 
    """ Averages the prices within the book 
        --> inputs a list of tuples 
        * checks if list is empty 
            --> returns an avg of 0 if it is
        * reads each price and adds to the running sum 
        --> outputs a calculated avrage (sum / number of numbers added)
    """

    if not(pricebook): 
        return 0.0 

    running_sum = 0 
    
    for index_y in range(len(pricebook)): 
        running_sum += pricebook[index_y][0]

    return (running_sum / len(pricebook))

def unsorted_get(pricebook, name): 
    """Finds a price in a pricebook based on given name
    --> inputs a list of tuples and a string (corrosponds to a inumbernt)
    * runs thorught each value to see if it contaings the name 
        --> outputs the price if so
    * 
    """

    for index_y in range(len(pricebook)): #linear search

        if (pricebook[index_y][1] == name): 
            return pricebook[index_y][0]

    #if no product is found 
    return None 

def unsorted_put(pricebook, name, price): 
    """ Places or replaces a price based on the name in a pricebook 
    --> reads in a list of tuples, a string and a number 
    * searches to see if there is already name in pricebook 
        * if so records the index 
    * if no name, add it to the end of the pricebook 
    *if there is a name, update the entire tuple 
    """

    index_of_price = len(pricebook) + 5 #sets as an impossible index 

    for index_y in range(len(pricebook)): #linear search

        if (pricebook[index_y][1] == name): 
            index_of_price = index_y

    if(index_of_price == len(pricebook) + 5 ): #if impossible index still is there, the value dosn't exist
        pricebook += ((price, name),) #this way to insert tuples into list, 
        #if you do it without the comma, it will just add two values and not a tuple
    else: 
        pricebook[index_y] = (price, name) 

def sorted_get(pricebook, name): 
    """ Get a price, given a sorted pricebook and a name 
    must have a O(n log n) --> use Binary search 
    --> input a sorted list of tuples (sorted by name), and a name 
    * search for it 
        --> when you get to the value, return it 
    * otherwise update the loop based on the comparions 
    * return none if you don't find anything else 
    """
    high_val = len(pricebook) 
    low_val = 0 

    while high_val > low_val: #binary search

        middle = (high_val + low_val) // 2 

        if (pricebook[middle][1] < name): #bigger than mid val
            low_val = middle + 1
            
        elif (name < pricebook[middle][1]): #smaller then mid val 
            high_val = middle 

        else: #middle is the index of name / equal to mid val 

            return pricebook[middle][0]

    return None #otherwise it's a lost cause 

def sorted_put(pricebook, name, price):
    """ Places / Replaces a price, name pair given a sorted pricebook    

        --> inputs a list of tuples, and a (price, name) pair 

        * runs thorught the list 
            * if the current object is lower then the name, record it 
            * at the end, we get the index that is the highest number below our input value

        * at the end, we check if the list contained the value already
            * (if not) use recorded index is the value 
            * get the HIGHEST NUMBER BELOW OUR INPUT VALUE 
                * importent to get,  easy to find, hard figure process out
            * the i where we would do .insert(i + 1, x) to put in place

        --> return the updated pricebook         
    """ 
    #assume that the index is 0 initally 
    lower_val_index = 0 #we find the value of the index that is just below our desired value  

    for index_y in range(len(pricebook)): 
        #0 index case --> if the name should be at the first
        if (pricebook[0][1] > name): 
            pricebook.insert(0, (price, name)) 
            return 
        # if it is below --> ongoing function
        elif(pricebook[index_y][1] < name): 
            lower_val_index = index_y #records the last lowest value 
        #otherwise it is equal case 
        elif (pricebook[index_y][1] == name): 
            #update it 
            pricebook[index_y] =  (price, name)
            lower_val_index = None #make sure you reset it after you update it 
            return pricebook
        # if it is above, don't do anything, it will just go to the end
    
    if not(lower_val_index == None): 
        #insert the value into the proper place 
        pricebook.insert(lower_val_index + 1, (price, name))


"""
if __name__ == '__main__': 

#is_sorted
    L1 = [(5, "appl"), (7, "ban"), (10, "car")]
    L2 = [(5, "ban"), (3, "appl")]
    print("is_sorted(L1):", is_sorted(pb1))  # True
    print("is_sorted(L2):", is_sorted(pb2))  # False

#unsorted_get 
    L5 = [(20, "pear"), (8, "appl"), (13, "ban")]
    print(f"unsorted_get(L5, 'appl'):", unsorted_get(L5, "appl"))  # 8
    print("unsorted_get(L5, 'ma'):", unsorted_get(L5, "mango"))  # None

#sorted_get
    L6 = 

#test sorted_out 
    L7 = [(3, "apple"), (6, "B"), (12, "P")]
    print("sorted_put(L6, 'B', 9):", sorted_put(L6, "B", 9))  
    print("sorted_put(L6, 'C', 8):", sorted_put(L6, "C", 8))  
    print("sorted_put(L6, 'A', 2):", sorted_put(L6, "A", 2)) 
"""

"""

Notes: (delete before submission)
-------------
    --> use less comments inline code: they should only explain chuncks of code  
    --> loop names are descriptive or x/i 
    --> minimal blank space 

* [1,2,4,5,6]
    val = 3

if(lower > val)
    lower = loop_val 

after loop: 
    lower = 2 
        use lower, since it will end at a predictable place (the greatest value that is under the val)
    uppper = 6 

"""

