package com.bakery.bakery_management.model;

import java.util.List;

public class CartOrderRequest {

    private Integer customerId;
    private List<CartItem> items;

    public Integer getCustomerId() { return customerId; }
    public void setCustomerId(Integer customerId) { this.customerId = customerId; }

    public List<CartItem> getItems() { return items; }
    public void setItems(List<CartItem> items) { this.items = items; }

    // Inner class for each cart item
    public static class CartItem {
        private Integer productId;
        private Integer quantity;

        public Integer getProductId() { return productId; }
        public void setProductId(Integer productId) { this.productId = productId; }

        public Integer getQuantity() { return quantity; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }
    }
}