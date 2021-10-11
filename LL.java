import java.util.NoSuchElementException;

public class LL 
{
    private Node head;
    private Node tail;
    private int size;

    public void addFront(int d)
    {
        if (head==null)
        {
            head = new Node(d, null);
            tail=head;
        }
        else
        {
            head = new Node(d, head);
        }
        size++;
    }

    public void addBack(int d)
    {
        if(head==null)
        {
            head = new Node(d, null);
            tail = head;
        }
        else
        {
            tail.next = new Node(d, null);
            tail = tail.next;
        }
        size++;
    }

    public int removeFront()
    {
        int olddata;
        if(head == null)
        {
            throw new NoSuchElementException();
        }
        else if (head == tail)
        {
            olddata = head.data;
            head = tail =null;
        }
        else
        {
            olddata = head.data;
            head = head.next; 
        }
        size--;
        return olddata;
    }

    public int removeBack()
    {
        int olddata;
        if(head == null)
        {
            throw new NoSuchElementException();
        }
        else if (head == tail)
        {
            olddata = head.data;
            head = tail =null;
        }
        else
        {
            Node p = head;
            while (p.next != tail)
                p=p.next;
            olddata = tail.data;
            p.next = null;
            tail=p;
        }
        size--;
        return olddata;
    }

    public int get(int i)
    {
        if( i<0 || i>size-1)
            throw new ArrayIndexOutOfBoundsException("index " + i + " size " + size);
        else
        {
            Node p = head;
            while(i != 0)
            {
                p=p.next;
                i--;
            }
            return p.data;
        }
    }

    public void reverse()
    {
        if (head == null || head ==tail)
            return;
        Node p1 = null;
        Node p2 = head;
        Node p3 = head.next;

        while (p3 != null)
        {
            p2.next = p1;
            p1 = p2;
            p2 = p3;
            p3 = p3.next;
        }

        p2.next = p1;

        Node temp = head;
        head = tail;
        tail = temp;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node p =head;
        while(p != null)
        {
            sb.append(p.data + " ");
            p=p.next;
        }
        sb.append("]");
        return new String(sb);
    }

    private static class Node
    {
        int data;
        Node next;
        Node(int d, Node n)
        {
            data = d;
            next = n;
        }
    }

    public static void main (String args[])
    {
        LL list = new LL();
        for (int i=0; i<5; i++)
            list.addBack(i);
        
        System.out.println(list);
        list.reverse();
        for (int i=0; i<5; i++)
            System.out.print (list.get(i) + " ");

        /*
        This is for adding elements at the front of the list
        for (int i=0; i<5; i++)
            list.addFront(i);

        System.out.println(list);
        */

        /*
        This is for viewing reverse function in LinkedList
        list.reverse();
        System.out.println(list);
        */

        /* This is  for viewing removeBack and removeFront

        list.removeBack();
        list.removeFront();
        System.out.println(list);
        */
        // list.reverse();
        // print(list);
    }
}
