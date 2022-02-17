/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConexaoBanco;
import br.com.projeto.model.Fornecedor;
import br.com.projeto.model.Produto;
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
public class ProdutoDAO {
    private Connection conexao;

    public ProdutoDAO() {
        this.conexao = new ConexaoBanco().pegarConexao();
    }
    
    //Método Cadastrar Produto
    public void cadastrarProduto(Produto obj){
        try {
            //1 - Instrução SQL
            String sql = "insert into tb_produtos (descricao,preco,qtd_estoque,for_id)"
                + "value (?,?,?,?)";
        
            //2- Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQnt());
            stmt.setInt(4, obj.getFornecedor().getId());
            
            //3 - Executar
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
        
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }
        
    }
    
    //Método Listar Produto 
    public List<Produto> listaProduto(){
        try{
            //1 - Criar Lista
            List<Produto> lista = new ArrayList<>();
            
            //2 - Instrução SQL
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
                    + "from tb_produtos as p "
                    + "inner join tb_fornecedores as f "
                    + "on(p.for_id = f.id)";
            
            //3 - Praparando SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            
            //4 - Execução
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Fornecedor f = new Fornecedor();
                Produto obj = new Produto();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQnt(rs.getInt("p.qtd_estoque"));
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
                
                lista.add(obj);
                
            }
            return lista;
            
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
    
    //Método Alterar Produto
    public void alterarProduto(Produto obj){
        try{
            //1 - Instrução SQL
            String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?, for_id=? "
                    + "where id=?";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, obj.getDescricao());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQnt());
            stmt.setInt(4, obj.getFornecedor().getId());
            
            stmt.setInt(5, obj.getId());
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso!");
            
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }
    }
    
    //Método Excluir Produto
    public void excluirProduto(Produto obj){
        try{
            //1 - Instrução SQL
            String sql = "delete from tb_produtos where id=?";
            
            //2 - Preparar SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, obj.getId());
            
            //3 - Executar
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Produto Excluí do com Sucesso!");
            
        } catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }
    }
    
    //Método Pesquisar Produto 
    public List<Produto> pesquisarProdutoNome(String nome){
        try{
            //1 - Criar Lista
            List<Produto> lista = new ArrayList<>();
            
            //2 - Instrução SQL
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
                    + "from tb_produtos as p "
                    + "inner join tb_fornecedores as f "
                    + "on(p.for_id = f.id) where p.descricao like ?";
            
            //3 - Praparando SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            
            //4 - Execução
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Fornecedor f = new Fornecedor();
                Produto obj = new Produto();
                
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQnt(rs.getInt("p.qtd_estoque"));
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
                
                lista.add(obj);
                
            }
            return lista;
            
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
    
    
    //Método Buscar Produto 
    public Produto buscarProdutoNome(String nome){
        try{
            //1  - Instrução SQL
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome "
                    + "from tb_produtos as p "
                    + "inner join tb_fornecedores as f "
                    + "on(p.for_id = f.id) where p.descricao = ?";
            
            //2 - Praparando SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            
            //3 - Execução
            ResultSet rs = stmt.executeQuery();
            Fornecedor f = new Fornecedor();
            Produto obj = new Produto();
                
            if(rs.next()){
                obj.setId(rs.getInt("p.id"));
                obj.setDescricao(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQnt(rs.getInt("p.qtd_estoque"));
                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);
            }
            return obj;
            
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
    
    //Metodo para dar baixa no estoque
    public void baixaEstoque(int id, int qtd_nova){
        try{
            //1  - Instrução SQL
            String sql = "update tb_produtos set qtd_estoque = ? where id = ?";
            
            //2 - Praparando SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            
            //3 - Execução
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso no estoque!");
            
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }
        
    }
    
    //Método para adicionar estoque
    public void adicionarEstoque(int id, int qtd_nova){
        try{
            //1  - Instrução SQL
            String sql = "update tb_produtos set qtd_estoque = ? where id = ?";
            
            //2 - Praparando SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            
            //3 - Execução
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso no estoque!");
            
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Erro: " + error);
        }
        
    }
    
    //Método para retornar estoque atualizado
    public int retornaQtdAtualizada(int id){
        try{
            int qtd_estoque = 0;
            
            //1  - Instrução SQL
            String sql = "select qtd_estoque from tb_produtos where id = ?";
            
            //2 - Praparando SQL
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            
            //3 - Execução
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                qtd_estoque = (rs.getInt("qtd_estoque"));
            }
            
            return qtd_estoque;
            
        }catch (SQLException error) {
            throw new RuntimeException(error);
        }
    }
    
}
