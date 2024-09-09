package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//to display Summary of my information 
public class Summary {
	private Label label, label2, lage, lcoment, lgender, l2;
	private Button button, button2, button3, button4;
	private TextArea area;
	private HBox box, box2, box3, lhbBox, hBox;
	private VBox vBox, vBox2;
	private Scene scene, scene2;
	private Stage stage;
	private TextField textField, ageText;
	private RadioButton r1, r2;
	private ToggleGroup group;

//this stage to create report from the input information
	public Summary(DoublyLinkedList1 doublyLinkedList1) {
		l2 = new Label();
		lgender = new Label("select your the gender of you need");
		lgender.setStyle("-fx-Text-Fill:SLATEGRAY;-fx-font-size:18;-fx-font-weight:BOLD;-fx-font-Style:ITALIC;");
		r1 = new RadioButton("M");
		r2 = new RadioButton("F");
		group = new ToggleGroup();
		hBox = new HBox(15);
		group.getToggles().addAll(r1, r2);
		hBox.getChildren().addAll(lgender, r1, r2);

		lhbBox = new HBox();
		lcoment = new Label();
		lhbBox.getChildren().add(lcoment);
		lcoment.setAlignment(Pos.CENTER);
		button4 = new Button("count");
		ageText = new TextField();
		lage = new Label("please enter the age if you need");
		lage.setStyle("-fx-Text-Fill:SLATEGRAY;-fx-font-size:18;-fx-font-weight:BOLD;-fx-font-Style:ITALIC;");
		box = new HBox();
		box3 = new HBox(10);
		box3.getChildren().addAll(lage, ageText, button4);
		label = new Label("please enter the location :");
		label2 = new Label();
		label.setStyle("-fx-Text-Fill:SLATEGRAY;-fx-font-size:18;-fx-font-weight:BOLD;-fx-font-Style:ITALIC;");
		textField = new TextField();
		box2 = new HBox();
		box2.getChildren().add(textField);
		button3 = new Button("summary");
		vBox2 = new VBox(10);
		vBox2.getChildren().addAll(label, box2, button3, label2, box3, lhbBox, hBox,l2);
		button = new Button("prev");
		button2 = new Button("next");
		box.getChildren().addAll(button, button2);
		box.setAlignment(Pos.CENTER);
		area = new TextArea();
		vBox = new VBox();
		vBox.getChildren().addAll(area, box);
		scene = new Scene(vBox2, 500, 300);
		scene2 = new Scene(vBox);
		stage = new Stage();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
		button3.setOnAction(e -> {
			if (doublyLinkedList1.searchLocation(textField.getText())) {

				try {
					doublyLinkedList1.reportOfLocation(textField.getText());
					stage.setScene(scene2);

					area.setText(doublyLinkedList1.getReport());
				} catch (NumberFormatException ex) {

				}
			} else
				label2.setText("this location is not exist");
		});
		button.setOnAction(e -> {
			if (doublyLinkedList1.getCurrentLocation() == doublyLinkedList1.getHead()) {
				area.setText(area.getText() + "\n not exist Previous location");
			} else {
				try {
					if (doublyLinkedList1.getCurrentLocation() == null) {
						doublyLinkedList1.setCurrentLocation(doublyLinkedList1.getLocationNode(textField.getText()));

					}

					doublyLinkedList1.reportOfLocation(doublyLinkedList1.getPreviousLocation().getLocation());
					area.setText(doublyLinkedList1.getReport());

				} catch (NumberFormatException ex) {

				}
			}
		});
		button2.setOnAction(e -> {
			if (doublyLinkedList1.getCurrentLocation() == doublyLinkedList1.getTail()) {
				area.setText(area.getText() + "\n not exist Previous location");
			} else {
				try {
					if (doublyLinkedList1.getCurrentLocation() == null) {
						doublyLinkedList1.setCurrentLocation(doublyLinkedList1.getLocationNode(textField.getText()));

					}

					doublyLinkedList1.reportOfLocation(doublyLinkedList1.getNextLocation().getLocation());
					area.setText(doublyLinkedList1.getReport());

				} catch (NumberFormatException ex) {

				}
			}
		});
		button4.setOnAction(e -> {
			boolean check = true;

			if (ageText.getText().length() == 0 || textField.getText().length() == 0) {
				lcoment.setText("the text feild is empty");
				check = false;
			} else {

				for (int i = 0; i < ageText.getText().length(); i++) {
					char c = ageText.getText().charAt(i);
					if (!Character.isDigit(c)) {
						lcoment.setText("use numbers between 1-200 just in text feild 2");
						check = false;
						break;
					}
				}
			}
			if (check == true) {
				if (!(Integer.valueOf(ageText.getText()) > 0) || !(Integer.valueOf(ageText.getText()) < 200)) {
					lcoment.setText("use numbers between 1-200 just");
					check = false;
				}
			}
			try {
				if (check == true) {

					lcoment.setText(String.valueOf(doublyLinkedList1.countMartyrsByAgeInLocation(textField.getText(),
							Integer.valueOf(ageText.getText()))));

				}
			} catch (NumberFormatException ex) {

			}
		});
		r1.setOnAction(e -> {
			 try {
				l2.setText(String.valueOf( doublyLinkedList1.countMartyrsByGenderInLocation(textField.getText(), 'M')));
			} catch (NumberFormatException e2) {
			}
			
		});
		r2.setOnAction(e -> {
			try {
				l2.setText(String.valueOf( doublyLinkedList1.countMartyrsByGenderInLocation(textField.getText(), 'F')));}
			catch (NumberFormatException ex){
				
			}
		});
	}

}
