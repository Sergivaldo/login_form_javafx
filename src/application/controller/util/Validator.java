package application.controller.util;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Validator {

	public static boolean contains_empty_input(TextField[] inputs) {
		for (int i = 0; i < inputs.length; i++) {
			if(inputs[i].getText().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public static boolean is_valid_email(TextField input_email) {
		if (input_email.getText().contains("@")) {
			if (input_email.getText().contains(".com")) {
				return true;
			}
		}
		return false;
	}

	public static boolean is_valid_lenght_pass(PasswordField input_pass, int min_lenght) {
		return input_pass.getText().length() >= min_lenght;
	}

	public static boolean is_equals_passwords(PasswordField input_pass, PasswordField input_conf_pass) {
		return input_pass.getText().equals(input_conf_pass.getText());
	}

}
