import java.util.HashMap;
import java.util.Map.Entry;

/* Assignment #1 7/11/16
 * PolynomialCalculator adds, subtracts, and finds derivatives of polynomials. 
 * Polynomials are represented by hashmaps where they key represents the 
 * power, and its corresponding value is the coefficient. For example:
 * 5x^5 - x^3 + 10
 * is represented by a hash map with key-values:
 * 5 -> 5
 * 3 -> -1 
 * 0 -> 10 
 * 
 * There are alternative ways to represent polynomials in code. 
 * One way is to use arrays, where the each index represents the power
 * and the value at that index is the coefficient. For example:
 * 5x^5 - x^3 + 10 
 * is represented by this array [10, 0, 0, -1, 0, 5]
 * 
 * The benefit of using the hash map representation instead of that of arrays is
 * that there is no wasted space. For all coefficients that have a 0 as a coefficient, 
 * there will not be an entry in the hashmap while there would be one in an array. 
 * For example, the polynomial 5x^10 + 1 is represented by an array [1, 0, 0, 0, 0, 0, 0, 0, 0, 5]
 * Notice all those unnecessary zeros, whereas a hashmap representation would simply be:
 * 10 -> 5
 * 0 -> 1
 * 
 * These are design considerations that affect memory usage. Get used to thinking about design, 
 * and time and space complexity. The second assignment after this will force you to choose what 
 * data structures to use to accomplish your task. 
 * 
 * NOTES: 
 *  - Shall you decide to make any helper methods, they MUST be private and you cannot use them in 
 *    the main method.
 *  - Notice that all methods are static. Make sure you ask me if you don't understand how 
 *    static methods are different from instance methods and how and when to use them.  
 */
public class PolynomialCalculator
{

   /*
    * TO STRING POLY *IMPLEMENT THIS FIRST* This method is for your convenience
    * so you can see your output. Given a polynomial p in hashmap
    * representation, return a string representation such that a hashmap with
    * key-value pairs: 5 -> 5 3 -> -1 0 -> 10 will return a string that looks
    * like this: "5x^5 - x^3 + 10"
    */
   public static String toStringPoly(HashMap<Integer, Integer> p)
   {

      String polytoprint = "";

      for (Entry<Integer, Integer> entry : p.entrySet())
      {
         if (entry.getKey() == 0)
         {
            polytoprint += entry.getValue();

         }

         else
         {
            polytoprint = entry.getValue() + "x^" + entry.getKey() + " + "
                  + polytoprint;
         }

      }

      return polytoprint;

   }

   /*
    * ADD Add polynomials p1 and p2, and return a new polynomial. The returned
    * answer should be simplified.
    */

   public static HashMap<Integer, Integer> add(HashMap<Integer, Integer> p1,
         HashMap<Integer, Integer> p2)
   {
      HashMap<Integer, Integer> answerhashmap = new HashMap<Integer, Integer>();
      
      answerhashmap.putAll(p1);
      
      for (int key : p2.keySet())
      {
         if (answerhashmap.containsKey(key))
         {
            answerhashmap.put(key, answerhashmap.get(key) + p2.get(key));
         }
         else
         {
            int value_p2 = p2.get(key);
            answerhashmap.put(key, value_p2);
         }
      }
      return answerhashmap;
   }

   /*
    * SUBTRACT Subtract polynomials p2 FROM p1, and return a new polynomial. The
    * returned answer should be simplified.
    */

   public static HashMap<Integer, Integer> subtract(
         HashMap<Integer, Integer> p1, HashMap<Integer, Integer> p2)
   {
      HashMap<Integer, Integer> answerhashmap = new HashMap<Integer, Integer>();
      
      answerhashmap.putAll(p1);
      
      for (int key : p2.keySet())
      {
         if (answerhashmap.containsKey(key))
         {
            answerhashmap.put(key, answerhashmap.get(key) - p2.get(key));
         }

         else
         {
            int value_p2 = p2.get(key);
            answerhashmap.put(key, value_p2);
         }
      }
      return answerhashmap;
   }

   /*
    * SUBTRACT Calculate the derivative of polynomial p and return it. The
    * returned answer should be simplified.
    */
   public static HashMap<Integer, Integer> findDerivative(
         HashMap<Integer, Integer> p)
   {
      HashMap<Integer, Integer> answerhashmap = new HashMap<Integer, Integer>();
      
      answerhashmap.putAll(p);
      
      for (int key : p.keySet())
      {
         if (key > 0)
         {
            answerhashmap.put(key - 1, answerhashmap.get(key) * key);
            answerhashmap.remove(key);
         }
      }
      return answerhashmap;
   }

   public static void main(String args[])
   {
      /* Create polynomials */
      System.out.println("Create polynomials:");
      
      // p1: 5x^5 - x^3 + 10
      HashMap<Integer, Integer> p1 = new HashMap<Integer, Integer>();
      p1.put(5, 5);
      p1.put(3, -1);
      p1.put(0, 10);
      System.out.println("p1: " + PolynomialCalculator.toStringPoly(p1));

      // p2: x^2
      HashMap<Integer, Integer> p2 = new HashMap<Integer, Integer>();
      p2.put(2, 1);
      System.out.println("p2: " + PolynomialCalculator.toStringPoly(p2));

      // p3: -x^2 + 3x - 15
      HashMap<Integer, Integer> p3 = new HashMap<Integer, Integer>();
      p3.put(2, -1);
      p3.put(1, 3);
      p3.put(0, -15);
      System.out.println("p3: " + PolynomialCalculator.toStringPoly(p3));

      // Separator
      System.out.println("-------------------");

      /* Output results of methods */
      HashMap<Integer, Integer> answer;

      // add
      answer = PolynomialCalculator.add(p1, p2);
      System.out.println(PolynomialCalculator.toStringPoly(p1) + " PLUS "
            + PolynomialCalculator.toStringPoly(p2) + " = "
            + PolynomialCalculator.toStringPoly(answer));

      // subtract
      answer = PolynomialCalculator.subtract(p3, p2);
      System.out.println(PolynomialCalculator.toStringPoly(p3) + " MINUS "
            + PolynomialCalculator.toStringPoly(p2) + " = "
            + PolynomialCalculator.toStringPoly(answer));

      // derivative
      answer = PolynomialCalculator.findDerivative(p3);
      System.out.println("dy/dx(" + PolynomialCalculator.toStringPoly(p3)
            + ") = " + PolynomialCalculator.toStringPoly(answer));

   }

}
