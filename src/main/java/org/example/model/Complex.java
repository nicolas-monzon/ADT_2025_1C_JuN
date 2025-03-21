package org.example.model;

public class Complex implements Number {

    private double real;
    private double complex;

    public Complex(double real, double complex) {
        this.real = real;
        this.complex = complex;
    }

    @Override
    public Number plus(Number a) {
        if(a instanceof Complex) {
            Complex aux = (Complex) a;
            return new Complex(this.real + aux.real, this.complex + aux.complex);
        }
        throw new RuntimeException("No se puede hacer la suma");
    }

    @Override
    public Number power(Number a) {
        return null;
    }
}
