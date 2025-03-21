package org.example;

import org.example.model.Complex;
import org.example.model.List;

public class App {

    public static void main(String[] args) {
        Complex complex = new Complex(0.5, 1);
        System.out.println(complex.plus(new Complex(0.5, 3)));
    }

}
