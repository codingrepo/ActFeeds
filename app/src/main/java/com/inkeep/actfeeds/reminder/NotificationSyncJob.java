package com.inkeep.actfeeds.reminder;

import android.content.Context;
import android.support.annotation.NonNull;


import com.evernote.android.job.DailyJob;
import com.evernote.android.job.JobRequest;

import java.util.concurrent.TimeUnit;

/**
 * Created by KavitaPC on 12/4/2017.
 *
 */

public class NotificationSyncJob extends DailyJob {

    public static final String TAG = "Notification_Job_Tag";


    public static void schedule() {


        DailyJob.schedule(new JobRequest.Builder(TAG), TimeUnit.HOURS.toMillis(9), TimeUnit.HOURS.toMillis(12));
    }


    @NonNull
    @Override
    protected DailyJobResult onRunDailyJob(@NonNull Params params) {
        Context context = getContext();
        ReminderTask.executeTask(context, ReminderTask.ACTION_SHOW_REMINDER);
        return DailyJobResult.SUCCESS;
    }



}
/*public class DemoSyncJob extends Job {

    public static final String TAG = "job_demo_tag";

    @Override
    @NonNull
    protected Result onRunJob(Params params) {
        // run your job here
        return Result.SUCCESS;
    }

    public static void scheduleJob() {
        new JobRequest.Builder(DemoSyncJob.TAG)
                .setExecutionWindow(30_000L, 40_000L)
                .build()
                .schedule();
    }*/
//}