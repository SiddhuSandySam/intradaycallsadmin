package com.technosandy.developer.intradaycallsadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

   EditText magic,advmagic,entry,sscode,positional,momentum,option,option2,master1,storm,volbo,accopn,slhunt,sr, livecount;


   Button submit,uploadmaster,uploadstorm,uploadaccopn,uploadvolbo,uploadsl,uploadsr;
   Button delet;
   String upload="https://techsandy.tech/uploadintradaycalls.php";
   String delete="https://techsandy.tech/deleteintradaycalls.php";

    String uploadmasterfile="https://techsandy.tech/uploadmaster.php";
    String uploadstormfile="https://techsandy.tech/uploadstorm1.php";
    String uploadaccopnfile="https://techsandy.tech/uploadaccopn.php";
    String uploadvol="https://techsandy.tech/uploadvol.php";
    String uploadslhunt="https://techsandy.tech/uploadslhunt.php";
    String uploadsrs="https://techsandy.tech/uploadsr.php";

    String master2, storm2, volbo2, accopn2,sl2,sr2, lc;

    int j,k,l,m,n,o,p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        magic=findViewById(R.id.magic);
        advmagic=findViewById(R.id.advmagic);
        entry=findViewById(R.id.entry);
        sscode=findViewById(R.id.sscode);
        positional=findViewById(R.id.positional);
        momentum=findViewById(R.id.momentum);
        option=findViewById(R.id.optiontrading);
        option2=findViewById(R.id.optiontrading2);
        master1=findViewById(R.id.master1);
        storm=findViewById(R.id.storm);
        uploadstorm=findViewById(R.id.uploadstorm);
        volbo=findViewById(R.id.volbo);
        accopn=findViewById(R.id.accopn);
        slhunt=findViewById(R.id.slhunt);
        sr=findViewById(R.id.srstrategy);
        livecount=findViewById(R.id.livecount);

        submit=findViewById(R.id.submit);
        delet=findViewById(R.id.delete);
        uploadmaster=findViewById(R.id.uploadmaster);
        uploadaccopn=findViewById(R.id.uploadaccopn);
        uploadvolbo=findViewById(R.id.uploadvol);
        uploadsl=findViewById(R.id.uploadsl);
        uploadsr=findViewById(R.id.uploadsr);



        Async mainimage = new Async();
        mainimage.execute();

         j = new Random().nextInt(1000); // [0, 60] + 20 => [20, 80]
         k = new Random().nextInt(1000); // [0, 60] + 20 => [20, 80]
         l = new Random().nextInt(1000); // [0, 60] + 20 => [20, 80]
         m = new Random().nextInt(1000); // [0, 60] + 20 => [20, 80]
         n = new Random().nextInt(1000); // [0, 60] + 20 => [20, 80]
         o = new Random().nextInt(1000); // [0, 60] + 20 => [20, 80]
         p = new Random().nextInt(1000); // [0, 60] + 20 => [20, 80]


        submit.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {



//                final String scr=magic.getText().toString();
//                final String ent=advmagic.getText().toString();
//                final String tar=entry.getText().toString();
//                final String stoploss=sscode.getText().toString();
//                final String positional1=positional.getText().toString();
//                final String momentm=momentum.getText().toString();
//                final String optns=option.getText().toString();
//                final String optns2=option2.getText().toString();
//                final String mast=master1.getText().toString();

                final String scr=String.valueOf(j);
                final String ent=String.valueOf(j);
                final String tar=String.valueOf(j);
                final String stoploss=String.valueOf(j);
                final String positional1=String.valueOf(j);
                final String momentm=String.valueOf(j);
                final String optns=String.valueOf(j);
                final String optns2=String.valueOf(j);
                final String mast=String.valueOf(j);


                StringRequest request=new StringRequest(Request.Method.POST, upload, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            String status=object.getString("status");
                            if (status=="1")
                            {
                                Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Error"+error,Toast.LENGTH_LONG).show();
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                      Map<String,String> param=new HashMap<>();
                      param.put("sc",scr);
                      param.put("en",ent);
                      param.put("ta",tar);
                      param.put("st",stoploss);
                      param.put("pos",positional1);
                      param.put("mom",momentm);
                      param.put("optn",optns);
                      param.put("optn2",optns2);
                      param.put("master",mast);

                        return param;
                    }
                };
                Volley.newRequestQueue(MainActivity.this).add(request);
            }
        });


        delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringRequest request=new StringRequest(Request.Method.POST, delete, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            String status=object.getString("status");
                            if (status=="1")
                            {
                                Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                Volley.newRequestQueue(getApplicationContext()).add(request);

            }
        });

        uploadmaster.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                final String mast=String.valueOf(k);
                StringRequest request=new StringRequest(Request.Method.POST, uploadmasterfile, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            String status=object.getString("status");
                            if (status=="1")
                            {
                                Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Error"+error,Toast.LENGTH_LONG).show();
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> param=new HashMap<>();

                        param.put("master",mast);

                        return param;
                    }
                };
                Volley.newRequestQueue(MainActivity.this).add(request);
            }
        });


        uploadstorm.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                final String storm1=String.valueOf(k);
                StringRequest request=new StringRequest(Request.Method.POST, uploadstormfile, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            String status=object.getString("status");
                            if (status=="1")
                            {
                                Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Error"+error,Toast.LENGTH_LONG).show();
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> param=new HashMap<>();

                        param.put("storm",storm1);

                        return param;
                    }
                };
                Volley.newRequestQueue(MainActivity.this).add(request);
            }
        });

        uploadaccopn.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                final String accopn1=String.valueOf(m);
                StringRequest request=new StringRequest(Request.Method.POST, uploadaccopnfile, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            String status=object.getString("status");
                            if (status=="1")
                            {
                                Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Error"+error,Toast.LENGTH_LONG).show();
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> param=new HashMap<>();

                        param.put("storm",accopn1);

                        return param;
                    }
                };
                Volley.newRequestQueue(MainActivity.this).add(request);
            }
        });

        uploadvolbo.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                final String volbo1=String.valueOf(k);
                StringRequest request=new StringRequest(Request.Method.POST, uploadvol, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            String status=object.getString("status");
                            if (status=="1")
                            {
                                Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Error"+error,Toast.LENGTH_LONG).show();
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> param=new HashMap<>();

                        param.put("vol",volbo1);

                        return param;
                    }
                };
                Volley.newRequestQueue(MainActivity.this).add(request);
            }
        });

        uploadsl.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                final String sl =String.valueOf(o);
                StringRequest request=new StringRequest(Request.Method.POST, uploadslhunt, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            String status=object.getString("status");
                            if (status=="1")
                            {
                                Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Error"+error,Toast.LENGTH_LONG).show();
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> param=new HashMap<>();

                        param.put("slhunt",sl);

                        return param;
                    }
                };
                Volley.newRequestQueue(MainActivity.this).add(request);
            }
        });

        uploadsr.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                final String sr =String.valueOf(p);
                StringRequest request=new StringRequest(Request.Method.POST, uploadsrs, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object=new JSONObject(response);
                            String status=object.getString("status");
                            if (status=="1")
                            {
                                Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"Error"+error,Toast.LENGTH_LONG).show();
                    }
                })
                {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> param=new HashMap<>();

                        param.put("sr",sr);

                        return param;
                    }
                };
                Volley.newRequestQueue(MainActivity.this).add(request);
            }
        });
    }

    public class Async extends AsyncTask<String, String, String> {

        String callsurl = "https://techsandy.tech/intradaycalls.php";

        @Override
        protected String doInBackground(String... strings) {
            //    intradayCallsModels.clear();
            StringRequest request = new StringRequest(Request.Method.GET, callsurl, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONArray array = new JSONArray(response);
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject object = array.getJSONObject(i);
                             master2 = object.getString("master");
                             storm2 = object.getString("storm");
                             volbo2 = object.getString("volbo");
                             accopn2 = object.getString("acopn");
                             sl2 = object.getString("slhunt");
                             sr2 = object.getString("sr");
                             lc = object.getString("lc");


                            master1.setText(master2);
                            storm.setText(storm2);
                            volbo.setText(volbo2);
                            accopn.setText(accopn2);
                            slhunt.setText(sl2);
                            sr.setText(sr2);
                            livecount.setText(lc);


                            //   intradayCallsModels.add(new IntradayCallsModel(script, entry, target, sl));
//                            Global.magic = object.getString("script");
//                            Global.advmagic = object.getString("entry");
//                            Global.entry = object.getString("target");
//                            Global.sscode = object.getString("sl");
//                            Global.positional = object.getString("positional");
//                            Global.momentum = object.getString("momentum");
//                            Global.options = object.getString("options");
//                            Global.options2 = object.getString("options2");
//                            Global.mastercode = object.getString("master");
//                            Global.indexoptns = object.getString("index");
//                            Global.todaypurchase = object.getString("todaypurchase");
//                            Global.totalpurchase = object.getString("totalpurchase");
//                            Global.storm = object.getString("storm");
//                            Global.volbo = object.getString("volbo");
//                            Global.accopncode = object.getString("acopn");
//
//                            todaypurchase.setText(Global.todaypurchase);
//                            totalpurchase.setText(Global.totalpurchase);




                        }

//                        IntradayRecyclerAdapter adapter = new IntradayRecyclerAdapter(getApplicationContext(), intradayCallsModels);
//                        recyclerView.setAdapter(adapter);
                        //Toast.makeText(getApplicationContext(), premcode, Toast.LENGTH_LONG).show();


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            });
            Volley.newRequestQueue(getApplicationContext()).add(request);

            return "process complete";
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

