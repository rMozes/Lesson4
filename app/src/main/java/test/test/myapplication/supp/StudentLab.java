package test.test.myapplication.supp;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by RICHI on 2014.09.24..
 */
public class StudentLab {

    public static final String TAG = "StudentLab";

    private Context context;
    private ArrayList<HashMap<String, Student>> students;
    private static StudentLab lab;
    private JSONSerializer serializer;

    private StudentLab(Context context) {
        this.context = context;
        serializer = new JSONSerializer(context, Constants.JSON.FILENAME);
        try {
            students = serializer.load();
        } catch (Exception e) {
            students = generateStudentList();
        }
    }

    public static StudentLab get(Context context) {
        if(lab == null) {
            lab = new StudentLab(context);
        }

        return lab;
    }

    public ArrayList<HashMap<String, Student>> getData() {
        return students;
    }

    private ArrayList<HashMap<String, Student>> generateStudentList() {
        ArrayList<HashMap<String, Student>> listStudents = new ArrayList<HashMap<String, Student>>();

        generateStudentsItem("Dmitriy","Bruso", listStudents );
        generateStudentsItem("Михайло","Тромбола", listStudents );
        generateStudentsItem("Олександр","Мікуланінець ", listStudents );
        generateStudentsItem("Іван", "Фельцан ", listStudents);
        generateStudentsItem("Михайло","Рогач ", listStudents );
        generateStudentsItem("Александр ","Миченко ", listStudents );
        generateStudentsItem("Oleh ","Mahobey", listStudents );
        generateStudentsItem("Диана","Ручкайте ", listStudents );
        generateStudentsItem("Саша","Курта  ", listStudents );
        generateStudentsItem("Сергей","Грищук  ", listStudents );

        return listStudents;
    }

    private void generateStudentsItem(String name, String sname, ArrayList<HashMap<String, Student>> listStudents) {
        HashMap<String, Student> item = new HashMap<String, Student>();
        item.put("student", new Student.Builder(name, sname).build());
        listStudents.add(item);
    }

    public void save(){
        Log.d(TAG, "save students");
        try {
            serializer.serializer(students);
        } catch (JSONException e) {
            Log.d(TAG, "JSONException : ", e);
        } catch (IOException e) {
            Log.d(TAG, "IOException : ", e);
        }
    }
}
