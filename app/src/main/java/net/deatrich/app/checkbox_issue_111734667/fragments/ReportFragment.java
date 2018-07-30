package net.deatrich.app.checkbox_issue_111734667.fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import net.deatrich.app.checkbox_issue_111734667.R;
import net.deatrich.app.checkbox_issue_111734667.databinding.CheckboxesOneBinding;
import net.deatrich.app.checkbox_issue_111734667.databinding.CheckboxesTwoBinding;
import net.deatrich.app.checkbox_issue_111734667.viewmodels.ReportViewModel;

import java.util.Date;
import java.util.Objects;


public class ReportFragment extends Fragment {

    private static final String TAG = ReportFragment.class.getSimpleName();


    public final static String LAYOUT_ID_KEY = "layoutId";
    public final static String REPORT_DATE_KEY = "reportDate";


    // Store instance variables
    private int layoutId;


    //shared
    private static Date reportDate;

    //each fragment (viewpager page) shares the same reportDate and viewModel
    private ReportViewModel reportViewModel;

    //bindings
    //section data bindings
    private ViewDataBinding reportBinding = null;


    public ReportFragment() {
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        layoutId = getArguments().getInt(LAYOUT_ID_KEY, R.layout.checkboxes_one);
        reportDate = (Date) getArguments().getSerializable(REPORT_DATE_KEY);


        Log.d(TAG, "onCreate, layoutId= " + layoutId);
        Log.d(TAG, "onCreate, reportDate= " + reportDate);

        reportViewModel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(ReportViewModel.class);


    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d(TAG, "onActivityCreated, reportDate= " + reportViewModel.getDailyReportDate());


    }


    // newInstance constructor for creating fragment with arguments
    public static ReportFragment newInstance(int layoutResId, Date reportDate) {

        ReportFragment dbtFrag = new ReportFragment();

        Bundle args = new Bundle();
        args.putInt(LAYOUT_ID_KEY, layoutResId);
        args.putSerializable(REPORT_DATE_KEY, reportDate);


        Log.d(TAG, "newInstance, reportDate= " + reportDate);

        dbtFrag.setArguments(args);
        return dbtFrag;
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle args) {
        args.putInt(LAYOUT_ID_KEY, layoutId);
        super.onSaveInstanceState(args);


    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = null;
        CheckboxesOneBinding checkboxesOneBinding;
        CheckboxesTwoBinding checkboxesTwoBinding;



            switch (layoutId) {
                case R.layout.checkboxes_one:
                    checkboxesOneBinding = DataBindingUtil.inflate(inflater, layoutId, container, false);

                    if (checkboxesOneBinding != null) {
                        view = checkboxesOneBinding.getRoot();
                        checkboxesOneBinding.setReport(reportViewModel.getDailyReport());

                        Log.d(TAG, "onCreateView, constraint view,  reportDate= " + reportDate);
                    }
                    break;

                case R.layout.checkboxes_two:
                    checkboxesTwoBinding = DataBindingUtil.inflate(inflater, layoutId, container, false);

                    if (checkboxesTwoBinding != null) {
                        view = checkboxesTwoBinding.getRoot();
                        checkboxesTwoBinding.setReport(reportViewModel.getDailyReport());

                        Log.d(TAG, "onCreateView, linear view,  reportDate= " + reportDate);
                    }
                    break;

        }


        return view;

    }


}