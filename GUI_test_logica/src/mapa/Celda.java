package mapa;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import personajes.Jugador;
import personajes.Malo;

public class Celda {
	public static final int LEFT = KeyEvent.VK_LEFT;
	public static final int RIGHT = KeyEvent.VK_RIGHT;
	public static final int UP = KeyEvent.VK_UP;
	public static final int DOWN = KeyEvent.VK_DOWN;
	
	private ArrayList<Malo> malos;
	private Jugador jugador;
	private Mapa mapa;
	
	private int x;
	private int y;
	
	public Celda(Mapa mapa, int x, int y){
		this.malos = new ArrayList<Malo>();
		this.jugador = null;
		this.mapa = mapa;
		
		this.x = x;
		this.y = y;
	}
	
	public void addMalo(Malo m){
		this.malos.add(m);
	}
	
	public void removeMalo(Malo m){
		this.malos.remove(m);
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	
	public Celda getVecina(int dir){
		switch (dir){
			case UP :
				return this.mapa.getCelda(x, y - 1);
			case DOWN :
				return this.mapa.getCelda(x, y + 1);
			case LEFT :
				return this.mapa.getCelda(x - 1, y);
			case RIGHT :
				return this.mapa.getCelda(x + 1, y);
		}
		return null;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}
