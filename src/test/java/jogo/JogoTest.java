package jogo;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class JogoTest {

    private Jogador jogador;
    private Dado dado1;
    private Dado dado2;

    @BeforeEach
    void setup() {
        jogador = mock(Jogador.class);
        dado1 = mock(Dado.class);
        dado2 = mock(Dado.class);
    }

    @Test
    void testeGanhaPrimeiroTurnoCom7() {
        when(jogador.lancar(dado1, dado2)).thenReturn(7);

        Jogo jogo = new Jogo(jogador, dado1, dado2);
        assertTrue(jogo.jogo());
    }

    @Test
    void testeGanhaPrimeiroTurnoCom11() {
        when(jogador.lancar(dado1, dado2)).thenReturn(11);

        Jogo jogo = new Jogo(jogador, dado1, dado2);
        assertTrue(jogo.jogo());
    }

    @Test
    void testePerdePrimeiroTurnoCom2() {
        when(jogador.lancar(dado1, dado2)).thenReturn(2);

        Jogo jogo = new Jogo(jogador, dado1, dado2);
        assertFalse(jogo.jogo());
    }

    @Test
    void testePerdePrimeiroTurnoCom3() {
        when(jogador.lancar(dado1, dado2)).thenReturn(3);

        Jogo jogo = new Jogo(jogador, dado1, dado2);
        assertFalse(jogo.jogo());
    }

    @Test
    void testePerdePrimeiroTurnoCom12() {
        when(jogador.lancar(dado1, dado2)).thenReturn(12);

        Jogo jogo = new Jogo(jogador, dado1, dado2);
        assertFalse(jogo.jogo());
    }

    @Test
    void testeGanhaSegundoTurnoAoRepetirPonto() {
        when(jogador.lancar(dado1, dado2))
                .thenReturn(8)
                .thenReturn(5)
                .thenReturn(8);

        Jogo jogo = new Jogo(jogador, dado1, dado2);
        assertTrue(jogo.jogo());
    }

    @Test
    void testePerdeSegundoTurnoSeSair7() {
        when(jogador.lancar(dado1, dado2))
                .thenReturn(6)
                .thenReturn(7);

        Jogo jogo = new Jogo(jogador, dado1, dado2);
        assertFalse(jogo.jogo());
    }

    @Test
    void deveContinuarJogandoAteRepetirPontoOuSair7() {
        when(jogador.lancar(dado1, dado2))
                .thenReturn(6)
                .thenReturn(4)
                .thenReturn(9)
                .thenReturn(6);

        Jogo jogo = new Jogo(jogador, dado1, dado2);
        assertTrue(jogo.jogo());
    }
}
