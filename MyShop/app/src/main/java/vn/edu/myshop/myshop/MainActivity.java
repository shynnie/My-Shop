package vn.edu.myshop.myshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    EditText tbxUsername, tbxPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GeneratingDummData generatingDummData = new GeneratingDummData();
        //generatingDummData.generate(50);

        tbxUsername = (EditText) findViewById(R.id.tbxUsername);
        tbxPassword = (EditText) findViewById(R.id.tbxPassword);

        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String username, password;

        FirebaseDatabase
                .getInstance()
                .getReference()
                .child("root")
                .child("users")
                .child(tbxUsername.getText().toString() + "-" + tbxPassword.getText().toString())
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            Toast.makeText(getApplicationContext(), "Thanh cong", Toast.LENGTH_SHORT).show();
                            DataTemp.currentUser = dataSnapshot.getValue(User.class);

                            Intent intent = new Intent(MainActivity.this, LoginSuccess.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(getApplicationContext(), "Thanh that", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
    }
}
