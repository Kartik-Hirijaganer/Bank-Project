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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddDetails {
	@FXML
	TextField i;
	@FXML
	TextField p;
	@FXML
	TextField org;
	@FXML
	TextField e;
	@FXML
	TextArea a;
	@FXML
	Button add;
	@FXML
	Button clear;
	
	String query;
	Main m = new Main();
	                         //Getting data from AddDetails
	public void addDetails() throws SQLException{	
		int money = Integer.parseInt(i.getText());
		int pincode = Integer.parseInt(p.getText());
		String organisation = org.getText();
		String email = e.getText();
		query = "pincode="+pincode+",email='"+email+"',organisation='"+organisation+"',money="+money;
		addQuery();
	}
	
	public void clear() {                        //Form clear function.
		i.setText("");
		p.setText("");
		org.setText("");
		e.setText("");	
		a.setText("");
	}	
	
	public void onSubmit(ActionEvent event) throws IOException, SQLException {
		addDetails();                       //Adding details
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
	
	public void addQuery() throws SQLException{
		Connection myConn = m.getConnection();
		Statement myStmt = myConn.createStatement();
		try {
			String sql = "update customer set "+query+" where pasword='"+Login.getPassword()+"';";
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
