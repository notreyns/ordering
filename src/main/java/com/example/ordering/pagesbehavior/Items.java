package com.example.ordering.pagesbehavior;

public class Items {
    private String name;
    private String imageName;
    private Double price;

    public Items(){
    }
    public Items(String name, Double price, String imgName) {
        this.name = name;
        this.price = price;
        this.imageName=imgName;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Items{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public void setImageName(String imageName){
        this.imageName=imageName;
    }
    public String getImageName() {
        return imageName;
    }
}
