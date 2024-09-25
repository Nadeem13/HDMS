package com.iustbatch2018rollnocse70.hdms.CustomerFoodPanel;

public class CustomerPendingOrders {

    private String ShopkeeperId, ItemID, ItemName, ItemQuantity, Price, TotalPrice;

    public CustomerPendingOrders(String itemID, String itemName, String itemQuantity, String price, String totalPrice, String shopkeeperId) {
        ShopkeeperId = shopkeeperId;
        ItemID = itemID;
        ItemName = itemName;
        ItemQuantity = itemQuantity;
        Price = price;
        TotalPrice = totalPrice;

    }

    public CustomerPendingOrders() {

    }

    public String getShopkeeperId() {
        return ShopkeeperId;
    }

    public void setShopkeeperId(String shopkeeperId) {
        ShopkeeperId = shopkeeperId;
    }

    public String getItemID() {
        return ItemID;
    }

    public void setItemID(String itemID) {
        ItemID = itemID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getItemQuantity() {
        return ItemQuantity;
    }

    public void setItemQuantity(String itemQuantity) {
        ItemQuantity = itemQuantity;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        TotalPrice = totalPrice;
    }


}
