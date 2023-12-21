package webmobileshop.RanDom;

import java.util.List;

public class CustomValidationException extends RuntimeException {
    private final List<String> errors;

    public CustomValidationException(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getErrors() {
        return errors;
    }
}
