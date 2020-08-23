package model;

public class EmailSetting {
    private int id;
    private String language;
    private String pagesizes;
    private String spamfiller;
    private String signature;

    public EmailSetting() {
    }

    public EmailSetting(int id, String language, String pagesizes, String spamfiller, String signature) {
        this.id = id;
        this.language = language;
        this.pagesizes = pagesizes;
        this.spamfiller = spamfiller;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPagesizes() {
        return pagesizes;
    }

    public void setPagesizes(String pagesizes) {
        this.pagesizes = pagesizes;
    }

    public String getSpamfiller() {
        return spamfiller;
    }

    public void setSpamfiller(String spamfiller) {
        this.spamfiller = spamfiller;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}
