package Model.java;

public class banquinho {
	public banquinho(int idCaixa, double saldoInicial) {
		super();
		this.idCaixa = idCaixa;
		this.saldoInicial = saldoInicial;
	}
	public banquinho() {
			super();
			// TODO Auto-generated constructor stub
		}
		private int idCaixa;
	private double saldoInicial;

	public int getIdCaixa() {
		return idCaixa;
	}

	public void setIdCaixa(int idCaixa) {
		this.idCaixa = idCaixa;
	}

	public double getSaldoInicial() {
		return saldoInicial;
	}

	public void setSaldoInicial(double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}

	
}
