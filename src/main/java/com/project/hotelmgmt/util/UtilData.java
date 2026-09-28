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
    public static String generateHotelId(){
        String id= String.valueOf(UUID.randomUUID());
        return "H-"+id;
    }
    public static String generateRoomId(){
        String id= String.valueOf(UUID.randomUUID());
        return "R-"+id;
    }
    public static String generateCustomerId(){
        String id= String.valueOf(UUID.randomUUID());
        return "C-"+id;
    }
    public static String generateUserId(){
        String id= String.valueOf(UUID.randomUUID());
        return "U-"+id;
    }
}
