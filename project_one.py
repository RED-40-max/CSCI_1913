"""
Project 1: Kōnane (Hawaiian Checkers)
Author: Roshinikitha Somasundram

Reasruch cited:
Thompson, D. (2005). Teaching a Neural Network to Play Konane.
    https://cs.brynmawr.edu/Theses/Thompson.pdf
    Section 4: Preliminary Experiments

Project summery: a playble version of Kōnane.
it includes:
    --> board generation
    --> move validation
    --> starting intial move funciton
    --> move finding
    --> AI-based descition making with huerstics scoring.

Notes
-------------------------------------------------
* Coordinate
    "y-axis" --> row index (vertical)
    "x-axis" --> collum index (horrizonal)
    ex.

    y_axis
            |    [1, 2, 1, 2, 1, 2]
            |    [2, 1, 2, 1, 2, 1]
            |    [1, 2, 1, 2, 1, 2]
            |    [2, 1, 2, 1, 2, 1]
            |    [1, 2, 1, 2, 1, 2]
            |    [2, 1, 2, 1, 2, 1]
            ----------------------------- x_axis

* Token Legend:
    + Empty token --> ○ (u25CB), is white / int: 1
    + Filled token --> ● (u25CF), is black / int: 2
    + Blank space --> "  ", is blank / int: 0
* Math adjecent vocab
    + delta --> 'change in'
* Heuristic Logic
    -------------------------------------------------
    a0 = current board state (after opponent move)
    a1_pl = all possible player moves (via get_valid_moves)
    a2_States = board states after applying each move

    For each a2_State:
        - count player / opponent tokens, moves, and movable pieces
        - calculate ratios
            -> ratios are based on: 4.1.1 Plausible board evaluation functions
            where the author comes up with the 'best evaluator functions' for Kōnane
        - weighted scoring:
            -> weighing comes from: 4.2 Testing the static evaluation functions, where
            the author tests each of the functions against a random player at various depths
                functions:
                a-f measured number of peices
                g-l measured number of possible moves
                m-r measured the movable peices
            -> I chose (multiple) the best preforming functions of each section at depth 1.
            -> then i multiplied the normalized function by apx. the % of games won by that function
        - weight application:
            + Token advantage: (0.5)
            + Dominance: (0.45)
            + Ratio safety: (0.45)
            + Opponent mobility (- 1): (0.82)
            + Player move advantage: (0.8)
            + Player piece mobility: (0.95)
    - store scores in array, and select randomly among top 3
"""

import random

# Board Setup and Display
def generate_board(an_int):
    """ Creates a int square board with checkerbord values

        --> takes an int input
        * creates a nested list of int x int
        * sets alternating tokens for each nested list (1,2)
        --> returns the final board
    """
    an_int = int(an_int)
    final_board = [] # mass / y_axis access

    #Error handle: if zero or negetive board size
    if (an_int <= 0):
        return final_board

    #y_axis loop
    previous_val = 1 #make the very
    for y_axis in range(an_int):
        inner_board = []

        # finding the starting value for this row
        if ((y_axis % 2 == 0) or (y_axis == 0)):
            previous_val = 1
            inner_board.append(previous_val)
        else:
            previous_val = 2
            inner_board.append(previous_val)

        #x_axis control
        for x_axis in range(an_int - 1 ):

            if (previous_val == 1):
                previous_val = 2 #change the value for the next iter
                inner_board.append(previous_val) #if the last First_token_ was 1, add 2

            elif (previous_val == 2):
                previous_val = 1
                inner_board.append(previous_val)

        final_board.append(inner_board) #at the end of the inner row, enter it to y_axis row

    return final_board

def get_board_as_string(board):
    """ Converts the board data into a string

        --> input is the board as a nested list
        * adds the colum number
        * adds row number + token
        * adds seperation bars
        --> overall, creates a string that represents board
    """
    final_board = "   "

    #puts the x_axis on top
    for x_axis in range(len(board[0])):
        final_board += f"{x_axis % 10} "
    final_board += "\n"

    #adds the rows, sepreators, and tokens
    for y_axis in range(len(board)):
        final_board += "  +"
        for x_axis in range(len(board[y_axis])):
            final_board += "-+"
        final_board += "\n"
        final_board += f"{y_axis % 10} |"

        for x_axis in range(len(board[y_axis])):
            symbol_of_token = 0 #assumes blank space untill proven

            if (board[y_axis][x_axis] == 1):
                symbol_of_token = "\u25CF"  #  ●  - Black peice
            elif (board[y_axis][x_axis] == 2):
                symbol_of_token = "\u25CB"  # ○ - White peice
            else:
                symbol_of_token = " " #empty
            final_board += f"{symbol_of_token}|"

        final_board += "\n"

    #Bottom border
    final_board += "  +"
    for x_axis in range(len(board[0])):
        final_board += "-+"
    final_board += "\n"

    return final_board

