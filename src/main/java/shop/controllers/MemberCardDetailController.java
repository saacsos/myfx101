package shop.controllers;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import shop.models.MemberCard;

import java.io.IOException;

public class MemberCardDetailController {

    @FXML private Label nameLabel;
    @FXML private Label phoneLabel;
    @FXML private Label cumulativePurchaseLabel;
    @FXML private Label pointLabel;
    @FXML private TextField purchaseTextField;
    @FXML private TextField pointTextField;

    private MemberCard memberCard;

    @FXML
    public void initialize() {
        System.out.println("initialize MemberCardDetailController");
        memberCard = (MemberCard) FXRouter.getData();
        showMemberCardData();
    }

    @FXML
    public void handleAddPurchaseButton(ActionEvent actionEvent) {
        String purchaseString = purchaseTextField.getText();
        double purchase = Double.parseDouble(purchaseString);
        memberCard.addPurchase(purchase);
        showMemberCardData();
        purchaseTextField.clear();
    }

    @FXML
    public void handleUsePointButton(ActionEvent actionEvent) {
        String pointString = pointTextField.getText();
        int point = Integer.parseInt(pointString);
        memberCard.useStamp(point);
        showMemberCardData();
        pointTextField.clear();
    }

    @FXML
    public void handleBackButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("home");
        } catch (IOException e) {
            System.err.println("ไปที่หน้า home ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    private void showMemberCardData() {
        nameLabel.setText(memberCard.getName());
        phoneLabel.setText(memberCard.getPhone());
        String cumulativePurchase = String.format("%.2f", memberCard.getCumulativePurchase());
        cumulativePurchaseLabel.setText(cumulativePurchase);
        String point = "" + memberCard.getStamp();
        pointLabel.setText(point);
    }
}
