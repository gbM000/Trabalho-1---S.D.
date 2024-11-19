package trabalho1sd.cliente;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import trabalho1sd.servidor.model.Publisher;
import trabalho1sd.servidor.model.Subscriber;


public class Cliente extends UnicastRemoteObject implements Subscriber{

    public Cliente() throws RemoteException{}
    
    @Override
    public void recebeMensagem(String mensagem) throws RemoteException {
        System.out.println(mensagem);
    }
    
    public static void main(String[] args){
        try{
            Scanner scanner = new Scanner(System.in);
            Registry regs = LocateRegistry.getRegistry("localhost",1098);
            Publisher pub = (Publisher) regs.lookup("ServerRMI");
            System.out.println("Conectado ao servidor");
            
            Cliente sub = new Cliente();
            
            pub.subscribe(sub);
         
            String input;
            while (true) {
                input = scanner.nextLine();
                if (input.equalsIgnoreCase("sair")) {
                    pub.unsubscribe(sub);
                    break;
                }
            }
            
            System.out.println("Encerrando sessão");
            scanner.close();
        }catch(Exception e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
