package idv.john.ex4_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ResultActivity extends ActionBarActivity{
    Button btnBack;
    TextView tvBMI, tvContent;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_activity);
        findViews();
        getContent();
    }
    
    private void findViews() {
        tvBMI = (TextView) findViewById(R.id.tvBMI);
        tvContent = (TextView) findViewById(R.id.tvContent);
        
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    
    private void getContent() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int height = bundle.getInt("Height");
        int weight = bundle.getInt("Weight");
        double calc = weight/((height/100.0)*(height/100.0));
        
        String BMI = getString(R.string.bmi) + String.valueOf(decimalFormat.format(calc));
        tvBMI.setText(BMI);
        
        if (calc>=18.5 && calc<24) {
            tvContent.setText(getString(R.string.normal));
        }else if(calc >=24) {
            tvContent.setText(getString(R.string.over_weight));
        }
    }
}
