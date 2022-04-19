package objetos;

public class Armas {

	private double damage;
	private int durability;
	
	public Armas(double damage, int durability) {
		
		this.damage = damage;
		this.durability = durability;
		
	}

	public double getDamage() {
		return damage;
	}

	public void setDamage(double damage) {
		this.damage = damage;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}
	
	@Override
	public String toString() {
		
		return  "Daño: " + this.damage + " Durabilidad: " + this.durability;
		
	}
	
	
	
}
