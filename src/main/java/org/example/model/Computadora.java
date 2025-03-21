package org.example.model;

public class Computadora {

    private boolean tienePantalla;
    private boolean tieneTeclado;
    private Computadora api;

    public Computadora() {


    }

    public boolean isTienePantalla() {
        return tienePantalla;
    }

    public boolean isTieneTeclado() {
        return tieneTeclado;
    }

    public Computadora getApi() {
        return api;
    }
}
