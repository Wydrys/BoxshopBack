package hello.controller;

import hello.dto.Product;
import hello.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product")
    public ResponseEntity<Integer> createProduct(@RequestBody Product product){
        Integer id = productService.createProduct(product);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }


    @RequestMapping(value = "/product",method = RequestMethod.GET)
    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.productList();
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
