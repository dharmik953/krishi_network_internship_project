package com.dharmik953.krishinetwork;

public class model {

    private  int crop_id;
    private  int id;
    private  String district;
    private  int district_id;
    private  String hindi_name;
    private  String image;
    private  float km;
    private  String last_date;
    private  float lat;
    private  float lng;
    private  String location;
    private  String market;
    private  String meters;
    private  String state;
    private  String locaurl_strtion;

    public model() {
    }

    public model(int crop_id, int id, String district, int district_id, String hindi_name, String image, float km, String last_date, float lat, float lng, String location, String market, String meters, String state, String locaurl_strtion) {
        this.crop_id = crop_id;
        this.id = id;
        this.district = district;
        this.district_id = district_id;
        this.hindi_name = hindi_name;
        this.image = image;
        this.km = km;
        this.last_date = last_date;
        this.lat = lat;
        this.lng = lng;
        this.location = location;
        this.market = market;
        this.meters = meters;
        this.state = state;
        this.locaurl_strtion = locaurl_strtion;
    }

    public int getCrop_id() {
        return crop_id;
    }

    public void setCrop_id(int crop_id) {
        this.crop_id = crop_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getDistrict_id() {
        return district_id;
    }

    public void setDistrict_id(int district_id) {
        this.district_id = district_id;
    }

    public String getHindi_name() {
        return hindi_name;
    }

    public void setHindi_name(String hindi_name) {
        this.hindi_name = hindi_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public float getKm() {
        return km;
    }

    public void setKm(float km) {
        this.km = km;
    }

    public String getLast_date() {
        return last_date;
    }

    public void setLast_date(String last_date) {
        this.last_date = last_date;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLng() {
        return lng;
    }

    public void setLng(float lng) {
        this.lng = lng;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMeters() {
        return meters;
    }

    public void setMeters(String meters) {
        this.meters = meters;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocaurl_strtion() {
        return locaurl_strtion;
    }

    public void setLocaurl_strtion(String locaurl_strtion) {
        this.locaurl_strtion = locaurl_strtion;
    }

    @Override
    public String toString() {
        return
                '\n' +
                        "   ->  crop_id : " + crop_id + '\n'+
                        "   ->  District : "+district + '\n'+
                        "   ->  District Id : " + district_id +'\n'+
                        "   ->  Hindi name : " + hindi_name +'\n'+
                        "   ->  image : " + image +'\n'+
                        "   ->  Distance : " + km +'\n'+
                        "   ->  Last date : " + last_date +'\n'+
                        "   ->  Latitude " + lat +'\n'+
                        "   ->  Longitude: " + lng+'\n'+
                        "   ->  Location : " + location+'\n'+
                        "   ->  Market : " + market+'\n'+
                        "   ->  Meters : " + meters +'\n'+
                        "   ->  State : " + state +'\n'+
                        "   ->  url_str : " + locaurl_strtion +'\n'
                ;
    }

}
