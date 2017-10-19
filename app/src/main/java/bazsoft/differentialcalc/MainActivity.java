package bazsoft.differentialcalc;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected Expression finalres;
    protected static int lastclick;
    protected boolean mode=false;
    public static Expression[] Expressions = new Expression[20];
    public static int cursor=0;
    protected static String curtext;
    public static TextView expressionview;
    public static void checkcalc()
    {
        curtext = expressionview.getText().toString();
        if(lastclick==3 && Expressions[cursor]!=null && cursor>0){
            Expressions[cursor -1] = new Product(Expressions[cursor-1],Expressions[cursor]);
            Expressions[cursor] = null;
            cursor--;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button dydybut = (Button)findViewById(R.id.derivativechoosebut);
        final Button integralbut = (Button)findViewById(R.id.Integralchoosebut);
        Button decimalsep = (Button)findViewById(R.id.decimalsep);
        Button evalbut = (Button)findViewById(R.id.evalbut);
        Button clearbut = (Button)findViewById(R.id.clear);
        Button variablebut = (Button)findViewById(R.id.variablebut);
        Button plusbut = (Button)findViewById(R.id.plusbut);
        Button minusbut = (Button)findViewById(R.id.minusbut);
        Button productbut = (Button)findViewById(R.id.productbut);
        Button dividebut = (Button)findViewById(R.id.dividebut);
        Button sinbut = (Button)findViewById(R.id.sinbut);
        Button cosbut = (Button)findViewById(R.id.cosbut);
        Button tanbut = (Button)findViewById(R.id.tanbut);
        Button equalbut = (Button)findViewById(R.id.equalbut);
        Button powerbut = (Button)findViewById(R.id.powerbut);
        Button lnbut = (Button)findViewById(R.id.lnbut);
        Button onebut = (Button)findViewById(R.id.onebut);
        Button twobut = (Button)findViewById(R.id.twobut);
        Button threebut = (Button)findViewById(R.id.threebut);
        Button fourbut = (Button)findViewById(R.id.fourbut);
        Button fivebut = (Button)findViewById(R.id.fivebut);
        Button sixbut = (Button)findViewById(R.id.sixbut);
        Button sevenbut = (Button)findViewById(R.id.sevenbut);
        Button eightbut = (Button)findViewById(R.id.eightbut);
        Button ninebut = (Button)findViewById(R.id.ninebut);
        Button zerobut = (Button)findViewById(R.id.zerobut);

        expressionview = (TextView)findViewById(R.id.expressionview);
        dydybut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dydybut.setClickable(false);
                integralbut.setClickable(true);
                mode = false;

            }
        });
        integralbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                integralbut.setClickable(false);
                dydybut.setClickable(true);
                mode = true;
            }
        });
        variablebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressionview.setText(expressionview.getText()+"X");
                Expressions[cursor]= new Variable(1.0);
                checkcalc();
            }
        });
        productbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cursor++;
                lastclick = 3;
                expressionview.setText(expressionview.getText()+"*");
            }
        });
        equalbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                curtext = expressionview.getText().toString();
                expressionview.setText(null);
                int i=0;
                if(mode)Expressions[cursor]= null; //dfinalres= finalres.integrate();
                else{

                    expressionview.setText(Expressions[0].derive().toString());
                    while(Expressions[i+1]!=null) {

                        expressionview.setText(expressionview.getText() + Expressions[i].derive().toString());
                        i++;
                    }
                }

            }
        });
        zerobut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(Expressions[cursor]!= null)
                {
                    expressionview.setText(expressionview.getText()+"0");
                    Expressions[cursor] = new Constant(Double.valueOf(Expressions[cursor].toString()).doubleValue()*10);}
                else
                {
                    expressionview.setText("0");
                    Expressions[cursor] = new Constant(0.0);}
                lastclick=-1;
                checkcalc();
            }
        });
        onebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Expressions[cursor]!= null)
                {
                    expressionview.setText(expressionview.getText()+"1");
                    Expressions[cursor] = new Constant((Double.valueOf(Expressions[cursor].toString()).doubleValue()*10)+1);}
                else
                {
                    expressionview.setText("1");
                    Expressions[cursor] = new Constant(1.0);}

                checkcalc();
                lastclick=-1;
            }
        });
        twobut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Expressions[cursor]!= null)
                {
                    expressionview.setText(expressionview.getText()+"2");
                    Expressions[cursor] = new Constant((Double.valueOf(Expressions[cursor].toString()).doubleValue()*10)+2);}
                else
                {
                    expressionview.setText(expressionview.getText()+"2");
                    Expressions[cursor] = new Constant(2.0);}

                checkcalc();
                lastclick=-1;
            }
        });
        decimalsep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                expressionview.setText(expressionview.getText()+".");
            }
        });
        clearbut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int i=0;
                while(Expressions[i]!=null)
                {
                    Expressions[i]= null;
                    i++;
                }
                i=0;
                expressionview.setText(null);
                cursor=0;

            }
        });
    }
}
