/* Assignment #2 7/11/16
 * In MyStack, you will write your own stack. 
 * It will have its own push, pop, and peek methods just like a real stack. 
 * You can't use Java's library stack, since the point is to implement it from scratch.
 * 
 * How will you design MyStack?
 * What fields will MyStack have and will you use any data structures?
 * Are there considerations for time and space efficiency you can take?
 * 
 * Whatever design you choose, please write a detailed explanation why you chose it
 * versus other options you thought of. What are the benefits of it over other designs?
 * This is important since it'll help you practice coding in a smart way and it'll help
 * you articulate your ideas to interviewers. 
 * 
 * Try designing this with pen and paper first before you start to code.
 * All fields and methods you add to this file must be PRIVATE and you can only use
 * the constructor, push, pop, and peek in main. 
 * 
 * 
 * For simplicity, your stack will hold ints.
 */

/* 
 * Anshuman 07/27/16
 * 

Insertion/ Removal into a Linked List is fast - only two references have to be modified 
after locating the insertion/ removal  point, rest all existing node objects remain in 
their current location.

For sorted array, insertion & deletion in a sorted array can be time consuming - all
 the elements following the inserted or deleted element must be shifted appropriately.


Cons of LinkedList over Arrays: The elements of an array are contiguous in memory. This 
allows immediate access to any array element, because it's address can be calculated directly 
as its offset from the beginning of the array. Linked List do not afford such immediate access- 
an element can be accessed only by traversing the list from the front
 * 
 * */

public class MyStack
{
   private ListNode headNode;

   /* Do you need to initialize anything in the constructor? */
   public MyStack()
   {
      // ListNode HeadNode;
   }

   /*
    * PUSH Pushes int n to the top of the stack.
    */

   public void push(int n)
   {
      if (headNode == null)
      {
         headNode = new ListNode(n);
      } else
      {
         ListNode currentNode = headNode;

         while (currentNode.nextNode != null)
         {
            currentNode = currentNode.nextNode;
         }
         currentNode.nextNode = new ListNode(n);
         currentNode = currentNode.nextNode;
      }
   }

   /*
    * POP Removes the int at the top of the stack and returns it.
    */

   public int pop()
   {
      if (headNode == null)
      {
         return 0;
      }

      ListNode temp = null;

      ListNode CurrentNode = headNode;
      while (CurrentNode.nextNode != null)
      {
         temp = CurrentNode;
         CurrentNode = CurrentNode.nextNode;
      }
      // LastNode = CurrentNode;
      int pop_data = CurrentNode.data;
      temp.nextNode = null;

      return pop_data;

   }

   /*
    * PEEK Returns the int at the top of the stack but does not remove it.
    */

   public int peek()

   {
      int peekdata;
      if (headNode == null)
      {
         peekdata = 0;
      }

      else
      {
         ListNode currentNode = headNode;
         while (currentNode.nextNode != null)
         {
            currentNode = currentNode.nextNode;
         }
         peekdata = currentNode.data;
      }
      return peekdata;
   }

   public static void main(String[] args)
   {
      // Add anything to the main method, but you can only use
      // the constructor, push, pop, and peek methods from
      // the MyStack class here.

      // Create a new stack
      MyStack s = new MyStack();

      s.push(1);
      s.push(2);
      s.push(3);
      System.out.println("Peek top of stack:" + s.peek());
      System.out.println("Popped this from stack:" + s.pop());
      System.out.println("Popped this from stack:" + s.pop());

      System.out.println("Peek top of stack:" + s.peek());

   }
}
