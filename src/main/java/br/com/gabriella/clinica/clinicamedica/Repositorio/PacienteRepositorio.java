package br.com.gabriella.clinica.clinicamedica.Repositorio;

import br.com.gabriella.clinica.clinicamedica.Entidades.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepositorio extends  JpaRepository<Paciente, Long>{
}