package jokessecure.securejokes.Jokes;

public class Jokes {
    
    private String category;
    private String joke;
    private String punchL;
    private int status;

    public Jokes() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Jokes(String category, String joke, String punchL, int status) {
        this.category = category;
        this.joke = joke;
        this.punchL = punchL;
        this.status=status;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public String getPunchL() {
        return punchL;
    }

    public void setPunchL(String punchL) {
        this.punchL = punchL;
    }

    @Override
    public String toString() {
        return "Jokes [category=" + category + ", joke=" + joke + ", punchL=" + punchL + "]";
    }

}
