/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cdv.dao;

import br.com.cdv.jdbc.ConnectionFactory;
import br.com.cdv.model.ControleEstoque;
import br.com.cdv.model.Fornecedores;
import br.com.cdv.model.Produtos;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProdutoDAO {

    private Connection con;

    public ProdutoDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    // Metodo cadastrar produto
    public void cadastrar(Produtos obj) {
        try {

            String sql = "insert into tb_produtos (descricao,valor_bruto,preco,qtd_estoque,for_id) values(?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getValor_bruto());
            stmt.setDouble(3, obj.getPreco());
            stmt.setInt(4, obj.getQtd_estoque());
            stmt.setInt(5, obj.getFornecedor().getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }

    }

    // Metodo listar Produtos
    public List<Produtos> listarProdutos() {
        try {
            // criando a lista

            List<Produtos> lista = new ArrayList<>();
            // criando sql
            String sql = "select p.id, p.descricao, p.valor_bruto,p.preco,p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id)";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setValor_bruto(rs.getDouble("p.valor_bruto"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                f.setNome(rs.getString(("f.nome")));

                obj.setFornecedor(f);

                lista.add(obj);
            }

            return lista;

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }

    }

    // Metodo Alterar Produto 
    public void alterar(Produtos obj) {
        try {

            String sql = "update tb_produtos set descricao=?,valor_bruto=?,preco=?,qtd_estoque=?,for_id=? where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getValor_bruto());
            stmt.setDouble(3, obj.getPreco());
            stmt.setInt(4, obj.getQtd_estoque());
            stmt.setInt(5, obj.getFornecedor().getId());
            stmt.setInt(6, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto alterado com sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }

    }

    //metodo excluir Produtos
    public void excluir(Produtos obj) {
        try {

            String sql = "delete from tb_produtos where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro" + erro);
        }

    }

    public List<Produtos> listarProdutosPorNome(String nome) {
        try {
            // criando a lista

            List<Produtos> lista = new ArrayList<>();
            // criando sql
            String sql = "select p.id, p.descricao,p.valor_bruto, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao like?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setValor_bruto(rs.getDouble("p.valor_bruto"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));
                f.setNome(rs.getString(("f.nome")));

                obj.setFornecedor(f);

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }

    }

    public Produtos consultarProdutosPorNome(String nome) {
        try {
            // criando a lista

            // criando sql
            String sql = "select p.id, p.descricao,p.valor_bruto, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();

            if (rs.next()) {

                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setValor_bruto(rs.getDouble("p.valor_bruto"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString(("f.nome")));

                obj.setFornecedor(f);

            }

            return obj;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            return null;

        }

    }

    // busca produto por Codigo
    public Produtos buscaPorCodigo(int id) {
        try {
            // criando a lista

            // criando sql
            String sql = "select * from tb_produtos where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setDescricao(rs.getString("descricao"));
                obj.setValor_bruto(rs.getDouble("valor_bruto"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));

            }

            return obj;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Produto não encontrado!");
            return null;

        }

    }
    // Metodo que da baixa no estoque 

    public void baixaEstoque(int id, int qtd_nova) {
        try {

            String sql = "update tb_produtos set qtd_estoque= ? where id=?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro_Produto:" + erro);

        }

    }
    // Metodo que retorna o estoque atual de um produto

    public int retornaEstoqueAtual(int id) {
        try {
            int qtd_estoque = 0;
            int qtd_adiquirida;

            String sql = "select qtd_estoque from tb_produtos where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                
                qtd_estoque = (rs.getInt("qtd_estoque"));
            }
            
            return qtd_estoque;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }
    }
    
    public void adicionarEstoque(int id, int qtd_nova){
        try {
            
            String sql = "update tb_produtos set qtd_estoque = ? where id= ?";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();
 
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro"+erro);
        }
    }
    
    public void cadastrarEstoque(ControleEstoque control){
        try {
            
            String sql = "insert into tb_adicao_estoque(produto_id, qtd_add, data_add, subtotal)values(?,?,?,?);";
            
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setInt(1, control.getProduto().getId());
            stmt.setInt(2, control.getQtd_adicionada());
            stmt.setString(3, control.getData_adicionada());
            stmt.setDouble(4, control.getSubtotal());
            stmt.execute();
            stmt.close();
 
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro"+erro);
        }
    }

}
