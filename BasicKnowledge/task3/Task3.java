package ua.home.task3;

public class Task3 {
    static int sum;

    private static int digitalRoot(int a) {
        sum = 0;
        while (a != 0) {
            sum += (a % 10);
            a = a / 10;
        }
        if (sum / 10 > 0)
            digitalRoot(sum);
        if (sum / 10 == 0)
            return sum;
        else return 0;
    }

    public static void main(String[] args) {
        System.out.println(digitalRoot(132189));
    }
}
