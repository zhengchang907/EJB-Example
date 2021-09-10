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
			Object foundUsingApp = context.lookup("java:app/hello-world-ejb/HelloWorld!helloworld.HelloWorldHome");
			Object foundUsingCorba = context.lookup(
					"corbaname::localhost:2809#ejb/global/hello-world/hello-world-ejb/HelloWorld!helloworld%5c.HelloWorldHome");
			Object foundUsingRef = context.lookup("java:comp/env/ejb/session/HelloWorld");

			HelloWorldHome helloWorldHomeUsingGlobal = (HelloWorldHome) PortableRemoteObject.narrow(foundUsingGlobal,
					HelloWorldHome.class);
			HelloWorldHome helloWorldHomeUsingApp = (HelloWorldHome) PortableRemoteObject.narrow(foundUsingApp,
					HelloWorldHome.class);
			HelloWorldHome helloWorldHomeUsingCorba = (HelloWorldHome) PortableRemoteObject.narrow(foundUsingCorba,
					HelloWorldHome.class);
			HelloWorldHome helloWorldHomeUsingRef = (HelloWorldHome) PortableRemoteObject.narrow(foundUsingRef,
					HelloWorldHome.class);

			System.out.println(helloWorldHomeUsingGlobal.create().helloWorld("Access EJB using java:global"));
			System.out.println(helloWorldHomeUsingApp.create().helloWorld("Access EJB using java:app"));
			System.out.println(helloWorldHomeUsingCorba.create().helloWorld("Access EJB using corbaname:"));
			System.out.println(helloWorldHomeUsingRef.create().helloWorld("Access EJB using java:comp/env"));
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (CreateException e) {
			e.printStackTrace();
		}
	}
}