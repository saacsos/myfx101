package shop.controllers;

import com.github.saacsos.FXRouter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import shop.models.MemberCard;

import java.io.IOException;

public class HomeController {

    private MemberCard john, anna, harry;

    @FXML private ImageView image;

    @FXML
    public void initialize() {
        john = new MemberCard("John Smith", "081-222-8888");
        anna = new MemberCard("Anna Frost", "082-333-9999", 135);
        harry = new MemberCard("Harry Potter", "083-444-0000", 40000);
        image.setImage(new Image("/CSKULabLogo.png"));
    }

    @FXML
    public void handleJohnMemberCardButton(ActionEvent actionEvent) {
        try {
            // เปลี่ยนการแสดงผลไปที่ route ที่ชื่อ member_card_detail
            // พร้อมส่ง reference instance john ไปด้วย
            FXRouter.goTo("member_card_detail", john);
        } catch (IOException e) {
            System.err.println("ไปที่หน้า member_card_detail ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleAnnaMemberCardButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("member_card_detail", anna);
        } catch (IOException e) {
            System.err.println("ไปที่หน้า member_card_detail ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleHarryMemberCardButton(ActionEvent actionEvent) {
        try {
            FXRouter.goTo("member_card_detail", harry);
        } catch (IOException e) {
            System.err.println("ไปที่หน้า member_card_detail ไม่ได้");
            System.err.println("ให้ตรวจสอบการกำหนด route");
        }
    }

    @FXML
    public void handleMemberCardListButton(ActionEvent event) {
        try {
            FXRouter.goTo("member_card_list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
