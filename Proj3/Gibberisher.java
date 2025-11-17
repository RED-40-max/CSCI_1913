/*
 *
 *
 *
 *
 *
 */


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
            f
            samps =  LetterSample.toSamples(str[i], segmentLength);



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

    }






}
