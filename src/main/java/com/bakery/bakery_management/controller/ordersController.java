package com.bakery.bakery_management.controller;

import com.bakery.bakery_management.model.orders;
import com.bakery.bakery_management.repository.ordersrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.bakery.bakery_management.model.CartOrderRequest;
import com.bakery.bakery_management.model.OrderItem;
import com.bakery.bakery_management.model.product;
import com.bakery.bakery_management.model.customer;
import com.bakery.bakery_management.repository.orderitemrepository;
import com.bakery.bakery_management.repository.productrepository;
import com.bakery.bakery_management.repository.customerrepository;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class ordersController {

    @Autowired
    private ordersrepository ordersRepository;
@Autowired
private orderitemrepository orderItemRepository;

@Autowired
private productrepository productRepository;

@Autowired
private customerrepository customerRepository;
    // Get all orders
    @GetMapping
    public List<orders> getAllOrders() {
        return ordersRepository.findAll();
    }

    // Place new order
    @PostMapping
    public orders addOrder(@RequestBody orders order) {
        order.setStatus("Pending");
        return ordersRepository.save(order);
    }

    // Delete order
  @DeleteMapping("/{id}")
public ResponseEntity<?> deleteOrder(@PathVariable int id) {
    try {
        List<OrderItem> items = orderItemRepository.findByOrderId(id);
        orderItemRepository.deleteAll(items);
        ordersRepository.deleteById(id);
        return ResponseEntity.ok("Deleted!");
    } catch (Exception e) {
        return ResponseEntity.badRequest()
                .body(Map.of("error", "Could not delete this order."));
    }
}

    // Assign employee to order
    @PutMapping("/{id}/assign/{employeeId}")
    public orders assignEmployee(@PathVariable int id, @PathVariable int employeeId) {
        orders order = ordersRepository.findById(id).orElseThrow();
        order.setEmployeeId(employeeId);
        return ordersRepository.save(order);
    }

    // Update order status
    @PutMapping("/{id}/status")
    public orders updateStatus(@PathVariable int id, @RequestBody java.util.Map<String, String> body) {
        orders order = ordersRepository.findById(id).orElseThrow();
        order.setStatus(body.get("status"));
        return ordersRepository.save(order);
    }

    // Get orders by employee
    @GetMapping("/employee/{employeeId}")
    public List<orders> getOrdersByEmployee(@PathVariable int employeeId) {
        return ordersRepository.findByEmployeeId(employeeId);
    }

    // Get pending orders by employee
    @GetMapping("/employee/{employeeId}/pending")
    public List<orders> getPendingOrdersByEmployee(@PathVariable int employeeId) {
        return ordersRepository.findByEmployeeIdAndStatus(employeeId, "Pending");
    }
    @PostMapping("/cart")
public ResponseEntity<?> placeCartOrder(@RequestBody CartOrderRequest request) {

    for (CartOrderRequest.CartItem cartItem : request.getItems()) {
        product p = productRepository.findById(cartItem.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found: " + cartItem.getProductId()));

        if (p.getStockQty() < cartItem.getQuantity()) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "Not enough stock for: " + p.getProductName() +
                            " (Available: " + p.getStockQty() + ")"));
        }
    }

    customer cust = customerRepository.findById(request.getCustomerId())
            .orElseThrow(() -> new RuntimeException("Customer not found: " + request.getCustomerId()));

    double totalAmount = 0.0;
    List<product> productsToUpdate = new ArrayList<>();

    for (CartOrderRequest.CartItem cartItem : request.getItems()) {
        product p = productRepository.findById(cartItem.getProductId()).get();
        double lineTotal = p.getPrice() * cartItem.getQuantity();
        totalAmount += lineTotal;
        p.setStockQty(p.getStockQty() - cartItem.getQuantity());
        productsToUpdate.add(p);
    }

    orders newOrder = new orders();
    newOrder.setCustomer(cust);
    newOrder.setOrderDate(new java.util.Date());
    newOrder.setStatus("Pending");
    newOrder.setTotalAmount(totalAmount);

    orders savedOrder = ordersRepository.save(newOrder);

    List<OrderItem> itemsToSave = new ArrayList<>();
    for (CartOrderRequest.CartItem cartItem : request.getItems()) {
        product p = productRepository.findById(cartItem.getProductId()).get();
        OrderItem item = new OrderItem();
        item.setOrderId(savedOrder.getOrderId());
        item.setProductId(cartItem.getProductId());
        item.setQuantity(cartItem.getQuantity());
        item.setUnitPrice(p.getPrice());
        itemsToSave.add(item);
    }
    orderItemRepository.saveAll(itemsToSave);

    productRepository.saveAll(productsToUpdate);

    return ResponseEntity.ok(savedOrder);
}
}