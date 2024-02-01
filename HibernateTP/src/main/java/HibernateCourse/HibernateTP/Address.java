package HibernateCourse.HibernateTP;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;

@Entity
public class Address {
	
	@Id
	@GeneratedValue
	private int id;
	private String rue;
	private int numero;
	private String ville;
	
    @OneToOne(mappedBy = "adress") // Fait référence à l'attribut dans Etudiant
	private Etudiant etudiant;
	
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	
	public void setEtudiant(Etudiant et) {
		this.etudiant=et;
	}
	
	public Etudiant getEtudiant() {
		return etudiant;
	}

	@Override
	public String toString() {
		return "L'insertion avec succee d'Address [rue=" + rue + ", numero=" + numero + ", ville=" + ville + "]";
	}

}
