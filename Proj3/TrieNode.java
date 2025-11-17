/* DONE CODE (do comments)
 * Project 3: Word Scramble
 *   Author: Roshinikitha Somasundram
 *   Class summary: TrieNode
 *
 *
 */



public class TrieNode <T>
{
    private T currVal; // data node
    private TrieNode<T>[] childs = new TrieNode[26];
    //private TrieNode[] childs = (TrieNode<T>[]) new TrieNode[26];


    /* Constructor
     *
     */
    public TrieNode()
    {
        for(int i = 0; i < 26; i++) //makes 26 nulls
        {
            this.childs[i] = null;
        }
    }

    //returns the data of this node
    public T getData()
    {
        return currVal;
    }

    //sets data
    public void setData(T data)
    {
        this.currVal = data;
    }

    /* Method that messes around eyeyey
     *
     */
    public TrieNode<T> getChild(char letter)
    {

        if(!(Character.isLetter(letter))) // filter to catch non-chars
        {
            return null;
        }
        else //otherwise it's not a charecter that needs to be stopped, but could be upper
        {
            letter = Character.toLowerCase(letter); // makes it lower case

            if((letter < 'a') || (letter > 'z'))
            {
                return null;
            }

        }


        int index = letter - 'a';

        // If this slot is empty, make a new node
        if (childs[index] == null)
        {
            childs[index] = new TrieNode<T>();
        }

        // Return the TrieNode stored here
        return childs[index];
    }

     /* Method that messes around eyeyey
     * - rec
     */
    public int getTreeSize()
    {
        int size = 1; // counting this node

        // loop through every child
        for (int i = 0; i < childs.length; i++)
        {
            if (childs[i] != null) //base case: the child is null
            {
                size += childs[i].getTreeSize(); // recursively add subtree size
            }
        }

        return size; // in which case return all up to that point

    }





}
