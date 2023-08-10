package com.seekerscloud.ecomapi.ecomapi.dto.response.paginate;

import com.seekerscloud.ecomapi.ecomapi.dto.response.ItemResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedItemResponseDTO {
    private long dataCount;
    private List<ItemResponseDTO> dataList;

    }
