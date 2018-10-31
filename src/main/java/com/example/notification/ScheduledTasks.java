package com.example.notification;

import com.example.entity.Activite;
import com.example.service.IUserService;
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

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private static final String key = "8cd51d6739fbdc1f88fc2f828a4fdedd";

    @Autowired
    private IUserService userService;

    @Autowired
    private IEmailService emailService;

    @Scheduled(fixedRate = 100000)
    public void reportCurrentTime() throws APIException {

        /*OWN JAPIS*/
        OWM owm = new OWM(key);
        owm.setUnit(OWM.Unit.METRIC);
        String content = "Weather informations for all activities: ";

        for(Activite a : userService.getUserByUsername("user").getActivites()){
            CurrentWeather cwd = owm.currentWeatherByCityName(a.getLocalisation().getVille());

            content += System.getProperty("line.separator") +
                    " City: " + cwd.getCityName() +
                    " Temp: " + cwd.getMainData().getTemp() +
                    " Rain: " + cwd.hasRainData() +
                    " Wind: " + cwd.getWindData().component1();
        }


        emailService.sendSimpleMessage(content);

    }
}
