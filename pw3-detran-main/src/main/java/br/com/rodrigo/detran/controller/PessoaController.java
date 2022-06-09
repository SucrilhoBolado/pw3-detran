package br.com.rodrigo.detran.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rodrigo.detran.entity.Pessoa;
import br.com.rodrigo.detran.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
	@Autowired
	private PessoaRepository repository;
	
	private List<Pessoa> dados = new ArrayList<Pessoa>();
	
	public ResponseEntity<Pessoa> inserir(@RequestBody Pessoa pes){
        repository.save(pes);
        return ResponseEntity.ok(pes);
    }
	@PostMapping 
	  public ResponseEntity<Pessoa> buscarPorId(@PathVariable Integer id) {
		
        Optional<Pessoa> pessoa = repository.findById(id);
        if(!pessoa.isPresent()) {
            ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(pessoa.get());
    }
	
	@PutMapping("{/idPessoa}")
	public void atualizar(@PathVariable Integer id, @RequestBody Pessoa pessoa)
	{
		boolean existe = repository.existsById(id);
		
		if(existe)

		{
			repository.save(pessoa);
		}
	}
}
