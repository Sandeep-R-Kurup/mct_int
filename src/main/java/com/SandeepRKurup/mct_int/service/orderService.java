package com.SandeepRKurup.mct_int.service;

import com.SandeepRKurup.mct_int.Exception.missingParameter;
import com.SandeepRKurup.mct_int.model.order;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class orderService {
//    create method
//    update method
//    validation

  public JSONObject validation(JSONObject order) throws missingParameter{
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

}
