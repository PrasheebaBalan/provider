package com.example.provider;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @SuppressLint("Range")
    public void onClickShowDetails(View view) {
        // inserting complete table details in this text field
        TextView resultView = findViewById(R.id.res);

        // creating a cursor object of the
        // content URI
        Cursor cursor = getContentResolver().query(Uri.parse("content://com.demo.user.provider/users"), null, null, null, null);

        // iteration of the cursor
        // to print whole table
        if(cursor != null) {
            if (cursor.moveToFirst()) {
                StringBuilder strBuild = new StringBuilder();
                do {
                    strBuild.append("\n").append(cursor.getString(cursor.getColumnIndex("id"))).append("-").append(cursor.getString(cursor.getColumnIndex("name")));
                } while (cursor.moveToNext());
                resultView.setText(strBuild.toString());
            } else {
                resultView.setText("No Records Found");
            }
            cursor.close();
        } else {
            resultView.setText("Cursor is null");
        }
    }
}
