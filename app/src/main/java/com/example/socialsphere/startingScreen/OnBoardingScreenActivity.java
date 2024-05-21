package com.example.socialsphere.startingScreen;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.socialsphere.R;
import com.example.socialsphere.authScreen.LoginActivity;
import com.example.socialsphere.authScreen.SignupActivity;
import com.example.socialsphere.databinding.ActivityOnBoardingScreenBinding;
import com.example.socialsphere.startingScreen.viewPagerAdapter.OnBoardingViewPagerAdapter;

public class OnBoardingScreenActivity extends AppCompatActivity {
    private ActivityOnBoardingScreenBinding binding;
    private OnBoardingViewPagerAdapter viewPagerAdapter;
    TextView dots[] = new TextView[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityOnBoardingScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setDotIndicator(position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        binding.nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getItem(0)<2){
                    binding.viewPager.setCurrentItem(getItem(1), true);
                }else{
                    startActivity(new Intent(OnBoardingScreenActivity.this, SignupActivity.class));
                    finish();
                }
            }
        });

        binding.skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(OnBoardingScreenActivity.this, LoginActivity.class));
                finish();
            }
        });

        viewPagerAdapter = new OnBoardingViewPagerAdapter(this);
        binding.viewPager.setAdapter(viewPagerAdapter);

        setDotIndicator(0);


    }

    private void setDotIndicator(int position) {
        dots = new TextView[3];
        binding.dotIndicator.removeAllViews();

        for (int i = 0; i < dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226"));
            dots[i].setTextSize(35);
            dots[i].setTextColor(getResources().getColor(R.color.pink_bg));
            binding.dotIndicator.addView(dots[i]);
        }

        dots[position].setTextColor(getResources().getColor(R.color.myPink));
    }

    private int getItem(int i){
        return binding.viewPager.getCurrentItem() + i;
    }
}