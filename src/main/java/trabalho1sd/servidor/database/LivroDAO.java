package trabalho1sd.servidor.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import trabalho1sd.servidor.model.Livro;


public class LivroDAO {
    
    private ConexaoBD conexao = new ConexaoBD();
    
    public void insert(String query){
        try{
            this.conexao.conectar();
            int rowsAffected = this.conexao.sttm.executeUpdate(query);
            
            if(rowsAffected > 0){
                System.out.println("Insert OK");
            }else{
             System.out.println("Insert fail");   
            }
            
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.conexao.desconectar();
        }
    }
    
    public void search(String query){
        ResultSet rs = null;
        try{
            this.conexao.conectar();
            rs = this.conexao.sttm.executeQuery(query);
            
            while(rs.next()){
                System.out.println("Livro: (" + rs.getInt("ID") + ") " + rs.getString("TITULO"));
            }
            
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            try{
                if(rs != null) rs.close();
                this.conexao.desconectar();
            }catch(SQLException e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
    
    public void delete(String query){
        try{
            this.conexao.conectar();
            this.conexao.sttm.executeUpdate(query);
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.conexao.desconectar();
        }
    }
    
    public void update(String query){
        try{
            this.conexao.conectar();
            this.conexao.sttm.executeUpdate(query);
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }finally{
            this.conexao.desconectar();
        }
    }
   
}
