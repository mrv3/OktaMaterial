package com.vic3e.app.oktamaterial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
     /*  new DrawerBuilder()
                .withActivity(this)
                //.withRootView(R.id.drawer_layout)
                .withActionBarDrawerToggle(false)
                .build();*/

        //if you want to update the items at a later time it is recommended to keep it in a variable
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Tab one");
        SecondaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withIcon(R.drawable.ic_add_shopping_cart_black_48dp).withName("Tab Two");
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Tab three");

        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.blue_back_two)
                .addProfiles(
                        new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com").withIcon(getResources().getDrawable(R.drawable.ic_launcher_background))
                )
                .withSelectionListEnabledForSingleProfile(false)
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withFullscreen(false)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withTranslucentStatusBar(true)
                .withTranslucentNavigationBar(false)
                .withActionBarDrawerToggle(true)
                .withRootView(R.id.drawer_layout)
                .addDrawerItems(
                        item1,item3,
                        new DividerDrawerItem(),
                        item2,
                       new SecondaryDrawerItem()//.withName("tab two")
                    //    item3,
                      //  new
                )

                .build();
      //  result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(false);
    //    getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
       result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(true);

    }
}
