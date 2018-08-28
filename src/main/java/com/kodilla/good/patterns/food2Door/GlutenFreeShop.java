package com.kodilla.good.patterns.food2Door;


import java.util.*;

public class GlutenFreeShop implements FoodProducer {
    private Map<Product, Integer> productList;
    private List<Customer> blockedCustomer;

    public GlutenFreeShop(){
        productList = createProductList();
        blockedCustomer = createBlockedCustomer();
    }

    private Map<Product, Integer> createProductList(){
        Map<Product, Integer> productList = new HashMap<>();

        productList.put(new GlutenFreeProduct("Muffin", "Muffin made from corn flour"), 25);
        productList.put(new GlutenFreeProduct("Millet", "It is one of groats which doesn't include gluten"), 10);
        productList.put(new GlutenFreeProduct("Bread", "Light bread with dump"), 8);
        productList.put(new GlutenFreeProduct("Soy Chops", "Chops without taste and gluten"), 2);

        return productList;
    }

    private List<Customer> createBlockedCustomer(){
        List<Customer> blockedCustomer = new ArrayList<>();
        blockedCustomer.add(new Customer("Sally Vally"));
        return blockedCustomer;
    }

    @Override
    public boolean process(Customer customer, Map<Product, Integer> productsOrder){
        return(!blockedCustomer.contains(customer) && isProductAvailable(productsOrder));
    }
    public boolean isProductAvailable(Map<Product, Integer> productsOrder){
        for (Map.Entry<Product, Integer> entry : productsOrder.entrySet()){
            Optional<Integer> productQty = Optional.ofNullable(productList.get(entry.getKey()));
            if(productQty.orElse(0) < entry.getValue()){
                System.out.println("Gluten Free Shop: Product is not available. Sorry ");
                return false;
            }
        }
        return true;
    }
}
