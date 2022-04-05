package br.com.fiap.cp.main;

import br.com.fiap.cp.entity.Livro;
import br.com.fiap.cp.service.impl.LivroServiceImpl;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        LivroServiceImpl livroService = LivroServiceImpl.getInstance();

        Livro l1 = new Livro("As Crônicas da FIAP", "Giulio", "1452154849-6", 2, LocalDate.of(2022, 04, 05), true);
        Livro l2 = new Livro("Viagem ao centro da biblioteca", "Bernardi", "4845745849-5", 15, LocalDate.of(2021, 01, 10), true);
        Livro l3 = new Livro("O Mochileiro das Galáxias", "Douglas Adams", "6958484759-9", 1, LocalDate.of(1979, 10, 12), true);

        livroService.cadastrar(l1);
        livroService.cadastrar(l2);
        livroService.cadastrar(l3);

        livroService.listar().forEach(System.out::println);

        livroService.remover(l3.getId());

        l2.setEdicao(3);
        livroService.atualizar(l2);

        livroService.listar().forEach(System.out::println);

    }


}
