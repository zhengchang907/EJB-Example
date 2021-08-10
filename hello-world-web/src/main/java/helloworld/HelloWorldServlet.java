package helloworld;

import java.io.IOException;

import javax.ejb.CreateException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
    name = "HelloWorldServlet",
    urlPatterns = {"/HelloWorldServlet"})
public class HelloWorldServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    try {
      InitialContext context = new InitialContext();

      Object foundUsingGlobal =
          context.lookup(
              "java:global/hello-world/hello-world-ejb/HelloWorld!helloworld.HelloWorldHome");
      Object foundUsingApp =
          context.lookup("java:app/hello-world-ejb/HelloWorld!helloworld.HelloWorldHome");
      Object foundUsingWebSphere =
          context.lookup(
              "ejb/hello-world/hello-world-ejb.jar/HelloWorld#helloworld.HelloWorldHome");

      HelloWorldHome helloWorldHomeUsingGlobal =
          (HelloWorldHome) PortableRemoteObject.narrow(foundUsingGlobal, HelloWorldHome.class);
      HelloWorldHome helloWorldHomeUsingApp =
          (HelloWorldHome) PortableRemoteObject.narrow(foundUsingApp, HelloWorldHome.class);
      HelloWorldHome helloWorldHomeUsingWebSphere =
          (HelloWorldHome) PortableRemoteObject.narrow(foundUsingWebSphere, HelloWorldHome.class);

      helloWorldHomeUsingGlobal.create().helloWorld("Reza");
      helloWorldHomeUsingApp.create().helloWorld("Zheng");
      helloWorldHomeUsingWebSphere.create().helloWorld("Ed");
    } catch (NamingException e) {
      e.printStackTrace();
    } catch (CreateException e) {
      e.printStackTrace();
    }
  }
}
