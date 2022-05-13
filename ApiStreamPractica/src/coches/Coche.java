package coches;

public class Coche implements Comparable<Coche> {

	private Marca marca;
	private String matricula;
	private int anios;
	private Combustible combustible;
	
	
	public Coche(Marca marca, String matricula, int anios, Combustible combustible) {
		super();
		this.marca = marca;
		this.matricula = matricula;
		this.anios = anios;
		this.combustible = combustible;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public String getMatricula() {
		return matricula;
	}


	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public int getAnios() {
		return anios;
	}


	public void setAnios(int anios) {
		this.anios = anios;
	}


	public Combustible getCombustible() {
		return combustible;
	}


	public void setCombustible(Combustible combustible) {
		this.combustible = combustible;
	}


	@Override
	public String toString() {
		return "Coche [marca=" + marca + ", matricula=" + matricula + ", anios=" + anios + ", combustible="
				+ combustible + "]";
	}


	@Override
	public int compareTo(Coche o) {
		
		return this.anios - o.anios;
		
	}
	
	
	
}
