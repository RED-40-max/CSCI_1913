package lab06files;



import java.util.Arrays;

public class NimTester {

    public static void main(String[] args) {
        int[] state;
        int[] result;
        int[] expected;
        boolean output;

        System.out.println("Beginning of testing createGameStates");
        state = NIM.createGameState(0, 0);
        System.out.println(Arrays.toString(state));     // []
        if (state.length != 0) throw new AssertionError("createGameStates(0,0) failed");
        else System.out.println("createGameStates(0,0) ran successfully");

        state = NIM.createGameState(5, 5);
        System.out.println(Arrays.toString(state));     // [1, 2, 3, 4, 5]
        expected = new int[]{1, 2, 3, 4, 5};
        if (!Arrays.equals(state, expected)) throw new AssertionError("createGameStates(5,5) failed");
        else System.out.println("createGameStates(5,5) ran successfully");

        state = NIM.createGameState(4, 3);
        System.out.println(Arrays.toString(state));     // [1, 2, 3, 3]
        expected = new int[]{1, 2, 3, 3};
        if (!Arrays.equals(state, expected)) throw new AssertionError("createGameStates(4,3) failed");
        else System.out.println("createGameStates(4,3) ran successfully");

        state = NIM.createGameState(7, 9);
        System.out.println(Arrays.toString(state));     // [1, 2, 3, 4, 5, 6, 7]
        expected = new int[]{1, 2, 3, 4, 5, 6, 7};
        if (!Arrays.equals(state, expected)) throw new AssertionError("createGameStates(7,9) failed");
        else System.out.println("createGameStates(7,9) ran successfully");

        state = NIM.createGameState(1, 1);
        System.out.println(Arrays.toString(state));     // [1]
        expected = new int[]{1};
        if (!Arrays.equals(state, expected)) throw new AssertionError("createGameStates(1,1) failed");
        else System.out.println("createGameStates(1,1) ran successfully");

        state = NIM.createGameState(1, 3);
        System.out.println(Arrays.toString(state));     // [1]
        expected = new int[]{1};
        if (!Arrays.equals(state, expected)) throw new AssertionError("createGameStates(1,3) failed");
        else System.out.println("createGameStates(1,3) ran successfully");

        state = NIM.createGameState(5, 2);
        System.out.println(Arrays.toString(state));     // [1, 2, 2, 2, 2]
        expected = new int[]{1, 2, 2, 2, 2};
        if (!Arrays.equals(state, expected)) throw new AssertionError("createGameStates(5,2) failed");
        else System.out.println("createGameStates(5,2) ran successfully");

        state = NIM.createGameState(8, 4);
        System.out.println(Arrays.toString(state));     // [1, 2, 3, 4, 4, 4, 4, 4]
        expected = new int[]{1, 2, 3, 4, 4, 4, 4, 4};
        if (!Arrays.equals(state, expected)) throw new AssertionError("createGameStates(5,2) failed");
        else System.out.println("createGameStates(5,2) ran successfully");

        state = NIM.createGameState(6, 1);
        System.out.println(Arrays.toString(state));     // [1, 1, 1, 1, 1, 1]
        expected = new int[]{1, 1, 1, 1, 1, 1};
        if (!Arrays.equals(state, expected)) throw new AssertionError("createGameStates(6,1) failed");
        else System.out.println("createGameStates(6,1) ran successfully");

        state = NIM.createGameState(13, 9);
        System.out.println(Arrays.toString(state));     // [1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9]
        expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9};
        if (!Arrays.equals(state, expected)) throw new AssertionError("createGameStates(13,9) failed");
        else System.out.println("createGameStates(13,9) ran successfully");

        System.out.println("End of testing createGameStates");
        System.out.println("********************************************");
        System.out.println("Beginning of testing isValidMove");

        state = new int[]{5, 4, 3, 2};
        output = NIM.isValidMove(state, "1", "2");
        System.out.println(output); // true
        if (!output) throw new AssertionError("isValidMove(state, \"1\", \"2\") failed");
        else System.out.println("isValidMove(state, \"1\", \"2\") ran successfully");

        state = new int[]{8, 7, 6, 5, 4};
        output = NIM.isValidMove(state, "5", "2");
        System.out.println(output); // true
        if (!output) throw new AssertionError("isValidMove(state, \"5\", \"2\") failed");
        else System.out.println("isValidMove(state, \"5\", \"2\") ran successfully");

