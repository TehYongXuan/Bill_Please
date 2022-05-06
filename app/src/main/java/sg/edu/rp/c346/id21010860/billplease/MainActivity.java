package sg.edu.rp.c346.id21010860.billplease;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    Button btnReset;
    Button btnSplit;
    EditText Input1;
    EditText Input2;
    EditText Input3;
    TextView displayview;
    TextView splitview;
    ToggleButton toggleButton1;
    ToggleButton toggleButton2;
    RadioGroup paygroup;
    RadioButton cashB;
    RadioButton paynowB;


    double amount = 0.0;
    double pax = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSplit = findViewById(R.id.button1);
        btnReset = findViewById(R.id.button2);
        Input1 = findViewById(R.id.editText1);
        Input2 = findViewById(R.id.editText2);
        Input3 = findViewById(R.id.editText3);
        displayview = findViewById(R.id.textviewdisplay);
        toggleButton1 = findViewById(R.id.toggleButtonsvs);
        toggleButton2 = findViewById(R.id.toggleButtongst);
        splitview = findViewById(R.id.textviewsplit);
        paygroup = findViewById(R.id.radioGroup);
        paynowB = findViewById(R.id.paynow);
        cashB = findViewById(R.id.cash);

        paygroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = "";
                String cashtxt = (String.valueOf(cashB.getText()));
                int checkedRadioId = paygroup.getCheckedRadioButtonId();


                if (checkedRadioId == R.id.cash) {
                    // Write the code when cash selected

                    txt = "Total Bill: $ " + txt;
                    txt = "Each Pays: $ " + amount + "in cash";

                } else {
                    // Write the code when paynow selected
                    txt = "Total Bill: $ " + txt;
                    txt = "Each Pays: $ " + amount + "in PayNow";
                }
            }
            });

                    btnSplit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            double amount = Double.parseDouble(String.valueOf(Input1.getText()));
                            double pax = Double.parseDouble(String.valueOf(Input2.getText()));
                            double discount = Double.parseDouble(String.valueOf(Input3.getText()));
                            if (toggleButton1.isChecked()) {
                                double totalAmount =( amount * 1.1 )-(amount*(discount/100));
                                String txt = toggleButton1.getText();
                                txt = "Total Bill: $ " + totalAmount;
                            } else if
                            (toggleButton2.isChecked()) {
                                double totalAmount = (amount * 1.07 )-(amount *(discount/100));
                            } else if (toggleButton1.isChecked() && toggleButton2.isChecked()) {
                                double totalAmount = (amount * 1.17 )- (amount *(discount/100));
                            } else {
                                double totalAmount = (amount + 0.0 )- (amount *(discount/100));
                      double eachpax = totalAmount/pax;

                      splitview.setText(String.format("Total Bill: $%.2f" , totalAmount));
                      displayview.setText(String.format("Each Pays: $%.2f",eachpax));
                            }
                        }

                    });


                }
            }