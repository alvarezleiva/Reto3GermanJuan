
package clases;

/**
 * @author german y juan
 */
public class Productos {
	private int idproducto;
	private Categorias idcategoria;
	private String nombre;
	private double precio;
	private String descripcion;
	private String color;
	private String talla;
	private int stock;
	
	/**
	 * Constructor
	 * @param idproducto int
	 * @param idcategoria Categorias
	 * @param nombre String
	 * @param precio double
	 * @param descripcion String
	 * @param color String
	 * @param talla String
	 * @param stock int
	 */

	public Productos(int idproducto, Categorias idcategoria, String nombre, double precio, String descripcion,
			String color, String talla, int stock) {
		this.idproducto = idproducto;
		this.idcategoria = idcategoria;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.color = color;
		this.talla = talla;
		this.stock = stock;
	}
	
	/**
	 * 
	 * @param idproducto int
	 */

	public Productos(int idproducto) {
		super();
		this.idproducto = idproducto;
	}

	/**
	 * Constructor
	 * @param idcategoria Categorias
	 * @param nombre String
	 * @param precio double
	 * @param descripcion String
	 * @param color String
	 * @param talla String
	 * @param stock int
	 */
	public Productos(Categorias idcategoria, String nombre, double precio, String descripcion, String color,
			String talla, int stock) {
		this.idcategoria = idcategoria;
		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.color = color;
		this.talla = talla;
		this.stock = stock;
	}

	/**
	 * Constructor
	 * @param nombre String
	 * @param precio double
	 * @param descripcion String
	 * @param color String
	 * @param talla String
	 * @param stock int
	 */
	public Productos(String nombre, double precio, String descripcion, String color, String talla, int stock) {

		this.nombre = nombre;
		this.precio = precio;
		this.descripcion = descripcion;
		this.color = color;
		this.talla = talla;
		this.stock = stock;
	}

	/**
	 * Constructor Vacio
	 */
	public Productos() {
	}
	
	/**
	 * 
	 * @return int
	 */

	public int getIdproducto() {
		return idproducto;
	}
	
	/**
	 * 
	 * @param idproducto int
	 */

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	
	/**
	 * 
	 * @return Categorias
	 */

	public Categorias getIdcategoria() {
		return idcategoria;
	}
	/**
	 * 
	 * @param idcategoria Categorias
	 */

	public void setIdcategoria(Categorias idcategoria) {
		this.idcategoria = idcategoria;
	}
	/**
	 * 
	 * @return String
	 */

	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @param nombre String
	 */

	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * @return String
	 */

	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * 
	 * @param descripcion String
	 */

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	/**
	 * 
	 * @return String
	 */

	public String getColor() {
		return color;
	}

	/**
	 * 
	 * @param color String
	 */
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	 * 
	 * @return String
	 */

	public String getTalla() {
		return talla;
	}
	
	/**
	 * 
	 * @param talla String
	 */

	public void setTalla(String talla) {
		this.talla = talla;
	}
	
	/**
	 * 
	 * @return int
	 */

	public int getStock() {
		return stock;
	}
	/**
	 * 
	 * @param stock int
	 */

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Categoria: " + idcategoria.getNombre() + ", producto: " + nombre + ", precio: " + precio
				+ ", descripcion: " + descripcion + ", color: " + color + ", talla: " + talla + ", stock: " + stock;
	}

}
