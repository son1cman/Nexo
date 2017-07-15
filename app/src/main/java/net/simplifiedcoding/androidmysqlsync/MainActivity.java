package net.simplifiedcoding.androidmysqlsync;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;
import java.util.Arrays;
import android.app.AlertDialog.Builder;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import 	android.app.Dialog;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.support.design.widget.Snackbar;
import android.Manifest;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.RadioButton;
import android.content.DialogInterface;



import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.telephony.SmsManager;
import android.content.BroadcastReceiver;
import android.widget.Toast;
import android.content.IntentFilter;
import android.content.Context;

import android.view.inputmethod.EditorInfo;
import android.view.View.OnKeyListener;
import android.view.View;
import android.view.KeyEvent;

import 	android.app.Activity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.text.DateFormat;
import java.util.Date;

import static java.lang.Math.round;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    /*
    * CILINDROSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS
    * */
    public static final String URL_SAVE_NAME = "http://www.tomzacr.com/t/saveitf.php";
//1 luis
    //2 andres
    //valerin
    String _supervisor = "P5";

    //Cartago

    int codigocliente = -1;


    //17PJL77239328
    //16PHR028965
    //17PJL772932
    String _CurrentGPS,_CurrentGPS2;



    int usardos;
    //RUTA1
    //{"kevin vargas vega","soda dona ceci","panaderia pibes","ester sojo","pulperia kike","pulperia el pueblo","super canada","super la central","abastecedor tierra poeta","abastecedor obando","lucrecia camacho","rancho sapito","abastecedor dona maria","quesera la negrita","torre alba","oscar gamboa pereira","restaurante r y r","soda los tucanes ","ferreteria chinchilla","almacen digrasa","abastecedor el cruce","agropecuaria del norte","pulperia la casita","junta administrativa ctp la suiza","kimberly vega","pulperia san martin","super aquiares","verduleria Maria Jose","super la canasta la suiza","supermercado la suiza","ferreteria velca","pulperia el cipres","pulperia kendal","pulperia las orquideas","super el tuiz","pulperia el higueron","panaderia la trinidad","super juan vinas","pulperia la miguelena","super la canasta juan vinas","super canada","super la central","abastecedor tierra poeta","abastecedor obando","abastecedor dona maria","lucrecia camacho","rancho sapito","quesera la negrita","kevin vargas vega","soda dona ceci","ester sojo","panaderia pibes","pulperia kike","pulperia el pueblo","restaurante r y r","torre alba","oscar gamboa pereira","soda los tucanes ","abastecedor el cruce","ferreteria chinchilla","almacen digrasa","panaderia el carmen","soda la casita","pulperia gaudy","pulperia san cristobal","pulperia aguila real","pulperia yuritza","quesera valle grano de oro","abastecedor bebata","pulperia la chiquita","pulperia calderon salas","pulperia san martin 2","pulperia lulu","mini super la plaza","ferreteria el angel","pulperia adonay","abastecedor zamora","soda y pulperia el dorado","abastecedor cabecar","freddy aguilar jimenez","pulperia sitio mata","super barato","mini super la amistad","super salas","pulperia rayo azul","super jabillos","pulperia la favorita","super santa teresa","puiperia la familia"};
    //RUTA2
    //{"Pulperia Las Delicias","Super El Quetzal","Super El Arbolito","Restaurante Chiraz","Marisqueria Los Santos","Abastecedor El Pueblo","Abastecedor El Bambu","Repuesto Urecha","CSU SRL Pali San Marcos","Super San Marcos","Soda Pollolandia","Soda La Casita","Super San Marcos ","Almacen Mayorista","Supermercado LaTroja","Soda Pollos #2","Edwin Naranjo Barrantes ","Super Liang","Gessa Super Compro San Pablo","Panaderia Tu Pan","Supermercado La Carreta","Super La Cuevita","Super La Cuevita","Pulperia Los Angeles","Pulperia Panterd","Pulperia Ulloa","Minisuper Los Guidos","Super Pedro","Super La Plaza","Bar El Mirador","Abastecedor El Centro","Super J Y J","Abastecedor Fallas","Coopellano Bonito","Abastecedor El Mirador","Soda Del Cafe","Alimentos del Sur","Abastecedor San Antonio","Comisariato Casa Mata","Restaurante El Encuentro","Abastecedor Los Juncos","Super Alina","Pulperia Kiosko La Manzana","Restaurante San Francisco","Bodega Sumistros San Pablo","Super La Cope","Super San Lorenzo","Super Allison","Bar Chicos","Super Santa Marta","Restaurante La Catarata","Super LaTrinidad","Panaderia Las Manzanitas","Pulperia Providencia","Abastecedor La Esperanza","Super Los Carguitas","Barlas Damitas","Abastedor San Rafael","Abastecedor La Ezquinita","Abastecesor El Bosque","Pulperia Chaplls","Pulperia La Plaza","Pulperia Los Claveles","Pulperia Linda Vista","Pulperia La Minita","Abastecesor Flor del Rio","Pulperia El Cruce","Abastecedor Pura Vida","Abastecedor el Buen Precio","Abastecesor La Curvita","Colegio San Andres","Coopellano Bonito","Abastecedor Fallas","Super J Y J","Abastecedor El Centro","Soda Del Cafe","Abastecedor San Antonio","Abastecedor El Mirador","Alimentos del Sur","Comisariato Casa Mata","Restaurante El Encuentro","Pulperia Kiosko La Manzana","Abastecedor Los Juncos","Restaurante San Francisco","Super Alina","Bodega Sumistros San Pablo","Super La Cope","Super Allison","Super San Lorenzo"};
    //RUTA3
    //{"Prolex S.A","Mafan","Demasa Cartago","Hap 1","Catheter Resert","Teini plex costa rica srl","Hap","Prismar tres rios","Tecni Gypsum S.A ","Euromobilia San Francisco 1","Euromobilia San Francisco 1","Prismar Zapote ","Prismar Zapote","Importaciones Adnat ","Gessa calle blancos","Prismar de costa rica tibas ","Corporacion Cek ","Aceros Abonos Agro Colima Tibas","Aceros Abonos Agro B.26","Primar de Costa Rica Uruca","Mayoreo Abonos Agro B38","Soda Carmen mayoreo abonos agro B38","Garabito ","Arclad","Arclad","Anixter","La casa de las baterias  ","Ilg S.C.S. S.A. LA VALENCIA","Disal S.A.","Alpemusa pequeÃ±o mundo guachipelin escazu","Basic Palets","Distribuidora la florida S.A.","Importaciones Ivan Rang","Euromobilia Barrio Cuba 1","Euromobilia Barrio Cuba 2","Comercializadora B y A Plaza Tren","Euromobilia Pavas ","Demasa Materia Prima","Demasa Cedi ","Demasa Tortillas ","Demasa Anexo ","Basic Seats Pavas ","Basic Pallets Pavas ","Singe pavas ","Clima Ideal Pavas","Leogar","Olo Las Brisas","Ilg  Supply Chail Services S.A ","Olo S.A ","Prismar de Costa Rica Tibas","Irex de Costa Rica Concepcion Tres Rios","Prismar De Costa Rica Heredia","Euromobilia San Francisco 2 ","Gessa Paso Ancho"};
    //RUTA7
    //{"ARSA","CSU SRL Mas x Menos Coronado","CSU SRL Mas x Menos cuesta mora","CSU SRL Mas x Menos Sabana","CSU SRL Mas x Menos Tibas","CSU SRL MAXI PALI GUADALUPE","CSU SRL Maxi Pali Pavas","CSU SRL Maxi Pali Tibas","CSU SRL MXM LA GRANJA","CSU SRL MXM SABANILLA","CSU SRL Pali Colima","CSU SRL Pali Concepcion ","CSU SRL Pali Coronado","CSU SRL PALI CURRIDABAT","CSU SRL Pali El Parque","CSU SRL PALI GUADALUPE","CSU SRL Pali Lomas","CSU SRL PALI MATA PLATANO","CSU SRL Pali Montes de Oca","CSU SRL Pali Pavas","CSU SRL Pali Plaza Viquez","CSU SRL PALI PURRAL","CSU SRL Pali San Antonio","CSU SRL Pali San Blas ","CSU SRL Walmart Escazu","CSU SRL WALMART GUADALUPE","CSU SRL Walmart Tibas","CSU SRLpaliel alto","Ferreteria EPA S.A Escazu","Ferreteria EPA S.A Tibas","GESSA PERI MONTE LIMAR","GESSA PERI VARGAS ARAYA","GESSA Perimercado Del Sur","GESSA Perimercado Embajada","Gessa Perimercado Gran Via","GESSA Perimercado Guadalupe","GESSA Perimercado Moravia","GESSA Supercompro Plaza Pavas","GESSA Supercompro Tibas","GESSS Supercompro Coronado","Luis Fung"};
    //RUTA8
    //{"Super Santa Cecilia","Super Ema","Comercial Alemora S.A","Luis Alpizar Corrales","Pulperia La Guaria","Comercial Alemora S.A","Restaurante Santa Marta","Soda Masis","Super Lopez","Comercial Alemora S.A","Pulperia La Plaza","Comercial Alemora S.A","Cesilia Vargas Rojas ","Verdureria XT","Super Colima","Abastesedor La Terminal","Abastecedor Grifo Alto","Pulperia La Bendicion","Super Rocha","Super Piedades","Minisuper San Vito","Pulperia La Economica","Ma Ventanit","Andres Martin Agüero Quiros","Golosinas Kenneth","Abastecedor Vivian","Abastecedor Cutty","Super Sabanilla","Abastecedor La Deportiva","Super Cazu","Proxi Santa Ana","Comercial Alemora S.A","Comercial Alemora S.A","Tienda Colon","Roy Bustamante ","Abastecedor la plaza","Julio Cubillo","Super Yiyi","Alemora Cedi","Super Quitirrisi","Tienda Paso Ancho","Super Santa Cecilia","Super Ema","Pulperia La Guaria","Alemora Norte","Alemora Centro","Luis Alpizar","Restaurante Santa Marta","Soda Masis","Super Lopez","Comercial Alemora S.A","Pulperia La Plaza","Comercial Alemora S.A","Super Pedernal","Abastesedor La Terminal","Super Colina","Verdureria XT","Nely Porras Quesada","Laura Porras","Pulperia La Bendicion","Super Piedades","Pulperia La Economica","Victor Villalobos"};
    //RUTA 46
    //{"Tienda San Antonio","Tienda La Trinidad de Moravia","Tienda Santo Domingo","Tienda Coronado 2","Tienda San Pedro Coronado","Tienda Ipis","Tienda Purral","Tienda Tres Rios"};

    String[] _ruta1 = {"Prolex S.A","Mafan","Demasa Cartago","Hap 1","Catheter Resert","Teini plex costa rica srl","Hap","Prismar tres rios","Tecni Gypsum S.A ","Euromobilia San Francisco 1","Euromobilia San Francisco 1","Prismar Zapote ","Prismar Zapote","Importaciones Adnat ","Gessa calle blancos","Prismar de costa rica tibas ","Corporacion Cek ","Aceros Abonos Agro Colima Tibas","Aceros Abonos Agro B.26","Primar de Costa Rica Uruca","Mayoreo Abonos Agro B38","Soda Carmen mayoreo abonos agro B38","Garabito ","Arclad","Arclad","Anixter","La casa de las baterias  ","Ilg S.C.S. S.A. LA VALENCIA","Disal S.A.","Alpemusa pequeÃ±o mundo guachipelin escazu","Basic Palets","Distribuidora la florida S.A.","Importaciones Ivan Rang","Euromobilia Barrio Cuba 1","Euromobilia Barrio Cuba 2","Comercializadora B y A Plaza Tren","Euromobilia Pavas ","Demasa Materia Prima","Demasa Cedi ","Demasa Tortillas ","Demasa Anexo ","Basic Seats Pavas ","Basic Pallets Pavas ","Singe pavas ","Clima Ideal Pavas","Leogar","Olo Las Brisas","Ilg  Supply Chail Services S.A ","Olo S.A ","Prismar de Costa Rica Tibas","Irex de Costa Rica Concepcion Tres Rios","Prismar De Costa Rica Heredia","Euromobilia San Francisco 2 ","Gessa Paso Ancho"};
            //{"Pulperia Las Delicias","Super El Quetzal","Super El Arbolito","Restaurante Chiraz","Marisqueria Los Santos","Abastecedor El Pueblo","Abastecedor El Bambu","Repuesto Urecha","CSU SRL Pali San Marcos","Super San Marcos","Soda Pollolandia","Soda La Casita","Super San Marcos ","Almacen Mayorista","Supermercado LaTroja","Soda Pollos #2","Edwin Naranjo Barrantes ","Super Liang","Gessa Super Compro San Pablo","Panaderia Tu Pan","Supermercado La Carreta","Super La Cuevita","Super La Cuevita","Pulperia Los Angeles","Pulperia Panterd","Pulperia Ulloa","Minisuper Los Guidos","Super Pedro","Super La Plaza","Bar El Mirador","Abastecedor El Centro","Super J Y J","Abastecedor Fallas","Coopellano Bonito","Abastecedor El Mirador","Soda Del Cafe","Alimentos del Sur","Abastecedor San Antonio","Comisariato Casa Mata","Restaurante El Encuentro","Abastecedor Los Juncos","Super Alina","Pulperia Kiosko La Manzana","Restaurante San Francisco","Bodega Sumistros San Pablo","Super La Cope","Super San Lorenzo","Super Allison","Bar Chicos","Super Santa Marta","Restaurante La Catarata","Super LaTrinidad","Panaderia Las Manzanitas","Pulperia Providencia","Abastecedor La Esperanza","Super Los Carguitas","Barlas Damitas","Abastedor San Rafael","Abastecedor La Ezquinita","Abastecesor El Bosque","Pulperia Chaplls","Pulperia La Plaza","Pulperia Los Claveles","Pulperia Linda Vista","Pulperia La Minita","Abastecesor Flor del Rio","Pulperia El Cruce","Abastecedor Pura Vida","Abastecedor el Buen Precio","Abastecesor La Curvita","Colegio San Andres","Coopellano Bonito","Abastecedor Fallas","Super J Y J","Abastecedor El Centro","Soda Del Cafe","Abastecedor San Antonio","Abastecedor El Mirador","Alimentos del Sur","Comisariato Casa Mata","Restaurante El Encuentro","Pulperia Kiosko La Manzana","Abastecedor Los Juncos","Restaurante San Francisco","Super Alina","Bodega Sumistros San Pablo","Super La Cope","Super Allison","Super San Lorenzo"};
            //{"kevin vargas vega","soda dona ceci","panaderia pibes","ester sojo","pulperia kike","pulperia el pueblo","super canada","super la central","abastecedor tierra poeta","abastecedor obando","lucrecia camacho","rancho sapito","abastecedor dona maria","quesera la negrita","torre alba","oscar gamboa pereira","restaurante r y r","soda los tucanes ","ferreteria chinchilla","almacen digrasa","abastecedor el cruce","agropecuaria del norte","pulperia la casita","junta administrativa ctp la suiza","kimberly vega","pulperia san martin","super aquiares","verduleria Maria Jose","super la canasta la suiza","supermercado la suiza","ferreteria velca","pulperia el cipres","pulperia kendal","pulperia las orquideas","super el tuiz","pulperia el higueron","panaderia la trinidad","super juan vinas","pulperia la miguelena","super la canasta juan vinas","super canada","super la central","abastecedor tierra poeta","abastecedor obando","abastecedor dona maria","lucrecia camacho","rancho sapito","quesera la negrita","kevin vargas vega","soda dona ceci","ester sojo","panaderia pibes","pulperia kike","pulperia el pueblo","restaurante r y r","torre alba","oscar gamboa pereira","soda los tucanes ","abastecedor el cruce","ferreteria chinchilla","almacen digrasa","panaderia el carmen","soda la casita","pulperia gaudy","pulperia san cristobal","pulperia aguila real","pulperia yuritza","quesera valle grano de oro","abastecedor bebata","pulperia la chiquita","pulperia calderon salas","pulperia san martin 2","pulperia lulu","mini super la plaza","ferreteria el angel","pulperia adonay","abastecedor zamora","soda y pulperia el dorado","abastecedor cabecar","freddy aguilar jimenez","pulperia sitio mata","super barato","mini super la amistad","super salas","pulperia rayo azul","super jabillos","pulperia la favorita","super santa teresa"};

    //RUTA1
    //{"pulperia linoncito","pulperia divino nino","pulperia gemelos","pulperia la esquina","pulperia papillos","pulperia pequenita","pulperia la perla","pulperia el buitre","lacteos del oriente","restaurante quetzal","super la esperanza","adriano","pujperia kike","kevin vargas vega","soda dona ceci","pulperia kike","panaderia pibes","ester sojo","super canada","super la central","abastecedor tierra poeta","pulperia el pueblo","abastecedor dona maria","lucrecia camacho","abastecedor obando","rancho sapito","quesera la negrita","torre alba","restaurante r y r","oscar gamboa pereira","abastecedor el cruce","almacen digrasa","ferreteria chinchilla","soda los tucanes ","turri prefa","super san rafael","carniceria la favorita","pulperia bendicion de dios","comisariato lety","pulperia lym","wok y roll","more than words","nazca","pulperia san martin #1","panaderia el cantaro","abastecedor jiron","abastecedor salmeron","bar el jardin"};
    //RUTA2
    //{"Super Santa Marta","Bar Chicos","Restaurante La Catarata","Panaderia Las Manzanitas","Pulperia Providencia","Super LaTrinidad","Abastecedor La Esperanza","Super Los Carguitas","Barlas Damitas","Abastedor San Rafael","Abastecedor La Ezquinita","Abastecesor El Bosque","Pulperia Chaplls","Pulperia LasDelicias","Super El Arbolito","Restaurante Chiraz","Super El Quetzal","Repuesto Urecha","Marisqueria Los Santos","Abastecedor El Bambu","Abastecedor El Pueblo","CSU SRL Pali San Marcos","Soda La Casita","Super San Marcos","Soda Pollos #2","Soda Pollolandia","Super San Marcos #2","Supermercado LaTroja","Almacen Mayorista","Super Mita","Super Liang","Gessa Super Compro San Pablo","Supermercado La Carreta","Pulperia Ulloa","Minisuper Los Guidos","Pulperia Panterd","Super Pedro","Pulperia Linda Vista","Bar El Mirador","Super La Plaza","Pulperia La Plaza","Pulperia Luna","Pulperia Los Claveles","Abastecedor Pura Vida","Pulperia El Cruce","Abastecesor La Curvita","Pulperia La Minita","Abastecesor Flor del Rio","Abastecedor el Buen Precio","Colegio San Andres","Pulperia La Palma","Pulperia Luna","Super La Cuevita","Super La Cuevita","Pulperia Los Angeles","Bodega San Antonio","Gabriela Clark","Pulperia Los Pioneros","Lorena Abarca","Pulperia Viajero","Abastecedor Orquideas","Abastecedor Melanni","Pulperia La Bendicion","Super La Familia","Suministros San Carlos","Panaderia Tu Pan","Super Pirris","Rolando Umaña Calderon","Abastecedor La Flor","Minor Porras Venegas","Super El Cruce","Seidy Abarca  Mora","La Luchita","Seidy Abarca  Mora","Super El Cruce","La Luchita"};
    String[] _ruta1_2 = {"Super Santa Marta","Bar Chicos","Restaurante La Catarata","Panaderia Las Manzanitas","Pulperia Providencia","Super LaTrinidad","Abastecedor La Esperanza","Super Los Carguitas","Barlas Damitas","Abastedor San Rafael","Abastecedor La Ezquinita","Abastecesor El Bosque","Pulperia Chaplls","Pulperia LasDelicias","Super El Arbolito","Restaurante Chiraz","Super El Quetzal","Repuesto Urecha","Marisqueria Los Santos","Abastecedor El Bambu","Abastecedor El Pueblo","CSU SRL Pali San Marcos","Soda La Casita","Super San Marcos","Soda Pollos #2","Soda Pollolandia","Super San Marcos #2","Supermercado LaTroja","Almacen Mayorista","Super Mita","Super Liang","Gessa Super Compro San Pablo","Supermercado La Carreta","Pulperia Ulloa","Minisuper Los Guidos","Pulperia Panterd","Super Pedro","Pulperia Linda Vista","Bar El Mirador","Super La Plaza","Pulperia La Plaza","Pulperia Luna","Pulperia Los Claveles","Abastecedor Pura Vida","Pulperia El Cruce","Abastecesor La Curvita","Pulperia La Minita","Abastecesor Flor del Rio","Abastecedor el Buen Precio","Colegio San Andres","Pulperia La Palma","Pulperia Luna","Super La Cuevita","Super La Cuevita","Pulperia Los Angeles","Bodega San Antonio","Gabriela Clark","Pulperia Los Pioneros","Lorena Abarca","Pulperia Viajero","Abastecedor Orquideas","Abastecedor Melanni","Pulperia La Bendicion","Super La Familia","Suministros San Carlos","Panaderia Tu Pan","Super Pirris","Rolando Umaña Calderon","Abastecedor La Flor","Minor Porras Venegas","Super El Cruce","Seidy Abarca  Mora","La Luchita","Seidy Abarca  Mora","Super El Cruce","La Luchita"};
    //{"Super Santa Marta","Bar Chicos","Restaurante La Catarata","Panaderia Las Manzanitas","Pulperia Providencia","Super LaTrinidad","Abastecedor La Esperanza","Super Los Carguitas","Barlas Damitas","Abastedor San Rafael","Abastecedor La Ezquinita","Abastecesor El Bosque","Pulperia Chaplls","Pulperia LasDelicias","Super El Arbolito","Restaurante Chiraz","Super El Quetzal","Repuesto Urecha","Marisqueria Los Santos","Abastecedor El Bambu","Abastecedor El Pueblo","CSU SRL Pali San Marcos","Soda La Casita","Super San Marcos","Soda Pollos #2","Soda Pollolandia","Super San Marcos #2","Supermercado LaTroja","Almacen Mayorista","Super Mita","Super Liang","Gessa Super Compro San Pablo","Supermercado La Carreta","Pulperia Ulloa","Minisuper Los Guidos","Pulperia Panterd","Super Pedro","Pulperia Linda Vista","Bar El Mirador","Super La Plaza","Pulperia La Plaza","Pulperia Luna","Pulperia Los Claveles","Abastecedor Pura Vida","Pulperia El Cruce","Abastecesor La Curvita","Pulperia La Minita","Abastecesor Flor del Rio","Abastecedor el Buen Precio","Colegio San Andres","Pulperia La Palma","Pulperia Luna","Super La Cuevita","Super La Cuevita","Pulperia Los Angeles","Bodega San Antonio","Gabriela Clark","Pulperia Los Pioneros","Lorena Abarca","Pulperia Viajero","Abastecedor Orquideas","Abastecedor Melanni","Pulperia La Bendicion","Super La Familia","Suministros San Carlos","Panaderia Tu Pan","Super Pirris","Rolando Umaña Calderon","Abastecedor La Flor","Minor Porras Venegas","Super El Cruce","Seidy Abarca  Mora","La Luchita","Seidy Abarca  Mora","Super El Cruce","La Luchita"};
    //{"puiperia la familia","pulperia linoncito","pulperia divino nino","pulperia gemelos","pulperia la esquina","pulperia papillos","pulperia pequenita","pulperia la perla","pulperia el buitre","lacteos del oriente","restaurante quetzal","super la esperanza","adriano","pujperia kike","kevin vargas vega","soda dona ceci","pulperia kike","panaderia pibes","ester sojo","super canada","super la central","abastecedor tierra poeta","pulperia el pueblo","abastecedor dona maria","lucrecia camacho","abastecedor obando","rancho sapito","quesera la negrita","torre alba","restaurante r y r","oscar gamboa pereira","abastecedor el cruce","almacen digrasa","ferreteria chinchilla","soda los tucanes ","turri prefa","super san rafael","carniceria la favorita","pulperia bendicion de dios","comisariato lety","pulperia lym","wok y roll","more than words","nazca","pulperia san martin #1","panaderia el cantaro","abastecedor jiron","abastecedor salmeron","bar el jardin"};


    private List<CharSequence> charSequences = new ArrayList<>();
    private List<String> indexes = new ArrayList<>();
    private List<String> indexes2 = new ArrayList<>();
    private String _negocio,_descuento,_credito;

    //RUTA1
    //{649,0,0,649,0,200,425,649,425,0,240,0,0,0,0,0,0,0,200,300,0,0,0,0,0,0,649,240,240,649,200,649,0,0,649,0,0,649,0,240,425,649,425,0,0,240,0,0,0,0,649,0,0,200,0,0,0,0,0,200,300,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,649,649,200,0,300,0,425,0};
    //RUTA2
    //{0,649,0,0,0,649,0,0,240,649,0,0,0,0,0,0,649,649,0,0,0,0,250,0,0,0,0,0,400,0,400,600,0,400,300,0,0,0,600,0,500,0,0,0,0,0,600,400,0,600,0,0,0,0,0,0,0,0,400,0,0,0,600,0,0,0,0,0,0,0,0,400,0,600,400,0,0,300,0,500,0,0,500,0,0,0,0,400,600};
    //RUTA8
    //{0,600,150,500,0,150,619,0,450,150,0,150,0,0,250,0,600,0,250,0,0,0,0,0,0,0,0,200,619,0,150,150,150,2133,500,649,2133,200,150,0,1933,0,600,0,150,150,500,619,0,450,150,0,150,0,0,250,0,619,250,0,0,0,0};
    //RUTA3
    //{0,0,62,0,0,0,0,8,0,0,0,0,0,0,8,0,0,0,0,8,0,0,0,0,0,0,0,0,0,8,0,600,0,0,0,0,0,62,62,62,62,0,0,0,0,0,0,0,0,8,300,0,0,8};
    //RUTA7
    //{0,240,240,240,240,240,240,240,240,240,240,240,240,240,240,240,240,240,240,240,240,24,240,240,240,240,240,240,0,0,0,0,0,0,0,0,0,0,0,0,800};
    //RUTA46
    //{1933,1933,1933,1933,1933,1933,1933,1933,1933,1933,1933,1933};

    int[] _descuento1 = {0,0,62,0,0,0,0,8,0,0,0,0,0,0,8,0,0,0,0,8,0,0,0,0,0,0,0,0,0,8,0,600,0,0,0,0,0,62,62,62,62,0,0,0,0,0,0,0,0,8,300,0,0,8};
    //{0,649,0,0,0,649,0,0,240,649,0,0,0,0,0,0,649,649,0,0,0,0,250,0,0,0,0,0,400,0,400,600,0,400,300,0,0,0,600,0,500,0,0,0,0,0,600,400,0,600,0,0,0,0,0,0,0,0,400,0,0,0,600,0,0,0,0,0,0,0,0,400,0,600,400,0,0,300,0,500,0,0,500,0,0,0,0,400,600};

    int[] _descuento1_2 = {600,0,0,0,0,0,0,0,0,0,400,0,0,0,0,0,649,0,0,0,649,240,0,649,0,0,0,0,0,649,649,0,0,0,0,0,0,0,0,400,0,0,0,0,0,0,0,0,0,0,0,0,250,0,0,600,0,0,0,0,0,0,0,0,0,0,0,600,0,400,500,500,0,500,500,0};
    //{600,0,0,0,0,0,0,0,0,0,400,0,0,0,0,0,649,0,0,0,649,240,0,649,0,0,0,0,0,649,649,0,0,0,0,0,0,0,0,400,0,0,0,0,0,0,0,0,0,0,0,0,250,0,0,600,0,0,0,0,0,0,0,0,0,0,0,600,0,400,500,500,0,500,500,0};
    //RUTA1:
    //{0,0,0,0,0,0,0,0,0,0,425,0,0,0,0,0,0,649,425,649,425,200,0,240,0,0,0,0,0,0,0,300,200,0,0,0,240,0,0,240,0,0,0,0,0,0,425,0};
    //RUTA2:
    //{600,0,0,0,0,0,0,0,0,0,400,0,0,0,0,0,649,0,0,0,649,240,0,649,0,0,0,0,0,649,649,0,0,0,0,0,0,0,0,400,0,0,0,0,0,0,0,0,0,0,0,0,250,0,0,600,0,0,0,0,0,0,0,0,0,0,0,600,0,400,500,500,0,500,500,0};
    int[] _credit1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    int[] _credit1_2 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    //RUTA1
    //{"17PKL053959","17PKL063956","17PKL063957","17PKL066956","17PKL061953","17PKL121906","17PKL122905","17PKL197867","17PKM022046","17PKM022040","17PKM006028","17PJM956004","17PKM011028","17PJM957007","17PJM985023","17PKM000033","17PKM000029","17PKM006028","17PKM013024","17PKL061957","17PKM038013","17PJL945981","17PKM017019","17PKL129901","17PKL060964","17PKL124906","17PKL015999","17PKL133900","17PKL136899","17PKL133900","17PKL137898","17PKL150888","17PKL178903","17PKL200856","17PKL168888","17PKL184902","17PKL132902","17PJL988948","17PKL193912","17PJL989949","17PKL122905","17PKL197867","17PKM022046","17PKM022040","17PKM011028","17PKM006028","17PJM956004","17PJM957007","17PKL053959","17PKL063956","17PKL066956","17PKL063956","17PKL061953","17PKL121906","17PKM000029","17PJM985023","17PKM000033","17PKM006028","17PKM038013","17PKM013024","17PKL061957","17PJL984951","17PKL052960","17PKL213857","17PKL245874","17PKL257871","17PKL289874","17PKL303862","17PKL358821","17PKL357821","17PKL318846","17PKL308858","17PKL305862","17PKL305862","17PKL306862","17PKL307862","17PKL308863","17PKL308864","17PKL309865","17PKL310866","17PKL121933","17PKL128972","17PKL127967","17PKL126966","17PKM049069","17PKL126966","17PKM048069","17PKM100039","17PKM101054"};
    //RUTA2
    //{"17PJL711701","17PJL740684","17PJL739683","17PJL740685","17PJL742685","17PJL740688","16PHR292687","17PJL744683","16PHR270692","16PHR268693","16PHR268694","16PHR269693","16PHR268693","16PHR266691","16PHR267691","16PHR267690","16PHR264683","16PHR246718","16PHR246718","16PHR243723","16PHR245720","16PHR229709","16PHR229709","16PHR215708","16PHR207709","16PHR205704","16PHR183689","16PHR181689","16PHR177695","16PHR177696","16PHR177696","16PHR175698","16PHR161717","16PHR164723","16PHR167726","16PHR231756","16PHR264791","16PHR226759","17PJL718823","17PJL718823","17PJL762773","16PHR283685","17PJL732789","16PHR249720","16PHR248716","16PHR269687","16PHR259670","16PHR259673","16PHR269692","16PHR259658","17PJL759687","17PJL831702","17PJL797676","17PJL801675","17PJL832716","17PJL817722","17PJL801728","17PJL804732","17PJL798717","17PJL743841","17PJL715787","16PHR265771","16PHR264773","17PJL716785","16PHR185781","16PHR204777","16PHR210771","16PHR215770","16PHR199778","16PHR192779","16PHR200780","16PHR164723","16PHR161717","16PHR175698","16PHR177696","16PHR231756","16PHR226759","16PHR167726","16PHR264791","17PJL718823","17PJL718823","17PJL732789","17PJL762773","16PHR249720","16PHR283685","16PHR248716","16PHR269687","16PHR259673","16PHR259670"};
    //RUTA8
    //{"16PHR028965","16PGR975926","16PGR944897","16PGR943896","16PGR980923","16PGR943895","16PGR876863","16PHR004913","16PGR854804","16PHR004913","16PGR932856","16PHR033899","16PGR932856","16PGR907909","16PGR906909","16PGR915824","16PGR863929","16PGR863930","16PGR863929","16PGR891917","16PGR917930","16PGR928917","16PHR153992","16PHR143962","16PHR141960","16PHR144979","16PHR144953","16PHR136963","16PHR134977","16PHR137970","16PHR094993","16PHR039993","16PHR023971","16PHR020974","16PGR957900","16PGR972878","16PGR946891","16PGR943885","16PGR944885","16PHR030921","16PHR203972","16PHR028965","16PGR975926","16PGR980923","16PGR944897","16PGR943895","16PGR943896","16PGR876863","16PHR004913","16PGR854804","16PHR004913","16PGR932856","16PHR033899","16PGR932856","16PGR915824","16PGR906909","16PGR907909","16PGR863929","16PGR863929","16PGR863930","16PGR891917","16PGR928917","16PGR917930"};
    //RUTA3
    //{"17PJL76399058","17PJL76399072","17PJL76439057","17PJL76489078","17PJL76089055","17PJL76069049","17PJL76559049","17PJL71719611","16PHR23919678","16PHR23289714","16PHR23289714","16PHR23679777","16PHR23759772","16PHR19819690","16PHS22060138","16PHS21560175","16PHS19600135","16PHS19360134","16PHS17750120","16PHS18430159","16PHS18470119","16PHS18470119","16PHR19109990","16PHS19080003","16PHS19080003","16PHS19000003","16PHS18960004","16PHS17430320","16PHS07900134","16PHS11720078","16PHS14790022","16PHR21229230","16PHR22169825","16PHR19229816","16PHR18849841","16PHR18819894","16PHS15830015","16PHS13180129","16PHS13250148","16PHS13250148","16PHS13030136","16PHS14830024","16PHS14790021","16PHS14780023","16PHS15100005","16PHS15250006","16PHR21009281","16PHR21049268","16PHR21009281","16PHS21510173","17PJL72269834","16PHS17080494","16PHR23509712","16PHR20239645"};
    //RUTA7
    //{"16PHS25240271","16PHS27800389","16PHR20979947","16PHS18300012","16PHS20530225","16PHS22900088","16PHS13430119","16PHS19410272","16PHR23809923","16PHS25190075","16PHS19510217","17PJL71059858","16PHS28220458","16PHR25019743","16PHS20210263","16PHS23630155","16PHS12820154","16PHS26150135","16PHS27720025","16PHS14580064","16PHR20799831","16PHS26530238","16PHS26710401","16PHS24730296","16PHR14899955","16PHS22330070","16PHS20160140","16PHS24660206","16PHR14799978","16PHS20090153","16PHS22070135","16PHS25250014","16PHR21159763","16PHS15380028","16PHR20419952","16PHS22050036","16PHS23390273","16PHS13900062","16PHS21310257","16PHS26530328","17PKM75400562"};
    //RUTA46
    //{"16PHS26280395","16PHS25640484","16PHS26040676","16PHS28270486","16PHS28670668","16PHS25580258","16PHS25580258","16PHR27609970"};

    String[] _TRON1 = {"17PJL76399058","17PJL76399072","17PJL76439057","17PJL76489078","17PJL76089055","17PJL76069049","17PJL76559049","17PJL71719611","16PHR23919678","16PHR23289714","16PHR23289714","16PHR23679777","16PHR23759772","16PHR19819690","16PHS22060138","16PHS21560175","16PHS19600135","16PHS19360134","16PHS17750120","16PHS18430159","16PHS18470119","16PHS18470119","16PHR19109990","16PHS19080003","16PHS19080003","16PHS19000003","16PHS18960004","16PHS17430320","16PHS07900134","16PHS11720078","16PHS14790022","16PHR21229230","16PHR22169825","16PHR19229816","16PHR18849841","16PHR18819894","16PHS15830015","16PHS13180129","16PHS13250148","16PHS13250148","16PHS13030136","16PHS14830024","16PHS14790021","16PHS14780023","16PHS15100005","16PHS15250006","16PHR21009281","16PHR21049268","16PHR21009281","16PHS21510173","17PJL72269834","16PHS17080494","16PHR23509712","16PHR20239645"};
            //{"17PJL772932","17PJL74046848","17PJL772932","17PJL74026850","17PJL77293244","17PJL772932","16PHR29226871","17PJL74476838","16PHR27046929","16PHR26896939","16PHR26896941","16PHR26996931","16PHR26876932","16PHR26676913","16PHR26776910","16PHR26776909","16PHR26406834","16PHR24677186","16PHR24687182","16PHR24357237","16PHR24547200","16PHR22937095","16PHR22937095","16PHR21507087","16PHR20757097","16PHR20537048","16PHR18356890","16PHR18136890","16PHR17776950","16PHR17716960","16PHR17706963","16PHR17556985","16PHR16137175","16PHR16407232","16PHR16747266","16PHR23187565","16PHR26407913","16PHR22617590","17PJL71848232","17PJL71848232","17PJL76267735","16PHR28316856","17PJL73217893","16PHR24937208","16PHR24807167","16PHR26996876","16PHR25916704","16PHR25926736","16PHR26976928","16PHR25936583","17PJL75996874","17PJL83137026","17PJL79786768","17PJL80166751","17PJL83237165","17PJL81707226","17PJL80137281","17PJL80467324","17PJL79857178","17PJL74318418","17PJL71547878","16PHR26527714","16PHR26487733","17PJL71687854","16PHR18577815","16PHR20417776","16PHR21017710","16PHR21567703","16PHR19967785","16PHR19287793","16PHR20077800","16PHR16407232","16PHR16137175","16PHR17556985","16PHR17706963","16PHR23187565","16PHR22617590","16PHR16747266","16PHR26407913","17PJL71848232","17PJL71848232","17PJL73217893","17PJL76267735","16PHR24937208","16PHR28316856","16PHR24807167","16PHR26996876","16PHR25926736","16PHR25916704"};
            //{"17PKL05349597","17PKL06309569","17PKL06399570","17PKL06689568","17PKL06199535","17PKL12129068","17PKL12269052","17PKL19738676","17PKM02220460","17PKM02250406","17PKM00610286","17PJM95640048","17PKM01170288","17PJM95730071","17PJM98510232","17PKM00050331","17PKM00010296","17PKM00600287","17PKM01360246","17PKL06179572","17PKM03820137","17PJL94539810","17PKM01760193","17PKL12999012","17PKL06039641","17PKL12439064","17PKL01569994","17PKL13369003","17PKL13638990","17PKL13329006","17PKL13718988","17PKL15098882","17PKL17839037","17PKL20048569","17PKL16898884","17PKL18459027","17PKL13289023","17PJL98889489","17PKL19309129","17PJL98919491","17PKL12269052","17PKL19738676","17PKM02220460","17PKM02250406","17PKM01170288","17PKM00610286","17PJM95640048","17PJM95730071","17PKL05349597","17PKL06309569","17PKL06689568","17PKL06399570","17PKL06199535","17PKL12129068","17PKM00010296","17PJM98510232","17PKM00050331","17PKM00600287","17PKM03820137","17PKM01360246","17PKL06179572","17PJL98429516","17PKL05279604","17PKL21378579","17PKL24568747","17PKL25748711","17PKL28998749","17PKL30378624","17PKL35838218","17PKL35738219","17PKL31828469","17PKL30818583","17PKL30528624","17PKL30588622","17PKL30668621","17PKL30788628","17PKL30838635","17PKL30858640","17PKL30968653","17PKL31068669","17PKL12139330","17PKL12839720","17PKL12779677","17PKL12659664","17PKM04930698","17PKL12659665","17PKM04850696","17PKM10010390"};

    //16PHR25936583
    //RUTA1:
    //{"17PKM083058","17PKM083059","17PKM079062","17PKM102062","17PKM099063","17PKM098068","17PKM096065","17PKM118059","17PKM118059","17PKM117059","17PKL068974","17PKL119909","17PKL061953","17PKL053959","17PKL063956","17PKL061953","17PKL063957","17PKL066956","17PKL122905","17PKL197867","17PKM022046","17PKL121906","17PKM011028","17PKM006028","17PKM022040","17PJM956004","17PJM957007","17PJM985023","17PKM000029","17PKM000033","17PKM038013","17PKL061957","17PKM013024","17PKM006028","17PKL069961","17PKL131955","17PKL034857","17PKL092892","17PKL033860","17PKL029854","17PKL056963","17PKL056962","17PKL051966","17PKL011959","17PJL998949","17PKL011959","17PKL166939","17PJL988948"};
    //RUTA2:
    //{"16PHR259658","16PHR269692","17PJL759687","17PJL797676","17PJL801675","17PJL831702","17PJL832716","17PJL817722","17PJL801728","17PJL804732","17PJL798717","17PJL743841","17PJL715787","17PJL711701","17PJL739683","17PJL740685","17QJU837819","17PJL744683","17PJL742685","16PHR292687","17PJL740688","16PHR270692","16PHR269693","16PHR268693","16PHR267690","16PHR268694","16PHR268693","16PHR267691","16PHR266691","16PHR264683","16PHR246718","16PHR246718","16PHR245720","16PHR205704","16PHR183689","16PHR207709","16PHR181689","17PJL716785","16PHR177696","16PHR177695","16PHR265771","16PHR220764","16PHR264773","16PHR215770","16PHR210771","16PHR192779","16PHR185781","16PHR204777","16PHR199778","16PHR200780","16PHR203778","16PHR219764","16PHR229709","16PHR229709","16PHR215708","16PHR224755","16PHR234731","16PHR163643","16PHR164644","16PHR170659","16PHR160660","16PHR164659","16PHR166665","16PHR188657","16PHR186658","16PHR243723","16PHR180663","16PHR234652","16PHR232649","16PHR190657","17PJL764836","16PHR203665","17PJL769784","16PHR203665","17PJL764836","17PJL769784"};
    String[] _TRON1_2 = {"16PHR259658","16PHR269692","17PJL759687","17PJL797676","17PJL801675","17PJL831702","17PJL832716","17PJL817722","17PJL801728","17PJL804732","17PJL798717","17PJL743841","17PJL715787","17PJL711701","17PJL739683","17PJL740685","17QJU837819","17PJL744683","17PJL742685","16PHR292687","17PJL740688","16PHR270692","16PHR269693","16PHR268693","16PHR267690","16PHR268694","16PHR268693","16PHR267691","16PHR266691","16PHR264683","16PHR246718","16PHR246718","16PHR245720","16PHR205704","16PHR183689","16PHR207709","16PHR181689","17PJL716785","16PHR177696","16PHR177695","16PHR265771","16PHR220764","16PHR264773","16PHR215770","16PHR210771","16PHR192779","16PHR185781","16PHR204777","16PHR199778","16PHR200780","16PHR203778","16PHR219764","16PHR229709","16PHR229709","16PHR215708","16PHR224755","16PHR234731","16PHR163643","16PHR164644","16PHR170659","16PHR160660","16PHR164659","16PHR166665","16PHR188657","16PHR186658","16PHR243723","16PHR180663","16PHR234652","16PHR232649","16PHR190657","17PJL764836","16PHR203665","17PJL769784","16PHR203665","17PJL764836","17PJL769784"};
            //{"16PHR26976928","16PHR26976928","17PJL772932","17PJL79786768","17PJL772932","17PJL83137026","17PJL83237165","17PJL81707226","17PJL80137281","17PJL80467324","17PJL79857178","17PJL74318418","17PJL71547878","17PJL71147019","17PJL73996838","17PJL74026850","17QJU83768195","17PJL74476838","17PJL74206856","16PHR29226871","17PJL74076887","16PHR27046929","16PHR26996931","16PHR26896939","16PHR26776909","16PHR26896941","16PHR26876932","16PHR26776910","16PHR26676913","16PHR26406834","16PHR24677186","16PHR24687182","16PHR24547200","16PHR20537048","16PHR18356890","16PHR20757097","16PHR18136890","17PJL71687854","16PHR17716960","16PHR17776950","16PHR26527714","16PHR22007642","16PHR26487733","16PHR21567703","16PHR21017710","16PHR19287793","16PHR18577815","16PHR20417776","16PHR19967785","16PHR20077800","16PHR20307781","16PHR21997642","16PHR22937095","16PHR22937095","16PHR21507087","16PHR22467554","16PHR23407313","16PHR16366439","16PHR16426449","16PHR17006593","16PHR16016602","16PHR16466598","16PHR16686655","16PHR18886579","16PHR18676584","16PHR24357237","16PHR18046635","16PHR23426521","16PHR23266490","16PHR19096579","17PJL76408366","16PHR20336653","17PJL76957840","16PHR20336653","17PJL76408366","17PJL76957840"};
                    //{"17PKM10170540","17PKM08380581","17PKM08310591","17PKM07990621","17PKM10290626","17PKM09990635","17PKM09870685","17PKM09650655","17PKM11810594","17PKM11820594","17PKM11740594","17PKL06849740","17PKL11989097","17PKL06199535","17PKL05349597","17PKL06309569","17PKL06199535","17PKL06399570","17PKL06689568","17PKL12269052","17PKL19738676","17PKM02220460","17PKL12129068","17PKM01170288","17PKM00610286","17PKM02250406","17PJM95640048","17PJM95730071","17PJM98510232","17PKM00010296","17PKM00050331","17PKM03820137","17PKL06179572","17PKM01360246","17PKM00600287","17PKL06989610","17PKL13119554","17PKL03458573","17PKL09248922","17PKL03348603","17PKL02958547","17PKL05629632","17PKL05619626","17PKL05139664","17PKL01139596","17PJL99879495","17PKL01129590","17PKL16669393","17PJL98859488"};



    String[] _direccionDB = {"GRANO DE ORO 600NORTE DE LA PLAZA","75 ESTE DEL TRANSITO DE TURRIALBA","FRENTE AL PARQUE","CARRETERA HACIA PERALTA","DE LA ESCUELA DE CALLE DEL CAS 300 ESTE","DE LA ESCUELA DEL CAS 700 OESTE","600 ESTE DE LA ESCUELA EL CAS","BARRIOS LOS SAUSES","BARRIO LOS SAUCES","BARRIO LOS SAUCES","BARRIO EL ORIENTE SANTA ROSA","BARRIO EL ORIENTE SANTA ROSA","PEJIBALLE 300 SUROESTE DE LA ESCUELA","DIAGONAL AL PARQUE LA SUIZA","DE LA RURAL50 OESTE","CENTRO LA SUIZ","FRENTE AL BANCO NACIONEAL DE SUIZA","FRENTE A PLAZA DE DEPORTES DE LA SUIZA","FRENTE A PLAZA LAS COLONIAS","BARRIO 100 MANZANAS 200 SUR DE LA ESCUELA","BARRIO 100 MANZANAS 800 NORTE DE LA ESCULA","FRENTE AL CENTRO EDUCATIVO TAYUDIC","DE LA ESCULA DE TAYITIC 2 KM SUR","DE LA ESCUELA 75 NORTE","BAJOS DE PACUARE FRENTE A IGLESIA","BAJOS DE PACUARE SOBRE CARRETERA","GRANO DE ORO CENTRO","GRANO DE ORO QUETZAL ESCUELA 250SUR","GRANO DE ORO 300 ESTE","FRENTE A PLAZA DE DEPORTES DE GRANO DE ORO","DE LA CONCHA DEPORTIVA 50 ESTE GRANO DE ORO","GRANO DE ORO 200 NORTE","TERMINAL DE TRANSTUSA","DE LA ESCUELA DE SITIO MATA 300 ESTE","500 OESTE DE LA ESCUELA","CENTRO DE LLANOS PAVONES","100 SUR DE LA ESCUELA DE JOBILLOS","TURRIALBA CENTRO","DEL PARQUE DE AQUIARES 50 NORTE","DE COOPEANDE 50 NORTE","PEJIBALLE EL HUMO CENTRO","DE LA IGLESIA PEJIBAYE 400 SUR","PEJIBALLE ATIRRO 700 OESTE","DEL PARQUE DE TURRIALNA 200 NORTE","SANTA ELENA 50 NORTE DE FOTOS MARTINEZ","JUAN VILLAS 400 NORTE DE LA ESCUELA","JUAN VIÑAS LOS ALPES ESCUELA 100 ESTE","JUAN VIÑAS 50 OESTE","JUAN VIÑAS DE LA IGLESIA 50 NORTE","FRENTE A LA ESCUELA DE GUAYABO","SANTA CRUZ CENTRO","DEL CENTRO DE SANTA CRUZ KM AL NORTE","DIAGONAL A LA IGLESIA DEL TUIS","CANADA LASUIZA DE LA ESCUELA 50M OESTE","PERALTA CENTRO DE LA ESCUELA 25 ESTE","CAPELLADES DIAGONAL A LA IGLESIA","BARRIO CANADA 150 OESTE DE ESCUELA","DE LA ESCUELA DE LA LIRA 400 NORTE","CENTRO DE TURRIALBA DIAGONAL A LA PLAZA","TURIALBA CENTRO","DE LA ESCULEA DE PAVONES 300 NORTE","300 NORTE DE LA CRUZ ROJA LA SUIZA","SANTA CRUZ CENNTRO DE LA IGLESIA 200 NORTE","DEL MONUMENTO GUAYABO 5 KM NORTE","300 NORESTE DE LA IGLESIA DEL CARMEN DE SANTA CRUZ","DEL BAR ARC NOE 800 MT MANO DERACHA","DEL BAR ARC NOE 800 MT MANO DERACHA"};
    String[] _telefonoDB = {"8337-3517","2556-6621","2559-1020","8635-5975","8346,7764","8350-8612","2285-1700","8659-0449","2245-1709","2245-1861","2529-2047","2578-0187","8989-7322","2531-1281","2531-1919","8745-3214","2531-1084","6138-6734","8841-4225","7102-3673","8357-2837","8846-3392","","2554-8345","","","","8472-0883","2532-2083","","","","8950-3754","2539-1670","2538-1122","8648-7436","2538-1514","2556-1834","2556-2298","8790-7444","2531-3102","2272-9150","2272-2313","2274-4747","8753-7194","","2532-1020","2532-2010","8767-1688","2221-2733","6103-1234","8320-7649","2292-4583","2531-1101","2559-0915","","2531-1530","2577-1940","2574-2630","2577-1034","2538-1005","8488-6045","","7156-2072","8770-8047","8971-2653",""};
    Integer[] _descuentoDB = {0,425,425,0,0,0,0,0,0,0,0,0,240,0,649,0,240,200,649,0,0,649,0,0,0,0,0,0,0,0,0,0,649,0,649,649,200,300,649,-1,240,240,0,300,0,0,0,240,649,425,0,200,0,200,0,0,425,649,200,425,300,649,240,0,0,240,240};
    Integer[] _creditDB = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
    private int _SelectedOption = 0;

    TextView myLabel;
    Button sendButton;

    // UI Widgets.
    private Button mRequestUpdatesButton;
    private Button mRemoveUpdatesButton;
    private Button mRequestButton;
    private TextView mLocationUpdatesResultView;
    private EditText mTextView;
    /*********************************************************
     * Facturacion
     */
    RadioButton m_i20, m_i25, m_i35,m_i45,m_i100,m_lts,m_kgs,m_i10,m_i40,m_i60;
    RadioButton m_i20r, m_i25r, m_i35r,m_i45r,m_i100r,m_i10r,m_i40r,m_i60r;
    Button m_add,m_substract;
    String _codigocliente = "0";
    String _client = "Libreria Hellen";
    String _ruta = "1";
    String _coords = "9.872890,-83.944350";
    String _date;
    double _totalfac = 0;
    String _Quantities;
    int _facnum = 10001;
    String _credit = "c";
    String _desc = "y";

    int Q10,Q20,Q25,Q35,Q40,Q45,Q60,Q100,Qlts,Qkgs;
    int Q10r,Q20r,Q25r,Q35r,Q40r,Q45r,Q60r,Q100r;



    double _precioCilindro10 = 2783;
    double _precioCilindro20 = 5567;
    double _precioCilindro25 = 5693;//6967
    double _precioCilindro35 = 9742;
    double _precioCilindro40 = 11134;
    double _precioCilindro45 = 12526;
    double _precioCilindro60 = 16700;
    double _precioCilindro100 = _precioCilindro25 * 4;


    double _descCilindro25 = 0;
    double _descCilindro100 = _descCilindro25 * 4;

    double _descCilindro10 = round(_descCilindro25/25) * 10;
    double _descCilindro20 = round(_descCilindro25/25) * 20;
    double _descCilindro35 = round(_descCilindro25/25) * 35;
    double _descCilindro40 = round(_descCilindro25/25) * 40;
    double _descCilindro45 = round(_descCilindro25/25) * 45;
    double _descCilindro60 = round(_descCilindro25/25) * 60;

    LatLon2MGRS c;


    double _precioLts = 221.4;
    double _precioKgs = _precioLts * 11.67;
    //database helper object
    private DatabaseHelper db;

    //View objects
    private Button buttonAdd,buttonSync;
    EditText myUserName;

    private ListView listViewNames;
    private String LAT,LONG;

    private LocationManager locationManager;
    private LocationListener locationListener;

    //List to store all the names
    private List<Name> names;

    //1 means data is synced and 0 means data is not synced
    public static final int NAME_SYNCED_WITH_SERVER = 1;
    public static final int NAME_NOT_SYNCED_WITH_SERVER = 0;

    //a broadcast to know weather the data is synced or not
    public static final String DATA_SAVED_BROADCAST = "net.simplifiedcoding.datasaved";

    //Broadcast receiver to know the sync status
    private BroadcastReceiver broadcastReceiver;

    //adapterobject for list view
    private NameAdapter nameAdapter;
    private void saveName(final int id, final String name) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, MainActivity.URL_SAVE_NAME,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj = new JSONObject(response);
                            if (!obj.getBoolean("error")) {
                                //updating the status in sqlite
                               // db.updateNameStatus(id, MainActivity.NAME_SYNCED_WITH_SERVER);


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LAT = "-10000";
        //initializing views and objects
        db = new DatabaseHelper(this);
        names = new ArrayList<>();

        Q10 = Q40 = Q60 = Q20 = Q25 = Q35 = Q45 = Q100 = Qlts = Qkgs = 0;

        m_i20 = (RadioButton) findViewById(R.id.i20); m_i25 = (RadioButton) findViewById(R.id.i25);
        m_i35 = (RadioButton) findViewById(R.id.i35); m_i45 = (RadioButton) findViewById(R.id.i45);
        m_i10 = (RadioButton) findViewById(R.id.i10); m_i40 = (RadioButton) findViewById(R.id.i40);
        m_i100= (RadioButton) findViewById(R.id.i100); m_i60 = (RadioButton) findViewById(R.id.i60);
        m_lts = (RadioButton) findViewById(R.id.ilts);m_kgs = (RadioButton) findViewById(R.id.ikgs);

        m_i20r = (RadioButton) findViewById(R.id.i20r); m_i25r = (RadioButton) findViewById(R.id.i25r);
        m_i35r = (RadioButton) findViewById(R.id.i35r); m_i45r = (RadioButton) findViewById(R.id.i45r);
        m_i100r= (RadioButton) findViewById(R.id.i100r); m_i60r = (RadioButton) findViewById(R.id.i60r);
        m_i10r = (RadioButton) findViewById(R.id.i10r); m_i40r = (RadioButton) findViewById(R.id.i40r);

        m_add = (Button) findViewById(R.id.btn_add); m_substract = (Button) findViewById(R.id.btn_substract);

        mTextView = (EditText) findViewById(R.id.txtWebsite);

        mTextView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {


                if (actionId == EditorInfo.IME_ACTION_SEND) { //IME_ACTION_DONE para cerrar editor
                    //m_i25.setText("25 lbs x "+mTextView.getText().toString()+"  Unids.");
                    switch (_SelectedOption ){
                        case 0:
                            Q25 = Integer.valueOf(mTextView.getText().toString());
                            m_i25.setText("25 x "+mTextView.getText().toString());

                            break;
                        case 125:
                            Q25r = Integer.valueOf(mTextView.getText().toString());
                            m_i25r.setText("25r x "+mTextView.getText().toString());
                            break;
                        case 1:
                            Q20= Integer.valueOf(mTextView.getText().toString());
                            m_i20.setText("20 x "+mTextView.getText().toString());
                            break;
                        case 10:
                            Q20r= Integer.valueOf(mTextView.getText().toString());
                            m_i20r.setText("20r x "+mTextView.getText().toString());
                            break;

                        case 2:
                            Q35= Integer.valueOf(mTextView.getText().toString());
                            m_i35.setText("35 x "+mTextView.getText().toString());
                            break;
                        case 20:
                            Q35r= Integer.valueOf(mTextView.getText().toString());
                            m_i35r.setText("35r x"+mTextView.getText().toString());
                            break;
                        case 3:
                            Q45= Integer.valueOf(mTextView.getText().toString());
                            m_i45.setText("45 x "+mTextView.getText().toString());
                            break;
                        case 30:
                            Q45r= Integer.valueOf(mTextView.getText().toString());
                            m_i45r.setText("45r x "+mTextView.getText().toString());
                            break;
                        case 4:
                            Q100= Integer.valueOf(mTextView.getText().toString());
                            m_i100.setText("Te x "+mTextView.getText().toString());
                            break;
                        case 40:
                            Q100r= Integer.valueOf(mTextView.getText().toString());
                            m_i100r.setText("Ter x "+mTextView.getText().toString());
                            break;
                        case 5:
                            Qlts= Integer.valueOf(mTextView.getText().toString());
                            m_lts.setText("Granel lts x "+mTextView.getText().toString());
                            break;
                        case 6:
                            Qkgs= Integer.valueOf(mTextView.getText().toString());
                            m_kgs.setText("Granel kgs x "+mTextView.getText().toString());
                            break;
                        case 7:
                            Q10 = Integer.valueOf(mTextView.getText().toString());
                            m_i10.setText("10 x "+mTextView.getText().toString());
                            break;
                        case 70:
                            Q10r = Integer.valueOf(mTextView.getText().toString());
                            m_i10r.setText("10r x "+mTextView.getText().toString());
                            break;
                        case 8:
                            Q40 = Integer.valueOf(mTextView.getText().toString());
                            m_i40.setText("40 x "+mTextView.getText().toString());
                            break;
                        case 80:
                            Q40r = Integer.valueOf(mTextView.getText().toString());
                            m_i40r.setText("40r x "+mTextView.getText().toString());
                            break;
                        case 9:
                            Q60 = Integer.valueOf(mTextView.getText().toString());
                            m_i60.setText("60 x "+mTextView.getText().toString());
                            break;
                        case 90:
                            Q60r = Integer.valueOf(mTextView.getText().toString());
                            m_i60r.setText("60r x "+mTextView.getText().toString());
                            break;
                        default:
                            break;
                    }
                    //progressButton.performClick();
                    return true;
                }

                return false;
            }
        });

        m_add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
        sendButton = (Button) findViewById(R.id.send);
        sendButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //codigocliente = getClienteFromGPS(_TRON6);

                if(codigocliente != -1){

                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int choice) {
                            switch (choice) {
                                case DialogInterface.BUTTON_POSITIVE:

                                    //saveNameToLocalStorage();
/*
                                    saveNameToServer( _ruta8[codigocliente] +"," +_totalfac + "," + String.valueOf(Q10) + "," + String.valueOf(Q20)
                                            + "," + String.valueOf(Q25)+ "," + String.valueOf(Q35)+ "," + String.valueOf(Q45)+ "," + String.valueOf(Q60)
                                            + "," + String.valueOf(Q100)
                                            + "," + String.valueOf(Q10r) + "," + String.valueOf(Q20r)
                                            + "," + String.valueOf(Q25r)+ "," + String.valueOf(Q35r)+ "," + String.valueOf(Q45r)+ "," + String.valueOf(Q60r)
                                            + "," + String.valueOf(Q100r) + "," + LAT + "," + LONG + "," + _credit8[codigocliente]+"," + String.valueOf(_descuento8[codigocliente])+","+_supervisor);
*/
                                    if(usardos == 1){
                                        saveNameToServer( _ruta1[codigocliente] +"," +_totalfac + "," + String.valueOf(Q10) + "," + String.valueOf(Q20)
                                                + "," + String.valueOf(Q25)+ "," + String.valueOf(Q35)+ "," + String.valueOf(Q45)+ "," + String.valueOf(Q60)
                                                + "," + String.valueOf(Q100)
                                                + "," + String.valueOf(Q10r) + "," + String.valueOf(Q20r)
                                                + "," + String.valueOf(Q25r)+ "," + String.valueOf(Q35r)+ "," + String.valueOf(Q45r)+ "," + String.valueOf(Q60r)
                                                + "," + String.valueOf(Q100r) + ","  +_descuento1_2[codigocliente]+ "," + LAT + "," + LONG + "," + _supervisor);

                                    }else{

                                        saveNameToServer( _ruta1_2[codigocliente] +"," +_totalfac + "," + String.valueOf(Q10) + "," + String.valueOf(Q20)
                                                + "," + String.valueOf(Q25)+ "," + String.valueOf(Q35)+ "," + String.valueOf(Q45)+ "," + String.valueOf(Q60)
                                                + "," + String.valueOf(Q100)
                                                + "," + String.valueOf(Q10r) + "," + String.valueOf(Q20r)
                                                + "," + String.valueOf(Q25r)+ "," + String.valueOf(Q35r)+ "," + String.valueOf(Q45r)+ "," + String.valueOf(Q60r)
                                                + "," + String.valueOf(Q100r) + "," + LAT + "," + LONG + "," +_descuento1_2[codigocliente]+ "," +_supervisor);
                                    }
                                    codigocliente = -1;


                                    mTextView.setText("0");

                                    m_i25.setText("25 x "+mTextView.getText().toString());

                                    m_i25r.setText("25r x "+mTextView.getText().toString());

                                    m_i20.setText("20 x "+mTextView.getText().toString());

                                    m_i20r.setText("20r x "+mTextView.getText().toString());

                                    m_i35.setText("35 x "+mTextView.getText().toString());

                                    m_i35r.setText("35r x"+mTextView.getText().toString());

                                    m_i45.setText("45 x "+mTextView.getText().toString());

                                    m_i45r.setText("45r x "+mTextView.getText().toString());

                                    m_i100.setText("Te x "+mTextView.getText().toString());

                                    m_i100r.setText("Ter x "+mTextView.getText().toString());


                                    m_i10.setText("10 x "+mTextView.getText().toString());

                                    m_i10r.setText("10r x "+mTextView.getText().toString());

                                    m_i40.setText("40 x "+mTextView.getText().toString());

                                    m_i40r.setText("40r x "+mTextView.getText().toString());

                                    m_i60.setText("60 x "+mTextView.getText().toString());

                                    m_i60r.setText("60r x "+mTextView.getText().toString());

                                    Q10 = Q10r = Q20 = Q20r = Q25 = Q25r = Q35 = Q35r = Q40 = Q40r = Q45 = Q45r = Q60 = Q60r = Q100 = Q100r = 0;

                                    //saveNameToServer("0,"+editTextName.getText().toString()+","+LAT+","+LONG+","+_supervisor);
                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:

                                    break;
                            }
                        }
                    };

                    if (usardos == 1){
                        calcularFactura(_descuento1,_credit1,_ruta1,codigocliente);
                    }else{
                        calcularFactura(_descuento1_2,_credit1,_ruta1_2,codigocliente);
                    }



                    //calcularFactura(_descuento8,_credit8,_ruta8,codigocliente);
                    //calcularFactura(_descuento8,_credit8,_ruta8,codigocliente);

                    android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
                    builder.setTitle(_client);

                    builder.setMessage(_ruta1_2[codigocliente] + _credit1[codigocliente] + _descuento1_2[codigocliente] + "Desglose de factura: " + "\n" + fac_detail + "\n Desglose Descuento" + desc_detail )
                            .setPositiveButton("Imprimir", dialogClickListener)
                            .setNegativeButton("Cancelar", dialogClickListener).show();
                }//END IF
                else{
                    Toast.makeText( getApplicationContext(),"Presione el boton Detectar para selecionar cliente",Toast.LENGTH_LONG).show();
                }





            }


        });


        myUserName = (EditText)findViewById(R.id.txtUserName); //Boton menos
        m_substract.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });
        m_i10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 7;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(true);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_i10r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 70;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(true);m_i40r.setChecked(false);
            }
        });
        m_i40.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 8;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(true);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_i40r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 80;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(true);
            }
        });
        m_i60.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 9;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(true);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_i60r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 90;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);m_i60r.setChecked(true);
            }
        });

        m_i20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 1;
                mTextView.setText("");
                m_i20.setChecked(true);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_i20r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 10;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(true);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_i25.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 0;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(true);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_i25r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 125;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(true);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_i35.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 2;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(true);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_i35r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 20;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(true);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_i45.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 3;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(true);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_i45r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 30;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(true);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_i100.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 4;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(true);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_i100r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 40;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(true);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_lts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 5;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(true);
                m_kgs.setChecked(false);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });
        m_kgs.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                _SelectedOption = 6;
                mTextView.setText("");
                m_i20.setChecked(false);m_i25.setChecked(false);m_i35.setChecked(false);
                m_i45.setChecked(false);m_i100.setChecked(false);m_lts.setChecked(false);
                m_kgs.setChecked(true);m_i10.setChecked(false);m_i40.setChecked(false);
                m_i60.setChecked(false);
                m_i20r.setChecked(false);m_i25r.setChecked(false);m_i60r.setChecked(false);
                m_i35r.setChecked(false);m_i45r.setChecked(false);m_i100r.setChecked(false);
                m_i10r.setChecked(false);m_i40r.setChecked(false);
            }
        });

        c = new LatLon2MGRS();

        //buttonSave = (Button) findViewById(R.id.buttonSave);
        buttonAdd = (Button) findViewById(R.id.buttonAddCliente);
        buttonSync = (Button) findViewById(R.id.btnsync);


        listViewNames = (ListView) findViewById(R.id.listViewNames);
        buttonSync.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                for(int l=0; l<=500; l++){
                    //db.updateNameStatus(l,NAME_NOT_SYNCED_WITH_SERVER);
                }

            }
        }
            );



        //Detectar BOTON
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                //codigocliente = getClienteFromGPS(_TRON8);
                /*
                usardos = 0;
                if (getClienteFromGPS(_TRON1) == -1){
                    codigocliente = getClienteFromGPS(_TRON1_2);
                    charSequences.add(new String(_ruta1_2[codigocliente]));
                }else{
                    codigocliente = getClienteFromGPS(_TRON1);
                    charSequences.add(new String(_ruta1[codigocliente]));
                    usardos = 1;
                }*/

                getClienteFromGPS(_TRON1,_TRON1_2);



                if (charSequences.size() > 0){
                    final CharSequence[] options = charSequences.toArray(new CharSequence[charSequences.size()]);



                charSequences.clear();

                //CharSequence options[] = new CharSequence[] {"Call", "SMS", "Email"};

                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
                //builder.setCancelable(false);
                builder.setTitle("Selecione un cliente:");
                builder.setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String[] index = indexes.toArray(new String[indexes.size()]);
                        //String[] index2 = indexes2.toArray(new String[indexes2.size()]);
                        String _sel = String.valueOf(options[which]);
                        if (_sel.substring(_sel.length() - 1).equals("1")){
                            usardos = 1;
                            codigocliente = Integer.parseInt(index[which]);
                        }else{
                            usardos = 2;
                            codigocliente = Integer.parseInt(index[which]);
                        }




                        // the user clicked on options[which]
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //the user clicked on Cancel
                    }
                });
                builder.show();
                }//END IF
                /*
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int choice) {
                        switch (choice) {
                            case DialogInterface.BUTTON_POSITIVE:

                                saveNameToServer("0,"+","+LAT+","+LONG+","+_supervisor);


                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };


                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder( MainActivity.this);
                builder.setMessage("Actualizar coordenadas para: ")
                        .setPositiveButton("Pura Vida", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();
                        */




