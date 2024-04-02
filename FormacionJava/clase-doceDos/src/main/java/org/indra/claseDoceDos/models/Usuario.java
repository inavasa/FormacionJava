package org.indra.claseDoceDos.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
public class Usuario {
    @Getter
    @Setter
    private String nickName;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private LocalDate fechaDeNacimiento;
    @Getter
    @Setter
    private String correo;

}
