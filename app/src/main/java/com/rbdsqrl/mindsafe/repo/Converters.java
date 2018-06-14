package com.rbdsqrl.mindsafe.repo;

import com.google.gson.Gson;
import com.rbdsqrl.mindsafe.pojo.Event;

import java.util.ArrayList;
import java.util.List;

import androidx.room.TypeConverter;

public class Converters {

    @TypeConverter
    public static String toStringEvent(List<Event> events) {
        List<String> eventStrings = new ArrayList<>();
        for (Event event : events) {
            Gson gson = new Gson();
            eventStrings.add(gson.toJson(event));
        }

        Gson gson = new Gson();
        return gson.toJson(eventStrings);
    }

    @TypeConverter
    public static List<Event> toEvent(String eventString) {
        Gson gson = new Gson();
        List<String> arrayList = gson.fromJson(eventString, List.class);

        List<Event> list = new ArrayList<>();
        for (String event : arrayList) {
            Event item = gson.fromJson(event, Event.class);
            list.add(item);
        }
        return list;
    }

    @TypeConverter
    public static String toStringSubstanceUse(DiaryPage.SubstanceUse substanceUse) {
        return substanceUse.getCode();
    }

    @TypeConverter
    public static DiaryPage.SubstanceUse toSubstanceUse(String substanceUse) {
        return DiaryPage.SubstanceUse.valueOf(substanceUse);
    }

}
