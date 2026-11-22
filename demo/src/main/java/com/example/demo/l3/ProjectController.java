package com.example.demo.l3;

import com.example.demo.l2.TaskDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {
    @PostMapping("/l3/projects/{projectId}/tasks")
    public String createTaskForProject(
            @PathVariable Long projectId,
            @RequestBody TaskDTO task) {

        return "Успешно! В проект с ID = " + projectId
                + " добавлена задача: '" + task.getTitle()
                + "' (приоритет: " + task.getPriority() + ")";
    }

    @PostMapping("/l3/teams/{memberId}/members")
    public String createMemberForTeam(
            @PathVariable Long memberId,
            @RequestBody MemberDTO member) {

        return "В команду, присоединился новый участник: " + member.getName()
                + " ,на позицию" + member.getRole() + ".Его ID = "  + memberId;
    }
}