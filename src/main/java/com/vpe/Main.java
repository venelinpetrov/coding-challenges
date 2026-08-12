package com.vpe;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var shortener = new URLShortener();

        var code = shortener.shorten("https://google.com");
        System.out.println(code);

        var url = shortener.restore(code);
        System.out.println(url);
    }
}