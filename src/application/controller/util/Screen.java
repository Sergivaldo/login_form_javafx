package application.controller.util;

import java.io.IOException;

import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

public class Screen {
	
	public static void load_screen(String path, VBox box) {
		transition(path,box);
	}
	
	private static void set_screen(String path, VBox box) throws IOException {
		Parent screen = FXMLLoader.load(Screen.class.getResource(path));
		VBox root_box = (VBox) box.getParent();
		root_box.getChildren().clear();
		root_box.getChildren().add(screen);
	}
	
	private static void transition(String path, VBox box) {
		FadeTransition fade_transition = new FadeTransition();
		fade_transition.setDuration(Duration.millis(100));
		fade_transition.setNode(box);
		fade_transition.setFromValue(1);
		fade_transition.setToValue(0);
		
		fade_transition.setOnFinished((ActionEvent event) ->{
			try {
				set_screen(path,box);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		fade_transition.play();
		
	}
}
