package clases;


public class Clientes {
	private int idCliente;
	private String nombre;
	private String direccion;
	private int codigo;

	/**
	 * 
	 * @return int
	 */
	public int getIdCliente() {
		return idCliente;
	}

	/**
	 * 
	 * @param idCliente int
	 */
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	/**
	 * 
	 * @return string
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * 
	 * @param codigo int
	 */
	
	
	public Clientes(int codigo) {
		this.codigo = codigo;
	}
	/**
	 * 
	 * @param nombre string
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return string
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * 
	 * @param direccion string
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * 
	 * @return string
	 */

	public int getCodigo() {
		return codigo;
	}
	/**
	 * 
	 * @param codigo int
	 */

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	/**
	 * Constructor
	 * @param nombre string
	 * @param direccion string
	 * @param codigo int
	 */
	public Clientes(String nombre, String direccion, int codigo) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigo = codigo;
	}
	
	/**
	 * Constructor
	 * @param idCliente int
	 * @param nombre string
	 * @param direccion string
	 * @param codigo int
	 */

	public Clientes(int idCliente, String nombre, String direccion, int codigo) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigo = codigo;
	}

	/**
	 * Constructor vacio
	 */
	public Clientes() {
	}

	@Override
	public String toString() {
		return "clientes [idCliente=" + idCliente + ", nombre=" + nombre + ", direccion=" + direccion + ", codigo="
				+ codigo + "]";
	}

}
