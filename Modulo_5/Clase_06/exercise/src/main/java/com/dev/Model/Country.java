package com.dev.Model;

public class Country {

    private String country_id;
    private String country_name;
    private Integer region_id;

    public Country(String country_id, String country_name, Integer region_id) {
        this.country_id = country_id;
        this.country_name = country_name;
        this.region_id = region_id;
    }

    public String getCountry_id() {
        return country_id;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public Integer getRegion_id() {
        return region_id;
    }

    public void setRegion_id(Integer region_id) {
        this.region_id = region_id;
    }

}
