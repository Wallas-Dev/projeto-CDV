/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cdv.model;

import br.com.cdv.dao.ItemVendaDAO;
import java.util.List;

public class ItemVendas {
    //Atributos
    
    private int id;
    private Vendas venda;
    private Produtos produto;
    private int qtd;
    private double subtotal;
    
    
    public void cadastrarItem(ItemVendas obj) {
        new ItemVendaDAO().cadastrarItem(obj);

    }

    public List<ItemVendas> listaItensPorVenda(int venda_id) {
        return new ItemVendaDAO().listaItensPorVenda(venda_id);

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vendas getVenda() {
        return venda;
    }

    public void setVenda(Vendas venda) {
        this.venda = venda;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
    
    
}
