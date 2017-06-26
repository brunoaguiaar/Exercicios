package br.com.crescer.aula5;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author bruno.aguiar
 */
//@WebServlet(name = "cliente", urlPatterns = {"/cliente"})
public class ClienteServlet extends HttpServlet{
    
    //private List<String> nomes = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException{
        resp.setContentType("text/html");
        try(final PrintWriter out = resp.getWriter();){
            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<title>Java - aula5</title>");
            out.append("<meta charset=\"UTF-8\">");
            out.append("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
            out.append("</head>");
            out.append("<body>");
            out.append("<h1>Clientes</h1>");
            out.append("</body>");
            out.append("<form action=\"/aula5/cliente\" method=\"POST\">"
                    + "<label>Nome: </label>"
                    //+ "<input tipe=\"text\", placeholder=\"Bruno\", autofocus></input>"
                    + "<input tipe=\"submit\">Enviar</input>"
                    + "</form>");
            out.append("</html>");
        }
    }
}
