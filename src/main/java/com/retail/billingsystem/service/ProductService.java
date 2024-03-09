package com.retail.billingsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retail.billingsystem.entity.Product;
import com.retail.billingsystem.repository.ProductRepository;

import lombok.AllArgsConstructor;

@Service
public class ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	public Product getProductById(Long productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		return optionalProduct.get();
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getProductId()).get();
		existingProduct.setProductName(product.getProductName());
		existingProduct.setBrandName(product.getBrandName());
		existingProduct.setProductDescription(product.getProductDescription());
		Product updatedProduct = productRepository.save(existingProduct);
		return updatedProduct;
	}

	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}
}
