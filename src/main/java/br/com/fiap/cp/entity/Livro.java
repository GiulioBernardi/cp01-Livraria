package br.com.fiap.cp.entity;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "tb_livro")
@SequenceGenerator(name = "livro", sequenceName = "sq_tb_livro", allocationSize = 1)
public class Livro implements Serializable {


    @Serial
    private static final long serialVersionUID = 3552051102624087041L;

    public Livro() {
        this.ativo=true;
        this.dataCadastro = LocalDateTime.now();
        this.dataAtualizacao = LocalDateTime.now();
    }

    public Livro(String titulo, String autor, String isbn, int edicao, LocalDate dataPublicacao, Boolean ativo) {
        this();
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.edicao = edicao;
        this.dataPublicacao = dataPublicacao;
        this.ativo = ativo;
    }

    @Id
    @GeneratedValue(generator="livro", strategy = GenerationType.SEQUENCE)
    @Column(name = "cd_livro")
    private Long id;

    @Column(name = "nm_livro", length = 60, nullable = false, unique = true)
    private String titulo;

    @Column(name = "nm_autor", length = 60, nullable = false)
    private String autor;

    @Column(name = "ds_isbn", length = 50, nullable = false, unique = true)
    private String isbn;

    @Column(name = "nr_edicao", length = 3)
    private Integer edicao;

    @Column(name = "dt_publicacao")
    private LocalDate dataPublicacao;

    @Column(name = "st_ativo")
    private Boolean ativo;

    @Column(name = "dt_cadastro")
    private LocalDateTime dataCadastro;

    @Column(name = "dt_atualizacao")
    private LocalDateTime dataAtualizacao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString() {
        return "Livro: titulo: " + this.getTitulo()
                +"\nautor=: " + this.getAutor()
                +"\nisbn=: " + this.getIsbn()
                +"\nedicao: " + this.getEdicao()
                +"\ndata de publicacao: " + this.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                +"\nativo: " + this.getAtivo();
    }
}