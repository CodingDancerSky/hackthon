/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cmu;

/**
 *
 * @author Sean
 */
public class MerchandiseObject {
    String title;
    String description;
    int price;
    String url;
    MerchandiseObject setTitle(String title){
        this.title = title;
        return this;
    }
    MerchandiseObject setDescription(String description){
        this.description = description;
        return this;
    }
    MerchandiseObject setPrice(int price) {
        this.price = price;
        return this;
    }
    MerchandiseObject setUrl(String url) {
        this.url = url;
        return this;
    }
}
