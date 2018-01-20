public class PolishNotation {
    public static void main(String[] args) {
        String[] infixValues = new String[] {
            "3*(1+2)",
            "(3+5)*2",
            "(8+2)*(3+4)",
            "4/(1+1)",
            "(3+1)/2",
            "3+1*2",
            "3*1+2",
            "88+5",
        };
        String[] prefixValues = new String[] {
            "*,3,+,1,2",
            "*,+,3,5,2",
            "*,+,8,2,+,3,4",
            "/,4,+,1,1",
            "/,+,3,1,2",
            "+,3,*,1,2",
            "+,*,3,1,2",
            "+,88,5"
        };
        PrefixConverter preConverter = new PrefixConverter();
        for (int i = 0; i < infixValues.length; i++) {
            String infix = infixValues[i];
            String prefixSolution = prefixValues[i];
            String prefix = preConverter.convert(infix);
            System.out.println("******************************");
            System.out.println("Infix Value : " + infix);
            System.out.println("Expected Prefix Value: " + prefixSolution);
            System.out.println("Current Prefix Output: " + prefix);
        }
    }
}