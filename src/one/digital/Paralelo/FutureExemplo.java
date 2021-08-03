package one.digital.Paralelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class FutureExemplo {
    private static final ExecutorService threadPoll = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        Casa casa = new Casa(new Quarto());
        List<? extends Future<?>> futuros = casa.obterAFazeresDaCasa().stream().map(atividade -> threadPoll.submit(() -> atividade.realizar()))
                .collect(Collectors.toList());
        while (futuros.stream().allMatch(Future::isDone)){
            int numeroDeAtividadesNaoFinalizadas = 0;
            for (Future<?> futuro: futuros ) {
                if (futuro.isDone()) {
                    try {
                        System.out.println("Parabéns você terminou de " + futuro.get());
                        futuros.remove(futuro);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                } else {
                    numeroDeAtividadesNaoFinalizadas++;

                }
                System.out.println("numero de Atividades não finalizadas :: " +numeroDeAtividadesNaoFinalizadas);

            }
        }
        threadPoll.shutdown();
    }
}
class Casa {
    private final List<Comodo> comodos;

    Casa(Comodo... comodos) {
        this.comodos = Arrays.asList(comodos);
    }
    List<Atividade> obterAFazeresDaCasa() {
        return this.comodos.stream().map(Comodo::obterAfazeresDoComodo)
                .reduce(new ArrayList<Atividade>(), (pivo, atividades) ->{
                    pivo.addAll(atividades);
                    return pivo;
                });

    }
}

interface Atividade {
    void realizar() throws InterruptedException;
}

abstract class Comodo {
    abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo {
    @Override
    List<Atividade> obterAfazeresDoComodo() {
        return Arrays.asList(
                this::arrumarACama,
                this::varrerOQuarto,
                this::arrumarGuardaRoupa
        );
    }
    private void arrumarGuardaRoupa() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("arrumar o guarda roupa.");
    }
    private void varrerOQuarto() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("varrer o Quarto.");
    }
    private void arrumarACama() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Arrumar a cama");
    }
}