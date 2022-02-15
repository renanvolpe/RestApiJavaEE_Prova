package Controller.java;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.java.DAO;
import Model.java.JavaBeans;
import Model.java.banquinho;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main", "/inserir", "/resgatar", "/iniciarBanco"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	
	JavaBeans beans = new JavaBeans();
	banquinho bancoInicial = new banquinho();
	
	public Controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// dao.testeConct();

		String action = request.getServletPath();
		System.out.println(action);
		if(action.equals("/iniciarBanco")) {
			iniciarBanco(request, response);
		}else
		if (action.equals("/main")) {
			
			listaContatos(request, response);
			System.out.println(action);
			transacoes(request, response);
		} else if (action.equals("/inserir")) {
			System.out.println(action);
			transadaoDepositar(request, response);
		} else if (action.equals("/resgatar")) {
			System.out.println(action);
			transadaoSacar(request, response);
		}
		else {
			System.out.println("nao foi encontrado nenhum comando");
		}

	}
	
	protected void iniciarBanco(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("saldoInicial"));
		
		bancoInicial.setSaldoInicial(Double.parseDouble(request.getParameter("saldoInicial")));
		dao.iniciarBanco(bancoInicial);
		response.sendRedirect("main");
	
	}
	

	protected void transacoes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("banco.jsp");

	}
	
	protected void transadaoDepositar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//pega pelo name de cada input de novo,.html
		//System.out.println(request.getParameter("quantidade"));
					
		
		beans.setValor(request.getParameter("quantidade"));
		
		dao.inserirMovimentacao(beans, "Entrada");
		
		
		response.sendRedirect("main");
	}
	
	protected void transadaoSacar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//pega pelo name de cada input de novo,.html
		//System.out.println(request.getParameter("quantidade"));
					
		
		beans.setValor(request.getParameter("quantidade"));
		
		dao.inserirMovimentacao(beans, "Saida");
		
		
		response.sendRedirect("main");
	}

	
	protected void listaContatos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	ArrayList<JavaBeans> listaMov = dao.listarMovimentacoes();
	
	
	request.setAttribute("movimentacao", listaMov);
	
	RequestDispatcher requisicao = request.getRequestDispatcher("banco.jsp");
	requisicao.forward(request, response);
	
	
	
	
	
			for(int i = 0; i<listaMov.size(); i++) 
				System.out.println(listaMov.get(i).getValor());
	
	}
	
	
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub doGet(request, response); }
	 */

}
