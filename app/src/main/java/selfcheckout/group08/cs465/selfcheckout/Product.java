package selfcheckout.group08.cs465.selfcheckout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.integration.android.IntentIntegrator;

/**
 * Created by vsundareshan on 11/16/16.
 */

public class Product extends AppCompatActivity implements View.OnClickListener {
    private Button addToCartBtn;
    private static final String TAG = Product.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        Intent intent = getIntent();
        String productName = intent.getStringExtra(Scanner.PRODUCT_NAME);
        TextView textView = (TextView)findViewById(R.id.ProductName);
        textView.setText(productName);

        Button addCartBtn = (Button)findViewById(R.id.add_to_cart);
        addCartBtn.setOnClickListener(this);
        Button scanBtn = (Button)findViewById(R.id.scan_button);
        scanBtn.setOnClickListener(this);
        Button cartBtn = (Button)findViewById(R.id.cart_button);
        cartBtn.setOnClickListener(this);
        Button accountBtn = (Button)findViewById(R.id.account_button);
        accountBtn.setOnClickListener(this);
    }
    @Override
    public void startActivityForResult(Intent intent, int requestCode) {
        try {
            super.startActivityForResult(intent, requestCode);
        } catch (Exception ignored){}
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
        }else if(v.getId()==R.id.add_to_cart){
            intent = new Intent(getApplicationContext(),ViewCart.class);
        }
        startActivity(intent);
    }
}
