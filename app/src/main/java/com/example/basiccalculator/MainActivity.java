package com.example.basiccalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ClipboardManager;

public class MainActivity extends AppCompatActivity {
    private static TextView bottom;
    private static EditText top;
    private static Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9,dot,add,sub,multi,div,pow,equals,ans,backspace,allClear,firstbracket,closingbracket,copytoclip;
    private static String expression="",show="",exp_head="",exp_tail="",show_head="",show_tail="";
    private static Double result;
    private static int cursor_pos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        top=(EditText)findViewById(R.id.inpfield);
        bottom=(TextView)findViewById(R.id.result);
        top.setShowSoftInputOnFocus(false);
        //number_buttons
        b0=(Button)findViewById(R.id.button0);
        b1=(Button)findViewById(R.id.button1);
        b2=(Button)findViewById(R.id.button2);
        b3=(Button)findViewById(R.id.button3);
        b4=(Button)findViewById(R.id.button4);
        b5=(Button)findViewById(R.id.button5);
        b6=(Button)findViewById(R.id.button6);
        b7=(Button)findViewById(R.id.button7);
        b8=(Button)findViewById(R.id.button8);
        b9=(Button)findViewById(R.id.button9);
        //operator_button
        dot=(Button)findViewById(R.id.dot);
        add=(Button)findViewById(R.id.addition);
        sub=(Button)findViewById(R.id.sub);
        multi=(Button)findViewById(R.id.multiplication);
        div=(Button)findViewById(R.id.division);
        pow=(Button)findViewById(R.id.power);
        equals=(Button)findViewById(R.id.equals);
        ans=(Button)findViewById(R.id.ans);
        backspace=(Button)findViewById(R.id.backspace);
        firstbracket=(Button)findViewById(R.id.firstb);
        closingbracket=(Button)findViewById(R.id.closingb);
        allClear=(Button)findViewById(R.id.all_clear);
        copytoclip=(Button)findViewById(R.id.copyToClip);
        //display
        top.setText(expression);
        //click_actions
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                insert("0");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("1");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("2");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("3");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("4");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("5");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("6");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("7");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("8");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("9");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert(".");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(top.getSelectionStart()!=0){
                backspace();
                top.setText(show);
                top.setSelection(cursor_pos-1);}
                else{
                    Toast.makeText(getApplicationContext(),"Cursor at: 0",Toast.LENGTH_LONG).show();
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("+");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("-");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("*");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("/");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("^");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        firstbracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert("(");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        closingbracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insert(")");
                top.setText(show);
                top.setSelection(cursor_pos+1);
            }
        });
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                result=Calc.eval(expression);
                bottom.setText("=  "+result.toString());
                }catch(Exception e){
                    Toast.makeText(getApplicationContext(),"Most probably the expression is invalid",Toast.LENGTH_LONG).show();
                }
            }
        });
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!result.toString().equals("")){
                    expression=show=result.toString();
                    top.setText(show);
                    bottom.setText("");
                    top.setSelection(show.length());
                }
            }
        });
        copytoclip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("answer", bottom.getText().toString().substring(3));
                clipboard.setPrimaryClip(clip);
                Toast.makeText(getApplicationContext(),"Answer copied to clipboard",Toast.LENGTH_SHORT).show();
            }
        });
        allClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                top.setText("");
                bottom.setText("");
                expression=show="";
            }
        });
    }

    private static void stringChopper(){
        cursor_pos=top.getSelectionStart();
        exp_head = expression.substring(0,cursor_pos);
        show_head = show.substring(0,cursor_pos);
        exp_tail = expression.substring(cursor_pos);
        show_tail =show.substring(cursor_pos);
    }
    private static void backspace(){
        stringChopper();
        expression=exp_head.substring(0,exp_head.length()-1)+exp_tail;
        show=show_head.substring(0,show_head.length()-1)+show_tail;
    }
    private static void insert(String op){
        stringChopper();
        if(op.equals("*")){
            expression=exp_head+"*"+exp_tail;
            show=show_head+"×"+show_tail;
        }else if(op.equals("/")){
            expression=exp_head+"/"+exp_tail;
            show=show_head+"÷"+show_tail;
        }
        else{
        expression=exp_head+op+exp_tail;
        show=show_head+op+show_tail;}
    }

}