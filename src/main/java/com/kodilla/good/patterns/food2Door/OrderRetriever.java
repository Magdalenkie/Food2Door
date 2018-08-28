package com.kodilla.good.patterns.food2Door;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderRetriever {

    public List<OrderRequest> retrieve() {
        List<OrderRequest> orderRequestList = new ArrayList<>();

        Customer customer = new Customer("Stephen Door");
        FoodProducer foodProducer = new GlutenFreeShop();
        Map<Product, Integer> productsList = new HashMap<>();
        productsList.put(new GlutenFreeProduct("Muffin", "Muffin made from corn flour"), 2);
        productsList.put(new GlutenFreeProduct("Millet", "It is one of groats which doesn't include gluten"), 2);
        productsList.put(new GlutenFreeProduct("Bread", "Light bread with dump"), 2);

        orderRequestList.add(new OrderRequest(customer, foodProducer, productsList));

        Customer customer1 = new Customer("Sally Vally");
        FoodProducer foodProducer1 = new GlutenFreeShop();
        Map<Product, Integer> productsList1 = new HashMap<>();
        productsList.put(new GlutenFreeProduct("Soy Chops", "Chops without taste and gluten"), 1);
        productsList.put(new GlutenFreeProduct("Bread", "Light bread with dump"), 1);

        orderRequestList.add(new OrderRequest(customer1, foodProducer1, productsList1));

        return orderRequestList;
    }
}
