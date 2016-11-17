package selfcheckout.group08.cs465.selfcheckout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.zxing.client.android.CaptureActivity;

/**
 * Created by vsundareshan on 11/16/16.
 */

public class ViewCart  extends AppCompatActivity implements View.OnClickListener {
    private Button addToCartBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcart);
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
}
