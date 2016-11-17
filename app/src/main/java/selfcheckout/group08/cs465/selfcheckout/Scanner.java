package selfcheckout.group08.cs465.selfcheckout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.client.android.CaptureActivity;

public class Scanner extends AppCompatActivity implements OnClickListener{
    private static final String TAG = Scanner.class.getSimpleName();


    private TextView formatTxt, contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);

        Button scanBtn = (Button)findViewById(R.id.scan_button);
        scanBtn.setOnClickListener(this);
        Button cartBtn = (Button)findViewById(R.id.cart_button);
        cartBtn.setOnClickListener(this);
        Button accountBtn = (Button)findViewById(R.id.account_button);
        accountBtn.setOnClickListener(this);
    }
    public void onClick(View v){
        Intent intent = null;
        //respond to clicks
        if(v.getId()==R.id.scan_button){
            //view product
            intent = new Intent(getApplicationContext(),Product.class);
        }else if(v.getId()==R.id.cart_button){
            intent = new Intent(getApplicationContext(),ViewCart.class);
        }else if(v.getId()==R.id.account_button){
            intent = new Intent(getApplicationContext(),Account.class);
        }
        startActivity(intent);
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        //retrieve scan result
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                String contents = intent.getStringExtra("SCAN_RESULT");
                Log.d(TAG, "contents: " + contents);
            } else if (resultCode == RESULT_CANCELED) {
                // Handle cancel
                Log.d(TAG, "RESULT_CANCELED");
            }
        }
    }
}
