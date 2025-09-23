'''
Authors: Peter Wang and Daniel Kluver
Modified by: Adriana Picoral in Fall 2025
'''
from collections import OrderedDict
from weather import load, F_to_C, F_to_C_file, clean, average, total_rain_by_year

if __name__ == "__main__":

    print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

    print("Testing F_to_C function")
    assert F_to_C(float("inf")) == float("inf")
    assert F_to_C(-float("inf")) == float("-inf")
    assert F_to_C(123899652354) == 68833140178.88889
    assert F_to_C(-898989785423) == -499438769697.2222
    assert F_to_C(0) == -17.77777777777778
    assert F_to_C(32) == 0.0
    print("F_to_C completed")
    print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

    # load testing files
    test_file_list = load("CompLab03/test_file.csv")
    messy_file_list = load("CompLab03/messy_file.csv")
    longer_file_list = load("CompLab03/longer_test_file.csv")

    print("Testing F_to_C_file function")
    F_to_C_file(test_file_list)
    assert test_file_list[0]["Max_Temperature"] == -14.444444444444445
    assert test_file_list[0]["Min_Temperature"] == -22.77777777777778
    print("F_to_C_file completed")
    print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")


    print("Testing clean function")
    
    assert clean(messy_file_list, "Min_Temperature") == []
    assert clean(messy_file_list, "Snow") == []
    assert clean(messy_file_list, "Precipitation") == []
    print(len(clean(messy_file_list, "Snow_Depth")))
    assert len(clean(messy_file_list, "Snow_Depth")) == 1
    assert len(clean(messy_file_list, "Max_Temperature")) == 1


    print("clean completed")
    print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

    print("Testing average function")
    result = average(test_file_list, "Snow") 
    assert type(result) == float
    assert result ==  0.0

    assert average(messy_file_list, "Snow") ==  0.0
    assert average(messy_file_list, "Snow_Depth") ==  9.0

    print(average(longer_file_list, "Snow_Depth"))
    assert average(longer_file_list, "Snow_Depth") == 9.799999999999999

    print("average completed")
    print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~")

    test_file_list = load("CompLab03/test_file.csv")
    print(total_rain_by_year(test_file_list))
    assert total_rain_by_year(test_file_list) ==  {2010: 8.5}

    longer_file_list = load("CompLab03/longer_test_file.csv")
    assert total_rain_by_year(longer_file_list) == {2010: 0.04, 2012: 0.09, 2013: 0.11}

    print("Testing total_rain_by_year function")

