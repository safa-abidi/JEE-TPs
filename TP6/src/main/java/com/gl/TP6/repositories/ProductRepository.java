package com.gl.TP6.repositories;

import com.gl.TP6.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProdName(final String prodName);
}
