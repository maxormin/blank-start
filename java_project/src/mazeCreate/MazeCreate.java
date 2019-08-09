package mazeCreate;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MazeCreate {
	private int[][] maze;
	private String road;
	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public void menu(int chose) {
		// System.out.println("enter maze create way");
		if (chose == 1) {
			manual_operation a = new manual_operation(road);
			a.create();
			this.maze = a.getMaze();
		} else if (chose == 2) {
			self_motion a = new self_motion();
			a.creatMaze();
			this.maze = a.getMaze();
			startX = a.getStartX();
			startY = a.getStartY();
			endX = a.getEndX();
			endY = a.getEndY();
		}
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}

	public void setRoad(String road) {
		this.road = road;
	}

	public int getStartX() {
		return startX;
	}

	public int getStartY() {
		return startY;
	}

	public int getEndX() {
		return endX;
	}

	public int getEndY() {
		return endY;
	}

	public int[][] getMaze() {
		return maze;
	}
}

class manual_operation {
	private String a;
	private File file;
	private int[][] maze;

	public manual_operation(String a) {
		this.a = a;
		file = new File(a);
	}

	public void create() {
		int m = 0, line = 0;
		try {
			Scanner in = new Scanner(file);
			while (in.hasNext()) {
				String str = in.nextLine();
				for (int i = 0; i < str.length(); i++) {
					if (Character.isDigit(str.charAt(i))) {
						m++;
					}
				}
				line++;
			}
			m = m / line;
			in.close();
			int[][] maze = new int[line][m];
			in = new Scanner(file);
			while (in.hasNext()) {
				for (int i = 0; i < line; i++) {
					for (int j = 0; j < m; j++) {
						maze[i][j] = in.nextInt();
					}
				}
			}
			in.close();
			/*
			 * System.out.println("please enter start point: (y,x)"); for (int i = 0; i <
			 * maze.length; i++) { for (int j = 0; j < maze[0].length; j++) {
			 * System.out.printf("%d ", maze[i][j]); } System.out.println(); } in = new
			 * Scanner(System.in);
			 */
			this.maze = maze;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[][] getMaze() {
		return maze;
	}
}

class self_motion {
	private int[][] maze;
	private ArrayList<Integer> X = new ArrayList<>();
	private ArrayList<Integer> Y = new ArrayList<>();
	private int L = 50;
	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public int getStartY() {
		return startY;
	}

	public int getStartX() {
		return startX;
	}

	public int getEndX() {
		return endX;
	}

	public int getEndY() {
		return endY;
	}

	public self_motion() {
		Random in = new Random();
		// maze = new int[in.nextInt(5) + 10][in.nextInt(5) + 10];
		maze = new int[L][L];
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				maze[i][j] = 1;
			}
		}
		for (int i = 0; i < maze.length; i++) {
			maze[i][0] = 0;
			maze[0][i] = 0;
			maze[L - 1][i] = 0;
			maze[i][L - 1] = 0;
		}
		X.add(2);
		Y.add(2);
	}

	public void creatMaze() {
		Random in = new Random();
		int count, i, j;
		while (X.size() != 0) {
			int r = in.nextInt(X.size());
			int x = X.get(r);
			int y = Y.get(r);
			count = 0;
			for (i = x - 1; i < x + 2; i++) {
				for (j = y - 1; j < y + 2; j++) {
					if (Math.abs(x - i) + Math.abs(y - j) == 1 && maze[i][j] == 0) {
						count++;
					}
				}
			}
			if (count <= 1) {
				maze[x][y] = 0;
				for (i = x - 1; i < x + 2; i++) {
					for (j = y - 1; j < y + 2; j++) {
						if (Math.abs(x - i) + Math.abs(y - j) == 1 && maze[i][j] == 1) {
							X.add(i);
							Y.add(j);
						}
					}
				}
			}
			X.remove(r);
			Y.remove(r);
		}
		maze[2][1] = 0;
		for (i = L - 3; i >= 0; i--) {
			if (maze[i][L - 3] == 0) {
				maze[i][L - 2] = 0;
				startX = 2;
				startY = 1;
				endX = i;
				endY = L - 2;
				break;
			}
		}
		// try { Thread.sleep(5000); } catch (InterruptedException e) {
		// e.printStackTrace(); }
	}

	public int[][] getMaze() {
		return maze;
	}

}