package FilterServlet;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import java.io.IOException;

public class IpFilter implements Filter {

//  File with forbidden IP
    public String fileOfForbiddenIp = "D:\\ForbiddenIP.txt";

    private FilterConfig filterConfig;
    public void init(FilterConfig config) {
        filterConfig = config;
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain filterchain) {
        IpFileReader ipFileReader = new IpFileReader();
        ArrayList<String> ipList = ipFileReader.getIp(fileOfForbiddenIp);
        response.setContentType("text/html");
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println("<html><head><title>IP Filter Example</title></head>");
        String userIp = request.getRemoteAddr();

        for (String ip : ipList) {

            if (ip.equals(userIp)) {
                String accessForbidden = "AccessDenied.jsp";
                RequestDispatcher requestDispatcher = request.getRequestDispatcher(accessForbidden);
                try {
                    requestDispatcher.forward(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String destination = "index.jsp";
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void destroy() {
        this.filterConfig = null;
    }
}

