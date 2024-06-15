package com.example.foodordering.adapterclass;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

import com.example.foodordering.R;

public class viewpageradapter extends PagerAdapter{

    Context context;
    int image[]={
        R.drawable.onboard_pic1,
        R.drawable.onboard_pic2,
        R.drawable.onboard_pic3

    };
    int heading[]={
        R.string.Heading1,
        R.string.Heading2,
        R.string.Heading3
    };
    int description[]={
            R.string.Onboard_1,
            R.string.Onboard_2,
            R.string.Onboard_3
    };

    public viewpageradapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.onboarding_layout, container, false);
        ImageView slidetitleimage = (ImageView) view.findViewById(R.id.image);
        TextView slideheading = (TextView) view.findViewById(R.id.heading);
        TextView slidedescription = (TextView) view.findViewById(R.id.description);

        slidetitleimage.setImageResource(image[position]);
        slideheading.setText(heading[position]);
        slidedescription.setText(description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
