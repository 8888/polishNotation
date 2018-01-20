import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;

public class PrefixConverter {
    public String[] infixValues;
    public String[] prefixValues;
    public Map<String, Integer> operatorRanks;
    public Boolean opperandSeenLast;

    public PrefixConverter() {
        this.operatorRanks = new HashMap<String, Integer>();
        this.operatorRanks.put("*", 2);
        this.operatorRanks.put("/", 2);
        this.operatorRanks.put("+", 1);
        this.operatorRanks.put("-", 1);
        // Parentheses need a value to always be less
        this.operatorRanks.put("(", 0);
        this.operatorRanks.put(")", 0);
        // used to track multi-digit ints
        this.opperandSeenLast = false;
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
                this.opperandSeenLast = false;
                operators.addFirst(item);
            } else if (item.equals("(")) {
                // Open Parentheses
                this.opperandSeenLast = false;
                boolean searching = true;
                while (searching) {
                    String pop = operators.removeFirst();
                    if (pop.equals(")")) {
                        searching = false;
                    } else {
                        result.addFirst(",");
                        result.addFirst(pop);
                    }
                }
            } else if (item.equals("*") || item.equals("/") || item.equals("+") || item.equals("-")) {
                // Operator
                this.opperandSeenLast = false;
                if (operators.peekFirst() != null && this.operatorRanks.get(item) <= this.operatorRanks.get(operators.peekFirst())) {
                    // if stack isn't empty and op in stack is same or greater
                    // add that one to the result
                    result.addFirst(",");
                    result.addFirst(operators.removeFirst());
                }
                // either way, add the new operator to the stack
                operators.addFirst(item);
            } else {
                // Operand
                if (!this.opperandSeenLast) {
                    // manage single and multi digit ints
                    result.addFirst(",");
                }
                result.addFirst(item);
                this.opperandSeenLast = true;
            }
        }
        // push any remaining operators to the result
        while (operators.peekFirst() != null) {
            result.addFirst(",");
            result.addFirst(operators.removeFirst());
        }
        String prefix = "";
        // the result is stacked
        while (result.peekFirst() != null) {
            prefix = prefix + result.removeFirst();
        }
        return prefix;
    }
}