package HibernateCourse.HibernateTP;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.ManyToAny;

@Entity
public class Etudiant extends Personne {

	private String cne;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id") 
	private Address adress;
	@ManyToOne(cascade = CascadeType.ALL)
	private Classe classe;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
	    name = "etudiant_cours", 
	    joinColumns = @JoinColumn(name = "etudiant_id"), 
	    inverseJoinColumns = @JoinColumn(name = "cours_id") 
	)
	private List<Cours> cours;
	
	public void setCours(List<Cours> c) {
		this.cours=c;
	}


	public void SetClass(Classe c) {
		this.classe = c;
	}

	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public Address getAdress() {
		return adress;
	}

	public void setAdress(Address adress) {
		this.adress = adress;
	}

//	    @ManyToOne
//	    @JoinColumn(name = "class_id")
//	    private Classe classe;
//		 public void setCours(List<Cours> cours) {
//		        this.cours = cours;
//		    }
//		  @ManyToMany(cascade = CascadeType.ALL)
//		    @JoinTable(
//		        name = "etudiant_cours",
//		        joinColumns = @JoinColumn(name = "etudiant_id"),
//		        inverseJoinColumns = @JoinColumn(name = "cours_id")
//		    )
//		  
//		  private List<Cours> cours = new ArrayList<>();
//		    public List<Cours> getCours() {
//		        return cours;
//		    }

	/**
	 * @return the cne
	 */

	/**
	 * @return the classe
	 */
//	public Classe getClasse() {
//		return classe;
//	}
//

	/**
	 * @param classe the classe to set
	 */
//	public void setClasse(Classe classe) {
//		this.classe = classe;
//	}

	/**
	 * @return the adress
	 */

}
