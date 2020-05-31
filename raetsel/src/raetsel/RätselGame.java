
package raetsel;

import java.util.List;
import java.util.Random;

import gui.Window;

public class RätselGame {
	static int level;
	static Window w = new Window("game", 500, 500);

	public static void main(String[] args) {
		Random rand = new Random(500);
		w = new Window("start", 500, 500);
		w.open();
		lvl2();
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
		String result = "";
		while (w.isOpen()) {
			levelnr();
			if (result.equals("21") & w.isKeyPressed("enter")) {
				win();
				lvl2();
			}
			result = keyboard(result);
			w.setFontSize(30);
			w.drawStringCentered("1, 1, 2, 3, 5, 8, 13, ???", 250, 100);
			w.drawStringCentered(result, 250, 200);

			w.refreshAndClear(100);

		}
	}

	public static void lvl2() {
		int time = 1;
		int nr = -1;
		int[] enemies = new int[12];
		int[] enemiesy = new int[12];
		boolean[] green = new boolean[12];
		int y = 300;
		Random rand = new Random();

		while (w.isOpen()) {
			w.setColor(136, 128, 171);
			w.fillRect(0, 0, 500, 500);
			w.setColor(0, 0, 0);
			w.setFontSize(20);
			w.drawStringCentered("up", 250, 100);
			w.setColor(60, 256, 77);
			w.fillOval(30, y, 10, 20);
			w.setColor(0, 0, 0);
			w.drawLine(0, 320, 500, 320);
			w.drawLine(0, 220, 500, 220);

			if (w.isKeyPressed("up") & y > 220) {
				y--;
			} else if (y >= 220 & y < 300) {
				y++;
			}

			if (time % 200 == 0 && nr < 11) {
//				time = 0;
				nr++;
				enemies[nr] = 550;
				enemiesy[nr] = rand.nextInt(80) + 220;
				if (nr % 2 == 0) {
					green[nr] = true;
				}
			}
			for (int i = 0; i <= nr; i++) {
				if (green[i] == false) {
					w.setColor(0, 255, 0);
				} else {
					w.setColor(255, 0, 0);
				}
				w.fillRect(enemies[i], enemiesy[i], 5, 20);
				w.drawRect(enemies[i], enemiesy[i], 5, 20);
				if (enemies[i] == 30) {
					if (green[i] == true & Math.abs(y - enemiesy[i]) > 20) {
						fuck();
						lvl2();
					} else if (green[i] == false & Math.abs(y - enemiesy[i]) < 20) {
						fuck();
						lvl2();
					}
				}
				enemies[i]--;
			}
			w.setColor(0, 0, 0);
			time++;
			if (enemies[9] < 0) {
				green[11] = true;
				green[10] = false;
			}
			if (enemies[11] < -50) {
				lvl3();
			}
			w.refreshAndClear();
		}
	}

	public static void lvl3() {
		w.close();

	}

	public static void lvl4() {
		w.close();

	}

	public static void lvl5() {
		w.close();

	}

	public static void lvl6() {
		w.close();

	}

	public static void lvl7() {
		w.close();

	}

	public static void lvl8() {
		w.close();

	}

	public static void lvl9() {
		w.close();

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

	public static void levelnr() {
		w.setFontSize(15);
		w.drawStringCentered("level: " + level, 250, 20);
	}

	public static void win() {
		w.setColor(0, 255, 0);
		w.setStrokeWidth(20);
		w.drawRect(0, 0, 500, 500);
		w.setFontSize(50);
		w.drawStringCentered("YESSIR!!", 250, 250);
		w.setColor(0, 0, 0);
		w.refresh();
		w.refresh(1000);
	}

	public static void fuck() {
		w.setColor(255, 0, 0);
		w.setStrokeWidth(20);
		w.drawRect(0, 0, 500, 500);
		w.setFontSize(50);
		w.drawStringCentered("you fucked up...", 250, 250);
		w.setColor(0, 0, 0);
		w.refresh();
		w.refresh(1000);
		w.setStrokeWidth(1);
	}

	public static void lvl2_jump() {

	}
}
