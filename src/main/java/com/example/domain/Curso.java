
package com.example.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name = "curso")
public class Curso implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_curso;
    
    @NotEmpty
    private String codigo;
    
    @NotEmpty
    private String nombre;
    
    @NotEmpty
    private String tipo;
    
    @NotEmpty
    private String ciclo;
    
    @NotEmpty
    private String estado;
    
    @NotEmpty
    private String sumilla;
    
    @NotEmpty
    private String modalidad; 
    
    @Min(0)
    private int num_horas_teoria;
    
    @Min(0)
    private int num_horas_practica;
    
    @Min(0)
    private int num_horas_laboratorio;
    
    @Min(0)
    private int num_horas_campo;
    
    @Positive
    private int num_creditos;
    
    @Positive
    private int periodo_academico_id;
    
    @Positive
    private int planes_estudio_id;
    
    @Positive
    private int institucion_id;
    
    @Positive
    private int departamento_id;
       
}
