package Test;

import Entities.Elevador;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElevadorTest {

    @Test
    public void ligarDesligar() {
        Elevador elevador = new Elevador(001, true, true);
        elevador.ligarDesligar();
        assertFalse(elevador.isLigado());
    }

    @Test
    public void calcularEsforco() {
        Elevador elevador = new Elevador(001, true, true);
        assertTrue(500 == elevador.calcularEsforco(1, 5));
        assertTrue(1125 == elevador.calcularEsforco(1, 10));
        assertTrue(0 == elevador.calcularEsforco(1, 1));
    }

    @Test
    public void ativarPrioridade(){
        Elevador elevador = new Elevador(001, true, false);
        elevador.ativarPrioridade();
        assertTrue(elevador.isPrioritario());
    }

    @Test
    public void desativarPrioridade(){
        Elevador elevador = new Elevador(001, true, true);
        elevador.desativarPrioridade();
        assertFalse(elevador.isPrioritario());
    }
}