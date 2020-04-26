package br.com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.entidades.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}