package fx;

import algorithm.Dfs;
import java_project.Main;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import mazeCreate.MazeCreate;

class Stage3 extends Application {
	private TextField startX = new TextField();
	private TextField startY = new TextField();
	private TextField endX = new TextField();
	private TextField endY = new TextField();
	private Stage stage = new Stage();
	private MazeCreate create;
	private int x1, y1, x2, y2;

	class Bt1 implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			x1 = Integer.parseInt(startX.getText());
			y1 = Integer.parseInt(startY.getText());
			x2 = Integer.parseInt(endX.getText());
			y2 = Integer.parseInt(endY.getText());
			create.setStartX(x1);
			create.setStartY(y1);
			create.setEndX(x2);
			create.setEndY(y2);
			stage.close();
		}

	}

	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		Pane pane = new Pane();
		VBox vb = new VBox();
		pane.getChildren().add(vb);
		pane.getStyleClass().add("background");

		Label Label1 = new Label("起始点坐标");
		Label Label2 = new Label("结束点坐标");
		Text text1 = new Text("------>y");
		Text text2 = new Text("------>x");
		Text text3 = new Text("x:");
		Text text4 = new Text("y:");
		Label1.setTranslateX(113);
		Label1.setTranslateY(3);
		Label2.setTranslateX(113);
		Label2.setTranslateY(93);
		text1.setTranslateX(10);
		text1.setTranslateY(35);
		text2.setRotate(90);
		text2.setTranslateX(-19);
		text2.setTranslateY(64);
		text3.setTranslateX(87);
		text3.setTranslateY(40);
		text3.getStyleClass().add("text3_4");
		text4.setTranslateX(87);
		text4.setTranslateY(72);
		text4.getStyleClass().add("text3_4");
		pane.getChildren().addAll(Label1, Label2, text1, text2, text3, text4);

		Button button1 = new Button("确认");
		Bt1 bt1 = new Bt1();
		button1.setOnAction(bt1);
		button1.setTranslateX(108);
		button1.setTranslateY(223);
		pane.getChildren().add(button1);

		startX.getStyleClass().add("point");
		vb.getChildren().add(startX);
		startY.getStyleClass().add("point");
		vb.getChildren().add(startY);
		endX.setTranslateY(30);
		endX.getStyleClass().add("point2");
		vb.getChildren().add(endX);
		endY.setTranslateY(30);
		endY.getStyleClass().add("point2");
		vb.getChildren().add(endY);
		vb.setTranslateX(100);
		vb.setTranslateY(20);

		Scene scene = new Scene(pane, 750, 500);
		scene.getStylesheets().add(getClass().getResource("maze_extend.css").toExternalForm());
		primaryStage.setTitle("maze");
		primaryStage.getIcons().add(new Image("file:image/timg.jpg"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public int getX2() {
		return x2;
	}

	public int getY2() {
		return y2;
	}

	public void setCreate(MazeCreate create) {
		this.create = create;
	}
}

class bt1_maze extends Pane {
	private int[][] maze;
	private MazeCreate create;
	private TextField fileroad;

	public void maze() {
		getChildren().clear();
		create = new MazeCreate();
		String road = fileroad.getText();
		create.setRoad(road);
		create.menu(1);
		this.maze = create.getMaze();
		LinePane line = new LinePane(maze); // map
		line.linepane();
		line.setTranslateX(50);
		line.setTranslateY(50);
		getChildren().add(line);
		Stage3 a = new Stage3();
		Stage stage3 = new Stage();
		try {
			a.start(stage3);
			a.setCreate(create);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * int x1 = Integer.parseInt(startX.getText()); int y1 =
		 * Integer.parseInt(startY.getText()); int x2 =
		 * Integer.parseInt(endX.getText()); int y2 = Integer.parseInt(endY.getText());
		 * create.setStartX(x1); create.setStartY(y1); create.setEndX(x2);
		 * create.setEndY(y2);
		 */
	}

	public void setFileroad(TextField fileroad) {
		this.fileroad = fileroad;
	}

	public int[][] getMaze() {
		return maze;
	}

	public MazeCreate getCreate() {
		return create;
	}
}

class bt2_maze extends Pane {
	private int[][] maze;
	private MazeCreate create;

	public void maze() {
		getChildren().clear();
		create = new MazeCreate();
		create.menu(2);
		this.maze = create.getMaze();
		LinePane line = new LinePane(maze); // map
		line.linepane();
		line.setTranslateX(50);
		line.setTranslateY(50);
		getChildren().add(line);
	}

	public int[][] getMaze() {
		return maze;
	}

	public MazeCreate getCreate() {
		return create;
	}
}

class bt3_find extends Pane {
	private Timeline timeline;
	private Dfs sta;
	private int speed;

	public void find_maze(MazeCreate create, int a) {
		sta = new Dfs(create.getStartX(), create.getStartY(), create.getEndX(), create.getEndY()); // find road
		sta.start(create.getMaze());
		// maze
		sta.setTranslateX(50);
		sta.setTranslateY(50);
		getChildren().add(sta);
		if (a % 2 == 0) {
			// 动画
			EventHandler<ActionEvent> eventHandler = e -> {
				int m = sta.hua_line(1);
				if (m == 2) {
					sta.getChildren().clear();
				}
			};
			timeline = new Timeline(new KeyFrame(Duration.millis(speed), eventHandler));
			timeline.setCycleCount(Timeline.INDEFINITE);
			timeline.play();
		} else {
			getChildren().clear();
			sta.hua_line(2);
			timeline.stop();
		}
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}

class bt4_findAll extends Pane {
	private Timeline timeline;
	private Dfs sta;
	private int speed;

	public void findAll_maze(MazeCreate create, int b) {
		sta = new Dfs(create.getStartX(), create.getStartY(), create.getEndX(), create.getEndY()); // find road
		sta.start(create.getMaze());
		// maze
		sta.setTranslateX(50);
		sta.setTranslateY(50);
		getChildren().add(sta);
		if (b % 2 == 0) {
			// 动画
			EventHandler<ActionEvent> eventHandler = e -> {
				sta.getChildren().clear();
				sta.hua_road();
			};
			timeline = new Timeline(new KeyFrame(Duration.millis(speed), eventHandler));
			timeline.setCycleCount(Timeline.INDEFINITE);
			timeline.play();
		} else {
			getChildren().clear();
			timeline.stop();
		}
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
}

public class Second_stage extends Application {
	private MazeCreate create;
	private TextField fileroad = new TextField();
	private bt1_maze button1 = new bt1_maze();
	private bt2_maze button2 = new bt2_maze();
	private bt3_find button3 = new bt3_find();
	private bt4_findAll button4 = new bt4_findAll();
	private static int a = 0;
	private static int b = 0;
	private int speed = 600;
	private int speed2 = 210;
	private Stage stage;

	class Bt1 implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			button1.setFileroad(fileroad);
			button1.maze();
			create = button1.getCreate();
		}

	}

	class Bt2 implements EventHandler<ActionEvent> {
		// private int[][] maze;
		@Override
		public void handle(ActionEvent event) {
			button2.maze();
			// maze = button2.getMaze();
			create = button2.getCreate();
		}
	}

	class Bt3 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			button3.setSpeed(speed);
			button3.find_maze(create, a);
			a++;
		}
	}

	class Bt4 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			button4.setSpeed(speed2);
			button4.findAll_maze(create, b);
			b++;
		}
	}

	class Bt5 implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			Stage stage1 = new Stage();
			Main a = new Main();
			a.start(stage1);
			stage.close();
		}

	}

	class Rbt1 implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			speed = 600;
		}

	}

	class Rbt2 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			speed = 300;
		}
	}

	class Rbt3 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			speed = 100;
		}
	}

	class Rbt4 implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			speed2 = 210;

		}

	}

	class Rbt5 implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			speed2 = 105;

		}

	}

	class Rbt6 implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			speed2 = 70;

		}

	}

	public void start(Stage primaryStage) throws Exception {

		// --------------------------------
		// stage set
		// -----------------------------------
		stage = primaryStage;
		Pane pane = new Pane();
		VBox vb = new VBox();
		HBox hb = new HBox();
		HBox hb2 = new HBox();

		// button
		// -----------------------------
		pane.getChildren().addAll(vb);
		pane.getChildren().addAll(hb, hb2);

		Button createMaze = new Button("导入.txt迷宫路径");
		Bt1 bt1 = new Bt1();
		createMaze.setOnAction(bt1);
		// ****************************
		Text text = new Text("迷宫");
		Text text2 = new Text("<-----");
		Text text3 = new Text("<-----");

		Label Label1 = new Label("读取路径");
		text.setId("p_text");
		text.setTranslateX(490);
		text.setTranslateY(40);
		text2.setTranslateX(1200);
		text2.setTranslateY(383);
		text3.setTranslateX(1200);
		text3.setTranslateY(440);

		fileroad.setTranslateX(1080);
		fileroad.setTranslateY(200);
		pane.getChildren().add(fileroad);
		pane.getChildren().addAll(text, text2, text3);
		pane.getChildren().add(Label1);

		Label1.setTranslateX(1080);
		Label1.setTranslateY(180);

		pane.getChildren().add(button1);
		// ***********************************
		// ----------------------------------------
		Button self_maze = new Button("自动生成迷宫");
		Bt2 bt2 = new Bt2();
		self_maze.setOnAction(bt2);
		pane.getChildren().add(button2);
		// --------------------------------------------
		Button inputMaze = new Button("输出最短路径");
		Bt3 bt3 = new Bt3();
		inputMaze.setOnAction(bt3);
		pane.getChildren().add(button3);
		// --------------------------------------
		Button inputMaze2 = new Button("输出所有路径");
		Bt4 but4 = new Bt4();
		inputMaze2.setOnAction(but4);
		pane.getChildren().add(button4);
		// -----------------------
		Button re_menu = new Button("返回菜单");
		Bt5 bt5 = new Bt5();
		re_menu.setOnAction(bt5);

		vb.getChildren().addAll(createMaze, self_maze, inputMaze, inputMaze2, re_menu);
		vb.setTranslateX(1080);
		vb.setTranslateY(250);
		vb.setSpacing(30);
		createMaze.getStyleClass().add("my_button");
		self_maze.getStyleClass().add("my_button2");
		inputMaze.getStyleClass().add("my_button3");
		inputMaze2.getStyleClass().add("my_button4");
		re_menu.getStyleClass().add("my_button5");

		// ---------------------
		RadioButton rbt1 = new RadioButton("x1");
		Rbt1 speed1 = new Rbt1();
		rbt1.setOnAction(speed1);
		// --------------------
		RadioButton rbt2 = new RadioButton("x2");
		Rbt2 speed2 = new Rbt2();
		rbt2.setOnAction(speed2);
		// --------------------
		RadioButton rbt3 = new RadioButton("x3");
		Rbt3 speed3 = new Rbt3();
		rbt3.setOnAction(speed3);

		ToggleGroup chose = new ToggleGroup();
		rbt1.setSelected(true);
		rbt1.setToggleGroup(chose);
		rbt2.setToggleGroup(chose);
		rbt3.setToggleGroup(chose);
		rbt1.getStyleClass().add("rbt1");
		rbt2.getStyleClass().add("rbt2");
		rbt3.getStyleClass().add("rbt3");
		hb.getChildren().addAll(rbt1, rbt2, rbt3);
		hb.setTranslateX(1248);
		hb.setTranslateY(368);

		// -----------------------------
		// ---------------------
		RadioButton rbt4 = new RadioButton("x1");
		Rbt4 speed4 = new Rbt4();
		rbt4.setOnAction(speed4);
		// --------------------
		RadioButton rbt5 = new RadioButton("x2");
		Rbt5 speed5 = new Rbt5();
		rbt5.setOnAction(speed5);
		// --------------------
		RadioButton rbt6 = new RadioButton("x3");
		Rbt6 speed6 = new Rbt6();
		rbt6.setOnAction(speed6);

		ToggleGroup chose2 = new ToggleGroup();
		rbt4.setSelected(true);
		rbt4.setToggleGroup(chose2);
		rbt5.setToggleGroup(chose2);
		rbt6.setToggleGroup(chose2);
		rbt4.getStyleClass().add("rbt1");
		rbt5.getStyleClass().add("rbt2");
		rbt6.getStyleClass().add("rbt3");
		hb2.getChildren().addAll(rbt4, rbt5, rbt6);
		hb2.setTranslateX(1248);
		hb2.setTranslateY(425);

		// background
		/*
		 * Image image = new Image("file:image/1.jpg"); ImageView img = new
		 * ImageView(image); img.setFitHeight(1080/2); img.setFitWidth(1920/2);
		 * pane.getChildren().add(img);
		 */
		pane.getStyleClass().add("background");
		// pane.getStyleClass().add("root");

		Scene scene = new Scene(pane, 1920, 1080);
		scene.getStylesheets().add(getClass().getResource("maze_extend.css").toExternalForm());
		primaryStage.setTitle("maze");
		primaryStage.getIcons().add(new Image("file:image/timg.jpg"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}

class LinePane extends Pane {
	private int[][] maze;
	private int len;

	public LinePane(int[][] maze) {
		this.maze = maze;
		int max = maze[0].length > maze.length ? maze[0].length : maze.length;
		this.len = 980 / max;
	}

	public void linepane() {
		int i, j;
		Rectangle rectangle;
		for (i = 0; i < maze.length; i++) {
			for (j = 0; j < maze[0].length; j++) {
				if (maze[i][j] == 1) {
					rectangle = new Rectangle(j * len, i * len, len, len);
					rectangle.setStroke(Color.CADETBLUE);
					rectangle.getStyleClass().add("wall");
					getChildren().add(rectangle);
				}
			}
		}

	}
}
