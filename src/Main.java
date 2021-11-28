import find_number.FindNumber;
import logger.MyLogger;
import logger.MyLoggerImpl;
import operators.Calculator;
import operators.CalculatorImpl;


public class Main {

    public static void main(String[] args) {
        //1
        //Асбтрактное решение логгера
        MyLogger logger = new MyLoggerImpl();

        //2
        //Возьмем 2 грузовика, если они начнут одновременно, тогда проехав 50км можно будет дозаправить
        // второй и он проедет еще 100км, таким образом омжно проехать 150
        // в случае с 50 грузовиками это ~450 км
        // Общая формула 1/1 + 1/2 + 1/N
        System.out.println("case 2");
        double vehicles = 50;
        double range = 100;
        double distance = 0;
        while (vehicles > 0) {
            distance += range / vehicles;
            vehicles--;
        }
        System.out.println("distance = " + distance);

        System.out.println("case 3");
        //3
        Calculator calculator = new CalculatorImpl();
        int firstValue = 10;
        int secondValue = 10;
        System.out.println(firstValue + "-" + secondValue + "=" + calculator.minus(firstValue, secondValue));
        System.out.println(firstValue + "*" + secondValue + "=" + calculator.multiply(firstValue, secondValue));
        try {
            System.out.println(firstValue + "/" + secondValue + "=" + calculator.divide(firstValue, secondValue));
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("case 4");
        //4
        FindNumber findNumber = new FindNumber();
        System.out.println(findNumber.getSum("src/promteh.txt"));
    }

}
