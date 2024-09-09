package application;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//to search of input location
public class SearchLocation extends InsertLocation {
	private Pane pane;
	private HBox hBox;
	private VBox vBox;
	private TextArea textArea;
	private TabPane tabPane;
	public SearchLocation(DoublyLinkedList1 doublyLinkedList1) {
		super(doublyLinkedList1);
		hBox = new HBox();
		hBox.getChildren().add(getL2());
		getStage().setWidth(500);
		getStage().setHeight(500);
		getStage().setTitle("search by location");
		getButton1().setText("search");
		textArea = new TextArea();
		pane = new Pane();
		pane.getChildren().add(textArea);
		vBox = new VBox(15);
		getBorderPane().setBottom(null);
		vBox.getChildren().addAll(hBox,gethBox(), pane);
		hBox.setAlignment(Pos.CENTER);
		pane.setPrefHeight(200);
		pane.setPrefWidth(100);
		textArea.setVisible(false);
		getBorderPane().setBottom(vBox);
		getButton1().setOnAction(e -> {
			boolean check = true;
			if (getTextField().getText().length() == 0) {
				getL2().setText("the text feild is empty");
				check = false;
			} else {
				for (int i = 0; i < getTextField().getText().length(); i++) {
					char c = getTextField().getText().charAt(i);
					if (!Character.isLetter(c)) {
						getL2().setText("use charctars just");

						check = false;
						break;
					}

				}
			}
			if (check == true) {
				try {
					textArea.setVisible(true);
					doublyLinkedList1.displayAllMartyrsByLocation(getTextField().getText());
					textArea.setText(doublyLinkedList1.getString());
					doublyLinkedList1.setString("");

				} catch (NumberFormatException ex) {

				}
			}
		});
	}
}
