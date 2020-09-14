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
                    boolean continuar = true;
                    int andarAtual = 0;
                    int andarDesejado = 0;
                    do {
                        try {
                            System.out.println("Em qual andar você está? ");
                            andarAtual = ler.nextInt();
                            continuar = false;
                        } catch (Exception e){
                            System.out.println("Código deve ser numérico.");
                            ler.next();
                        }
                    }while (continuar);
                    continuar = true;
                    do {
                        try {
                            System.out.println("Qual andar você deseja ir? ");
                            andarDesejado = ler.nextInt();
                            continuar = false;
                        }catch (Exception e){
                            System.out.println("Código deve ser numérico.");
                            ler.next();
                        }
                    }while (continuar);

                    metodosAplicacao.prioridadeElevador(andarAtual, andarDesejado);

                    // imprimi o status dos dois elevadores
                    System.out.println(metodosAplicacao.elevador1);
                    break;

                case "2":
                    System.out.println("Elevador 1 ligado: "
                            + metodosAplicacao.elevador1.isLigado()
                            + "\nElevador 2 ligado: "
                            + metodosAplicacao.elevador2.isLigado());
                    System.out.println("\nDeseja Ligar/Desligar qual elevador? \nDigite 0 para sair.");
                    String optionLigaDesliga = ler.next();

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
                        case "0":
                            System.out.println("Menu Inicial");
                            break;
                        default:
                            System.out.println("Opção Inválida");
                            break;
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
