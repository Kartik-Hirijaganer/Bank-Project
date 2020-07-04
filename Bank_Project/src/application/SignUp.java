package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignUp {
	                                    //Registration form labels
	@FXML
	TextField firstName;
	@FXML
	TextField lastName;
	@FXML
	TextField email;
	@FXML
	TextField username;
	@FXML
	TextField password;
	@FXML
	DatePicker dob;
	@FXML
	Button submit;
	@FXML
	Button clear;
	@FXML
	RadioButton male;
	@FXML
	RadioButton female;
	Main m = new Main();

	@FXML    	//display successful window on clicking submit.
    private void onSubmit(ActionEvent event)throws IOException, InterruptedException, SQLException{
		getDetails();
        Parent view1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene scene1 = new Scene(view1);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
                
        Parent view2 = FXMLLoader.load(getClass().getResource("Success.fxml")); //Going to Home page
        Scene scene2 = new Scene(view2);
        window = new Stage();
        window.setScene(scene2);
        window.show();
    }
	
	public void clear() {                        //Form clear function.
		firstName.setText("");
		lastName.setText("");
		email.setText("");
		password.setText("");		
	}	
	
	public void getDetails() throws SQLException  //Gets data from registration form
	{
		String first = firstName.getText();
		String last = lastName.getText();
		String emailid = email.getText();
		String user = username.getText();
		String pass = password.getText();		
		
		LocalDate d = dob.getValue();    //Getting date value
		String date = d.toString();		
		
		String gender="";               //Getting gender value from radio button
		if(male.isSelected())
			gender = "M";
		else if(female.isSelected())
			gender = "F";
		else
			System.out.println("Enter gender.");	
		
		Connection myConn = m.getConnection();
		Statement myStmt = myConn.createStatement();
		try {
			
			String query = "('"+first+"','"+last+"','"+emailid+"','"+user+"','"+pass+"','"+date+"','"+gender+"');";
			String sql = "insert into customer(firstname,lastname,email,username,pasword,dateOfBirth,gender) values"+query;
			myStmt=myConn.createStatement();
			myStmt.executeUpdate(sql);
			System.out.println("Data Successfully added.");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myStmt != null) {
				myStmt.close();
			}
		}
	}
}