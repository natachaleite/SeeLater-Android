package com.formobile.seelater;

/* Created by Nathalia on 06/02/2017. */

import java.util.Date;

public class Filme {

    private static int proximoId = 0;
    private int idFilme;
    private String nomeFilme;
    private String genero;
    private String comentario;
    private int ano;
    private int prioridade;
    private boolean visualizado;

    public Filme(String nomeFilme, String genero, String comentario, int ano, int prioridade) {
        this.idFilme = proximoId++;
        this.nomeFilme = nomeFilme;
        this.genero = genero;
        this.comentario = comentario;
        this.ano = ano;
        this.prioridade = prioridade;
        this.visualizado = false;
    }

    public void editarFilme(String nomeFilme, String genero, String comentario, int ano, int prioridade) {
        if (!this.nomeFilme.equals(nomeFilme)) {
            this.nomeFilme = nomeFilme;
        }
        if (!this.genero.equals(genero)) {
            this.genero = genero;
        }
        if (!this.comentario.equals(comentario)) {
            this.comentario = comentario;
        }
        if (this.ano != ano) {
            this.ano = ano;
        }
        if (this.prioridade != prioridade) {
            this.prioridade = prioridade;
        }
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public Boolean getVisualizado() {
        return visualizado;
    }

    public void setVisualizada(Boolean visualizada) {
        this.visualizado = visualizada;
    }
}
