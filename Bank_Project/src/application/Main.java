package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	//--module-path D:\JFx\javafx-sdk-11.0.2\lib\  --add-modules=javafx.controls,javafx.fxml//
	//Add user lib JavaFx, them run as configuration-> Arguments->vm arguments->paste the above path.
	
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
	public static void main(String[] args){
		launch(args);
	}
	public Connection getConnection() throws SQLException {
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "BankProject" , "BankProject");
		return myConn;
	}
}
