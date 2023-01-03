
public class DetectCapital {
    public static boolean detectCapitalUse(String word) {
        String regex = "^([A-Z]+|[a-z]+|[A-Z][a-z]*)$";
        return (word.matches(regex));
    }

    public static void main(String[] args) {
        String s = "FlaG";
        System.out.println(detectCapitalUse(s));
    }

}
