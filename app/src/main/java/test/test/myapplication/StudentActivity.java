package test.test.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

import test.test.myapplication.supp.Student;
import test.test.myapplication.supp.StudentAdapter;

/**
 * Created by RICHI on 2014.09.24..
 */
public class StudentActivity extends Activity {

    private static final String TAG = "StudentActivity";

    private Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        Intent intent = getIntent();
        String name = intent.getStringExtra(StudentAdapter.EXTRA_NAME);
        String sname = intent.getStringExtra(StudentAdapter.EXTRA_SNAME);
        String email = intent.getStringExtra(StudentAdapter.EXTRA_EMAIL);
        int age = intent.getIntExtra(StudentAdapter.EXTRA_AGE, 0);
        int tell = intent.getIntExtra(StudentAdapter.EXTRA_TELL, 0);

        FragmentManager fragmentManager = getFragmentManager();
        fragment = fragmentManager.findFragmentById(R.id.fragmnet_container);

        if(fragment == null) {
            fragment = StudentFragment.newinstance(name,
                    sname, email, age, tell);

            fragmentManager.beginTransaction()
                    .add(R.id.fragmnet_container, fragment)
                    .commit();
        }
    }
}
