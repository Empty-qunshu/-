package org.example.sqlclassroom.dao;

import org.example.sqlclassroom.entity.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassroomDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 查询所有
    public List<Classroom> getAllClassrooms() {
        String sql = "SELECT classroomId, classroomName, classroomPeople FROM classroom";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Classroom.class));
    }

    // 根据ID查询
    public Classroom getClassroomById(int id) {
        String sql = "SELECT classroomId, classroomName, classroomPeople FROM classroom WHERE classroomId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Classroom.class));
    }

    // 插入
    public int addClassroom(Classroom classroom) {
        String sql = "INSERT INTO classroom(classroomId, classroomName, classroomPeople) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, classroom.getClassroomId(), classroom.getClassroomName(), classroom.getClassroomPeople());
    }

    // 更新
    public int updateClassroom(Classroom classroom) {
        String sql = "UPDATE classroom SET classroomName = ?, classroomPeople = ? WHERE classroomId = ?";
        return jdbcTemplate.update(sql, classroom.getClassroomName(), classroom.getClassroomPeople(), classroom.getClassroomId());
    }

    // 删除
    public int deleteClassroom(int id) {
        String sql = "DELETE FROM classroom WHERE classroomId = ?";
        return jdbcTemplate.update(sql, id);
    }
}
