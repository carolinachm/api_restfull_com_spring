package br.com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.entidades.Lancamento;

public interface LancamentoRepository extends JpaRepository <Lancamento, Long> {

}