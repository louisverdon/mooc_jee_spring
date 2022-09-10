package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = { "/bag" })
public class BagServlet extends HttpServlet {
	
	Bag myBag = new Bag();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
        res.setContentType("text/html");
		out.println("<html><body>");
		out.println("<h1> Le Sac magique </h1>");
        out.println("<form action='bag' method=post>");
        out.println("Reference : <input name='ref'> <br>");
        out.println("Quantité : <input name='qty'> <br>");
        out.println("<input type=submit value='Envoi'>");
        out.println("</form>");
        out.println("</body></html>");
	}

	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
	throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		
		String ref = req.getParameter("ref");
        String qty = req.getParameter("qty");
		
        if (ref == null || ref.isEmpty() || qty == null || qty.isEmpty()) {
            res.sendError(400, "Params missing");
        }

        try {
            Integer.parseInt(qty);
        } catch (NumberFormatException e) {
            res.sendError(400, "La quantité renseignée n'est pas un nombre");
        }

        res.setContentType("text/html");
        out.println("<html><body>");
        out.println("<span> Référence : " + ref +"</span><br>");
        out.println("<span> Quantité : " + qty + "</span><br>");
        out.println("</body></html>");
	}
	
	
	

}
