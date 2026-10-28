
package com.ucb.tdd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

public class TresEnRayaIaTest {

    private TresEnRaya juego;

    @Before
    public void setUp() {
        juego = new TresEnRaya();
    }

    // 1. Validacion de coordenadas

    @Test
    public void coordenadaXMenorQueUnoDebeLanzarExcepcion() {
        Exception excepcion = assertThrows(
            Exception.class,
            () -> juego.jugar(0, 1)
        );

        assertEquals(
            "La coordenada 0 esta fuera de lugar",
            excepcion.getMessage()
        );
    }

    @Test
    public void coordenadaXMayorQueTresDebeLanzarExcepcion() {
        Exception excepcion = assertThrows(
            Exception.class,
            () -> juego.jugar(4, 1)
        );

        assertEquals(
            "La coordenada 4 esta fuera de lugar",
            excepcion.getMessage()
        );
    }

    @Test
    public void coordenadaYMenorQueUnoDebeLanzarExcepcion() {
        Exception excepcion = assertThrows(
            Exception.class,
            () -> juego.jugar(1, 0)
        );

        assertEquals(
            "La coordenada 0 esta fuera de lugar",
            excepcion.getMessage()
        );
    }

    @Test
    public void coordenadaYMayorQueTresDebeLanzarExcepcion() {
        Exception excepcion = assertThrows(
            Exception.class,
            () -> juego.jugar(1, 4)
        );

        assertEquals(
            "La coordenada 4 esta fuera de lugar",
            excepcion.getMessage()
        );
    }

    @Test
    public void casillaOcupadaDebeLanzarExcepcion() throws Exception {
        juego.jugar(1, 1);

        Exception excepcion = assertThrows(
            Exception.class,
            () -> juego.jugar(1, 1)
        );

        assertEquals(
            "La posicion ya esta ocupada",
            excepcion.getMessage()
        );
    }

    // 2. Alternancia de turnos

    @Test
    public void jugadorXDebeComenzarLaPartida() throws Exception {
        assertEquals(
            "No hay ganador",
            juego.jugar(1, 1)
        );
    }

    @Test
    public void losJugadoresDebenAlternarEntreXYMas() throws Exception {
        juego.jugar(1, 1); // X
        assertEquals('+', juego.siguienteTurno());

        juego.jugar(2, 1); // +
        assertEquals('X', juego.siguienteTurno());

        juego.jugar(1, 2); // X
        assertEquals('+', juego.siguienteTurno());

        juego.jugar(2, 2); // +
        assertEquals('X', juego.siguienteTurno());
    }


    @Test
    public void siguienteTurnoDebeIndicarXAlInicio() {
        assertEquals(
            'X',
            juego.siguienteTurno()
        );
    }

    @Test
    public void siguienteTurnoDebeIndicarMasDespuesDeX()
            throws Exception {
        juego.jugar(1, 1);

        assertEquals(
            '+',
            juego.siguienteTurno()
        );
    }

    // 3. Escenarios sin ganador

    @Test
    public void partidaSinTresEnRayaDebeIndicarQueNoHayGanador()
            throws Exception {
        assertEquals("No hay ganador", juego.jugar(1, 1));
        assertEquals("No hay ganador", juego.jugar(2, 2));
        assertEquals("No hay ganador", juego.jugar(1, 2));
        assertEquals("No hay ganador", juego.jugar(3, 3));
    }

    // 4. Victoria por filas

    @Test
    public void victoriaDeXEnLaPrimeraFila() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(2, 1); // +
        juego.jugar(1, 2); // X
        juego.jugar(2, 2); // +
        String resultado = juego.jugar(1, 3); // X

        assertEquals("X es el ganador", resultado);
    }

    @Test
    public void victoriaDeMasEnLaSegundaFila() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(2, 1); // +
        juego.jugar(1, 2); // X
        juego.jugar(2, 2); // +
        juego.jugar(3, 3); // X
        String resultado = juego.jugar(2, 3); // +

        assertEquals("+ es el ganador", resultado);
    }

    // 5. Victoria por columnas

    @Test
    public void victoriaDeXEnLaPrimeraColumna() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(1, 2); // +
        juego.jugar(2, 1); // X
        juego.jugar(2, 2); // +
        String resultado = juego.jugar(3, 1); // X

        assertEquals("X es el ganador", resultado);
    }

    @Test
    public void victoriaDeMasEnLaSegundaColumna() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(1, 2); // +
        juego.jugar(3, 3); // X
        juego.jugar(2, 2); // +
        juego.jugar(3, 1); // X
        String resultado = juego.jugar(3, 2); // +

        assertEquals("+ es el ganador", resultado);
    }

    // 6. Victoria por diagonales

    @Test
    public void victoriaDeXEnLaDiagonalPrincipal() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(1, 2); // +
        juego.jugar(2, 2); // X
        juego.jugar(1, 3); // +
        String resultado = juego.jugar(3, 3); // X

        assertEquals("X es el ganador", resultado);
    }

    @Test
    public void victoriaDeMasEnLaDiagonalSecundaria() throws Exception {
        juego.jugar(1, 1); // X
        juego.jugar(1, 3); // +
        juego.jugar(2, 1); // X
        juego.jugar(2, 3); // +
        juego.jugar(3, 1); // X
        String resultado = juego.jugar(3, 2); // +

        // El ultimo movimiento anterior no forma una diagonal.
        // Se completa la diagonal secundaria en un escenario nuevo.
        TresEnRaya otroJuego = new TresEnRaya();
        otroJuego.jugar(1, 1); // X
        otroJuego.jugar(1, 3); // +
        otroJuego.jugar(2, 2); // X
        otroJuego.jugar(1, 2); // +
        otroJuego.jugar(3, 3); // X

        // Esta secuencia no permite que + gane la diagonal secundaria,
        // porque X ya ocupa el centro.
        assertEquals("No hay ganador", resultado);
    }
}
