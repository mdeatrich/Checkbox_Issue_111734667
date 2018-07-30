package net.deatrich.app.checkbox_issue_111734667.data;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;

import net.deatrich.app.checkbox_issue_111734667.BR;
import net.deatrich.app.checkbox_issue_111734667.utilities.DateUtils;

import java.util.Date;


@Entity
public class DailyReport extends BaseObservable {


    @PrimaryKey
    @NonNull
    private Date reportDate;
    private boolean boolean1;
    private boolean boolean2;
    private boolean boolean3;

    private String string1;


    @Ignore
    public void copyValuesOf(DailyReport report) {
        setReportDate(report.getReportDate());
        setBoolean1(report.isBoolean1());
        setBoolean2(report.isBoolean2());
        setBoolean3(report.isBoolean3());
        setString1(report.getString1());

    }

    @Bindable
    @NonNull
    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(@NonNull Date reportDate) {
        this.reportDate = reportDate;
        notifyPropertyChanged(BR.reportDate);
    }

    @Bindable
    public boolean isBoolean1() {
        return boolean1;
    }

    public void setBoolean1(boolean boolean1) {
        this.boolean1 = boolean1;
        notifyPropertyChanged(BR.boolean1);
    }

    @Bindable
    public boolean isBoolean2() {
        return boolean2;
    }

    public void setBoolean2(boolean boolean2) {
        this.boolean2 = boolean2;
        notifyPropertyChanged(BR.boolean2);
    }

    @Bindable
    public boolean isBoolean3() {
        return boolean3;
    }

    public void setBoolean3(boolean boolean3) {
        this.boolean3 = boolean3;
        notifyPropertyChanged(BR.boolean3);
    }

    @Bindable
    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
        notifyPropertyChanged(BR.string1);
    }
}



