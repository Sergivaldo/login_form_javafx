package application.controller;

import java.io.IOException;

import application.controller.util.Screen;
import application.controller.util.Validator;
import application.exceptions.EmptyFieldException;
import application.exceptions.InvalidLengthPasswordException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LoginFormController {

	@FXML
	private Label lbl_login;

	@FXML
	private Label lbl_subtitle;

	@FXML
	private TextField username_input;

	@FXML
	private PasswordField password_input;

	@FXML
	private Button login_btt;

	@FXML
	private Button register_btt;

	@FXML
	private HBox box_message;

	@FXML
	private Label lbl_message_error;

	@FXML
	private VBox root_box;

	public Label getLbl_login() {
		return lbl_login;
	}

	public void setLbl_login(Label lbl_login) {
		this.lbl_login = lbl_login;
	}

	public Label getLbl_subtitle() {
		return lbl_subtitle;
	}

	public void setLbl_subtitle(Label lbl_subtitle) {
		this.lbl_subtitle = lbl_subtitle;
	}

	public TextField getUsername_input() {
		return username_input;
	}

	public void setUsername_input(TextField username_input) {
		this.username_input = username_input;
	}

	public PasswordField getPassword_input() {
		return password_input;
	}

	public void setPassword_input(PasswordField password_input) {
		this.password_input = password_input;
	}

	public Button getLogin_btt() {
		return login_btt;
	}

	public void setLogin_btt(Button login_btt) {
		this.login_btt = login_btt;
	}

	public Button getRegister_btt() {
		return register_btt;
	}

	public void setRegister_btt(Button register_btt) {
		this.register_btt = register_btt;
	}

	public HBox getBox_message() {
		return box_message;
	}

	public void setBox_message(HBox box_message) {
		this.box_message = box_message;
	}

	public Label getLbl_message_error() {
		return lbl_message_error;
	}

	public void setLbl_message_error(Label lbl_message_error) {
		this.lbl_message_error = lbl_message_error;
	}

	public VBox getRoot_box() {
		return root_box;
	}
	@FXML
	public void login(ActionEvent event) {
		try {
			validation_inputs();
		} catch (EmptyFieldException  e) {
			e.showMessage(box_message, lbl_message_error, "Empty Fields.");
		}
	}
	
	public void setRoot_box(VBox root_box) {
		this.root_box = root_box;
	}
	

	@FXML
	public void register_screen(ActionEvent event) throws IOException {
		Screen.load_screen("/fxml/registerFormView.fxml", root_box);
	}
	
	private void validation_inputs() throws EmptyFieldException {
		TextField[] inputs = {username_input,password_input};
		if(!Validator.contains_empty_input(inputs)) {
			// login implementation.
		}else {
			throw new EmptyFieldException();
		}
	}
	
}
