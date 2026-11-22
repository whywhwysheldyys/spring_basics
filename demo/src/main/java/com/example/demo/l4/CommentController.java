package com.example.demo.l4;

import org.springframework.web.bind.annotation.*;

@RestController
public class CommentController {
    @PostMapping("/l4/projects/{projectId}/comments")
    public String addCommentToProject(
            @PathVariable Long projectId,
            @RequestParam boolean sendEmailNotification,
            @RequestBody CommentDTO comment
    ) {
        return "К проекту ID = " + projectId
                + " добавлен комментарий от '"
                + comment.getAuthor() + "'. Уведомление на почту отправлено: "
                + sendEmailNotification;
    }
}
