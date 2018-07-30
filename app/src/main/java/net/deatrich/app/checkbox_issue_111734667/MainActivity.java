package net.deatrich.app.checkbox_issue_111734667;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.deatrich.app.checkbox_issue_111734667.data.DailyReport;
import net.deatrich.app.checkbox_issue_111734667.utilities.DateUtils;
import net.deatrich.app.checkbox_issue_111734667.viewmodels.ReportViewModel;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

public class MainActivity extends AppCompatActivity implements ReportViewModel.OnReportSaved{


    ReportViewModel reportViewModel;
    DailyReport dailyReport;
    Date mReportDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        reportViewModel = ViewModelProviders.of(Objects.requireNonNull(this)).get(ReportViewModel.class);


        // create a fake report, if it's already in the db it'll get updated
        Calendar cal;
        cal = Calendar.getInstance();
        cal.set(Calendar.MONTH, 0);
        cal.set(Calendar.DAY_OF_MONTH, 1);
        cal.set(Calendar.YEAR, 2018);

        mReportDate = DateUtils.getDateAtMidnight(cal.getTime());

        dailyReport = new DailyReport();
        dailyReport.setReportDate(mReportDate);
        dailyReport.setBoolean1(true);
        dailyReport.setBoolean2(true);
        dailyReport.setBoolean3(false);
        dailyReport.setString1("String 1");

        reportViewModel.copyReport(dailyReport);
        reportViewModel.saveReport(this);

    }

    public void loadFakeReport(View view) {
        loadReport (mReportDate);
    }

    protected void loadReport(Date reportDate) {
        Intent intent = new Intent(this, ReportActivity.class);

        intent.putExtra(ReportActivity.REPORT_DATE_KEY, reportDate);
        startActivity(intent);
    }

    @Override
    public void onReportSaved() {

    }
}
