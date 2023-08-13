package com.seekerscloud.ecomapi.ecomapi.entity.compositekey;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderHasItemId implements Serializable {
    private String orderOrderId;
    private int itemCode;

}
