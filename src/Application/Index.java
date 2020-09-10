package Application;

import Entities.Elevador;
import Application.*;

import java.util.Locale;
import java.util.Scanner;

public class Index {

    public static boolean el1, el2;

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner ler = new Scanner(System.in);

        boolean cont = true;
        while (cont) {
            System.out.println("O que deseja fazer: " +
                    "\n1. Pegar Elevador" +
                    "\n2. Ligar/Desligar Elevador" +
                    "\n0. Sair");
            String option = ler.next();

            switch (option){
                case "1":
                    System.out.println("Em qual andar você está? ");
                    int andarAtual = ler.nextInt();
                    System.out.println("Qual andar você deseja ir? ");
                    int andarDesejado = ler.nextInt();

                    metodosAplicacao.prioridadeElevador(andarAtual, andarDesejado);

                    if (metodosAplicacao.elevador1.isPrioritario()) {
                        System.out.println("Elevador 1 a caminho...");
                    } else {
                        System.out.println("Elevador 2 a caminho...");
                    }
                    // imprimi o status dos dois elevadores
                    System.out.println(metodosAplicacao.elevador1);
                    break;

                case "2":
                    System.out.println("Status Elevador 1: "
                            + metodosAplicacao.elevador1.isLigado()
                            + "\nStatus elevador 2: "
                            + metodosAplicacao.elevador2.isLigado());
                    System.out.println("\nDeseja Ligar/Desligar qual elevador? \nDigite 0 para sair.");
                    String optionLigaDesliga = ler.nextLine();

                    switch (optionLigaDesliga){
                        case "1":
                            metodosAplicacao.elevador1.ligarDesligar();
                            metodosAplicacao.elevador2.ativarPrioridade();
                            metodosAplicacao.elevador1.desativarPrioridade();
                            System.out.println(metodosAplicacao.elevador1);
                            break;
                        case  "2":
                            metodosAplicacao.elevador2.ligarDesligar();
                            metodosAplicacao.elevador1.ativarPrioridade();
                            metodosAplicacao.elevador2.desativarPrioridade();
                            System.out.println(metodosAplicacao.elevador1);
                            break;
                        default:
                            System.out.println("Opção Inválida");
                            //continue;
                    }
                    break;

                case "0":
                    System.out.println("Obrigado e até mais!");
                    cont = false;
                    break;

                default:
                    System.out.println("Opção Inválida!");
                    break;
            }

        }
        ler.close();
    }


}
