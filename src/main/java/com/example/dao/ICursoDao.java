
package com.example.dao;

import com.example.domain.Curso;
import org.springframework.data.repository.CrudRepository;

public interface ICursoDao extends CrudRepository<Curso, Long>{
    
}
