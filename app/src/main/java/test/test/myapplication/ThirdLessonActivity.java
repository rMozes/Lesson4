package test.test.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.method.CharacterPickerDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

import test.test.myapplication.supp.Student;
import test.test.myapplication.supp.StudentAdapter;
import test.test.myapplication.supp.StudentLab;

/**
 * Created by BruSD on 9/23/2014.
 */
public class ThirdLessonActivity extends Activity {
    private ListView listView;
    private ArrayList<HashMap<String, Student>> students;
    private StudentAdapter studentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_lesson_layout);

        students = StudentLab.get(this).getData();

        listView = (ListView) findViewById(R.id.custom_items_list_view);
    }

    @Override
    protected void onResume() {
        super.onResume();
        studentAdapter =  new StudentAdapter(this, students, R.layout.list_item_layout, null, null );
        listView.setAdapter(studentAdapter);
    }

}
