package com.example.exam.meteo;

import io.swagger.annotations.ApiModelProperty;

public class Weather {
    @ApiModelProperty(notes = "Ville",name="ville",required=true,value="test ville")
    private String ville;
    @ApiModelProperty(notes = "zip_code",name="zip_code",required=true,value="test zip_code")
    private String zip_code;
    @ApiModelProperty(notes = "pays",name="pays",required=true,value="test pays")
    private String pays;
    @ApiModelProperty(notes = "meteo",name="meteo",required=true,value="test meteo")
    private String meteo;

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getZip_code() {
        return zip_code;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getMeteo() {
        return meteo;
    }

    public void setMeteo(String meteo) {
        this.meteo = meteo;
    }

    public Weather(String ville, String zip_code, String pays, String meteo) {
        this.ville = ville;
        this.zip_code = zip_code;
        this.pays = pays;
        this.meteo = meteo;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "ville='" + ville + '\'' +
                ", zip_code='" + zip_code + '\'' +
                ", pays='" + pays + '\'' +
                ", meteo='" + meteo + '\'' +
                '}';
    }
}
