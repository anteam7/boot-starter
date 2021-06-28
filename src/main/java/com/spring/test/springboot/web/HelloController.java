package com.spring.test.springboot.web;

import com.spring.test.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//RextController <- json 방식으로 return 값을 변경해서 전송한다.
@RestController
public class HelloController {

    //GetMapping <- get 방식으로 넘어오는 action 에 mapping 한다.
    @GetMapping("/hello")
    public String Hello(){
        return "hello";
    }

    //RequestParm <- get 방식으로 넘어오는 파라미터를 캐치해서 받는다.
    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
