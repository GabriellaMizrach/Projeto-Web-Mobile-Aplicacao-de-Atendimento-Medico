package br.com.gabriella.clinica.clinicamedica.Repositorio;

import br.com.gabriella.clinica.clinicamedica.Entidades.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface MedicoRepositorio extends  JpaRepository<Medico, Long>{
}