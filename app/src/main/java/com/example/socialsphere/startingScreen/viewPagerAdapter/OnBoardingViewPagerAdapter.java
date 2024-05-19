package com.example.socialsphere.startingScreen.viewPagerAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.airbnb.lottie.LottieAnimationView;
import com.example.socialsphere.R;

public class OnBoardingViewPagerAdapter extends PagerAdapter {

    Context context;
    int sliderAnimations[] = {R.raw.interact_with_world, R.raw.chat_with_anyone, R.raw.share_picture};
    int sliderTitle[] = {R.string.Interact_Title, R.string.Chat_Title, R.string.ShareImage_Title};
    int sliderDescription[] = {R.string.Interact_Description, R.string.Chat_Description, R.string.ShareImage_Description};

    public OnBoardingViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return sliderTitle.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (LinearLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.onboarding_items_layout, container, false);

        LottieAnimationView lottieAnimationView = view.findViewById(R.id.onBoardingAnimation);
        TextView headingTextView = view.findViewById(R.id.onBoardingHeadingText);
        TextView descriptionTextView = view.findViewById(R.id.onBoardingSubHeadingText);

        lottieAnimationView.setAnimation(sliderAnimations[position]);
        headingTextView.setText(sliderTitle[position]);
        descriptionTextView.setText(sliderDescription[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
