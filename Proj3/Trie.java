/* DONE
 * Project 3: Word Scramble
 *   Author: Roshinikitha Somasundram
 *   Class Summary: Trie
 *      - A tree data stuct from TrieNode objs.
 *      - Stores strings by making child nodes for each char.
 *      - can do CRUD for vals with strings.
 */


 public class Trie <T>
{
    private TrieNode<T> root; //private generic root

    /* Construtor that makes the root.
     */
    public Trie()
    {
        this.root = new TrieNode<T>(); //intilizes root to the given node
    }

    //getter
    public T get(String s)
    {
        return getNode(s).getData();
    }

    //setter
    public void put(String s, T value)
    {
        getNode(s).setData(value);
    }

    /* Method that returns the TrieNode
     *      --> starts at root
     *          --> calls getChild on each char in string, and it fills in nodes
     *      (looks like)
     *          root >>> char1 >>char2 >> ... >> last char
     *      --> traces it untill the last letter is finally there
     *           --> returns the node that maps to the entire string
     */
    private TrieNode<T> getNode(String str)
    {
        TrieNode<T> nextNode = root;

        for(int i = 0; i < str.length(); i++)
        {
            nextNode = nextNode.getChild(str.charAt(i));
        }

        return nextNode;
    }


}
