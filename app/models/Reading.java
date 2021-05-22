package models;
import javax.persistence.Entity;

import org.joda.time.DateTime;
import play.db.jpa.Model;
import play.Logger;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;                      ///imported date to use Date as a type, as per advice on Slack
import java.util.HashMap;


@Entity
public class Reading extends Model {
    private int code;
    private double temperature;
    private double windSpeed;
    private double pressure;
    private double windDirection;
    public Date dateTime;


    public Reading(int code, double temperature, double windSpeed, double pressure, double windDirection, Date date) {
        this.code = code;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.windDirection = windDirection;
        this.dateTime = date;


    }
    /*
    public String Weather(int code) {
        String weather = "";
        switch (code) {
            case 100:
                weather = "Clear";
                break;
            case 200:
                weather = "Partial clouds";
                break;
            case 300:
                weather = "Cloudy";
                break;
            case 400:
                weather = "Light Showers";
                break;
            case 500:
                weather = "Heavy Showers";
                break;
            case 600:
                weather = "Rain";
                break;
            case 700:
                weather = "Snow";
                break;
            case 800:
                weather = "Thunder";
                break;

            default:
                weather = "Varied";
                break;
        }

        return weather;
    }
    */

    public static String Weather(int code) {
        HashMap<Integer,String> weather = new HashMap<Integer,String>();
        weather.put(100,"Clear");
        weather.put(200,"Partial clouds");
        weather.put(300,"Cloudy");
        weather.put(400,"Light Showers");
        weather.put(500,"Heavy Showers");
        weather.put(600,"Rain");
        weather.put(700,"Snow");
        weather.put(800,"Thunder");
        weather.put(900,"Varied");
        return weather.get(code);
    }

    public String WeatherIcon(int code) {
        String weatherIcon = "";
        switch (code) {
            case 100:
                weatherIcon = "ui right floated fitted inverted yellow huge sun outline icon";
                break;
            case 200:
                weatherIcon = "ui right floated fitted inverted orange huge loud sun icon";
                break;
            case 300:
                weatherIcon = "ui right floated fitted inverted grey huge cloud icon";
                break;
            case 400:
                weatherIcon = "ui right floated fitted inverted inverted huge cloud rain icon";
                break;
            case 500:
                weatherIcon = "ui right floated fitted inverted huge cloud showers heavy icon";
                break;
            case 600:
                weatherIcon = "ui right floated fitted inverted huge secondary cloud rain icon";
                break;
            case 700:
                weatherIcon = "ui right floated fitted inverted huge inverted snowflake icon";
                break;
            case 800:
                weatherIcon = "ui right floated fitted inverted huge yellow bolt icon";
                break;

            default:
                weatherIcon = "Varied";
                break;
        }

        return weatherIcon;
    }

    public double TempF(double temperature) {
        double temperatureF = ((temperature * 1.8) + 32);
        return temperatureF;
    }

    public String TempIcon(double temperatureF) {
        String tempIcon = "";
        if(temperatureF>=49 && temperatureF<=59)
        {
          tempIcon = "ui right floated fitted inverted huge grey temperature low icon";
        }
        else if(temperatureF>=41 && temperatureF<=49)
        {
            tempIcon = "ui right floated fitted inverted huge teal temperature low icon";
        }
        else if(temperatureF>=32 && temperatureF<=41)
        {
            tempIcon = "ui right floated fitted inverted huge blue temperature low icon";
        }
        else if(temperatureF<32)
        {
            tempIcon = "ui right floated fitted inverted huge blue snowflake outline icon";
        }
        else if(temperatureF>=60 && temperatureF<=68){
            tempIcon = "ui right floated fitted inverted huge inverted yellow temperature high icon";
        }
        else if(temperatureF>68){
            tempIcon = "ui right floated fitted inverted huge inverted red temperature high icon";
        }
        return tempIcon;
    }
    public String PressureIcon(double pressure) {
        String pressureIcon = "";
        if(pressure<=980)
        {
            pressureIcon = "ui right floated fitted inverted primary blue dumbbell icon";
        }
        else if(pressure>980 && pressure<=990)
        {
            pressureIcon = "ui right floated fitted inverted primary large teal dumbbell icon";
        }
        else if(pressure>990 && pressure<=1000)
        {
            pressureIcon = "ui right floated fitted inverted primary big yellow dumbbell icon";
        }
        else if(pressure>1000 && pressure<=1010)
        {
            pressureIcon = "ui right floated fitted inverted primary huge orange dumbbell icon";
        }
        else if(pressure>1010)
        {
            pressureIcon = "ui right floated fitted inverted primary huge red dumbbell icon";
        }

        return pressureIcon;
    }


    public int kMhr_Bft(double windSpeed) {
        int bFTScale = 0;
        if (windSpeed == 1) {
            bFTScale = 0;
        } else if (windSpeed > 1 && windSpeed < 6) {
            bFTScale = 1;
        } else if (windSpeed > 5 && windSpeed < 12) {
            bFTScale = 2;
        } else if (windSpeed > 11 && windSpeed < 20) {
            bFTScale = 3;
        } else if (windSpeed > 19 && windSpeed < 29) {
            bFTScale = 4;
        } else if (windSpeed > 28 && windSpeed < 39) {
            bFTScale = 5;
        } else if (windSpeed > 38 && windSpeed < 50) {
            bFTScale = 6;
        } else if (windSpeed > 49 && windSpeed < 62) {
            bFTScale = 7;
        } else if (windSpeed > 61 && windSpeed < 75) {
            bFTScale = 8;
        } else if (windSpeed > 74 && windSpeed < 89) {
            bFTScale = 9;
        } else if (windSpeed > 88 && windSpeed < 103) {
            bFTScale = 10;
        } else if (windSpeed > 102 && windSpeed < 118) {
            bFTScale = 11;
        }
        return bFTScale;
    }

