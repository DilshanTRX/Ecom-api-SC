package com.seekerscloud.ecomapi.ecomapi.api;

import com.seekerscloud.ecomapi.ecomapi.dto.request.OrderHasItemRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.service.OrderHasItemService;
import com.seekerscloud.ecomapi.ecomapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order-has-item")
public class OrderHasItemController {
    @Autowired
    private OrderHasItemService orderHasItemService;
    @PostMapping(value = "/visitor/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
    )   // http://localhost:8000/api/v1/order-has-item/create (POST)

    public ResponseEntity<StandardResponse> createUser(@RequestBody OrderHasItemRequestDTO dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                        orderHasItemService.createOrderHasItem(dto),
                        null
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")   // http://localhost:8000/api/order-has-item/user/15 (GET)
    public ResponseEntity<StandardResponse> findOrderHasItem(@PathVariable String id) throws ClassNotFoundException {

        return  new ResponseEntity<>(
                new StandardResponse(
                        200,
                        id+" details ",
                        orderHasItemService.findOrderHasItem(id)
                ),HttpStatus.OK
        );


    }
    @PutMapping(value = "/modify",params = {"id"})  // http://localhost:8000/api/v1/order-has-item/modify?id=15
    public ResponseEntity<StandardResponse> updateOrderHasItem(@RequestBody OrderHasItemRequestDTO dto, @RequestParam String id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        orderHasItemService.updateOrderHasItem(dto, id),
                        null
                ),HttpStatus.CREATED
        );

    }

    @DeleteMapping("/remove/{id}")   // http://localhost:8000/api/v1/order-has-item/15 (DELETE)
    public ResponseEntity<StandardResponse> deleteOrderHasService(@PathVariable String orderOrderId,int itemCode){

        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                        orderHasItemService.deleteOrderHasItem(orderOrderId,itemCode),
                        null
                ),HttpStatus.NO_CONTENT
        );
    }
    @GetMapping(value = "/list", params = {"searchText","page","size"})     // http://localhost:8000/api/v1/order-has-item/list (GET)
    public ResponseEntity<StandardResponse> findAllUser(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Data List!",
                        orderHasItemService.findAllOrderHasItem(searchText,page,size)
                ),HttpStatus.OK
        );

    }

}
