package controllers;

import java.time.LocalDateTime;
import java.util.List;

import models.Member;
import models.Station;
import models.Reading;

import org.joda.time.DateTime;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;

import java.util.Date;

public class StationCtrl extends Controller {
    public static void index(Long id) {
        Station station = Station.findById(id);
        Logger.info("Station id = " + id);

        Member member = Accounts.getLoggedInMember();

        if (!station.readings.isEmpty()) {
            station.maxTemperature = StationAnalytics.getMaxTemp(station.readings);
            station.minTemperature = StationAnalytics.getMinTemp(station.readings);
            station.maxWindSpeed = StationAnalytics.getMaxWindSpeed(station.readings);
            station.minWindSpeed = StationAnalytics.getMinWindSpeed(station.readings);
            station.maxPressure = StationAnalytics.getMaxPressure(station.readings);
            station.minPressure = StationAnalytics.getMinPressure(station.readings);
        }
        //  Logger.info ("MaxTemp = " + station.maxTemperature);
        // Logger.info ("MinTemp = " + station.minTemperature);

        station.tempTrend = StationAnalytics.getTrend(station.readings);
        station.windTrend = StationAnalytics.getTrendWS(station.readings);
        station.pressureTrend = StationAnalytics.getTrendPr(station.readings);

        // Logger.info ("Trends = 1 " + station.tempTrend + ", 2 " + station.windTrend  + ", 3 " + station.pressureTrend);


        // station.maxWindSpeed = StationAnalytics.getMaxWindSpeed(station.readings);
        //  station.minWindSpeed = StationAnalytics.getMinWindSpeed(station.readings);
        //  station.maxTemperature = StationAnalytics.getMaxTemp(station.readings);
        //  station.minTemperature = StationAnalytics.getMinTemp(station.readings);
        //  station.maxPressure = StationAnalytics.getMaxPressure(station.readings);
        //  station.minPressure = StationAnalytics.getMinPressure(station.readings);

        render("station.html", station);
        //render("cards.html", maxPressure,maxTemperature, maxWindSpeed, minPressure, minTemperature, minWindSpeed);
    }

    public static void addReading(Long id, int code, double temperature, double windSpeed, int pressure, double windDirection) {
        Date date = new Date();
        Reading reading = new Reading(code, temperature, windSpeed, pressure, windDirection, date);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect("/stations/" + id);
    }

    public static void deletereading(Long id, Long readingid) {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info("Removing " + reading.id);

        station.readings.remove(reading);
        station.save();
        reading.delete();
        render("station.html", station);
    }

}