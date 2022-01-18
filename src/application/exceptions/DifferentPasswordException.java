package application.exceptions;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class DifferentPasswordException extends Exception {
	
	public void showMessage(HBox box, Label label, String message ) {
		box.setVisible(true);
		label.setText(message);
	}
}
