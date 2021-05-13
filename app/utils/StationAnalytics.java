package utils;

import models.Reading;

import java.util.List;

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
        if (readings.size() > 0) {
            tempTrendVar1 = readings.get(0);
            tempTrendVar2 = readings.get(1);
            tempTrendVar3 = readings.get(2);

            for (Reading reading : readings) {
                if (tempTrendVar1.getTemperature()> tempTrendVar2.getTemperature() && tempTrendVar2.getTemperature()>tempTrendVar3.getTemperature()) {
                    tempTrend = "ui right floated fitted huge angle up icon";
                }
                else if (tempTrendVar1.getTemperature()< tempTrendVar2.getTemperature() && tempTrendVar2.getTemperature()<tempTrendVar3.getTemperature()) {
                    tempTrend = "ui right floated fitted huge angle down icon";
                }
                else{
                    tempTrend = "ui right floated fitted huge arrows alternate horizontal icon";
                }
            }
        }
        return tempTrend;
    }
}