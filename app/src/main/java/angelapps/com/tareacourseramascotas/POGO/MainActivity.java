package angelapps.com.tareacourseramascotas.POGO;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import angelapps.com.tareacourseramascotas.Adapter.PageAdapter;
import angelapps.com.tareacourseramascotas.Fragments.PerfilFragment;
import angelapps.com.tareacourseramascotas.Fragments.ReciclerViewFragment;
import angelapps.com.tareacourseramascotas.R;
import angelapps.com.tareacourseramascotas.menus.AboutActivity;
import angelapps.com.tareacourseramascotas.menus.ContactoActivity;
import angelapps.com.tareacourseramascotas.pantallas.Favs;

public class MainActivity extends AppCompatActivity {

    private Toolbar   toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
     //view types


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar =   (Toolbar)   findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(toolbar !=null){
            setSupportActionBar(toolbar);
            toolbar.setTitleMarginStart(12);
        }

    }

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new ReciclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.huella);
        tabLayout.getTabAt(1).setIcon(R.drawable.icgato);
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.mascotas, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.Favs:
                startActivity(new Intent(getApplicationContext(),Favs.class));
                return true;
            case R.id.mCotacto:
                startActivity(new Intent(getApplicationContext(), ContactoActivity.class));
                return true;
            case R.id.mAbout:
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
            default:
                return super.onOptionsItemSelected(item);

        }
    }

}
