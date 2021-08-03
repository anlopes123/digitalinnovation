package one.digital.funcional;

import java.util.Arrays;

public class ComposicaoFuncoes {
    public static void main(String[] args) {
        int [] valores = {1,2,3,4};
        Arrays.stream(valores)
                .filter(numero -> numero %2 == 0)
                .map(numero -> numero *2)
                .forEach(numero -> System.out.println(numero));

    }
}
