package personajes;

import javax.swing.JLabel;

import grafica.EntidadGrafica;
import mapa.Celda;

public abstract class Entidad {
	
	protected int velocidad = 4;
	protected Celda pos;
	
	protected EntidadGrafica grafico;
	
	protected Entidad(int velocidad, Celda pos) {
		this.pos = pos;
		this.velocidad = velocidad;
		
		this.grafico = null;
	}
	
	protected Entidad(Celda pos) {
		this.pos = pos;
		
		this.grafico = null;
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public Celda getPos() {
		return pos;
	}
	
	protected void mover(int dir){
		Celda next = this.pos.getVecina(dir);
		
		if(next != null){
			this.pos = next;
			this.grafico.mover(dir);
		}
	}
	
	public JLabel getGrafico(){
		return this.grafico.getGrafico();
	}
}
