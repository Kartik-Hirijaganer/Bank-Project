package application;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddRemove {
	@FXML
	Button confirm;
	@FXML
	Button submit;
	@FXML
	Button clear;
	@FXML
	Button back;
	@FXML
	TextField money;
	
	int amount=0;
	String sql,query;
	ResultSet myRs = null;
	public void addMoney(ActionEvent event) throws SQLException, IOException {
		try {
			amount = Integer.parseInt(money.getText());
			Main.myStmt=Main.myConn.createStatement();
			query = "select income from income where pasword='"+Login.password+"';";
			myRs = Main.myStmt.executeQuery(query);
			myRs.next();
			amount += Integer.parseInt(myRs.getString("income"));
			sql = "update income set income="+amount+" where pasword='"+Login.password+"';";
			Main.myStmt.executeUpdate(sql);
			
			//return to home page
			Parent view1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			Scene scene1 = new Scene(view1);
			Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
			window1.setScene(scene1);
			window1.show();
			
			//success page
			Parent view = FXMLLoader.load(getClass().getResource("Success.fxml")); //Going to Home page
			Scene scene = new Scene(view);
			Stage window = new Stage();
			window.setScene(scene);
			window.show();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (Main.myStmt != null) {
				Main.myStmt.close();
			}
		}
	}
	
	public void clear() {
		money.setText("");
	}
	
	public void removeMoney(ActionEvent event) throws SQLException, IOException {
		try {
			Main.myStmt=Main.myConn.createStatement();
			amount = Integer.parseInt(money.getText());
			query = "select income from income where pasword='"+Login.password+"';";
			myRs=Main.myStmt.executeQuery(query);
			myRs.next();
			amount -= Integer.parseInt(myRs.getString("income"));
			sql = "update income set income="+amount+" where pasword='"+Login.password+"';";
			Main.myStmt.executeUpdate(sql);
			   
			//return to home page
			Parent view1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
	        Scene scene1 = new Scene(view1);
	        Stage window1 = (Stage)((Node)event.getSource()).getScene().getWindow();
	        window1.setScene(scene1);
	        window1.show();
	        
	        //success page
	      	Parent view = FXMLLoader.load(getClass().getResource("Success.fxml")); //Going to Home page
	      	Scene scene = new Scene(view);
	      	Stage window = new Stage();
	      	window.setScene(scene);
	      	window.show();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (Main.myStmt != null) {
				Main.myStmt.close();
			}
		}
	}
	
	public void Back(ActionEvent event) throws IOException {
		Parent view1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene1 = new Scene(view1);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
	}
}