        state = new int[] {4, 3};
        output = NIM.isValidMove(state, "1", "1");
        System.out.println(output); // true
        if (!output) throw new AssertionError("isValidMove(state, \"1\", \"1\") failed");
        else System.out.println("isValidMove(state, \"1\", \"1\") ran successfully");

        state = new int[] {4, 3};
        output = NIM.isValidMove(state, "3", "4");
        System.out.println(output); // false
        if (output) throw new AssertionError("isValidMove(state, \"3\", \"4\") failed");
        else System.out.println("isValidMove(state, \"3\",\"4\") ran successfully");

        state = new int[] {5, 4, 3, 2};
        output = NIM.isValidMove(state, "5", "4");
        System.out.println(output); // false
        if (output) throw new AssertionError("isValidMove(state, \"5\", \"4\") failed");
        else System.out.println("isValidMove(state, \"5\", \"4\") ran successfully");

        state = new int[] {5, 4, 3, 2};
        output = NIM.isValidMove(state, "a", "a");
        System.out.println(output); // false
        if (output) throw new AssertionError("isValidMove(state, \"a\", \"a\") failed");
        else System.out.println("isValidMove(state, \"a\", \"a\") ran successfully");

        state = new int[] {5, 4, 3, 2};
        output = NIM.isValidMove(state, "a", "2");
        System.out.println(output); // false
        if (output) throw new AssertionError("isValidMove(state, \"a\", 2) failed");
        else System.out.println("isValidMove(state, \"a\", 2) ran successfully");

        state = new int[] {5, 4, 3, 2};
        output = NIM.isValidMove(state, "1", "a");
        System.out.println(output); // false
        if (output) throw new AssertionError("isValidMove(state, \"1\", \"a\") failed");
        else System.out.println("isValidMove(state, \"1\", \"a\") ran successfully");

        state = new int[] {5, 4, 3, 2};
        output = NIM.isValidMove(state, "0", "1");
        System.out.println(output); // false
        if (output) throw new AssertionError("isValidMove(state, \"0\", \"1\") failed");
        else System.out.println("isValidMove(state, \"0\", \"1\") ran successfully");

        state = new int[] {5, 4, 3, 2};
        output = NIM.isValidMove(state, "4", "3");
        System.out.println(output); // false
        if (output) throw new AssertionError("isValidMove(state, \"4\", \"3\") failed");
        else System.out.println("isValidMove(state, \"4\", \"3\") ran successfully");

        state = new int[] {5, 4, 3, 2};
        output = NIM.isValidMove(state, "1", "4");
        System.out.println(output); // false
        if (output) throw new AssertionError("isValidMove(state, \"1\", \"4\") failed");
        else System.out.println("isValidMove(state, \"1\", \"4\") ran successfully");

        state = new int[] {5, 4, 3, 2};
        output = NIM.isValidMove(state, "3", "3");
        System.out.println(output); // true
        if (!output) throw new AssertionError("isValidMove(state, \"3\", \"3\") failed");
        else System.out.println("isValidMove(state, \"3\", \"3\") ran successfully");

        System.out.println("End of testing isValidMove");
        System.out.println("********************************************");
        System.out.println("Beginning of testing update");


        state = new int[] {3, 2, 1};
        result = NIM.update(state, 2, 1);
        expected = new int[]{3, 2, 0};
        System.out.println(Arrays.toString(state) +" "+ Arrays.toString(result)); // [3, 2, 1] [3, 2, 0]
        if (!Arrays.equals(expected, result)) throw new AssertionError("update(state,2,1) failed");
        else System.out.println("update(state,2,1) ran successfully");

        state = new int[] {4, 3, 2, 1, 0};
        result = NIM.update(state, 3, 1);
        expected = new int[]{4, 3, 2, 0, 0};
        System.out.println(Arrays.toString(state) +" "+ Arrays.toString(result)); // [4, 3, 2, 1, 0] [4, 3, 2, 0, 0]
        if (!Arrays.equals(expected, result)) throw new AssertionError("update(state,3,1) failed");
        else System.out.println("update(state,3,1) ran successfully");

        state = new int[] {9, 8, 7, 6, 5, 4, 3};
        result = NIM.update(state, 6, 2);
        expected = new int[]{9, 8, 7, 6, 5, 4, 1};
        System.out.println(Arrays.toString(state) +" "+ Arrays.toString(result)); // [9, 8, 7, 6, 5, 4, 3] [9, 8, 7, 6, 5, 4, 1]
        if (!Arrays.equals(expected, result)) throw new AssertionError("update(state,6,2) failed");
        else System.out.println("update(state,6,2) ran successfully");

