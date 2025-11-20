/* DONE
 * Project 3: Word Scramble
 *   Author: Roshinikitha Somasundram
 *   Class Summary: TrieNode
 *      - A single node in a trie data struct.
 *      - store val and 26 children ('a'–'z').
 *      - CRUD child nodes and count size (w/ recusion)
 */



public class TrieNode <T>
{
    private T currVal; // data node
    private TrieNode<T>[] childs = new TrieNode[26];
    //private TrieNode[] childs = (TrieNode<T>[]) new TrieNode[26];


    /* Constructor
     *      --> creates a new obj
     *      --> creates 26 null children
     */
    public TrieNode()
    {
        for(int i = 0; i < 26; i++) //makes 26 nulls
        {
            this.childs[i] = null;
        }
    }

    //setter
    public void setData(T data)
    {
        this.currVal = data;
    }

    //getter
    public T getData()
    {
        return currVal;
    }

     /* Method that gets tree size
     *      -> counts by starting at this node
     *      --> loop thorught child and adds to count
     */
    public int getTreeSize()
    {
        int size = 1; // counting this node

        // loop through every child
        for (int i = 0; i < childs.length; i++)
        {
            if (childs[i] != null) //base case: the child is null
            {
                size += childs[i].getTreeSize(); // recursive case: add subtree size
            }
        }

        return size; //base case fufilled, return size

    }

    /* Method that returns the child node corresponding to the given letter.
     *      If the child not exist --> create it.
     *      If the char not valid --> returns null.
     */
    public TrieNode<T> getChild(char letter)
    {
        if(!(Character.isLetter(letter))) // filter to catch non-chars
        {
            return null;
        }
        else //otherwise it's not a char that needs to be stopped, but could be upper
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
}
