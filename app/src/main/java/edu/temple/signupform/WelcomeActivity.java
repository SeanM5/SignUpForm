package edu.temple.signupform;


import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    TextView welcomeMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

//        Intent ok = getIntent();
        String message = getIntent().getStringExtra("welcome");
//        String msg = ok.getExtras().getString("welcome");

        welcomeMsg = findViewById(R.id.welcomeText);

        welcomeMsg.setText("Welcome, " + message + ", to the SignUpForm App");
        welcomeMsg.setTextSize(30);



        Integer colorFrom = getResources().getColor(R.color.holo_red_dark);
        Integer colorTo = getResources().getColor(R.color.holo_blue_bright);

        ObjectAnimator colorAnim = ObjectAnimator.ofInt(welcomeMsg, "textColor",
                colorFrom, colorTo);
        colorAnim.setDuration(1500);
        colorAnim.setEvaluator(new ArgbEvaluator());
        colorAnim.setRepeatMode(ValueAnimator.REVERSE);
        colorAnim.setRepeatCount(Animation.INFINITE);
        colorAnim.start();


    }
}
