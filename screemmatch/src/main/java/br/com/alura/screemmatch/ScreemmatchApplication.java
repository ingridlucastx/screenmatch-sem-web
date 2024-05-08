package br.com.alura.screemmatch;

import br.com.alura.screemmatch.model.DadosSerie;
import br.com.alura.screemmatch.service.ConsumoApi;
import br.com.alura.screemmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreemmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreemmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumoApi();
		var json = consumoApi.obterDados("https://www.omdbapi.com/?t=lost&apikey=76a8ed5a");
		System.out.println(json);
        ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);



	}
}
