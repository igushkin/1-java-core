import java.util.Arrays;
import java.util.Scanner;

public class StepTracker {
    private int targetStepsPerDay;
    private MonthData[] monthToData;

    StepTracker() {
        targetStepsPerDay = 10000;
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void saveSteps(Scanner scanner) {
        int month = Chat.Ask(scanner, "Введите номер месяца начиная с 0:", x -> Validator.checkMonth(x));
        int day = Chat.Ask(scanner, "Введите номер дня начиная с 0:", x -> Validator.checkDay(x));
        int steps = Chat.Ask(scanner, "Введите количество шагов:", x -> Validator.checkSteps(x));
        monthToData[month].days[day] = steps;
        System.out.println("Сохранено.");
    }

    public void setTargetSteps(Scanner scanner) {
        int steps = Chat.Ask(scanner, "Введите новую цель по шагам:", x -> Validator.checkSteps(x));
        targetStepsPerDay = steps;
        System.out.println("Сохранено");
    }

    public String getStatByDay(int month) {
        StringBuilder stat = new StringBuilder();
        for (int x = 0; x < monthToData[0].days.length; x++) {
            stat.append(x + 1 + " день: " + monthToData[month].days[x]);
            if (x + 1 < monthToData[0].days.length) {
                stat.append(", ");
            }
        }
        return stat.toString();
    }

    public int getTotalSteps(int month) {
        return Arrays.stream(monthToData[month].days).sum();
    }

    public int getMaxSteps(int month) {
        return Arrays.stream(monthToData[month].days).max().getAsInt();
    }

    public double getAverageSteps(int month) {
        return getTotalSteps(month) / 30.0;
    }

    public int getBestSeries(int month) {
        int bestSeries = 0;
        int challenger = 0;

        for (int x = 0; x < monthToData[month].days.length; x++) {
            if (monthToData[month].days[x] >= targetStepsPerDay){
                challenger++;
            }
            else{
                challenger = 0;
            }
            if (challenger > bestSeries){
                bestSeries = challenger;
            }
        }
        return bestSeries;
    }

    public double getDistance(int month) {
        int steps = getTotalSteps(month);
        return Converter.StepsToKilometers(steps);
    }

    public double getBurnedCalories(int month) {
        int steps = getTotalSteps(month);
        return Converter.StepsToKilocalories(steps);
    }

    class MonthData {
        public int[] days;

        MonthData() {
            days = new int[30];
        }

    }
}
