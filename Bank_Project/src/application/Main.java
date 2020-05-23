package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	public static Connection myConn = null;
	public static Statement myStmt;
	public static ResultSet myRs;

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root,700,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws SQLException{
		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "BankProject" , "BankProject");
		System.out.println("Database connection successful!\n");
//		Statement myStmt = myConn.createStatement();
//		ResultSet myRs = null;
		
		launch(args);
	}
}
