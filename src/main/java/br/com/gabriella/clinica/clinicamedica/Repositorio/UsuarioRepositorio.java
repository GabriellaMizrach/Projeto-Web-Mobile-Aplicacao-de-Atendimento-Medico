package br.com.gabriella.clinica.clinicamedica.Repositorio;

import br.com.gabriella.clinica.clinicamedica.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepositorio extends  JpaRepository<Usuario, Long>{
}