"""
week 4: sets 

Your commonality() function 
--> takes any number (use * before parameter name) of lists
--> returns a single set containing the animals that were found in all of the lists provided. 

Submit your commonality.py solution to gradescope.

"""

def commonality(*lists) -> set: 

    if len(lists) == 0: 
        return set() 

    final_set = set(lists[0])

    for x in range(1, len(lists)): 
        set_x = set(lists[x])
        final_set = final_set.intersection(set_x)

    return final_set


if __name__ == '__main__': 
    dense_forest = ["howler monkey", "sloth", "chipmunk", "toucan", "leafcutter ant", "sloth", "tarantula", "pit viper"]
    cave = ["pit viper", "bat", "leafcutter ant", "pit viper", "tarantula", "tadpole"]
    volcano = ["tarantula", "parrot", "pit viper", "leafcutter ant", "tarantula", "grasshopper"]

    common_animals = commonality(dense_forest, cave, volcano)
    print(common_animals)
    assert common_animals == {'leafcutter ant', 'tarantula', 'pit viper'}
