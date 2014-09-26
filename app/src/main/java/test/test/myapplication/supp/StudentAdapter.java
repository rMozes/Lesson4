package test.test.myapplication.supp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import test.test.myapplication.R;
import test.test.myapplication.StudentActivity;

/**
 * Created by BruSD on 9/23/2014.
 */
public class StudentAdapter extends SimpleAdapter {

    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_SNAME = "sname";
    public static final String EXTRA_EMAIL = "email";
    public static final String EXTRA_AGE = "age";
    public static final String EXTRA_TELL = "tellnumber";

    public static final int REQUEST_STUDENT = 10;

    private ArrayList<HashMap<String, Student>> students;
    private Context context;
    private int resource;

    /**
     * Constructor
     *
     * @param context  The context where the View associated with this SimpleAdapter is running
     * @param data     A List of Maps. Each entry in the List corresponds to one row in the list. The
     *                 Maps contain the data for each row, and should include all the entries specified in
     *                 "from"
     * @param resource Resource identifier of a view layout that defines the views for this list
     *                 item. The layout file should include at least those named views defined in "to"
     * @param from     A list of column names that will be added to the Map associated with each
     *                 item.
     * @param to       The views that should display column in the "from" parameter. These should all be
     *                 TextViews. The first N views in this list are given the values of the first N columns
     */
    public StudentAdapter(Context context, ArrayList<HashMap<String, Student>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.students = data;
        this.context = context;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = mInflater.inflate(resource, parent, false);

        final Student student = students.get(position).get("student");

        TextView nameTextView = (TextView) convertView.findViewById(R.id.first_name_indicator);
        String name = student.getName();
        nameTextView.setText(name);

        TextView snameTextView = (TextView) convertView.findViewById(R.id.second_name_indicator);
        String sname = student.getSname();
        snameTextView.setText(sname);

        Button button = (Button) convertView.findViewById(R.id.btn_in_list);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, StudentActivity.class);
                intent.putExtra(EXTRA_NAME, student.getName());
                intent.putExtra(EXTRA_SNAME, student.getSname());
                intent.putExtra(EXTRA_EMAIL, student.getEmail());
                intent.putExtra(EXTRA_AGE, student.getAge());
                intent.putExtra(EXTRA_TELL, student.getTellNumber());
                ((Activity) context).startActivityForResult(intent, REQUEST_STUDENT);
            }
        });

        return convertView;
    }
}
