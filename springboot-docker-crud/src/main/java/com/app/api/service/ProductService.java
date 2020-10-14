package com.app.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.api.entity.Product;
import com.app.api.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	public Product getProductById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public Product updateProduct(Product product, Long id) {

		Optional<Product> updateProduct = productRepository.findById(id);
		if (!updateProduct.isPresent()) {
			return null;
		}

		return productRepository.save(product);
	}

	public String deleteProduct(Long id) {

		productRepository.deleteById(id);
		return "Product Deleted : " + id;
	}
}
