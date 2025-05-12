package clases;

public class pedidoproducto {
	
		private int idpedidoproducto;
		private pedidos idpedido;
		private productos idproducto;
		private int unidades;
		private double precio;
		public int getIdpedidoproducto() {
			return idpedidoproducto;
		}
		public void setIdpedidoproducto(int idpedidoproducto) {
			this.idpedidoproducto = idpedidoproducto;
		}
		public pedidos getIdpedido() {
			return idpedido;
		}
		public void setIdpedido(pedidos idpedido) {
			this.idpedido = idpedido;
		}
		public productos getIdproducto() {
			return idproducto;
		}
		public void setIdproducto(productos idproducto) {
			this.idproducto = idproducto;
		}
		public int getUnidades() {
			return unidades;
		}
		public void setUnidades(int unidades) {
			this.unidades = unidades;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public pedidoproducto(int idpedidoproducto, pedidos idpedido, productos idproducto, int unidades,
				double precio) {
			this.idpedidoproducto = idpedidoproducto;
			this.idpedido = idpedido;
			this.idproducto = idproducto;
			this.unidades = unidades;
			this.precio = precio;
		}
		public pedidoproducto() {
		}
		@Override
		public String toString() {
			return "pedidoproducto [idpedidoproducto=" + idpedidoproducto + ", idpedido=" + idpedido + ", idproducto="
					+ idproducto + ", unidades=" + unidades + ", precio=" + precio + "]";
		}
		
		
	
}
