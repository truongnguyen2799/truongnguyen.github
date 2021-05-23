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
public class Order {

    private int id;
    private Book book;
    private Supplier supplier;
    float price, total;
    int number;

    public Order() {
    }

    public Order(Book book, Supplier supplier) {
        this.book = book;
        this.supplier = supplier;
    }

    public Order(int id, Book book, Supplier supplier, float price, int number, float total) {
        this.id = id;
        this.book = book;
        this.supplier = supplier;
        this.price = price;
        this.total = total;
        this.number = number;
    }

    public Order(Book book, Supplier supplier, float price, int number, float total) {
        this.book = book;
        this.supplier = supplier;
        this.price = price;
        this.total = total;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
