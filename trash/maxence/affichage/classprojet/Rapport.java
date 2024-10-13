package affichage.classprojet;

public class Rapport{
    private String date;
    private String heure;
    private String lieu;
    private String motif;

    public void setDate(String argv){
        date = argv;
    }
    public void setHeure(String argv){
        heure = argv;
    }
    public void setLieu(String argv){
        lieu = argv;
    }
    public void setMotif(String argv){
        motif = argv;
    }
    public String getDate(){
        return date;
    }
    public String getHeure(){
        return heure;
    }
    public String getLieu(){
        return lieu;
    }
    public String getMotif(){
        return motif;
    }

    public Rapport(){
        this("none","none","none","none");
    }
    public Rapport(String date1,String heure1, String lieu1, String motif1){
        date = date1;
        heure = heure1;
        lieu = lieu1;
        motif = motif1;
    }
}