package test.test.myapplication.supp;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by RICHI on 2014.09.26..
 */
public class JSONSerializer {

    private String mFileName;
    private Context context;

    public JSONSerializer(Context c, String f) {
        this.context = c;
        this.mFileName = f;
    }

    public void serializer(List<HashMap<String, Student>> students) throws JSONException, IOException{
        OutputStream out = null;
        OutputStreamWriter writer = null;
        JSONArray jsonArray = null;

        try {
            out = context.openFileOutput(mFileName, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            jsonArray = new JSONArray();

            for(HashMap<String, Student> map : students) {
                Student student = map.get("student");
                jsonArray.put(student.toJSON());
            }

            writer.write(jsonArray.toString());
        } finally {
            if(writer != null) {
                writer.close();
            }
        }
    }

    public  ArrayList<HashMap<String, Student>> load() throws IOException, JSONException {
        InputStream in = null;
        InputStreamReader is = null;
        BufferedReader reader = null;
        ArrayList<HashMap<String, Student>> students = new ArrayList<HashMap<String, Student>>();
        StringBuilder builder = new StringBuilder();

        in = context.openFileInput(mFileName);
        is = new InputStreamReader(in);
        reader = new BufferedReader(is);

        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }

        JSONArray jsonArray = (JSONArray) new JSONTokener(builder.toString()).nextValue();
        for (int i = 0; i < jsonArray.length(); i++) {
            Student student = new Student(jsonArray.getJSONObject(i));
            HashMap<String, Student> map = new HashMap<String, Student>();
            map.put("student", student);
            students.add(map);
        }

        if(reader != null) {
            reader.close();
        }

        return  students;
    }
}
