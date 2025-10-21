


public class NIM {

    /**
     * cerate a game state array
     * @param size -- the number of rows
     * @param stickMax -- the largest value
     * @return an array representing a token array. The array in the first position will be one, each following will be
     *     one larger up to the max.
     */
    public static int[] createGameState(int size, int stickMax) {
        //TODO: FILL ME IN

        int[] gameBoard = new int[size];

        for(int i = 0; i < size; i++) //first loop - initalizes y-axis
        {
            if ( i >= stickMax)
            {
                gameBoard[i] = (stickMax);
            }
            else
            {
                gameBoard[i] = (stickMax + 1);
            }

        }
        return gameBoard;
    }

    /**
     * This provided function operators similarly to the python isDigit method. You give it a string and it will tell
     * you if the string contains only digits. Give it a read -- the actual design isn't hard, basically a linear search.
     * @param str any string
     * @return true if all letters in the string are digits.
     */
    private static boolean isDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if a given move (as represented by two input strings) is valid. This should check if the inputs are numbers
     * if those numbers are in the valid range.
     * @param gameState an array representing the number of tokens in each row.
     * @param row a string representing which row the user wants to take from. 1-indexed.
     * @param takes a string representing how many tokens the user wants to take.
     * @return true if and only if the move would be valid
     */
    public static boolean isValidMove(int[] gameState, String row, String takes) {

        if (!(isDigit(row) && isDigit(takes))) //if inputs are digits
        {
            return false;
        }

        int rowNum = Integer.parseInt(row); //a method to convert a string into a int to preform operations
        int takesNum = Integer.parseInt(takes);

        if((rowNum >= (gameState).length) || (rowNum > 0))
        {
            return false;
        }

        if (!((0 < takesNum) && (takesNum <= 3)))
        {
            return false;
        }

        if (takesNum > gameState[rowNum])
        {
            return false;
        }

        return true; //if it passes all the checks
    }

    /**
     * User System.out.println to represent a token grid to the program user.
     * @param gameState an array representing the number of tokens in each row.
     */
    public static void drawGameState(int[] gameState) {
        System.out.println("====================");

        for (int y = 0; y < gameState.length; y++)
        {
            System.out.print(y + 1);

            for (int x = 0; x < gameState[y]; x++)
            {
                System.out.print("#");
            }
            System.out.println();
        }

        System.out.println("====================");

    }


    /**
     * Create an updated version of the game state. You can assume the row and takes are valid for the gameState array provided.
     * @param gameState an array representing the number of tokens in each row.
     * @param row the row the user wants to take from (0-indexed)
     * @param takes the number of tokens the user wants to take
     * @return a new array representing the state number of tokens in each row after the given numbers were removed.
     */
    public static int[] update(int[] gameState, int row, int takes) {

        int[] finalGameState = gameState;
        finalGameState[row] -= takes;
        return finalGameState;
    }

    /**
     *
     * @param gameState an array representing the number of tokens in each row.
     * @return true if and only if every element of gameState is false.
     */
    public static boolean isOver(int[] gameState) {

        for(int y = 0; y < gameState.length; y++)
        {
            if (gameState[y] != 0 )
            {
                return false;
            }

        }

        return true; // you will want to delete this line.
    }
}
