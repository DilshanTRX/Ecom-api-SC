package com.seekerscloud.ecomapi.ecomapi.dto.response.paginate;

import com.seekerscloud.ecomapi.ecomapi.dto.response.OrderHasItemResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedOrderHasItemResponseDTO {
    private long dataCount;
    private List<OrderHasItemResponseDTO> dataList;
}
