package com.example.brulette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.service.autofill.TextValueSanitizer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.brulette.BetTypes.Columna;
import com.example.brulette.BetTypes.DesdeHasta;
import com.example.brulette.BetTypes.Docena;
import com.example.brulette.BetTypes.Paridad;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public Brulette app;
    public static Context context;
    public TextView[] fields = new TextView[37];
    public TextView[] docenas = new TextView[3];
    public TextView[] columns = new TextView[3];
    public TextView par;
    public TextView impar;
    public TextView V1a18;
    public TextView V19a36;
    public TextView numberIn;
    public TextView errorCode;
    public Button buttonIn;
    public Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Getting the context of the app
        this.context = getApplicationContext();

        //Getting an instance of the app
        this.app = Brulette.getBrulette();

        //Constructing all the views
        this.constructingComponents();
        this.updateTextViews();
    }

    private void constructingComponents() {
        this.fields[0] = (TextView) findViewById(R.id.textView41);
        this.fields[1] = (TextView) findViewById(R.id.textView);
        this.fields[2] = (TextView) findViewById(R.id.textView14);
        this.fields[3] = (TextView) findViewById(R.id.textView2);
        this.fields[4] = (TextView) findViewById(R.id.textView21);
        this.fields[5] = (TextView) findViewById(R.id.textView28);
        this.fields[6] = (TextView) findViewById(R.id.textView35);
        this.fields[7] = (TextView) findViewById(R.id.textView3);
        this.fields[8] = (TextView) findViewById(R.id.textView8);
        this.fields[9] = (TextView) findViewById(R.id.textView15);
        this.fields[10] = (TextView) findViewById(R.id.textView22);
        this.fields[11] = (TextView) findViewById(R.id.textView30);
        this.fields[12] = (TextView) findViewById(R.id.textView36);
        this.fields[13] = (TextView) findViewById(R.id.textView4);
        this.fields[14] = (TextView) findViewById(R.id.textView9);
        this.fields[15] = (TextView) findViewById(R.id.textView16);
        this.fields[16] = (TextView) findViewById(R.id.textView23);
        this.fields[17] = (TextView) findViewById(R.id.textView31);
        this.fields[18] = (TextView) findViewById(R.id.textView37);
        this.fields[19] = (TextView) findViewById(R.id.textView5);
        this.fields[20] = (TextView) findViewById(R.id.textView10);
        this.fields[21] = (TextView) findViewById(R.id.textView17);
        this.fields[22] = (TextView) findViewById(R.id.textView25);
        this.fields[23] = (TextView) findViewById(R.id.textView32);
        this.fields[24] = (TextView) findViewById(R.id.textView38);
        this.fields[25] = (TextView) findViewById(R.id.textView6);
        this.fields[26] = (TextView) findViewById(R.id.textView12);
        this.fields[27] = (TextView) findViewById(R.id.textView18);
        this.fields[28] = (TextView) findViewById(R.id.textView26);
        this.fields[29] = (TextView) findViewById(R.id.textView34);
        this.fields[30] = (TextView) findViewById(R.id.textView40);
        this.fields[31] = (TextView) findViewById(R.id.textView7);
        this.fields[32] = (TextView) findViewById(R.id.textView13);
        this.fields[33] = (TextView) findViewById(R.id.textView19);
        this.fields[34] = (TextView) findViewById(R.id.textView27);
        this.fields[35] = (TextView) findViewById(R.id.textView33);
        this.fields[36] = (TextView) findViewById(R.id.textView39);
        this.docenas[0] = (TextView) findViewById(R.id.docena1);
        this.docenas[1] = (TextView) findViewById(R.id.docena2);
        this.docenas[2] = (TextView) findViewById(R.id.docena3);
        this.columns[0] = (TextView) findViewById(R.id.column1);
        this.columns[1] = (TextView) findViewById(R.id.column2);
        this.columns[2] = (TextView) findViewById(R.id.column3);
        this.par = (TextView) findViewById(R.id.parField);
        this.impar = (TextView) findViewById(R.id.imparField);
        this.V1a18 = (TextView) findViewById(R.id.field1a18);
        this.V19a36 = (TextView) findViewById(R.id.field19a36);
        this.errorCode = (TextView) findViewById(R.id.errorCode);
        this.numberIn = (EditText) findViewById(R.id.inNumber);
        this.buttonIn = (Button) findViewById(R.id.buttonIn);
        this.resetButton = (Button) findViewById(R.id.button2);

        //Code of the button to introduce
        this.buttonIn.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                EditText inNumber = findViewById(R.id.inNumber);
                if (inNumber.getText().toString().matches("")) {
                    errorCode.setText("Introduce a number");
                    return;
                } else if (inNumber.getText().toString().contains(",") || inNumber.getText().toString().contains(".")) {
                    errorCode.setText("Just digits");
                    return;
                }

                TextView errorCode = findViewById(R.id.errorCode);
                int number = Integer.parseInt(inNumber.getText().toString());

                if (number < 0 || number > 36) {
                    errorCode.setText("Wrong input. Allowed numbers are 0-36");
                } else {
                    errorCode.setText("Number introduced correctly");
                    Brulette.getBrulette().getRoulette().addResult(number);
                    updateTextViews();
                }
                Brulette.getBrulette().guardar();
                return;
            }
        });

        //Code of the button to reset
        this.resetButton.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Brulette.getBrulette().reset();
                updateTextViews();
            }
        });
    }

    private void updateTextViews() {
        double num = 0;
        DecimalFormat twoDForm = new DecimalFormat("#.##");

        for (int i = 0; i < 37; i++) {
            num = this.app.getRoulette().getNumeroData(i);
            this.fields[i].setText(twoDForm.format(num)+"");
        }
        for (int i = 0; i < 37; i++) this.fields[i].setTextColor(Color.BLACK);

        num = this.app.getRoulette().getDocenaData(Docena.PRIMERA);
        this.docenas[0].setText(twoDForm.format(num)+"");

        num = this.app.getRoulette().getDocenaData(Docena.SEGUNDA);
        this.docenas[1].setText(twoDForm.format(num)+"");

        num = this.app.getRoulette().getDocenaData(Docena.TERCERA);
        this.docenas[2].setText(twoDForm.format(num)+"");

        num = this.app.getRoulette().getColumnaData(Columna.PRIMERA);
        this.columns[0].setText(twoDForm.format(num)+"");

        num = this.app.getRoulette().getColumnaData(Columna.SEGUNDA);
        this.columns[1].setText(twoDForm.format(num)+"");

        num = this.app.getRoulette().getColumnaData(Columna.TERCERA);
        this.columns[2].setText(twoDForm.format(num)+"");

        num = this.app.getRoulette().getParidadData(Paridad.PAR);
        this.par.setText(twoDForm.format(num)+"");

        num = this.app.getRoulette().getParidadData(Paridad.IMPAR);
        this.impar.setText(twoDForm.format(num)+"");

        num = this.app.getRoulette().getDesdeHastaData(DesdeHasta.UNO18);
        this.V1a18.setText(twoDForm.format(num)+"");

        num = this.app.getRoulette().getDesdeHastaData(DesdeHasta.DIECINUEVE36);
        this.V19a36.setText(twoDForm.format(num)+"");
        this.updateColor();
    }

    private void updateColor() {
        int times = 0;
        int biggest = 0;
        int secondBiggest = 0;
        int thirdBiggest = 0;
        int smallest1 = 0;
        int smallest2 = 0;
        int smallest3 = 0;

        for (int n = 0; n < 37; n++)
            if (this.app.getRoulette().getNumeroTimes(n) > times) {
                times = this.app.getRoulette().getNumeroTimes(n);
                biggest = n;
            }

        times = 0;
        for (int n = 0; n < 37; n++)
            if (this.app.getRoulette().getNumeroTimes(n) > times && n != biggest) {
                times = this.app.getRoulette().getNumeroTimes(n);
                secondBiggest = n;
            }

        times = 0;
        for (int n = 0; n < 37; n++)
            if (this.app.getRoulette().getNumeroTimes(n) > times && n != biggest && n != secondBiggest) {
                times = this.app.getRoulette().getNumeroTimes(n);
                thirdBiggest = n;
            }

        times = 10000;
        for (int n = 0; n < 37; n++)
            if (this.app.getRoulette().getNumeroTimes(n) < times) {
                times = this.app.getRoulette().getNumeroTimes(n);
                smallest1 = n;
            }

        times = 10000;
        for (int n = 0; n < 37; n++)
            if (this.app.getRoulette().getNumeroTimes(n) < times && n != smallest1) {
                times = this.app.getRoulette().getNumeroTimes(n);
                smallest2 = n;
            }

        times = 10000;
        for (int n = 0; n < 37; n++)
            if (this.app.getRoulette().getNumeroTimes(n) < times && n != smallest1 && n != smallest2) {
                times = this.app.getRoulette().getNumeroTimes(n);
                smallest3 = n;
            }

        if (biggest == 0) return;
        this.fields[biggest].setTextColor(Color.GREEN);
        this.fields[secondBiggest].setTextColor(Color.GREEN);
        this.fields[thirdBiggest].setTextColor(Color.GREEN);
        this.fields[smallest1].setTextColor(Color.RED);
        this.fields[smallest2].setTextColor(Color.RED);
        this.fields[smallest3].setTextColor(Color.RED);
    }

    public static Context getContext() { return MainActivity.context; }
}