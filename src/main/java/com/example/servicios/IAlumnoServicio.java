
package com.example.servicios;

import com.example.domain.Alumno;
import java.util.List;

public interface IAlumnoServicio {
    
    public List<Alumno> listaAlumnos();
    
    public void salvar(Alumno alumno);
    
    public void borrar(Alumno alumno);
    
    public Alumno localizationAlumno(Alumno alumno);
    
    
}
