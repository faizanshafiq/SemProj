
public class BasicJava2 {
     
    public static boolean match(char lowerCaseChar, char upperCaseChar) {
        boolean matchingChars = true;
        matchingChars = matchingChars && 'a' <= lowerCaseChar && lowerCaseChar <= 'z';
        matchingChars = matchingChars && 'A' <= upperCaseChar && upperCaseChar <= 'Z';
        matchingChars = matchingChars && (lowerCaseChar - upperCaseChar) == ('a' - 'A');
        return matchingChars;
    }
     
    public static long ceiling(double num){
        long floor = (long)num;
        if (floor < num){
            return floor + 1;
        } else {
            return floor;
        }
    }
     
    public static int count(String str, String chars) {
        int counter = 0;
        for (int index = 0; index < str.length(); index++) {
            char current = str.charAt(index);
            if (chars.contains(current + "")) {
                counter++;
            }
        }
        return counter;
    }
     
    public static int addHexDigits(int num){
        int added = 0;
        int rest = num;
        while (rest > 0) {
            added += rest%16;
            rest = rest/16;
        }
        return added;
    }
}