/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cdv.model;

import javax.swing.Icon;


public class Model_Card {
    
    Icon icon;
    String titulo;
    String valor;
    String descricao;
    
    public Model_Card(){
        
    }

    public Model_Card(Icon icon, String titulo, String valor, String descricao) {
        this.icon = icon;
        this.titulo = titulo;
        this.valor = valor;
        this.descricao = descricao;
    }
    

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
}
