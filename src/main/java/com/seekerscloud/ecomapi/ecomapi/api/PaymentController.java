package com.seekerscloud.ecomapi.ecomapi.api;

import com.seekerscloud.ecomapi.ecomapi.dto.request.PaymentRequestDTO;
import com.seekerscloud.ecomapi.ecomapi.service.PaymentService;
import com.seekerscloud.ecomapi.ecomapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE}
    )   // http://localhost:8000/api/v1/payment/create (POST)

    public ResponseEntity<StandardResponse> createPayment(@RequestBody PaymentRequestDTO dto){
        return new ResponseEntity<>(
                new StandardResponse(
                        201 ,
                        paymentService.createPayment(dto),
                        null
                ), HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")   // http://localhost:8000/api/v1/payment/15 (GET)
    public ResponseEntity<StandardResponse> findPayment(@PathVariable int id) throws ClassNotFoundException {

        return  new ResponseEntity<>(
                new StandardResponse(
                        200,
                        id+" details ",
                        paymentService.findPayment(id)
                ),HttpStatus.OK
        );

    }
    @PutMapping(value = "/modify",params = {"id"})  // http://localhost:8000/api/v1/payment/modify?id=15
    public ResponseEntity<StandardResponse> updatePayment(@RequestBody PaymentRequestDTO dto, @RequestParam int id) throws ClassNotFoundException {
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        paymentService.updatePayment(dto, id),
                        null
                ),HttpStatus.CREATED
        );

    }

    @DeleteMapping("/remove/{id}")   // http://localhost:8000/api/v1/payment/15 (DELETE)
    public ResponseEntity<StandardResponse> deletePayment(@PathVariable int id){

        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                        paymentService.deletePayment(id),
                        null
                ),HttpStatus.NO_CONTENT
        );
    }

    @GetMapping(value = "/list", params = {"searchText","page","size"})     // http://localhost:8000/api/v1/payment/list (GET)
    public ResponseEntity<StandardResponse> findAllPayment(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size
    ){
        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Data List!",
                        paymentService.findAllPayment(searchText,page,size)
                ),HttpStatus.OK
        );

    }
}
