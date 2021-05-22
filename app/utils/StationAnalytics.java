package utils;

import models.Reading;
import models.Station;
import play.Logger;
import java.util.List;
import java.util.*;

public class StationAnalytics {

    public static double getMaxTemp(List<Reading> readings) {

        Reading maxTemp = null;
        if (readings.size() > 0) {
            maxTemp = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getTemperature() > maxTemp.getTemperature()) {
                    maxTemp = reading;
                }
            }
        }
        return maxTemp.getTemperature();
    }

    public static double getMinTemp(List<Reading> readings) {
        Reading minTemp = null;
        if (readings.size() > 0) {
            minTemp = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getTemperature() < minTemp.getTemperature()) {
                    minTemp = reading;
                }
            }
        }
        return minTemp.getTemperature();
    }

    public static double getMaxWindSpeed(List<Reading> readings) {
        Reading maxWindSpeed = null;
        if (readings.size() > 0) {
            maxWindSpeed = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getWindSpeed() > maxWindSpeed.getWindSpeed()) {
                    maxWindSpeed = reading;
                }
            }
        }
        return maxWindSpeed.getWindSpeed();
    }

    public static double getMinWindSpeed(List<Reading> readings) {
        Reading minWindSpeed = null;
        if (readings.size() > 0) {
            minWindSpeed = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getWindSpeed() < minWindSpeed.getWindSpeed()) {
                    minWindSpeed = reading;
                }
            }
        }
        return minWindSpeed.getWindSpeed();
    }

    public static double getMaxPressure(List<Reading> readings) {
        Reading maxPressure = null;
        if (readings.size() > 0) {
            maxPressure = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getPressure() > maxPressure.getPressure()) {
                    maxPressure = reading;
                }
            }
        }
        return maxPressure.getPressure();
    }

    public static double getMinPressure(List<Reading> readings) {
        Reading minPressure = null;
        if (readings.size() > 0) {
            minPressure = readings.get(0);
            for (Reading reading : readings) {
                if (reading.getPressure() < minPressure.getPressure()) {
                    minPressure = reading;
                }
            }
        }
        return minPressure.getPressure();
    }

   public static String getTrend(List<Reading> readings) {
        String tempTrend = "";
        Reading tempTrendVar1 = null;
        Reading tempTrendVar2 = null;
        Reading tempTrendVar3 = null;
        if (readings.size() > 2) {

            tempTrendVar1 = readings.get(readings.size()-1);
            tempTrendVar2 = readings.get(readings.size()-2);
            tempTrendVar3 = readings.get(readings.size()-3);

            //Logger.info("PT = " + tempTrendVar1 + ", " + tempTrendVar2 + ", " + tempTrendVar3);

                if (tempTrendVar1.getTemperature()> tempTrendVar2.getTemperature() && tempTrendVar2.getTemperature()>tempTrendVar3.getTemperature()) {
                    tempTrend = "huge angle up icon";
                }
                else if (tempTrendVar1.getTemperature()< tempTrendVar2.getTemperature() && tempTrendVar2.getTemperature()<tempTrendVar3.getTemperature()) {
                    tempTrend = "huge angle down icon ";
                }
                else{
                    tempTrend = "huge arrows alternate horizontal icon";
                }

        }
        return tempTrend;
    }

    public static String getTrendWS(List<Reading> readings) {
        String windSpeedTrend = "";
        Reading windSpeedTrendVar1 = null;
        Reading windSpeedTrendVar2 = null;
        Reading windSpeedTrendVar3 = null;
        if (readings.size() > 2) {

            windSpeedTrendVar1 = readings.get(readings.size()-1);
            windSpeedTrendVar2 = readings.get(readings.size()-2);
            windSpeedTrendVar3 = readings.get(readings.size()-3);

            //Logger.info("PT = " + windSpeedTrendVar1.getWindSpeed() + ", " + windSpeedTrendVar2.getWindSpeed() + ", " + windSpeedTrendVar3.getWindSpeed());
            if (windSpeedTrendVar1.getWindSpeed()> windSpeedTrendVar2.getWindSpeed() && windSpeedTrendVar2.getWindSpeed()>windSpeedTrendVar3.getWindSpeed()) {
                windSpeedTrend = "fitted huge angle up icon";
            }
            else if (windSpeedTrendVar1.getWindSpeed()< windSpeedTrendVar2.getWindSpeed() && windSpeedTrendVar2.getWindSpeed()<windSpeedTrendVar3.getWindSpeed()) {
                windSpeedTrend = "fitted huge angle down icon";
            }
            else{
                windSpeedTrend = "fitted huge arrows alternate horizontal icon";
            }

        }
        return windSpeedTrend;
    }
    public static String getTrendPr(List<Reading> readings) {
        String pressureTrend = "";
        Reading pressureTrendVar1 = null;
        Reading pressureTrendVar2 = null;
        Reading pressureTrendVar3 = null;
        if (readings.size() > 2) {

            pressureTrendVar1 = readings.get(readings.size()-1);
            pressureTrendVar2 = readings.get(readings.size()-2);
            pressureTrendVar3 = readings.get(readings.size()-3);

           // Logger.info("PT = " + pressureTrendVar1.getPressure() + ", " + pressureTrendVar2.getPressure() + ", " + pressureTrendVar3.getPressure());

            if ((pressureTrendVar1.getPressure()> pressureTrendVar2.getPressure() )&& (pressureTrendVar2.getPressure()>pressureTrendVar3.getPressure())) {
                pressureTrend = " fitted huge angle up icon";
            }
            else if ((pressureTrendVar1.getPressure()< pressureTrendVar2.getPressure()) && (pressureTrendVar2.getPressure()<pressureTrendVar3.getPressure())) {
                pressureTrend = " fitted huge angle down icon";
            }
            else{
                pressureTrend = "fitted huge arrows alternate horizontal icon";
            }

        }
        return pressureTrend;
    }
    public static List<Station> sortStationABC(List<Station> stations)
    {
        Logger.info("Alphabetically sorting stations");
        stations.sort(Comparator.comparing(Station::getName));
        return stations;
    }

}