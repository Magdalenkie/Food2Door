package com.kodilla.good.patterns.food2Door;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HealthyShop implements FoodProducer {
    private Map<Product, Integer> productsList;

    public HealthyShop(){
        productsList = createProductList();
    }

    private Map<Product, Integer> createProductList(){
        Map<Product, Integer> productsList = new HashMap<>();

        productsList.put(new GlutenFreeProduct("Rice waffles", "Round waffles made from rice" ), 6);
        productsList.put(new GlutenFreeProduct("Noodle","Fine pasta for chicken soup" ), 7);
        productsList.put(new GrainProduct("Cereal bars",true), 10);
        productsList.put(new GrainProduct("Pasta Graham", true), 8);
        return productsList;
    }

    @Override
    public boolean process(Customer customer, Map<Product, Integer> productsOrders){
        for(Map.Entry<Product, Integer> entry : productsOrders.entrySet()){
            Optional<Integer> productQty = Optional.ofNullable(productsList.get(entry.getKey()));
            if(productQty.orElse(0) < entry.getValue()){
                System.out.println("Healthy Shop: Product is not available. Sorry");
                return false;
            }
        }
        return true;
    }
}
