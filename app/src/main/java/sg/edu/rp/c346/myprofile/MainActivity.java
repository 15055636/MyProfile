package sg.edu.rp.c346.myprofile;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etGPA;
    RadioGroup rgGender;
    CheckBox cbLike;



    @Override
    protected void onPause() {
        super.onPause();
        //Retrieve data input from the user
        String strName = etName.getText().toString();
        float strGPA = Float.parseFloat(etGPA.getText().toString());
        boolean checked = cbLike.isChecked();

         int gender = rgGender.getCheckedRadioButtonId();

        //Obtain an instance of the Shared Preference
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Obtain an instance of the Shared Preference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        //Add the key-value pair
        prefEdit.putString("name",strName);
        prefEdit.putFloat("gpa", strGPA );
        prefEdit.putBoolean("checked", checked);
        prefEdit.putInt("gender", gender);

        //Call commit method to save the changes into the Shared Preference
        prefEdit.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String strName = prefs.getString("name","John");
        float strGPA = prefs.getFloat("gpa",0);
        boolean checked = prefs.getBoolean("checked",false);
        int gender = prefs.getInt("gender",0);

        rgGender.check(gender);
        etName.setText(strName);
        etGPA.setText(Float.toString(strGPA));
        cbLike.setChecked(checked);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etName = (EditText)findViewById(R.id.editText);
        etGPA = (EditText)findViewById(R.id.editText2);
        rgGender = (RadioGroup)findViewById(R.id.RadioGroupGender);
        cbLike = (CheckBox)findViewById(R.id.checkBoxLikeProgramming);




    }
}
