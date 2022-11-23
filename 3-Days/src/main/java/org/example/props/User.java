
package org.example.props;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class User {

    @SerializedName("durum")
    @Expose
    private Boolean durum;
    @SerializedName("mesaj")
    @Expose
    private String mesaj;
    @SerializedName("bilgiler")
    @Expose
    private Bilgiler bilgiler;

    public Boolean getDurum() {
        return durum;
    }

    public void setDurum(Boolean durum) {
        this.durum = durum;
    }

    public String getMesaj() {
        return mesaj;
    }

    public void setMesaj(String mesaj) {
        this.mesaj = mesaj;
    }

    public Bilgiler getBilgiler() {
        return bilgiler;
    }

    public void setBilgiler(Bilgiler bilgiler) {
        this.bilgiler = bilgiler;
    }

}
