package criterios_aceptacion;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import castas.*;
import dominio.*;
import habilidades.*;
import items.*;
import razas.*;

// Falta todo


/***
 * 
 * 11)	Como Personaje, quiero combatir contra otros jugadores.
 * Motivaci�n: Para obtener sus �tems al derrotarlos.
 * 
 ***/

public class Historia11Test {


	/***
	 * 
	 * 1.	Dado un Personaje que pertenece a una Alianza, cuando �stos resultan ganadores de un combate, entonces 
	 * se reparten los �tems de los perdedores entre los integrantes. 
	 * 
	 ***/
	
	@Test
	public void historia11Criterio01_Test() throws FileNotFoundException{
		Personaje p1 = new Humano("Humano1","1231");
		Personaje p2 = new Orco("Humano2","1231");
		Personaje p3 = new Elfo("Humano3","1231");
		Personaje p4 = new Elfo("Humano4","1231");
		p1.setClase(new Guerrero());
		p2.setClase(new Hechicero());
		p3.setClase(new Chaman());
		p4.setClase(new Hechicero());
		
		/*
		 * Armo las alianzas: 
		 *  
		 * */
		Alianza a1 = new Alianza();
		p1.setAlianzaActual(a1);
		p2.setAlianzaActual(a1);
		
		
		p1.getAlianzaActual().formarAlianza(p2);
		p2.getAlianzaActual().formarAlianza(p1);
		
		/*
		 * Se preparan los equipos a pelear
		 * */
		Equipo e1 = new Equipo(p1);
		e1.agregar(p2);
		Equipo e2 = new Equipo(p3);
		e2.agregar(p4);
		
		/*
		 * Compruebo que esten todos vivos
		 * */
		Assert.assertEquals(true, e1.quedaAlgunoVivo());
		Assert.assertEquals(true, e2.quedaAlgunoVivo());
		
		/*
		 * Se ataca por turnos. La idea es que cuando un equipo se queda sin peleadores, 
		 * se sumen los niveles de todos sus integrantes y se los multiplique por 10.
		 * Ese numero sera dividido por la cantidad de peleadores del equipo ganador y se le 
		 * sumara a cada uno a su experiencia. 
		 * 
		 * */
		Combate c = new Combate("Super Batalla");
		while(e1.quedaAlgunoVivo() && e2.quedaAlgunoVivo() ){
			c.combatir(e1, e2);
		}
		if(e1.quedaAlgunoVivo())
			e1.repartirItem(e2);
		else if(e2.quedaAlgunoVivo())
			e2.repartirItem(e1);
	}
	
	
	/***
	 * 
	 * 2.	Dado un Personaje, cuando finaliza el combate contra otro Personaje 
	 * Usuario y resulta ganador, entonces se le entrega el mejor �tem de aquel Personaje Usuario derrotado. 
	 * 
	 ***/
	
	@Test
	public void historia11Criterio02_Test() throws FileNotFoundException{
		Personaje p1 = new Humano("Humano1","1231");
		Personaje p2 = new Orco("Humano2","1231");
		p1.setClase(new Guerrero());
		p2.setClase(new Hechicero());
		
		/*
		 * Se preparan los equipos a pelear
		 * */
		Equipo e1 = new Equipo(p1);
		Equipo e2 = new Equipo(p2);
		
		/*
		 * Compruebo que esten todos vivos
		 * */
		Assert.assertEquals(true, e1.quedaAlgunoVivo());
		Assert.assertEquals(true, e2.quedaAlgunoVivo());
		
		/*
		 * Se ataca por turnos. La idea es que cuando un equipo se queda sin peleadores, 
		 * se sumen los niveles de todos sus integrantes y se los multiplique por 10.
		 * Ese numero sera dividido por la cantidad de peleadores del equipo ganador y se le 
		 * sumara a cada uno a su experiencia. 
		 * 
		 * */
		
		Combate c = new Combate("La Gran Batalla");
		while(e1.quedaAlgunoVivo() && e2.quedaAlgunoVivo() ){
			c.combatir(e1, e2);
		}
		
		if(e1.quedaAlgunoVivo())
			e1.repartirItem(e2);
		else if(e2.quedaAlgunoVivo())
			e2.repartirItem(e1);
	}
	
	/***
	 * 
	 * 3.	Dado un Personaje, cuando finaliza el combate contra un Personaje Gen�rico y resulta ganador, 
	 * entonces se le entrega el mejor �tem del Personaje Gen�rico.
	 * 
	 ***/
	
	@Test
	public void historia11Criterio03_Test() throws FileNotFoundException{
		Personaje p1 = new Humano("Humano1","1231");
		Personaje p2 = new Orco("Humano2","1231");
		Generico g = new Generico("Terminator");
		p1.setClase(new Guerrero());
		p2.setClase(new Hechicero());
		
		/*
		 * Armo la alianza: 
		 *  
		 * */
		Alianza a1 = new Alianza();
		p1.setAlianzaActual(a1);
		p2.setAlianzaActual(a1);
		
		
		p1.getAlianzaActual().formarAlianza(p2);
		p2.getAlianzaActual().formarAlianza(p1);
		
		/*
		 * Se prepara un equipo para pelear
		 * */
		Equipo e1 = new Equipo(p1);
		
		/*
		 * Compruebo que esten todos vivos
		 * */
		Assert.assertEquals(true, e1.quedaAlgunoVivo());
		Assert.assertEquals(true, g.estaVivo());
		
		/*
		 * Se ataca por turnos. La idea es que cuando un equipo se queda sin peleadores, 
		 * se sumen los niveles de todos sus integrantes y se los multiplique por 10.
		 * Ese numero sera dividido por la cantidad de peleadores del equipo ganador y se le 
		 * sumara a cada uno a su experiencia. 
		 * 
		 * */
		
		Combate c = new Combate("La Pelea Final");
		while(e1.quedaAlgunoVivo() && g.estaVivo()){
			c.combatir(e1, g);
		}
		
		if(e1.quedaAlgunoVivo())
			e1.repartirItem(g);
	}
}
