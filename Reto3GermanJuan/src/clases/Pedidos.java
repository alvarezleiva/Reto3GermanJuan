package clases;

import java.sql.Date;

/**
 * @author german y juan
 */

public class Pedidos {
	private int idPedido;
	private Clientes idCliente;
	private double precioTotal;
	private String direccionEnvio;
	private Date fecha;

	/**
	 * 
	 * @param precioTotal    double
	 * @param direccionEnvio String
	 * @param fecha          Date
	 */

	public Pedidos(double precioTotal, String direccionEnvio, Date fecha) {
		this.precioTotal = precioTotal;
		this.direccionEnvio = direccionEnvio;
		this.fecha = fecha;
	}

	/**
	 * 
	 * @param direccionEnvio String
	 * @param fecha          Date
	 */

	public Pedidos(String direccionEnvio, Date fecha) {
		this.direccionEnvio = direccionEnvio;
		this.fecha = fecha;
	}

	/**
	 * 
	 * @return int
	 */

	public int getIdPedido() {
		return idPedido;
	}

	/**
	 * 
	 * @param idPedido int
	 */

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	/**
	 * 
	 * @return Clientes
	 */

	public Clientes getIdCliente() {
		return idCliente;
	}

	/**
	 * 
	 * @param idCliente Clientes
	 */
	public void setIdCliente(Clientes idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * 
	 * @return double
	 */

	public double getPrecioTotal() {
		return precioTotal;
	}

	/**
	 * 
	 * @param precioTotal double
	 */
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	/**
	 * 
	 * @return String
	 */

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	/**
	 * 
	 * @param direccionEnvio String
	 */

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	/**
	 * 
	 * @return Date
	 */

	public Date getFecha() {
		return fecha;
	}

	/**
	 * 
	 * @param fecha Date
	 */

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * 
	 * @param idPedido int
	 */

	public Pedidos(int idPedido) {
		super();
		this.idPedido = idPedido;
	}

	/**
	 * Constructor
	 * 
	 * @param idPedido       int
	 * @param idCliente      Clientes
	 * @param precioTotal    double
	 * @param direccionEnvio String
	 * @param fecha          Date
	 */

	public Pedidos(int idPedido, Clientes idCliente, double precioTotal, String direccionEnvio, Date fecha) {
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.precioTotal = precioTotal;
		this.direccionEnvio = direccionEnvio;
		this.fecha = fecha;
	}

	/**
	 * Constructor vacio
	 */

	public Pedidos() {
	}

	@Override
	public String toString() {
		return "pedidos [idPedido=" + idPedido + ", idCliente=" + idCliente + ", precioTotal=" + precioTotal
				+ ", direccionEnvio=" + direccionEnvio + ", fecha=" + fecha + "]";
	}

}
