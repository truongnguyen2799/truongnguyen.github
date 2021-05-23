/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 *
 * @author ADMIN
 */
public class Book {

    private int id;
    private String img;
    private String name;
    private float price;
    private int number;
    private Supplier supplier;

    public Book() {
    }

    public Book(String img, String name, float price, int number) {
        this.img = img;
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Book(int id, String img, String name, float price, int number) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.img = img;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getImg() {
        return img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setImg(String img) {
        this.img = img;
    }

    @Override
    public String toString() {
        return "" + id + " " + img + " " + name + " " + price + " " + number; 
    }
}
