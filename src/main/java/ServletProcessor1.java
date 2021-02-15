import com.sun.xml.internal.messaging.saaj.soap.impl.TreeException;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

public class ServletProcessor1 {
    public void process (Request request, Response response) {
        String uri = request.getUri();
        String servletName = uri.substring(uri.lastIndexOf("/") + 1);
        URLClassLoader loader = null;
        try {
            //
            URL[] urls = new URL[1];
            URLStreamHandler streamHandler = null;
            File classPath = new File(Constants.WEB_ROOT);


            String repository = (new URL("file", null, classPath.getCanonicalPath() + File.separator)).toString() ;

            urls[0] = new URL(null, repository, streamHandler);
            loader = new URLClassLoader(urls) ;
        }
        catch (IOException e) {
            System.out.println(e.toString());
        }

        Class myclass = null;
        try {
            myclass = loader.loadClass(servletName);
        }catch (ClassNotFoundException a) {
            System.out.println(a.toString());
        }

        Servlet servlet = null;

        try {
            servlet = (Servlet) myclass.newInstance();
            RequestFacade requestFacade = new RequestFacade(request);
            ResponseFacade responseFacade = new ResponseFacade(response);

            servlet.service((ServletRequest) requestFacade, (ServletResponse) responseFacade);
        }catch (Exception e) {
            System.out.println(e.toString());
        }
        catch (Throwable e) {
            System.out.println(e.toString());
        }
    }
}
