package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class HomePage {
	@FXML
	Button AdDetails;
	@FXML
	Button logout;
	@FXML
	Button withdraw;
	@FXML
	Button deposit;
	@FXML
	Button moneyTransfer;
	@FXML
	Button reset;
	
	public void details(ActionEvent event) throws IOException{
		System.out.println("success");
		Parent view1 = FXMLLoader.load(getClass().getResource("AddDetails.fxml"));
        Scene scene1 = new Scene(view1);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene1);
        window.show();
	}
	
	public void out(ActionEvent event) throws IOException{
		System.out.println("success");
		Parent view2 = FXMLLoader.load(getClass().getResource("Login.fxml"));
        Scene scene2 = new Scene(view2);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene2);
        window.show();
	}
	
	public void add(ActionEvent event) throws IOException {
		Parent view3 = FXMLLoader.load(getClass().getResource("Deposit.fxml"));
        Scene scene3 = new Scene(view3);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene3);
        window.show();
	}
	
	public void remove(ActionEvent event) throws IOException {
		Parent view4 = FXMLLoader.load(getClass().getResource("withdraw.fxml"));
        Scene scene4 = new Scene(view4);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene4);
        window.show();
	}
	
	public void moneyTransfer(ActionEvent event) throws IOException{
		Parent view5 = FXMLLoader.load(getClass().getResource("MoneyTransfer.fxml"));
        Scene scene5 = new Scene(view5);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene5);
        window.show();
	}
	
	public void resetPass(ActionEvent event)throws IOException{
		Parent view5 = FXMLLoader.load(getClass().getResource("ResetPass.fxml"));
        Scene scene5 = new Scene(view5);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene5);
        window.show();
	}
	
}
