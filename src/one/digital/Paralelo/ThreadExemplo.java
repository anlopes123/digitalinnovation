package one.digital.Paralelo;

public class ThreadExemplo {
    public static void main(String[] args) {
        GeradorPdf iniciarGeradorPdf = new GeradorPdf();
        BarraDeCarregamento iniciarBarraDeCarregamento = new BarraDeCarregamento(iniciarGeradorPdf);

        iniciarGeradorPdf.start();
        iniciarBarraDeCarregamento.start();

    }
}

class GeradorPdf extends Thread{

    @Override
    public void run() {
        try {
            System.out.println("Iniciar geração do PDF");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Gerar PDF");
    }
}

class BarraDeCarregamento extends Thread {

    private Thread iniciarGeradorPdf;

    public BarraDeCarregamento(Thread iniciarGeradorPdf) {

        this.iniciarGeradorPdf = iniciarGeradorPdf;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(500);

                if (!iniciarGeradorPdf.isAlive()) {
                    break;
                }
                System.out.println("Loading....");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class BarraDeCarregamento1 implements Runnable {
    @Override
    public void run() {

        try {
            Thread.sleep(3000);
            System.out.println("Rodando Barra de Carregamento 1 ");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class BarraDeCarregamento2 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Rodando Barra de Carregamento 2 " );

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}