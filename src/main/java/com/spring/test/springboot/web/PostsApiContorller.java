package com.spring.test.springboot.web;

import com.spring.test.springboot.web.dto.PostsResponseDto;
import com.spring.test.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import com.spring.test.springboot.service.posts.PostsService;
import com.spring.test.springboot.web.dto.PostsSaveRequestDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//RequiredArgsContructor <- 초기화되지않은 final 필드나  NonNull 이 붙은 필드에대해 생성자를 생성
//RequiredArgsContructor <- 생성자에서 Bean 을 주입받도록 하기때문에 Autowired 사용하지 않아도됨
@RequiredArgsConstructor
@RestController
public class PostsApiContorller {

    private final PostsService postsService;

    //RequestBody <- get or post 타입으로 submit 되는 데이터를 변수로 받을때 사용 
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PostMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
