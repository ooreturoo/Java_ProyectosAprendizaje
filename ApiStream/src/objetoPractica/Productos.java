package objetoPractica;

import java.util.Objects;

public class Productos {
	private static int cantidadProductos;
	private int id;
	private String nombreProducto;
	private double precio;
	
	public Productos(String nombreProducto, double precio) {
		cantidadProductos++;
		this.id = cantidadProductos;
		this.nombreProducto = nombreProducto;
		this.precio = precio;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getNombreProducto() {
		return this.nombreProducto;
	}
	
	public double getPrecio() {
		return this.precio;
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombreProducto=" + nombreProducto + ", precio=" + precio + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nombreProducto, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Productos other = (Productos) obj;
		return id == other.id && Objects.equals(nombreProducto, other.nombreProducto)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio);
	}
	
	
	
}
