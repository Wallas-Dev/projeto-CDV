/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cdv.dao;

import br.com.cdv.jdbc.ConnectionFactory;
import br.com.cdv.model.ItemVendas;
import br.com.cdv.model.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class ItemVendaDAO {

    private Connection con;

    public ItemVendaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    // Metodo cadastrar intens
    public void cadastrarItem(ItemVendas obj) {

        try {

            String sql = "insert into tb_itensvendas (venda_id,produto_id,qtd,subtotal) values(?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getVenda().getId());
            stmt.setInt(2, obj.getProduto().getId());;
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());

            stmt.execute();
            stmt.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro_Item:" + erro);
        }

    }

    public List<ItemVendas> listaItensPorVenda(int venda_id) {
        try {
            // criando a lista

            List<ItemVendas> lista = new ArrayList<>();
            // criando sql
            String sql = "select p.descricao,i.qtd,p.preco,i.subtotal from tb_itensvendas as i "
                    + "inner join tb_produtos as p on(i.produto_id = p.id)where i.venda_id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, venda_id);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                ItemVendas item = new ItemVendas();
                Produtos prod = new Produtos();

                
                prod.setDescricao(rs.getString("p.descricao"));
                item.setQtd(rs.getInt("i.qtd"));
                prod.setPreco(rs.getDouble("p.preco"));
                item.setSubtotal(rs.getDouble("i.subtotal"));

                item.setProduto(prod);

                lista.add(item);

            }

            return lista;

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }

    }

}
