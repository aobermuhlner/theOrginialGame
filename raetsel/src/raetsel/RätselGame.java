
package raetsel;

import java.util.Random;

import gui.Window;

public class RätselGame {
	static int level;
	static Window w = new Window("game", 500, 500);

	public static void main(String[] args) {
		Random rand = new Random(500);
		w = new Window("start", 500, 500);
		w.open();
		w.setFontSize(30);

		while (w.isOpen()) {
			w.setColor(20, 20, 20);
			w.fillRect(0, 0, 500, 500);
			w.drawImageCentered("pics/start3.png", 250, 300, rand.nextDouble() / 2);
			w.setColor(200, 200, 200);
			w.drawStringCentered("press here to start:", 250, 100);
			w.refreshAndClear(500);

			if (w.wasLeftMouseButtonClicked() & Math.abs(w.getMouseX() - 237) < 20
					& Math.abs(w.getMouseY() - 95) < 12) {
				level = 1;
				w.setColor(0, 0, 0);
				w.setFontSize(15);
				lvl1();
			}
		}
	}

	public static void lvl1() {
		while (w.isOpen()) {
			w.drawStringCentered("level: " + level, 250, 20);

			w.refreshAndClear();
		}
	}
}
