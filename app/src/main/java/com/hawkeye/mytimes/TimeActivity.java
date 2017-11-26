package com.hawkeye.mytimes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class TimeActivity extends AppCompatActivity {
    UserInfo userInfo = new UserInfo();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        userInfo.createSharePref(TimeActivity.this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.activity_times_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_log_out:
//                Toast.makeText(this, "nimic", Toast.LENGTH_SHORT).show();
                logout();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout() {
        userInfo.logout();
        Intent intent = new Intent(TimeActivity.this,LoginActivity.class);
        startActivity(intent);
        this.finish();
    }
}
