package br.com.gabriella.clinica.clinicamedica.Controllers;

import br.com.gabriella.clinica.clinicamedica.Entidades.Medico;
import br.com.gabriella.clinica.clinicamedica.Repositorio.MedicoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepositorio repository;

    @GetMapping("/novo")
    public String mostrarFormulario() {
        return "cadastro-medico";
    }

    @PostMapping("/salvar")
    public String salvarMedico(Medico medico) {
        repository.save(medico);
        return "redirect:/";
        }

    @GetMapping("/listar")
    public String listarMedicos(org.springframework.ui.Model model) {
        model.addAttribute("listaMedicos", repository.findAll());
        return "lista-medicos";
    }

    @GetMapping("/excluir/{id}")
    public String excluirMedico(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/medicos/listar";
    }
}