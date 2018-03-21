package hello.dao;

import hello.model.ProductModel;
import org.springframework.data.repository.CrudRepository;

public interface ProductDao extends CrudRepository<ProductModel, Integer> {
}
