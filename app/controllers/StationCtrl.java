package controllers;

import java.util.List;

import models.Station;
import models.Reading;

import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;

public class StationCtrl extends Controller
{
    public static void index(Long id)
    {
        Station station = Station.findById(id);
        Logger.info ("Station id = " + id);

        station.maxTemperature = StationAnalytics.getMaxTemp(station.readings);
        station.minTemperature = StationAnalytics.getMinTemp(station.readings);
        station.maxWindSpeed = StationAnalytics.getMaxWindSpeed(station.readings);
        station.minWindSpeed = StationAnalytics.getMinWindSpeed(station.readings);
        station.maxPressure = StationAnalytics.getMaxPressure(station.readings);
        station.minPressure = StationAnalytics.getMinPressure(station.readings);

        Logger.info ("MaxTemp = " + station.maxTemperature);
        Logger.info ("MinTemp = " + station.minTemperature);


       // station.maxWindSpeed = StationAnalytics.getMaxWindSpeed(station.readings);
        //  station.minWindSpeed = StationAnalytics.getMinWindSpeed(station.readings);
        //  station.maxTemperature = StationAnalytics.getMaxTemp(station.readings);
        //  station.minTemperature = StationAnalytics.getMinTemp(station.readings);
        //  station.maxPressure = StationAnalytics.getMaxPressure(station.readings);
        //  station.minPressure = StationAnalytics.getMinPressure(station.readings);

        render("station.html", station);
       //render("cards.html", maxPressure,maxTemperature, maxWindSpeed, minPressure, minTemperature, minWindSpeed);
    }

    public static void addReading(Long id, int code, double temperature, double windSpeed, int pressure, double windDirection)
    {
        Reading reading = new Reading(code,temperature,windSpeed,pressure,windDirection);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/stations/" + id);
    }

}