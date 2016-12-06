package selfcheckout.group08.cs465.selfcheckout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * Created by vsundareshan on 11/17/16.
 */

public class Account  extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = Account.class.getSimpleName();

    private Button addToCartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
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
            //open scanner
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }else if(v.getId()==R.id.cart_button){
            intent = new Intent(getApplicationContext(),ViewCart.class);
        }else if(v.getId()==R.id.account_button){
            intent = new Intent(getApplicationContext(),Account.class);
        }
        startActivity(intent);
    }
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        try {
            super.startActivityForResult(intent, requestCode);
        } catch (Exception ignored){}
    }
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            //we have a result
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            Log.i(TAG,"Scan Format:"+scanFormat);
            Log.i(TAG,"Scan CONTENT:"+scanContent);

            //TODO this is where a service call could be made to resolve product details from scan Content.
            intent = new Intent(getApplicationContext(),Product.class);
            intent.putExtra(Scanner.PRODUCT_NAME,scanContent);
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
