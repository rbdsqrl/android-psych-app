package com.rbdsqrl.mindsafe.repo;

import com.rbdsqrl.mindsafe.pojo.Event;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity
public class DiaryPage {

    public enum SubstanceUse {
        DRINKING("DRINKING"), SMOKING("SMOKING"), DRUGS("DRUGS"), NONE("NONE");

        private String code;

        SubstanceUse(String code){
            this.code = code;
        }

        public String getCode(){
            return code;
        }
    }

    @NonNull
    @PrimaryKey
    String diaryDate;
    @TypeConverters(Converters.class)
    List<Event> events;
    String moodQuotient;
    String appetiteQuotient;
    String eatingQuotient;
    String socialQuotient;
    String communicationQuotient;
    @TypeConverters(Converters.class)
    SubstanceUse substanceUse;


    @NonNull
    public String getDiaryDate() {
        return diaryDate;
    }

    public void setDiaryDate(@NonNull String diaryDate) {
        this.diaryDate = diaryDate;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public String getMoodQuotient() {
        return moodQuotient;
    }

    public void setMoodQuotient(String moodQuotient) {
        this.moodQuotient = moodQuotient;
    }

    public String getAppetiteQuotient() {
        return appetiteQuotient;
    }

    public void setAppetiteQuotient(String appetiteQuotient) {
        this.appetiteQuotient = appetiteQuotient;
    }

    public String getEatingQuotient() {
        return eatingQuotient;
    }

    public void setEatingQuotient(String eatingQuotient) {
        this.eatingQuotient = eatingQuotient;
    }

    public String getSocialQuotient() {
        return socialQuotient;
    }

    public void setSocialQuotient(String socialQuotient) {
        this.socialQuotient = socialQuotient;
    }

    public String getCommunicationQuotient() {
        return communicationQuotient;
    }

    public void setCommunicationQuotient(String communicationQuotient) {
        this.communicationQuotient = communicationQuotient;
    }

    public SubstanceUse getSubstanceUse() {
        return substanceUse;
    }

    public void setSubstanceUse(SubstanceUse substanceUse) {
        this.substanceUse = substanceUse;
    }

    public DiaryPage(@NonNull String diaryDate, List<Event> events, String moodQuotient, String appetiteQuotient, String eatingQuotient, String socialQuotient, String communicationQuotient, SubstanceUse substanceUse) {
        this.diaryDate = diaryDate;
        this.events = events;
        this.moodQuotient = moodQuotient;
        this.appetiteQuotient = appetiteQuotient;
        this.eatingQuotient = eatingQuotient;
        this.socialQuotient = socialQuotient;
        this.communicationQuotient = communicationQuotient;
        this.substanceUse = substanceUse;
    }

    @Override
    public String toString() {
        return "DiaryPage{" +
                "diaryDate='" + diaryDate + '\'' +
                ", events=" + events.toString() +
                ", moodQuotient='" + moodQuotient + '\'' +
                ", appetiteQuotient='" + appetiteQuotient + '\'' +
                ", eatingQuotient='" + eatingQuotient + '\'' +
                ", socialQuotient='" + socialQuotient + '\'' +
                ", communicationQuotient='" + communicationQuotient + '\'' +
                ", substanceUse=" + substanceUse +
                '}';
    }
}
