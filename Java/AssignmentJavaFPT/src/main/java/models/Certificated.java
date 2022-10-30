package models;

public class Certificated {
    private String certificatedId;
    private String certificatedName;
    private String certificatedDate;
    private String certificatedRank;

    public Certificated(String certificatedId, String certificatedName, String certificatedDate, String certificatedRank) {
        this.certificatedId = certificatedId;
        this.certificatedName = certificatedName;
        this.certificatedDate = certificatedDate;
        this.certificatedRank = certificatedRank;
    }

    public String getCertificatedId() {
        return certificatedId;
    }

    public void setCertificatedId(String certificatedId) {
        this.certificatedId = certificatedId;
    }

    public String getCertificatedName() {
        return certificatedName;
    }

    public void setCertificatedName(String certificatedName) {
        this.certificatedName = certificatedName;
    }

    public String getCertificatedDate() {
        return certificatedDate;
    }

    public void setCertificatedDate(String certificatedDate) {
        this.certificatedDate = certificatedDate;
    }

    public String getCertificatedRank() {
        return certificatedRank;
    }

    public void setCertificatedRank(String certificatedRank) {
        this.certificatedRank = certificatedRank;
    }
}
