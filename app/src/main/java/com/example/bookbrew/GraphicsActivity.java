package com.example.bookbrew;

import android.view.View;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import java.util.ArrayList;

public class GraphicsActivity extends AppCompatActivity {
    private static LineChart lineChart;
    private static BarChart barChart;
    private static RadioGroup chartTypeGroup;
    private Button nextButton;

    private static LineData lineData;
    private static BarData barData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphics);

        initializeViews();
        setupCharts();
        setupListeners();
    }

    private void initializeViews() {
        lineChart = findViewById(R.id.lineChart);
        barChart = findViewById(R.id.barChart);
        chartTypeGroup = findViewById(R.id.chartTypeGroup);
        nextButton = findViewById(R.id.nextButton);
    }

    private void setupCharts() {
        setupLineChart();
        setupBarChart();
        barChart.setVisibility(View.GONE);
    }

    private void setupListeners() {
        chartTypeGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.radioLine) {
                lineChart.setVisibility(View.VISIBLE);
                barChart.setVisibility(View.GONE);
            } else {
                lineChart.setVisibility(View.GONE);
                barChart.setVisibility(View.VISIBLE);
            }
        });

        nextButton.setOnClickListener(v -> {
            Intent intent = new Intent(GraphicsActivity.this, FinalActivity.class);
            intent.putExtra("selectedChart", chartTypeGroup.getCheckedRadioButtonId() == R.id.radioLine ? "line" : "bar");
            startActivity(intent);
        });
    }

    private void setupLineChart() {
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 4));
        entries.add(new Entry(1, 8));
        entries.add(new Entry(2, 6));
        entries.add(new Entry(3, 10));
        entries.add(new Entry(4, 7));

        LineDataSet dataSet = new LineDataSet(entries, "Sample Data");
        lineData = new LineData(dataSet);
        lineChart.setData(lineData);
        lineChart.invalidate();
    }

    private void setupBarChart() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0, 4));
        entries.add(new BarEntry(1, 8));
        entries.add(new BarEntry(2, 6));
        entries.add(new BarEntry(3, 10));
        entries.add(new BarEntry(4, 7));

        BarDataSet dataSet = new BarDataSet(entries, "Sample Data");
        barData = new BarData(dataSet);
        barChart.setData(barData);
        barChart.invalidate();
    }

    public static LineData getLineData() {
        return lineData;
    }

    public static BarData getBarData() {
        return barData;
    }
}
