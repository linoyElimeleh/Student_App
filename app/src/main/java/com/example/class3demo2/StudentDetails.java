package com.example.class3demo2;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;


public class StudentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details_view);
        this.setTitle("Students Details");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        // Get the intent from the previous page
        Intent oldIntent = getIntent();

        Boolean check = oldIntent.getBooleanExtra("check", false);
        ImageView checkImg = findViewById(R.id.sd_check_img);
        if (check){checkImg.setImageResource(android.R.drawable.checkbox_on_background);}



        // Get previous data
        setTextViewWithPreviousItem(oldIntent, "name", R.id.sd_value_name);
        setTextViewWithPreviousItem(oldIntent, "id", R.id.sd_value_id);
        setTextViewWithPreviousItem(oldIntent, "phone", R.id.sd_value_phone);
        setTextViewWithPreviousItem(oldIntent, "add", R.id.sd_value_add);

        // Set the intent page
        oldIntent.setClass(this, StudentEdit.class);

        // On edit action
        Button editButton = findViewById(R.id.sd_edit_btn);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(oldIntent);
            }
        });
    }

    /**
     * This function get an id, extra and intent the set the data from a text view
     *
     * @param intent
     * @param extra
     * @param id
     */
    private void setTextViewWithPreviousItem(Intent intent, String extra, int id) {
        String stringExtra = intent.getStringExtra(extra);
        TextView textView = findViewById(id);
        textView.setText(stringExtra);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}