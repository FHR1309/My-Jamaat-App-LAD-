package com.example.myjamaat1lad;

public class Masjid_Model {

    int id;
    String name;
    String fazr;
    String juhr;
    String asr;
    String maghrib;
    String esha;
    boolean isActive;


    @Override
    public String toString() {
        return "Masjid_Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fazr='" + fazr + '\'' +
                ", juhr='" + juhr + '\'' +
                ", asr='" + asr + '\'' +
                ", maghrib='" + maghrib + '\'' +
                ", esha='" + esha + '\'' +
                ", isActive=" + isActive +
                '}';
    }


    public Masjid_Model(int id, String name,boolean isActive, String fazr, String juhr, String asr, String maghrib, String esha ) {
        this.id = id;
        this.name = name;
        this.fazr = fazr;
        this.juhr = juhr;
        this.asr = asr;
        this.maghrib = maghrib;
        this.esha = esha;
        this.isActive = isActive;
    }

    public String getFazr() {
        return fazr;
    }

    public void setFazr(String fazr) {
        this.fazr = fazr;
    }

    public String getJuhr() {
        return juhr;
    }

    public void setJuhr(String juhr) {
        this.juhr = juhr;
    }

    public String getAsr() {
        return asr;
    }

    public void setAsr(String asr) {
        this.asr = asr;
    }

    public String getMaghrib() {
        return maghrib;
    }

    public void setMaghrib(String maghrib) {
        this.maghrib = maghrib;
    }

    public String getEsha() {
        return esha;
    }

    public void setEsha(String esha) {
        this.esha = esha;
    }





    public Masjid_Model() {
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
