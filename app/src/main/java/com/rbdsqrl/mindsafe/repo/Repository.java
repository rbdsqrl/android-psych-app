package com.rbdsqrl.mindsafe.repo;

import android.app.Application;

public class Repository {
    AppDatabase appDatabase;
    Application application;

    public Repository(Application application) {
        this.application = application;
        this.appDatabase = AppDatabase.getAppDatabase(application);
    }
}
