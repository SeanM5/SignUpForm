package edu.temple.signupform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class FormActivity extends AppCompatActivity {

    TextView name;
    TextView email;
    TextView password;
    TextView confirm;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        confirm = findViewById(R.id.confirm);
        submit = findViewById(R.id.submit);

        View.OnClickListener submitClick = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(name.getText().toString().matches("")){
                    Toast.makeText(FormActivity.this, "Name Field is empty.", Toast.LENGTH_SHORT).show();
                }else if(email.getText().toString().matches("")){
                    Toast.makeText(FormActivity.this, "Email Field is empty.", Toast.LENGTH_SHORT).show();
                }else if(password.getText().toString().matches("")){
                    Toast.makeText(FormActivity.this, "Password Field is empty.", Toast.LENGTH_SHORT).show();
                }else if(confirm.getText().toString().matches("")){
                    Toast.makeText(FormActivity.this, "Password Confirmation Field is empty.", Toast.LENGTH_SHORT).show();
                }else if(!password.getText().toString().equals(confirm.getText().toString())){
                    Toast.makeText(FormActivity.this, "Password and Confirmation Field do not match.", Toast.LENGTH_SHORT).show();
                }else {
                    Intent welcome = new Intent(FormActivity.this, WelcomeActivity.class);
                    welcome.putExtra("welcome", name.getText().toString());
                    startActivity(welcome);
                }

//                Intent welcome = new Intent(FormActivity.this, WelcomeActivity.class);
//////                    welcome.putExtra("welcome", name.getText().toString());
//                    startActivity(welcome);

            }
        };

        submit.setOnClickListener(submitClick);

    }

}
