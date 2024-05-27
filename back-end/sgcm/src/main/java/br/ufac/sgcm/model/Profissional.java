package br.ufac.sgcm.model;

import java.io.Serializable;

public class Profissional implements Serializable {
    private Long id;
    private String nome;
    private String registro;
    private String emial;
    private String telefone;
    private Especialidade especialidade;
    private Unidade unidade;

    public Profissional() {

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getRegistro() {
        return registro;
    }
    public void setRegistro(String registro) {
        this.registro = registro;
    }
    public String getEmial() {
        return emial;
    }
    public void setEmial(String emial) {
        this.emial = emial;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Unidade getUnidade() {
        return unidade;
    }
    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }
    public Especialidade getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }
}
