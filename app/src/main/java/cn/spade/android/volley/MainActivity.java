package cn.spade.android.volley;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;


public class MainActivity extends Activity {

  @InjectView(R.id.textview) TextView mTextView;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.inject(this);
    mTextView.setText("zhaosc");
    String url = "http://www.baidu.com";
    RequestQueue requestQueue = Volley.newRequestQueue(this);
    StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
      @Override
      public void onResponse(String response) {
        Log.d("TAG", response);
      }
    }, new Response.ErrorListener() {
      @Override
      public void onErrorResponse(VolleyError error) {
        Log.e("TAG", error.getMessage(), error);
      }
    });

    url = "http://m.weather.com.cn/data/101010100.html";
    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url,
      null, new Response.Listener<JSONObject>(){
      @Override public void onResponse(JSONObject response) {
        Log.d("TAG", response.toString());
      }
    }, new Response.ErrorListener(){
      @Override public void onErrorResponse(VolleyError error) {
        Log.e("TAG", error.getMessage(), error);
      }
    });
    requestQueue.add(jsonObjectRequest);
  }


  @OnClick({R.id.textview, R.id.textview})
  public void onClick(View view){
    switch (view.getId()){

    }
  }
}
