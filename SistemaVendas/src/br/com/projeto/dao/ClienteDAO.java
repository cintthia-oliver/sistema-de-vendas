/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConexaoBanco;
import br.com.projeto.model.Cliente;
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
public class ClienteDAO {
    private Connection conexao;
    
    public ClienteDAO(){
        this.conexao = new ConexaoBanco().pegarConexao();
    }
    
    //Método Cadastrar Cliente
    public void cadastrarClientes(Cliente obj){
        try{
           //1 - Instrução SQL
           String sql = "insert into tb_clientes(nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)"
                   + "values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
           
           //2 - Preparar SQL
           PreparedStatement stmt = conexao.prepareStatement(sql);
           stmt.setString(1, obj.getNome());
           stmt.setString(2, obj.getRg());
           stmt.setString(3, obj.getCpf());
           stmt.setString(4, obj.getEmail());
           stmt.setString(5, obj.getTelefone());
           stmt.setString(6, obj.getCelular());
           stmt.setString(7, obj.getCep());
           stmt.setString(8, obj.getEndereco());
           stmt.setString(9, obj.getNumero());
           stmt.setString(10, obj.getComplemento());
           stmt.setString(11, obj.getBairro());
           stmt.setString(12, obj.getCidade());
           stmt.setString(13, obj.getEstado());
           
           //3 - Executar
           stmt.execute();
           stmt.close();
           JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso!");
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, "Erro: "+error);
        }
    }
    
    //Método Listar Clientes
    public List<Cliente> listarClientes(){
        try{
            List<Cliente> lista = new ArrayList<>();
            
            //1 - Instrução SQL
            String sql = "select * from tb_clientes";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            //3 - Executar
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               Cliente obj = new Cliente();
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setRg(rs.getString("rg"));
               obj.setCpf(rs.getString("cpf"));
               obj.setEmail(rs.getString("email"));
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
    
    //Metodo Alterar Cliente
    public void alterarCliente(Cliente obj){
        try{
            //1 - Instrução SQL
            String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?, celular=?, cep=?, endereco=?, numero=?, complemento=?,"
                    + " bairro=?, cidade=?, estado=? where id=?";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setString(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getEstado());
            stmt.setInt(14, obj.getId());
            
            //3 - Executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente Alterado com Sucesso!");

        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Erro: "+error);
        }
    }
    
    //Método Excluir Cliente
    public void excluirCliente(Cliente obj){
        try{
            //1 - Instrução SQL
            String sql = "delete from tb_clientes where id=?";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            
            //3 - Executar
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Cliente Excluido com Sucesso!");

            
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, "Erro: "+error);
        }
    }
    
    //Método Buscar Cliente
    public Cliente buscarCliente(String nome){
        try{
            //1 - Instrução SQL
            String sql = "select * from tb_clientes where nome = ?";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            
            //3 - Executar
            ResultSet rs = stmt.executeQuery();
            Cliente obj = new Cliente();
            
            while(rs.next()){
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setRg(rs.getString("rg"));
               obj.setCpf(rs.getString("cpf"));
               obj.setEmail(rs.getString("email"));
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
    public List<Cliente> pesquisarNome(String nome){
        try{
            //1 - Criar lista
            List<Cliente> lista = new ArrayList<>();
            
            //2 - Instrução SQL
            String sql = "select * from tb_clientes where nome like ?";
            
            //3 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            
            //4 - Executar
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
               Cliente obj = new Cliente();
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setRg(rs.getString("rg"));
               obj.setCpf(rs.getString("cpf"));
               obj.setEmail(rs.getString("email"));
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
    
    //Método Buscar Cliente pelo CPF
    public Cliente buscarClienteCPF(String cpf){
        try{
            //1 - Instrução SQL
            String sql = "select * from tb_clientes where cpf = ?";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, cpf);
            
            //3 - Executar
            ResultSet rs = stmt.executeQuery();
            Cliente obj = new Cliente();
            
            while(rs.next()){
               obj.setId(rs.getInt("id"));
               obj.setNome(rs.getString("nome"));
               obj.setRg(rs.getString("rg"));
               obj.setCpf(rs.getString("cpf"));
               obj.setEmail(rs.getString("email"));
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
    
}
