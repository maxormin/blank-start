package algorithm;

import java.util.Stack;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class Dfs extends Pane {
	private Stack<Point> maze_min;
	private Stack<Point> maze_min2;
	private Stack<Point> road_All;
	private Stack<Point> road_All2;
	private int len;
	private int x, y;
	private int endx, endy;

	public Dfs(int x, int y, int endx, int endy) {
		this.endx = endx;
		this.endy = endy;
		this.x = x;
		this.y = y;
	}

	@SuppressWarnings("unchecked")
	public void start(int[][] maze) {
		int x = this.x, y = this.y, node;
		int endx = this.endx, endy = this.endy;
		boolean[][] maze1 = new boolean[maze.length][maze[0].length];
		Point point = new Point(x, y);
		Stack<Point> num = new Stack<>();
		Stack<Point> min = new Stack<>();
		Stack<Point> road = new Stack<>();
		findPoint find = new findPoint(maze, maze1);
		Recall re;
		next poi = new next(maze);
		do {
			node = find.findNode(x, y, num);
			point.setNode(node);
			num.push(point);
			maze1[x][y] = true;
			road.push(point);
			poi.nextPoint(num);
			x = poi.getX();
			y = poi.getY();
			// recall
			if ((x == -1 && y == -1) || maze1[x][y] == true || (x == endx && y == endy)) {
				if (x == endx && y == endy) {
					num.push(new Point(x, y));
					road.push(new Point(x, y));
					if (min.empty())
						min = (Stack<Point>) num.clone();
					else if (min.size() > num.size())
						min = (Stack<Point>) num.clone();
				}
				/*
				 * int[] tempx = new int[num.size()]; int[] tempy = new int[num.size()]; int len
				 * = num.size(); Stack<Point> temp = new Stack<Point>(); for (int i = 0; i <
				 * len; i++) { tempx[i] = num.peek().getX(); tempy[i] = num.peek().getY();
				 * temp.push(num.pop()); for (int j = 0; j < i; j++) { if (tempx[i] == tempx[j]
				 * && tempy[i] == tempy[j]) { System.out.println("error: " + i + " " + j);
				 * System.exit(1); } } } for (int i = 0; i < len; i++) { num.push(temp.pop()); }
				 */
				re = new Recall(x, y, maze, num, maze1, road);
				re.recallpoint();
				if (num.empty() == true)
					break;
				x = re.getX();
				y = re.getY();
			}
			point = new Point(x, y);
			if (x == endx && y == endy) {
				if (min.empty())
					min = (Stack<Point>) num.clone();
				else if (min.size() > num.size()) {
					min = (Stack<Point>) num.clone();
					min.push(point);
					road.push(point);
				}
			}

			// try { Thread.sleep(1000); } catch (InterruptedException e) {
			// e.printStackTrace(); }

		} while (true);
		// System.out.println("×î¶ÌÂ·¾¶");
		int len = min.size();
		for (int i = 0; i < len; i++) {
			num.push(min.pop());
		}
		maze_min = num;
		maze_min2 = (Stack<Point>) maze_min.clone();
		int max = maze.length > maze[0].length ? maze.length : maze[0].length;
		this.len = 980 / max;

		long len2 = road.size();
		Stack<Point> temp = new Stack<>();
		while (!road.empty()) {
			temp.push(road.pop());
		}
		road_All = temp;
		road_All2 = (Stack<Point>) road_All.clone();
		// best short road
		/*
		 * for (int i = 0; i < len; i++) { System.out.println(num.peek().toString()); if
		 * (roadx == -1) { roadx = num.peek().getX(); roady = num.peek().getY(); } else
		 * { Line line = new Line(roady * 50, roadx * 50, num.peek().getY() * 50,
		 * num.peek().getX() * 50); line.setStroke(Color.GREEN); line.setStrokeWidth(3);
		 * getChildren().add(line); roadx = num.peek().getX(); roady =
		 * num.peek().getY(); } num.pop(); }
		 */
	}

	private static int roadx = -1, roady = -1;

	public int hua_line(int re) {
		int m = 0;
		if (maze_min.empty() || re == 2) {
			maze_min = (Stack<Point>) maze_min2.clone();
			roadx = -1;
			roady = -1;
			return 2;
		}
		if (roadx == -1) {
			roadx = maze_min.peek().getX();
			roady = maze_min.peek().getY();
			m = 0;
		} else {
			Line line = new Line(roady * len + len / 2, roadx * len + len / 2, maze_min.peek().getY() * len + len / 2,
					maze_min.peek().getX() * len + len / 2);
			line.setStroke(Color.BLUE);
			line.setStrokeWidth(3);
			getChildren().add(line);
			// System.out.println(roady+" "+roadx);
			// System.out.println(maze_min.peek().getY()+" "+maze_min.peek().getX());
			roadx = maze_min.peek().getX();
			roady = maze_min.peek().getY();
			m = 1;
			// try { Thread.sleep(5000); } catch (InterruptedException e) {
			// e.printStackTrace(); }
		}
		maze_min.pop();
		return m;
	}

	public void hua_road() {
		if (road_All.empty()) {
			road_All = (Stack<Point>) road_All2.clone();
			return;
		}
		Rectangle rectangle = new Rectangle(road_All.peek().getY() * len, road_All.peek().getX() * len, len, len);
		rectangle.setStroke(Color.GREEN);
		getChildren().add(rectangle);
		road_All.pop();
		return;
	}
}

