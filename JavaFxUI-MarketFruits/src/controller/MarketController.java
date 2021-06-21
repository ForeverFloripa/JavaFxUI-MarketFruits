package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Fruit;

public class MarketController implements Initializable {

	@FXML
	private VBox chosenFruitCard;

	@FXML
	private Label fruitNameLabel;

	@FXML
	private Label fruitPriceLabel;

	@FXML
	private ImageView fruitImg;

	@FXML
	private ScrollPane scroll;

	@FXML
	private GridPane grid;

	private List<Fruit> fruits = new ArrayList<Fruit>();

	private List<Fruit> getData() {
		List<Fruit> fruits = new ArrayList<>();
		Fruit fruit;

		for (int i = 0; i < 20; i++) {

			fruit = new Fruit();
			fruit.setName("Kiwi");
			fruit.setPrice(2.99);
			fruit.setImgSrc("/img/kiwi.png");
			fruit.setColor("6A7324");

			fruits.add(fruit);
		}

		return fruits;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		fruits.addAll(getData());
		int column =0;
		int row =0;
		
		

		try {
			for (int i = 0; i < fruits.size(); i++) {
				FXMLLoader fxmlLoader = new FXMLLoader();
				fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));

				AnchorPane anchorPane = fxmlLoader.load();
				ItemController itemController = fxmlLoader.getController();
				itemController.setData(fruits.get(i));
				
				
				
				if(column ==3) {
					column=0;
					row++;
				}
				
				grid.add(anchorPane, column++, row);
				
				GridPane.setMargin(anchorPane,new Insets(10));

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
