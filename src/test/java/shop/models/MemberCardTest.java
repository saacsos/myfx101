package shop.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberCardTest {

    @Test
    @DisplayName("เพิ่มยอดซื้อ 49 และ 51 บาท ได้ยอดสะสม 100 บาท")
    void testAddPurchase() {
        MemberCard card = new MemberCard("John Smith", "080-123-4567");
        card.addPurchase(49);
        card.addPurchase(51);
        assertEquals(100, card.getCumulativePurchase());
    }

    @Test
    @DisplayName("เพิ่มยอดซื้อ 49 และ 51 บาท ได้สแตมป์ 1 ดวงจากยอดซื้อ 51 บาทเท่านั้น")
    void testPointAfterAddPurchase() {
        MemberCard card = new MemberCard("John Smith", "080-123-4567");
        card.addPurchase(49);
        card.addPurchase(51);
        assertEquals(1, card.getStamp());
    }
}