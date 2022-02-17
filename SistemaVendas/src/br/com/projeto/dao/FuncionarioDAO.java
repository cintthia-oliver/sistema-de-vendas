/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConexaoBanco;
import br.com.projeto.model.Funcionario;
import br.com.projeto.view.FormLogin;
import br.com.projeto.view.FormMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Ohayou
 */
public class FuncionarioDAO {
    private Connection conexao;
    
    public FuncionarioDAO(){
        this.conexao = new ConexaoBanco().pegarConexao();
    }
    
    //Método Cadastrar Funcionario
    public void cadastrarFuncionarios(Funcionario obj){
        try{
           //1 - Instrução SQL
           String sql = "insert into tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, cep, "
                   + "endereco, numero, complemento, bairro, cidade, estado) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
           
           //2 - Preparar SQL
           PreparedStatement stmt = conexao.prepareStatement(sql);
           stmt.setString(1, obj.getNome());
           stmt.setString(2, obj.getRg());
           stmt.setString(3, obj.getCpf());
           stmt.setString(4, obj.getEmail());
           stmt.setString(5, obj.getSenha());
           stmt.setString(6, obj.getCargo());
           stmt.setString(7, obj.getNivel());
           stmt.setString(8, obj.getTelefone());
           stmt.setString(9, obj.getCelular());
           stmt.setString(10, obj.getCep());
           stmt.setString(11, obj.getEndereco());
           stmt.setString(12, obj.getNumero());
           stmt.setString(13, obj.getComplemento());
           stmt.setString(14, obj.getBairro());
           stmt.setString(15, obj.getCidade());
           stmt.setString(16, obj.getEstado());
           
           //3 - Executar
           stmt.execute();
           stmt.close();
           JOptionPane.showMessageDialog(null, "Funcionário Cadastrado com Sucesso!");
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, "Erro: "+error);
        }
    }
    
    //Método Listar Funcionario
    public List<Funcionario> listarFuncionarios(){
        try{
            List<Funcionario> lista = new ArrayList<>();
            
            //1 - Instrução SQL
            String sql = "select * from tb_funcionarios";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            //3 - Executar
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               Funcionario obj = new Funcionario();
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setRg(rs.getString("rg"));
               obj.setCpf(rs.getString("cpf"));
               obj.setEmail(rs.getString("email"));
               obj.setSenha(rs.getString("senha"));
               obj.setCargo(rs.getString("cargo"));
               obj.setNivel(rs.getString("nivel_acesso"));
               obj.setTelefone(rs.getString("telefone"));
               obj.setCelular(rs.getString("celular"));
               obj.setCep(rs.getString("cep"));
               obj.setEndereco(rs.getString("endereco"));
               obj.setNumero(rs.getString("numero"));
               obj.setComplemento(rs.getString("complemento"));
               obj.setBairro(rs.getString("bairro"));
               obj.setCidade(rs.getString("cidade"));
               obj.setEstado(rs.getString("estado"));
               
               lista.add(obj);
               
            }
            return lista;
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,"Erro: "+e);
        }
        return null;
    }
    
    //Metodo Alterar Funcionario
    public void alterarFuncionario(Funcionario obj){
        try{
            //1 - Instrução SQL
            String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?, senha=?, cargo=?, nivel_acesso=?, telefone=?, "
                    + "celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setString(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getEstado());
            stmt.setInt(17, obj.getId());
            
            //3 - Executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Funcionario Alterado com Sucesso!");

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Erro: "+error);
        }
    }
    
    //Método Excluir Funcionario
    public void excluirFuncionario(Funcionario obj){
        try{
            //1 - Instrução SQL
            String sql = "delete from tb_funcionarios where id=?";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            
            //3 - Executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Funcionário Excluido com Sucesso!");

            
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Erro: "+error);
        }
    }
    
    //Método Buscar Funcionario
    public Funcionario buscarFuncionario(String nome){
        try{
            //1 - Instrução SQL
            String sql = "select * from tb_funcionarios where nome = ?";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            
            //3 - Executar
            ResultSet rs = stmt.executeQuery();
            Funcionario obj = new Funcionario();
            
            while(rs.next()){
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setRg(rs.getString("rg"));
               obj.setCpf(rs.getString("cpf"));
               obj.setEmail(rs.getString("email"));
               obj.setSenha(rs.getString("senha"));
               obj.setCargo(rs.getString("cargo"));
               obj.setNivel(rs.getString("nivel_acesso"));
               obj.setTelefone(rs.getString("telefone"));
               obj.setCelular(rs.getString("celular"));
               obj.setCep(rs.getString("cep"));
               obj.setEndereco(rs.getString("endereco"));
               obj.setNumero(rs.getString("numero"));
               obj.setComplemento(rs.getString("complemento"));
               obj.setBairro(rs.getString("bairro"));
               obj.setCidade(rs.getString("cidade"));
               obj.setEstado(rs.getString("estado"));
            }
            return obj;
            
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Erro: "+error);
        }
        
        return null;
    }
    
    //Método filtrar cliente na tabela
    public List<Funcionario> pesquisarNome(String nome){
        try{
            //1 - Criar lista
            List<Funcionario> lista = new ArrayList<>();
            
            //2 - Instrução SQL
            String sql = "select * from tb_funcionarios where nome like ?";
            
            //3 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            
            //4 - Executar
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               Funcionario obj = new Funcionario();
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setRg(rs.getString("rg"));
               obj.setCpf(rs.getString("cpf"));
               obj.setEmail(rs.getString("email"));
               obj.setSenha(rs.getString("senha"));
               obj.setCargo(rs.getString("cargo"));
               obj.setNivel(rs.getString("nivel_acesso"));
               obj.setTelefone(rs.getString("telefone"));
               obj.setCelular(rs.getString("celular"));
               obj.setCep(rs.getString("cep"));
               obj.setEndereco(rs.getString("endereco"));
               obj.setNumero(rs.getString("numero"));
               obj.setComplemento(rs.getString("complemento"));
               obj.setBairro(rs.getString("bairro"));
               obj.setCidade(rs.getString("cidade"));
               obj.setEstado(rs.getString("estado"));
               
               lista.add(obj);
               
            }
            return lista;
            
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Erro:\n "+error);
        }
        
        return null;
    }
    
    //Método Login
    public void efetuarLogin(String email, String senha){
        try{
            //1 - Instrução SQL
            String sql = "select * from tb_funcionarios where email=? and senha=?";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            
            //4 - Executar
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()){
                if(rs.getString("nivel_acesso").equals("Administrador"))
                {
                    FormMenu menu = new FormMenu();
                    menu.logUser = rs.getString("nome");
                    JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema! " + menu.logUser);
                    menu.setVisible(true);
                }
                else if(rs.getString("nivel_acesso").equals("Usuário"))
                {
                    FormMenu menu = new FormMenu();
                    menu.logUser = rs.getString("nome");
                    JOptionPane.showMessageDialog(null, "Bem vindo ao Sistema! " + menu.logUser);
                    menu.setVisible(true);
                }
                else
                {
                    FormLogin login = new FormLogin();
                    JOptionPane.showMessageDialog(null, "Dados Inválidos");
                    login.setVisible(true);
                }
            }else{
                    FormLogin login = new FormLogin();
                    JOptionPane.showMessageDialog(null, "Dados Inválidos");
                    login.setVisible(true);
                }
            
        }catch (SQLException error){
            throw new RuntimeException(error);
        }
    }
    
}
