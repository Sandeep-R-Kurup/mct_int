package com.example.MCT.Interview.controller;


import com.example.MCT.Interview.exception.missingParameter;
import com.example.MCT.Interview.model.orders;
import com.example.MCT.Interview.repository.orderRepository;
import com.example.MCT.Interview.service.orderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/v1")

public class orderController {

    @Autowired
    orderService orderService;
    @Autowired
    orderRepository orderRepository;


    @PostMapping("/order")
    public ResponseEntity<String> create(@RequestBody String order) throws missingParameter {
        JSONObject obj = new JSONObject(order);
        JSONObject error = orderService.validation(obj);
        if (error.isEmpty()) {
            orders order1 = new orders();
            order1.setPaymentid(obj.getString("paymentid"));
            order1.setProductid(obj.getString("productid"));
            order1.setUserid(obj.getString("userid"));
            order1.setCount(obj.getString("count"));
            return new ResponseEntity<>("order created", HttpStatus.CREATED);
        } else return new ResponseEntity<>("Missing parameter", HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/saveorder")
    public ResponseEntity<String> saveorder(@RequestBody orders obj){
        orders saved = orderService.saved(obj);
        return new ResponseEntity<>(saved.toString(),HttpStatus.CREATED);
    }
    @GetMapping("/order")
    public ResponseEntity<String> getorder(@RequestParam String orderid) {
        List<orders> orders = new ArrayList<>();
        if (orderid == null) {
            orders = orderRepository.findAll();
        } else {
            orders order1 = orderRepository.findById(Integer.valueOf(orderid)).get();
            orders.add(order1);
        }
        return new ResponseEntity<>(orders.toString(), HttpStatus.OK);
    }
}
