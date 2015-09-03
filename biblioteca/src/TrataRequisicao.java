import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TrataRequisicao
 */
@WebServlet("/TrataRequisicao")
public class TrataRequisicao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TrataRequisicao() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		Connection conexao = null;

		//Statement DeclaracaoSQL;  feito pelo Cristiano no dia 02/09/2015
		//Esse é melhor para evitar SQL Injection
		PreparedStatement DeclaracaoSQL;

		String url = "jdbc:mysql://127.0.0.1:3306/dbbiblioteca";
		String username = "root";
		String password = "";

		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conexao = DriverManager.getConnection(url, username, password);
			System.out.println("Conexão realizada com sucesso!");

			String sql = "INSERT INTO tbllivros VALUES (?,?,?,?)";
						
			//DeclaracaoSQL = conexao.createStatement();
			DeclaracaoSQL = conexao.prepareStatement( sql );
			
			DeclaracaoSQL.setString(1, request.getParameter("nmisbn") );
			DeclaracaoSQL.setString(2, request.getParameter("nmtitulo") );
			DeclaracaoSQL.setString(3, request.getParameter("nmautor") );
			DeclaracaoSQL.setString(4, request.getParameter("nmeditora") );
			
			/*
			String sql = "INSERT INTO tbllivros "
					+ "VALUES ('" + request.getParameter("nmisbn") + "',"
					+ "'" + request.getParameter("nmtitulo") + "',"
					+ "'" + request.getParameter("nmautor") + "',"
					+ "'" + request.getParameter("nmeditora") + "');";
			*/
			
			System.out.println(sql);
			
			boolean retorno = DeclaracaoSQL.execute();
			

		} catch (Exception e) {
			System.out.println("Falha na conexão: " + e.getMessage());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}







