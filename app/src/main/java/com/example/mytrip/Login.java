package com.example.mytrip;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener
{
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.l_username);
        password = findViewById(R.id.l_password);
        Button login = findViewById(R.id.btn_login);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        String email_field = email.getText().toString();
        String pass_field = password.getText().toString();

        //password - all letters and digits 4-12
        String regex_p = "^*[a-zA-Z0-9]{4,12}$";
        // email - as permitted by RFC 5322
        String regex_e = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

        // conditions
        if (email_field.isEmpty() || pass_field.isEmpty())
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
        // compare to database
        else
        {
            User new_user = new User(email_field, pass_field, null, null);
            DbHelper helper = DbHelper.getInstance(this); // open or create
            // sets the static flag to comparison result
            MainActivity.setLogged(helper.findUser(new_user));
//            String flagLogged = Boolean.toString(MainActivity.getLogged());
//            Log.d("D/DbHelper", flagLogged);
            if (MainActivity.getLogged())
            {
                Toast.makeText(getApplicationContext(), "נכנס...",
                        Toast.LENGTH_SHORT).show();
                Intent backToMain = new Intent(this, MainActivity.class);
                startActivity(backToMain);
            }
            else
                Toast.makeText(getApplicationContext(), "נסה שוב",
                        Toast.LENGTH_SHORT).show();
        }
    }
}