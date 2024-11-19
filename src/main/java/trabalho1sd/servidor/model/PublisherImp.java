package trabalho1sd.servidor.model;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class PublisherImp extends UnicastRemoteObject implements Publisher{

    private List<Subscriber> subs;
    
    public PublisherImp() throws RemoteException{
        this.subs = new ArrayList<>();
    }
    
    @Override
    public void subscribe(Subscriber sub) throws RemoteException {
        this.subs.add(sub);
    }

    @Override
    public void unsubscribe(Subscriber sub) throws RemoteException {
        subs.remove(sub);
    }

    @Override
    public void enviaMensagem(String mensagem) throws RemoteException {
        for(Subscriber s : this.subs){
            try{
                s.recebeMensagem(mensagem);
            }catch(RemoteException e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }
    
}
