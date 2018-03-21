package hello.service;

import hello.dao.ProductDao;
import hello.dto.Product;
import hello.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public Integer createProduct(Product product) {
        ProductModel productModel = new ProductModel();
        productModel.setName(product.getName());
        productModel.setCategory(product.getCategory());
        productModel.setPrice(product.getPrice());
        ProductModel saved = productDao.save(productModel);
        return saved.getProductId();
    }

    public List<Product> productList(){
        Iterable<ProductModel> all = productDao.findAll();
        List<Product> products = new ArrayList<>();


        for (ProductModel pm:all) {
            Product product = new Product();
            product.setCategory(pm.getCategory());
            product.setName(pm.getName());
            product.setPrice(pm.getPrice());
            product.setProductId(pm.getProductId());

            products.add(product);

        }

        return products;
    }
}
