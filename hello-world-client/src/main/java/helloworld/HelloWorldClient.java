package helloworld;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class HelloWorldClient {

	public static void main(String[] args) {

		try {
			InitialContext context = new InitialContext();

			Object foundUsingGlobal = context
					.lookup("java:global/hello-world/hello-world-ejb/HelloWorld!helloworld.HelloWorldHome");
			Object foundUsingCorba = context.lookup(
					"corbaname::localhost:2809#ejb/global/hello-world/hello-world-ejb/HelloWorld!helloworld%5c.HelloWorldHome");

			HelloWorldHome helloWorldHomeUsingGlobal = (HelloWorldHome) PortableRemoteObject.narrow(foundUsingGlobal,
					HelloWorldHome.class);
			HelloWorldHome helloWorldHomeUsingCorba = (HelloWorldHome) PortableRemoteObject.narrow(foundUsingCorba,
					HelloWorldHome.class);

			helloWorldHomeUsingGlobal.create().helloWorld("Access EJB using java:global");
			helloWorldHomeUsingCorba.create().helloWorld("Access EJB using corbaname:");
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (CreateException e) {
			e.printStackTrace();
		}
	}
}
