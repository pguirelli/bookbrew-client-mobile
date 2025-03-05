package com.example.bookbrew;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ProcessingFinalActivity extends AppCompatActivity {
    private ViewPager2 viewPager;
    private Button loginButton;
    private Button booksButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processing_final);

        viewPager = findViewById(R.id.viewPager);
        loginButton = findViewById(R.id.loginButton);
        booksButton = findViewById(R.id.booksButton);

        setupCarousel();
        setupButtons();
    }

    private void setupCarousel() {
        CarouselAdapter adapter = new CarouselAdapter();
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {}).attach();
    }

    private void setupButtons() {
        loginButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finishAffinity();
        });

        booksButton.setOnClickListener(v -> {
            Intent intent = new Intent(this, BooksActivity.class);
            startActivity(intent);
            finishAffinity();
        });
    }
}
