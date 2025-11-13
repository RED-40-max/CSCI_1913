/*
 * Project 3: Word Scramble
 *   Author: Roshinikitha Somasundram
 *   Class summary: CharBag
 *      - a class to count freq of letters
 *          - to generate a random letter from the bag
 *      - Data strucutre for counting charecters
 *
 */




public interface CharBag
{
    /

    /* Constructor Charecter Bag
     *      -> default, creates empty obj
     *
     */
    public CharBag()
    {

    }

    /* Method add char to Charbag
     *      -> if char uppercase, convreted to lwr before adding
     *      -> if char not english, converted to '.' (STOP char)
     */
    public void add(char letter)
    {
        char toAdd ;

        if(!(Character.isLetter(letter)))
        {
            toAdd = '.';
        }

        toAdd = Character.toLowerCase(letter);

    }


}
