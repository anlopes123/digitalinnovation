package one.digital.funcional;

import java.util.function.UnaryOperator;

public class Funcional {
    public static void main(String[] args) {
        UnaryOperator<Integer> calcularValor = valor ->valor*3;
        int valor=10;
        System.out.println("O Resultado é " + calcularValor.apply(10));
    }
}
