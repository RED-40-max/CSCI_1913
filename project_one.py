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
        if(start_token_x >= len(board)-1) or (start_token_y >= len(board) -1): #edge check 
            print("token 1 position is too big")
            Is_valid_First_token__move = False 
        elif (end_token_x >= len(board) - 1) or (end_token_y >= len(board) - 1): #edge check 
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

#vvv fix all this vvv
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
    if(start_token_x >= len(board)) or (start_token_y >= len(board) ): 
        return False 
    elif (end_token_x >= len(board) ) or (end_token_y >= len(board) ): 
        return False 
    elif (start_token_x < 0) or (start_token_y < 0): 
        return False 
    elif (end_token_x < 0) or (end_token_y < 0): 
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
    
    #checking stones between the spaces 
    start_token = board[start_token_y][start_token_x]

    #step calculations 
    if (delta_y > 0): 
        step = 1 #moving up 
    elif (delta_y < 0): 
        step = -1 #moving down 
    elif (delta_x > 0): 
        step = 1 #moving right
    else: 
        step = -1 #moving left

    if delta_x == 0: 
        for y in range(start_token_y + step, end_token_y, step): 
            if(board[y][start_token_x]== 0): #over empty space
                return False
            elif( start_token == board[y][start_token_x]): #over same token, since y is changing 
                return False
    elif delta_y == 0: 
        for x in range(start_token_x + step, end_token_x, step): 
            if(board[start_token_y][x]== 0): #over empty space
                return False
            elif(start_token == board[start_token_y][x]): #over same token, since y is changing 
                return False

    
    return True

#W2
def get_valid_moves_for_stone(board, stone): 
    """ ss
        -s
    """

    input_token_x = stone[0]
    input_token_y = stone[1]

    if (input_token_x == "") or (input_token_x == ""): 
        return [] # return a blank list 

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

   final_list = [] #make a blank list

   for y_axis in range(len(board)):

        for x_axis in range(len(board[y_axis])): 

            if(token == player): 
                token_position = [y_axis, x_axis ]
                final_list += (get_valid_moves_for_stone(token_position))

   return final_list 

def human_player(board, player): 
    #whatnot 
    return 0

def random_player(board, player): 
    #
    return 0

#W3 
def ai_player(board, player): 
    #stuff 
    return 0 

def play_game(): 
    #things
    return 0

if __name__ == "__main__":
    print(get_board_as_string(generate_board(input("user: "))))
    