    public String kMhr_BftLabel(double windSpeed) {
        String bFTScaleLabel = "";
        if (windSpeed == 1) {
            bFTScaleLabel = "Calm";
        } else if (windSpeed > 1 && windSpeed < 6) {
            bFTScaleLabel = "Light Air";
        } else if (windSpeed > 5 && windSpeed < 12) {
            bFTScaleLabel = "Light Breeze";
        } else if (windSpeed > 11 && windSpeed < 20) {
            bFTScaleLabel = "Gentle Breeze";
        } else if (windSpeed > 19 && windSpeed < 29) {
            bFTScaleLabel = "Moderate Breeze";
        } else if (windSpeed > 28 && windSpeed < 39) {
            bFTScaleLabel = "Fresh Breeze";
        } else if (windSpeed > 38 && windSpeed < 50) {
            bFTScaleLabel = "strong Breeze";
        } else if (windSpeed > 49 && windSpeed < 62) {
            bFTScaleLabel = "Near Gale";
        } else if (windSpeed > 61 && windSpeed < 75) {
            bFTScaleLabel = "Gale";
        } else if (windSpeed > 74 && windSpeed < 89) {
            bFTScaleLabel = "Severe Gale";
        } else if (windSpeed > 88 && windSpeed < 103) {
            bFTScaleLabel = "Strong storm";
        } else if (windSpeed > 102 && windSpeed < 118) {
            bFTScaleLabel = "Violent Storm";
        }
        return bFTScaleLabel;
    }

    public String WindIcon(int bFTScale) {
        String windIcon = "";
        switch (bFTScale) {
            case 1:
                windIcon = "ui right floated fitted inverted blue small wind icon";
                break;
            case 2:
                windIcon = "ui right floated fitted inverted green small wind icon";
                break;
            case 3:
                windIcon = "ui right floated fitted inverted green wind icon";
                break;
            case 4:
                windIcon = "ui right floated fitted inverted green large wind icon";
                break;
            case 5:
                windIcon = "ui right floated fitted inverted green big wind icon";
                break;
            case 6:
                windIcon = "ui right floated fitted inverted green huge wind icon";
                break;
            case 7:
                windIcon = "ui right floated fitted inverted green massive wind icon";
                break;
            case 8:
                windIcon = "ui right floated fitted inverted olive massive wind icon";
                break;
            case 9:
                windIcon = "ui right floated fitted inverted yellow massive wind icon";
                break;
            case 10:
                windIcon = "ui right floated fitted inverted orange massive wind icon";
                break;
            case 11:
                windIcon = "ui right floated fitted inverted red massive wind icon";
                break;

            default:
                windIcon = "Unknown";
                break;
        }
        return windIcon;
    }

    public String windDirection_Text(double windDirection) {
        String windDirection_Text = "";
        if (windDirection > 348.75 && windDirection <= 11.25) {
            windDirection_Text = "N";
        } else if (windDirection > 11.25 && windDirection <= 33.75) {
            windDirection_Text = "NNE";
        } else if (windDirection > 33.75 && windDirection <= 56.25) {
            windDirection_Text = "NE";
        } else if (windDirection > 56.25 && windDirection <= 78.25) {
            windDirection_Text = "ENE";
        } else if (windDirection > 78.25 && windDirection <= 101.25) {
            windDirection_Text = "E";
        } else if (windDirection > 101.25 && windDirection <= 123.75) {
            windDirection_Text = "ESE";
        } else if (windDirection > 123.75 && windDirection <= 146.25) {
            windDirection_Text = "SE";
        } else if (windDirection > 146.25 && windDirection <= 168.75) {
            windDirection_Text = "SSE";
        } else if (windDirection > 168.75 && windDirection <= 191.25) {
            windDirection_Text = "S";
        } else if (windDirection > 191.25 && windDirection <= 213.75) {
            windDirection_Text = "SSW";
        } else if (windDirection > 213.75 && windDirection <= 236.25) {
            windDirection_Text = "SW";
        } else if (windDirection > 236.25 && windDirection <= 258.75) {
            windDirection_Text = "WSW";
        } else if (windDirection > 258.75 && windDirection <= 281.25) {
            windDirection_Text = "W";
        } else if (windDirection > 281.25 && windDirection <= 303.75) {
            windDirection_Text = "WNW";
        } else if (windDirection > 303.75 && windDirection <= 326.25) {
            windDirection_Text = "NW";
        } else if (windDirection > 326.25 && windDirection <= 348.75) {
            windDirection_Text = "NNW";
        }

        return windDirection_Text;
    }

    public String windChillCalc(double temperatureC, double windKmpHr)
    {
        double mid1 = Math.pow(windKmpHr,0.16);
        double windChillCalc = 13.12 + (0.6215*temperatureC) - (11.37*(mid1)) + ((0.3965*temperatureC)*(mid1));

        DecimalFormat df = new DecimalFormat(("#.###")); ////// https://www.programiz.com/java-programming/examples/round-number-decimal
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(windChillCalc);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public double getTemperature() {
        return temperature;
    }

    public Date getDateTime() {
        return dateTime; ///////////////https://www.baeldung.com/java-string-to-date
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getWindDirection() {
        return windDirection;
    }
    public void setWindDirection(double windDirection) {
        this.windDirection=windDirection;
    }


    // public double getMaxTemp()

}
