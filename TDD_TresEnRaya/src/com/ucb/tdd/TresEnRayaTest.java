package com.ucb.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TresEnRayaTest {
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    private TresEnRaya tresEnRaya;
    
    
    public final void before(){
        
    }
    
    
    @Test
    public void cuandoFueraXlanzarExcepcion() throws Exception{
        
        //1. Preparacion de la prueba
        tresEnRaya = new TresEnRaya();
        System.out.println("Inicializando Prueba para comprobar que si esta fuera de X debe lanzar excepcion.... " + tresEnRaya.toString());

        //2. Logica de la prueba
        exception.expect(Exception.class);

        //3. Verificacion o Assert
        tresEnRaya.jugar(5,2);
    }
    
    @Test
    public void cuandoFueraYlanzarExcepcion() throws Exception{
        //1. Preparacion de la prueba
        tresEnRaya = new TresEnRaya();
        System.out.println("Inicializando Prueba para comprobar que si esta fuera de y debe lanzar excepcion.... " + tresEnRaya.toString());

        //2. Logica de la prueba
        exception.expect(Exception.class);
        //3. Verificacion o Assert
        tresEnRaya.jugar(2,6);
    }
    @Test
    public void cuandoLugarOcupadoLanzarExcepcion() throws Exception {
        // 1. Preparacion de la prueba
        tresEnRaya = new TresEnRaya();
        System.out.println("Inicializando Prueba.... " + tresEnRaya.toString());
        tresEnRaya.jugar(1, 3); 

        // 3. Verificacion 
        exception.expect(Exception.class);

        // 2. Logica de la prueba 
        tresEnRaya.jugar(1, 3); 
    }
    
    @Test
    public void siPrimerTurnoEntoncesJuegaX(){
        //1. Preparacion de la prueba
        tresEnRaya = new TresEnRaya();
        System.out.println("Inicializando Prueba para comprobar si es el primer turno entonces juega X.... " + tresEnRaya.toString());

        //2. Logica de la prueba
        char turnoObtenido= tresEnRaya.siguienteTurno();

        //3. Verificacion o Assert
        assertEquals('X', turnoObtenido);
        
    }
    
    @Test
    public void siPrimerTurnoXSiguienteMas() throws Exception{
        //1. Preparacion de la prueba
        tresEnRaya = new TresEnRaya();
        System.out.println("Inicializando Prueba para comprobar si el primer turno fue X el sig sea +.... " + tresEnRaya.toString());
        
        tresEnRaya.jugar(2, 1); //2. Logica  X
        assertEquals('+',tresEnRaya.siguienteTurno()); //3. Verificacion
        
        tresEnRaya.jugar(2, 2); //2. Logica + 
        assertEquals('X',tresEnRaya.siguienteTurno()); //3. Verificacion
        
        
    }
   @Test
    public void siPrimerTurnoMasSiguienteX() throws Exception {
        // 1. Preparacion de la prueba
        tresEnRaya = new TresEnRaya();
        System.out.println("Inicializando Prueba.... " + tresEnRaya.toString());

        // 2. Logica: El primer jugador que mueve es 'X'
        tresEnRaya.jugar(2, 1); 

        // 3. Verificacion: Tras el movimiento de 'X', el siguiente turno es '+'
        assertEquals('+', tresEnRaya.siguienteTurno());

        // 2. Logica: Mueve '+' en la siguiente casilla
        tresEnRaya.jugar(2, 2); 

        // 3. Verificacion: Tras el movimiento de '+', el siguiente turno es 'X'
        assertEquals('X', tresEnRaya.siguienteTurno());
    }
    @Test
    public void cuandoNoHayGanador() throws Exception{
        //1. Preparacion de la prueba
        tresEnRaya = new TresEnRaya();
        System.out.println("Inicializando Prueba para comprobar cuando no hay ganador.... " + tresEnRaya.toString());
        //2. Logica de la prueba

        String  resultado = tresEnRaya.jugar(2, 1); //X
        //3. Verificacion
        assertEquals("No hay ganador", resultado);
        
    }
    
    @Test
    public void siLlenaColumnaEntoncesGana()  throws Exception{
        //1. Preparacion de la prueba
        tresEnRaya = new TresEnRaya();
        System.out.println("Inicializando Prueba para comprobar si llena una columna gana.... " + tresEnRaya.toString());
        //2.Logica de la prueba
        tresEnRaya.jugar(1, 1);//X
        tresEnRaya.jugar(1, 2);//+
        tresEnRaya.jugar(2, 1);//X
        tresEnRaya.jugar(2, 2);//+
        String  resultado = tresEnRaya.jugar(3, 1); //X
        //3.Verificacion
        assertEquals("X es el ganador", resultado);
    }
    
    @Test
    public void siLlenaFilaEntoncesGana() throws Exception{
        //1. Preparacion de la prueba
        tresEnRaya = new TresEnRaya();
        System.out.println("Inicializando Prueba para comprobar si llena una fila gana.... " + tresEnRaya.toString());
        //2. Logica de la prueba
        tresEnRaya.jugar(2, 1);//X
        tresEnRaya.jugar(1, 1);//+
        tresEnRaya.jugar(3, 1);//X
        tresEnRaya.jugar(1, 2);//+
        tresEnRaya.jugar(2, 2);//X
        String  resultado = tresEnRaya.jugar(1, 3); //+
        //3. Verificacion
        assertEquals("+ es el ganador", resultado);
    }
    
    @Test
    public void siLlenaDiagonalEntoncesGana() throws Exception{
        //1. Preparacion de la prueba
        tresEnRaya = new TresEnRaya();
        System.out.println("Inicializando Prueba si llena diagonal gana.... " + tresEnRaya.toString());
        //2.Logica de la prueba
        tresEnRaya.jugar(1, 1);//X
        tresEnRaya.jugar(1, 2);//+
        tresEnRaya.jugar(2, 2);//X
        tresEnRaya.jugar(1, 3);//+
        String  resultado = tresEnRaya.jugar(3, 3);//X

        //3.Verificacion
        assertEquals("X es el ganador", resultado);
    }
    
    @Test
    public void siLlenaDiagonalOpuestaEntoncesGana() throws Exception{
        //1. Preparacion de la prueba
        tresEnRaya = new TresEnRaya();
        System.out.println("Inicializando Prueba si llena diagonal opuesta gana.... " + tresEnRaya.toString());
        //2.Logica de la prueba
        tresEnRaya.jugar(1, 2);//X
        tresEnRaya.jugar(1, 3);//+
        tresEnRaya.jugar(1, 1);//X
        tresEnRaya.jugar(2, 2);//+
        tresEnRaya.jugar(2, 3);//X
        String  resultado = tresEnRaya.jugar(3, 1);//+
        assertEquals("+ es el ganador", resultado);
    }
}