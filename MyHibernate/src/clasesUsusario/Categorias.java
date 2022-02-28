package clasesUsusario;

import anotaciones.*;

@Table(name="Categorias")
public class Categorias {
	
	@Id
	@Column(name="id_categoria")
	private Integer idCategoria;
	
	@Column(name="nombre_categoria" )
	private String nombreCategoria;

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}
	
	public Categorias() {	
	}
	
	public Categorias(Integer id) {
		this.idCategoria = id;
	}
	
}
