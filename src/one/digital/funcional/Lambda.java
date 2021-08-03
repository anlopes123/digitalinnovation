package one.digital.funcional;

public class Lambda {
    public static void main(String[] args) {
      GeradorNome gerarNome = valor -> valor;
        System.out.println(gerarNome.gerar("Anizair"));
    }

}

interface GeradorNome {
    String gerar(String valor);
}
