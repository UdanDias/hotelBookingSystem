package com.project.hotelmgmt.util;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.UUID;
@Component
public class UtilData {

    public static LocalDate generateTodayDate(){
        return LocalDate.now();
    }

    public static String generateBookingId(){
        String id= String.valueOf(UUID.randomUUID());
        return "B-"+id;
    }
}
