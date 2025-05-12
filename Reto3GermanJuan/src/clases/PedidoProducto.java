package clases;

public class PedidoProducto {
	
		private int idpedidoproducto;
		private Pedidos idpedido;
		private Productos idproducto;
		private int unidades;
		private double precio;
		public int getIdpedidoproducto() {
			return idpedidoproducto;
		}
		public void setIdpedidoproducto(int idpedidoproducto) {
			this.idpedidoproducto = idpedidoproducto;
		}
		public Pedidos getIdpedido() {
			return idpedido;
		}
		public void setIdpedido(Pedidos idpedido) {
			this.idpedido = idpedido;
		}
		public Productos getIdproducto() {
			return idproducto;
		}
		public void setIdproducto(Productos idproducto) {
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
		public PedidoProducto(int idpedidoproducto, Pedidos idpedido, Productos idproducto, int unidades,
				double precio) {
			this.idpedidoproducto = idpedidoproducto;
			this.idpedido = idpedido;
			this.idproducto = idproducto;
			this.unidades = unidades;
			this.precio = precio;
		}
		public PedidoProducto() {
		}
		@Override
		public String toString() {
			return "pedidoproducto [idpedidoproducto=" + idpedidoproducto + ", idpedido=" + idpedido + ", idproducto="
					+ idproducto + ", unidades=" + unidades + ", precio=" + precio + "]";
		}
		
		
	
}
