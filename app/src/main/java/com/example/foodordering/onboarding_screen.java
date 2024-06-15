package com.example.foodordering;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.foodordering.adapterclass.viewpageradapter;

public class onboarding_screen extends AppCompatActivity {

    ViewPager mSideViewPager;
    LinearLayout DotLayout;
    Button  next, skip;
    TextView[] dots;

    viewpageradapter viewpageradapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_onboarding_screen);

        next=findViewById(R.id.nxtbtn);
        skip=findViewById(R.id.skipbtn);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mSideViewPager= (ViewPager) findViewById(R.id.slideViewPager);
        DotLayout= (LinearLayout) findViewById(R.id.indicator_layout);
        viewpageradapter = new viewpageradapter(this);
        mSideViewPager.setAdapter(viewpageradapter);
    }
    public void setUpindicator(int position){
        dots= new TextView[3];
        DotLayout.removeAllViews();
        for(int i=0; i<dots.length; i++){
            dots[i]=new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.white,getApplicationContext().getTheme()));
            DotLayout.addView(dots[i]);
        }
        dots[position].setTextColor(getResources().getColor(R.color.main,getApplicationContext().getTheme()));
    }
    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setUpindicator(position);

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}