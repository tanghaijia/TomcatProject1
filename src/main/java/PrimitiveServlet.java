import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class PrimitiveServlet implements Servlet {


    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init");
    }

    public ServletConfig getServletConfig() {
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("from service");
        PrintWriter out  = servletResponse.getWriter();
        out.println("Holle, Roses are red.");
        out.print("Violets are biue.");
    }

    public String getServletInfo() {
        return null;
    }

    public void destroy() {
        System.out.println("销毁");
    }
}
