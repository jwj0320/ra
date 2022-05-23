package gui.tabbedContent.api;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import ru.avicomp.ontapi.OntManagers;
import ru.avicomp.ontapi.OntologyModel;

public class OntologyFunc {
    OWLOntologyManager manager = OntManagers.createONT();
	OWLDataFactory factory = manager.getOWLDataFactory();
	File file = new File(this.getClass().getResource("").getPath(),"../../../../../data/CB_PDO_V4.owl");
	OWLOntology ontology;
	OntologyModel o;

    public OntologyFunc(){
        System.out.println("Load Ontology: " + LoadOntology());
    }

    public boolean LoadOntology() {
		try {
			ontology = manager.loadOntologyFromOntologyDocument(file);
			o = (OntologyModel)ontology;
			return true;	
		}
		catch (OWLOntologyCreationException e) {
			System.err.println("Error creating OWL ontology: " + e.getMessage());
			//	System.exit(-1);
			return false;
		} 	
	}

	// public ArrayList<String> LoadSWInfo(String SWvector){
	// 	ArrayList<String> swInfo = new ArrayList<String>();
	// 	String queryString = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
	// 			+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
	// 			+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
	// 			+ "PREFIX PDO: <http://www.semanticweb.org/PDO#>\n"
	// 			+ "PREFIX CBSAO: <http://www.semanticweb.org/CBSAO#>\n"
	// 			+ "SELECT ?s_p_l ?t_l\n"
	// 			+ "WHERE { \n"
	// 			+ "  ?s rdfs:label \""+ SWvector +"\".\n"
	// 			+ "  ?s PDO:work_in_platforms ?s_p."
	// 			+ "  ?s_p rdfs:label ?s_p_l."
	// 			+ "  ?s PDO:perform_techniques ?t.\n"
	// 			+ "  ?t rdfs:label ?t_l.\n"
	// 			+ "}";
	// 	Query query = QueryFactory.create(queryString);
	// 	QueryExecution qe = QueryExecutionFactory.create(query, o.asGraphModel());
	// 	ResultSet res = qe.execSelect();
	// 	while (res.hasNext()) {
	// 		QuerySolution qs = res.next();
	// 		String s1 = qs.get("s_p_l").toString();
	// 		String s2 = qs.get("t_l").toString();
	// 		swInfo.add(s1);
	// 		swInfo.add(s2);
	// 	}
		
	// 	return swInfo;
	// }

    public ArrayList<String> LoadTechniquesFromSW(String SWvector){
		ArrayList<String> techlist = new ArrayList<String>();
		String queryString = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX PDO: <http://www.semanticweb.org/PDO#>\n"
				+ "PREFIX CBSAO: <http://www.semanticweb.org/CBSAO#>\n"
				+ "SELECT ?t_l\n"
				+ "WHERE { \n"
				+ "  ?s rdfs:label \""+ SWvector +"\".\n"
				+ "  ?s PDO:perform_techniques ?t.\n"
				+ "  ?t rdfs:label ?t_l.\n"
				+ "}";
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, o.asGraphModel());
		ResultSet res = qe.execSelect();
		while (res.hasNext()) {
			QuerySolution qs = res.next();
			String s1 = qs.get("t_l").toString();
			techlist.add(s1);
		}
		
