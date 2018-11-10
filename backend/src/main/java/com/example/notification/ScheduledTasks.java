package com.example.notification;

import com.example.entity.Activite;
import com.example.entity.Environment;
import com.example.entity.User;
import com.example.service.IUserService;
import net.aksingh.owmjapis.model.DailyWeatherForecast;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.WeatherData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;

import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.model.CurrentWeather;

/**
 * Scheduled component to get data from weather API
 * Use OpenWeatherApi java library to handle response
 */

@Component
public class ScheduledTasks {


    /**
     * Api Key given by OWM to request their API
     *
     */
    private static final String key = "8cd51d6739fbdc1f88fc2f828a4fdedd";

    @Autowired
    private IUserService userService;

    @Autowired
    private IEmailService emailService;

    /**
     * cron allow us to define when this method is executed
     * @throws APIException: if to much request /min are made,
     * OWM no more return information
     */

    //@Scheduled(cron = "0 0 18 * * WED")
    @Scheduled(fixedRate = 500000)
    public void reportCurrentTime() throws APIException {

        OWM owm = new OWM(key);
        owm.setUnit(OWM.Unit.METRIC);
        String content = "Weather informations for all activities: ";

        /**
         * We do for only one user to test
         * TODO: do for all users
         */
        List<User> users = userService.getUsers();
        if (users.size() == 0 ){ return ; }
        User user = users.get(0);

        for(Activite a : user.getActivites()){

            HourlyWeatherForecast hwf = owm.hourlyWeatherForecastByCityName(a.getLocalisation().getVille());

            /**
             * Forecast return 40 weather information
             * every 3h for 5 days
             * If asked Wednesday at 7:00pm and want weather for Saturday 12:00:
             * 8 * 3 - 2
             */
            WeatherData forecastData = hwf.component5().get(8*3-2);

            content += System.getProperty("line.separator");
            content += "**********************************";
            content += System.getProperty("line.separator");
            content += a.getSport().getName() + " at " + a.getLocalisation().getVille() + " ";
            content += forecastData.getDateTime().toString()  + ": ";
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

        /**
         * Log in console to test (avoid email spamming)
         * Uncomment emailService.sendSimpleMessage(content);
         * to send mail to user
         * NOTE:
         * alexandre.vu@etudiant.univ-rennes1.fr is given for all user in DB
         */

        System.out.println(content);

        emailService.sendSimpleMessage(user.getMail(),content);

    }
}
