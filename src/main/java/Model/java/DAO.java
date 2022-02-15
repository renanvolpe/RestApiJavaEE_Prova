package Model.java;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DAO {
		//variaveis de conexao
	
		private String drive ="com.mysql.cj.jdbc.Driver";
		private String url = "jdbc:mysql://127.0.0.1:3308/provakiver?useTimezonetrue&serverTimezone=UTC";
		//private String url = "jdbc:mysql://127.0.0.1:3308/provakiver";
		private String user = "root";
		private String password = "root";
		
		
		//conexao do banco
		private Connection contectar() {
			Connection conect = null;
			try {
				Class.forName(drive);
				conect = DriverManager.getConnection(url, user, password);
				return conect;
			}catch(Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		
		public void testeConct() {
			try {
				Connection con = contectar();
				System.out.println(con);
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void iniciarBanco(banquinho bancoInicial) {
			String criarBanco = "insert into caixa(idCaixa, descricao, saldoInicial ) values "
					+ "(?, ? , ?)";
			
			try {
				Connection conect = contectar();
				
				PreparedStatement pst = conect.prepareStatement(criarBanco);
			pst.setInt(1, 1);
			pst.setInt(2, bancoInicial.getIdCaixa());
			pst.setDouble(3, (bancoInicial.getSaldoInicial()));
		
			pst.executeUpdate();
			
			conect.close();
			
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public void inserirMovimentacao(JavaBeans beans, String movimentacao) {
			String criarBanco = "insert into movimentacao( descricao, valor, tipo, data, CaixaId) values "
					+ "(? , ? , ? , ? , ?)";
			
			try {
				Connection conect = contectar();
				
				PreparedStatement pst = conect.prepareStatement(criarBanco);
			pst.setString(1, beans.getDescricao());
			pst.setDouble(2, Double.parseDouble(beans.getValor()));
			
			if(movimentacao == "Entrada")
				pst.setString(3, "Entrada");
			else if(movimentacao == "Saida")
				pst.setString(3, "Saida");
			
			
			
			Date date = new Date();
			
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			
			
			
			
			pst.setString(4, formatter.format(date));
			pst.setInt(5, 1);
			
			pst.executeUpdate();
			
			conect.close();
			
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		
		public ArrayList<JavaBeans> listarMovimentacoes(){
			
			ArrayList<JavaBeans> movimentacoes = new ArrayList<>();
			
			String leitura = "select * from movimentacao";
			
			try {
				Connection conect = contectar();
				
				PreparedStatement pst = conect.prepareStatement(leitura);
				
				//retorno do banco de dados
				ResultSet resultadoLeitura = pst.executeQuery();
				
				while (resultadoLeitura.next()) {
					
					String descricao = resultadoLeitura.getString(1);
					double valorDouble = resultadoLeitura.getDouble(2);
					String valor = valorDouble+"";
					String tipo = resultadoLeitura.getString(3);
					String Data = resultadoLeitura.getString(4);
					
					
					
					
					movimentacoes.add(new JavaBeans( tipo,  valor,  Data,  descricao));
					
				}
				
				conect.close();
				
				
				return movimentacoes;
				
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
		}
		
		
		
		
		
}
