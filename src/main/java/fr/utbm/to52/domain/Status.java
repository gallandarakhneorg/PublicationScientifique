package fr.utbm.to52.domain;

public enum Status {


    ECC ("Enseignant Chercheur Contractuel"),
    IGR ("Ingénieur de Recherche"),
    IGE ("Ingénieur d'Etude"),
    MCF_HDR ("Maître de Conférences avec HDR"),
    ADM ("Personnel Administratif"),
    Postdoc ("Post-Doctorant"),
    PR ("Professeur des Universités"),
    STA ("Stagiaire"),
    MCF ("Maître de Conférences");


    private String name = "";
    private String codeStatus = "";

    //Constructeur
    Status(String name, String codeStatus){
        this.name = name;
        this.codeStatus= codeStatus;
    }

    Status(String name){
        this.name = name;
    }


    public String toString(){
        return name;
    }

    public String getCodestatus(){
        return codeStatus;
    }
}
