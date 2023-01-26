import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int userInput = scanner.nextInt();
        StepTracker stepTracker = new StepTracker();

        while (userInput != 0) {
            switch (userInput) {
                case 1:
                    stepTracker.saveSteps(scanner);
                    break;
                case 2:
                    int month = Chat.Ask(scanner, "Введите номер месяца начиная с 0:", x -> Validator.checkMonth(x));
                    printStat(stepTracker, month);
                    break;
                case 3:
                    stepTracker.setTargetSteps(scanner);
                    break;
                default:
                    System.out.println("Такой команды не существует.");
            }
            printMenu(); // печатаем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt(); // повторное считывание данных от пользователя
        }
        System.out.println("Программа завершена.");
    }

    private static void printMenu() {
        System.out.println("Что вы хотите сделать?");

        System.out.println("1. Ввести количество шагов за определённый день;");
        System.out.println("2. Напечатать статистику за определённый месяц;");
        System.out.println("3. Изменить цель по количеству шагов в день;");
        System.out.println("0. Выйти из приложения.");
    }

    private static void printStat(StepTracker stepTracker, int month) {
        System.out.println("1. Количество пройденных шагов по дням: " + stepTracker.getStatByDay(month));
        System.out.println("2. Общее количество шагов: " + stepTracker.getTotalSteps(month));
        System.out.println("3. Максимальное пройденное количество шагов в месяце: " + stepTracker.getMaxSteps(month));
        System.out.println("4. Среднее количество шагов: " + stepTracker.getAverageSteps(month));
        System.out.println("5. Пройденная дистанция (в км): " + stepTracker.getDistance(month));
        System.out.println("6. Количество сожжённых килокалорий: " + stepTracker.getBurnedCalories(month));
        System.out.println("7. Лучшая серия: : " + stepTracker.getBestSeries(month));
    }
}
