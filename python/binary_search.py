"""
Week 4: searching 
    Implement binary search in python. 
    Write a function called binary_search that takes in two arguments: 
        --> a sorted list (increasing values)
        -->  a search value.
"""



def recursive_binary_search(lst, target, high, low):
  mid = (low+high)//2
  
  if lst[mid] == target:
    return mid
  
  if low > high:
    return -1
  
  if target < lst[mid]:
    return recursive_binary_search(lst, target, mid-1, low)
  
  if target > lst[mid]:
    return recursive_binary_search(lst, target, high, mid+2)
 


if __name__ == "__main__":
  numbers = [0, 5, 10, 23, 41, 43, 44, 60, 99, 120, 343]
  assert binary_search(numbers, 99) == 8
  assert binary_search(numbers, 9) == -1