		return techlist;
	}

    public ArrayList<String[]> LoadAllGroup() {
		ArrayList<String[]> listvector = new ArrayList<String[]>();
		String queryString = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX PDO: <http://www.semanticweb.org/PDO#>\n"
				+ "PREFIX CBSAO: <http://www.semanticweb.org/CBSAO#>\n"
				+ "SELECT ?a_l\n"
				+ "WHERE { \n"
				+ "  ?a rdf:type PDO:AC-Attack_Groups.\n ?a rdfs:label ?a_l.\n"
				+ "}"
                + "ORDER BY ASC(?a_l)";
		
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, o.asGraphModel());
		ResultSet res = qe.execSelect();
		
		while (res.hasNext()) {
			QuerySolution qs = res.next();
			String s1 = qs.get("a_l").toString();
			
			listvector.add(new String[]{s1});
		}	
		
		return listvector;
	}
    
    public ArrayList<String[]> LoadAllSW() {
		ArrayList<String[]> listvector = new ArrayList<String[]>();
		String queryString = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX PDO: <http://www.semanticweb.org/PDO#>\n"
				+ "PREFIX CBSAO: <http://www.semanticweb.org/CBSAO#>\n"
				+ "SELECT ?a_l\n"
				+ "WHERE { \n"
				+ "  ?a rdf:type PDO:AC-Software_Used.\n" 
				+ "  ?a rdfs:label ?a_l.\n"
				+ "}"
                + "ORDER BY ASC(?a_l)";
		
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, o.asGraphModel());
		ResultSet res = qe.execSelect();
		
		while (res.hasNext()) {
			QuerySolution qs = res.next();
			String s1 = qs.get("a_l").toString();
			
			listvector.add(new String[]{s1});
		}	
		
		return listvector;
	}
    

    public ArrayList<String[]> LoadAllTech() {
		ArrayList<String[]> listvector = new ArrayList<String[]>();
		String queryString = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX PDO: <http://www.semanticweb.org/PDO#>\n"
				+ "PREFIX CBSAO: <http://www.semanticweb.org/CBSAO#>\n"
				+ "SELECT ?a_l\n"
				+ "WHERE { \n"
				+ "  ?a rdf:type PDO:AC-Techniques_Used.\n ?a rdfs:label ?a_l.\n"
				+ "}"
                + "ORDER BY ASC(?a_l)";
		
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, o.asGraphModel());
		ResultSet res = qe.execSelect();
		
		while (res.hasNext()) {
			QuerySolution qs = res.next();
			String s1 = qs.get("a_l").toString();
			
			listvector.add(new String[]{s1});
		}	
		
		return listvector;
	}

    public ArrayList<String[]> LoadSWPlatform(String sw) {
		ArrayList<String[]> listvector = new ArrayList<String[]>();
		String queryString = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX PDO: <http://www.semanticweb.org/PDO#>\n"
				+ "PREFIX CBSAO: <http://www.semanticweb.org/CBSAO#>\n"
				+ "SELECT ?a_p_l \n"
				+ "WHERE { \n"
				+ "  ?a rdfs:label \"" + sw +"\".\n"+ "?a PDO:work_in_platforms"+" ?a_p.\n"
				+ "  ?a_p rdfs:label ?a_p_l.\n"
				+ "}"
                + "ORDER BY ASC(?a_p_l)";
		
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, o.asGraphModel());
		ResultSet res = qe.execSelect();
		
		while (res.hasNext()) {
			QuerySolution qs = res.next();
			String s1 = qs.get("a_p_l").toString();
			
			listvector.add(new String[]{s1});
		}	
		
		return listvector;
	}

    public ArrayList<String[]> LoadSWTech(String sw) {
		ArrayList<String[]> listvector = new ArrayList<String[]>();
		String queryString = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX PDO: <http://www.semanticweb.org/PDO#>\n"
				+ "PREFIX CBSAO: <http://www.semanticweb.org/CBSAO#>\n"
				+ "SELECT ?a_t_l \n"
				+ "WHERE { \n"
				+ "  ?a rdfs:label \"" + sw +"\".\n"+ "?a PDO:perform_techniques"+" ?a_t.\n"
				+ "  ?a_t rdfs:label ?a_t_l.\n"
				+ "}"
                + "ORDER BY ASC(?a_p_l)";
		
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, o.asGraphModel());
		ResultSet res = qe.execSelect();
		
		while (res.hasNext()) {
			QuerySolution qs = res.next();
			String s1 = qs.get("a_t_l").toString();
			
			listvector.add(new String[]{s1});
		}	
		
		return listvector;
	}
    
    public ArrayList<String[]> LoadGroupTechnique(String group) {
		ArrayList<String[]> listvector = new ArrayList<String[]>();
		String queryString = "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n"
				+ "PREFIX owl: <http://www.w3.org/2002/07/owl#>\n"
				+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n"
				+ "PREFIX PDO: <http://www.semanticweb.org/PDO#>\n"
				+ "PREFIX CBSAO: <http://www.semanticweb.org/CBSAO#>\n"
				+ "SELECT ?a_l ?a_c ?s_l WHERE { ?b rdfs:label \""+ group +"\".\n ?b PDO:use_techniques ?a. ?a rdfs:label ?a_l. "
				+ "?a rdfs:comment ?a_c. ?sample rdf:type PDO:"+ group +". "
				+ "?sample PDO:sample_of_use ?a. "
				+ "?sample rdfs:label ?s_l.}";
		
		
		Query query = QueryFactory.create(queryString);
		QueryExecution qe = QueryExecutionFactory.create(query, o.asGraphModel());
		ResultSet res = qe.execSelect();
		
		while (res.hasNext()) {
			QuerySolution qs = res.next();
			String s1 = qs.get("a_l").toString();
			String s2 = qs.get("a_c").toString();
			String s3 = qs.get("s_l").toString();
			
			listvector.add(new String[]{s1, s2, s3});
		}	
		
		return listvector;
	}
   
}