// right rule
class next {
	private static int[][] maze;
	private int x;
	private int y;

	public next(int[][] maze) {
		next.maze = maze.clone();
	}

	public void nextPoint(Stack<Point> num) {
		int x = num.peek().getX();
		int y = num.peek().getY();
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
			if (m >= 0 && n >= 0 && m < maze.length && n < maze[0].length && maze[m][n] == 0) {
				this.x = m;
				this.y = n;
				num.push(a);
				return;
			}
			// straight line
			m = x + x - x1;
			n = y + y - y1;
			if (m >= 0 && n >= 0 && m < maze.length && n < maze[0].length && maze[m][n] == 0) {
				this.x = m;
				this.y = n;
				num.push(a);
				return;
			}

			if (m2 >= 0 && n2 >= 0 && m2 < maze.length && n2 < maze[0].length && maze[m2][n2] == 0) {
				this.x = m2;
				this.y = n2;
				num.push(a);
				return;
			}
			// step back
			else {
				this.x = -1;
				this.y = -1;
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

class findPoint {
	private static int[][] maze;
	private static boolean[][] maze1;

	public findPoint(int[][] maze, boolean[][] maze1) {
		findPoint.maze = maze.clone();
		this.maze1 = maze1;
	}

	public static int findNode(int x, int y, Stack<Point> num) {
		int node = 0;
		if (num.size() < 1) {
			if (x + 1 < maze.length && maze[x + 1][y] == 0 && maze1[x + 1][y] != true)
				node++;
			if (x - 1 >= 0 && maze[x - 1][y] == 0 && maze1[x - 1][y] != true)
				node++;
			if (y + 1 < maze[0].length && maze[x][y + 1] == 0 && maze1[x][y + 1] != true)
				node++;
			if (y - 1 >= 0 && maze[x][y - 1] == 0 && maze1[x][y - 1] != true)
				node++;
		} else {
			if (x + 1 < maze.length && maze[x + 1][y] == 0 && x + 1 != num.peek().getX() && maze1[x + 1][y] != true) {
				node++;
			}
			if (x - 1 >= 0 && maze[x - 1][y] == 0 && x - 1 != num.peek().getX() && maze1[x - 1][y] != true) {
				node++;
			}
			if (y + 1 < maze[0].length && maze[x][y + 1] == 0 && y + 1 != num.peek().getY()
					&& maze1[x][y + 1] != true) {
				node++;
			}
			if (y - 1 >= 0 && maze[x][y - 1] == 0 && y - 1 != num.peek().getY() && maze1[x][y - 1] != true) {
				node++;
			}
		}
		return node;
	}
}

class Point implements Cloneable {
	private int x;
	private int y;
	private int node;
	private int road = 1;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

	@Override
	public Object clone() {
		try {
			return (Point) super.clone();
		} catch (CloneNotSupportedException ex) {
			return null;
		}
	}

	public int getRoad() {
		return road;
	}

	public void setRoad(int road) {
		this.road = road;
	}
}
