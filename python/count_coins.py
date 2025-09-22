"""
week 3: Dictonaries 

Write a function count_coins(coins) 
    --> counts U.S. coins in a list 
    --> returns a dictionary mapping coin names to 
    the number of times they appear in the list of integers 
    representing coin values (in cents). 
    --> If no coins is represented in the argument list, its count should be zero.

The dictionary should use coin names, not values:

1 → pennies
5 → nickels
10 → dimes
25 → quarters

"""

def count_coins(coins): 

    pennies_count = 0 
    nickels_count = 0 
    dimes_count = 0 
    quarters_count = 0 
    final_coint_count = {}

    for x in coins: 

        if (x == 1): 
            pennies_count += 1 
        elif (x == 5): 
            nickels_count += 1
        elif(x == 10): 
            dimes_count += 1 
        elif(x == 25): 
            quarters_count += 1 
    
    final_coint_count["pennies"] = pennies_count
    final_coint_count["nickels"] = nickels_count
    final_coint_count["dimes"] = dimes_count
    final_coint_count["quarters"] = quarters_count
    
    #final_coint_count = {'pennies': pennies_count, "nickels": nickels_count, "dimes": dimes_count, "quarters": quarters_count}

    return (final_coint_count)

if __name__ == '__main__': 
    coins = [1, 25, 1, 25, 1, 10, 5]  
    counted_coins = count_coins(coins) 
    print(counted_coins)
    assert counted_coins == {"pennies": 3, "quarters": 2,"dimes": 1, "nickels": 1}
