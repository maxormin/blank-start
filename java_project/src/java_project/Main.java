package java_project;

import fx.Second_stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;;

public class Main extends Application {
	private Stage stage = new Stage();
	private Stage stage2 = new Stage();

	// private int[][] maze;
	class Bt1 implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			Second_stage a = new Second_stage();
			try {
				a.start(stage2);
				stage.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	class Bt3 implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			// TODO Auto-generated method stub
			System.exit(0);
		}

	}

	public void start(Stage primaryStage) {
		// --------------------------
		// set stage
		// --------------------------
		stage = primaryStage;
		Pane pane = new Pane();
		VBox vBox = new VBox();

		Text text1 = new Text("迷宫游戏");
		text1.getStyleClass().add("text1");
		text1.setTranslateX(815);
		text1.setTranslateY(290);
		pane.getChildren().add(text1);

		pane.getChildren().add(vBox);
		// -------
		Button enter = new Button("进入游戏");
		Bt1 bt1 = new Bt1();
		enter.setOnAction(bt1);
		// -------
		Button setting = new Button("设置");

		// -------
		Button exit = new Button("退出");
		Bt3 bt3 = new Bt3();
		exit.setOnAction(bt3);
		// -------
		vBox.getChildren().addAll(enter, setting, exit);
		vBox.setTranslateX(850);
		vBox.setTranslateY(400);
		vBox.setSpacing(30);
		// --------

		Scene scene = new Scene(pane, 1920, 1080);
		scene.getStylesheets().add(getClass().getResource("menu.css").toExternalForm());
		primaryStage.setTitle("maze");
		primaryStage.getIcons().add(new Image("file:image/timg.jpg"));
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
