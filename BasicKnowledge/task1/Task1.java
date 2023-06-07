package ua.home.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1 {

    public static List<Object> list = Arrays.asList(1, "2", "3", 7, "5", 9, "ffdbf", 15);

    public static List<Object> getIntegersFromList(List<Object> list) {
        List<Object> integerList = new ArrayList<>();

        list.forEach(element -> {
            if (element.getClass() == Integer.class) {
                integerList.add(element);
            }
        });
        return integerList;
    }

    public static void main(String[] args) {
        System.out.println(getIntegersFromList(list));
    }
}
