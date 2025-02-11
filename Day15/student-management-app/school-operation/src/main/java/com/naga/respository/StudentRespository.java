package com.naga.respository;

import com.naga.com.model.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRespository extends CrudRepository<Student, String> {
    void deleteByName(String name);
}
