package com.spring.test.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepsitory extends JpaRepository<Posts, Long> {

}