/*
                if(txtCoords.getText().toString().equals("Buscando Coordenadas GPS")){
                    Toast.makeText(getApplicationContext(),"Buscando coordenadas espere un momento por favor",Toast.LENGTH_LONG).show();

                }else{
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int choice) {
                        switch (choice) {
                            case DialogInterface.BUTTON_POSITIVE:
                                if (editDesc.getText().toString() == "" || editDesc.getText().toString() == null){
                                    editDesc.setText("0");
                                }


                                //saveNameToServer("0,"+editTextName.getText().toString()+","+LAT+","+LONG+","+_supervisor);
                                saveNameToServer(","+LAT+","+LONG+","+_supervisor);


                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                break;
                        }
                    }
                };


                android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder( MainActivity.this);
                builder.setMessage("Actualizar coordenadas para: " + editName.getText().toString())
                        .setPositiveButton("Pura Vida", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();

                }//ELSE END*/



            }
        });

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //txtCoords.setText(String.valueOf(location.getLatitude()) + " " + String.valueOf(location.getLongitude()));
                LAT = String.valueOf(location.getLatitude());
                LONG = String.valueOf(location.getLongitude());

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);

            }
        };


        registerReceiver(new NetworkStateChecker(), new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));



        //adding click listener to button
        //buttonSave.setOnClickListener(this);

        //calling the method to load all the stored names
        loadNames();

        //the broadcast receiver to update sync status
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                //loading the names again
                loadNames();
            }
        };

        //registering the broadcast receiver to update sync status
        registerReceiver(broadcastReceiver, new IntentFilter(DATA_SAVED_BROADCAST));
    }


    String fac_detail,desc_detail;
    boolean _facok = true;


    //MODIFICAR ANTES DE CARGAR CLIENTES
    public int getClienteFromGPS(String[] _Tron,String[] _Tron_2){
        if (LAT.equals("-10000")){
            _CurrentGPS = "Aun no";

        }else{

            String _t = c.convertLatLonToMGRS(Double.parseDouble(LAT),Double.parseDouble(LONG));

            _t = _t.replace(" ","");
            _CurrentGPS2 = _t;


            _CurrentGPS = _t.substring(0,8) + _t.substring(10,13);//17PJL7723593279 100 metros
            //_CurrentGPS = _t.substring(0,9) + _t.substring(10,14);//17PJL7723593279 ACTIVAR PARA 10 METROS
            boolean isThere = Arrays.asList(_Tron).contains(_CurrentGPS);
            boolean isThere2 = Arrays.asList(_Tron_2).contains(_CurrentGPS);
            charSequences.clear(); indexes.clear();

            if(isThere){
                for(int i=0;i<_Tron.length;i++)
                {
                    if(_Tron[i].equals(_CurrentGPS)){
                        charSequences.add(_ruta1[i] + "1");
                        indexes.add(String.valueOf(i));
                    }


                }
            }
            if(isThere2){
                for(int i=0;i<_Tron_2.length;i++)
                {
                    if(_Tron_2[i].equals(_CurrentGPS)){
                        charSequences.add(_ruta1_2[i] + "2");
                        indexes.add(String.valueOf(i));
                    }

                }
            }



        }

       /* int value = Arrays.binarySearch(_TRON8, _t.substring(0,_t.length() - 2));
        if (value != -1) {
// my array has silly !
        }*/

        return -1;
    }

    void calcularFactura(int[] _descuentos,int[] _credito ,String[] razon_soc,int codigocliente){
        if (codigocliente != -1){
            //int codigocliente = Integer.parseInt(myUserName.getText().toString());
            //_codigocliente = razon_soc[codigocliente];
            _client = razon_soc[codigocliente];
            _descCilindro25 = _descuentos[codigocliente];



            if(_descCilindro25 > 1000){
                //ES TIENDA
                _precioCilindro10 = 2783;
                _precioCilindro20 = 5567;
                _precioCilindro25 = 6959;//6967
                _precioCilindro35 = 9742;
                _precioCilindro40 = 11134;
                _precioCilindro45 = 12526;
                _precioCilindro60 = 16700;
                _precioCilindro100 = _precioCilindro25 * 4;
                _desc = "y";
                int conso = (Q25 + Q25r) + ( Q100r*4);
                if((conso) < 10)
                    _descCilindro25 = 1975;
                if((conso > 9) && (conso < 21))
                    _descCilindro25 = 1754;
                if((conso > 19) && (conso < 31))
                    _descCilindro25 = 1858;
                if((conso >= 30) && (conso < 41))
                    _descCilindro25 = 1898;
                if((conso >= 40) && (conso < 51))
                    _descCilindro25 = 1908;
                if((conso >= 50) && (conso < 61))
                    _descCilindro25 = 1923;
                if(conso >= 60)
                    _descCilindro25 = 1933;

            }else{
                //Precio Agencia
                //ES TIENDA
                _precioCilindro10 = 228*10;
                _precioCilindro20 = 228*20;
                _precioCilindro25 = 5693;//6967
                _precioCilindro35 = 228*35;
                _precioCilindro40 = 228*40;
                _precioCilindro45 = 228*45;
                _precioCilindro60 = 228*60;
                _precioCilindro100 = _precioCilindro25 * 4;



                if(_descuentos[codigocliente] != 0){
                    _desc = "y";


                }else{
                    _desc = "n";
                }



            }


            _descCilindro100 = _descCilindro25 * 4;

            _descCilindro10 = round(_descCilindro25/25) * 10;
            _descCilindro20 = round(_descCilindro25/25) * 20;
            _descCilindro35 = round(_descCilindro25/25) * 35;
            _descCilindro40 = round(_descCilindro25/25) * 40;
            _descCilindro45 = round(_descCilindro25/25) * 45;
            _descCilindro60 = round(_descCilindro25/25) * 60;

            //if(_credito[codigocliente] != 0){
                _credit = "y";
            //}else{
                _credit = "n";
            //}


            float _fd25 = (float)((Q25+Q25r) * _descCilindro25);
            float _fd100 = (float)((Q100+Q100r) * _descCilindro100);
            float _fd10 = (float)((Q10+Q10r) * _descCilindro10);
            float _fd20 = (float)((Q20+Q20r) * _descCilindro20);
            float _fd35 = (float)((Q35+Q35r) * _descCilindro35);
            float _fd40 = (float)((Q40+Q40r) * _descCilindro40);
            float _fd45 = (float)((Q45+Q45r) * _descCilindro45);
            float _fd60 = (float)((Q60+Q60r) * _descCilindro60);


            float _f =  (float)((Q25+Q25r) * _precioCilindro25);float _f0 = (float)((Q20+Q20r) * _precioCilindro20);float _f2 = (float)((Q35+Q35r) * _precioCilindro35);
            float _f3 = (float)((Q45+Q45r) * _precioCilindro45);float _f4 = (float)((Q100+Q100r) * _precioCilindro100);float _f5 = (float)(Qlts * _precioLts);
            float _f6 = (float)(Qkgs * _precioKgs); float _f7 = (float)((Q10+Q10r) * _precioCilindro10); float _f8 = (float)((Q40+Q40r) * _precioCilindro40); float _f9 = (float)((Q60+Q60r) * _precioCilindro60);



            fac_detail = "";
            desc_detail = "";
            _Quantities = String.valueOf(Q20)+","+String.valueOf(Q25)+","+String.valueOf(Q35)+","+String.valueOf(Q45)+","+String.valueOf(Q100)+","+String.valueOf(Qlts)+","+String.valueOf(Qkgs)+","+String.valueOf(Q10)+","+String.valueOf(Q40)+","+String.valueOf(Q60);
            _totalfac = _f+_f0+_f2+_f3+_f4+_f5+_f6+_f7+_f8+_f9;

            if (Q10 > 0){
                fac_detail += "    "+String.valueOf(Q10+Q10r)+ "    "+ String.valueOf(_precioCilindro10)  +"       Cilndro 10   "+ String.format("%.2f", _f7);
                fac_detail += "\n";
                if (_desc == "y"){
                    desc_detail += "    "+String.valueOf(Q10+Q10r)+ "    "+ String.valueOf(_descCilindro10)  +"       10 Lbs   "+  String.format("%.2f", _fd10);
                    desc_detail += "\n";
                }
            }

            if (Q20 > 0){
                fac_detail += "    "+String.valueOf(Q20+Q20r)+ "    "+ String.valueOf(_precioCilindro20)  +"       Cilndro 20   "+ String.format("%.2f", _f0);
                fac_detail += "\n";
                if (_desc == "y"){
                    desc_detail += "    "+String.valueOf(Q20+Q20r)+ "    "+ String.valueOf(_descCilindro20)  +"       20 Lbs   "+  String.format("%.2f", _fd20);
                    desc_detail += "\n";
                }
            }
            if (Q25 > 0){
                fac_detail += "    "+String.valueOf(Q25+Q25r)+ "    "+ String.valueOf(_precioCilindro25)  +"       Cilndro 25   "+  String.format("%.2f", _f);
                fac_detail += "\n";
                if (_desc == "y"){
                    desc_detail += "    "+String.valueOf(Q25+Q25r)+ "    "+ String.valueOf(_descCilindro25)  +"       25 Lbs   "+  String.format("%.2f", _fd25);
                    desc_detail += "\n";
                }
            }
            if (Q35 > 0){
                fac_detail += "    "+String.valueOf(Q35+Q35r)+ "    "+ String.valueOf(_precioCilindro35)  +"       Cilndro 35   "+ String.format("%.2f", _f2);
                fac_detail += "\n";
                if (_desc == "y"){
                    desc_detail += "    "+String.valueOf(Q35+Q35r)+ "    "+ String.valueOf(_descCilindro35)  +"       35 Lbs   "+  String.format("%.2f", _fd35);
                    desc_detail += "\n";
                }
            }

            if (Q40 > 0){
                fac_detail += "    "+String.valueOf(Q40+Q40r)+ "    "+ String.valueOf(_precioCilindro40)  +"       Cilndro 40   "+ String.format("%.2f", _f8);
                fac_detail += "\n";
                if (_desc == "y"){
                    desc_detail += "    "+String.valueOf(Q40+Q40r)+ "    "+ String.valueOf(_descCilindro40)  +"       40 Lbs   "+  String.format("%.2f", _fd40);
                    desc_detail += "\n";
                }

            }
            if (Q45 > 0){
                fac_detail += "    "+String.valueOf(Q45+Q45r)+ "    "+ String.valueOf(_precioCilindro45)  +"       Cilndro 45   "+ String.format("%.2f", _f3);
                fac_detail += "\n";
                if (_desc == "y"){
                    desc_detail += "    "+String.valueOf(Q45+Q45r)+ "    "+ String.valueOf(_descCilindro45)  +"       20 Lbs   "+  String.format("%.2f", _fd45);
                    desc_detail += "\n";
                }
            }
            if (Q60 > 0){
                fac_detail += "    "+String.valueOf(Q60+Q60r)+ "    "+ String.valueOf(_precioCilindro60)  +"       Cilndro 60   "+ String.format("%.2f", _f9);
                fac_detail += "\n";
                if (_desc == "y"){
                    desc_detail += "    "+String.valueOf(Q60+Q60r)+ "    "+ String.valueOf(_descCilindro60)  +"       60 Lbs   "+  String.format("%.2f", _fd60);
                    desc_detail += "\n";
                }

            }
            if (Q100 > 0){
                fac_detail += "    "+String.valueOf(Q100+Q100r)+ "    "+ String.valueOf(_precioCilindro100)  +"       Cilndro 100   "+ String.format("%.2f", _f4);
                fac_detail += "\n";
                if (_desc == "y"){
                    desc_detail += "    "+String.valueOf(Q100+Q100r)+ "    "+ String.valueOf(_descCilindro100)  +"      100 Lbs   "+  String.format("%.2f", _fd100);
                    desc_detail += "\n";

                }
            }
            if (Qlts > 0){
                fac_detail += "    "+String.valueOf(Qlts)+ "  "+ String.format("%.2f", _precioLts)  +"     Granel Lts   "+ String.format("%.2f", _f5
                );
                fac_detail += "\n";
            }
            if (Qkgs > 0){
                fac_detail += "    "+String.valueOf(Qkgs)+ "  "+ String.format("%.2f", _precioKgs)  +"     Granel Kgs   "+ String.format("%.2f", _f6);
                fac_detail += "\n";
            }
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            //requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION},10);
            return;
        }else{


            locationManager.requestLocationUpdates("gps", 1000, 1, locationListener);


        }

    }


    /*
    * this method will
    * load the names from the database
    * with updated sync status
    * */
    private void loadNames() {
        names.clear();
        Cursor cursor = db.getNames();
        if (cursor.moveToFirst()) {
            do {
                Name name = new Name(
                        cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_NAME)),
                        cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_STATUS))
                );
                names.add(name);
            } while (cursor.moveToNext());
        }

        nameAdapter = new NameAdapter(this, R.layout.names, names);
        listViewNames.setAdapter(nameAdapter);
    }

    /*
    * this method will simply refresh the list
    * */
    private void refreshList() {
        nameAdapter.notifyDataSetChanged();
    }

    /*
    * this method is saving the name to ther server
    * */
    private void saveNameToServer(String _data) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Factura creada correctamente");
        progressDialog.show();

        final String name = _data;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_SAVE_NAME,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            if (!obj.getBoolean("error")) {
                                //if there is a success
                                //storing the name to sqlite with status synced
                                saveNameToLocalStorage(name, NAME_SYNCED_WITH_SERVER);
                            } else {
                                //if there is some error
                                //saving the name to sqlite with status unsynced
                                saveNameToLocalStorage(name, NAME_NOT_SYNCED_WITH_SERVER);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        //Toast.makeText(getApplicationContext(), ,Toast.LENGTH_SHORT);
                        error.printStackTrace();
                        //Log.e("okas:", Log.getStackTraceString(error) );

                        //on error storing the name to sqlite with status unsynced
                        saveNameToLocalStorage(name, NAME_NOT_SYNCED_WITH_SERVER);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }
    private void getClients(String _data) {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Obteniendo Clientes");
        progressDialog.show();

        final String name = _data;

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "http://tomzacr.com/t/addCliente.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        try {
                            JSONObject obj = new JSONObject(response);
                            if (!obj.getBoolean("error")) {
                                //if there is a success
                                //storing the name to sqlite with status synced
                                //saveNameToLocalStorage(name, NAME_SYNCED_WITH_SERVER);
                                //Toast.makeText(this,obj.getString(""),Toast.LENGTH_SHORT);
                            } else {
                                //if there is some error
                                //saving the name to sqlite with status unsynced
                                //saveNameToLocalStorage(name, NAME_NOT_SYNCED_WITH_SERVER);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        //Toast.makeText(getApplicationContext(), ,Toast.LENGTH_SHORT);
                        error.printStackTrace();
                        //Log.e("okas:", Log.getStackTraceString(error) );

                        //on error storing the name to sqlite with status unsynced
                        saveNameToLocalStorage(name, NAME_NOT_SYNCED_WITH_SERVER);
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", name);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    //saving the name to local storage
    private void saveNameToLocalStorage(String name, int status) {




        db.addName(name, status);
        //Name n = new Name(name, status);
        //names.add(n);
        loadNames();
        refreshList();
    }

    @Override
    public void onClick(View view) {



            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int choice) {
                    switch (choice) {
                        case DialogInterface.BUTTON_POSITIVE:

                                saveNameToServer("0,"+","+LAT+","+LONG+","+_supervisor);


                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            break;
                    }
                }
            };


            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder( this );
            builder.setMessage("Actualizar coordenadas para: ")
                    .setPositiveButton("Pura Vida", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();





        }




}