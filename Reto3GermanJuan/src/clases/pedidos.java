package clases;

import java.sql.Date;

public class pedidos {
	private int idPedido;
	private clientes idCliente;
	private double precioTotal;
	private String direccionEnvio;
	private Date fecha;

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public clientes getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(clientes idCliente) {
		this.idCliente = idCliente;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}

	public String getDireccionEnvio() {
		return direccionEnvio;
	}

	public void setDireccionEnvio(String direccionEnvio) {
		this.direccionEnvio = direccionEnvio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public pedidos(int idPedido, clientes idCliente, double precioTotal, String direccionEnvio, Date fecha) {
		this.idPedido = idPedido;
		this.idCliente = idCliente;
		this.precioTotal = precioTotal;
		this.direccionEnvio = direccionEnvio;
		this.fecha = fecha;
	}

	public pedidos() {
	}

	@Override
	public String toString() {
		return "pedidos [idPedido=" + idPedido + ", idCliente=" + idCliente + ", precioTotal=" + precioTotal
				+ ", direccionEnvio=" + direccionEnvio + ", fecha=" + fecha + "]";
	}
	
	

}
