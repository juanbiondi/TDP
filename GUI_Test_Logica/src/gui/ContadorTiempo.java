package gui;

import juego.Juego;

public class ContadorTiempo extends Thread {

	private Juego juego;
	private GUI gui;

	ContadorTiempo(Juego j, GUI gui) {
		this.juego = j;
		this.gui = gui;
	}

	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			juego.mover();
			if(gui.getLock()){
				juego.mover(gui.getDirection());
				gui.toggleLock();
			}
		}
	}
}