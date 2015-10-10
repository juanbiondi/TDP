package juego;

import java.util.Random;

import gui.GUI;

public class Juego {
	private Malo malos[];
	private Jugador jugador;
	
	public Juego(GUI gui){
		malos = new Malo[3];
		
		jugador = new Jugador(15, 10, 10);
		gui.add(jugador.getGrafico());
		
		for(int i = 0; i < malos.length; i++){
			Random r = new Random();
			malos[i] = new Malo(10, r.nextInt(gui.getWidth() - 32), r.nextInt(gui.getHeight() - 32));
			gui.add(malos[i].getGrafico());
		}
	}
	
	public void mover(){
		for(int i = 0; i < malos.length; i++){
			malos[i].mover();
		}
	}
	
	public void mover(int dir){
		jugador.mover(dir);
	}

}