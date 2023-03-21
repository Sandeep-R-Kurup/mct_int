package com.SandeepRKurup.mct_int.controller;

import com.SandeepRKurup.mct_int.Exception.missingParameter;
import com.SandeepRKurup.mct_int.doa.orderRepository;
import com.SandeepRKurup.mct_int.model.order;
import com.SandeepRKurup.mct_int.service.orderService;
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
    order order;

    @Autowired
    orderService orderService;
    @Autowired
    orderRepository orderRepository;



    @PostMapping("/order")
    public ResponseEntity<String> create(@RequestBody String order) throws missingParameter{
        JSONObject obj = new JSONObject(order);
        JSONObject error = orderService.validation(obj);
        if(error.isEmpty()){
           order order1 = new order();
           order1.setPaymentid(obj.getString("paymentid"));
           order1.setProductid(obj.getString("productid"));
           order1.setUserid(obj.getString("userid"));
           order1.setCount(obj.getString("count"));
           return new ResponseEntity<>("order created",HttpStatus.CREATED);
        }
        else return new ResponseEntity<>("Missing parameter",HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/order")
    public ResponseEntity<String> getorder(@RequestParam String orderid){
        List<order> orders=new ArrayList<>();
        if(orderid==null){
            orders = orderRepository.findAll();
        }
        else{
            order order1 = orderRepository.findById(Integer.valueOf(orderid)).get();
            orders.add(order1);
        }
        return new ResponseEntity<>(orders.toString(),HttpStatus.OK);
    }




















}
