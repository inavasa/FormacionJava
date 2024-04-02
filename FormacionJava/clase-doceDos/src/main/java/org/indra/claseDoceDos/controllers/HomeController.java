package org.indra.claseDoceDos.controllers;

import org.indra.claseDoceDos.models.Usuario;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

@RestController
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "Hola mundo web!";
    }

    @RequestMapping(value = "/hola", method = RequestMethod.GET)
    public String hello() {
        return """
                <h1>Hola mundo web!!!</h1>
                """;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public Usuario datosAdmin() {
        return Usuario.builder().nickName("Ivan").password("1234").correo("inavas@indra.es").fechaDeNacimiento(LocalDate.of(1998, Month.MARCH, 1)).build();
    }

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ArrayList<Usuario> listaUsuarios() {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();
        lista.add(Usuario.builder().nickName("Karim").password("1234").correo("k.malbo@yahoo.es").fechaDeNacimiento(LocalDate.of(1998, Month.APRIL, 6)).build());
        lista.add(Usuario.builder().nickName("Nordin").password("1234").correo("n.flecha@yahoo.es").fechaDeNacimiento(LocalDate.of(1995, Month.APRIL, 6)).build());
        lista.add(Usuario.builder().nickName("Mustafa").password("1234").correo("tafito@yahoo.es").fechaDeNacimiento(LocalDate.of(1998, Month.MARCH, 12)).build());

        return lista;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        // No hacer esto, solo como prueba
        return """
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <style>
                        body {
                            background: linear-gradient(to right, #ff9966, #ff5e62);
                        }
                        form {
                            display: flex;
                            flex-direction: column;
                            align-items: center;
                            margin-top: 100px;
                            padding: 30px;
                            background-color: white;
                            border-radius: 10px;
                            box-shadow: 0px 0px 20px 0px rgba(0,0,0,0.2);
                        }
                        label {
                                    display: block;
                                    margin-bottom: 10px;
                                    font-size: 18px;
                                    font-weight: bold;
                                }
                                input[type="text"], input[type="password"] {
                                    width: 300px;
                                    height: 40px;
                                    padding-left: 10px;
                                    font-size: 18px;
                                    border: 1px solid grey;
                                    border-radius: 5px;
                                    box-shadow: 0px 0px 5px 0px rgba(0,0,0,0.2);
                                    margin-bottom: 20px;
                                }
                                input[type="submit"] {
                                    display: block;
                                    margin-top: 20px;
                                    width: 100px;
                                    height: 40px;
                                    border-radius: 5px;
                                    font-size: 18px;
                                    cursor: pointer;
                                    border: none;
                                    box-shadow: 0px 0px 5px 0px rgba(0,0,0,0.2);
                                }
                                 #login_button_1 {
                                            background-color: #f44336;
                                            color: white;
                                        }
                                        #login_button_2 {
                                            background-color: #ffeb3b;
                                            color: black;
                                            margin-left: 30px;
                                        }
                                        #login_button_1:hover {
                                            background-color: #e53935;
                                        }
                                        #login_button_2:hover {
                                            background-color: #ffe082;
                                        }
                                        p {
                                            text-align: center;
                                            margin-top: 30px;
                                            font-size: 18px;
                                        }
                                        a {
                                            text-decoration: none;
                                            color: blue;
                                        }
                                    </style>
                                    </head>
                                    <body>
                                        <form>
                                            <label for="email_or_phone">Email or Phone</label><br>
                                            <input type="text" id="email_or_phone" name="email_or_phone"><br>
                                            <label for="password">Password</label><br>
                                            <input type="password" id="password" name="password"><br>
                                            <input type="submit" value="Login" id="login_button_1">
                                        </form>
                                        <p>Not a member? <a href="signup.html">Signup now</a></p>
                                    </body>
                                    </html>
                """;
    }
}
