package ua.training.web.beans;

public class Genre {
    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getId () {
        return this.id;
    }

}
