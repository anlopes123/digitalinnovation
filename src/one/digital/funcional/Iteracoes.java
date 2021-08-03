package one.digital.funcional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {
    public static void main(String[] args) {
        String[] nomes = {"João", "João", "Paulo", "Oliveira", "Santos", "Instrutor", "Java"};
        Integer[] numeros = {1,2,3,4,5};
        //imprimirNomesFiltrados(nomes);
//        imprimirTodosNomes(nomes);
//        imprmirODobroDeCadaItemDaLista(numeros);

        List<String> profissoes = new ArrayList<>();
        profissoes.add("Desenvolvedor");
        profissoes.add("Testador");
        profissoes.add("Gerente de projetos");
        profissoes.add("Gerente de qualidade");

        profissoes.stream().filter(profissao -> profissao.startsWith("Gerente"))
                .forEach(System.out::println);




     }
    public static void imprimirNomesFiltrados(String... nomes){
        String nomesParaImprmir="";
        for (int i = 0; i < nomes.length; i++) {
            if (nomes[i].equals("João")) {
                nomesParaImprmir+=""+ nomes[i];
            }
        }
        System.out.println("Nomes do For: " + nomesParaImprmir);

        String nomesResultados = Stream.of(nomes).filter(nome->nome.equals("João"))
                .collect(Collectors.joining());
        System.out.println("Nomes do Stream " + nomesResultados);
    }
    public static void imprimirTodosNomes(String... nomes){
//        for (String nome: nomes) {
//            System.out.println(nome);
//        }

        Stream.of(nomes).forEach(System.out::println);
    }
   public static void imprmirODobroDeCadaItemDaLista(Integer... numeros){
//       for (Integer numero: numeros) {
//           System.out.println(numero*2);
//       }

       Stream.of(numeros).map(numero-> numero*2)
               .forEach(System.out::println);
   }
}
