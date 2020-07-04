package application;

import java.io.IOException;
import java.sql.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class resetPass {
	@FXML
	Button clear;
	@FXML
	Button reset;
	@FXML
	PasswordField newp;
	@FXML
	PasswordField rep;
	
	public void clear() {
		newp.setText("");
		rep.setText("");
	}
	
	public void reset(ActionEvent event)throws IOException,SQLException {
		String query;
		String newpass = newp.getText();
		String repeat = rep.getText();
		if(newpass.equals(repeat)) {
			Main m = new Main();
			Connection myConn = m.getConnection();
			Statement myStmt = myConn.createStatement();
			query = "update customer set pasword='"+newpass+"' where username='"+Login.getUsername()+"';";
			int rows = myStmt.executeUpdate(query);
			System.out.println(rows +" rows affected.");
			
			Parent view1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			Scene scene1 = new Scene(view1);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
	        window.setScene(scene1);
	        window.show();
	        
	      //display success page
			Parent view3 = FXMLLoader.load(getClass().getResource("Success.fxml")); //Going to Home page
	        Scene scene3 = new Scene(view3);
	        Stage window3 = new Stage();
	        window3.setScene(scene3);
	        window3.show();
		}
		else
			System.out.println("Both passwords don't match.");
	}
}
