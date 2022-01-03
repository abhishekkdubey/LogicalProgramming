package com.example.algorithm;

import kotlin.Triple;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class ActivitySelectionProblemJava {


    public static void main(String[] args) {
        Triple<String, Integer, Integer> tp1 = new Triple("A1", 0, 6);
        Triple<String, Integer, Integer> tp2 = new Triple("A2", 3, 4);
        Triple<String, Integer, Integer> tp3 = new Triple("A3", 1, 2);
        Triple<String, Integer, Integer> tp4 = new Triple("A4", 5, 8);
        Triple<String, Integer, Integer> tp5 = new Triple("A5", 5, 7);
        Triple<String, Integer, Integer> tp6 = new Triple("A6", 8, 9);
        Triple<String, Integer, Integer>[] arr = new Triple[]{tp1, tp2, tp3, tp4, tp5, tp6};
        for (Triple<String, Integer, Integer> t : arr
        ) {
            System.out.println("[" + t.getFirst() + ", " + t.getSecond() + ", " + t.getThird() + "]");
        }

        System.out.println("==================");
        System.out.println(new ActivitySelectionProblemJava().solution(arr));
    }


    private String solution(Triple<String, Integer, Integer>[] arr) {
        List<Triple<String, Integer, Integer>> list = Arrays.asList(arr);
        list.sort(comparator);
        for (Triple<String, Integer, Integer> t : list
        ) {
            System.out.println("[" + t.getFirst() + ", " + t.getSecond() + ", " + t.getThird() + "]");
        }

        StringBuilder solution = new StringBuilder();
        solution.append(list.get(0).getFirst()).append(", ");
        Triple<String, Integer, Integer> tp = list.get(0);


        for (int i = 1; i < list.size(); i++) {

            if (list.get(i).getSecond() >= tp.getThird()) {
                tp = list.get(i);
                solution.append(tp.getFirst()).append(", ");
            }
        }

        return solution.toString();
    }

    public Comparator<Triple<String, Integer, Integer>> comparator = (o1, o2) -> {
        if (o1.getThird() < o2.getThird()) {
            return -1;
        } else if (Objects.equals(o1.getThird(), o2.getThird())) {
            return 0;
        } else {
            return 1;
        }
    };


}
