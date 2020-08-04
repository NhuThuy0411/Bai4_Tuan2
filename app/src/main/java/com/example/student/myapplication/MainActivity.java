package com.example.student.myapplication;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText hoten, cmnd, thongtin;
    CheckBox docbao, docsach, coding;
    RadioButton trungcap, caodang, daihoc;
    Button guithongtin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hoten = (EditText)findViewById(R.id.txthoten);
        cmnd = (EditText)findViewById(R.id.txtcmnd);
        thongtin = (EditText)findViewById(R.id.txtThongtin);

        docbao = (CheckBox)findViewById(R.id.chkDocbao);
        docsach = (CheckBox) findViewById(R.id.chkDocsach);
        coding = (CheckBox) findViewById(R.id.chkCoding);

        guithongtin = (Button) findViewById(R.id.btnGui);
        guithongtin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doShowInfomation();
            }
        });
    }

    public void doShowInfomation()
    {
        String ten = hoten.getText()+"";
        ten = ten.trim();
        if(ten.length() < 3)
        {
            hoten.requestFocus();
            hoten.selectAll();
            Toast.makeText(this, "Tên phải >= 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        String cm = cmnd.getText()+"";
        cm = cm.trim();
        if(cm.length() != 9)
        {
            cmnd.requestFocus();
            cmnd.selectAll();
            Toast.makeText(this, "CMND phải bao gồm 9 kí tự", Toast.LENGTH_LONG).show();
            return;
        }

        String bang = "";
        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup1);
        int id = group.getCheckedRadioButtonId();
        if(id == -1)
        {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad = (RadioButton) findViewById(id);
        bang = rad.getText()+"";

        String sothich= "";
        if(docbao.isChecked())
            sothich += docbao.getText()+"\n";
        if(docsach.isChecked())
            sothich += docsach.getText()+"\n";
        if(coding.isChecked())
            sothich += coding.getText()+"\n";

        String themthongtin = thongtin.getText()+"";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });

        String msg = ten + "\n";
        msg += cm +"\n";
        msg += bang +"\n";
        msg += sothich;
        msg += "----------------------\n";
        msg += "Thông tin bổ sung: \n";
        msg += themthongtin+ "\n";
        msg += "-----------------";
        builder.setMessage(msg);
        builder.create().show();
    }


}
