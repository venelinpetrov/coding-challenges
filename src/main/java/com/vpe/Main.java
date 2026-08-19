package com.vpe;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // var shortener = new URLShortener();

        // var code = shortener.shorten("https://google.com");
        // System.out.println(code);

        // var url = shortener.restore(code);
        // System.out.println(url);


        // var classrooms = new Classrooms();

        // var count = classrooms.getRoomsCount(List.of(List.of(30, 75), List.of(0, 50), List.of(60, 150)));
        // System.out.println("room count: " + count);

        // count = classrooms.getRoomsCount(List.of());
        // System.out.println("room count: " + count);

        // count = classrooms.getRoomsCount(List.of(List.of(10, 40), List.of(20, 50), List.of(30, 150)));
        // System.out.println("room count: " + count);

        // count = classrooms.getRoomsCount(List.of(List.of(10, 40), List.of(20, 50), List.of(30, 150), List.of(45, 60)));
        // System.out.println("room count: " + count);


        // var tree = new BinaryExpressionTree();
        // tree.root("*",
        //     tree.create("+",
        //         tree.create("3", null, null),
        //         tree.create("2", null, null)),
        //     tree.create("+",
        //         tree.create("4", null, null),
        //         tree.create("5", null, null)
        //     )
        // );
        // System.out.println(tree.calc());

        int maxProfit = MaxProfit.getMaxProfit2(new int[] { 9, 11, 8, 5, 7, 10 });
        System.out.println(maxProfit);
    }
}