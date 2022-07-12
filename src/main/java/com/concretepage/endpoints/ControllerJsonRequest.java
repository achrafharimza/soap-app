package com.concretepage.endpoints;


import com.concretepage.gs_ws.GetArticleByIdRequest;
import com.concretepage.gs_ws.GetArticleByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

@Controller
@RequestMapping("/getArticleByIdRequest")
public class ControllerJsonRequest {


    @PostMapping("/")
    public GetArticleByIdResponse JsonRequest(@RequestBody String requestjson){
        GetArticleByIdRequest request =new GetArticleByIdRequest();
        System.out.printf("\n request from controller = "+request+"\n");
        return null;
    }





}
