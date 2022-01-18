package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginController implements Initializable {

	@FXML
	private Button google_btt;

	@FXML
	private Button git_hub_btt;

	@FXML
	private VBox login_with_box;

	@FXML
	private Label lbl_optional_text;

	@FXML
	private Button minimize_btt;

	@FXML
	private Button close_btt;

	@FXML
	private VBox form_box;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			init_form();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			set_icon_btt();
		}
	}

	public VBox getlogin_with_box() {
		return login_with_box;
	}

	public void setlogin_with_box(VBox login_with_box) {
		this.login_with_box = login_with_box;
	}

	public Label getLbl_optional_text() {
		return lbl_optional_text;
	}

	public void setLbl_optional_text(Label lbl_optional_text) {
		this.lbl_optional_text = lbl_optional_text;
	}

	public Button getMinimize_btt() {
		return minimize_btt;
	}

	public void setMinimize_btt(Button minimize_btt) {
		this.minimize_btt = minimize_btt;
	}

	public Button getClose_btt() {
		return close_btt;
	}

	public void setClose_btt(Button close_btt) {
		this.close_btt = close_btt;
	}

	public VBox getForm_box() {
		return form_box;
	}

	public void setForm_box(VBox form_box) {
		this.form_box = form_box;
	}

	@FXML
	public void close(ActionEvent event) {
		Button button_event = (Button) event.getSource();
		Stage stage = (Stage) button_event.getScene().getWindow();
		stage.close();

	}
	
	@FXML
	public void minimize(ActionEvent event) {
		Button button_event = (Button) event.getSource();
		Stage stage = (Stage) button_event.getScene().getWindow();
		stage.setIconified(true);
	}
	private void init_form() throws IOException {
		form_box.getChildren().clear();
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/loginFormView.fxml"));
		form_box.getChildren().add(root);

	}

	private void set_icon_btt() {
		Image github_icon = new Image(getClass().getResourceAsStream("/images/github_icon.png"));
		Image google_icon = new Image(getClass().getResourceAsStream("/images/google_icon.png"));
		Image minimize_icon = new Image(getClass().getResourceAsStream("/images/minimize_icon.png"));
		Image close_icon = new Image(getClass().getResourceAsStream("/images/close_icon.png"));
		minimize_btt.setGraphic(new ImageView(minimize_icon));
		close_btt.setGraphic(new ImageView(close_icon));
		google_btt.setGraphic(new ImageView(google_icon));
		git_hub_btt.setGraphic(new ImageView(github_icon));
	}
}
