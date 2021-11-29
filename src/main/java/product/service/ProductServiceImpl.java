package product.service;

import product.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService{
    private static Map<Integer, Product> products;

    public static Map<Integer, Product> getProducts() {
        return products;
    }

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Noi", 10000, "Hanoi"));
        products.put(2, new Product(2, "Nieu", 11000, "Danang"));
        products.put(3, new Product(3, "Bat", 12000, "Saigon"));
        products.put(4, new Product(4, "Dia", 13000, "Beijin"));
        products.put(5, new Product(5, "Xoong", 14000, "Miami"));
        products.put(6, new Product(6, "Chao", 15000, "Newyork"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
    @Override
    public int findIdByName(String name){
        List<Product> list = findAll();
        for(int i = 0;i < list.size();i++){
            if(list.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }
}
