package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ClassroomController {
    private List<Classroom> classrooms = new ArrayList<>(List.of(
            new Classroom("A7-217", "数据结构教室", 50),
            new Classroom("A6-423", "大学英语教室", 60),
            new Classroom("A7-306", "计算机网络教室", 55)
    ));

    @GetMapping("/classroom")
    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    @GetMapping("/classroom/{id}")
    public Classroom getClassroom(@PathVariable String id) {
        for (Classroom c : classrooms) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    @DeleteMapping("/classroom/{id}")
    public String deleteClassroom(@PathVariable String id) {
    classrooms.removeIf(c -> c.getId().equals(id));
    return "教室"+id+"已被删除";
        }
}
