package br.com.gabriella.clinica.clinicamedica.Controllers;

import br.com.gabriella.clinica.clinicamedica.Entidades.Paciente;
import br.com.gabriella.clinica.clinicamedica.Repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequestMapping ("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepositorio repository;
    @PostMapping
    public void cadastrar( @RequestBody Paciente paciente){
        repository.save(paciente);
    }
    @GetMapping
    public List <Paciente> listar(){
        return repository.findAll();
    }
    @DeleteMapping ("/{id}")
    public void excluir (@PathVariable long id) {
        repository.deleteById(id);
    }
    @PutMapping
    public void atualizar (@RequestBody Paciente paciente){
        repository.save(paciente);
    }

    @GetMapping("/novo")
    public String mostrarFormulario() {
        return "cadastro-paciente";
    }

    @PostMapping("/salvar")
    public String salvarPaciente(Paciente paciente) {
        repository.save(paciente);
        return "redirect:/";
    }

    @GetMapping("/listar")
    public String listarPacientes(org.springframework.ui.Model model) {
        model.addAttribute("listaPacientes", repository.findAll());
        return "lista-pacientes";
    }

    @GetMapping("/excluir/{id}")
    public String excluirPaciente(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/pacientes/listar";
    }
}