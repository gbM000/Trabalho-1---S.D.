package trabalho1sd.servidor.model;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Subscriber extends Remote{
    public void recebeMensagem(String mensagem) throws RemoteException;
}
