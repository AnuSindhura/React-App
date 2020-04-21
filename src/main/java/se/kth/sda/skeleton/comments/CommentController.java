package se.kth.sda.skeleton.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.kth.sda.skeleton.posts.Post;

import java.util.List;


@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/comments")
  public Comment postComment(@RequestBody Comment comment) {
      return commentService.create(comment);
  }
    @DeleteMapping("/comments/{id}")
    public void delete(@PathVariable Long id){
        commentService.deleteById(id);
    }

    @GetMapping("/comments")
    public List<Comment> getAll(@RequestParam("postId") Long postId){
        return commentService.getAllByPostId(postId);
    }

}
