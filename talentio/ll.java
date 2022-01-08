import java.util.*;

class Node{
    int data;
    Node next;
    public Node(int data)
    {
        this.data = data;
    }
}


public class Main
{
public static Node h=null,curr=null;
public static void insert(int data)
{
    Node temp = new Node(data);
    temp.next = null;
    if(h==null)
        h = temp;
    else
        curr.next = temp;
    curr = temp;
}

public static Node sort(Node h)
{
    if(h==null || h.next==null)
        return h;
    Node prev=null,slow=h,fast=h;
    while(fast!=null && fast.next!=null)
    {
        prev = slow;
        slow = slow.next;
        fast = fast.next.next;
    }
    prev.next = null;
    Node l1 = sort(h);
    Node l2 = sort(slow);
    
    return merge(l1,l2);
}

public static Node merge(Node l1,Node l2)
{
    Node h = new Node(0),p=h;
    while(l1!=null && l2!=null)
    {
        if(l1.data<l2.data)
        {
            p.next = l1;
            l1 = l1.next;
        }
        else
        {
            p.next = l2;
            l2 = l2.next;
        }
        p = p.next;
    }
    if(l1!=null)
        p.next = l1;
    if(l2!=null)
        p.next = l2;
    return h.next;
}

public static void print(Node h)
{
    for(Node p = h;p!=null;p = p.next)
        System.out.print(p.data+" ");
    System.out.println();
}

 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     int n,t;
     n = sc.nextInt();
     while (--n>-1)
     {
         t = sc.nextInt();
         while (--t > -1)
             insert(sc.nextInt());
     }
     print(sort(h));
 }
}