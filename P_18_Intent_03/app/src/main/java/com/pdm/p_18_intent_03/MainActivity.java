package com.pdm.p_18_intent_03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText editText=(EditText)findViewById(R.id.editText);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),SegundaActivity.class);
                intent.putExtra("nombre", editText.getText().toString());
                startActivityForResult(intent,1234);
            }
        });
    }

    protected void onActivityResult(int requestCode,int resultCode, Intent intent) {
        String res="Sin resolver";
        if(requestCode==1234 && resultCode==RESULT_OK){
            res=intent.getExtras().getString("resultado");
            button.setVisibility(View.INVISIBLE);
        }
        TextView textView=(TextView)findViewById(R.id.textView2);
        textView.setText(res);

    }

}
