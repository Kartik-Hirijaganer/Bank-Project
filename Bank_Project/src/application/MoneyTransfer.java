package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.*;
public class MoneyTransfer {
	
	@FXML
	Button back;
	@FXML
	Button submit;
	@FXML
	TextField u;
	@FXML
	TextField a;
	
	Main m = new Main();
	String query;
	int rows;
	
	public void back(ActionEvent event) throws IOException {
		System.out.println("Back to home page");
		Parent view1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		Scene scene1 = new Scene(view1);
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
	}
	
	public void submit(ActionEvent event)throws IOException,SQLException{
		Connection myConn = m.getConnection();
		Statement myStmt = myConn.createStatement();
		ResultSet myRs = null;
		
		String username = u.getText();
		int amount = Integer.parseInt(a.getText());
		deductAmount(amount);
		
		query = "select money from customer where username='"+username+"';";
		myRs = myStmt.executeQuery(query);
		myRs.next();
		amount += myRs.getInt("money");
		query = "update customer set money="+amount+" where username='"+username+"';";
		rows = myStmt.executeUpdate(query);
		System.out.println(rows+" rows affected");
		
		//return to home page
		Parent view2 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		Scene scene2 = new Scene(view2);
		Stage window2 = (Stage)((Node)event.getSource()).getScene().getWindow();
		window2.setScene(scene2);
		window2.show();
		
		//display success page
		Parent view3 = FXMLLoader.load(getClass().getResource("Success.fxml")); //Going to Home page
        Scene scene3 = new Scene(view3);
        Stage window3 = new Stage();
        window3.setScene(scene3);
        window3.show();
	}
	
	public void deductAmount(int money)throws SQLException {
		query = "update customer set money="+money+" where username='"+Login.getUsername()+"';";
		Connection myConn = m.getConnection();
		Statement myStmt = myConn.createStatement();
		rows = myStmt.executeUpdate(query);
		System.out.println(rows+" affected.");
	}

}
