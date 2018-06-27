package foolcreator.formulario;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button siguiente;
    EditText nombre;
    EditText telefono;
    EditText email;
    EditText descripcion;

    String nombreSTR;
    String telefonoSTR;
    String emailSTR;
    String descripcionSTR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombre);
        telefono = findViewById(R.id.telefono);
        email = findViewById(R.id.email);
        descripcion = findViewById(R.id.descripcion);
        siguiente = findViewById(R.id.siguiente);

        siguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intento = new Intent( MainActivity.this, SecondActivity.class);

                nombreSTR = nombre.getText().toString();
                telefonoSTR = telefono.getText().toString();
                emailSTR = email.getText().toString();
                descripcionSTR = descripcion.getText().toString();

                DatePicker fecha = (DatePicker) findViewById(R.id.fecha);
                    int diaEnviado = fecha.getDayOfMonth();
                    int mesEnviado = fecha.getMonth()+1;
                    int anioEnviado = fecha.getYear();

                StringBuilder fechaSTR = new StringBuilder("");
                    fechaSTR.append(diaEnviado).toString();
                    fechaSTR.append("/").toString();
                    fechaSTR.append(mesEnviado).toString();
                    fechaSTR.append("/").toString();
                    fechaSTR.append(anioEnviado).toString();


                Bundle cajita = new Bundle();
                    cajita.putString("nombreSTR",nombreSTR);
                    cajita.putString("fechaSTR",fechaSTR.toString());
                    cajita.putString("telefonoSTR",telefonoSTR);
                    cajita.putString("emailSTR",emailSTR);
                    cajita.putString("descripcionSTR",descripcionSTR);

            intento.putExtras(cajita);
            startActivity(intento);

            }

        });//fin siguiente


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){
                String result=data.getStringExtra("result");
                //nombre.setText(result.toString());
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

}
