package grafica;

import java.awt.Point;

import javax.swing.Icon;
import javax.swing.JLabel;

import mapa.Celda;

public abstract class EntidadGrafica {
	protected JLabel grafico;
	protected Icon image[];
	protected final int width = 32;
	protected final int height = 32;
	
	protected int velocidad;
	
	protected Point pos;
	
	protected EntidadGrafica(int velocidad, int x, int y) {
		this.pos = new Point(x * this.width, y * this.height);
		this.velocidad = velocidad;
		
		this.image = new Icon[4];
	}
	
	public int getVelocidad() {
		return velocidad;
	}

	public Point getPos() {
		return pos;
	}
	
	protected void changeIcon(int dir){
		int direccion = -1;
		
		switch (dir){
			case Celda.UP : 
				direccion = 0;
				break;
			case Celda.DOWN : 
				direccion = 1;
				break;
			case Celda.LEFT : 
				direccion = 2;
				break;
			case Celda.RIGHT : 
				direccion = 3;
				break;
		}
		
		this.grafico.setIcon(this.image[direccion]);
	}
	
	public void mover(int dir){
		if(this.grafico != null){
			this.changeIcon(dir);
			
			try {
				switch (dir){
					case Celda.UP : // Arriba
						for(int i = 0; i < this.height; i += this.velocidad){
							this.grafico.setBounds(this.pos.x, this.pos.y -= this.velocidad, width, height);
							Thread.sleep(100);
						}
						break;
					case Celda.DOWN : // Abajo
						for(int i = 0; i < this.height; i += this.velocidad){
							this.grafico.setBounds(this.pos.x, this.pos.y += this.velocidad, width, height);
							Thread.sleep(100);
						}
						break;
					case Celda.RIGHT : // Derecha
						for(int i = 0; i < this.width; i += this.velocidad){
							this.grafico.setBounds(this.pos.x += this.velocidad, this.pos.y, width, height);
							Thread.sleep(100);
						}
						break;
					case Celda.LEFT : // Derecha
						for(int i = 0; i < this.width; i += this.velocidad){
							this.grafico.setBounds(this.pos.x -= this.velocidad, this.pos.y, width, height);
							Thread.sleep(100);
						}
						break;
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public JLabel getGrafico(){
		if(this.grafico == null){
			this.grafico = new JLabel(image[0]);
			this.grafico.setBounds(this.pos.x, this.pos.y, width, height);
		}
		
		return this.grafico;
	}

}
