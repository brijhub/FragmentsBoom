package group.wnrcorp.com.navigationproject;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements InterfaceSolution{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    FragmentTransaction fragmentTransaction;
    NavigationView navigationView;

    public int addResult,subResult,mulresult,divResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //onlyForMultiplication=(OnlyForMultiplication)this;
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView=(NavigationView)findViewById(R.id.navigation_view);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.content_main,new DefaultFragment());
        fragmentTransaction.commit();
        getSupportActionBar().setTitle("Default Fragment");

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               switch (item.getItemId())
               {
                   case R.id.first:
                       fragmentTransaction=getSupportFragmentManager().beginTransaction();
                       fragmentTransaction.replace(R.id.content_main,new FirstFragment());
                       fragmentTransaction.addToBackStack(null);
                       fragmentTransaction.commit();
                       getSupportActionBar().setTitle("First Fragment");
                       item.setChecked(true);
                       drawerLayout.closeDrawers();
                       break;

                   case R.id.second:

                       SecondFragment sf=new SecondFragment();
                       Bundle args = new Bundle();
                       args.putInt("mul", mulresult);
                       sf.setArguments(args);
                       System.out.println("fragmentCheckMultiplicationActivity..."+mulresult);
                       fragmentTransaction=getSupportFragmentManager().beginTransaction();
                       fragmentTransaction.replace(R.id.content_main,sf);
                       fragmentTransaction.addToBackStack(null);
                       fragmentTransaction.commit();
                       getSupportActionBar().setTitle("Second Fragment");
                       item.setChecked(true);
                       drawerLayout.closeDrawers();
                       break;

                   case R.id.third:

                       ThirdFragment tf=new ThirdFragment();
                       Bundle args1 = new Bundle();
                       args1.putInt("div", divResult);
                       tf.setArguments(args1);
                       fragmentTransaction=getSupportFragmentManager().beginTransaction();
                       fragmentTransaction.replace(R.id.content_main,tf);
                       fragmentTransaction.addToBackStack(null);
                       fragmentTransaction.commit();
                       getSupportActionBar().setTitle("Third Fragment");
                       item.setChecked(true);
                       drawerLayout.closeDrawers();
                       break;

               }

                return true;
            }
        });

    }

    @Override
    public void sendAdditionData(int a) {
        addResult=a;
        System.out.println("fragmentCheckActivity..."+addResult);
        FirstFragment2 f2=new FirstFragment2();
        Bundle args = new Bundle();
        args.putInt("add", addResult);
        f2.setArguments(args);
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.ff2,f2);
        fragmentTransaction.commit();
    }

    @Override
    public void sendSubtractionData(int b) {

        subResult=b;
        FirstFragment3 f3=new FirstFragment3();
        Bundle args = new Bundle();
        args.putInt("sub", subResult);
        f3.setArguments(args);
        fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.ff3,f3);
        fragmentTransaction.commit();

    }

    @Override
    public void sendMultiplicationData(int c) {
        mulresult=c;
    }

    @Override
    public void senddivisionData(int d) {
        divResult=d;
    }


    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() > 0){
            getFragmentManager().popBackStackImmediate();
        }
        else{
            super.onBackPressed();
        }
    }
}
