"""
Week 4: searching 
    Implement binary search in python. 
    Write a function called binary_search that takes in two arguments: 
        --> a sorted list (increasing values)
        -->  a search value.
"""



    
 


if __name__ == "__main__":
  numbers = [0, 5, 10, 23, 41, 43, 44, 60, 99, 120, 343]
  assert binary_search(numbers, 99) == 8
  assert binary_search(numbers, 9) == -1

