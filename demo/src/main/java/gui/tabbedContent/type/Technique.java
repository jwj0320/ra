package gui.tabbedContent.type;

public class Technique {
    private Software[] softwares;
    private String name;
    private String ID;
    private String mainID;
    private String[] platforms;
    private String tactics;
    private String[] mitigations;
    private String[] detections;
    private String attackPatterns;

    public Technique(String name){
        super();
        this.setName(name);
    }

    public String getAttackPatterns() {
        return attackPatterns;
    }

    public void setAttackPatterns(String attackPatterns) {
        this.attackPatterns = attackPatterns;
    }

    public String[] getDetections() {
        return detections;
    }

    public void setDetections(String[] detections) {
        this.detections = detections;
    }

    public String[] getMitigations() {
        return mitigations;
    }

    public void setMitigations(String[] mitigations) {
        this.mitigations = mitigations;
    }

    public String getTactics() {
        return tactics;
    }

    public void setTactics(String tactics) {
        this.tactics = tactics;
    }

    public String[] getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }

    public String getMainID() {
        return mainID;
    }

    public void setMainID(String mainID) {
        this.mainID = mainID;
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

    public Software[] getSoftwares() {
        return softwares;
    }

    public void setSoftwares(Software[] softwares) {
        this.softwares = softwares;
    }
}
