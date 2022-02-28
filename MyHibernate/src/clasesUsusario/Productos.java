package clasesUsusario;


import anotaciones.*;

@Table(name="Productos")
public class Productos{
	
	@Id
	@Column(name="id_producto")
	private Integer idProducto;
	
	@Column(name="nombre_producto")
	private String nombreProducto;
	
	@Column(name="precio")
	private Integer precio;
	
	@ManyToOne
	@Column(name="id_categoria")
	private Categorias categoria;
	
	public Productos() {
	}
	
	public Productos(Integer id, String nombreProducto, Integer precio, Categorias categoria) {
		this.idProducto = id;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
		this.categoria = categoria;
	}
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer id) {
		this.idProducto = id;
	}
	
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombre) {
		this.nombreProducto = nombre;
	}
	
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Categorias getCategoria() {
		return categoria;
	}

	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	
}
