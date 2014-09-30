package test.test.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;

import test.test.myapplication.supp.Student;
import test.test.myapplication.supp.StudentAdapter;
import test.test.myapplication.supp.StudentLab;


/**
 * Created by RICHI on 2014.09.24..
 */
public class StudentFragment extends Fragment {

    private static final String TAG = "StudentFragment";

    private EditText mName;
    private EditText mSname;
    private EditText mEmail;
    private EditText mAge;
    private EditText mTell;
    private Student mStudent;
    private ArrayList<HashMap<String, Student>> students;

    private StudentFragment() {
        students = StudentLab.get(getActivity()).getData();
    }

    public static StudentFragment newinstance(String name,
                                              String sname,
                                              String email,
                                              int age,
                                              int tell) {
        Bundle args = new Bundle();
        args.putString(StudentAdapter.EXTRA_NAME, name);
        args.putString(StudentAdapter.EXTRA_SNAME, sname);
        args.putString(StudentAdapter.EXTRA_EMAIL, email);
        args.putInt(StudentAdapter.EXTRA_AGE, age);
        args.putInt(StudentAdapter.EXTRA_TELL, tell);

        StudentFragment fragment = new StudentFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.student_information_layout, container, false);

        Bundle arg = getArguments();

        mName = (EditText) view.findViewById(R.id.name_indicator);
        mSname = (EditText) view.findViewById(R.id.sname_indicator);
        mEmail = (EditText) view.findViewById(R.id.email_indicator);
        mAge = (EditText) view.findViewById(R.id.age_indicator);
        mTell = (EditText) view.findViewById(R.id.tell_indicator);

        mName.setText(arg.getString(StudentAdapter.EXTRA_NAME));
        mSname.setText(arg.getString(StudentAdapter.EXTRA_SNAME));

        String string = arg.getString(StudentAdapter.EXTRA_EMAIL);
        if(string != null) {
            mEmail.setText(string);
        }

        int i = arg.getInt(StudentAdapter.EXTRA_AGE);
        if(i != 0) {
            mAge.setText(i+"");
        }

        i = arg.getInt(StudentAdapter.EXTRA_TELL);
        if(i != 0) {
            mTell.setText(i+"");
        }

        mName.addTextChangedListener(new MyWatcher(mName));
        mSname.addTextChangedListener(new MyWatcher(mSname));
        mEmail.addTextChangedListener(new MyWatcher(mEmail));
        mAge.addTextChangedListener(new MyWatcher(mAge));
        mTell.addTextChangedListener(new MyWatcher(mTell));

        String nameClick = arg.getString(StudentAdapter.EXTRA_NAME);
        for(HashMap<String, Student> student : students) {
            String name = student.get("student").getName();
            if (nameClick.equals(name)) {
                mStudent = student.get("student");
                break;
            }
        }

        return view;
    }

    private class MyWatcher implements TextWatcher {

        private EditText view;

        public MyWatcher(View v) {
            view = (EditText) v;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            int id = view.getId();

            switch (id) {
                case R.id.name_indicator:
                    mStudent.setName(charSequence.toString());
                    break;
                case R.id.age_indicator:
                    if(charSequence.length() != 0) {
                        mStudent.setAge(Integer.parseInt(charSequence.toString()));
                    } else {
                        mStudent.setAge(0);
                    }
                    break;
                case R.id.sname_indicator:
                    mStudent.setSname(charSequence.toString());
                    break;
                case R.id.email_indicator:
                    mStudent.setEmail(charSequence.toString());
                    break;
                case R.id.tell_indicator:
                    if(charSequence.length() != 0) {
                        mStudent.setTellNumber(Integer.parseInt(charSequence.toString()));
                    } else {
                        mStudent.setTellNumber(0);
                    }
                    break;
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    }
}
