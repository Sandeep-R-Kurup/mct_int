package com.example.MCT.Interview.service;


import com.example.MCT.Interview.exception.missingParameter;
import com.example.MCT.Interview.model.orders;
import com.example.MCT.Interview.repository.orderRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderService {

    @Autowired
    orderRepository Repository;

    public JSONObject validation(JSONObject order) throws missingParameter {
        JSONObject object = new JSONObject(order);
        JSONObject error = new JSONObject();
        if(!object.has("productid")){
            throw  new missingParameter("missing parameter");
        }
        if(!object.has("userid")){
            throw  new missingParameter("missing parameter");
        }
        if(!object.has("paymentid")){
            throw  new missingParameter("missing parameter");
        }
        if(!object.has("count")){
            throw  new missingParameter("missing parameter");
        }
        return error;

    }

    public orders saved(orders obj) {
       return Repository.save(obj);
    }
}
