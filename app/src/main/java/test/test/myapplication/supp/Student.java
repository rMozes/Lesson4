package test.test.myapplication.supp;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by BruSD on 9/23/2014.
 */
public class Student {

    private String mName;
    private String mSname;
    private String mEmail;
    private int mAge;
    private int mTellNumber;

    public Student(JSONObject jsonObject) throws JSONException {
        mName = jsonObject.getString(Constants.JSON.JSON_NAME);
        mSname = jsonObject.getString(Constants.JSON.JSON_SNAME);
        String email = jsonObject.getString(Constants.JSON.JSON_EMAIL);
        int age = jsonObject.getInt(Constants.JSON.JSON_AGE);
        int tell = jsonObject.getInt(Constants.JSON.JSON_TELL);
        if(email != null) {
            mEmail = email;
        } if(age != 0) {
            mAge = age;
        } if(tell != 0) {
            mTellNumber = tell;
        }
    }

    private Student(String name, String mSname, String mEmail,
                    int mAge, int mTellNumber) {
        this.mName  = name;
        this.mSname = mSname;
        this.mEmail = mEmail;
        this.mAge = mAge;
        this.mTellNumber = mTellNumber;
    }

    public static class Builder {
        private String name;
        private String sname;
        private String email = "";
        private int age;
        private int tell;

        public Builder(String name, String sname) {
            this.name = name;
            this.sname = sname;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setTell(int tell) {
            this.tell = tell;
            return this;
        }

        public Student build() {
            return new Student(name, sname, email, age, tell);
        }
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(Constants.JSON.JSON_NAME, mName);
        jsonObject.put(Constants.JSON.JSON_SNAME, mSname);
        jsonObject.put(Constants.JSON.JSON_EMAIL, mEmail);
        jsonObject.put(Constants.JSON.JSON_AGE, mAge);
        jsonObject.put(Constants.JSON.JSON_TELL, mTellNumber);

        return jsonObject;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public String getSname() {
        return mSname;
    }

    public void setSname(String mSname) {
        this.mSname = mSname;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public int getAge() {
        return mAge;
    }

    public void setAge(int mAge) {
        this.mAge = mAge;
    }

    public int getTellNumber() {
        return mTellNumber;
    }

    public void setTellNumber(int mTellNumber) {
        this.mTellNumber = mTellNumber;
    }
}
