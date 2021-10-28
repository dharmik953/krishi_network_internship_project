package com.dharmik953.krishinetwork;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Objects;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView imageView;
    DatabaseClass db_class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Activity 1");

        EditText et_name = findViewById(R.id.et_name);
        EditText et_email = findViewById(R.id.et_email);
        Button image = findViewById(R.id.open_camera);
        TextView tv_name = findViewById(R.id.tv_name);
        TextView tv_email = findViewById(R.id.tv_email);
        Button save = findViewById(R.id.save);
        Button show = findViewById(R.id.show);

        imageView = findViewById(R.id.imageView);
        Button go_to_activity_2 = findViewById(R.id.go_to_Activity_2);

        image.setOnClickListener(v -> {
            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            try {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(getApplicationContext(), "failed" , Toast.LENGTH_SHORT).show();
            }
            
            if (isValid(et_email.getText().toString())){
                tv_name.setText(et_name.getText().toString());
                tv_email.setText(et_email.getText().toString());
                Toast.makeText(getApplicationContext(), "Saving data", Toast.LENGTH_SHORT).show();
            } else Toast.makeText(getApplicationContext(), "Please enter a velid E- mail", Toast.LENGTH_SHORT).show();


        });
//***************************************************************************************************************************************************************************************************

        save.setOnClickListener(v -> {
            byte[] img = convert_imaveView_ByteArray(imageView);
            db_class = new DatabaseClass(MainActivity.this);
            if (db_class.save(1,et_name.getText().toString(),et_email.getText().toString(),img)){
                Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
            }else Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show();
            db_class.save(1,et_name.getText().toString(),et_email.getText().toString(),img);
        });

        show.setOnClickListener(v -> {

            db_class = new DatabaseClass(MainActivity.this);
            byte [] img = db_class.get("SELECT IMG FROM data WHERE id = 1");
            if (img != null){
                Bitmap bitmap = convertbytearyrtobitmap(img);
                imageView.setImageBitmap(bitmap);
            }

            String name = db_class.getname("SELECT name FROM data WHERE id = 1");
            String email = db_class.getEmail("SELECT email FROM data WHERE id = 1");

            tv_name.setText(name);
            tv_email.setText(email);

        });

        go_to_activity_2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, MainActivity2.class)));

    }

    private Bitmap convertbytearyrtobitmap(byte [] bytes){
        return BitmapFactory.decodeByteArray(bytes,0,bytes.length);
    }

    private byte[] convert_imaveView_ByteArray(ImageView imageView){

        Bitmap bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,70,byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
        }
    }

    public static boolean isValid(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
    }

}