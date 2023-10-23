package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;


	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");


	}

	@Test
	public void testHeuresPrevues(){
		untel.ajouteEnseignement(uml, 0, 1, 0);
		untel.ajouteEnseignement(java, 0, 1, 0);
		assertEquals(2, untel.heuresPrevues(),"L'enseignant doit réaliser 2h" );
	}



	@Test
	public void testEnSousService(){
		untel.ajouteEnseignement(uml, 1, 1, 1);
		assertTrue (untel.sousService(), "L'enseignant doit être en sous service");

		untel.ajouteEnseignement(uml, 100, 50, 50);
		assertFalse (untel.sousService(), "L'enseignant ne doit pas être en sous service");

	}
	@Test
	public void testHeuresPrevuesPourUe(){
		untel.ajouteEnseignement(java,0,1,0);
		assertEquals(1,untel.heuresPrevuesPourUE(java),"Erreur");

	}
	@Test
	public void testResteAPlanifier()
	{
		UE uml = new UE("test", 10,20,30);
		assertEquals(172, untel.resteAPlanifier(uml, TypeIntervention.TD),
				"Il y a plus d'heures à planifier)");
		assertEquals(182, untel.resteAPlanifier(uml, TypeIntervention.CM),
				"Il y a plus d'heures à planifier)");
		assertEquals(162, untel.resteAPlanifier(uml, TypeIntervention.TP),
				"Il y a plus d'heures à planifier)");
	}




}
