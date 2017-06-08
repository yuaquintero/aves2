package com.example.administrador.aves;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ave_info extends AppCompatActivity {

    String Identificador;
    Integer id;
    SQLiteDatabase db;
    ImageButton canto,next,back;
    String codigoave;
    String nombreave;
    String inglesave;
    String cientificoave;
    String formaave;
    String color1ave;
    String color2ave ;
    String picoave ;
    String pataave;
    String linkave;
    String rutaave;
    String conservaave;
    String residenciaave;
    String vistasave;
    String codigoact1;
    CheckBox avistamiento;
    LinearLayout avefoto;

    //Para la galería
    private static final int PICK_IMAGE = 100;
    Uri imageUri=null;
    ImageView foto_gallery;
    int flag=0;


    int total;
    int i=0;


    private Permisos permiso;
    private View miLayout;
    private boolean camaraOk;

    TextView nombre,nombreingles,nombrecientifico,info1,info2,info3,info4,info5,info6,info7,info8,descripcion;
    ImageView pajaro;


    //Para la cámara
    private final String ruta_fotos = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + "/misAves/";
    private File file = new File(ruta_fotos);
    private ImageButton boton,compartir;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ave_info);
        Bundle extras = getIntent().getExtras();
        //getSupportActionBar().hide();

        nombre=(TextView) findViewById(R.id.ave_nombre);
        nombreingles=(TextView) findViewById(R.id.ave_nombre_en);
        nombrecientifico=(TextView) findViewById(R.id.ave_nombre_cientifico);
        info1=(TextView) findViewById(R.id.ave_informacion1);
        info2=(TextView) findViewById(R.id.ave_informacion2);
        info3=(TextView) findViewById(R.id.ave_informacion3);
        info4=(TextView) findViewById(R.id.ave_informacion4);
        info5=(TextView) findViewById(R.id.ave_informacion5);
        info6=(TextView) findViewById(R.id.ave_informacion6);
        info7=(TextView) findViewById(R.id.ave_informacion7);
        info8=(TextView) findViewById(R.id.ave_informacion8);
        descripcion=(TextView) findViewById(R.id.describe);
        canto=(ImageButton) findViewById(R.id.ave_link);
        next=(ImageButton) findViewById(R.id.next);
        back=(ImageButton) findViewById(R.id.back);
        avefoto=(LinearLayout)findViewById(R.id.fondoav);
        avistamiento=(CheckBox)findViewById(R.id.chequeo);
        miLayout = findViewById(R.id.activity_ave_info);
        permiso = new Permisos(miLayout,Ave_info.this);
        camaraOk = false;

        //Compartir
        compartir = (ImageButton) findViewById(R.id.btnCompartir);
        foto_gallery= (ImageView) findViewById(R.id.foto_gallery);

        //Cámara
        boton = (ImageButton) findViewById(R.id.btnTomaFoto);
        file.mkdirs(); //Crea el directorio

        Identificador=extras.getString("id");
        id = Integer.parseInt(Identificador);

        Aves_bd Ave = new Aves_bd(this);
        db=Ave.getWritableDatabase();


        String[] campos = new String[]{"codigo","color1","color2","colorpata","pico","forma","espanol","ingles","cientifico","residencia","conserva","link","rutas","vistas"};
        String[] args = new String[]{Identificador};
        Cursor c = db.query("Aves", campos, "codigo=?", args, null, null, null);

        if(c.moveToFirst()) {

            do {
                codigoave=c.getString(0);
                color1ave=c.getString(1);
                color2ave=c.getString(2);
                pataave=c.getString(3);
                picoave=c.getString(4);
                formaave=c.getString(5);
                nombreave=c.getString(6);
                inglesave=c.getString(7);
                cientificoave=c.getString(8);
                residenciaave=c.getString(9);
                conservaave=c.getString(10);
                linkave=c.getString(11);
                rutaave=c.getString(12);
                vistasave=c.getString(13);
            } while (c.moveToNext());
        }

        int resourceID = getResources().getIdentifier("ave_"+id, "drawable", getPackageName());
        int resourceID2 = getResources().getIdentifier("ave_"+id+"_a", "drawable", getPackageName());

        avefoto.setBackgroundResource(resourceID);
        //pajaro.setBackgroundResource(resourceID);


        final int[]fotoid={resourceID,resourceID2};
        total=fotoid.length;

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i--;
                if (i == -1) {
                    i = total - 1;
                }
                avefoto.setBackgroundResource(fotoid[i]);

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                i++;
                if (i == total) {
                    i = 0;
                }
                avefoto.setBackgroundResource(fotoid[i]);
            }
        });



        //

        //Toast.makeText(Ave_info.this, vistasave+" Ha sido avistada", Toast.LENGTH_SHORT).show();

        if (vistasave.equals("1")){
            avistamiento.setEnabled(false);
            avistamiento.setChecked(true);

        }


        avistamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (avistamiento.isChecked()) {

                    avistamiento.setEnabled(false);
                    Toast.makeText(Ave_info.this, nombreave+" "+getString(R.string.avistamiento2), Toast.LENGTH_SHORT).show();
                    String[] campos2 = new String[]{"codigo","color1","color2","colorpata","pico","forma","espanol","ingles","cientifico","residencia","conserva","link","rutas","vistas"};
                    String[] args2 = new String[]{Identificador};
                    Cursor c2 = db.query("Aves", campos2, "codigo=?", args2, null, null, null);
                    if(c2.moveToFirst()) {
                        do {
                            codigoave=c2.getString(0);
                        } while (c2.moveToNext());
                    }
                    ContentValues nuevoValor = new ContentValues();
                    nuevoValor.put("vistas","1");
                    db.update("Aves", nuevoValor, "codigo=" + codigoave, null);
                }
            }
        });

        switch(Integer.parseInt(codigoave)){
            case 1:
                descripcion.setText(R.string.d1);
                break;
            case 2:
                descripcion.setText(R.string.d2);
                break;
            case 3:
                descripcion.setText(R.string.d3);
                break;
            case 4:
                descripcion.setText(R.string.d4);
                break;
            case 5:
                descripcion.setText(R.string.d5);
                break;
            case 6:
                descripcion.setText(R.string.d6);
                break;
            case 7:
                descripcion.setText(R.string.d7);
                break;
            case 8:
                descripcion.setText(R.string.d8);
                break;
            case 9:
                descripcion.setText(R.string.d9);
                break;
            case 10:
                descripcion.setText(R.string.d10);
                break;
            case 11:
                descripcion.setText(R.string.d11);
                break;
            case 12:
                descripcion.setText(R.string.d12);
                break;
            case 13:
                descripcion.setText(R.string.d13);
                break;
            case 14:
                descripcion.setText(R.string.d14);
                break;
            case 15:
                descripcion.setText(R.string.d15);
                break;
            case 16:
                descripcion.setText(R.string.d16);
                break;
            case 17:
                descripcion.setText(R.string.d17);
                break;
            case 18:
                descripcion.setText(R.string.d18);
                break;
            case 19:
                descripcion.setText(R.string.d19);
                break;
            case 20:
                descripcion.setText(R.string.d20);
                break;
            case 21:
                descripcion.setText(R.string.d21);
                break;
            case 22:
                descripcion.setText(R.string.d22);
                break;
            case 23:
                descripcion.setText(R.string.d23);
                break;
            case 24:
                descripcion.setText(R.string.d24);
                break;
            case 25:
                descripcion.setText(R.string.d25);
                break;
            case 26:
                descripcion.setText(R.string.d26);
                break;
            case 27:
                descripcion.setText(R.string.d27);
                break;
            case 28:
                descripcion.setText(R.string.d28);
                break;
            case 29:
                descripcion.setText(R.string.d29);
                break;
            case 30:
                descripcion.setText(R.string.d30);
                break;
            case 31:
                descripcion.setText(R.string.d31);
                break;
            case 32:
                descripcion.setText(R.string.d32);
                break;
            case 33:
                descripcion.setText(R.string.d33);
                break;
            case 34:
                descripcion.setText(R.string.d34);
                break;
            case 35:
                descripcion.setText(R.string.d35);
                break;
            case 36:
                descripcion.setText(R.string.d36);
                break;
            case 37:
                descripcion.setText(R.string.d37);
                break;
            case 38:
                descripcion.setText(R.string.d38);
                break;
            case 39:
                descripcion.setText(R.string.d39);
                break;
            case 40:
                descripcion.setText(R.string.d40);
                break;
            case 41:
                descripcion.setText(R.string.d41);
                break;
            case 42:
                descripcion.setText(R.string.d42);
                break;
            case 43:
                descripcion.setText(R.string.d43);
                break;
            case 44:
                descripcion.setText(R.string.d44);
                break;
            case 45:
                descripcion.setText(R.string.d45);
                break;
            case 46:
                descripcion.setText(R.string.d46);
                break;
            case 47:
                descripcion.setText(R.string.d47);
                break;
            case 48:
                descripcion.setText(R.string.d48);
                break;
            case 49:
                descripcion.setText(R.string.d49);
                break;
            case 50:
                descripcion.setText(R.string.d50);
                break;
            case 51:
                descripcion.setText(R.string.d51);
                break;
            case 52:
                descripcion.setText(R.string.d52);
                break;
            case 53:
                descripcion.setText(R.string.d53);
                break;
            case 54:
                descripcion.setText(R.string.d54);
                break;
            case 55:
                descripcion.setText(R.string.d55);
                break;
            case 56:
                descripcion.setText(R.string.d56);
                break;
            case 57:
                descripcion.setText(R.string.d57);
                break;
            case 58:
                descripcion.setText(R.string.d58);
                break;
            case 59:
                descripcion.setText(R.string.d59);
                break;
            case 60:
                descripcion.setText(R.string.d60);
                break;
            case 61:
                descripcion.setText(R.string.d61);
                break;
            case 62:
                descripcion.setText(R.string.d62);
                break;
            case 63:
                descripcion.setText(R.string.d63);
                break;
            case 64:
                descripcion.setText(R.string.d64);
                break;
            case 65:
                descripcion.setText(R.string.d65);
                break;
            case 66:
                descripcion.setText(R.string.d66);
                break;
            case 67:
                descripcion.setText(R.string.d67);
                break;
            case 68:
                descripcion.setText(R.string.d68);
                break;
            case 69:
                descripcion.setText(R.string.d69);
                break;
            case 70:
                descripcion.setText(R.string.d70);
                break;
            case 71:
                descripcion.setText(R.string.d71);
                break;
            case 72:
                descripcion.setText(R.string.d72);
                break;
            case 73:
                descripcion.setText(R.string.d73);
                break;
            case 74:
                descripcion.setText(R.string.d74);
                break;
            case 75:
                descripcion.setText(R.string.d75);
                break;
            case 76:
                descripcion.setText(R.string.d76);
                break;
            case 77:
                descripcion.setText(R.string.d77);
                break;
            case 78:
                descripcion.setText(R.string.d78);
                break;
            case 79:
                descripcion.setText(R.string.d79);
                break;
            case 80:
                descripcion.setText(R.string.d80);
                break;
            case 81:
                descripcion.setText(R.string.d81);
                break;
            case 82:
                descripcion.setText(R.string.d82);
                break;
            case 83:
                descripcion.setText(R.string.d83);
                break;
            case 84:
                descripcion.setText(R.string.d84);
                break;
            case 85:
                descripcion.setText(R.string.d85);
                break;
            case 86:
                descripcion.setText(R.string.d86);
                break;
            case 87:
                descripcion.setText(R.string.d87);
                break;
            case 88:
                descripcion.setText(R.string.d88);
                break;
            case 89:
                descripcion.setText(R.string.d89);
                break;
            case 90:
                descripcion.setText(R.string.d90);
                break;
            case 91:
                descripcion.setText(R.string.d91);
                break;
            case 92:
                descripcion.setText(R.string.d92);
                break;
            case 93:
                descripcion.setText(R.string.d93);
                break;
            case 94:
                descripcion.setText(R.string.d94);
                break;
            case 95:
                descripcion.setText(R.string.d95);
                break;
            case 96:
                descripcion.setText(R.string.d96);
                break;
            case 97:
                descripcion.setText(R.string.d97);
                break;
            case 98:
                descripcion.setText(R.string.d98);
                break;
            case 99:
                descripcion.setText(R.string.d99);
                break;
            case 100:
                descripcion.setText(R.string.d100);
                break;
            case 101:
                descripcion.setText(R.string.d101);
                break;
            case 102:
                descripcion.setText(R.string.d102);
                break;
            case 103:
                descripcion.setText(R.string.d103);
                break;
            case 104:
                descripcion.setText(R.string.d104);
                break;
            case 105:
                descripcion.setText(R.string.d105);
                break;
            case 106:
                descripcion.setText(R.string.d106);
                break;
            case 107:
                descripcion.setText(R.string.d107);
                break;
            case 108:
                descripcion.setText(R.string.d108);
                break;
            case 109:
                descripcion.setText(R.string.d109);
                break;
            case 110:
                descripcion.setText(R.string.d110);
                break;
            case 111:
                descripcion.setText(R.string.d111);
                break;
            case 112:
                descripcion.setText(R.string.d112);
                break;
            case 113:
                descripcion.setText(R.string.d113);
                break;
            case 114:
                descripcion.setText(R.string.d114);
                break;
            case 115:
                descripcion.setText(R.string.d115);
                break;
            case 116:
                descripcion.setText(R.string.d116);
                break;
            case 117:
                descripcion.setText(R.string.d117);
                break;
            case 118:
                descripcion.setText(R.string.d118);
                break;
            case 119:
                descripcion.setText(R.string.d119);
                break;
            case 120:
                descripcion.setText(R.string.d120);
                break;
            case 121:
                descripcion.setText(R.string.d121);
                break;
            case 122:
                descripcion.setText(R.string.d122);
                break;
            case 123:
                descripcion.setText(R.string.d123);
                break;
            case 124:
                descripcion.setText(R.string.d124);
                break;
            case 125:
                descripcion.setText(R.string.d125);
                break;
            case 126:
                descripcion.setText(R.string.d126);
                break;
            case 127:
                descripcion.setText(R.string.d127);
                break;
            case 128:
                descripcion.setText(R.string.d128);
                break;
            case 129:
                descripcion.setText(R.string.d129);
                break;
            case 130:
                descripcion.setText(R.string.d130);
                break;
            case 131:
                descripcion.setText(R.string.d131);
                break;
            case 132:
                descripcion.setText(R.string.d132);
                break;
            case 133:
                descripcion.setText(R.string.d133);
                break;
            case 134:
                descripcion.setText(R.string.d134);
                break;
            case 135:
                descripcion.setText(R.string.d135);
                break;
            case 136:
                descripcion.setText(R.string.d136);
                break;
            case 137:
                descripcion.setText(R.string.d137);
                break;
            case 138:
                descripcion.setText(R.string.d138);
                break;
            case 139:
                descripcion.setText(R.string.d139);
                break;
            case 140:
                descripcion.setText(R.string.d140);
                break;
            case 141:
                descripcion.setText(R.string.d141);
                break;
            case 142:
                descripcion.setText(R.string.d142);
                break;
            case 143:
                descripcion.setText(R.string.d143);
                break;
            case 144:
                descripcion.setText(R.string.d144);
                break;
            case 145:
                descripcion.setText(R.string.d145);
                break;
            case 146:
                descripcion.setText(R.string.d146);
                break;
            case 147:
                descripcion.setText(R.string.d147);
                break;
            case 148:
                descripcion.setText(R.string.d148);
                break;
            case 149:
                descripcion.setText(R.string.d149);
                break;
            case 150:
                descripcion.setText(R.string.d150);
                break;
            case 151:
                descripcion.setText(R.string.d151);
                break;
            case 152:
                descripcion.setText(R.string.d152);
                break;
            case 153:
                descripcion.setText(R.string.d153);
                break;
            case 154:
                descripcion.setText(R.string.d154);
                break;
            case 155:
                descripcion.setText(R.string.d155);
                break;
            case 156:
                descripcion.setText(R.string.d156);
                break;
            case 157:
                descripcion.setText(R.string.d157);
                break;
            case 158:
                descripcion.setText(R.string.d158);
                break;
            case 159:
                descripcion.setText(R.string.d159);
                break;
            case 160:
                descripcion.setText(R.string.d160);
                break;
            case 161:
                descripcion.setText(R.string.d161);
                break;
            case 162:
                descripcion.setText(R.string.d162);
                break;
            case 163:
                descripcion.setText(R.string.d163);
                break;
            case 164:
                descripcion.setText(R.string.d164);
                break;
            case 165:
                descripcion.setText(R.string.d165);
                break;
            case 166:
                descripcion.setText(R.string.d166);
                break;
            case 167:
                descripcion.setText(R.string.d167);
                break;
            case 168:
                descripcion.setText(R.string.d168);
                break;
            case 169:
                descripcion.setText(R.string.dfault);
                break;
            case 170:
                descripcion.setText(R.string.d170);
                break;
            case 171:
                descripcion.setText(R.string.d171);
                break;
            case 172:
                descripcion.setText(R.string.d172);
                break;
            case 173:
                descripcion.setText(R.string.d173);
                break;
            case 174:
                descripcion.setText(R.string.d174);
                break;
            case 175:
                descripcion.setText(R.string.d175);
                break;
            case 176:
                descripcion.setText(R.string.d176);
                break;
            case 177:
                descripcion.setText(R.string.d177);
                break;
            case 178:
                descripcion.setText(R.string.d178);
                break;
            case 179:
                descripcion.setText(R.string.d179);
                break;
            case 180:
                descripcion.setText(R.string.d180);
                break;
            case 181:
                descripcion.setText(R.string.d181);
                break;
            case 182:
                descripcion.setText(R.string.d182);
                break;
            case 183:
                descripcion.setText(R.string.d183);
                break;
            case 184:
                descripcion.setText(R.string.d184);
                break;
            case 185:
                descripcion.setText(R.string.d185);
                break;
            case 186:
                descripcion.setText(R.string.d186);
                break;
            case 187:
                descripcion.setText(R.string.d187);
                break;
            case 188:
                descripcion.setText(R.string.d188);
                break;
            case 189:
                descripcion.setText(R.string.d189);
                break;
            case 190:
                descripcion.setText(R.string.d190);
                break;
            case 191:
                descripcion.setText(R.string.d191);
                break;
            case 192:
                descripcion.setText(R.string.d192);
                break;
            case 193:
                descripcion.setText(R.string.d193);
                break;
            case 194:
                descripcion.setText(R.string.d194);
                break;
            case 195:
                descripcion.setText(R.string.d195);
                break;
            case 196:
                descripcion.setText(R.string.d196);
                break;
            case 197:
                descripcion.setText(R.string.d197);
                break;
            case 198:
                descripcion.setText(R.string.d198);
                break;
            case 199:
                descripcion.setText(R.string.d199);
                break;
            case 201:
                descripcion.setText(R.string.d201);
                break;
            case 202:
                descripcion.setText(R.string.d202);
                break;
            case 203:
                descripcion.setText(R.string.d203);
                break;
            case 204:
                descripcion.setText(R.string.d204);
                break;
            case 205:
                descripcion.setText(R.string.d205);
                break;
            case 206:
                descripcion.setText(R.string.d206);
                break;
            case 207:
                descripcion.setText(R.string.d207);
                break;
            case 208:
                descripcion.setText(R.string.d208);
                break;
            case 209:
                descripcion.setText(R.string.d209);
                break;
            case 210:
                descripcion.setText(R.string.d210);
                break;
            case 211:
                descripcion.setText(R.string.d211);
                break;
            case 212:
                descripcion.setText(R.string.d212);
                break;
            case 213:
                descripcion.setText(R.string.d213);
                break;
            case 214:
                descripcion.setText(R.string.d214);
                break;
            case 215:
                descripcion.setText(R.string.d215);
                break;
            case 216:
                descripcion.setText(R.string.d216);
                break;
            case 217:
                descripcion.setText(R.string.d217);
                break;
            case 218:
                descripcion.setText(R.string.d218);
                break;
            case 219:
                descripcion.setText(R.string.d219);
                break;
            case 220:
                descripcion.setText(R.string.d220);
                break;
            case 221:
                descripcion.setText(R.string.d221);
                break;
            case 222:
                descripcion.setText(R.string.d222);
                break;
            case 223:
                descripcion.setText(R.string.d223);
                break;
            case 224:
                descripcion.setText(R.string.d224);
                break;
            case 225:
                descripcion.setText(R.string.d225);
                break;
            case 226:
                descripcion.setText(R.string.d226);
                break;
            case 227:
                descripcion.setText(R.string.d227);
                break;
            case 228:
                descripcion.setText(R.string.d228);
                break;
            case 229:
                descripcion.setText(R.string.d229);
                break;
            case 230:
                descripcion.setText(R.string.d230);
                break;
            case 231:
                descripcion.setText(R.string.d231);
                break;
            case 232:
                descripcion.setText(R.string.d232);
                break;
            case 233:
                descripcion.setText(R.string.d233);
                break;
            case 234:
                descripcion.setText(R.string.d234);
                break;
            case 235:
                descripcion.setText(R.string.d235);
                break;
            case 236:
                descripcion.setText(R.string.d236);
                break;
            case 237:
                descripcion.setText(R.string.d237);
                break;
            case 238:
                descripcion.setText(R.string.d238);
                break;
            case 239:
                descripcion.setText(R.string.d239);
                break;
            case 240:
                descripcion.setText(R.string.d240);
                break;
            case 241:
                descripcion.setText(R.string.d241);
                break;
            case 242:
                descripcion.setText(R.string.d242);
                break;
            case 243:
                descripcion.setText(R.string.d243);
                break;
            case 244:
                descripcion.setText(R.string.d244);
                break;
            case 245:
                descripcion.setText(R.string.d245);
                break;
            case 246:
                descripcion.setText(R.string.d246);
                break;
            case 247:
                descripcion.setText(R.string.d247);
                break;
            case 248:
                descripcion.setText(R.string.d248);
                break;
            case 249:
                descripcion.setText(R.string.d249);
                break;
            case 250:
                descripcion.setText(R.string.d250);
                break;
            case 251:
                descripcion.setText(R.string.d251);
                break;
            case 252:
                descripcion.setText(R.string.d252);
                break;
            case 253:
                descripcion.setText(R.string.d253);
                break;
            case 254:
                descripcion.setText(R.string.d254);
                break;
            case 255:
                descripcion.setText(R.string.d255);
                break;
            case 256:
                descripcion.setText(R.string.d256);
                break;
            case 257:
                descripcion.setText(R.string.d257);
                break;
            case 258:
                descripcion.setText(R.string.d258);
                break;
            case 259:
                descripcion.setText(R.string.d259);
                break;
            case 260:
                descripcion.setText(R.string.d260);
                break;
            case 261:
                descripcion.setText(R.string.d261);
                break;
            case 262:
                descripcion.setText(R.string.d262);
                break;
            case 263:
                descripcion.setText(R.string.d263);
                break;
            case 264:
                descripcion.setText(R.string.d264);
                break;
            case 265:
                descripcion.setText(R.string.d265);
                break;
            case 266:
                descripcion.setText(R.string.d266);
                break;
            case 267:
                descripcion.setText(R.string.d267);
                break;
            case 268:
                descripcion.setText(R.string.d268);
                break;
            case 269:
                descripcion.setText(R.string.d269);
                break;
            case 270:
                descripcion.setText(R.string.d270);
                break;
            case 271:
                descripcion.setText(R.string.d271);
                break;
            case 272:
                descripcion.setText(R.string.d272);
                break;
            case 273:
                descripcion.setText(R.string.d273);
                break;
            case 274:
                descripcion.setText(R.string.d274);
                break;
            case 275:
                descripcion.setText(R.string.d275);
                break;
            case 276:
                descripcion.setText(R.string.d276);
                break;
            case 277:
                descripcion.setText(R.string.d277);
                break;
            case 278:
                descripcion.setText(R.string.d278);
                break;
            case 279:
                descripcion.setText(R.string.d279);
                break;
            case 280:
                descripcion.setText(R.string.d280);
                break;
            case 281:
                descripcion.setText(R.string.d281);
                break;
            case 282:
                descripcion.setText(R.string.d282);
                break;
            default:
                descripcion.setText(R.string.dfault);
                break;

        }


        switch(Integer.parseInt(rutaave)){
            case 0:
                info8.setText(R.string.rutainfo1);
                break;
            case 1:
                info8.setText("Ventanas");
                break;
            case 2:
                info8.setText("Verdun-mesenia");
                break;
            case 3:
                info8.setText("Verdun-mesenia & Ventanas");
                break;
            case 4:
                info8.setText("La Salada");
                break;
            case 5:
                info8.setText("La Salada & Ventanas");
                break;
            case 6:
                info8.setText("La Salada & Verdun-mesenia");
                break;
            case 7:
                info8.setText("La Salada, Verdun-mesenia & Ventanas ");
                break;
            case 8:
                info8.setText("La Herrera");
                break;
            case 9:
                info8.setText("La Herrera & Ventanas");
                break;
            case 10:
                info8.setText("La Herrera & Verdun-mesenia");
                break;
            case 11:
                info8.setText("La Herrera, Verdun-mesenia & Ventanas");
                break;
            case 12:
                info8.setText("La Herrera & La Salada");
                break;
            case 13:
                info8.setText("La Herrera, La Salada & Ventanas");
                break;
            case 14:
                info8.setText("La Herrera, La Salada & Verdun-mesenia");
                break;
            case 15:
                info8.setText("La Herrera, La Salada, Verdun-mesenia & Ventanas");
                break;

            default:
                info8.setText(R.string.rutainfo1);
                break;
        }

        switch(Integer.parseInt(residenciaave)){
            case 0:
                info6.setText(R.string.endemismoinfo1);
                break;
            case 1:
                info6.setText(R.string.endemismoinfo2);
                break;
            default:
                info6.setText(R.string.endemismoinfo2);
                break;
        }

        switch(Integer.parseInt(conservaave)){
            case 0:
                info7.setText(R.string.conservainfo1);
                break;
            case 1:
                info7.setText(R.string.conservainfo2);
                break;
            case 2:
                info7.setText(R.string.conservainfo3);
                break;
            case 3:
                info7.setText(R.string.conservainfo4);
                break;
            default:
                info7.setText(R.string.conservainfo5);
                break;
        }

        switch(Integer.parseInt(formaave)){
            case 0:
                info1.setText(R.string.formainfo1);
                break;
            case 1:
                info1.setText(R.string.formainfo2);
                break;
            case 2:
                info1.setText(R.string.formainfo3);
                break;
            case 3:
                info1.setText(R.string.formainfo4);
                break;
            case 4:
                info1.setText(R.string.formainfo5);
                break;
            case 5:
                info1.setText(R.string.formainfo6);
                break;
            case 6:
                info1.setText(R.string.formainfo7);
                break;
            case 7:
                info1.setText(R.string.formainfo8);
                break;
            case 8:
                info1.setText(R.string.formainfo9);
                break;
            case 9:
                info1.setText(R.string.formainfo10);
                break;
            default:
                info1.setText(R.string.formainfo1);
                break;
        }

        switch(Integer.parseInt(picoave)){
            case 0:
                info2.setText(R.string.picoinfo1);
                break;
            case 1:
                info2.setText(R.string.picoinfo2);
                break;
            case 2:
                info2.setText(R.string.picoinfo3);
                break;
            case 3:
                info2.setText(R.string.picoinfo4);
                break;
            case 4:
                info2.setText(R.string.picoinfo5);
                break;
            case 5:
                info2.setText(R.string.picoinfo6);
                break;
            case 6:
                info2.setText(R.string.picoinfo7);
                break;
            case 7:
                info2.setText(R.string.picoinfo8);
                break;
            case 8:
                info2.setText(R.string.picoinfo9);
                break;
            case 9:
                info2.setText(R.string.picoinfo10);
                break;
            default:
                info2.setText(R.string.picoinfo1);
                break;
        }

        switch(Integer.parseInt(color1ave)){
            case 0:
                info3.setText(R.string.colorinfo1);
                break;
            case 1:
                info3.setText(R.string.colorinfo2);
                break;
            case 2:
                info3.setText(R.string.colorinfo3);
                break;
            case 3:
                info3.setText(R.string.colorinfo4);
                break;
            case 4:
                info3.setText(R.string.colorinfo5);
                break;
            case 5:
                info3.setText(R.string.colorinfo6);
                break;
            case 6:
                info3.setText(R.string.colorinfo7);
                break;
            case 7:
                info3.setText(R.string.colorinfo8);
                break;
            case 8:
                info3.setText(R.string.colorinfo9);
                break;
            case 9:
                info3.setText(R.string.colorinfo10);
                break;
            case 10:
                info3.setText(R.string.colorinfo11);
                break;
            case 11:
                info3.setText(R.string.colorinfo12);
                break;
            case 12:
                info3.setText(R.string.colorinfo13);
                break;
            case 13:
                info3.setText(R.string.colorinfo14);
                break;
            default:
                info3.setText(R.string.colorinfo1);
                break;
        }

        switch(Integer.parseInt(color2ave)){
            case 0:
                info4.setText(R.string.colorinfo1);
                break;
            case 1:
                info4.setText(R.string.colorinfo2);
                break;
            case 2:
                info4.setText(R.string.colorinfo3);
                break;
            case 3:
                info4.setText(R.string.colorinfo4);
                break;
            case 4:
                info4.setText(R.string.colorinfo5);
                break;
            case 5:
                info4.setText(R.string.colorinfo6);
                break;
            case 6:
                info4.setText(R.string.colorinfo7);
                break;
            case 7:
                info4.setText(R.string.colorinfo8);
                break;
            case 8:
                info4.setText(R.string.colorinfo9);
                break;
            case 9:
                info4.setText(R.string.colorinfo10);
                break;
            case 10:
                info4.setText(R.string.colorinfo11);
                break;
            case 11:
                info4.setText(R.string.colorinfo12);
                break;
            case 12:
                info4.setText(R.string.colorinfo13);
                break;
            case 13:
                info4.setText(R.string.colorinfo14);
                break;
            default:
                info4.setText(R.string.colorinfo1);
                break;
        }

        switch(Integer.parseInt(pataave)){
            case 0:
                info5.setText(R.string.colorinfo1);
                break;
            case 1:
                info5.setText(R.string.colorinfo2);
                break;
            case 2:
                info5.setText(R.string.colorinfo3);
                break;
            case 3:
                info5.setText(R.string.colorinfo4);
                break;
            case 4:
                info5.setText(R.string.colorinfo5);
                break;
            case 5:
                info5.setText(R.string.colorinfo6);
                break;
            case 6:
                info5.setText(R.string.colorinfo7);
                break;
            case 7:
                info5.setText(R.string.colorinfo8);
                break;
            case 8:
                info5.setText(R.string.colorinfo9);
                break;
            case 9:
                info5.setText(R.string.colorinfo10);
                break;
            case 10:
                info5.setText(R.string.colorinfo11);
                break;
            case 11:
                info5.setText(R.string.colorinfo12);
                break;
            case 12:
                info5.setText(R.string.colorinfo13);
                break;
            case 13:
                info5.setText(R.string.colorinfo14);
                break;
            default:
                info5.setText(R.string.colorinfo1);
                break;
        }

        nombre.setText(nombreave);
        nombreingles.setText(inglesave);
        nombrecientifico.setText(cientificoave);

        canto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myWebLink = new Intent(android.content.Intent.ACTION_VIEW);
                myWebLink.setData(Uri.parse(linkave));
                startActivity(myWebLink);
            }
        });

        //Compartir en redes
        compartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });

        //Clic al botón capturar
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                camaraOk = permiso.ValidarCamara();
                if(camaraOk){

                    String file = ruta_fotos + getCode() + ".jpg";
                    File mi_foto = new File( file );
                    try {
                        mi_foto.createNewFile();
                    } catch (IOException ex) {
                        Log.e("ERROR ", "Error:" + ex);
                    }
                    //
                    Uri uri = Uri.fromFile( mi_foto );
                    //Abre la camara para tomar la foto
                    Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    //Guarda imagen
                    cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                    //Retorna a la actividad
                    startActivityForResult(cameraIntent, 0);



                } else {
                    //No hay permisos para cámara o storage
                }
            }
        });

    }

    @SuppressLint("SimpleDateFormat")
    private String getCode() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyymmddhhmmss");
        String date = dateFormat.format(new Date() );
        String photoCode = "pic_" + date;
        return photoCode;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch ( item.getItemId() )
        {
            case R.id.boton_home:{
                Intent Home = new Intent(Ave_info.this, Home.class);
                ActivityCompat.finishAffinity(this);
                startActivity(Home);
                Home.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                finish();
            }
            break;

            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode == RESULT_OK && requestCode == PICK_IMAGE){
            imageUri = data.getData();
            foto_gallery.setImageURI(imageUri);
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_STREAM, imageUri);
            intent.setType("image/jpeg");
            intent.putExtra(Intent.EXTRA_TEXT, "He visto esta ave el día de hoy: "+nombreave);
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, "Share with"));
            imageUri=null;
        }
    }


    private void enviar(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        //    intent.putExtra(Intent.EXTRA_TEXT, "Probando");
        //    intent.setType("text/plain");

        intent.putExtra(Intent.EXTRA_STREAM, imageUri);
        intent.setType("image/jpeg");

        startActivity(Intent.createChooser(intent, "Share with"));
        imageUri=null;
    }



    @Override
    public void onBackPressed() {
        Intent goback = new Intent(Ave_info.this, Filtro.class);
        startActivity(goback);
        finish();
    }
}
