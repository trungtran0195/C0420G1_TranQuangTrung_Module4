package model;

public class DictModel {
    private String eng;
    private String vi;

    public DictModel() {
    }

    public DictModel(String eng, String vi) {
        this.eng = eng;
        this.vi = vi;
    }

    public String getEng() {
        return this.eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

    public String getVi() {
        return this.vi;
    }

    public void setVi(String vi) {
        this.vi = vi;
    }
}
