package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.controller.util.Screen;
import application.controller.util.Validator;
import application.exceptions.DifferentPasswordException;
import application.exceptions.EmptyFieldException;
import application.exceptions.InvalidEmailException;
import application.exceptions.InvalidLengthPasswordException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class RegisterFormController implements Initializable {

	@FXML
	private Label lbl_register;

	@FXML
	private Label lbl_subtitle;

	@FXML
	private TextField username_input;

	@FXML
	private TextField email_input;

	@FXML
	private PasswordField pass_input;

	@FXML
	private PasswordField conf_pass_input;

	@FXML
	private Button register_btt;

	@FXML
	private Button cancel_btt;

	@FXML
	private HBox box_message;

	@FXML
	private Label lbl_message_error;

	@FXML
	private VBox root_box;

	private int length_pass;

	public VBox getRoot_box() {
		return root_box;
	}

	public void setRoot_box(VBox root_box) {
		this.root_box = root_box;
	}

	public Label getLbl_register() {
		return lbl_register;
	}

	public void setLbl_register(Label lbl_register) {
		this.lbl_register = lbl_register;
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

	public TextField getEmail_input() {
		return email_input;
	}

	public void setEmail_input(TextField email_input) {
		this.email_input = email_input;
	}

	public PasswordField getPass_input() {
		return pass_input;
	}

	public void setPass_input(PasswordField pass_input) {
		this.pass_input = pass_input;
	}

	public PasswordField getConf_pass_input() {
		return conf_pass_input;
	}

	public void setConf_pass_input(PasswordField conf_pass_input) {
		this.conf_pass_input = conf_pass_input;
	}

	public Button getRegister_btt() {
		return register_btt;
	}

	public void setRegister_btt(Button register_btt) {
		this.register_btt = register_btt;
	}

	public Button getCancel_btt() {
		return cancel_btt;
	}

	public void setCancel_btt(Button cancel_btt) {
		this.cancel_btt = cancel_btt;
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

	public int getLength_pass() {
		return length_pass;
	}

	public void setLength_pass(int length_pass) {
		this.length_pass = length_pass;
	}

	@FXML
	public void register(ActionEvent event) {
		try {
			validation_inputs();
		} catch (EmptyFieldException e) {
			e.showMessage(box_message, lbl_message_error, "Empty fields.");
		} catch (InvalidEmailException e) {
			e.showMessage(box_message, lbl_message_error, "Invalid e-mail.");
		} catch (InvalidLengthPasswordException e) {
			e.showMessage(box_message, lbl_message_error,
					"password must contain at least " + length_pass + " characters.");
		} catch (DifferentPasswordException e) {
			e.showMessage(box_message, lbl_message_error, "Different passwords.");
		}
	}

	private void validation_inputs() throws DifferentPasswordException, EmptyFieldException, InvalidEmailException,
			InvalidLengthPasswordException {

		TextField[] inputs = { username_input, email_input, pass_input, conf_pass_input };
		if (!Validator.contains_empty_input(inputs)) {
			if (Validator.is_valid_email(email_input)) {
				if (Validator.is_valid_lenght_pass(pass_input, length_pass)) {
					if (Validator.is_equals_passwords(pass_input, conf_pass_input)) {
						// register implementation
					} else {
						throw new DifferentPasswordException();
					}
				} else {
					throw new InvalidLengthPasswordException();
				}
			} else {
				throw new InvalidEmailException();
			}
		} else {
			throw new EmptyFieldException();
		}
	}

	@FXML
	public void login_screen() throws IOException {
		Screen.load_screen("/fxml/loginFormView.fxml", root_box);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		setLength_pass(8);

	}

}
