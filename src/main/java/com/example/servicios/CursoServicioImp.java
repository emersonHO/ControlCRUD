
package com.example.servicios;

import com.example.dao.ICursoDao;
import com.example.domain.Curso;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoServicioImp implements ICursoServicio{

    @Autowired
    private ICursoDao cursoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Curso> listaCursos() {
        return (List<Curso>) cursoDao.findAll();
    }

    @Override
    @Transactional
    public void salvar(Curso curso) {
        cursoDao.save(curso);
    }

    @Override
    @Transactional
    public void borrar(Curso curso) {
        cursoDao.delete(curso);
    }

    @Override
    @Transactional(readOnly = true)
    public Curso localizationCurso(Curso curso) {
        return cursoDao.findById(curso.getId_curso()).orElse(null);
    }
    
}
