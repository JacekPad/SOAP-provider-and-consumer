package com.soapTutorial.consumer.service;

import com.soapTutorial.consumer.model.GetProductRequest;
import com.soapTutorial.consumer.model.GetProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class ProductConsumer extends WebServiceGatewaySupport {

    public GetProductResponse getProduct(long id) {
        GetProductRequest request = new GetProductRequest();
        request.setId(id);
        log.info("Sending request for ID: {}", request.getId());

        return (GetProductResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/whatEver",request,
                        new SoapActionCallback("com/soap/tutorial/products"));
    }



}
