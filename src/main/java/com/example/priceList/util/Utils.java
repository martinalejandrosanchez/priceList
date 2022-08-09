package com.example.priceList.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Utils {
    public static <T> String writeValueAsString(T o) {
        ObjectMapper objectMapper = new ObjectMapper();
        String result = null;
        try {
            result = objectMapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Date convertStringToDate(String dateInString) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd hh:mm:ss", Locale.ENGLISH);
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.parse(dateInString);
    }
}
