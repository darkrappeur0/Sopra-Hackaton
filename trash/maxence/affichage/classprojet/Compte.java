package affichage.classprojet;

public class Compte{

    private String nom;
    private String prenom;
    private String pseudo;


    public void setNom(String argv){
        nom = argv;
    }
    public void setPrenom(String argv){
        prenom = argv;
    }
    public void setPseudo (String argv){
        pseudo = argv;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public String getPseudo(){
        return pseudo;
    }
    public Compte(){
        this("none","none","none");
    }
    public Compte(String argv, String argc, String argg){
        nom = argv;
        prenom = argc;
        pseudo = argg;
    }




}