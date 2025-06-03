package org.example.model;

/**
 * Precondición: La pila debe estar inicializada para usar cada uno de los métodos
 */
public interface Stack {

    void add(int a);

    /**
     * Precondición: La pila no puede estar vacía
     */
    void remove();

    /**
     * Preondición: La pila no puede estar vacía
     * Estrategia: Se va a usar una estructura alternativa dentro de pila,
     * tal que esa estructura va a ser linal y vamos a considerar
     * un índice especial para guardar el tope y el objetivo es devolver el
     * valor contenido en esa posición
     *
     * @return el tope de la pila
     */
    int getTop();

    boolean isEmpty();

}
