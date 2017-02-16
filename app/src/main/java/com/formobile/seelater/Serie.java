package com.formobile.seelater;

/* Created by Nathalia on 07/02/2017. */

public class Serie {

    private static int proximoId = 0;
    private int idSerie;
    private String nomeSerie;
    private String produtora;
    private String genero;
    private String comentario;
    private int temporada;
    private int prioridade;
    private boolean visualizado;

    public Serie(String nomeSerie, String produtora, String genero, String comentario, int temporada, int prioridade) {
        this.idSerie = proximoId++;
        this.nomeSerie = nomeSerie;
        this.produtora = produtora;
        this.genero = genero;
        this.comentario = comentario;
        this.temporada = temporada;
        this.prioridade = prioridade;
        this.visualizado = false;
    }

    public void editarSerie (String nomeSerie, String produtora, String genero, String comentario, int temporada, int prioridade) {
        if (!this.nomeSerie.equals(nomeSerie)) {
            this.nomeSerie = nomeSerie;
        }
        if (!this.produtora.equals(produtora)){
            this.produtora = produtora;
        }
        if (!this.genero.equals(genero)){
            this.genero = genero;
        }
        if (!this.comentario.equals(comentario)) {
            this.comentario = comentario;
        }
        if (this.temporada != temporada) {
            this.temporada = temporada;
        }
        if (this.prioridade != prioridade) {
            this.prioridade = prioridade;
        }
    }

    public String getNomeSerie() {
        return nomeSerie;
    }

    public void setNomeSerie(String nomeSerie) {
        this.nomeSerie = nomeSerie;
    }

    public String getProdutora() {
        return produtora;
    }

    public void setProdutora(String produtora) {
        this.produtora = produtora;
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

    public int getTemporada() {
        return temporada;
    }

    public void setTemporada(int temporada) {
        this.temporada = temporada;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }

    public boolean isVisualizado() {
        return visualizado;
    }

    public void setVisualizado(boolean visualizado) {
        this.visualizado = visualizado;
    }
}
