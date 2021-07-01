package com.spring.test.springboot.service.posts;

import com.spring.test.springboot.domain.posts.Posts;
import com.spring.test.springboot.web.dto.PostsResponseDto;
import com.spring.test.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import com.spring.test.springboot.domain.posts.PostsRepsitory;
import com.spring.test.springboot.web.dto.PostsSaveRequestDto;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostsService {
    private final PostsRepsitory postsRepsitory;

    //Transactional <- 역활확인
    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepsitory.save(requestDto.toEntity()).getId();
    }
    
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepsitory.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepsitory.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);

    }
}
