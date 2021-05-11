package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model
{
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    public List<Reading> readings = new ArrayList<Reading>();
    //public String county;
    public float latitude;
    public float longitude;
    //public String icon1 = "/public/images/image1.png";
    //public String icon2 = "/public/images/image2.png";

    public double maxPressure;
    public double minPressure;
    public double maxWindSpeed;
    public double minWindSpeed;
    public double maxTemperature;
    public double minTemperature;


    public Station(String name, float latitude, float longitude)
    {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        //this.county = county;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   // public List<Reading> getReadings() {
    //    return readings;
    //}

   // public void setReadings(List<Reading> readings) {
   //     this.readings = readings;
   // }

    public float getLat() {
        return latitude;
    }

    public void setLat(float latitude) {
        this.latitude = latitude;
    }

    public float getLng() {
        return longitude;
    }

    public void setLng(float longitude) {
        this.longitude = longitude;

    }

/*
    public int getLatestWeatherCode() {
        
        int latestWeatherCode = readings.get(readings.size()-1).getCode();
        return latestWeatherCode;
    }
    public double getLatestTemperature() {

        double latestTemp = readings.get(readings.size()-1).getTemperature();
        return latestTemp;
    }
    public double getLatestWind() {

        double latestWind = readings.get(readings.size()-1).getWindSpeed();
        return latestWind;
    }
    public double getLatestPressure() {

        double latestPressure = readings.get(readings.size()-1).getPressure();
        return latestPressure;
    }
    */
}

