package com.example.demo.controller;

import com.example.demo.model.message;
import com.example.demo.service.messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class messageController {
    @Autowired
    messageService msgService;

    @PostMapping("/createMsg")
    public ResponseEntity<String> createMsg(@RequestBody message msg){
        msgService.saveMessage(msg);
        return new ResponseEntity<>(msg.toString(), HttpStatus.CREATED);
    }
// this is a get api call
    @GetMapping("/getmsgbyid")
    public ResponseEntity<String> getMsgbyid(@RequestBody Integer id){
        msgService.findmsg(id);
    }

}
