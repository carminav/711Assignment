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

public class MyStack
{
   private ListNode LastNode;
   private ListNode FirstNode;
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
      if (FirstNode == null)
      {
         FirstNode = LastNode = new ListNode(n);
      }

      else
      {
         LastNode.nextNode = new ListNode(n);
         LastNode = LastNode.nextNode;
      }
   }

   /*
    * POP Removes the int at the top of the stack and returns it.
    */
   public int pop()
   {
      if (FirstNode == null)
      {
         return 0;
      }

      int temp = LastNode.data;
      if (FirstNode == LastNode)
      {
         FirstNode = LastNode = null;
      } else
      {
         ListNode CurrentNode = FirstNode;
         while (CurrentNode.nextNode != LastNode)
         {
            CurrentNode = CurrentNode.nextNode;
         }
         LastNode = CurrentNode;
         CurrentNode.nextNode = null;
      }
      return temp;

   }

   /*
    * PEEK Returns the int at the top of the stack but does not remove it.
    */
   public int peek()

   {
      int peekdata;
      if (LastNode == null)
      {
         peekdata = 0;
      }

      else
      {
         peekdata = LastNode.data;
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

      // pop
      System.out.println("Popped this from stack:"+s.pop());

      // peek
      System.out.println("Peek top of stack:"+ s.peek());

      // pop
      System.out.println("Popped this from stack:"+s.pop());

      // peek
      System.out.println("Peek top of stack:"+s.peek());
   }
}
