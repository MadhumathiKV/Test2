package test.smart.rmkv.addsub;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import test.smart.rmkv.R;
import test.smart.rmkv.test2.Calculator;
import test.smart.rmkv.test2.MainActivity;

/**
 * Created by smartron01 on 17/04/15.
 */
public class AddSubtract extends Activity implements Calculator {
    static int add_result =0 ;
    static int sub_result =0 ;
    static int add_a = 0;
    static int add_b =0 ;
    static int sub_a = 0;
    static int sub_b =0 ;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addsubtract);
        final Context context = this;

        TextView tv1 = (TextView) findViewById(R.id.textView);
        tv1.setText("Add Result ( "+ add_a  +"  "+ add_b +")= "+add_result
                +"\nSubtract Result="+ sub_a  +"  "+ sub_b +")= "+sub_result);
        Button main_btn = (Button) findViewById(R.id.mainbtn);


        main_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void add(int a,int b){
        add_result = (a+b);
        add_a = a;
        add_b = b;

        System.out.println("Adding (" + a + " + " +b+") Output= "+(a+b));
    }
    public void subtract(int a, int b){
        sub_result = (a-b);
        sub_a = a;
        sub_b = b;
        System.out.println("Subtracting (" + a + " - " +b+") Output= "+(a-b));
    }

}
