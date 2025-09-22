"""
Week 3: mutability

Write a python function called multiply_items 
    --> takes two arguments: a list and an integer n.
    --> The function should return a new list, with each item in the original list multiplied by n.


"""

def multiply_items(list_of, int_n): 
    
    final_list = []

    for x in range(len(list_of)): 
        final_list += [list_of[x]] * (int_n) 

    return final_list



#test functions 
if __name__ == '__main__': 
    things = ["apple", 3, 4.0]
    print(multiply_items(things, 3))
    assert multiply_items(things, 3) == ["apple", "apple", "apple", 3, 3, 3, 4.0, 4.0, 4.0]

    print("test passed")