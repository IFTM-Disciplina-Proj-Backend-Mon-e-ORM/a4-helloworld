package com.iftm.api.helloworld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@SpringBootApplication
@RestController
@RequestMapping("/api")
public class HelloworldApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloworldApplication.class, args);
	}

	// GET padrão
	@GetMapping
	public String helloWorld() {
		return "<h1>Olá, Mundo!</h1>";
	}

	@GetMapping("mars")
	public String helloMars() {
		return "Olá, Marte!";
	}

	@GetMapping("moon")
	public String helloMoon() {
		return "Olá, Lua!";
	}

	// GET aluno
	@GetMapping("aluno")
	public Aluno getAluno() {
		return new Aluno("Fabio", 25);
	}

	// POST Aluno
	// Obtem um objeto JSON no corpo da requisição
	@PostMapping("aluno")
	public Aluno saveAluno(@RequestBody Aluno aluno) {
		// Logger para printar no terminal do springboot
		Logger logger = Logger.getLogger(HelloworldApplication.class.getName());
		logger.info("Aluno recebido: \n" + aluno.toString());
		return aluno;
	}

	// GET Lista de Alunos
	@GetMapping("alunos")
	public List<Aluno> getAlunos() {
		var listaDeAlunos = new ArrayList<Aluno>();
		listaDeAlunos.add(new Aluno("Braulio", 21));
		listaDeAlunos.add(new Aluno("Rodrigo", 30));
		listaDeAlunos.add(new Aluno("Jose Pereira", 81));
		listaDeAlunos.add(new Aluno("Maria Laura", 27));
		return listaDeAlunos;
	}
}
