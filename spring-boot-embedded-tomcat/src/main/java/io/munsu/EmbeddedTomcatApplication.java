package io.munsu;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Munsu Seo on 2020/05/27
 */
public class EmbeddedTomcatApplication {

  public static void main(String[] args) throws LifecycleException {
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(8080);

    Context context = tomcat.addContext("/", "/");

    HttpServlet servlet = new HttpServlet() {
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>Hello Tomcat</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println("<h1>Hello Tomcat 1</h1>");
        writer.println("<h2>Hello Tomcat 2</h2>");
        writer.println("<h3>Hello Tomcat 3</h3>");
        writer.println("</body>");
        writer.println("</html>");
      }
    };

    String servletName = "helloABC";
    tomcat.addServlet("/", servletName, servlet);
    context.addServletMappingDecoded("/hello", servletName);

    tomcat.start();
    tomcat.getServer().await();
  }
}
