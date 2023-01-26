public class Validator {
    public static Result checkMonth(int month) {
        boolean isValid = month >= 0 && month <= 11;
        String message = "";
        if (!isValid) {
            message = "Значение должно быть больше или равно нуля и меньше 12.";
        }
        return new Result(isValid, message);
    }

    public static Result checkSteps(int steps) {
        boolean isValid = steps >= 0;
        String message = "";
        if (!isValid) {
            message = "Значение должно быть больше или равно нуля.";
        }
        return new Result(isValid, message);
    }

    public static Result checkDay(int day) {
        boolean isValid = day >= 0 && day <= 29;
        String message = "";
        if (!isValid) {
            message = "Значение должно быть больше или равно нуля и меньше 30.";
        }
        return new Result(isValid, message);
    }

    static class Result {
        boolean isValid;
        String message;

        Result(boolean isValid, String message) {
            this.isValid = isValid;
            this.message = message;
        }
    }
}
