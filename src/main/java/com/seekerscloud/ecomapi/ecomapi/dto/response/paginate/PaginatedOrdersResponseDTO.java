package com.seekerscloud.ecomapi.ecomapi.dto.response.paginate;

import com.seekerscloud.ecomapi.ecomapi.dto.response.OrdersResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedOrdersResponseDTO {
    private long dataCount;
    private List<OrdersResponseDTO> dataList;

}
