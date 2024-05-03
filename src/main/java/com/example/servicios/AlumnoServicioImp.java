
package com.example.servicios;

import com.example.dao.IAlumnoDao;
import com.example.domain.Alumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AlumnoServicioImp implements IAlumnoServicio{

    @Autowired
    private IAlumnoDao alumnoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Alumno> listaAlumnos() {
        return (List<Alumno>) alumnoDao.findAll();
    }

    @Override
    @Transactional
    public void salvar(Alumno alumno) {
        alumnoDao.save(alumno);
    }

    @Override
    @Transactional
    public void borrar(Alumno alumno) {
        alumnoDao.delete(alumno);
    }

    @Override
    @Transactional(readOnly = true)
    public Alumno localizationAlumno(Alumno alumno) {
        return alumnoDao.findById(alumno.getId_alumno()).orElse(null);
    }
    
}
