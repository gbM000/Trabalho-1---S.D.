package trabalho1sd.servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import trabalho1sd.servidor.model.*;

public class Servidor {

    public static void main(String[] args) {
        
        try{
            Registry regs = LocateRegistry.createRegistry(1098);
            Publisher pub = new PublisherImp();
            regs.rebind("ServerRMI", pub);
            System.out.println("Servidor Iniciado.");
        }catch(RemoteException e){
            System.out.println("Erro: " + e.getMessage());
        }
        
    }
}
