"""
week 3: practice 

a basic number guessing game for I/O testing  

"""
import random 

min = 1 
max = 100 
sec = random.randint(min, max)

def randome_maker():

    guess = False
    while(guess != True): 

        input = True 

        while (input == True): 
            user_input = input("yo: ")

            if not(user_input.Isdigit): 
                print("Invalid input, try again")
                input = False
            else: 
                input = True 
                break 

        user_input = int(user_input)

        if user_input == sec: 
            print("correct")
            guess = True 
            break
        elif user_input > sec: 
            print("smaller")
        else: 
            print("larger")

if __name__ == '__main__': 
    randome_maker() 
    print("ran well")

