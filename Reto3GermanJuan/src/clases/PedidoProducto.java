package clases;

/**
 * @author german y juan
 */
public class PedidoProducto implements Comparable<PedidoProducto> {

	private int idpedidoproducto;
	private Pedidos idpedido;
	private Productos idproducto;
	private int unidades;
	private double precio;

	/**
	 * 
	 * @return int
	 */
	public int getIdpedidoproducto() {
		return idpedidoproducto;
	}

	/**
	 * 
	 * @param idpedidoproducto int
	 */

	public void setIdpedidoproducto(int idpedidoproducto) {
		this.idpedidoproducto = idpedidoproducto;
	}

	/**
	 * 
	 * @return int
	 */
	public Pedidos getIdpedido() {
		return idpedido;
	}

	/**
	 * 
	 * @param idpedido Pedido
	 */
	public void setIdpedido(Pedidos idpedido) {
		this.idpedido = idpedido;
	}

	/**
	 * 
	 * @return Pedido
	 */

	public Productos getIdproducto() {
		return idproducto;
	}

	/**
	 * 
	 * @param idproducto Productos
	 */

	public void setIdproducto(Productos idproducto) {
		this.idproducto = idproducto;
	}

	/**
	 * 
	 * @return int
	 */
	public int getUnidades() {
		return unidades;
	}

	/**
	 * 
	 * @param unidades int
	 */
	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	/**
	 * 
	 * @return double
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * 
	 * @param precio double
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * 
	 * @param idpedidoproducto int
	 * @param idpedido         Pedidos
	 * @param idproducto       Productos
	 * @param unidades         int
	 * @param precio           double
	 */
	public PedidoProducto(int idpedidoproducto, Pedidos idpedido, Productos idproducto, int unidades, double precio) {
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

	@Override
	public int compareTo(PedidoProducto o) {
		return o.getUnidades() - unidades;
	}

}
