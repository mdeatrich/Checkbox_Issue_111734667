package net.deatrich.app.checkbox_issue_111734667.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import net.deatrich.app.checkbox_issue_111734667.R;
import net.deatrich.app.checkbox_issue_111734667.fragments.ReportFragment;

import java.util.ArrayList;
import java.util.Date;


public class ReportViewPagerAdapter extends FragmentPagerAdapter {

    private static ArrayList<Integer> mLayoutIds = new ArrayList<>();
    private static ArrayList<String> mSectionTitles = new ArrayList<>();
    private static ArrayList<ReportFragment> mReportFragments = new ArrayList<>();

    private static int numSections;
    private static Date reportDate;


    private final FragmentManager fragmentManager;


    public ReportViewPagerAdapter(FragmentManager fm, Context context, Date reportDate) {
        super(fm);
        fragmentManager = fm;

        this.reportDate = reportDate;

        if (reportDate == null)
            return;

        if (mReportFragments.size() == 0) {
            mLayoutIds.add(R.layout.checkboxes_one);
            mSectionTitles.add("Checkboxes One");

            mReportFragments.add(ReportFragment.newInstance(R.layout.checkboxes_one, reportDate));
        }

        if (mReportFragments.size() == 1) {
            mLayoutIds.add(R.layout.checkboxes_two);
            mSectionTitles.add("Checkboxes Two");

            mReportFragments.add(ReportFragment.newInstance(R.layout.checkboxes_two, reportDate));
        }


        numSections = mLayoutIds.size();

    }

    @Override
    public int getCount() {

        return numSections;
    }


    @Override
    public Fragment getItem(int sectionIndex) {

        return mReportFragments.get(sectionIndex);

    }

    // Returns the page title for the top indicator
    @Override
    public CharSequence getPageTitle(int position) {

        if (mSectionTitles != null) {
            int numSections = mSectionTitles.size();

            if ((numSections > 0) && (position < numSections))
                return mSectionTitles.get(position);

        }

        return "Page " + position;

    }
}
