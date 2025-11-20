package br.com.gabriella.clinica.clinicamedica.Repositorio;

import br.com.gabriella.clinica.clinicamedica.Entidades.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepositorio extends JpaRepository<Consulta, Long>{
}