def prep_board_human(board):
    """ Shows board + asks human to make the first move

        --> input is the current nested list board
        --> outputs / prints a board
            * asks human to input values
            * checks if values are within bounds of rules
                * if not, asks to re-enter value
            * executes the move
    """
    while True:
        print(get_board_as_string(board))

        #inputs position
        First_token_y =  int(input("token 1 row: "))
        First_token_x = int(input("token 1 colum: "))
        Second_token_y =  int(input("token 2 row: "))
        Second_token_x = int(input("token 2 colum: "))

        #checks if it is valid
        if First_token_y in (0, len(board)-1) or First_token_x in (0, len(board[0])-1):
            print("token 1 cannot be on edge\n")
            print("Invalid move, try again!\n")
            continue
        if Second_token_y in (0, len(board)-1) or Second_token_x in (0, len(board[0])-1):
            print("token 2 cannot be on edge\n")
            print("Invalid move, try again!\n")
            continue
        if board[First_token_y][First_token_x] == board[Second_token_y][Second_token_x]:
            print("same token type - try again\n")
            print("Invalid move, try again!\n")
            continue

        # perform removal only after both inputs validated
        board[First_token_y][First_token_x] = 0
        board[Second_token_y][Second_token_x] = 0
        return board

def is_valid_move(board, move):
    """ Checks if move is within bounds of rules

        --> inputs a nested list board
        --> inputs a nested move list
        --> outputs a boolean indicating if it is or isn't a valid move
    """

    #converting the moves
    start_token_y, start_token_x = move[0]
    end_token_y, end_token_x = move[1]

    #index check - is moves within bounds
    if not((0 <= start_token_y < len(board)) and (0 <= start_token_x < len(board[0]))):
        return False
    if not((0 <= end_token_y < len(board)) and (0 <= end_token_x < len(board[0]))):
        return False

    start_val = board[start_token_y][start_token_x]
    end_val = board[end_token_y][end_token_x]

    # Must move from token to empty space
    if (start_val == 0) or not(end_val == 0):
        return False

    #must move in straight line only
    if not (start_token_x == end_token_x or start_token_y == end_token_y):
        return False

    delta_x = abs(end_token_x - start_token_x) #
    delta_y = abs(end_token_y - start_token_y)

    # must be even and over two spaces
    if (delta_x == 0) and ((delta_y < 2) or not(delta_y % 2 == 0)):
        return False
    if (delta_y == 0) and ((delta_x < 2) or not(delta_x % 2 == 0)):
        return False

    # Checks spaces jumped over
    if delta_x == 0: #vertical move
        step = 1 if end_token_y > start_token_y else -1
        y = start_token_y + step

        while y != end_token_y:
            cur = board[y][start_token_x]

            #every alternate square (those jumped over) must have enemy pieces
            if (y - start_token_y) % 2 != 0:
                if cur == 0 or cur == start_val:
                    return False
            else:
                if cur != 0:
                    return False

            y += step

    else:  # horizontal jump
        step = 1 if end_token_x > start_token_x else -1
        x = start_token_x + step

        while x != end_token_x:
            cur = board[start_token_y][x]

            if (x - start_token_x) % 2 != 0:
                if cur == 0 or cur == start_val:
                    return False
            else:
                if cur != 0:
                    return False

            x += step

    return True
#W2
def get_valid_moves_for_stone(board, stone):
    """ Finds valid moves for a single stone or 'token' on the board
        --> inputs board, a list of lists, and stone position, a tuple of tuples
            * checks each point on board to the stone
            * creates a list of valid moves
        --> returns a list of tuple of tuples for the stones
    """

    input_token_y = stone[0]
    input_token_x = stone[1]

    #checks if checks if the stone position is valid to the board
    if not ((0 <= input_token_y < len(board)) and (0 <= input_token_x < len(board[0]))):
        return []

    input_token = board[input_token_y][input_token_x]

    # No moves possible if this sq is empty
    if input_token == 0:
        return []

    final_list = []

    #iterates throught every position on board to find correct matches
    for y_axis in range(len(board)):

        for x_axis in range(len(board[y_axis])):
            current_move_pair = ((input_token_y, input_token_x),(y_axis,x_axis))

            if (is_valid_move(board, current_move_pair)):
                final_list.append(((input_token_y, input_token_x),(y_axis, x_axis)))

    return final_list

