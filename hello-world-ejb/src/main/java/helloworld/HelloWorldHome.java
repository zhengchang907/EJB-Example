package helloworld;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface HelloWorldHome extends EJBHome {
	HelloWorldRemote create() throws CreateException, RemoteException;
}
