package br.com.rodrigo.detran.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.rodrigo.detran.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{

}
