package com.example.gamer.implicentintents;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText mytxt1,mytxt2,mytxt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mytxt1 = (EditText)findViewById(R.id.link);
        mytxt2 = (EditText)findViewById(R.id.maps);
        mytxt3 = (EditText)findViewById(R.id.shtxt);
    }
    public void onclick(View view) {
        switch (view.getId()){
            case R.id.bt1 :
                String mystr1 = mytxt1.getText().toString();
                Uri browser = Uri.parse(mystr1);
                Intent intent1 = new Intent(Intent.ACTION_VIEW,browser);
                startActivity(intent1);
                break;
            case R.id.bt2 :
                String mystr2 = mytxt2.getText().toString();
                Uri loc = Uri.parse("geo:0,0?q="+mystr2);
                Intent intent2 = new Intent(Intent.ACTION_VIEW,loc);
                startActivity(intent2);
                break;
            case R.id.bt3 :
                String mystr3 = mytxt3.getText().toString();
                ShareCompat.IntentBuilder
                        .from(this)
                        .setType("text/plain")
                        .setChooserTitle("Share this text with : ")
                        .setText(mystr3).startChooser();
                break;
            case R.id.bt4 :
                Intent intent3 = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(intent3);
                break;
        }
    }

}
