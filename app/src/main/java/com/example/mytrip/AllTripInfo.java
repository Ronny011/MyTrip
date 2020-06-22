package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AllTripInfo extends AppCompatActivity {

    private TextView tvLink;
    private String full_text = "";
    private TextView tvDesc;
    private TextView tvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_trip_info);

        tvTitle = findViewById(R.id.tv_title);
        tvTitle.setTypeface(null, Typeface.BOLD);
        tvDesc = findViewById(R.id.tv_desc);
        tvLink = findViewById(R.id.tv_link);
        final Button more = findViewById(R.id.more_button);

        Intent i = getIntent();
        GetTripInfo(i.getIntExtra("tripId", 0));

        more.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tvDesc.setText(full_text);
                more.setVisibility(View.GONE);
            }
        });
    }

    private void GetTripInfo(int nTripId) {
        final int length = 650;// length of trip description
        int description = R.string.app_name;// default string
        switch (nTripId) {
            case 0:
                description = R.string.shofet_desc;
                full_text = this.getResources().getString(description);
                tvTitle.setText(R.string.shofet_title);
                tvDesc.setText(this.getResources().getString(description).substring(0, length));
                tvLink.setText(R.string.shofet_link);
                tvLink.setMovementMethod(LinkMovementMethod.getInstance());
                //Linkify.addLinks(tvLink, Linkify.WEB_URLS);
                break;
            case 1:
                description = R.string.dor_desc;
                full_text = this.getResources().getString(description);
                tvTitle.setText(R.string.dor_title);
                tvDesc.setText(this.getResources().getString(description).substring(0, length));
                tvLink.setText(R.string.dor_link);
                //Linkify.addLinks(tvLink, Linkify.WEB_URLS);
                break;
            case 2:
                description = R.string.sorek_desc;
                full_text = this.getResources().getString(description);
                tvTitle.setText(R.string.sorek_title);
                tvDesc.setText(this.getResources().getString(description).substring(0, length));
                tvLink.setText(R.string.sorek_link);
                Linkify.addLinks(tvLink, Linkify.WEB_URLS);
                break;
            case 3:
                description = R.string.red_desc;
                full_text = this.getResources().getString(description);
                tvTitle.setText(R.string.red_title);
                tvDesc.setText(this.getResources().getString(description).substring(0, length));
                tvLink.setText(R.string.red_link);
                Linkify.addLinks(tvLink, Linkify.WEB_URLS);
                break;
            case 4:
                description = R.string.ayun_desc;
                full_text = this.getResources().getString(description);
                tvTitle.setText(R.string.ayun_title);
                tvDesc.setText(this.getResources().getString(description).substring(0, length));
                tvLink.setText(R.string.ayun_link);
                Linkify.addLinks(tvLink, Linkify.WEB_URLS);
                break;
            case 5:
                description = R.string.gedi_desc;
                full_text = this.getResources().getString(description);
                tvTitle.setText(R.string.gedi_title);
                tvDesc.setText(this.getResources().getString(description).substring(0, length));
                tvLink.setText(R.string.gedi_link);
                Linkify.addLinks(tvLink, Linkify.WEB_URLS);
                break;
            case 6:
                description = R.string.ofir_desc;
                full_text = this.getResources().getString(description);
                tvTitle.setText(R.string.ofir_title);
                tvDesc.setText(this.getResources().getString(description).substring(0, length));
                tvLink.setText(R.string.ofir_link);
                Linkify.addLinks(tvLink, Linkify.WEB_URLS);
                break;
            case 7:
                description = R.string.sharon_desc;
                full_text = this.getResources().getString(description);
                tvTitle.setText(R.string.sharon_title);
                tvDesc.setText(this.getResources().getString(description).substring(0, length));
                tvLink.setText(R.string.sharon_link);
                Linkify.addLinks(tvLink, Linkify.WEB_URLS);
                break;
            case 8:
                description = R.string.meron_desc;
                full_text = this.getResources().getString(description);
                tvTitle.setText(R.string.meron_title);
                tvDesc.setText(this.getResources().getString(description).substring(0, length));
                tvLink.setText(R.string.meron_link);
                Linkify.addLinks(tvLink, Linkify.WEB_URLS);
                break;
            case 9:
                description = R.string.snir_desc;
                full_text = this.getResources().getString(description);
                tvTitle.setText(R.string.snir_title);
                tvDesc.setText(this.getResources().getString(description).substring(0, length));
                tvLink.setText(R.string.snir_link);
                Linkify.addLinks(tvLink, Linkify.WEB_URLS);
                break;
            case 10:
                description = R.string.cave_desc;
                full_text = this.getResources().getString(description);
                tvTitle.setText(R.string.cave_title);
                tvDesc.setText(this.getResources().getString(description).substring(0, length));
                tvLink.setText(R.string.cave_link);
                Linkify.addLinks(tvLink, Linkify.WEB_URLS);
                break;
        }
    }
}
