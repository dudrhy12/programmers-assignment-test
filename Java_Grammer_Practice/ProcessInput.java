
public class Main {

    public static String parseNumber(String input) {
        if (input == null || input.isEmpty()){
            return "잘못된 입력";
        }
        try {
            int number = Integer.parseInt(input);
            return String.valueOf(number);
        } catch (NumberFormatException e) {
            return "숫자 형식 오류";
        }


    }

    public static void main(String[] args) {
        System.out.println(parseNumber("123"));
        System.out.println(parseNumber("abc"));
        System.out.println(parseNumber("  "));
        System.out.println(parseNumber(null));
    }
}
