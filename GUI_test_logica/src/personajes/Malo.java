package personajes;

import java.util.Random;

import grafica.MaloGrafico;
import mapa.Celda;

public class Malo extends Entidad{

	public Malo(int velocidad, Celda pos) {
		super(velocidad, pos);

		this.grafico = new MaloGrafico(velocidad, this.pos.getX(), this.pos.getY());
	}
	
	public Malo(Celda pos) {
		super(pos);

		this.grafico = new MaloGrafico(velocidad, this.pos.getX(), this.pos.getY());
	}

	public void mover() {
		Random r = new Random();
		
		int dir = r.nextInt(4);
		
		int direccion = -1;
		switch (dir) {
			case 0 : //Arriba
				direccion = Celda.UP;
				break;
			case 1 : //Abajo
				direccion = Celda.DOWN;
				break;
			case 2 : //Izquierda
				direccion = Celda.LEFT;
				break;
			case 3 : //Derecha
				direccion = Celda.RIGHT;
				break;
		}
		
		this.pos.removeMalo(this);
		super.mover(direccion);
		this.pos.addMalo(this);
	}

}
