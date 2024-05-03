
package com.example.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import java.io.Serializable;
import lombok.Data;

@Data //geters and seters automaticos sin necesidad de tipearlos
@Entity // para volver una entidad o modelo mi clase
@Table(name = "alumno")//la tabla en la base de datos tiene un 
                        //nombre que inicia por minusculas, y aca
                        //la clase inicia por mayusculas
public class Alumno implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_alumno;
    
    @NotEmpty
    private String codigo;
    
    @NotEmpty
    private String nombres;
    
    @NotEmpty
    private String apellidos;
    
    @NotEmpty
    @Email
    private String email;
    
    @NotEmpty
    private String estado;
    
    @Positive
    private int institucion_id;
    
    @Positive
    private int departamento_id;
    
    @Positive
    private int usuario_id;
}
