"""
Computer Lab 03: The game of Nim
Author: Roshinikitha Somasundram (worked alone)

Project Summery:

Notes 
-------------------------------------------------

* the 'y - axis' and the 'x - axis' of the board as such: 

    y-axis 
        |
        |   1 ####
        |   2 ###
        |   3
        |   4 #
        ----------------x axis

    * as thought the board was charted onto a graph. 
        * the Y-axis is the 'size of the board' 
        * the x is the decedning / amount of tokens 

 
* anotating functions 
    \""" - summery function on first line 
    --> (I/O of function)
    * process / calculation 

"""



def create_game_state(size, token_max): 
    """ Creates a size x size board and populates with tokens 
            --> inputs integers: a size, and token_max 
            * makes a board of size x size 
            * populates board with tokens based on y_axis 
                * Y_axis[1] = 1 
                * Y_axis[2] = 2
                ... 
                * Y_axis[n] = n 
                * Y_axis[n + 1] = n 
                ... 
            -> returns the populated board 
    """
    game_board = [] #creates empty list 

    for y_axis in range(size): # first loop - initalizes the y axis 

            if(y_axis >= token_max): #if the amount of token is more or equal to token max
                game_board.append(token_max)
            else: # otherwise, it's still counting to that number
                game_board.append(y_axis + 1) 

    return game_board

def is_valid_move(game_state, row, takes): 
    """ Checks if the move is allowed per the rules and constraints of Nim 
        --> inputs a list, and two strings - row and takes
        * if row and takes are digits 
        * if takes is (1,2 or 3)
        * if row is a valid row within the board 
        * if there are enought tokens within the specified row 
        --> outputs boolean (if it is or isn't a valid move)
    """

    #checks if the inputs are digits  
    if not(row.isdigit() and takes.isdigit()):
        return False 

    #initalizes and converts vars. 
    row = int(row) - 1 
    takes = int(takes)

    # checks row
    if ((row >= len(game_state)) or (row < 0)):  
        return False 
        
    #checks takes 
    if not((0 < takes) and (takes <= 3)): #1,2 or 3 will pass to true
        return False
    
    if (takes > game_state[row]): # if can take token from that row
        return False

    return True # if pass all checks

def update(game_state, row, takes): 
    """ Updates board based on the turn metrics 
        --> inputs list / game board, two ints - row and takes
            * copies down board 
            * takes away tokens from specified row 
        --> outputs the board 
    """
    final_game_state = game_state.copy() # copies this down 
    final_game_state[row ] -= takes #updates that row 
    return final_game_state

def draw_game_state(game_state):
    """ Prints out the board given the list 
        --> input is the list containing tokens and index as rows 
        --> output is the board and corosponding y cordinants
    """
    print('====================')

    for y_axis in range(len(game_state)): 
        print(f"{y_axis + 1} ", end="") # prints numbers 

        for x_axis in range(game_state[y_axis]): #prints for each 
            print(f"#", end="") 

        print() # return after each row is done

    print('====================')

def is_over(game_state): 
    """ Determines the game is over by reading the board 
        --> input is the list game board
            * checks if any row has any tokens
            * if there is any tokens at all, it isn't over 
        --> returns boolean 
    """

    for y_axis in range(len(game_state)): 

        if game_state[y_axis] != 0: # if a value isn't empty 
            return False # it's not over 

    return True  #otherwise it is over since no more tokens 
