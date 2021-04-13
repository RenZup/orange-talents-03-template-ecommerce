package orangetalents03templateecommerce.compartilhado;

public class ErrorDto {
    private final String field;
    private final String message;

    public ErrorDto(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }


}
