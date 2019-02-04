/**
 * Haven Programming Team
 * Brendan Foley, Nicholas Barranco, Raymond Santiago, Alex Reyes
 * Started: 1/7/2019
 *
 * Music streaming app aimed at increasing revenue for artists on streaming platforms
 *
 * This file handles the main activity the user stays on for most of the usage
 */

package com.example.brend.haven2;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * The main activity of our program. First screen seen by user
 * @extends: default extension of activities
 * @implements: an interface for using a sliding navigation drawer
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView mTextMessage;  // Current filler, displays reactive text for current screen
                                        // will be replaced with meaningful info at a later date

    // Listener for the bottom navigation tabs
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        /**
         * Handles clicks on the navigation drawer
         * @param item - the item that has been clicked
         * @return - true once the clicked item has finished operation, false otherwise
         */
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_trending);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_library);
                    return true;
            }
            return false;
        }
    };

    /**
     * Default onCreate method. Sets up the navigation drawer and sliding drawer
     * @param savedInstanceState - the last state that the user left the app in
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    /**
     * When back is pressed ensure that the drawer is closed
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * Creates the menu of the sliding drawer
     * @param menu - the menu
     * @return - tells us that it has inflated the menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * When '...' is clicked, determine if "Settings" is then clicked
     * @param item - the item that has been clicked on
     * @return - true if the setting button has been clicked, otherwise continue
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * STILL NEEDS TO BE IMPLEMENTED FULLY
     * Handles clicks on items in the sliding menu
     * @param item - the item that has been clicked
     * @return - tells us that the operation completed successfully
     */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.optionOne) {

        } else if (id == R.id.optionTwo) {

        } else if (id == R.id.optionThree) {

        } else if (id == R.id.optionFour) {

        } else if (id == R.id.optionFive) {

        } else if (id == R.id.optionSix) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
