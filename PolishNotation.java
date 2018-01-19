public class PolishNotation {
    public static void main(String[] args) {
        PrefixConverter preConverter = new PrefixConverter();
        for (int i = 0; i < preConverter.infixValues.length; i++) {
            String infix = preConverter.infixValues[i];
            String prefixSolution = preConverter.prefixValues[i];
            String prefix = preConverter.convert(infix);
            System.out.println("******************************");
            System.out.println("Infix Value : " + infix);
            System.out.println("Prefix Value: " + prefixSolution);
            System.out.println("Your Answer : " + prefix);

        }
    }
}