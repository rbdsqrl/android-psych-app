package com.rbdsqrl.mindsafe.repo;

import android.os.AsyncTask;

public abstract class DBOperation {
    abstract void run();
    public void execute() {
        run();
    }

    public static void asyncTask(final DBOperation dbOperation) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                dbOperation.execute();
                return null;
            }
        }.execute();
    }

}
