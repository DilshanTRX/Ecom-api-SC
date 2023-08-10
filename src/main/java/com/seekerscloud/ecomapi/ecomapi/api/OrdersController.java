package com.seekerscloud.ecomapi.ecomapi.api;

import com.seekerscloud.ecomapi.ecomapi.dto.request.OrdersRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.service.OrdersService;
import com.seekerscloud.ecomapi.ecomapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    @PostMapping(value = "/visitor/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
    )   // http://localhost:8000/api/v1/orders/create (POST)

    public ResponseEntity<StandardResponse> createOrders(@RequestBody OrdersRequestDTO dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                        ordersService.createOrders(dto),
                        null
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")   // http://localhost:8000/api/v1/orders/15 (GET)
    public ResponseEntity<StandardResponse> findOrders(@PathVariable String order_id) throws ClassNotFoundException {

        return  new ResponseEntity<>(
                new StandardResponse(
                        200,
                        order_id+" details ",
                        ordersService.findOrders(order_id)
                ),HttpStatus.OK
        );

    }

    @PutMapping(value = "/modify",params = {"id"})  // http://localhost:8000/api/v1/orders/modify?id=15
    public ResponseEntity<StandardResponse> updateOrders(@RequestBody OrdersRequestDTO dto, @RequestParam String id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        ordersService.updateOrders(dto, id),
                        null
                ),HttpStatus.CREATED
        );

    }
    @DeleteMapping("/remove/{id}")   // http://localhost:8000/api/v1/orders/15 (DELETE)
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable String id){

        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                        ordersService.deleteOrders(id),
                        null
                ),HttpStatus.NO_CONTENT
        );
    }

    @GetMapping(value = "/list", params = {"searchText","page","size"})     // http://localhost:8000/api/v1/orders/list (GET)
    public ResponseEntity<StandardResponse> findAllOrders(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Data List!",
                        ordersService.findAllOrders(searchText,page,size)
                ),HttpStatus.OK
        );

    }
}
