package com.wyw.eshop.kafka.controller;

import com.alibaba.fastjson.JSONObject;
import com.wyw.eshop.kafka.vo.ParamVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductToKafkaController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    private static final String TOPIC = "access-log";

    @RequestMapping("/sendData")
    public String sendData(Integer productId,Integer shopId){
        return "123";
    }

    @RequestMapping("/send2kafka/{id}")
    public String send2Kafka(@PathVariable Integer id){
        String request_module = "product_detail_info";
        String headers = "Host: localhost:8082\n" +
                "User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:60.0) Gecko/20100101 Firefox/60.0\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n" +
                "Accept-Language: en-US,en;q=0.5\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Connection: keep-alive\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "Pragma: no-cache\n" +
                "Cache-Control: no-cache";
        String uri_args = "{\"productId\":\""+id+"\",\"shopId\":\""+id+"\"}";
        String http_version = "1.1";
        String method = "GET";
        String raw_reader = "Host: localhost:8082\n" +
                "User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:60.0) Gecko/20100101 Firefox/60.0\n" +
                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8\n" +
                "Accept-Language: en-US,en;q=0.5\n" +
                "Accept-Encoding: gzip, deflate\n" +
                "Connection: keep-alive\n" +
                "Upgrade-Insecure-Requests: 1\n" +
                "Pragma: no-cache\n" +
                "Cache-Control: no-cache";
        String body_data = "";
        ParamVo vo = new ParamVo(request_module,headers,uri_args,http_version,method,raw_reader,body_data);
        String jsonString = JSONObject.toJSONString(vo);
        kafkaTemplate.send(TOPIC,jsonString);
        return jsonString;
    }
}
