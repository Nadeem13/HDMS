package com.iustbatch2018rollnocse70.hdms.CustomerFoodPanel;

public class Cart {

    private String ShopkeeperId, ItemID, ItemName, ItemQuantity,Price,Totalprice;

    public Cart(String shopkeeperId, String itemID, String itemName, String itemQuantity, String price, String totalprice) {
        ShopkeeperId = shopkeeperId;
        ItemID = itemID;
        ItemName = itemName;
        ItemQuantity = itemQuantity;
        Price = price;
        Totalprice = totalprice;
    }

    public Cart() {
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

    public String getTotalprice() {
        return Totalprice;
    }

    public void setTotalprice(String totalprice) {
        Totalprice = totalprice;
    }
}
