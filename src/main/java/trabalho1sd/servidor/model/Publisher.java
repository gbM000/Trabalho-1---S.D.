package trabalho1sd.servidor.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Publisher extends Remote{
    public void subscribe(Subscriber sub) throws RemoteException;
    public void unsubscribe(Subscriber sub) throws RemoteException;
    public void enviaMensagem(String mensagem) throws RemoteException;
}
