/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cdv.dao;

import br.com.cdv.jdbc.ConnectionFactory;

import br.com.cdv.model.Funcionarios;
import br.com.cdv.view.FrmLogin;
import br.com.cdv.view.FrmMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class FuncionarioDAO{


    private Connection con;

    public FuncionarioDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Metodo Cadastrar Funcionario
    public void cadastrarFuncionario(Funcionarios obj) {
        try {
            //criação do comando sql
            String sql = "insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //conectar o banco de dados e organizar o comando sql 
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            // Executar comando
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);

        }
    }

    // metado alterar funcinarios
    public void alterarFuncionario(Funcionarios obj) {
        try {
            //criação do comando sql
            String sql = "update tb_funcionarios set nome=?,rg=?,cpf=?,email=?,senha=?,cargo=?,nivel_acesso=?,telefone=?,celular=?,cep=?,"
                    + "endereco=?,numero=?,complemento=?,bairro=?,cidade=?,estado=? where id =?";

            //conectar o banco de dados e organizar o comando sql 
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            stmt.setInt(17, obj.getId());

            // Executar comando
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);

        }

    }

    // metado excluir funcinarios
    public void excluirFuncionario(int id) {
        try {
            //criação do comando sql
            String sql = "delete from tb_funcionarios where id = ?";

            //conectar o banco de dados e organizar o comando sql 
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            // Executar comando
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro" + erro);

        }

    }

    //metodo listar funcionarios 
    public List<Funcionarios> listarFuncionarios() {
        try {
            // criando a lista

            List<Funcionarios> lista = new ArrayList<>();
            // criando sql
            String sql = "select * from tb_funcionarios";

            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }

    }

    // Consulta Funcionario por cpf 
    public Funcionarios consultaPorCpf(String cpf) {
        try {
            String sql = "select * from tb_funcionarios where cpf = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();

            Funcionarios obj = new Funcionarios();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

            }
            return obj;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Funcionario nao encontrado!");
            return null;

        }

    }

    // Metodo listar Funcionario por nome -- retorna uma lista
    public List<Funcionarios> listaFuncionariosNome(String nome) {
        try {
            // criando a lista

            List<Funcionarios> lista = new ArrayList<>();
            // criando sql
            String sql = "select * from tb_funcionarios where nome like ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }

    }

    //Metodo efetua login 
    public void efetuarLogin(String email, String senha) {

        try {
            // Comando login 
            String sql = "select * from tb_funcionarios where email = ? and senha = ?";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                // Usuario logou 

                // caso o usuario seja do tipo admin
                if (rs.getString("nivel_acesso").equals("Administrador")) {
                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema! ");
                    FrmMenu tela = new FrmMenu();
                    tela.usuarioLogado = rs.getString("nome");
                    tela.nivel_acesso = rs.getString("nivel_acesso");
                    tela.setVisible(true);

                } // Caso o usuario seja do tipo limitado 
                else if (rs.getString("nivel_acesso").equals("Gerente")) {

                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao sistema! ");
                    FrmMenu tela = new FrmMenu();
                    tela.usuarioLogado = rs.getString("nome");
                    tela.nivel_acesso = rs.getString("nivel_acesso");


                    tela.setVisible(true);

                }

            } else {
                //Dados incorretos
                JOptionPane.showMessageDialog(null, "Dados incorretos! ");
                new FrmLogin().setVisible(true);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

}
