/*
 * Project 3: Word Scramble
 *   Author: Roshinikitha Somasundram
 *   Class summary: Gibberisher
 *      - trains a model using letter segment samples.
 *      - Each segment maps to a CharBag that contains freq of next char.
 *      - Can generate new “gibberish” words based on patterns.
 *
 *
 */




public class Gibberisher
{
    private Trie<CharBag> letterModel;
    private int segmentLength;
    private int samplesProcessed;

    /* Constructor makes segment length and creates the Trie model.
     *      --> Starts w zero samples.
     *      --> makes an empty Trie to store CharBags.
     */
    public Gibberisher(int segmentLength)
    {
        this.segmentLength = segmentLength;
        this.samplesProcessed = 0;

        letterModel = new Trie<CharBag>();
        //insitlaizes the Trie variable
    }

    //getter
    public int getSampleCount()
    {
        return samplesProcessed;

    }

    /* Method that Trains the model
     *      --> gets data (array of string)
     *      --> for each string, augment it to create more data
     *          --> break into segment + next char
     *          --> for each segment, method updates Charbag for freq
     *          --> inc processed samples
     *     --> end up with freqnecy for each char on each segments
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


    /* Method that generates and returns a new word
     *      --> new word based on trained model
     *      --> start w/ empty string
     *              --> asks model to generate the last char over and over
     *              --> until the model says it should stop
     *      --> outputs that final string
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
        return word; // return the final string

    }






}
