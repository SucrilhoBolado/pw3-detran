package br.com.rodrigo.detran.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name =  "PW3_DETRAN")

public class Pessoa {
	@Length(max = 4)
	@Column (name = "idPessoa")
	@Id
	private Long idPessoa;
	
	@Length(max = 40)
	@NotNull
	@Column (name = "nome")
	private String nome;
	
	@Length(max = 50)
	@Column (name = "endereco")
	private String endereco;		
}
