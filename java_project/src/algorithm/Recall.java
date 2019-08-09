package algorithm;

import java.util.Stack;

public class Recall {
	private int[][] maze;
	private int x;
	private int y;
	private Stack<Point> num;
	private Stack<Point> road;
	private boolean[][] maze1;

	public Recall(int x, int y, int[][] maze, Stack<Point> num, boolean[][] maze1, Stack<Point> road) {
		this.maze = maze;
		this.x = x;
		this.y = y;
		this.num = num;
		this.maze1 = maze1;
		this.road = road;
	}

	public void recallpoint() {
		while (true) {
			maze1[num.peek().getX()][num.peek().getY()] = false;
			road.push(num.pop());
			if (num.empty()) {
				return;
			} else if (num.peek().getNode() > 1) {
				num.peek().setNode(num.peek().getNode() - 1);
				num.peek().setRoad(num.peek().getRoad() + 1);
				road.push(num.peek());
				break;
			}
		}
		// System.out.println("recall success");
		// System.out.println(num.peek().toString());
		int x = num.peek().getX();
		int y = num.peek().getY();
		renext point = new renext(maze, num.peek().getRoad(), maze1);
		point.nextPoint(num);
		x = point.getX();
		y = point.getY();
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
}

class renext {
	private static int[][] maze;
	private boolean maze1[][];
	private int x;
	private int y;
	private int road;

	public renext(int[][] maze, int road, boolean[][] maze1) {
		this.maze = maze.clone();
		this.road = road;
		this.maze1 = maze1;
	}

	public void nextPoint(Stack<Point> num) {
		int x = num.peek().getX();
		int y = num.peek().getY();
		int road = 0;
		if (num.size() > 1) {
			Point a = num.pop();
			int x1 = num.peek().getX();
			int y1 = num.peek().getY();
			int m, n, m2 = 0, n2 = 0; // m-right n-left
			// right
			m = x - x1;
			n = y - y1;
			if (m == 1) {
				m = x;
				m2 = x;
				n = y - 1;
				n2 = y + 1;
			} else if (m == -1) {
				m = x;
				m2 = x;
				n = y + 1;
				n2 = y - 1;
			} else if (n == 1) {
				m = x + 1;
				m2 = x - 1;
				n = y;
				n2 = y;
			} else if (n == -1) {
				m = x - 1;
				m2 = x + 1;
				n = y;
				n2 = y;
			}
			if (m >= 0 && n >= 0 && m < maze.length && n < maze[0].length && maze[m][n] == 0 && maze1[m][n] != true) {
				this.x = m;
				this.y = n;
				road++;
			}
			if (road == this.road) {
				num.push(a);
				return;
			}
			// straight line
			m = x + x - x1;
			n = y + y - y1;
			if (m >= 0 && n >= 0 && m < maze.length && n < maze[0].length && maze[m][n] == 0 && maze1[m][n] != true) {
				this.x = m;
				this.y = n;
				road++;
			}
			if (road == this.road) {
				num.push(a);
				return;
			}
			if (m2 >= 0 && n2 >= 0 && m2 < maze.length && n2 < maze[0].length && maze[m2][n2] == 0
					&& maze1[m2][n2] != true) {
				this.x = m2;
				this.y = n2;
				road++;
			}
			if (road == this.road) {
				num.push(a);
				return;
			}
		} else {
			if (x + 1 < maze.length && maze[x + 1][y] == 0) {
				this.x = x + 1;
				this.y = y;
				return;
			}
			if (x - 1 >= 0 && maze[x - 1][y] == 0) {
				this.x = x - 1;
				this.y = y;
				return;
			}
			if (y + 1 < maze[0].length && maze[x][y + 1] == 0) {
				this.x = x;
				this.y = y + 1;
				return;
			}
			if (y - 1 >= 0 && maze[x][y - 1] == 0) {
				this.x = x;
				this.y = y - 1;
				return;
			}
		}
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}