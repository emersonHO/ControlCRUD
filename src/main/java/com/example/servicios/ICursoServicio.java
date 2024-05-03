
package com.example.servicios;

import com.example.domain.Curso;
import java.util.List;

public interface ICursoServicio {
    
    public List<Curso> listaCursos();
    
    public void salvar(Curso curso);
    
    public void borrar(Curso curso);
    
    public Curso localizationCurso(Curso curso);
    
}
