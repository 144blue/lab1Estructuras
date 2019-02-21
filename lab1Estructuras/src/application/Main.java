package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.NewtonRapson;
import javafx.scene.Scene;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import model.Bairstow;

public class Main extends Application {
	
	private static Main instanceMain;
	private NewtonRapson nr;
	private Bairstow bt;
	
	public Main() {
		Main.instanceMain=this;
		bt=new Bairstow();
	}
	
	public String methodBairstow(double a[], double r0, double s0, double re[], double im[]) {
		return bt.BairstowMethod(a, r0, s0, re, im);
	}
	
	public String methodNewtonRaphson(int[] a,double x) {
		return NewtonRapson.methodNewtonRaphson(a,x);
	}
	
	public static Main instance() {
		return instanceMain;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			TabPane root = (TabPane)FXMLLoader.load(getClass().getResource("Index.fxml"));
			Scene scene = new Scene(root);
		//	scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