def get_valid_moves(board, player):
   """ Returns all valid moves for a player, given the current state of a board
       --> inputs board, as a list of lists, and player, a single int that reps token
       * iterates throught entire board
       * finds all valid moves player's tokens
       --> return a list of tuple of tuples of the valid moves
   """

   final_list = []


   for y_axis in range(len(board)):

        for x_axis in range(len(board[y_axis])):
            token = board[y_axis][x_axis]

            if(token == player):
                token_position = (y_axis, x_axis)
                valid_moves = get_valid_moves_for_stone(board, token_position)
                final_list.extend(valid_moves)

    #FIX

   return final_list

def human_player(board, player):
    """ Handles input and move selection for the human player
        --> inputs a board, list of lists, and a int, representing a token of player.
        * checks if there is a vlid move
        * handels error input
        --> returns the inputted move by player
    """

    if not(get_valid_moves(board, player)):
        print("No valid moves")
        return ()

    waiting_for_valid_move = True

    while(waiting_for_valid_move): # loop for valid move
        print(get_board_as_string(board))

        start_token_y = int(input("Enter start row: "))
        start_token_x = int(input("Enter start column: "))
        end_token_y = int(input("Enter end row: "))
        end_token_x = int(input("Enter end column: "))

        move = ((start_token_y, start_token_x), (end_token_y, end_token_x))

        #final descition
        if (is_valid_move(board, move)):
            waiting_for_valid_move = False
            return move # exit the loop
        else:
            print("Invalid move, try again!\n")


    return ()

def random_player(board, player):
    """Returns a random valid move for the player
        --> inputs a board, list of lists, and an int, player token / stone
        --> returns a random, valid move for player
    """
    moves = get_valid_moves(board, player)
    if not moves:
        print("No valid moves")
        return ()
    return random.choice(moves)

#W3
def ai_player(board, player):
    """ Short-sited AI that selects an move using heuristics (outlined above).

            --> inputs a board, list of lists, and an int, player's token.

            * gets valid moves given current board state
            * creates board states given each possible and valid move for player
            * counts
                --> tokens on board for each side
                --> moves each player has
                --> movable peices each player has
            * scores moves based on weighted heuristics (as detailed above)
                using the counted amounts
            * normalizes values by total tokens and penalizes opponent metrics
            * compiles all scores into a ranked list and randomly picks one of the top 3

            --> returns one move (tuple of tuples) representing the AIs chosen action.
    """
    moves = get_valid_moves(board, player)
    if not(moves):
        print("No valid moves") #if there are not valid moves, then print it
        return

    if (player == 1):
        op_symbol = 2
    else:
        op_symbol = 1

    scores = [] #inilizes score

    #iterates thorught all possible moves
    for current_move in moves:

        new_board = []
        #copy board so you don't mutate the OG
        for row in board:
            new_board.append(row[:])

    #find the board state based on the moves
        start_token_y, start_token_x = current_move[0]
        end_token_y, end_token_x = current_move[1]

        token = new_board[start_token_y][start_token_x]

        new_board[start_token_y][start_token_x] = 0
        new_board[end_token_y][end_token_x] = token

        #remove jumped peices
        if start_token_y == end_token_y:  # horizontal jump
            if end_token_x > start_token_x:
                step = 1
            else:
                step = -1

            for x in range(start_token_x + step, end_token_x, step):
                if not((x - start_token_x) % 2 == 0):
                    new_board[start_token_y][x] = 0

        elif start_token_x == end_token_x:  # vertical jump
            if end_token_y > start_token_y:
                step = 1
            else:
                step = -1

            for y in range(start_token_y + step, end_token_y, step):
                if not((y - start_token_y) % 2 == 0):
                    new_board[y][start_token_x] = 0

        # (1) count tokens on board
        pl_tok = 0
        op_tok = 0
        for row in new_board:
            pl_tok += row.count(player)
            op_tok += row.count(op_symbol)


        #(2) count move amount
        pl_moves = (get_valid_moves(new_board, player))
        op_moves = get_valid_moves(new_board, op_symbol)

        pl_moves_count = len(pl_moves)

        if (op_moves):
            op_moves_count = len(op_moves)
        else:
            op_moves_count = 1

        #(3) count movable pieces
        pl_piece_set = set()
        for m in pl_moves:
            pl_piece_set.add(m[0])

        if pl_moves:
            pl_pieces = len(pl_piece_set)
        else:
            pl_pieces = 0

        op_piece_set = set()
        for m in op_moves:
            op_piece_set.add(m[0])

        if op_piece_set:
            op_pieces = len(op_piece_set)
        else:
            op_pieces = 0

        if not(pl_tok + op_tok == 0):
            total_tokens = pl_tok + op_tok
        else:
            total_tokens = 1

        #scoring - safegaurds
        if op_tok == 0:
            op_tok = 1
        if pl_tok == 0:
            pl_tok = 1

        if op_pieces == 0:
            op_pieces = 1
        if pl_pieces == 0:
            pl_pieces = 1

        if pl_moves_count == 0:
            pl_moves_count = 1

        if op_moves_count == 0:
            op_moves_count == 1


        move_score = 0

        #scoring moves
            # / total_tokens --> normalizes for fair comparsion
            # adds all the diffrent scores w/ weights
            #muiltiple diffrent formulas to react to diffrent board situations

        pl_tok = float(pl_tok)

        # Token-basaed logic
            #rewards player for having higher share of total tokens
            #hurts player for amount of oponents tokens
        move_score += 0.5  * (pl_tok / total_tokens) #ratio of player tokens
        move_score += 0.45 * ((pl_tok / total_tokens) - ((op_tok / total_tokens) * 3)) # (oponet ration *3 ) to make oponent tokens more threatening
        move_score += 0.45 * ((pl_tok / total_tokens) / (op_tok / total_tokens)) #player ratio : oponent ratio

        #Mobility based
            #reward for having many possible moves
            # if the oponent has more mobility, it is worse for player
        move_score += 0.82 * (-1) * (op_moves_count) #less mobility for op, -- subtracts from the score
        move_score += 0.8  * (pl_moves_count / op_moves_count)
        move_score += 0.8  * (pl_moves_count / (op_moves_count * 3))

        #Movable peices
            #rewards player for having active peices
            # active peices leads to player being more 'dominent' in the game
        move_score += 0.95 * ((pl_pieces / total_tokens) - ((op_pieces / total_tokens) * 3))
        move_score += 0.85 * ((pl_pieces / total_tokens) / (op_pieces / total_tokens))
        move_score += 0.85 * ((pl_pieces / total_tokens) / ((op_pieces / total_tokens) * 3))

        scores.append([move_score, current_move])

    # sort list based on move_score, from max to min
    top_3 = []

    for move_pair in scores:
        for i in range(len(top_3)):
            if (move_pair[0] > top_3[i][0]):
                top_3.insert(i, move_pair)
                break
        # if move_pair not inserted above (means still not in top_3)
        if not(move_pair in top_3):
            top_3.append(move_pair)
    # keep only top 3 values (remove extras)
    if (len(top_3) > 3):
        top_3 = top_3[:3]

    chosen_index = random.randint(0, len(top_3) - 1) #importent for end games, where 1 or 2 moves might only be left

    return top_3[chosen_index][1]

