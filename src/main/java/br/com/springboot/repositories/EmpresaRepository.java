package br.com.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springboot.entidades.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Transactional(readOnly = true)
	Empresa findByCnpj(String cnpj);

}