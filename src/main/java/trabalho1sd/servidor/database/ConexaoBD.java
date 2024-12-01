package trabalho1sd.servidor.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoBD {
    protected Connection con;
    protected Statement sttm;
    
    public void conectar(){
        try{
            con = DriverManager.getConnection("url","user","password");
            this.sttm = this.con.createStatement();
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    
    public void desconectar(){
        try{
            if(this.sttm != null) this.sttm.close();
            if(this.con != null && !this.con.isClosed()) this.con.close();
        }catch(SQLException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
