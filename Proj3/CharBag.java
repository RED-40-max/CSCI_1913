/* DONE
 * Project 3: Word Scramble
 *   Author: Roshinikitha Somasundram
 *   Class Summary: CharBag
 *      - A data structure to count and store the freq of char.
 *      - CRUD characters
 *      - Generating a random char with systematic sampling
 *
 *   Systematic Sampling (statistical principle):
 *      In systematic sampling, the data is structred in such a way that the
 *      item appears as many times as it's freqency. we then follow the steps:
 *
 *          1. Choose a starting position within the total number of items.
 *          2. Move through the ordered list until landing on the item whose
 *             interval contains that given point.
 *
 *      Since this case only reqires one random char, we only choose one char.
 *      Using this method, we can ensure that chars with higher freq are
 *      more likley to be choosen. This gives us a simple way to generate random chars
 *      proportional to the number of times a given char is in the bag
 *
 */


public class CharBag
{
    private int[] freqs;
    private String Alphabet;
    private int size;

    /* Constructor Charecter Bag
     *      -> default, creates empty obj
     *          stores data and makes freqs null
     */
    public CharBag()
    {
        this.Alphabet = "abcdefghijklmnopqrstuvwxyz.";
        this.freqs = new int[27];
        this.size = 0;
    }

    /* Method add char to Charbag
     *      -> if char uppercase, convreted to lwr before adding
     *      -> if char not english, converted to '.' (STOP char)
     */
    public void add(char letter)
    {

        this.freqs[getIndex(letter)] ++;
        size ++; //increase size of bag

    }

    /* Method subtract char to Charbag
     *      -> same exact logic as add, except, instead we subtract from freqs and size instead of add
     *      -> if char uppercase, convreted to lwr before subtracting
     *      -> if char not english, converted to '.' (STOP char)
     *
     */
    public void remove(char c)
    {
        if(freqs[getIndex(c)] > 0)
        {
            this.freqs[getIndex(c)] --;
            size --; //increase size of bag
        }

    }


    /* Method to get freqency based on letter
     *      --> finds index and returns the freqency
     */
    public int getCount(char c)
    {
        return (this.freqs[getIndex(c)]);

    }

    /* Method - get index based on the charecter / letter
     *      + provides abstraction
     *      --> first filteres and lowercases the letters
     *      --> then gets the index of the alphabet (which will be same index of freqency)
     */
    public int getSize()
    {
        return size;

    }

    /* Method - get index based on the char / letter
     *      + provides abstraction
     *      --> first filteres and lowercases the letters
     *      --> then gets the index of the alphabet (which will be same index of freqency)
     */
    public int getIndex(char c){
        char toAdd ; //make a char to add

        if(!(Character.isLetter(c))) // filter to catch non-chars
        {
            toAdd = LetterSample.STOP;
        }
        else //otherwise it's not a char that needs to be stopped, but could be upper
        {
            toAdd = Character.toLowerCase(c); // makes it lower case
        }

        int Index = Alphabet.indexOf(toAdd);

        return Index;
    }

    /* Method - Returns a string noting the count of each letter i the bag
     *      output should look likeCharBag{A:3, B:0, C:1, ... Z:2, _:5}
     */
    public String toString()
    {
        String finalCounts = "CharBag{";

        for(int i = 0; i < 27; i++)
        {
            finalCounts += Alphabet.charAt(i) + ":"+ freqs[i];

            if (i < 26)
            {
                finalCounts += ", "; //formatting on last digitis and commas
            }
        }

        finalCounts += "}";
        return finalCounts;

    }

    /* Method generates a character by implimenting systamatic sampling
    *
    *       --> since CharBag has the char listed out w/ freq
    *       1. randomly select position, given 0 <= position < size
    *       2. move thorught the line of chars, subtracting from the freq untill
    *          land on the char that is at that position.
    *
    * In systematic sampling, char w/ larger freq have more chance of getting picked.
    *
    */
    public char getRandomChar()
    {
        int count = (int) Math.floor(Math.random() * size);
        for (int i = 0; i < 27; i++)
        {
            count -= getCount(Alphabet.charAt(i));
            if (count < 0)
            {
                return (Alphabet.charAt(i));
            }
        }
        return '.';
    }
}
