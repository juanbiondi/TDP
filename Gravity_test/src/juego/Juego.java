package juego;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

import gui.GUI;

public class Juego {
	private Malo malos[];
	private Jugador jugador;
	
	private final int gravity_force = 5;
	private final int ground_position = 90;
	
	private ArrayList<Entidad> to_fall;
	
	public Juego(GUI gui){
		malos = new Malo[3];
		to_fall = new ArrayList<Entidad>();
		
		jugador = new Jugador(15, 10, 70);
		gui.add(jugador.getGrafico());
		this.to_fall.add(jugador);
		
		for(int i = 0; i < malos.length; i++){
			Random r = new Random();
			malos[i] = new Malo(10, r.nextInt(gui.getWidth() - 17), ground_position);
			gui.add(malos[i].getGrafico());
		}
	}
	
	public void mover(){
		for(int i = 0; i < malos.length; i++){
			
			// Inteligencia de los malos
			Random r = new Random();
			
			int dir = r.nextInt(4);
			
			if(dir > 1){
				malos[i].mover(Entidad.forward_key);
			}else{
				malos[i].mover(Entidad.backward_key);
			}
		}
		this.apply_gravity();
	}
	
	private void apply_gravity(){
		for(Entidad e : to_fall){
			System.out.println(e.pos.getY());
			if(e.pos.getY() < this.ground_position){
				e.fall(gravity_force);
			}
		}
	}
	
	public void mover(int dir){		
		String direccion = Entidad.still_key;
		
		switch (dir){
			case KeyEvent.VK_SPACE : //Arriba
				direccion = Entidad.jump_key;
				break;
			case KeyEvent.VK_RIGHT : //Derecha
				direccion = Entidad.forward_key;
				break;
			case KeyEvent.VK_LEFT : //Derecha
				direccion = Entidad.backward_key;
				break;
		}
		
		jugador.mover(direccion);
	}

}
