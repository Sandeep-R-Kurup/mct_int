package com.example.demo.service;

import com.example.demo.dao.messageRepository;
import com.example.demo.model.message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class messageService {
    @Autowired
    messageRepository msgRepository;
    public message saveMessage(message msg) {
       return msgRepository.save(msg);
    }

    public String findmsg(Integer id) {
        List<message> msg = new ArrayList<>();
       msgRepository.findById(id);

    }
}
