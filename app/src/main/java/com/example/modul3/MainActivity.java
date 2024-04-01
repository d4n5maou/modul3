package com.example.modul3;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TextWatcher {
    AutoCompleteTextView ac;
    public String[] stringdatafak = {"Teknik Informatika", "Sistem informasi",
            "Desain Komunikasi Visual","Manajemen Informasi"};
    EditText lv;

    private String lifeCycle = "androidlifecycle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ac = findViewById(R.id.dataautocomplete);
        ac.addTextChangedListener(this);
        ac.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, stringdatafak));
    }

    public void pilihfakultas(View v) {
        lv = findViewById(R.id.datalistview);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Data Fakultas Ilmu Komputer");
        builder.setItems(stringdatafak, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                lv.setText(stringdatafak[item]);
                dialog.dismiss();
            }
        }).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Posisi lagi start nih", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Posisi lagi stop nih", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Posisi lagi Resume nih", Toast.LENGTH_LONG).show();
        TextView txt1 = findViewById(R.id.txt1);
        txt1.setText("POSISI LAGI RESUME");
        Log.i(lifeCycle, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Posisi lagi pause nih", Toast.LENGTH_LONG).show();
        LinearLayout linearLayout = findViewById(R.id.linearParent);
        linearLayout.setBackgroundColor(getResources().getColor(R.color.purple_200));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Posisi udah hancur nih", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void afterTextChanged(Editable s) {}
}
