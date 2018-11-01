package com.example.notification;

import com.example.entity.Activite;
import com.example.entity.Environment;
import com.example.service.IUserService;
import net.aksingh.owmjapis.model.DailyWeatherForecast;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;

/**
 * Scheduled component to get data from weather API
 * Use REST TEMPLATE as Rest client
 */

@Component
public class ScheduledTasks {

    private static final String key = "8cd51d6739fbdc1f88fc2f828a4fdedd";

    @Autowired
    private IUserService userService;

    @Autowired
    private IEmailService emailService;

    //@Scheduled(cron = "0 0 18 * * WED")
    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() throws APIException {

        OWM owm = new OWM(key);
        owm.setUnit(OWM.Unit.METRIC);
        String content = "Weather informations for all activities: ";

        for(Activite a : userService.getUserByUsername("user").getActivites()){

            HourlyWeatherForecast hwf = owm.hourlyWeatherForecastByCityName(a.getLocalisation().getVille());

            /**
             * Weather every 3h for 5 days
             * If asked a 7:00pm
             * 8 * 3 - 2 for Saturday 12:00am
             */
            WeatherData forecastData = hwf.component5().get(8*3-2);

            content += System.getProperty("line.separator");
            content += "**********************************";
            content += System.getProperty("line.separator");
            content += a.getSport().getName() + " at " + a.getLocalisation().getVille() + ": ";
            content += System.getProperty("line.separator");
            content += "Status : " + forecastData.getWeatherList().get(0).getMainInfo();
            content += System.getProperty("line.separator");
            content += "Temperature: " + forecastData.getMainData().getTemp() + "°C";
            content += System.getProperty("line.separator");
            content += "Remark: ";

            content += (a.getSport().getEnvironment() == Environment.OUTSIDE &&
                    forecastData.getWeatherList().get(0).getMainInfo().equals("Rain")) ?
                    "BE CAREFUL IT IS RAINING! " : "ENJOY! ";

            content += System.getProperty("line.separator");

        }

        System.out.println(content);

        //emailService.sendSimpleMessage(content);

    }
}
