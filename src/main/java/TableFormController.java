import com.sun.source.tree.BinaryTree;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import model.CustomerTM;

import java.util.Optional;

public class TableFormController {
    public TableView<CustomerTM> tblCustomers;
    public TextField txtID;
    public TextField txtName;
    public TextField txtAddress;
    public Button btnSaveCustomer;
    public Button btnNewCustomer;
    public Button btnDeleteCustomer;

    public void initialize(){
        //btnDeleteCustomer.setDisable(true);
        // Let's map column names
        tblCustomers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblCustomers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblCustomers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));

        ObservableList<CustomerTM> olCustomers = tblCustomers.getItems();
        CustomerTM c001=new CustomerTM("c001","Rashimi","Tangalle");
        olCustomers.add(c001);
        olCustomers.add(new CustomerTM("C002","NIpuni","ABC"));
        olCustomers.add(new CustomerTM("C003","H","ABC"));
        olCustomers.add(new CustomerTM("C004","L","ABC"));

        btnSaveCustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                ObservableList<CustomerTM> olCustomers=tblCustomers.getItems();

//                String id=txtID.getText();
//                String name=txtName.getText();
//                String address=txtAddress.getText();
//
//                CustomerTM newCustomer= new CustomerTM(id, name,address);
               if(txtID.getText().isBlank()){
                   new Alert(Alert.AlertType.ERROR,"Customer ID can't be empty").showAndWait();
                   txtID.requestFocus();
                   return;
               } else if (txtName.getText().isBlank()) {
                   new Alert(Alert.AlertType.ERROR,"Customer Name can't be empty").showAndWait();
                   txtName.requestFocus();
                   return;
               } else if (txtAddress.getText().isBlank()) {
                   new Alert(Alert.AlertType.ERROR,"Customer Addrress can't be empty").showAndWait();
                   txtAddress.requestFocus();
                   return;
               }
                for (CustomerTM customer : olCustomers) {
                    if (customer.getId().equalsIgnoreCase(txtID.getText())){
                        new Alert(Alert.AlertType.ERROR,"Duplicate IDs are not allowed").showAndWait();
                        txtID.requestFocus();
                        return;             // Keep it in mind to return cause if we add a break the rest of the code will get executed
                        // and the object will get added eventhough we have the same customer ID.
                    }

                }
                olCustomers.add(new CustomerTM(txtID.getText(), txtName.getText(),txtAddress.getText()));

                txtID.clear();
                txtName.clear();
                txtAddress.clear();

                txtID.requestFocus();
            }
        });
        btnNewCustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               tblCustomers.getSelectionModel().clearSelection();
                txtID.requestFocus();
            }
        });
        tblCustomers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>() {
            @Override
            public void changed(ObservableValue<? extends CustomerTM> observableValue, CustomerTM previouslySelectedCustomer, CustomerTM newlySelectedCustomer) {
                System.out.println("Previous "+previouslySelectedCustomer);
                System.out.println("Current "+newlySelectedCustomer);
            }

        });
        btnDeleteCustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
//                System.out.println(tblCustomers.getSelectionModel().getSelectedItem());
//                System.out.println(tblCustomers.getSelectionModel().getSelectedIndex());
//                    tblCustomers.getSelectionModel().select(1);
            tblCustomers.getSelectionModel().clearSelection();
            }
        });
        tblCustomers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CustomerTM>() {
            @Override
            public void changed(ObservableValue<? extends CustomerTM> observableValue, CustomerTM customerTM, CustomerTM t1) {
                if (t1==null) {
                    txtID.setText(t1.getId());
//                txtID.setDisable(true); // can't select even
                    txtID.setEditable(false);// can't type
                    txtName.setText(t1.getName());
                    txtAddress.setText(t1.getAddress());
                    btnDeleteCustomer.setText("Update Customer");
                    return;
                }
            }
        });
        btnDeleteCustomer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ObservableList<CustomerTM> olCustomers=tblCustomers.getItems();
                CustomerTM selectedCustomer=tblCustomers.getSelectionModel().getSelectedItem();

                if (selectedCustomer==null){
                    btnDeleteCustomer.setDisable(true);
                    txtID.clear();
                    txtName.clear();
                    txtAddress.clear();
                    txtID.setEditable(true);
                    return;}
                btnDeleteCustomer.setDisable(false);
                Optional<ButtonType> selectedOption = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to delete the customer?",ButtonType.YES,ButtonType.NO).showAndWait();
                if (selectedOption.get()==ButtonType.YES){
                    olCustomers.remove(selectedCustomer);
                }
            }
        });
    }
}
