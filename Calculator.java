import java.lang.*;
import java.util.*;

public class Calculator {
  /*Evaluate a postfix expression stored in s.
   *Assume valid postfix notation, separated by spaces.
   */
  public static double eval(String s){
    MyDeque<Double> deque = new MyDeque<>();
    String[] tokens = s.split();
    for (int i = 0; i < tokens.length; i++) {
      if (tokens[i].equals("+")) {
        deque.addLast(deque.removeLast() + deque.removeLast());
      }
      if (tokens[i].equals("-")) {
        deque.addLast(-1*deque.removeLast() + deque.removeLast());
      }
      if (tokens[i].equals("*")) {
        deque.addLast(deque.removeLast() * deque.removeLast());
      }
      if (tokens[i].equals("/")) {
        deque.addLast(1/deque.removeLast() * deque.removeLast());
      }
      if (tokens[i].equals("%")) {
        Double y = deque.removeLast();
        Double x = deque.removeLast();
        deque.addLast(x % y);
      }
      else {
        deque.addLast(Double.parseDouble(tokens[i]));
      }
    }
    return deque.removeLast();
  }
}
