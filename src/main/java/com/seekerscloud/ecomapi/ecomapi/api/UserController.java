package com.seekerscloud.ecomapi.ecomapi.api;

import com.seekerscloud.ecomapi.ecomapi.dto.request.UserRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.service.UserService;
import com.seekerscloud.ecomapi.ecomapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/visitor/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
    )   // http://localhost:8000/api/v1/user/create (POST)

    public ResponseEntity<StandardResponse> createUser(@RequestBody UserRequestDTO dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                        userService.createUser(dto),
                        "OK"
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")   // http://localhost:8000/api/v1/user/15 (GET)
    public ResponseEntity<StandardResponse> findUser(@PathVariable String id) throws ClassNotFoundException {

        return  new ResponseEntity<>(
                new StandardResponse(
                        200,
                        id+" details ",
                        userService.findUser(id)
                ),HttpStatus.OK
        );

    }

    @PutMapping(value = "/modify",params = {"id"})  // http://localhost:8000/api/v1/user/modify?id=15
    public ResponseEntity<StandardResponse> updateUser(@RequestBody UserRequestDTO dto, @RequestParam String id){
     try{
         return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        userService.updateUser(dto, id),
                        null
                ),HttpStatus.CREATED
        );
    } catch (ClassNotFoundException e) {
        //  e.printStackTrace();
    }
        return new ResponseEntity<>(
                new StandardResponse(
                        404,
                        id+" not found",
                        null
                ), HttpStatus.NOT_FOUND
        );
    }
    @DeleteMapping("/remove/{id}")   // http://localhost:8000/api/v1/user/15 (DELETE)
    public ResponseEntity<StandardResponse> deleteUser(@PathVariable String id){

        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                        userService.deleteUser(id),
                        null
                ),HttpStatus.NO_CONTENT
        );
    }

    @GetMapping(value = "/list", params = {"searchText","page","size"})     // http://localhost:8000/api/v1/user/list (GET)
    public ResponseEntity<StandardResponse> findAllUser(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Data List!",
                       userService.findAllUser(searchText,page,size)
                ),HttpStatus.OK
        );

    }
}
