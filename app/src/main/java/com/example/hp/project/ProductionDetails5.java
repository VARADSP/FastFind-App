package com.example.hp.project;

        import android.app.DatePickerDialog;
        import android.content.Intent;
        import android.graphics.Color;
        import android.graphics.drawable.ColorDrawable;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.DatePicker;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;
        import java.util.Calendar;

public class ProductionDetails5 extends AppCompatActivity {
    private static final String TAG = "ProductionDetails5";
    private DatePickerDialog.OnDateSetListener cDateSetListener;
    private DatePickerDialog.OnDateSetListener dDateSetListener;
    private EditText piercingMcNo;
    private EditText piercingStart;
    private EditText piercingComplete;
    private EditText piercingInputQty;
    private EditText piercingAcceptedQty;
    private EditText piercingRejectedQty;
    private TextView piercingOutputQty;
    private TextView piercingoutput;
    private EditText piercingRecieptNo;
    private EditText piercingRemark;
    Button next8Btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_production_details5);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        piercingMcNo = (EditText)findViewById(R.id.piercing_machine_no);
        piercingStart = (EditText)findViewById(R.id.piercing_start_date);
        piercingComplete = (EditText) findViewById(R.id.piercing_comp_date);
        piercingInputQty = (EditText) findViewById(R.id.piercing_input_quantity);
        piercingAcceptedQty = (EditText) findViewById(R.id.piercing_accepted_quantity);
        piercingRejectedQty = (EditText) findViewById(R.id.piercing_rejected_quantity);
        piercingOutputQty = (TextView) findViewById(R.id.piercing_output_qty1);
        piercingoutput = (TextView)findViewById(R.id.piercing_output_qty);
        piercingRecieptNo = (EditText) findViewById(R.id.piercing_prod_receipt_no);
        piercingRemark = (EditText) findViewById(R.id.piercing_remark);
        next8Btn = (Button)findViewById(R.id.next8_btn);

        next8Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (piercingMcNo.getText().toString().length() == 0) {
                    piercingMcNo.setError("Input Needed");
                    piercingMcNo.requestFocus();
                }else if (piercingStart.getText().toString().length() == 0) {
                    piercingStart.setError("Input Needed");
                    piercingStart.requestFocus();
                } else if (piercingComplete.getText().toString().length() == 0) {
                    piercingComplete.setError("Input Needed");
                    piercingComplete.requestFocus();
                } else if (piercingInputQty.getText().toString().length() == 0) {
                    piercingInputQty.setError("Input Needed");
                    piercingInputQty.requestFocus();
                } else if (piercingAcceptedQty.getText().toString().length() == 0) {
                    piercingAcceptedQty.setError("Input Needed");
                    piercingAcceptedQty.requestFocus();
                } else if (piercingRejectedQty.getText().toString().length() == 0) {
                    piercingRejectedQty.setError("Input Needed");
                    piercingRejectedQty.requestFocus();
                }else if(piercingOutputQty.getText().toString().length() == 0){
                    piercingOutputQty.setError("Input Needed");
                    piercingOutputQty.requestFocus();
                }
                else {
                    Toast.makeText(ProductionDetails5.this, "Next clicked", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplication(), ProductionDetails6.class));
                }
            }
        });

        piercingStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails5.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        cDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        cDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: dd/mm/yyyy:" + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                piercingStart.setText(date);
            }
        };
        piercingComplete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        ProductionDetails5.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        dDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        dDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month=month+1;
                Log.d(TAG,"onDateSet: dd/mm/yyyy:" + day + "/" + month + "/" + year);
                String date = day + "/" + month + "/" + year;
                piercingComplete.setText(date);
            }
        };

        piercingoutput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int accepteQty = Integer.parseInt(piercingAcceptedQty.getText().toString());
                int rejectQty = Integer.parseInt(piercingRejectedQty.getText().toString());
                int result = accepteQty - rejectQty;
                piercingOutputQty.setText(""+result);
            }
        });
    }
}


