package com.iustbatch2018rollnocse70.hdms.DeliveryFoodPanel;

public class DeliveryShipFinalOrders1 {

    private String Address, ShopkeeperId, ShopkeeperName,GrandTotalPrice,MobileNumber,Name,RandomUID,UserId;

    public DeliveryShipFinalOrders1(String address, String shopkeeperId, String shopkeeperName, String grandTotalPrice, String mobileNumber, String name, String randomUID, String userId) {
        Address = address;
        ShopkeeperId = shopkeeperId;
        ShopkeeperName = shopkeeperName;
        GrandTotalPrice = grandTotalPrice;
        MobileNumber = mobileNumber;
        Name = name;
        RandomUID = randomUID;
        UserId = userId;
    }

    public DeliveryShipFinalOrders1()
    {

    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getShopkeeperId() {
        return ShopkeeperId;
    }

    public void setShopkeeperId(String shopkeeperId) {
        ShopkeeperId = shopkeeperId;
    }

    public String getShopkeeperName() {
        return ShopkeeperName;
    }

    public void setShopkeeperName(String shopkeeperName) {
        ShopkeeperName = shopkeeperName;
    }

    public String getGrandTotalPrice() {
        return GrandTotalPrice;
    }

    public void setGrandTotalPrice(String grandTotalPrice) {
        GrandTotalPrice = grandTotalPrice;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRandomUID() {
        return RandomUID;
    }

    public void setRandomUID(String randomUID) {
        RandomUID = randomUID;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }
}
