package operators;

public class CalculatorImpl implements Calculator {

    @Override
    public int minus(int firstValue, int secondValue) {
        return firstValue + convertValueToMinus(secondValue);
    }

    @Override
    public int multiply(int firstValue, int secondValue) {
        if (firstValue < secondValue) {
            return multiply(secondValue, firstValue);
        }
        int sum = 0;
        for (int i = abs(secondValue); i > 0; i--) {
            sum += firstValue;
        }
        if (secondValue < 0) {
            sum = convertValueToMinus(sum);
        }
        return sum;
    }

    @Override
    public int divide(int firstValue, int secondValue) throws Exception {
        if ( secondValue == 0) {
            throw new Exception("Cant divide");
        }
        int absFirstValue = abs(firstValue);
        int absSecondValue = abs(secondValue);

        int product = 0;
        int x = 0;
        while (product + absSecondValue <= absFirstValue) {
            product += absSecondValue;
            x++;
        }

        if ((firstValue < 0 && secondValue < 0) || (firstValue > 0 && secondValue > 0)) {
            return x;
        } else {
            return convertValueToMinus(x);
        }
    }

    private int convertValueToMinus(int value) {
        int minusValue = 0;
        int buf = value < 0 ? 1 : -1;
        while (value != 0) {
            value += buf;
            minusValue += buf;
        }
        return minusValue;
    }

    private int abs(int a) {
        if (a < 0) {
            return convertValueToMinus(a);
        } else {
            return a;
        }
    }
}
