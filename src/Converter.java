public class Converter {
    public final static double STEP_TO_KILOMETERS = 75.0 / 100 / 1000;
    public final static double STEP_TO_KILOCALORIES = 50.0 / 1000;

    public static double StepsToKilometers(int steps) {
        return steps * STEP_TO_KILOMETERS;
    }

    public static double StepsToKilocalories(int steps) {
        return steps * STEP_TO_KILOCALORIES;
    }
}