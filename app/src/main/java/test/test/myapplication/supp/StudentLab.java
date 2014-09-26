package test.test.myapplication.supp;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by RICHI on 2014.09.24..
 */
public class StudentLab {

    private Context context;
    private ArrayList<HashMap<String, Student>> students;
    private static StudentLab lab;

    private StudentLab(Context context) {
        this.context = context;
        students = new ArrayList<HashMap<String, Student>>();
        generateStudentList();
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

    private void generateStudentList() {
        generateStudentsItem("Dmitriy","Bruso", students );
        generateStudentsItem("Михайло","Тромбола", students );
        generateStudentsItem("Олександр","Мікуланінець ", students );
        generateStudentsItem("Іван", "Фельцан ", students);
        generateStudentsItem("Михайло","Рогач ", students );
        generateStudentsItem("Александр ","Миченко ", students );
        generateStudentsItem("Oleh ","Mahobey", students );
        generateStudentsItem("Диана","Ручкайте ", students );
        generateStudentsItem("Саша","Курта  ", students );
        generateStudentsItem("Сергей","Грищук  ", students );
    }

    private void generateStudentsItem(String name, String sname, ArrayList<HashMap<String, Student>> students) {
        HashMap<String, Student> item = generateMap();
        item.put("student", new Student.Builder(name, sname).build());
        students.add(item);
    }

    private HashMap<String, Student> generateMap() {
        return new HashMap<String, Student>();
    }
}
