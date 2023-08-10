package com.seekerscloud.ecomapi.ecomapi.dto.response.paginate;

import com.seekerscloud.ecomapi.ecomapi.dto.response.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginatedUserResponseDTO {
    private long dataCount;
    private List<UserResponseDTO> dataList;
}
