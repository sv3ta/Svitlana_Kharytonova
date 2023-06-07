package ua.home.task5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task5 {
    private static String meeting(String s) {
        String[] strings = s.split(";");
        List<String> list = new ArrayList<>();
        Arrays.stream(strings).forEach(e -> {
            String[] s2 = e.split(":");
            list.add("(" + s2[1].toUpperCase() + ", " + s2[0].toUpperCase() + ")");
        });
        return list.stream().sorted().collect(Collectors.joining(""));
    }

    public static void main(String[] args) {
        String s = "Fred:Corwill;Wilfred:Corwill;Barney:Tornbull;Betty:Tornbull;Bjon:Tornbull;Raphael:Corwill;Alfred:Corwill";
        System.out.println(meeting(s));
    }
}

