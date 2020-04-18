package se.kth.sda.skeleton.posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    public PostService postService;

    @PostMapping("")
    public Post create(@RequestBody Post newPost){
        return postService.save(newPost);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         postService.deleteById(id);
    }

    @GetMapping("")
    public List<Post> getAll(){
        return postService.getAll();
    }

}
