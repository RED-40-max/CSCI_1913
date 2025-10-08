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
    + empty token --> u25CB (white) (1) (○)
        (on my screen this shows up as a black token)
    + filled token --> u25CF (black) (2) (●)
        (on my screen this shows up as a white token)
    + blank space --> (0) nothing is there / no white or black 
* 

"""

import random 

#W1
def generate_board(an_int): 
    """ Creates a int square board with checkerbord values 
        --> takes an int input 
        * creates a nested list of int x int 
        * sets alternating tokens for each nested list 
        --> returns the final board 
    """
    an_int = int(an_int)

    final_board = [] # mass / y_axis access

    if (an_int <= 0): # if the user inputs a value >= 0, return empty list
        return final_board

    #y_axis control
    previous_val = 1 #make the very 

    for y_axis in range(an_int): 
        inner_board = [] # x_axis acesss, resests each time

        if ((y_axis % 2 == 0) or (y_axis == 0)): # if it is an even or 0, start w/ 1
            previous_val = 1 
            inner_board.append(previous_val)
        else: #otherwise it's odd so start with 2 
            previous_val = 2 
            inner_board.append(previous_val)

        #x_axis control 
        for x_axis in range(an_int - 1 ): 

            if (previous_val == 1): #if it starts with 1 
                previous_val = 2 #change the value for the next iter
                inner_board.append(previous_val) #if the last First_token_ was 1, add 2

            elif (previous_val == 2): 
                previous_val = 1 #change the value for the next iter
                inner_board.append(previous_val) 

        final_board.append(inner_board) #at the end of the inner row, enter it to y_axis row

    return final_board

def get_board_as_string(board): 
    """ Converts the board data into a string 
        --> input is the board as a nested list 
        * adds the colum number 
        * adds row number + token 
        * adds seperation bars 
        --> overall, creates a string that is for the board 
    """
    final_board = ""
    
    #puts the x_axis on top 
    
    final_board += "    "

    for x_axis in range(len(board[0])): 
        final_board += f"{x_axis % 10}   " # adds column no.

    final_board += "\n"
    
    #adds the rows 
    for y_axis in range(len(board)): 

        #adds seperation bar
        final_board += "  +"
        for x_axis in range(len(board[y_axis])): 
            final_board += f"-+"
        final_board += "\n"

        #adds row no. + tokens
        final_board += f"{y_axis % 10} |"
    
        for x_axis in range(len(board[y_axis])): 
            symbol_of_token = 0 #assumes blank space untill proven

            if (board[y_axis][x_axis] == 1): #empty token 
                symbol_of_token = "\u25CB" # to use unicode in python, use escape sequence
            elif (board[y_axis][x_axis] == 2): #a filled token 
                symbol_of_token = "\u25CF"
            else:  #otherwise it is a blank token, and represent as such
                symbol_of_token = " "

            final_board += f"{symbol_of_token}|" 

        final_board += "\n"

    #adds last row's sepreation bar
    final_board += "  +"
    for x_axis in range(len(board[0])): 
        final_board += f"-+"
    final_board += "\n"

    return final_board
    
def prep_board_human(board): 
    """ Shows board + asks human to make a move 
        --> input is the current nested list board 
        --> outputs / prints a board 
            * asks human to input values 
            * checks if values are within bounds of rules 
                * if not, asks to re-enter value
            * executes the move 
    """

    waiting_for_valid_move = True 

    while(waiting_for_valid_move): # loop for valid move 
        
        # prints board as a string 
        print(get_board_as_string(board))  

        start_token_y =  int(input("token 1 row: "))
        start_token_x = int(input("token 1 colum: "))
        end_token_y =  int(input("token 2 row: "))
        end_token_x = int(input("token 2 colum: "))
        
        move = ((start_token_y, start_token_x),(end_token_y, end_token_x))

        #checks on the First_token_ move
        Is_valid_First_token__move = True 

        #index check + edge check 
        if(start_token_x >= len(board)) or (start_token_y >= len(board) ): #edge check 
            print("token 1 position is too big")
            Is_valid_First_token__move = False 
        elif (end_token_x >= len(board) ) or (end_token_y >= len(board) ): #edge check 
            print("token 1 position is too big")
            Is_valid_First_token__move = False 
        elif (start_token_x < 0) or (start_token_y < 0): 
            print("token 1 position cannot be negetive")
            Is_valid_First_token__move = False 
        elif (end_token_x < 0) or (end_token_y < 0): 
            print("token 2 position cannot be negetive")
            Is_valid_First_token__move = False 
        
        #converts
        token_1 = board[start_token_y][start_token_x]
        token_2 = board[end_token_y][end_token_x]

        #token type check
        if(token_1 == token_2): #if both tokens are same (this check can only be dFirst_token_ after validating index)
            print("same token type - try again")
            Is_valid_First_token__move = False 
        
        #final discitions 
        if Is_valid_First_token__move:
            waiting_for_valid_move = False 
            # Mutate only if move was valid
            board[start_token_y][start_token_x] = 0
            board[end_token_y][end_token_x] = 0
            return None # exit the loop
        else:
            print("Invalid move, try again!\n")

def is_valid_move(board, move): 
    """ Checks if move is within bounds of rules 
        --> inputs a nested list board
        --> inputs a nested move list 
        * 
        --> outputs a boolean indicating if it is or isn't a valid move
    """

    #converting the moves 
    start_token_y = move[0][0]
    start_token_x = move[0][1]
    end_token_y = move[1][0]
    end_token_x = move[1][1]

    #index check - is moves within bounds
    if not(0 <= start_token_y < len(board)) and (0 <= start_token_x < len(board[0])):
            return False
    if not(0 <= end_token_y < len(board)) and (0 <= end_token_x < len(board[0])):
            return False

    # starting position has a token, ending is blank space
    if (board[start_token_y][start_token_x] == 0): 
        return False
    if not (board[end_token_y][end_token_x] == 0): 
        return False
    
    #the jump is only in one direction 
    delta_x = start_token_x - end_token_x 
    delta_y = start_token_y - end_token_y

    if (not(delta_x == 0) and not(delta_y == 0)): # if it moves like a bishop from chess - not in due cardinal directions
        return False
    elif ((delta_x == 0 and delta_y == 0)): #same 
        return False

    if abs(delta_x) < 2 and abs(delta_y) < 2: # if it moves only one space
        return False
    
    
    #checking stones between the spaces 
    start_token = board[start_token_y][start_token_x]

    

    if delta_x == 0: 
        #step calculations 
        if (delta_y > 0): 
            step = 1 #moving down 
        elif (delta_y < 0): 
            step = -1 #moving up 

        for y in range(start_token_y + step, end_token_y, step):
            current = board[y][start_token_x] 
            if(current == 0): #over empty space
                return False
            elif( start_token == current): #over same token, since y is changing 
                return False
    else: 
        #step calcs 
        if (delta_x > 0): 
            step = 1 #moving right
        else: 
            step = -1 #moving left

        for x in range(start_token_x + step, end_token_x, step): 
            current = board[start_token_y][x]
            if(current== 0): #over empty space
                return False
            elif(start_token == current): #over same token, since y is changing 
                return False

    return True

#W2
def get_valid_moves_for_stone(board, stone): 
    """ ss
        -s
    """

    input_token_y = stone[0]
    input_token_x = stone[1]

    if not ((0 <= input_token_y < len(board)) and (0 <= input_token_x < len(board[0]))):
        return []

    input_token = board[input_token_y][input_token_x]

    # No moves possible if this sq is empty
    if input_token == 0:
        return []

    final_list = []

    for y_axis in range(len(board)): 

        for x_axis in range(len(board[y_axis])): 
            current_move_pair = ([input_token_y, input_token_x],[y_axis,x_axis])

            if (is_valid_move(board, current_move_pair)): 
                final_list.append([y_axis, x_axis])
    
    return final_list

def get_valid_moves(board, player):
   """ s
       - lsd
   """ 

   final_list = [] #make a blank list

   for y_axis in range(len(board)):

        for x_axis in range(len(board[y_axis])): 
            token = board[y_axis][x_axis] 

            if(token == player): 
                token_position = (y_axis, x_axis)
                final_list.extend(get_valid_moves_for_stone(board, token_position))

   return final_list 

def human_player(board, player): 
    """ m 
    - lsdj
    """

    if not(get_valid_moves(board, player)):
        print(f"No valid moves")
        return ()

    #similar to the first move metric 

    waiting_for_valid_move = True 

    while(waiting_for_valid_move): # loop for valid move 
        print(get_board_as_string(board)) #prints the board down 

        start_token_y = int(input("Enter start row: "))
        start_token_x = int(input("Enter start column: "))
        end_token_y = int(input("Enter end row: "))
        end_token_x = int(input("Enter end column: "))

        move = ((start_token_y, start_token_x), (end_token_y, end_token_x)) #move
        
        #final discitions 
        if (is_valid_move(board, move)):
            waiting_for_valid_move = False 
            # Mutate only if move was valid
            return move # exit the loop
        else:
            print("Invalid move, try again!\n")

    
    return 0

def random_player(board, player): 
    """s
    - sdf
    """

    move_list = get_valid_moves(board, player)

    if not(move_list):
        print(f"No valid moves")
        return ()
    
    random_index = randint(0, len(move_list) -1)

    return move_list[random_index]

#W3 
def ai_player(board, player): 
    """ x 
    - 
    - reactive machine 
    two-steps ahead 
    a0 = current board state w/ the last turn being the ops
    a1_pl [] = all the next possible board states for player to take
        --> call get_valid_moves(board, player) 

    a2_op [] = all the next possible board states for op to take after a1_pl

        op_moves = get_valid_moves(board, player)
        for x in range(len(get_valid_moves(board, player))): 
            new_board = (simulate and store the move)
            op_moves[x] = len(get_valid_moves(new_board, oponent))
        


    'scores' a1_pl based on best practices for konea moves - based on heuristics: 
        -1 * (number of moves op has in response to a1_pl)
            --> accounts for how many moves op has 
            --> accounts for how many tokens player took last turn 
        


    takes top 3 scores and randomly picks one 

    """
    




    return 0 

def play_game(): 
    #things
    return 0
