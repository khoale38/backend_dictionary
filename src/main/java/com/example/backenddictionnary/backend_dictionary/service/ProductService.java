package com.example.backenddictionnary.backend_dictionary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.example.backenddictionnary.backend_dictionary.models.Product;
import com.example.backenddictionnary.backend_dictionary.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private MongoTemplate mongoTemplate;
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    public Product getProductByName(String name) {
        Query query = new Query();
        query.addCriteria(Criteria.where("name").is(name));
        List<Product> result = mongoTemplate.find(query, Product.class);

        return result.get(0);
    }

  

    public Product getProductById(String id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(String id, Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setName(product.getName()!=null ? product.getName() :  existingProduct.getName());
            existingProduct.setDescription(product.getDescription()!=null ? product.getDescription() :  existingProduct.getDescription());
            existingProduct.setPrice(product.getPrice());
            return productRepository.save(existingProduct);
        }
        return null;
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}
