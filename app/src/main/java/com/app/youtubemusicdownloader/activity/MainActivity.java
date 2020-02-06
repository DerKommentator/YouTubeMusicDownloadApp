package com.app.youtubemusicdownloader.activity;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import com.app.youtubemusicdownloader.R;
import com.app.youtubemusicdownloader.fragments.CreateURLListFragment;
import com.app.youtubemusicdownloader.fragments.DownloadMusicFragment;
import com.app.youtubemusicdownloader.fragments.HistoryFragment;

public class MainActivity extends AppCompatActivity {

    private ArrayList<EditText> editText_ArrayList= new ArrayList<>();
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private int[] tabIcons = {
            R.drawable.ic_playlist_add,
            R.drawable.ic_get_app,
            R.drawable.ic_query_builder
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }

    // XML onClick Methods
    public void onDelete(View view)
    {
        ViewGroup parent = (ViewGroup) view.getParent();
        parent.setVisibility(View.GONE);
    }

    public void addEditText(View view)
    {

        if(!editText_ArrayList.contains((EditText) view))
        {
            editText_ArrayList.add((EditText) view);
            //Log.d("EditTextList", "" + editText_ArrayList.size());
        }
    }

    public void fetch_button(View view) //TODO  fetch button
    {
        editTexttoString(editText_ArrayList);
    }

    public void editTexttoString(ArrayList<EditText> arrayList)
    {
        for(EditText editText: arrayList)
        {
            Log.d("EditText", editText.getText().toString());
        }
    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(tabIcons[0]);
        tabLayout.getTabAt(1).setIcon(tabIcons[1]);
        tabLayout.getTabAt(2).setIcon(tabIcons[2]);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new CreateURLListFragment(), "Create DL List");
        adapter.addFrag(new DownloadMusicFragment(), "Download Music");
        adapter.addFrag(new HistoryFragment(), "History");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
