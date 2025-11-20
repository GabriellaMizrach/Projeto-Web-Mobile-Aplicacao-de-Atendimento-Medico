package br.com.gabriella.clinica.clinicamedica.Controllers;

import br.com.gabriella.clinica.clinicamedica.Entidades.Consulta;
import br.com.gabriella.clinica.clinicamedica.Repositorio.ConsultaRepositorio;
import br.com.gabriella.clinica.clinicamedica.Repositorio.MedicoRepositorio;
import br.com.gabriella.clinica.clinicamedica.Repositorio.PacienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepositorio consultaRepository;

    @Autowired
    private MedicoRepositorio medicoRepository;

    @Autowired
    private PacienteRepositorio pacienteRepository;


    @GetMapping("/nova")
    public String mostrarFormulario(Model model) {
        model.addAttribute("listaMedicos", medicoRepository.findAll());
        model.addAttribute("listaPacientes", pacienteRepository.findAll());
        return "agendamento";
    }

    @PostMapping("/salvar")
    public String salvarConsulta(Consulta consulta) {
        consulta.setStatus("AGENDADA");
        consultaRepository.save(consulta);
        return "redirect:/";
    }

    @GetMapping("/listar")
    public String listarConsultas(Model model) {
        model.addAttribute("listaConsultas", consultaRepository.findAll());
        return "lista-consultas";
    }

    @GetMapping("/excluir/{id}")
    public String excluirConsulta(@PathVariable Long id) {
        consultaRepository.deleteById(id);
        return "redirect:/";
    }
}