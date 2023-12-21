package webmobileshop.RanDom;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class passwordcheckd {

    public  static  boolean containsWhitespace (String password){
        return password.contains(" ");
    }
    public  static int containsleght(String password){
        return password.length();
    }
    public static boolean checkDuplicates(String input) {
        // Sử dụng Set để kiểm tra trùng lặp
        Set<Character> charSet = new HashSet<>();

        for (char ch : input.toCharArray()) {
            // Nếu ký tự đã tồn tại trong Set, có nghĩa là có trùng lặp
            if (!charSet.add(ch)) {
                return true;
            }
        }

        // Không có trùng lặp
        return false;
    }

    // Custom exception class
    public class CustomValidationException extends RuntimeException {
        private final Map<String, String> errors;

        public CustomValidationException(Map<String, String> errors) {
            this.errors = errors;
        }

        public Map<String, String> getErrors() {
            return errors;
        }
    }
}
