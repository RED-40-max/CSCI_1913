"""
week 3: mutiaplity 

Write a python function called lowercase_list that 
    --> gets as argument a list of strings
    --> modifies the list by lowercasing each item in the list. 

You can use the string method .lower().


"""


def lowercase_list(list_of_strings): 

    for x in range(len(list_of_strings)):
        list_of_strings[x] = list_of_strings[x].lower()
    
    return list_of_strings



#test cases 
if __name__ == '__main__': 
    fruit = ["APPLE", "BANANA", "PEAR"]
    lowercase_list(fruit)
    assert fruit == ["apple", "banana", "pear"]
    print("test sucessful")