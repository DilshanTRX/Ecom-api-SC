package com.seekerscloud.ecomapi.ecomapi.api;

import com.seekerscloud.ecomapi.ecomapi.dto.request.ItemRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.service.ItemService;
import com.seekerscloud.ecomapi.ecomapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
    )   // http://localhost:8000/api/v1/item/create (POST)

    public ResponseEntity<StandardResponse> createItem(@RequestBody ItemRequestDTO dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                        itemService.createItem(dto),
                        null
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")   // http://localhost:8000/api/v1/item/15 (GET)
    public ResponseEntity<StandardResponse> findItem(@PathVariable int code) throws ClassNotFoundException {

        return  new ResponseEntity<>(
                new StandardResponse(
                        200,
                        code+" details ",
                        itemService.findItem(code)
                ),HttpStatus.OK
        );

    }

    @PutMapping(value = "/modify",params = {"id"})  // http://localhost:8000/api/v1/item/modify?id=15
    public ResponseEntity<StandardResponse> updateItem(@RequestBody ItemRequestDTO dto, @RequestParam int code) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        itemService.updateItem(dto, code),
                        null
                ),HttpStatus.CREATED
        );

    }

    @DeleteMapping("/remove/{id}")   // http://localhost:8000/api/v1/item/15 (DELETE)
    public ResponseEntity<StandardResponse> deleteItem(@PathVariable int code){

        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                        itemService.deleteItem(code),
                        null
                ),HttpStatus.NO_CONTENT
        );
    }

    @GetMapping(value = "/list", params = {"searchText","page","size"})     // http://localhost:8000/api/v1/item/list (GET)
    public ResponseEntity<StandardResponse> findAllItem(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Data List!",
                        itemService.findAllItem(searchText,page,size)
                ),HttpStatus.OK
        );

    }
}
