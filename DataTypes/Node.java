
public class Node <T>
{
    private T data;
    private Node<T> next;

    //constructor that stores data, and makes next null (last one)
    public Node(T data)
    {
        this.data = data;
        next = null;
    }

//setters
    //sets next (if adding at end of ADT)
    public void setNext(Node<T> next)
    {
        this.next = next;
    }

    //sets dat
    public void setData(T data)
    {
        this.data = data;
    }

//getters

    public Node<T> getNext()
    {
        return next;
    }
    public T getData()
    {
        return data;
    }

}
