
package raetsel;

import java.util.List;
import java.util.Random;

import gui.Window;

public class RätselGame {
	static int level;
	static Window w = new Window("game", 500, 500);
	static String numLvlDesc = "Find the next number!";

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
				lvl11_snake();
			}
		}
	}

	public static void lvl1() {
		String result = "";
		while (w.isOpen()) {
			
			levelnr(numLvlDesc);
			if (result.equals("21") & w.isKeyPressed("enter")) {
				win();
				lvl10();
			}

			result = keyboard(result);
			w.setFontSize(30);
			w.drawStringCentered("1, 1, 2, 3, 5, 8, 13, ???", 250, 100);
			w.drawStringCentered(result, 250, 200);

			w.refreshAndClear(100);

		}
	}
	
	public static void lvl10() {
		String result = "";
		while (w.isOpen()) {
			levelnr(numLvlDesc);
			if (result.equals("2310") & w.isKeyPressed("enter")) {
				win();
				lvl11_snake();
			}

			result = keyboard(result);

			w.setFontSize(30);
			w.drawStringCentered("1, 2, 6, 30, 210, ?", 250, 100);
			w.drawStringCentered(result, 250, 200);
			
			w.refreshAndClear(100);

		}
	}
	
	public static void lvl11_snake() {
		String result = "";
		levelnr(numLvlDesc);
		Lvl11_Snake snake = new Lvl11_Snake();
		snake.lvl11_snake(w);
		if (result.equals("21") & w.isKeyPressed("enter")) {
			win();
			lvl12();
		}
	}
	
	public static void lvl12() {
		String result = "";
		while (w.isOpen()) {
			levelnr(numLvlDesc);
			if (result.equals("2310") & w.isKeyPressed("enter")) {
				win();
				lvl12();
			}
			w.drawStringCentered("1, 2, 6, 30, 210, ?", 250, 100);
			w.setFontSize(30);
			w.refreshAndClear(100);

		}
	}


	public static void lvl2() {

	}

	public static String keyboard(String current) {
		List<String> list = w.getPressedKeys();
		String next = current;
		for (String item : list) {
			if (item.equals("back_space")) {
				if (next.length() > 0) {
					next = next.substring(0, next.length() - 1);
				}
			} else {
				next = next + item;
			}
		}
		return next;
	}

	public static void levelnr(String lvlDesc) {
		w.setFontSize(15);
		w.drawStringCentered("level: " + level, 250, 20);
		w.drawStringCentered(lvlDesc, 250, 40);
	}

	public static void win() {
		level++;
		w.setColor(0, 255, 0);
		w.setStrokeWidth(20);
		w.drawRect(0, 0, 500, 500);
		w.setFontSize(50);
		w.drawStringCentered("YESSIR!!", 250, 250);
		w.setColor(0, 0, 0);
		w.refresh();
		w.refresh(1000);
	}
}
