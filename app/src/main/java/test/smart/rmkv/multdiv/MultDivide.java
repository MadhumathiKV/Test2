package test.smart.rmkv.multdiv;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import test.smart.rmkv.R;
import test.smart.rmkv.test2.Calculator1;
import test.smart.rmkv.test2.MainActivity;

/**
 * Created by smartron01 on 17/04/15.
 */
public class MultDivide extends Activity implements Calculator1 {
    static int multiply_result = 0;
    static int divide_result = 0;
    static int mul_a = 0;
    static int mul_b = 0;

    static int div_a = 0;
    static int div_b = 0;

    final Context context = this;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplydivide);
        TextView tv1 = (TextView) findViewById(R.id.textView2);
        tv1.setText("Multiply Result(" + mul_a + "*" + mul_b + ")= " + multiply_result
                + "\nDivide Result(" + div_a + "/" + div_b + ")= " + divide_result);

        Button btn = (Button) findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }


    public void multiply(int a, int b) {
        try {
            multiply_result = (a * b);
            mul_a = a;
            mul_b = b;
            System.out.println("Multiplying (" + a + " * " + b + ") Output= " + (a * b));
        }catch (NumberFormatException e){
            Log.e("NumberFormatException","NFE in Multiply()");
        }catch(Exception e){
            Log.e("Exception ","An exception has occurred");
        }

    }

    public void divide(int a, int b) {

        try {
            div_a = a;
            div_b = b;
            divide_result = (a / b);
            System.out.println("Dividing (" + a + " / " + b + ") Output= " + (a / b));
        } catch (NumberFormatException e) {
            Log.e("NumberFormatException", "NFE in divide()");
        } catch (Exception e) {
            Log.e("Exception", "Exception");

        }
    }
}
