package main.primitives;

public class E_ChangeTheBase {
    public static void main(String[] args) {
        // change the base value
        // Ex: 12 in base 10 is equal to 1100 in base 2
        // Ex: 11100 in base2 is equal to 1C in base 16 (hexa)
        String str = "11100";
        int fromBase = 2;
        int toBase = 16;
        System.out.println(changeBase(str, fromBase, toBase));
    }

    private static String changeBase(String str, int fromBase, int toBase) {
        if (str.startsWith("-")) {  // ignoring everything is it is negative
            return "";
        }

        int intResult = 0;   // first lets convert everything to decimal (base 10), and then convert back to required base
        int maxPower = str.length() - 1;    // while calculating int value, we need to power the base
        for (int i = 0; i < str.length(); i++) {
            int positionPower = maxPower - i;   // right to left
            int placeValue = charToPlaceValue(str.charAt(i));
            // 111 in base 2 is equal to 1x2^2 + 1x2^1 + 1x2^0
            intResult = (int) (intResult + (placeValue * Math.pow(fromBase, positionPower)));
        }
        // convert this integer to required base now
        return integerToToBase(intResult, toBase);
    }

    private static int charToPlaceValue(char c) {
        boolean isDigit = Character.isDigit(c);
        return isDigit ? (c - '0') : (c - 'A' + 10);    // calculating the numeric value from char
    }

    private static String integerToToBase(int intResult, int toBase) {
        if (intResult == 0) {
            return "";
        }
        int lsd = intResult % toBase;
        char c = placeValueToChar(lsd); // calculating the char value from numeric

        // 12 with base 10 will be converted to 1100 in base 2
        // 12 % 2 = 0 then 12 / 2 = 6
        // 6 % 2 = 0 then 6 / 2 = 3
        // 3 % 2 = 1 then 3 / 2 = 1
        // 1 % 2 = 1 then 1 / 2 = 0

        return integerToToBase(intResult / toBase, toBase) + c; // string concatenation
    }

    private static char placeValueToChar(int v) {
        return (char) ((v >= 10) ? ('A' + v - 10) : ('0' + v));
    }
}
