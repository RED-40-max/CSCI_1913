"""
Computer Lab 03: Weather 
Author: Roshinikitha Somasundram (worked alone)

Project Summery: taking weather data in the form of a CSV and calculating certain values from the data. 

Notes 
-------------------------------------------------
*  

"""

# Import Statements
import csv  # imported for DictReader
import math  # imported for
 


# provided functions -- one handles some tedious loading details, and the other can help make sure you know what you're
# working with -- it's worth reading both carefully, and trying to learn from what you're seeing.

# provided functions: 
def load(filename):
    """load the CSV file by name, return list of dictionaries, each dictionary describes one row. of the file"""
    reader = csv.DictReader(
        open(filename), dialect="excel", skipinitialspace=True
    )
    return list(reader)

def min_min_temp(file_list):
    """The input is a list of dictionaries like would be returned by the load function. The output is the minimum temperature
    observed in the dataset. We are tacitly assuming that the min temperature for a day is always below the max temperature
    """
    min_temp = math.inf
    for row in file_list:
        row_min_temp = float(row["Min_Temperature"])
        if row_min_temp < min_temp:
            min_temp = row_min_temp
    return min_temp

# Working functions: 
def F_to_C(f_temp): 
    """Converts the given temprature from Farenhint to Celcius 
      --> input is some value f_temp
      * convert to a float, then apply the equation to convert fahrenheit to Celcius
      --> output the calculated Celcius
    """

    C_temp  = 5*(float(f_temp) - 32)/ 9 #converts to strings, and applies eq
    return C_temp

def F_to_C_file(file_list): 
    """ Takes a file, and converts all the min and max temps to Celcuis 
    --> inputs a file, that is a list of dicts. 
    * finds Max_Temperature and Min_Temperature
    * calls the conversion function to convert 
    * sets a new value / modifys the list of dicts to contain C instead of F
    """

    for dict_row in file_list: # loop over all dicts in this file list 
        dict_row['Max_Temperature'] = F_to_C(dict_row['Max_Temperature'])
        dict_row['Min_Temperature'] = F_to_C(dict_row['Min_Temperature'])

    #returns nothing 

def clean(file_list, column): 
    """ Cleans the list based on bad values from a specified colum 
    --> inputs a list of dicts, and a string that indicates a key within the dicts
    * cycles thorught the dicts in the list 
        * for each dict, it sees if it contains a unclean variable 
        * removes the entire dict / row if it dose 
    --> outputs the modified list
    """
    
    Moded_list = [] #blank list 
    list_of_Unclean = ["T", "M", "S", "A","", " "] # a list of stuff we don't want

    for dict_row in file_list: #cycles thorught dict 

        value = dict_row.get(column, " ") #finds a perticular value in the specified column, otherwise defaults

        if not(value in list_of_Unclean): #if the value dosn't contain special val 
            Moded_list.append(dict_row) #add it 
    
    return Moded_list #return final list after iters

def average(file_list, column): 
    """ Takes the avrage of a column given a list of values 
    --> inputs a list of dicts and a string column that relates to some key w/in dict
    * cleans up the column 
    * loops thorught the list of dicts 
        * for each dict / row, takes the column value 
        * adds it to running sum 
    * at the end avrages it by dividing by the count 
    --> outputs a final avrage of that column
    """
    final_list = clean(file_list, column)

    if(len(final_list) == 0): # if list is empty 
        return 0.0

    running_sum = 0.0 # inital set up for summation - avg 
    running_count = 0.0  

    for dict_row in final_list: 
        running_sum += float(dict_row.get(column)) #adds the collumn to the sum 
        running_count += 1.0
    
    final_avg = running_sum / running_count

    return final_avg

def total_rain_by_year(file_list): 
    """ finds the total rain by the year given a list 
    --> inputs a list of dicts 
    * has a blank dict 
    * cleans the list, given preciptation (the amont of rain)
    * cycles throught the dicts in the lsit 
        * records the current year 
        * adds / has a running sum of the rain based on year in the dict we return 
    * returns the dict 
    """

    yr_rain_dict = {} #create a dict for the final output
    file_list = clean (file_list, "Precipitation")

    for dict_row in file_list: #iterates throught all the rows

        date_metric = dict_row["Date"] #finds the date of the row 
        current_year = int(date_metric[:4]) # finds the year of the row 

        if (current_year in yr_rain_dict): # if the date already is in it, add it to the metric
             yr_rain_dict[current_year] += float(dict_row["Precipitation"])#add it to that year 
        else: # otherwise create a new year, and add the preciptation to it 
             yr_rain_dict[current_year] = float(dict_row["Precipitation"])#add it to that year 


    return yr_rain_dict

