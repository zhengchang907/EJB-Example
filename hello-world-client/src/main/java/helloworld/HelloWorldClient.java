package helloworld;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class HelloWorldClient {

	public static void main(String[] args) throws NamingException, RemoteException, CreateException {
		System.out.println("invoking remote EJB from client");
		
		InitialContext context = new InitialContext();
		System.out.println("invoked 1 remote EJB from client");
		
		//corbaname:rir:#ejb/global/hello-world/hello-world-ejb/HelloWorld!helloworld.HelloWorldHome
		//corbaname::localhost:2809#ejb/global/hello-world/hello-world-ejb/HelloWorld!helloworld.HelloWorldHome
		Object found = context.lookup("corbaname::localhost:2809#ejb/global/hello-world/hello-world-ejb/HelloWorld!helloworld.HelloWorldHome");

		System.out.println("invoked 2 remote EJB from client");
		HelloWorldHome helloWorldHome = (HelloWorldHome)PortableRemoteObject.narrow(found, HelloWorldHome.class);

		System.out.println("invoked 3 remote EJB from client");
		helloWorldHome.create().helloWorld(args[0]);
		System.out.println("invoked 4 remote EJB from client");
	}

}
