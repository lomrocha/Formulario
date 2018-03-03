

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProcessarFormulario
 */
@WebServlet("/processar")
public class ProcessarFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessarFormulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Recuperar os parâmetros
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		
		String[] dataNascimento = request.getParameter("data").split("-");		
		String[] dataAtual = LocalDate.now().toString().split("-");
		
		CalcularIdade c = new CalcularIdade(dataNascimento, dataAtual);
		
		// Concatenar as strings
		String nomeCompleto = nome + " " + sobrenome;
		
		// Preparar a resposta ao usuário
		PrintWriter out = response.getWriter();
		out.println("<html>"
				+ 		"<head>"
				+ 			"<title>Resposta</title>"
				+ 		"</head>"
				+		"<body>"
				+			"<p><h1>Seu nome completo é: " + nomeCompleto + "</h1></p>"
				+			"<p><h1>Sua idade é: " + c.getIdade() + "</h1></p>"
				+		"</body>"	
				+ 	"</html>");
	}
}
