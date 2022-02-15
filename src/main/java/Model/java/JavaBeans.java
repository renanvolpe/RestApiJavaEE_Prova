package Model.java;

public class JavaBeans {
		private String tipo; // entrada ou saida
		private String valor; 
		private String data; // xx/xx/xx
		private String descricao;
		//private int idCaixa;
		public String getTipo() {
			return tipo;
		}
		public void setTipo(String tipo) {
			this.tipo = tipo;
		}
		public String getValor() {
			return valor;
		}
		public void setValor(String valor) {
			this.valor = valor;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public JavaBeans() {
			super();
			// TODO Auto-generated constructor stub
		}
		public JavaBeans(String tipo, String valor, String data, String descricao) {
			super();
			this.tipo = tipo;
			this.valor = valor;
			this.data = data;
			this.descricao = descricao;
		}
		
		
		
		
}


