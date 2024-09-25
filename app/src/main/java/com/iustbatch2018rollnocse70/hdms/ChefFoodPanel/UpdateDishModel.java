package com.iustbatch2018rollnocse70.hdms.ChefFoodPanel;

public class UpdateDishModel {

    String Items,RandomUID,Description,Quantity,Price,ImageURL, ShopkeeperId;


    public UpdateDishModel()
    {

    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getImageURL() {
        return ImageURL;
    }

    public void setImageURL(String imageURL) {
        ImageURL = imageURL;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getRandomUID() {

        return RandomUID;
    }

    public void setRandomUID(String randomUID) {

        RandomUID = randomUID;
    }

    public String getItems()
    {
        return Items;
    }

    public void setItems(String items) {

        Items = items;
    }

    public String getShopkeeperId() {
        return ShopkeeperId;
    }

    public void setShopkeeperId(String shopkeeperId) {
        ShopkeeperId = shopkeeperId;
    }
}
