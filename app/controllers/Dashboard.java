package controllers;

import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

import com.google.gson.stream.JsonToken;
import models.Member;
import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;


public class Dashboard extends Controller
{
  public static void index() {
    Logger.info("Rendering Dashboard");
    Member member = Accounts.getLoggedInMember();
    System.out.println(member);
    List<Station> station = StationAnalytics.sortStationABC(member.stations);



    System.out.println(station);
    System.out.println(member.stations);
    System.out.println(member.stations.size());



    for (int i = 0; i < member.stations.size(); i++) {
      if(!station.get(i).readings.isEmpty()) {
        member.stations.get(i).maxTemperature = StationAnalytics.getMaxTemp(member.stations.get(i).readings);
        System.out.println(station.get(i).maxTemperature);
        member.stations.get(i).minTemperature = StationAnalytics.getMinTemp(member.stations.get(i).readings);
        member.stations.get(i).maxWindSpeed = StationAnalytics.getMaxWindSpeed(member.stations.get(i).readings);
        member.stations.get(i).minWindSpeed = StationAnalytics.getMinWindSpeed(member.stations.get(i).readings);
        member.stations.get(i).maxPressure = StationAnalytics.getMaxPressure(member.stations.get(i).readings);
        member.stations.get(i).minPressure = StationAnalytics.getMinPressure(member.stations.get(i).readings);

        member.stations.get(i).tempTrend = StationAnalytics.getTrend(member.stations.get(i).readings);
        member.stations.get(i).windTrend = StationAnalytics.getTrendWS(member.stations.get(i).readings);
        member.stations.get(i).pressureTrend = StationAnalytics.getTrendPr(member.stations.get(i).readings);

      }
    }
      render("dashboard.html", station);


  }
  public static void addStation (String title, float latitude, float longitude)
  {
    Member member = Accounts.getLoggedInMember();
    List<Station> stations = StationAnalytics.sortStationABC(member.stations);
    Station station = new Station (title, latitude,longitude);
    Logger.info ("Adding a new Station called " + title);
    member.stations.add(station);
    member.save();
    redirect ("/dashboard");
  }

  public static void deleteStation (Long id) {

    Logger.info("Deleting a Station");
    Member member = Accounts.getLoggedInMember();
    Station station = Station.findById(id);
    member.stations.remove(station);
    member.save();
    station.delete();
    redirect ("/dashboard");
  }
}
