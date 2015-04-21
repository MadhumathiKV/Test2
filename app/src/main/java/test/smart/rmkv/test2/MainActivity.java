package test.smart.rmkv.test2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import test.smart.rmkv.R;
import test.smart.rmkv.addsub.AddSubtract;
import test.smart.rmkv.multdiv.MultDivide;


public class MainActivity extends ActionBarActivity implements  ConstantValues{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView)findViewById(R.id.txtv);
        final Context context = this;

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder;
            builder = factory.newDocumentBuilder();
            Document document;
            InputStream inputStream = getResources().openRawResource(R.raw.operations);
            document = builder.parse(inputStream);
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            NodeList nList = document.getElementsByTagName("operation");
            Interface1 calc ;

            for (int temp = 0; temp < nList.getLength(); temp++)
            {
                Node node = nList.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE)
                {
                    Element eElement = (Element) node;
                    String opern =   eElement.getElementsByTagName(OPERATOR).item(0).getTextContent();
                    String class_name =  eElement.getElementsByTagName(CLASS_NAME).item(0).getTextContent();
                    String method_name =   eElement.getElementsByTagName(METHOD_NAME).item(0).getTextContent();
                    String interface_name =   eElement.getElementsByTagName(INTERFACE_NAME).item(0).getTextContent();
                    int arg1 = Integer.parseInt(eElement.getElementsByTagName(ARG1).item(0).getTextContent());
                    int arg2 = Integer.parseInt(eElement.getElementsByTagName(ARG2).item(0).getTextContent());
                    calc = (Interface1) Class.forName(class_name).newInstance();
                    Class[] paramInt = new Class[2];
                    paramInt[0] = Integer.TYPE;
                    paramInt[1] = Integer.TYPE;
                    Method method = calc.getClass().getDeclaredMethod(method_name, paramInt);
                    method.invoke(calc,arg1,arg2);
                }
            }
        } catch (ParserConfigurationException e) {
            Log.e("Parser ","ParserConfigurationException");
        } catch (SAXException e) {
            Log.e("SAXException ","SAXException");
        } catch (IOException e) {
            Log.e("IOException ","IOException........");
        }catch (NoSuchMethodException e) {
            Log.e("NoSuchMethod ","NoSuchMethodException");
        } catch (InstantiationException e) {
            Log.e("Instantiation","InstantiationException");
        } catch (IllegalAccessException e) {
            Log.e("IllegalAccessException ","IllegalAccessException");
        } catch (InvocationTargetException e) {
            Log.e("InvocationException ","InvocationTargetException");
        } catch (ClassNotFoundException e) {
            Log.e("ClassNotFoundException ","ClassNotFoundException.....");
            e.printStackTrace();
        } catch(NumberFormatException e){
            Log.e("NumberFormatException ","NumberFormatException.....");
            e.printStackTrace();
        } catch(Exception e){
            Log.e("Exception ","Exception");
        }


        Button addsub_btn =(Button)findViewById(R.id.addsubbtn);
        addsub_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AddSubtract.class);
                startActivity(intent);
                finish();

            }
        });

        Button multdiv_btn = (Button)findViewById(R.id.muldivbtn);
        multdiv_btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MultDivide.class);
                startActivity(intent);
                finish();
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
