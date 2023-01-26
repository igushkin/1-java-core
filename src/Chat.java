import java.util.Scanner;
import java.util.function.Function;

public class Chat {
    public static int Ask(Scanner scanner, String question, Function<Integer, Validator.Result> validator) {
        Validator.Result result;
        int response;
        do {
            System.out.println(question);
            response = scanner.nextInt();
            result = validator.apply(response);
            if (!result.isValid) {
                System.out.println(result.message);
            }
        } while (!result.isValid);
        return response;
    }
}
