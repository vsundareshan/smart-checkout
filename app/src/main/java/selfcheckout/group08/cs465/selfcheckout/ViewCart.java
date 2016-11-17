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
    }
    public void onClick(View v){
        //respond to clicks
       /* if(v.getId()==R.id.add_to_cart){
            //scan
            Intent intent = new Intent(getApplicationContext(),CaptureActivity.class);
            startActivityForResult(intent, 0);
        }*/
    }
}
