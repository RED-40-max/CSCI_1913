/* Computer lab 11: Mapping key-value pairs (ADT)
 *      by: Nikki Som, Shawn Grove, Leonard Jin
 */

public class Map <Key, Value>
{
    private Key[] keys;
    private Value[] values;
    private int count;

    /* Constructor
     *    input: length
     *      --> If the user gives a non-positive length, default to 1.
     *      --> keys, values, initlized with length (via casting array object)
     *      -->  counts is inilized to 0
     */
    public Map(int length)
    {
        if (length <= 0)
        length = 1;

        Object[] tempKeys = new Object[length];
        Object[] tempVals = new Object[length];

        this.keys = (Key[]) tempKeys;
        this.values = (Value[]) tempVals;
        this.count = 0;

    }

    /* Method that compares two keys for equality.
     *    - If exactly one is null --> not equal
     *    - If both null --> equal
     *    - Otherwise --> use .equals()
     */
    private boolean isEqual(Key leftKey, Key rightKey)
    {
        if ((leftKey == null) ^ (rightKey == null)) //exclusivly one of the keys are null
        {
            return false;
        }
        else if ((leftKey == null) && (rightKey == null)) //if both are null
        {
            return true;
        }
        return leftKey.equals(rightKey); // none of the keys are null
    }

    /* Method that returns index in the key array
     *      --> if exists, the given key is stored
     *      --> -otherwise, returns -1 .
     */
    private int getIndex(Key key)
    {
        for(int i = 0; i < count; i++)
        {
            if(isEqual(key, keys[i]))
            {
                return i;
            }
        }
        return -1;
    }

    /* Method that retrieves value's key
     *      --> Returns null if the key does not exist.
     */
    public Value get(Key key)
    {
        if(getIndex(key) == -1)
        {
            return null;
        }

        return values[getIndex(key)];

    }
    /* Method that checks if map has a key
     *      --> loops thorught and compares isEqual
     *      --> if key is found, return, otherwise it is false
     */
    public boolean containsKey(Key key)
    {

        for(int i = 0; i < count; i++)
        {
            if(isEqual(keys[i], key))
            {
                return true;
            }
        }
        return false;
    }

    /* Method that inserts / updates a key-value pair
     *      If key already exists --> update value
     *      else:
     *          -> grow array if full
     *          -> add new key-value at the end
     */
    public void put(Key key, Value value)
    {
        if (containsKey(key)) //if that element is at some index keys, chnage the element at the same index in values
        {
            values[getIndex(key)] = value;
        }
        else  //otherwise add key to keys annd add value to values at same index
        {
            //if both arrays are full, expand the array w/ procedure we saw in lecutre.
            if(keys.length == count)
            {
                int oldCount = count;

                Key[] oldKeys = this.keys;
                Value[] oldVals = this.values;

                Object[] tempKeys = new Object[2*oldCount];
                Object[] tempVals = new Object[2*oldCount];

                this.keys = (Key[]) tempKeys;
                this.values = (Value[]) tempVals;
                this.count = 0 ;

                for(int i = 0; i < oldCount ; i++ )
                {
                    keys[i] = oldKeys[i];
                    values[i] = oldVals[i];
                    count ++;
                }

            }

            //then add it to the same index by finding next avalible spot

            keys[count] = key;
            values[count] = value;
            count++;

        }
    }

    /* Method that returns the number of key-value pairs stored
     */
    public int size()
    {
        return count;

    }
}
