package com.kodilla.good.patterns.food2Door;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ExtraFoodShop implements FoodProducer {
    private Map<Product, Integer> productsList;

    public ExtraFoodShop(){
        productsList = createProductsList();
    }

    private Map<Product, Integer> createProductsList(){
        Map<Product, Integer> productList = new HashMap<>();

        productList.put(new MeatProduct ("beef cutlets", "beef"), 5);
        productList.put(new MeatProduct ("calf liver", "beef"), 3);
        productList.put(new GrainProduct ("oat cookies", true), 12);
        productList.put(new GrainProduct ("cereal cookies", true), 10);

        return productList;
    }

    @Override
    public boolean process(Customer customer, Map<Product, Integer> productsOrder){
        for(Map.Entry<Product, Integer> entry : productsOrder.entrySet()){
            Optional<Integer> productQty = Optional.ofNullable(productsList.get(entry.getKey()));
            if(productQty.orElse(0) < entry.getValue()){
                System.out.println("Extra Food Shop: Product is not available. Sorry");
                return false;
            }
        }
        return true;
    }
}
