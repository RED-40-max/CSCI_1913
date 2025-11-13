package DataTypes;

public class LinkedList<T>
{
    private Node<T> head;
    private Node<T> currNode;
    private T data;

    public LinkedList()
    {
        head = null;
    }

    public void insert(Node)
    {
        if(head == null)
        {
            head = node;
        }
        else
        {
            Node<T> currNode = head;

            while(currNode.getNext() != null)
            {
                currNode = currNode.getNext();
            }
            currNode.setNext(node);
        }

    }

    public String toString()
    {
        String result = "";
        Node<T> currNode = head;

        while(currNode != null)
        {
            result += currNode.getData() + " ";
            currNode = currNode.getNext();
        }

        return result;

    }

    public void push(Node<T> node)
    {
        if (head == null)
        {
            head = node;
        }
        else
        {
          node.setNext(head);
          head = node;
        }
    }

    public boolean search(T data)
    {
        Node<T> currNode = head;
        while (currNode != null)
        {
          if (currNode.getData().equals(data))
          {
            return true;
          }

          currNode = currNode.getNext();
        }

        return false;
    }

    public Node<T> remove(T data)
    {
        Node<T> currNode = head;
        Node<T> previous = null;
        while (currNode != null)
        {
          if (currNode.getData().equals(data))
          {
            if (previous != null)
            {
              previous.setNext(currNode.getNext());
            }
            else
            {
              head = head.getNext();
            }
            return currNode;
          }
          else
          {
            previous = currNode;
            currNode = currNode.getNext();
          }
        }
        return null;
    }

    public Node<T> pop()
    {
        Node<T> node = null;
        if (head != null)
        {
          node = head;
          head = head.getNext();
        }
        return node;
    }

    public Node<T> pop(int n)
    {
        if (n >= 0 && n < length)
        {
          Node<T> current = head;
          Node<T> previous = null;

          for (int i = 0; i < n; i++)
          {
            previous = current;
            current = current.getNext();
          }

          if (previous == null)
          {
            return pop();
          }
          else
          {
            previous.setNext(current.getNext());
          }

          length--;

          return current;
        }
        return null;

    }



}
