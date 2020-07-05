package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.List;

public class Register extends AppCompatActivity implements View.OnClickListener
{
    // element declaration
    private ImageView avatar;
    private EditText email;
    private EditText password;
    private EditText password2;
    //DbHelper helper;

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.removeItem(R.id.action_favorite);
        menu.removeItem(R.id.action_favorites);
        menu.removeItem(R.id.action_profile);
        menu.removeItem(R.id.action_login);
        menu.removeItem(R.id.action_register);
        menu.removeItem(R.id.action_search);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar action_bar = (Toolbar) findViewById(R.id.tb);
        setSupportActionBar(action_bar);

        // takeover
        avatar = findViewById(R.id.avatar);
        email = findViewById(R.id.r_username);
        password = findViewById(R.id.r_password);
        password2 = findViewById(R.id.r_password2);
        Button register = findViewById(R.id.btn_register);
        register.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        // input fields
        String email_field = email.getText().toString();
        String pass_field = password.getText().toString();
        String pass2_field = password2.getText().toString();

        //password - all letters and digits 4-12
        String regex_p = "^*[a-zA-Z0-9]{4,12}$";
        // email - as permitted by RFC 5322
        String regex_e = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        // conditions
        if (email_field.isEmpty() || pass_field.isEmpty() || pass2_field.isEmpty())
        {
            try { throw new Exception("יש למלא את כל השדות"); }
            catch (Exception e)
            { Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show(); }
        }

        else if (!email_field.matches(regex_e))
        {
            try { throw new Exception("אימייל לא חוקי"); }
            catch (Exception e)
            { Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show(); }
        }

        else if (!pass_field.matches(regex_p))
        {
            try { throw new Exception("פורמט סיסמא a-z, A-Z, 0-9, באורך 4-12"); }
            catch (Exception e)
            { Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show(); }
        }

        else if (email_field.contains(" ") || pass_field.contains(" "))
        {
            try { throw new Exception("נא להסיר רווחים"); }
            catch (Exception e)
            { Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show(); }
        }

        else if (!pass_field.matches(pass2_field))
        {
            try { throw new Exception("סיסמאות לא תואמות"); }
            catch (Exception e)
            { Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show(); }
        }
        // insert to database
        else
        {
            User new_user = new User(email_field, pass2_field, null, null);
            Toast.makeText(getApplicationContext(), new_user.toString(), Toast.LENGTH_LONG).show();
            DbHelper helper = DbHelper.getInstance(this); // open or create
            helper.addOrUpdateUser(new_user);
        }
    }
}