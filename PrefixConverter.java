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
        String result = "";

        // find the parentheses
        int start = infix.indexOf("(");
        int end = infix.indexOf(")");
        String paren = infix.substring(start + 1, end);
        
        // find index of operator
        int i = -1;
        for (String op: this.ops) {
            i = paren.indexOf(op);
            if (i != -1) {
                // operator found
                break;
            }
        }

        // pull out operator , opperand 1, then opperand 2
        result = result + paren.substring(i, i+1) + " " + paren.substring(0, i) + " " + paren.substring(i + 1);

        // find where remaining values are
        if (start == 0) {
            // parentheses started at index 0
            // remaining is after closing parentheses
            infix = infix.substring(end + 1);
        } else {
            infix = infix.substring(0, start);
        }

        // seperate remaining values
        // find index of operator
        i = -1;
        for (String op: this.ops) {
            i = infix.indexOf(op);
            if (i != -1) {
                // operator found
                break;
            }
        }

        // pull out operator then opperand
        if (i == 0) {
            result = infix.substring(i, i+1) + " " + infix.substring(i+1) + " " + result;
        } else {
            result = infix.substring(i, i+1) + " " + infix.substring(0, i) + " " + result;
        }

        return result;
    }
}