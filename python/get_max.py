"""
week 4: algorithums 
    find largest value in an unsorted collection

"""
import math

def get_max(*values):
  current_max = None
  for v in values:
    if current_max == None or v > current_max:
      current_max = v
  return current_max

if __name__ == "__main__":
  assert get_max(2, 0, -100, 100, 0, 2) == 100
  assert get_max(2, 0, math.inf, 100, 0, 2) == math.inf