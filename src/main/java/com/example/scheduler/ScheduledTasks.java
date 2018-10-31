package com.example.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;

import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;

/**
 * Scheduled component to get data from weather API
 * Use REST TEMPLATE as Rest client
 */

@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 10000)
    public void reportCurrentTime() throws APIException {

        String key = "8cd51d6739fbdc1f88fc2f828a4fdedd";
        double kelvin = 273.15;
        /*String openUri= "http://api.openweathermap.org/data/2.5/weather?q=London,uk&units=metric&appid=" + key;


        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(openUri, String.class);

        System.out.println(result);
        System.out.println("The time is now " + dateFormat.format(new Date()));*/

        // declaring object of "OWM" class
        OWM owm = new OWM(key);


        // getting current weather data for the "London" city
        CurrentWeather cwd = owm.currentWeatherByCityName("London");

        //printing city name from the retrieved data
        System.out.println("Temp: " + (cwd.getMainData().getTemp()-kelvin));

    }
}
