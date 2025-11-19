/* DONE CODE (do comments)
 * Project 3: Word Scramble
 *   Author: Roshinikitha Somasundram
 *   Class summary: Gibberisher
 *
 *
 */

import files.LetterSample;

public class Gibberisher
{
    private Trie<CharBag> letterModel;
    private int segmentLength;
    private int samplesProcessed;

    /* Method that messes around eyeyey
     *
     */
    public Gibberisher(int segmentLength)
    {
        this.segmentLength = segmentLength;
        this.samplesProcessed = 0;

        letterModel = new Trie<CharBag>();
        //insitlaizes the Trie variable

    }

    /* Method that messes around eyeyey
     *
     */
    public void train(String[] str)
    {
        //for each letter sample

        LetterSample[] samps;

            //the segment tells you which node of the Trie to use
            //the nextLetter tells you what to add to that CharBag

        for(int i = 0; i < str.length; i++)
        {
            samps =  LetterSample.toSamples(str[i], segmentLength);
            for(int x = 0; x < samps.length; x++)
            {
                //using string from lettersample to get charbag
                String currStr = samps[x].getSegment();
                char currChar = samps[x].getNextLetter();

                //find the charbag in trie
                CharBag currBag = letterModel.get(currStr);

                if(currBag == null) //if null, create new bag and put into trie
                {
                    currBag  = new CharBag();

                    letterModel.put(currStr, currBag);
                }

                //add char from lettersample to charbag
                currBag.add(currChar);
                samplesProcessed++; //inc count

            }
        }

    }

    /* Method that messes around eyeyey
     *
     */
    public int getSampleCount()
    {
        return samplesProcessed;

    }


    /* Method that messes around eyeyey
     *
     */
    public String generate()
    {
        String word = "";


        while(word.length() == 0 || word.charAt(word.length() - 1) != LetterSample.STOP) //while it dosn't end w/ stop letter
        {
            String sample; //get the last k letters of word

            if (word.length() < segmentLength) //word itself
            {
                sample = word;
            }
            else
            {
                sample = word.substring(word.length() - segmentLength); //work is shorter then l
            }

            CharBag bag = letterModel.get(sample); //get the counts for this sample

            if (bag == null) //voided if bag is null
            {
                break;
            }

            char next = bag.getRandomChar(); //geerate the next letter based on sample counts

            if (next == LetterSample.STOP) //if it's stop, be done
            {
                break;
            }

            word += next;  //word = word + nextletter

        }
        return word;

        //return word

    }






}
