package application;
	
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Stage window;
	public static final int WINDOW_WIDTH =	1280;
	public static final int WINDOW_HEIGHT = 1280;
	private static Group root;
	private static Scene scene;
	private static GraphicsContext gc;
	private static Canvas canvas;
	
	
	@Override
	public void start(Stage primaryStage) {
		window = primaryStage;
		root = new Group();
		canvas = new Canvas(WINDOW_WIDTH, WINDOW_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		
		root.getChildren().add(canvas);
		
		scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		

		
		
		AntEngine engine = new AntEngine();
		engine.init();
		engine.start();
		
		window.setScene(scene);
		window.sizeToScene();
		window.setTitle("Barcelona's version of Langton's Ant");
		window.show();
		
	}
	
	public static Stage getWindow() {
		return window;
	}
	
	public static GraphicsContext getGC() {
		return gc;
	}
	
	public static Scene getScene() {
		return scene;
	}
	
	public static Canvas getCanvas() {
		return canvas;
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
