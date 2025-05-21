package clases;

public class Categorias {

	private int idCategoria;
	private String nombre;

	/**
	 * 
	 * @return int
	 */

	public int getIdCategoria() {
		return idCategoria;
	}

	/**
	 * 
	 * @param idCategoria int
	 */

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
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
	 * @param nombre string
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Constructor
	 * 
	 * @param idCategoria int
	 * @param nombre      string
	 */

	public Categorias(int idCategoria, String nombre) {
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}

	public Categorias() {
	}

	@Override
	public String toString() {
		return "categorias [idCategoria=" + idCategoria + ", nombre=" + nombre + "]";
	}
	/**
	 * 
	 * @param nombre string
	 */

	public Categorias(String nombre) {
		this.nombre = nombre;
	}

}
