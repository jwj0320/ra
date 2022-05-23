package gui.tabbedContent.type;

public class Software {
    private Technique[] techniques;
    private String name;
    private String ID;
    private String type;
    private String[] platforms;

    public Software(String name){
        super();
        this.setName(name);
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        this.ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Technique[] getTechniques() {
        return techniques;
    }

    public void setTechniques(Technique[] techniques) {
        this.techniques = techniques;
    }
}
