package application;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Login {
	@FXML
	TextField u;
	@FXML
	TextField p;
	@FXML
	Button submit;
	@FXML
	Button clear;
	@FXML
	Button clickMe;
	
	String username;
	static String password;
	
	
	public void clear() {                        //Form clear function.
		u.setText("");
		p.setText("");
	}
	
	public void addUser(ActionEvent event) throws IOException {
		Parent view1 = FXMLLoader.load(getClass().getResource("SignUpForm.fxml"));
        Scene scene1 = new Scene(view1);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
	}
	
	public void onSubmit(ActionEvent event) throws IOException, SQLException{
		username = u.getText();		
		password = p.getText();
		boolean flag = validate(username,password);
		
		if(flag==true) {
		Parent view1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene1 = new Scene(view1);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
		}
		else {
			System.out.println("Wrong credentials");
			Parent view2 = FXMLLoader.load(getClass().getResource("WrongCredentials.fxml"));
	        Scene scene2 = new Scene(view2);
	        Stage window = new Stage();
	        window.setScene(scene2);
	        window.show();
		}
	}
	                                        //validating credentials
	public boolean validate(String user,String pass) throws SQLException {    
		ResultSet myRs = null;
		Main.myStmt = Main.myConn.createStatement();
		try {
				myRs = Main.myStmt.executeQuery("select pasword from customer where firstname='"+user+"';");
				myRs.next();
				if(myRs.getString("pasword").equals(pass))
					return true;
				else
					return false;		
		}
		catch (Exception e){
			System.out.println(e);
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (Main.myStmt != null) {
				Main.myStmt.close();
			}
		}
		return false;
	}
}