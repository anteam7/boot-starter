package com.spring.test.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepsitory postsRespository;

    @After
    public void cleanup(){
        postsRespository.deleteAll();
    }
    
    @Test
    public void call_contents_save(){
        //given
        String title = "테스트게시글";
        String contents = "테스트본문";
        
        postsRespository.save(Posts.builder().title(title).content(contents).author("joojoldu@gmail.com").build());

        //when
        List<Posts> postsList = postsRespository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(contents);
    }
}
