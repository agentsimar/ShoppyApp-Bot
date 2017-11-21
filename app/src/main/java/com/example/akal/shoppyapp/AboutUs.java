package com.example.akal.shoppyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Shoppy");
        setSupportActionBar(toolbar);

        PrimaryDrawerItem shop = new PrimaryDrawerItem().withIdentifier(0).withName("Shop").withIcon(R.mipmap.ic_launcher);
        final PrimaryDrawerItem about_us = new PrimaryDrawerItem().withIdentifier(1).withName("About Us");
        PrimaryDrawerItem faq_page = new PrimaryDrawerItem().withIdentifier(2).withName("Contact us");
        PrimaryDrawerItem chat_bot  = new PrimaryDrawerItem().withIdentifier(3).withName("Chatbot");

        final Drawer drawer = new DrawerBuilder()
                .withActivity(this)
                .addDrawerItems(shop, about_us, faq_page, chat_bot)
                .withDrawerWidthDp(250)
                .withActionBarDrawerToggle(true)
                .withToolbar(toolbar)
                .build();

        drawer.setOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                if (drawerItem.getIdentifier() == 0) {
                    Intent intent = new Intent(AboutUs.this, MainAppPage.class);
                    startActivity(intent);
                    drawer.closeDrawer();
                } else if (drawerItem.getIdentifier() == 1) {
                    Intent intent = new Intent(AboutUs.this, AboutUs.class);
                    startActivity(intent);
                    drawer.closeDrawer();
                } else if (drawerItem.getIdentifier() == 2) {
                    Intent intent = new Intent(AboutUs.this, FaqPage.class);
                    startActivity(intent);
                    drawer.closeDrawer();
                }
                else if (drawerItem.getIdentifier() == 3) {
                    Intent intent = new Intent(AboutUs.this, ChatBot.class);
                    startActivity(intent);
                    drawer.closeDrawer();
                }
                return true;
            }
        });
    }
}