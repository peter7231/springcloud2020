package com.liupan.springcloud.controller;

import com.liupan.springcloud.entities.CommonResult;
import com.liupan.springcloud.entities.Payment;
import com.liupan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentController
{

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment)
    {
        log.info("传入参数为："+payment.toString());
        int result = paymentService.create(payment);
        log.info("---测试热部署--1-");
        log.info("----插入结果："+result);
        if(result>0){
            return new CommonResult(200,"插入数据成功,server port :"+serverPort,result);
        }else{
            return new CommonResult(200,"插入数据失败");
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id)
    {
        Payment payment = paymentService.getPaymentById(id);
        log.info("----查询结果："+payment);
        log.info("---测试热部署--2-");
        if(payment != null){
            return new CommonResult(200,"查询成功,server port:"+serverPort,payment);
        }else{
            return new CommonResult(200,"没有对应纪录，查询 id="+id);
        }
    }
}
