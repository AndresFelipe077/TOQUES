package apps.educacion.numeros.moverobjectos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.example.numeros.R;

public class moverObjecto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mover_objecto);



    }// fin de onCreate

    public class MoverView extends View{
        float [] x = {50,130};
        float [] y = {50,100};
        float [] radio = {20,50};

        Paint paint[] = new Paint[2];
        Paint p;

        int circulo = -1;
        String text = "Mueve el circulo";

        public MoverView(Context context) {
            super(context);

            paint[0] = new Paint();
            paint[0].setAntiAlias(true);
            paint[0].setColor(Color.BLUE);

            paint[1] = new Paint();
            paint[1].setAntiAlias(true);
            paint[1].setColor(Color.YELLOW);

            p = new Paint();
            p.setAntiAlias(true);
            p.setColor(Color.GRAY);
            p.setTextSize(20);

        }//fin de MoverView



        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            canvas.drawColor(Color.argb(255,200,33,23));

            canvas.drawText(text,50,30,p);

            for(int i = 0; i<2; i++){
                canvas.drawCircle(x[i],y[i],radio[i],paint[i]);
            }

        }//fin de onDraw

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            //return super.onTouchEvent(event);
            float getx = event.getX();
            float gety = event.getY();
            int accion = event.getAction();

            if (accion == MotionEvent.ACTION_DOWN){
                for (int i = 0;i < 2; i++){
                    double cenx = getx - x[i];
                    double ceny = gety - y[i];

                    float distancia = (float) Math.sqrt(cenx * cenx + ceny * ceny);
                    if (distancia <= radio[i]){

                        circulo = i;
                        text = "EL circulo tocado es "+i;
                        invalidate();
                    }//fin del if
                }
            }

            if (accion == MotionEvent.ACTION_MOVE){

                if (circulo > -1){
                    x[circulo] = getx;
                    y[circulo] = gety;
                    invalidate();
                }

            }//fin del if
            //return super.onTouchEvent(event);
            return true;
        }


    }//fin de MoverView toda la clase


}// fin de moverObjeto