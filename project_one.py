"""
Project 1: Kōnane (Hawaiian Checkers)
Author: Roshinikitha Somasundram 

Project summery: 

Notes 
-------------------------------------------------
* x_axis + y_axis 
    again, this is what i mean when i refer to something as 
    y_axis, or x_axis. 

    y_axis      
            |    [1, 2, 1, 2, 1, 2]
            |    [2, 1, 2, 1, 2, 1]
            |    [1, 2, 1, 2, 1, 2]
            |    [2, 1, 2, 1, 2, 1]
            |    [1, 2, 1, 2, 1, 2]
            |    [2, 1, 2, 1, 2, 1]
            ----------------------------- x_axis

* my editor (VS code) has a black background, so the tokens will be refered to as: 
    empty token --> u25CB (white)
        (on my screen this shows up as a black token)
    filled token --> u25CF (black)
        (on my screen this shows up as a white token)
    blank space --> nothing is there / no white or black 

* 

"""

#W1
def generate_board(an_int): 
    """ Creates a int square board with checkerbord values 
        --> takes an int input 
        * creates a nested list of int x int 
        * sets alternating tokens for each nested list 
        --> returns the final board 
    """

    final_board = [] # mass / y_axis access

    if (an_int <= 0): # if the user inputs a value >= 0, return empty list
        return final_board

    #y_axis control
    for y_axis in range(an_int): 
        inner_board = [] # x_axis acesss, resests each time

        if ((y_axis % 2 == 0) or (y_axis == 0)): # if it is an even or 0, start w/ 1
            previous_val = 1 
            inner_board.append(previous_val)
        else: #otherwise it's odd so start with 2 
            previous_val = 2 
            inner_board.append(previous_val)

        #x_axis control 
        for x_axis in range(an_int -1 ): 

            if (previous_val == 1): #if it starts with 1 
                inner_board.append(2) #if the last one was 1, add 2
                previous_val = 2 #change the value for the next iter
            elif (previous_val == 2): 
                inner_board.append(1) 
                previous_val = 1

        final_board.append(inner_board) #at the end of the inner row, enter it to y_axis row

    return final_board

def get_board_as_string(board): 
    """ Prints the board given the input
        --> input is the board as a nested list 
        * prints the colum number 
        * prints row number + token 
        * prints seperation bars 
        --> overall, outputs a formatted / cleaned board w/ row + column numbers
    """

    #prints the x_axis on top 
    print("   ", end = "")

    for y_axis in range(len(board)): 
        print(f"{y_axis} ", end = "") # prints column no.

    print("")
    
    #prints the rows 
    for y_axis in range(len(board)): 

        #prints seperation bar
        print("  +", end ="")

        for x_axis in range(len(board)): 
            print("-+", end = "")
        print("")

        #prints row no. + tokens
        print(f"{y_axis} |", end = "") # prints row no.
    
        for x_axis in range(len(board[y_axis])): 
            symbol_of_token = " "

            if (board[y_axis][x_axis] == 1): #blank token 
                symbol_of_token = "\u25CB" # to use unicode in python, use escape sequence
            elif (board[y_axis][x_axis] == 2): #a filled token 
                symbol_of_token = "\u25CF"

            print(f"{symbol_of_token}|", end = "")
        print("")

    #prints last row's sepreation bar
    print("  +", end ="")

    for x_axis in range(len(board)): #prints seperation row
        print("-+", end = "")
    print("")
    
def prep_board_human(board): 
    """ Shows board + asks human to make a move 
        --> input is the current nested list board 
        --> outputs / prints a board 
            * asks human to input valiues 
            * checks if values are within bounds of rules 
                * if not, asks to re-enter value
            * executes the move 
    """

    waiting_for_valid_move = True 

    while(waiting_for_valid_move): # loop for valid move 
        
        # prints board as a string 
        get_board_as_string(board) 

        t1_y_axis =  int(input("token 1 row: "))
        t1_x_axis = int(input("token 1 colum: "))
        t2_y_axis =  int(input("token 2 row: "))
        t2_x_axis = int(input("token 2 colum: "))
        
        move = [[t1_y_axis, t1_x_axis],[t2_y_axis, t2_x_axis]]

        if is_valid_move(board, move):
            # Mutate only if move was valid
            board[t1_y_axis][t1_x_axis] = " "
            board[t2_y_axis][t2_x_axis] = " "
            break  # exit the loop
        else:
            print("Invalid move, try again!\n")

def is_valid_move(board, move): 
    """ Checks if move is within bounds of rules 
        --> inputs a nested list board
        --> inputs a nested move list 
        * checks tokens of the inputed values 
        * checks if the index / coordinates are valid 
        * checks if any of the tokens / cooridnates are at the edge of the board 
        --> outputs a boolean indicating if it is or isn't a valid move
    """
    
    IsValid = True # valid untill proven otherwise 

    t1_y_axis = move[0][0]
    t1_x_axis = move[0][1]
    

    t2_y_axis = move[1][0]
    t2_x_axis = move[1][1]

    #checks if token move is valid 

   #index check
    if(t1_x_axis >= len(board)) or (t1_y_axis >= len(board)): 
        print("token 1 position is too big")
        return False #immidently return becuse other functions will index error
    elif (t2_x_axis >= len(board)) or (t2_y_axis >= len(board)): 
        print("token 1 position is too big")
        return False
    elif (t1_x_axis >= len(board)) or (t1_y_axis >= len(board)): 
        print("token 1 position cannot be negetive")
        return False
    elif (t2_x_axis >= len(board)) or (t2_y_axis >= len(board)): 
        print("token 2 position cannot be negetive")
        return False
    

    #converts
    token_1 = board[t1_y_axis][t1_x_axis]
    token_2 = board[t2_y_axis][t2_x_axis]

    #token type check
    if(token_1 == token_2): #if both tokens are same (this check can only be done after validating index)
        print("same token type - try again")
        IsValid = False 
    
    #edge check
    if (t1_x_axis == 0) or (t1_y_axis == 0):  # if token 1 on edge of board 
        print("token 1, on board edge - try again")
        IsValid = False 
    elif (t1_x_axis == len(board)) or (t1_y_axis == len(board)): 
        print("token 1, on board edge - try again")
        IsValid = False 

    if (t2_x_axis == 0) or (t2_y_axis == 0): #if token 2 on edge of board 
        print("token 1, on board edge - try again")
        IsValid = False 
    elif (t2_x_axis == len(board)) or (t1_y_axis == len(board)): 
        print("token 1, on board edge - try again")
        IsValid = False 

    return IsValid

#W2
def get_valid_moves_for_stone(board, stone): 
    """ ss
        -s
    """

    input_token_x = stone[0]
    input_token_y = stone[1]

    if (input_token_x == "") or (input_token_x == ""): 
        return blank_list = [][]

    input_token = board[input_token_y][input_token_x]

    final_list = []

    for y_axis in range(len(board)): 

        for x_axis in range(len(board[y_axis])): 
            current_token = board[y_axis][x_axis]
            current_move_pair = ([input_token_y, input_token_x],[y_axis,x_axis])

            if (is_valid_move(board, current_move_pair)): 
                final_list.append([y_axis, x_axis])
    
    return final_list

def get_valid_moves(board, player): 
    """ s
        - lsd
    """


if __name__ == '__main__':
    board = generate_board(8)
    get_board_as_string(board)
    prep_board_human(board)
    get_board_as_string(board)
    

