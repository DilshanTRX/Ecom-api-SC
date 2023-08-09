package com.seekerscloud.ecomapi.ecomapi.api;

import com.seekerscloud.ecomapi.ecomapi.dto.request.ItemRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.util.StandardResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {

     @PostMapping("/member/create")
     public ResponseEntity<StandardResponse> createProduct(
        @RequestBody ItemRequestDTO dto
        ){
     return null;
}
}
