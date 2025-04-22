package com.estudos.orders.config;

import com.estudos.orders.entities.*;
import com.estudos.orders.entities.Enuns.OrderStatus;
import com.estudos.orders.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User(null, "Guilherme", "guilherme@gmail.com", "122333", "12345");
        User user1 = new User(null, "Ronaldo", "Ronaldo@gmail.com", "122333", "12345");

        Order order = new Order(null, Instant.parse("2025-05-20T20:20:00Z"), user, OrderStatus.SHIPPED);
        Order order1 = new Order(null, Instant.parse("2025-05-20T20:20:00Z"), user1, OrderStatus.SHIPPED);
        Order order2 = new Order(null, Instant.parse("2025-05-20T20:20:00Z"), user, OrderStatus.SHIPPED);

        Category category = new Category(null, "Teste");
        Category category2 = new Category(null, "Teste2");

        Product product = new Product(null, "Televisão", "bom demmias", 200.0, "defe");
        Product product1 = new Product(null, "celular", "bom demmias", 200.0, "defe");

        OrderItem oi1 = new OrderItem(order, product, 2, product1.getPrice());
        OrderItem oi2 = new OrderItem(order1, product1, 1, product1.getPrice());

        userRepository.saveAll(Arrays.asList(user,user1));
        orderRepository.saveAll(Arrays.asList(order, order1, order2));
        categoryRepository.saveAll(Arrays.asList(category, category2));
        productRepository.saveAll(Arrays.asList(product, product1));

        product.getCategories().add(category);
        product.getCategories().add(category2);
        product1.getCategories().add(category);


        productRepository.saveAll(Arrays.asList(product, product1));
        orderItemRepository.saveAll(Arrays.asList(oi1, oi2));

        Payment payment = new Payment(null, Instant.parse("2025-05-20T21:20:00Z"), order1);
        order1.setPayment(payment);
        orderRepository.save(order1);
    }
}
