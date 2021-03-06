package com.vic3e.app.oktamaterial;

import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.StateListDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.balysv.materialmenu.MaterialMenuDrawable;
import com.mikepenz.crossfader.Crossfader;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.iconics.IconicsDrawable;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.MiniDrawer;
import com.mikepenz.materialdrawer.holder.BadgeStyle;
import com.mikepenz.materialdrawer.interfaces.OnCheckedChangeListener;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.SwitchDrawerItem;
import com.mikepenz.materialdrawer.model.ToggleDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.mikepenz.materialdrawer.model.interfaces.Nameable;
import com.mikepenz.materialize.util.SystemUtils;
import com.mikepenz.materialize.util.UIUtils;
import com.mikepenz.octicons_typeface_library.Octicons;
import com.vic3e.app.oktamaterial.Utils.CrossfadeWrapper;


//import com.mikepenz.crossfader.Crossfader;

public class MainActivity_new extends AppCompatActivity {


    private static final int PROFILE_SETTING = 1;

    //save our header or result
    private AccountHeader headerResult = null;
    private Drawer result = null;
    private MiniDrawer miniResult = null;
  //  private CrossfadeDrawerLayout crossFader;
    private Crossfader crossFader;
    private MaterialMenuDrawable materialMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   ToggleButton toggleBtn = (ToggleButton) findViewById(R.id.play_pause);
      //  StateListDrawable stateListDrawable = (StateListDrawable) toggleBtn.getBackground();
    //    AnimationDrawable animationDrawable = (AnimationDrawable) stateListDrawable.getCurrent();
  //      animationDrawable.selectDrawable(animationDrawable.getNumberOfFrames() - 1);

//
        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                // Handle your drawable state here
         //       materialMenu.animateState(newState);
                if (crossFader != null && crossFader.isCrossFaded()) {
                    materialMenu.animateIconState(MaterialMenuDrawable.IconState.BURGER);
                    crossFader.crossFade();
                } else {
                    materialMenu.animateIconState(MaterialMenuDrawable.IconState.BURGER);
                    crossFader.crossFade();
                }
            }
        });
        materialMenu = new MaterialMenuDrawable(this, Color.WHITE, MaterialMenuDrawable.Stroke.THIN);
        toolbar.setNavigationIcon(materialMenu);


        //set the back arrow in the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setTitle(R.string.drawer_item_mini_drawer);


        if(savedInstanceState == null) {
            android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.content_frame, new RandomFragment()).addToBackStack(null);
            //   getSupportActionBar().getTitle();
            //  FragmentTransaction fragment = transaction.replace(R.id.content_frame,FirstFragment);
            // .addToBackStack( "tag" );
            //transaction.commit();
            //   android.app.FragmentManager fragmentManager = getFragmentManager();
            //       android.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
            //    transaction.replace(R.id.content_frame, new FirstFragment());
            //    transaction.replace(R.id.content_frame, new ThirdFragment3());
            transaction.commit();
            //    ConnectionBuddy.getInstance().getConfiguration().getNetworkEventsCache().clearLastNetworkState(this);
        }


        // Create a few sample profile
        // NOTE you have to define the loader logic too. See the CustomApplication for more details
        final IProfile profile = new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com").withIcon("https://avatars3.githubusercontent.com/u/1476232?v=3&s=460");
        final IProfile profile2 = new ProfileDrawerItem().withName("Bernat Borras").withEmail("alorma@github.com").withIcon(Uri.parse("https://avatars3.githubusercontent.com/u/887462?v=3&s=460"));
        final IProfile profile3 = new ProfileDrawerItem().withName("Max Muster").withEmail("max.mustermann@gmail.com").withIcon(getResources().getDrawable(R.drawable.ic_launcher_background));
        final IProfile profile4 = new ProfileDrawerItem().withName("Felix House").withEmail("felix.house@gmail.com").withIcon(getResources().getDrawable(R.drawable.ic_launcher_background));
        final IProfile profile5 = new ProfileDrawerItem().withName("Mr. X").withEmail("mister.x.super@gmail.com").withIcon(getResources().getDrawable(R.drawable.ic_launcher_background)).withIdentifier(4);
        final IProfile profile6 = new ProfileDrawerItem().withName("Batman").withEmail("batman@gmail.com").withIcon(getResources().getDrawable(R.drawable.ic_launcher_background));

        // Create the AccountHeader
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                //.withHeaderBackground(R.drawable.header)
                .withHeaderBackground(R.drawable.blue_back_two)
                .withTranslucentStatusBar(false)
                .addProfiles(
                        profile
                 //       profile2,
                 //       profile3,
                //        profile4,
               //         profile5,
               //         profile6,
                        //don't ask but google uses 14dp for the add account icon in gmail but 20dp for the normal icons (like manage account)
                 //       new ProfileSettingDrawerItem().withName("Add Account").withDescription("Add new GitHub Account").withIcon(GoogleMaterial.Icon.gmd_add).withIdentifier(PROFILE_SETTING),
              //          new ProfileSettingDrawerItem().withName("Manage Account").withIcon(GoogleMaterial.Icon.gmd_settings)
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
                        //sample usage of the onProfileChanged listener
                        //if the clicked item has the identifier 1 add a new profile ;)
                        if (profile instanceof IDrawerItem && ((IDrawerItem) profile).getIdentifier() == PROFILE_SETTING) {
                            IProfile newProfile = new ProfileDrawerItem().withNameShown(true).withName("Batman").withEmail("batman@gmail.com").withIcon(getResources().getDrawable(R.drawable.ic_launcher_background));
                            if (headerResult.getProfiles() != null) {
                                //we know that there are 2 setting elements. set the new profile above them ;)
                                headerResult.addProfile(newProfile, headerResult.getProfiles().size() - 2);
                            } else {
                                headerResult.addProfiles(newProfile);
                            }
                        }

                        //false if you have not consumed the event and it should close the drawer
                        return false;
                    }
                })
               .withSelectionListEnabledForSingleProfile(false)
                .withSavedInstance(savedInstanceState)
                .build();

        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(false)
                .withAccountHeader(headerResult) //set the AccountHeader we created earlier for the header
                .addDrawerItems(
                        new PrimaryDrawerItem().withName(R.string.drawer_item_compact_header).withIcon(GoogleMaterial.Icon.gmd_brightness_5).withIdentifier(1),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_action_bar_drawer).withIcon(FontAwesome.Icon.faw_home).withBadge("22").withBadgeStyle(new BadgeStyle(Color.RED, Color.RED)).withIdentifier(2).withSelectable(false),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_multi_drawer).withIcon(FontAwesome.Icon.faw_gamepad).withIdentifier(3),
                        new PrimaryDrawerItem().withName(R.string.drawer_item_non_translucent_status_drawer).withIcon(FontAwesome.Icon.faw_eye).withIdentifier(4),
                        new PrimaryDrawerItem().withDescription("A more complex sample").withName(R.string.drawer_item_advanced_drawer).withIcon(GoogleMaterial.Icon.gmd_adb).withIdentifier(5),
                        new SectionDrawerItem().withName(R.string.drawer_item_section_header),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_open_source).withIcon(FontAwesome.Icon.faw_github),
                        new SecondaryDrawerItem().withName(R.string.drawer_item_contact).withIcon(GoogleMaterial.Icon.gmd_format_color_fill).withTag("Bullhorn"),
                        new DividerDrawerItem(),
                        new SwitchDrawerItem().withName("Switch").withIcon(Octicons.Icon.oct_tools).withChecked(true).withOnCheckedChangeListener(onCheckedChangeListener),
                        new ToggleDrawerItem().withName("Toggle").withIcon(Octicons.Icon.oct_tools).withChecked(true).withOnCheckedChangeListener(onCheckedChangeListener)
                ) // add the items we want to use with our Drawer
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                    //    if (drawerItem instanceof Nameable) {
                      //      Toast.makeText(MainActivity_new.this, ((Nameable) drawerItem).getName().getText(MainActivity_new.this), Toast.LENGTH_SHORT).show();
                   ///     }
                        if (drawerItem != null) {

                            if (drawerItem.getIdentifier() == 1) {
                                Fragment f = RandomFragment.newInstance("Demo");
                                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, f).addToBackStack(null).commit();

                            } else if (drawerItem.getIdentifier() == 3) {
                                Fragment f2 = RandomFragment2.newInstance("Demo2");
                                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, f2).addToBackStack(null).commit();

                            }
                        }
                        return false;
                    }
                })
                .withGenerateMiniDrawer(true)
         //       .withToolbar(toolbar)
                .withSavedInstance(savedInstanceState)
                // build only the view of the Drawer (don't inflate it automatically in our layout which is done with .build())
                .buildView();

        //the MiniDrawer is managed by the Drawer and we just get it to hook it into the Crossfader
        miniResult = result.getMiniDrawer();

      //  crossFader.getCrossFadeSlidingPaneLayout().setShadowResourceLeft(R.drawable.material_drawer_shadow_left);
     //   crossFader.getFirst().setBackgroundColor(Color.WHITE);
       // crossFader.getSecond().setBackgroundColor(Color.BLUE);

        //get the widths in px for the first and second panel
        int firstWidth = (int) UIUtils.convertDpToPixel(300, this);
        int secondWidth = (int) UIUtils.convertDpToPixel(72, this);

        //create and build our crossfader (see the MiniDrawer is also builded in here, as the build method returns the view to be used in the crossfader)
        //the crossfader library can be found here: https://github.com/mikepenz/Crossfader
        crossFader = new Crossfader()
            //    .withContent(findViewById(R.id.crossfade_content))
                .withContent(findViewById(R.id.content_frame))
                .withFirst(result.getSlider(), firstWidth)
                .withSecond(miniResult.build(this), secondWidth)
                .withGmailStyleSwiping()
                .withSavedInstance(savedInstanceState)
                .build();
       // materialMenu.setTransformationOffset(MaterialMenuDrawable.AnimationState, 0 value);
        //define the crossfader to be used with the miniDrawer. This is required to be able to automatically toggle open / close
        miniResult.withCrossFader(new CrossfadeWrapper(crossFader));

        //define a shadow (this is only for normal LTR layouts if you have a RTL app you need to define the other one
        crossFader.getCrossFadeSlidingPaneLayout().setShadowResourceLeft(R.drawable.material_drawer_shadow_left);
    //    crossFader.getCrossFadeSlidingPaneLayout().setShadowResourceLeft(R.drawable.material_drawer_shadow_left);
        crossFader.getFirst().setBackgroundColor(Color.WHITE);
        crossFader.getSecond().setBackgroundColor(Color.WHITE);

    }

    private OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(IDrawerItem drawerItem, CompoundButton buttonView, boolean isChecked) {
            if (drawerItem instanceof Nameable) {
                Log.i("material-drawer", "DrawerItem: " + ((Nameable) drawerItem).getName() + " - toggleChecked: " + isChecked);
            } else {
                Log.i("material-drawer", "toggleChecked: " + isChecked);
            }
        }
    };

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //add the values which need to be saved from the drawer to the bundle
        outState = result.saveInstanceState(outState);
        //add the values which need to be saved from the accountHeader to the bundle
        outState = headerResult.saveInstanceState(outState);
        //add the values which need to be saved from the crossFader to the bundle
        outState = crossFader.saveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        if (SystemUtils.getScreenOrientation() == Configuration.ORIENTATION_LANDSCAPE) {
            inflater.inflate(R.menu.embedded, menu);
            menu.findItem(R.id.menu_1).setIcon(new IconicsDrawable(this, GoogleMaterial.Icon.gmd_sort).color(Color.WHITE).actionBar());
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (crossFader != null && crossFader.isCrossFaded()) {
            crossFader.crossFade();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle the click on the back arrow click
        switch (item.getItemId()) {
            case R.id.menu_1:
                crossFader.crossFade();
               // Fragment f = RandomFragment.newInstance("Demo");
           //     getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, f).commit();
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}