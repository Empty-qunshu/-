package org.example.sqlclassroom.service;

import org.example.sqlclassroom.dao.ClassroomDao;
import org.example.sqlclassroom.entity.Classroom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomDao classroomDao;

    public List<Classroom> getAllClassrooms() {
        return classroomDao.getAllClassrooms();
    }

    public Classroom getClassroomById(int id) {
        return classroomDao.getClassroomById(id);
    }

    public int addClassroom(Classroom classroom) {
        return classroomDao.addClassroom(classroom);
    }

    public int updateClassroom(Classroom classroom) {
        return classroomDao.updateClassroom(classroom);
    }

    public int deleteClassroom(int id) {
        return classroomDao.deleteClassroom(id);
    }
}
