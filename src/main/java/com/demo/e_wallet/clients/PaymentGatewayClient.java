package com.demo.e_wallet.clients;

import com.demo.e_wallet.dto.PaymentGatewayRequest;
import com.demo.e_wallet.dto.PaymentGatewayResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "Payment-gateway-client",url = "http://localhost:3000")
public interface PaymentGatewayClient {

    @PostMapping("/addMoney")
    PaymentGatewayResponse addMoney(PaymentGatewayRequest request);
}
