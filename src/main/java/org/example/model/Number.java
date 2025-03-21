package org.example.model;

public interface Number {

    /**
     * Precondición: la suma es entre numeros computables
     * Postcondicion: ....
     * Estrategia:
     * @param a, que es no computable
     * @return
     */
    Number plus(Number a);
    Number power(Number a);

}
