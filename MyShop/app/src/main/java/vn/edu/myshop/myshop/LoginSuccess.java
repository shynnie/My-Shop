package vn.edu.myshop.myshop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toolbar;

public class LoginSuccess extends AppCompatActivity {

    TextView lbUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_success);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setTitle("My Shop");

        lbUsername = (TextView) findViewById(R.id.lbUsernameLoginSuccess);
        lbUsername.setText(DataTemp.currentUser.getUsername());
    }
}
