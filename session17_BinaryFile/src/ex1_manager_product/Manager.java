package ex1_manager_product;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Manager {
    List<Product> products = new ArrayList<>();

    public boolean addProduct(Product p) {
        products.add(p);
        return true;
    }

    public List<Product> getAll() {
        List<Product> newProducts = new ArrayList<>();
//        Collections.copy(products, newProducts);
//        return newProducts;
            newProducts.addAll(products);
            return newProducts;
    }

    public static void writeDateToFile(String path, List<Product> products) throws IOException {
        try {
            OutputStream os = new FileOutputStream(path);
            ObjectOutputStream oss = new ObjectOutputStream(os);
            oss.writeObject(products);
            oss.flush();
            oss.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static List<Product> readDateFromFile(String path) throws IOException {
        List<Product> products = new ArrayList<Product>();
        try {
            InputStream is = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(is);
            products = (List<Product>) ois.readObject();
            is.close();
            ois.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return products;
    }


    public Product findById(String searchId) {
        for (Product p : products) {
            if(p == null){
                return null;
            }
            if(p.getId().equals(searchId)){
                return p;
            }
        }
        return null;
    }
}
