package hust.soict.dsai.aims.screen;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
public class CartScreenController {
    private Cart cart;
    @FXML private TableView<Media> tblMedia;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;
    @FXML private Button btnPlay;
    @FXML private Button btnRemove;
    @FXML private Label lblTotal;
    public CartScreenController(Cart cart) {
        this.cart = cart;
    }
    @FXML
    private void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        updateCartDisplay();
        tblMedia.getItems().addListener((javafx.collections.ListChangeListener<Media>) c -> updateCartDisplay());
        tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, old, selected) -> {
            if (selected != null) {
                btnRemove.setDisable(false);
                btnPlay.setDisable(!(selected instanceof Playable));
            } else {
                btnRemove.setDisable(true);
                btnPlay.setDisable(true);
            }
        });
    }
    private void updateCartDisplay() {
        tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
        lblTotal.setText(String.format("%.2f $", cart.totalCost()));
    }
    @FXML
    void btnPlayPressed() {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Cannot play media");
                alert.setHeaderText("Illegal media length");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }
    @FXML
    void btnRemovePressed() {
        Media m = tblMedia.getSelectionModel().getSelectedItem();
        if (m != null) {
            cart.removeMedia(m);
            updateCartDisplay();
        }
    }
    @FXML
    void btnPlaceOrderPressed() {
        cart.getItemsOrdered().removeAll(cart.getItemsOrdered());
        updateCartDisplay();
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Order Placed");
        alert.setHeaderText("Order created");
        alert.setContentText("Your order has been placed successfully!");
        alert.showAndWait();
    }
}