package com.formobile.seelater;

/* Created by Nathalia on 06/02/2017. */

public class Livro {

    private static int proximoId = 0;
    private int idLivro;
    private String nomeLivro;
    private String autor;
    private String genero;
    private String comentario;
    private int numPaginas;
    private int prioridade;
    private boolean visualizado;

    public Livro(String nomeLivro, String autor, String genero, String comentario, int numPaginas, int prioridade) {
        this.idLivro = proximoId++;
        this.nomeLivro = nomeLivro;
        this.autor = autor;
        this.genero = genero;
        this.comentario = comentario;
        this.numPaginas = numPaginas;
        this.prioridade = prioridade;
        this.visualizado = false;
    }

    public void editarLivro (String nomeLivro, String autor, String genero, String comentario, int numPaginas, int prioridade) {
        if (!this.nomeLivro.equals(nomeLivro)) {
            this.nomeLivro = nomeLivro;
        }
        if (!this.autor.equals(autor)) {
            this.autor = autor;
        }
        if (!this.genero.equals(genero)) {
            this.genero = genero;
        }
        if (!this.comentario.equals(comentario)) {
            this.comentario = comentario;
        }
        if (this.numPaginas != numPaginas) {
            this.numPaginas = numPaginas;
        }
        if (this.prioridade != prioridade) {
            this.prioridade = prioridade;
        }
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
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

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
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
