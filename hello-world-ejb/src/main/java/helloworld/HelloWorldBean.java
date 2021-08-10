package helloworld;

import java.rmi.RemoteException;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class HelloWorldBean implements SessionBean {

  private static final long serialVersionUID = 1L;

  public void helloWorld(String name) {
    System.out.println("Hello world, " + name);
  }

  public void setSessionContext(SessionContext ctx) throws EJBException, RemoteException {
    // TODO Auto-generated method stub
  }

  public void ejbRemove() throws EJBException, RemoteException {
    // TODO Auto-generated method stub
  }

  public void ejbActivate() throws EJBException, RemoteException {
    // TODO Auto-generated method stub
  }

  public void ejbPassivate() throws EJBException, RemoteException {
    // TODO Auto-generated method stub
  }
}