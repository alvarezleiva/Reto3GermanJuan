package clases;

public class clientes {
	private int idCliente;
	private String nombre;
	private String direccion;
	private int codigo;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public clientes(int idCliente, String nombre, String direccion, int codigo) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigo = codigo;
	}
	public clientes() {
	}
	@Override
	public String toString() {
		return "clientes [idCliente=" + idCliente + ", nombre=" + nombre + ", direccion=" + direccion + ", codigo="
				+ codigo + "]";
	}
	
	
}
