/* DONE CODE (do comments)
 * Project 3: Word Scramble
 *   Author: Roshinikitha Somasundram
 *   Class summary: Trie
 *
 *
 */


 public class Trie <T>
{
    private TrieNode<T> root; //private generic root

    /* Method that messes around eyeyey
     *
     */
    public Trie()
    {
        this.root = new TrieNode<T>(); //intilizes root to the given node
    }

    /* Method that messes around eyeyey
     *
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

    /* Method that messes around eyeyey
     *
     */
    public T get(String s)
    {
        return getNode(s).getData();
    }

    /* Method that messes around eyeyey
     *
     */
    public void put(String s, T value)
    {
        getNode(s).setData(value);
    }


}
