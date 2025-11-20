package br.com.gabriella.clinica.clinicamedica.Controllers;

import br.com.gabriella.clinica.clinicamedica.Entidades.Usuario;
import br.com.gabriella.clinica.clinicamedica.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepositorio repository;
    @PostMapping
    public void cadastrar( @RequestBody Usuario usuario){
        repository.save(usuario);
    }
    @GetMapping
    public List <Usuario> listar(){
        return repository.findAll();
    }

}