        state = new int[] {8, 7, 6, 5};
        result = NIM.update(state, 0, 3);
        expected = new int[]{5, 7, 6, 5};
        System.out.println(Arrays.toString(state) +" "+ Arrays.toString(result)); // [8, 7, 6, 5] [5, 7, 6, 5]
        if (!Arrays.equals(expected, result)) throw new AssertionError("update(state,0,3) failed");
        else System.out.println("update(state,0,3) ran successfully");

        state = new int[] {5, 4, 3, 2, 1};
        result = NIM.update(state, 1, 1);
        expected = new int[]{5, 3, 3, 2, 1};
        System.out.println(Arrays.toString(state) +" "+ Arrays.toString(result)); // [5, 4, 3, 2, 1] [5, 3, 3, 2, 1]
        if (!Arrays.equals(expected, result)) throw new AssertionError("update(state,1,1) failed");
        else System.out.println("update(state,1,1) ran successfully");

        state = new int[] {4, 3, 2, 1};
        result = NIM.update(state, 1, 2);
        expected = new int[]{4, 1, 2, 1};
        System.out.println(Arrays.toString(state) +" "+ Arrays.toString(result)); // [4, 3, 2, 1] [4, 1, 2, 1]
        if (!Arrays.equals(expected, result)) throw new AssertionError("update(state,1,2) failed");
        else System.out.println("update(state,1,2) ran successfully");

        System.out.println("End of testing update");
        System.out.println("********************************************");
        System.out.println("Beginning of testing drawGameState");

        state = new int[] {5,4,3,2,1};
        System.out.println("before call");
        NIM.drawGameState(state);
        System.out.println("after call");
        // before call
        // ====================
        // 1 #####
        // 2 ####
        // 3 ###
        // 4 ##
        // 5 #
        // ====================
        // after call

        state = new int[] {5,4,3,4,1,0,0,9,1};
        System.out.println("before call");
        NIM.drawGameState(state);
        System.out.println("after call");
        // before call
        // ====================
        // 1 #####
        // 2 ####
        // 3 ###
        // 4 ####
        // 5 #
        // 6
        // 7
        // 8 #########
        // 9 #
        // ====================
        // after call

        state = new int[] {1};
        System.out.println("before call");
        NIM.drawGameState(state);
        System.out.println("after call");
        // before call
        // ====================
        // 1 #
        // ====================
        // after call

        System.out.println("End of testing drawGameState");
        System.out.println("********************************************");
        System.out.println("Beginning of testing isOver");

        output = NIM.isOver(new int[]{0});
        System.out.println(output);                 // true
        if (!output) throw new AssertionError("isOver(new int[]{0}) failed");
        else System.out.println("isOver(new int[]{0}) ran successfully");

        output = NIM.isOver(new int[]{1,4,1,3,1,0});
        System.out.println(output);  // false
        if (output) throw new AssertionError("isOver(new int[]{1,4,1,3,1,0}) failed");
        else System.out.println("isOver(new int[]{0}) ran successfully");


        output = NIM.isOver(new int[]{0,1,2,3,2});
        System.out.println(output); // false
        if (output) throw new AssertionError("isOver(new int[]{0,1,2,3,2}) failed");
        else System.out.println("isOver(new int[]{0,1,2,3,2}) ran successfully");


        output = NIM.isOver(new int[]{1,2,3,4,0});
        System.out.println(output); // false
        if (output) throw new AssertionError("isOver(new int[]{1,2,3,4,0}) failed");
        else System.out.println("isOver(new int[]{1,2,3,4}) ran successfully");


        output = NIM.isOver(new int[]{0,0,0,0,0,0,0,0});
        System.out.println(output); // true
        if (!output) throw new AssertionError("isOver(new int[]{0,0,0,0,0,0,0,0}) failed");
        else System.out.println("isOver(new int[]{0,0,0,0,0,0,0,0}) ran successfully");


        output = NIM.isOver(new int[]{1,2,0,2,1,3});
        System.out.println(output); // false
        if (output) throw new AssertionError("isOver(new int[]{1,2,0,2,1,3}) failed");
        else System.out.println("isOver(new int[]{1,2,0,2,1,3}) ran successfully");


        System.out.println("End of testing isOver");
        System.out.println("********************************************");
        System.out.println("End of all testing");

    }
}