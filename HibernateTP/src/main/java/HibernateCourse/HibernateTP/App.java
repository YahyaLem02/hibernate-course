package HibernateCourse.HibernateTP;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {    
    	Address add1 =new Address();
    	add1.setNumero(12);
    	add1.setRue("Hay anas");
    	add1.setVille("safi");
   
    	Address add2 =new Address();
    	add2.setNumero(12);
    	add2.setRue("Saadaa");
    	add2.setVille("safi");
    	

    	Etudiant E1 =new Etudiant();
    	E1.setNom("Hiba");
    	E1.setPrenom("Dadda");
    	E1.setCne("EQ2222");
    	E1.setAdress(add1);
    	add1.setEtudiant(E1);

    	Etudiant E2 =new Etudiant();
    	E2.setNom("Anas");
    	E2.setPrenom("Moudnib");
    	E2.setCne("EX22");
    	E2.setAdress(add2);
    	add2.setEtudiant(E2);

    	List<Etudiant> etudiants = new ArrayList<Etudiant>();
    	etudiants.add(E1);
    	etudiants.add(E2);
    	
        Cours crs1=new Cours();
        crs1.setNom("UML");
        crs1.setEtudiants(etudiants);
        
        Cours crs2=new Cours();
        crs2.setNom("Merise");
        crs2.setEtudiants(etudiants);
 
    	Classe C = new Classe();
    	C.setNom("Algebre");
    	C.setEtudiants(etudiants);
    	
   
    	
    	
    	List<Cours> courses = new ArrayList<Cours>();
    	courses.add(crs1);
    	courses.add(crs2);
    	
    	E1.setCours(courses);
    	E2.setCours(courses);

    	
     	E1.SetClass(C);
    	E2.SetClass(C);
    	
    	Configuration con =new Configuration().configure().addAnnotatedClass(Etudiant.class).addAnnotatedClass(Address.class)
    			.addAnnotatedClass(Classe.class).addAnnotatedClass(Cours.class);
    	SessionFactory sf =con.buildSessionFactory();
    	Session ss= sf.openSession();
        Transaction tr=ss.beginTransaction();
     // ...

        try {
            for(Etudiant e :etudiants) {
                ss.save(e);
            }

            tr.commit(); // Commit de la transaction

            System.out.println("L'insertion est effectuée avec succès ");
        } catch (Exception e) {
            tr.rollback(); // En cas d'erreur, rollback de la transaction
            System.out.println("Erreur lors de l'insertion : " + e.getMessage());
        } finally {
            ss.close(); // Fermeture de la session Hibernate
            sf.close(); // Fermeture de la session factory
        }
}}
