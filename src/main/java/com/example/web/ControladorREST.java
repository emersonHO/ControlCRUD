
package com.example.web;

import com.example.domain.Alumno;
import com.example.domain.Curso;
import lombok.extern.slf4j.Slf4j;
import com.example.servicios.IAlumnoServicio;
import com.example.servicios.ICursoServicio;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ControladorREST {

    @Autowired
    private IAlumnoServicio alumnoServicio;
    @Autowired
    private ICursoServicio cursoServicio;
    
    @GetMapping("/")
    public String comienzo(Model model){
        
        List<Alumno> alumnos = alumnoServicio.listaAlumnos();
        List<Curso> cursos = cursoServicio.listaCursos();
        
        log.info("Ejecutando desde controlador MVC");
        model.addAttribute("alumnos", alumnos);
        model.addAttribute("cursos", cursos);
        
        return "indice";
    }
    
    @GetMapping("/anexarAlumno")
    public String anexarAlumno(Alumno alumno){
        return "cambiarAlumno";
    }
    
    @GetMapping("/anexarCurso")
    public String anexarCurso(Curso curso){
        return "cambiarCurso";
    }
    
    @PostMapping("/salvarAlumno")
    public String salvarAlumno(@Valid Alumno alumno, Errors error){
        if(error.hasErrors()){
            return "cambiarAlumno";
        }
        alumnoServicio.salvar(alumno);
        return "redirect:/";
    }
    
    @PostMapping("/salvarCurso")
    public String salvarCurso(@Valid Curso curso, Errors error){
        if(error.hasErrors()){
            return "cambiarCurso";
        }
        cursoServicio.salvar(curso);
        return "redirect:/";
    }
    
    @GetMapping("/cambiarAlumno/{id_alumno}")
    public String cambiarAlumno(Alumno alumno, Model model){
        alumno = alumnoServicio.localizationAlumno(alumno);
        model.addAttribute("alumno", alumno);
        return "cambiarAlumno";
    }
    
    @GetMapping("/cambiarCurso/{id_curso}")
    public String cambiarCurso(Curso curso, Model model){
        curso = cursoServicio.localizationCurso(curso);
        model.addAttribute("curso", curso);
        return "cambiarCurso";
    }
    
    @GetMapping("/borrarAlumno")
    public String borrarAlumno(Alumno alumno, Model model){
        alumnoServicio.borrar(alumno);
        return "redirect:/";
    }
    
    @GetMapping("/borrarCurso")
    public String borrarCurso(Curso curso, Model model){
        cursoServicio.borrar(curso);
        return "redirect:/";
    }
}
