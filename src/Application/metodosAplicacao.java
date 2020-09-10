package Application;

import Entities.Elevador;
import Application.*;


public class metodosAplicacao {

    public static Elevador elevador1 = new Elevador(01, true, true);
    public static Elevador elevador2 = new Elevador(02, true, false);

    // Testado
    public static void prioridadeElevador(int andarChamado, int andarDestino) {
        float esforco1 = elevador1.calcularEsforco(andarChamado, andarDestino);
        float esforco2 = elevador2.calcularEsforco(andarChamado, andarDestino);

        if (esforco1 <= esforco2){
            elevador1.setPrioritario(true);
            elevador2.setPrioritario(false);
            elevador1.setAndarAtual(andarDestino);
        }else{
            elevador1.setPrioritario(false);
            elevador2.setPrioritario(true);
            elevador2.setAndarAtual(andarDestino);
        }
    }

}
