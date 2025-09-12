"""
Week 2: Python Lists 
    + write a python function that given a string 
    returns two lists 
        --> one with all the vowels
        --> another will all consonents 
    --> the Case must stay the same when extracted

"""


def vowels_consonants(string_in_q): 
    # compare list
    V_comp_list = ["a","e","i","o","u","A","E","I","O","U",]

    # to expand
    V_list = [] # vowels list
    C_list = [] #Concenet list 


    for char in string_in_q: 

        if char in V_comp_list: # if you find a char that matches one on the list
            V_list.append(char) # add it to the vowles
        else: 
            C_list.append(char) #otherwise it's a concenant

    return (V_list, C_list)



if __name__ == "__main__":
    assert vowels_consonants("") == ([], [])
    assert vowels_consonants("aeaAR") == (["a", "e", "a", "A"], ["R"])
    assert vowels_consonants("abcd") == (["a"], ["b", "c", "d"])

    print("Passed all tests")