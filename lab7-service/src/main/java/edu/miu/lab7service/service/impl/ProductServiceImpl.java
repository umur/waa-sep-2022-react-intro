package edu.miu.lab7service.service.impl;


import com.google.common.collect.Lists;
import edu.miu.lab7service.entity.Category;
import edu.miu.lab7service.entity.Product;
import edu.miu.lab7service.entity.Review;
import edu.miu.lab7service.entity.User;
import edu.miu.lab7service.model.ProductRequest;
import edu.miu.lab7service.model.UserDetailsAdapter;
import edu.miu.lab7service.repository.CategoryRepository;
import edu.miu.lab7service.repository.ProductRepository;
import edu.miu.lab7service.repository.ReviewRepository;
import edu.miu.lab7service.repository.UserRepository;
import edu.miu.lab7service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    private final UserRepository userRepository;

    private final ReviewRepository reviewRepository;

    @Override
    public List<Product> getAll() {
        return Lists.newArrayList(productRepository.findAll());
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cannot find product: " + id));
    }

    @Override
    @Transactional
    public void add(ProductRequest productRequest) {
        Category category = categoryRepository.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category does not exist: " + productRequest.getCategoryId()));

        UserDetailsAdapter userDetails = (UserDetailsAdapter)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = userRepository.findByEmail(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Cannot find user: " + userDetails.getUsername()));
        Product product = new Product();
        product.setName(productRequest.getName());
        product.setRating(productRequest.getRating());
        product.setPrice(productRequest.getPrice());
        product.setCategory(category);
        product.setUser(user);

        productRepository.save(product);
    }

    @Override
    public List<Review> getReviews(int id) {
        return reviewRepository.getByProduct_Id(id);
    }

    @Override
    @Transactional
    public void addReviews(Set<Review> reviews, int id) {
        Product product = getById(id);
        reviews.forEach(r -> r.setProduct(product));
        reviewRepository.saveAll(reviews);
    }
}
