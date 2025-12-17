package org.example.sqlclassroom.controller;

import org.example.sqlclassroom.entity.Classroom;
import org.example.sqlclassroom.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    private ClassroomService classroomService;

    // 查询所有
    @GetMapping("/list")
    public List<Classroom> getAll() {
        return classroomService.getAllClassrooms();
    }

    // 根据ID查询
    @GetMapping("/{id}")
    public Classroom getById(@PathVariable int id) {
        return classroomService.getClassroomById(id);
    }

    // 添加
    @PostMapping("/add")
    public String add(@RequestBody Classroom classroom) {
        int result = classroomService.addClassroom(classroom);
        return result > 0 ? "添加成功" : "添加失败";
    }

    // 更新
    @PutMapping("/update")
    public String update(@RequestBody Classroom classroom) {
        int result = classroomService.updateClassroom(classroom);
        return result > 0 ? "更新成功" : "更新失败";
    }

    // 删除
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        int result = classroomService.deleteClassroom(id);
        return result > 0 ? "删除成功" : "删除失败";
    }
}
