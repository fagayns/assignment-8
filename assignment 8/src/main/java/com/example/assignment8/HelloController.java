package com.example.assignment8;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
//..
public class HelloController {
    @FXML
    private TextField nameField;
    @FXML
    private TextField priceField;
    @FXML
    private TextField weightField;
    @FXML
    private TextField screenSizeField;
    @FXML
    private TextField cameraResolutionField;
    @FXML
    private TextField ramSizeField;
    @FXML
    private TextField processorTypeField;
    @FXML
    private TextField batteryLifeField;
    @FXML
    private CheckBox hasStylusCheckBox;
    @FXML
    private ListView<Device> listView;
    @FXML
    private TabPane tabPane;

    private ObservableList<Device> devices = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        listView.setItems(devices);
    }

    @FXML
    protected void onAddButtonClick() {
        try {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            double weight = Double.parseDouble(weightField.getText());

            Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
            String selectedTabText = selectedTab.getText();

            if (selectedTabText.equals("Smartphone")) {
                double screenSize = Double.parseDouble(screenSizeField.getText());
                double cameraResolution = Double.parseDouble(cameraResolutionField.getText());
                devices.add(new Smartphone(name, price, weight, screenSize, cameraResolution));
            } else if (selectedTabText.equals("Laptop")) {
                int ramSize = Integer.parseInt(ramSizeField.getText());
                String processorType = processorTypeField.getText();
                devices.add(new Laptop(name, price, weight, ramSize, processorType));
            } else if (selectedTabText.equals("Tablet")) {
                double batteryLife = Double.parseDouble(batteryLifeField.getText());
                boolean hasStylus = hasStylusCheckBox.isSelected();
                devices.add(new Tablet(name, price, weight, batteryLife, hasStylus));
            }

            clearFields();
        } catch (NumberFormatException e) {
            showAlert("Input Error", "Please enter valid data in all fields.");
        }
    }

    @FXML
    protected void onRemoveButtonClick() {
        Device selectedDevice = listView.getSelectionModel().getSelectedItem();
        if (selectedDevice != null) {
            devices.remove(selectedDevice);
        } else {
            showAlert("Selection Error", "Please select a device to remove.");
        }
    }

    private void clearFields() {
        nameField.clear();
        priceField.clear();
        weightField.clear();
        screenSizeField.clear();
        cameraResolutionField.clear();
        ramSizeField.clear();
        processorTypeField.clear();
        batteryLifeField.clear();
        hasStylusCheckBox.setSelected(false);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}