def play_game(board):
    """Plays a complete game of Kōnane between two AI agents.

        --> inputs a starting board, as a nested list (list of lists)
        --> randomly selects which AI starts first:
                * Player 1 (Black, token=1)
                * Player 2 (White, token=2)
        --> alternates turns between AI agents using `ai_player()`
        --> game ends when a player has no valid moves
            * if White (2) wins, returns 1
            * if Black (1) wins, returns 2

        Returns:
            int: 1 if White AI wins, 2 if Black AI wins
    """

    #  Randomly decide who starts
    current_player = random.choice([1, 2])

    print(f"\nGame start! Player {current_player} moves first.\n")

    #  Main game loop
    while True:
        valid_moves = get_valid_moves(board, current_player)

        # Check for game-over condition
        if not valid_moves:
            if current_player == 1:
                print("Player 1 ● (Black) has no valid moves. Player 2 ○ (White) wins!\n")
                return 1
            else:
                print("Player 2 ○ has no valid moves. Player 1 ● wins!\n")
                return 2

        # Get the AI's chosen move
        move = ai_player(board, current_player)

        if move:
            start_token_y, start_token_x = move[0]
            end_token_y, end_token_x = move[1]
            token = board[start_token_y][start_token_x]
            board[start_token_y][start_token_x] = 0
            board[end_token_y][end_token_x] = token

            # Remove jumped-over pieces
            if start_token_y == end_token_y:  # Horizontal jump
                if end_token_x > start_token_x:
                    step = 1
                else:
                    step = -1
                for x in range(start_token_x + step, end_token_x, step):
                    if not ((x - start_token_x) % 2 == 0):
                        board[start_token_y][x] = 0

            elif start_token_x == end_token_x:  # Vertical jump
                if end_token_y > start_token_y:
                    step = 1
                else:
                    step = -1
                for y in range(start_token_y + step, end_token_y, step):
                    if not ((y - start_token_y) % 2 == 0):
                        board[y][start_token_x] = 0

        # Display the board after each move - I LOVE THIS FUNCTION <3 <3, so cool to see
        print(f"Player {current_player} made move: {move}")
        print(get_board_as_string(board))

        # Switch player
        if current_player == 1:
             current_player = 2
        else:
            current_player = 1
