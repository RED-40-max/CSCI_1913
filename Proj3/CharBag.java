/* DONE CODE (do comments)
 * Project 3: Word Scramble
 *   Author: Roshinikitha Somasundram
 *   Class summary: CharBag
 *      - a class to count freq of letters
 *          - to generate a random letter from the bag
 *      - Data strucutre for counting charecters
 *
 */

public class CharBag
{
    private int[] freqs;
    private String Alphabet;
    private int size;

    /* Constructor Charecter Bag
     *      -> default, creates empty obj
     *
     */

    //constructor that stores data, and makes next null (last one)
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
     *
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

    /* Method - get index based on the charecter / letter
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
        else //otherwise it's not a charecter that needs to be stopped, but could be upper
        {
            toAdd = Character.toLowerCase(c); // makes it lower case
        }

        int Index = Alphabet.indexOf(toAdd);

        return Index;
    }

    /* Method - returns a string noting the count of each letter
     *
     */
    public String toString()
    {
        String finalCounts = "CharBag{";

        for(int i = 0; i < 27; i++)
        {
            finalCounts += Alphabet.charAt(i) + ":"+ freqs[i];

            if (i < 26)
            {
                finalCounts += ", ";
            }
        }

        finalCounts += "}";
        return finalCounts;

    }

    /* Method - returns a string noting the count of each letter
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
