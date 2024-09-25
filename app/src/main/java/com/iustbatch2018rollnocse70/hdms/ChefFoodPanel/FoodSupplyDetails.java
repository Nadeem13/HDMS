package com.iustbatch2018rollnocse70.hdms.ChefFoodPanel;

public class FoodSupplyDetails {

    public String Items,Quantity,Price,Description,ImageURL,RandomUID, ShopkeeperId;

    public FoodSupplyDetails(String items, String quantity, String price, String description, String imageURL, String randomUID, String shopkeeperId) {
        Items = items;
        Quantity = quantity;
        Price = price;
        Description = description;
        ImageURL = imageURL;
        RandomUID=randomUID;
        ShopkeeperId = shopkeeperId;
    }

}
