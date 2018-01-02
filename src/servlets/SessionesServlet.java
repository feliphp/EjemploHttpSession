package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionesServlet
 */
@WebServlet(name = "/SessionesServlet", urlPatterns= {"/SessionesServlet"})
public class SessionesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession sesion = request.getSession();
		String titulo = null;
		Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
		
		if (contadorVisitas == null) {
            contadorVisitas = new Integer(1);
            titulo = "Bienvenido por primera vez...";
        } else {
            //si es distinto de nulo, incrementamos el contador
            titulo = "Bienvenido Nuevamente...";
            contadorVisitas += 1;
        }
		
		sesion.setAttribute("contadorVisitas", contadorVisitas);

        //Mostramos los  valores en el cliente
        PrintWriter out = response.getWriter();
        out.println("T&iacute;tulo: " + titulo);
        out.println("<br>");
        out.println("No. Accesos al recurso: " + contadorVisitas);
        out.println("<br>");
        out.println("ID de la sesi&oacute;n: " + sesion.getId());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
