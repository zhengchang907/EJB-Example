package helloworld;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

public class HelloWorldClient {

  public static void main(String[] args) throws NamingException, RemoteException, CreateException {

    InitialContext context = new InitialContext();

    Object found =
        context.lookup(
            "corbaname::localhost:2809#ejb/global/hello-world/hello-world-ejb/HelloWorld!helloworld%5c.HelloWorldHome");
    
    HelloWorldHome helloWorldHome =
        (HelloWorldHome) PortableRemoteObject.narrow(found, HelloWorldHome.class);

    helloWorldHome.create().helloWorld(args[0]);
  }
}
