package Entities;

import static java.lang.Math.abs;
import Application.*;

public class Elevador {

    private int idElevador;
    private boolean ligado;
    private boolean prioritario;
    private int andarAtual;

    //construtor
    public Elevador(int idElevador, boolean ligado, boolean prioritario) {
        this.idElevador = idElevador;
        this.ligado = ligado;
        this.prioritario = prioritario;
        this.andarAtual = 1;
    }

    public void ligarDesligar(){
        this.ligado = !this.ligado;
    }

    // getters e setters
    public boolean isPrioritario() {
        return prioritario;
    }

    public void setPrioritario(boolean prioritario) {
        this.prioritario = prioritario;
    }

    public int getAndarAtual() {
        return andarAtual;
    }

    public void setAndarAtual(int andarAtual) {
        this.andarAtual = andarAtual;
    }

    public int getIdElevador() {
        return idElevador;
    }

    public void setIdElevador(int idElevador) {
        this.idElevador = idElevador;
    }

    public boolean isLigado() {
        return ligado;
    }

    // métodos classe
    public void ativarPrioridade(){
        this.prioritario = true;
        this.andarAtual = 1;
    }

    public void desativarPrioridade(){
        this.prioritario = false;
    }

    public float calcularEsforco(int andarChamado, int andarDestino){
        /* formula desenvolvida para calcular o esforço do elevador
        leva em consideração o andar que o elevador está e o andar destino*/

        int esforcoPorAndar = 100;
        String elevadorSobe1 = "";
        String elevadorSobe2 = "";
        int sobeOuDesce = andarChamado - andarAtual;
        int sobeOuDesce1 = andarDestino - andarChamado;

        float esforcoTotal = 0;
        float esforco1 = 0;
        float esforco2 = 0;

        if (sobeOuDesce > 0){
            esforco1 = (float) (esforcoPorAndar * abs(sobeOuDesce) * 1.25);
        }else if (sobeOuDesce < 0){
            esforco1 = (float) (esforcoPorAndar * abs(sobeOuDesce));
        }else{
            esforco1 = 0;
        }

        if (sobeOuDesce1 > 0){
            esforco2 += (float) (esforcoPorAndar * abs(sobeOuDesce1) * 1.25);
        }else if (sobeOuDesce1 < 0) {
            esforco2 += (float) (esforcoPorAndar * abs(sobeOuDesce1));
        }else {
            esforco2 +=0;
        }

        if (esforco2 == 0){
            esforcoTotal = 0;
        }else{
            esforcoTotal = esforco1 + esforco2;
        }
        return esforcoTotal;
    }

    public String toString(){
        return "Elevador "
                + metodosAplicacao.elevador1.getIdElevador()
                + ", Ligado: "
                + metodosAplicacao.elevador1.isLigado()
                + ", Prioritário: "
                + metodosAplicacao.elevador1.isPrioritario()
                + ", Andar Atual: "
                + metodosAplicacao.elevador1.getAndarAtual()
                + "\n"
                + "Elevador "
                + metodosAplicacao.elevador2.getIdElevador()
                + ", Ligado: "
                + metodosAplicacao.elevador2.isLigado()
                + ", Prioritário: "
                + metodosAplicacao.elevador2.isPrioritario()
                + ", Andar Atual: "
                + metodosAplicacao.elevador2.getAndarAtual()
                + "\n";
    }

}
