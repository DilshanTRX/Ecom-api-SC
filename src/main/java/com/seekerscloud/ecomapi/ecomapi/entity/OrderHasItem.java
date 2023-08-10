package com.seekerscloud.ecomapi.ecomapi.entity;

import com.seekerscloud.ecomapi.ecomapi.entity.compositekey.OrderHasItemId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "orders_has_item_table")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderHasItem {
    @EmbeddedId
    private OrderHasItemId orderHasItemId;

    @ManyToOne
    @MapsId("orderOrderId")
    @JoinColumn(name = "order_order_id")
    private Orders orderOrderId;

    @ManyToOne
    @MapsId("itemCode")
    @JoinColumn(name = "item_code")
    private Item itemCode;
    @Column(name = "unit_price")
    private double unitPrice;
    @Column(name = "qty")
    private int qty;

    public OrderHasItem(String orderOrderId, int itemCode, double unitPrice, int qty) {
        this.orderHasItemId = new OrderHasItemId(orderOrderId, itemCode);
        this.unitPrice = unitPrice;
        this.qty = qty;
    }
}
