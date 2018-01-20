import java.util.Deque;
import java.util.ArrayDeque;

public class PrefixConverter {
    public String[] infixValues;
    public String[] prefixValues;
    private String[] ops;

    public PrefixConverter() {
        this.infixValues = new String[] {
            "3*(1+2)",
            "(3+5)*2",
            "(8+2)*(3+4)",
            "4/(1+1)",
            "(3+1)/2"
        };
        this.prefixValues = new String[] {
            "* 3 + 1 2",
            "* + 3 5 2",
            "* + 8 2 + 3 4",
            "/ 4 + 1 1",
            "/ + 3 1 2"
        };
        this.ops = new String[] {"*", "/", "+", "-"};
    }

    public String convert(String infix) {
        // Use deques as LIFO stacks
        // we will push and pop from the beginning of the stack
        Deque<String> result = new ArrayDeque<String>();
        Deque<String> operators = new ArrayDeque<String>();
        // iterate over the string in reverse
        for (int i = infix.length() - 1; i >= 0; i--) {
            String item = Character.toString(infix.charAt(i));
            if (item.equals(")")) {
                // Close Parentheses
                operators.addFirst(item);
            } else if (item.equals("(")) {
                // Open Parentheses
                boolean searching = true;
                while (searching) {
                    String pop = operators.removeFirst();
                    if (pop.equals(")")) {
                        searching = false;
                    } else {
                        result.addFirst(pop);
                    }
                }
            } else if (item.equals("*") || item.equals("/") || item.equals("+") || item.equals("-")) {
                // Operator
                operators.addFirst(item);
            } else {
                // Operand
                result.addFirst(item);
            }
        }
        // push any remaining operators to the result
        while (operators.peekFirst() != null) {
            result.addFirst(operators.removeFirst());
        }
        String prefix = "";
        // the result is stacked
        while (result.peekFirst() != null) {
            prefix = prefix + result.removeFirst() + " ";
        }
        return prefix;
    }
}