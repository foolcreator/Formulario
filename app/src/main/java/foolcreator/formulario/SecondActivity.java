package foolcreator.formulario;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class SecondActivity extends AppCompatActivity {

    TextView nombreRecibido;
    TextView fechaRecibida;
    TextView telRecibido;
    TextView emailRecibido;
    TextView descRecibido;
    Bundle cajita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nombreRecibido = findViewById(R.id.nombre);
        fechaRecibida = findViewById(R.id.fecha);
        telRecibido = findViewById(R.id.telefono);
        emailRecibido = findViewById(R.id.email);
        descRecibido = findViewById(R.id.descripcion);

         cajita = getIntent().getExtras();
        String nombre = cajita.getString("nombreSTR");
        String fecha = cajita.getString("fechaSTR");
        String telefono = cajita.getString("telefonoSTR");
        String email = cajita.getString("emailSTR");
        String descripcion = cajita.getString("descripcionSTR");

        nombreRecibido.setText(nombre);
        fechaRecibida.setText(fecha);
        telRecibido.setText(telefono);
        emailRecibido.setText(email);
        descRecibido.setText(descripcion);

        modificarDatos();
    }

    private void modificarDatos(){
        Button modificarDatos = (Button) findViewById(R.id.modificarDatos);
        modificarDatos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                //startActivity(new Intent(SecondActivity.this,MainActivity.class));
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result",cajita);
                setResult(Activity.RESULT_OK,returnIntent);
                finish();

            }
        });//fin click

    }


}
