package type;

import java.util.ArrayList;

import org.apache.jena.ontology.Ontology;

import gui.tabbedContent.api.OntologyFunc;

public class Software {
    private String name;
    OntologyFunc ontologyFunc = new OntologyFunc();

    public Software(String name){
        super();
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    


}
