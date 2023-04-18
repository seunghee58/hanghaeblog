package com.sparta.hanghaeblog.controlloer;

import com.sparta.hanghaeblog.dto.PostRequestDto;
import com.sparta.hanghaeblog.dto.PostResponseDto;
import com.sparta.hanghaeblog.entity.Post;
import com.sparta.hanghaeblog.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // Post 작성 API
    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(new PostRequestDto(requestDto.getTitle(), requestDto.getUsername(), requestDto.getContents(), requestDto.getPassword()));
    }

    // 전체 Post 조회 API
    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    // 선택 Post 조회 API
    @GetMapping("/api/posts/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    // Post 수정 API
    @PutMapping("/api/posts/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody PostRequestDto requestDto, @RequestParam String password) {
        return postService.updatepost(id, requestDto, password);
    }

    // Post 삭제 API
    @DeleteMapping("/api/posts/{id}")
    public String deletePost(@PathVariable Long id, @RequestParam String password) {
        return postService.deletepost(id, password);
    }
}
