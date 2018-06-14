package com.rbdsqrl.mindsafe.view;

import com.rbdsqrl.mindsafe.pojo.Event;
import com.rbdsqrl.mindsafe.repo.DiaryPage;
import com.rbdsqrl.mindsafe.util.DateTimeUtil;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;

public class MPage {
    public static DiaryPage createPage(@NonNull String diaryDate, List<Event> events, String moodQuotient, String appetiteQuotient, String eatingQuotient, String socialQuotient, String communicationQuotient, DiaryPage.SubstanceUse substanceUse){
        return new DiaryPage(DateTimeUtil.getCurrentDateFormatted(),new ArrayList<Event>(), null, null, null, null, null,DiaryPage.SubstanceUse.NONE);

    }
}
