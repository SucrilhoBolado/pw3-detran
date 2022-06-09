package br.com.rodrigo.detran.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;

import br.com.rodrigo.detran.enums.EstadoMultaEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

@Table(name =  "PW3_DETRAN")

public class Multa {
	@Length(max = 4)
    @NotNull
	@Column (name = "idMulta")
	@Id
	private Long idVeiculo;
	
    @Future
	@Column (name = "vencimento")
	private LocalDate vencimento;
	
    @Past
    @Column (name = "dataAplicacao")
    private LocalDate dataAplicacao;
    @Length(max = 10)
	@Column(name = "estadoMulta")
	@Enumerated(EnumType.STRING)
	private EstadoMultaEnum estadoMulta;
   
    @Length(max = 30)
	@Column (name = "orgao")
	private String orgao;
    
    @NotNull
    @ManyToOne
	@JoinColumn (name = "pessoa")
	private Pessoa condutor;
    
    @NotNull
    @ManyToOne
	@JoinColumn (name = "veiculo")
	private Veiculo veiculo;
}
