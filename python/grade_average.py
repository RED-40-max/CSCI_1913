"""
week 3: Nesting 
Write a Python function called calculate_class_average 
    --> takes in as argume a nested list representing student grades.
    --> return the average grade across all students in the class 
            (rounded to 2 decimal places).

"""

def calculate_class_average(gradebook): 
    
    running_avg = 0

    for y_axis in range(len(gradebook)): 
        running_sum = 0 

        for x_axis in range(len(gradebook[y_axis])): 

            running_sum += gradebook[y_axis][x_axis]

        running_avg += (running_sum / len(gradebook[y_axis])) 
    
    return round(running_avg /len(gradebook) , 2)


if __name__ == '__main__': 
    gradebook = [
    [85, 92, 78, 90], # Student 1's grades
    [88, 76, 95, 82], # Student 2's grades  
    [90, 87, 93, 89], # Student 3's grades
    [72, 68, 84, 79]  # Student 4's grades
    ]
    assert calculate_class_average(gradebook) == 84.25
    print(calculate_class_average(gradebook))
    print("all test passed")