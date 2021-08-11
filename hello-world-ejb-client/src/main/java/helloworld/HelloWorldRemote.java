package helloworld;

import java.rmi.RemoteException;

import javax.ejb.EJBObject;

public interface HelloWorldRemote extends EJBObject {
	public void helloWorld(String name) throws RemoteException;
}
