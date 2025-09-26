"""
week 4: searching 

linear search 
Call your function linear_search, it should take a list and a value.
It returns the index of the value, if value is in list, otherwise it returns -1.

"""

def linear_search(List, search_val): 

    for x_axis in range(len(List)): 

        if List[x_axis] == search_val: 
            return x_axis
    
    return -1 

if __name__ == "__main__":
  numbers = [0, 5, 10, 23, 41, 43, 44, 60, 99, 120, 343]
  assert binary_search(numbers, 99) == 8
  assert binary_search(numbers, 9) == -1