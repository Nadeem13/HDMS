package com.iustbatch2018rollnocse70.hdms.DeliveryFoodPanel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.iustbatch2018rollnocse70.hdms.Delivery_FoodPanelBottomNavigation;

import com.iustbatch2018rollnocse70.hdms.MapActivity;
import com.iustbatch2018rollnocse70.hdms.R;
import com.iustbatch2018rollnocse70.hdms.SendNotification.APIService;
import com.iustbatch2018rollnocse70.hdms.SendNotification.Client;
import com.iustbatch2018rollnocse70.hdms.SendNotification.Data;
import com.iustbatch2018rollnocse70.hdms.SendNotification.MyResponse;
import com.iustbatch2018rollnocse70.hdms.SendNotification.NotificationSender;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Delivery_ShippingOrder extends AppCompatActivity {


    TextView Address, ChefName, grandtotal, MobileNumber, Custname;
    Button Call, Shipped, btn_maps;
    private APIService apiService;
    LinearLayout l1, l2;
    String randomuid;
    String userid, Chefid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery__shipping_order);
        Address = (TextView) findViewById(R.id.ad3);
        ChefName = (TextView) findViewById(R.id.chefname2);
        grandtotal = (TextView) findViewById(R.id.Shiptotal1);
        MobileNumber = (TextView) findViewById(R.id.ShipNumber1);
        Custname = (TextView) findViewById(R.id.ShipName1);
        l1 = (LinearLayout) findViewById(R.id.linear3);
        l2 = (LinearLayout) findViewById(R.id.linearl1);
        Call = (Button) findViewById(R.id.call2);
        Shipped = (Button) findViewById(R.id.shipped2);
        btn_maps = findViewById(R.id.btn_maps);
        apiService = Client.getClient("https://fcm.googleapis.com/").create(APIService.class);
        Shipped();

    }

    private void Shipped() {

        randomuid = getIntent().getStringExtra("RandomUID");

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("DeliveryShipFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(randomuid).child("OtherInformation");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DeliveryShipFinalOrders1 deliveryShipFinalOrders1 = dataSnapshot.getValue(DeliveryShipFinalOrders1.class);
                grandtotal.setText("₹ " + deliveryShipFinalOrders1.getGrandTotalPrice());
                Address.setText(deliveryShipFinalOrders1.getAddress());
                final String addressGiven = deliveryShipFinalOrders1.getAddress();
                Custname.setText(deliveryShipFinalOrders1.getName());
                MobileNumber.setText("+91" + deliveryShipFinalOrders1.getMobileNumber());
                ChefName.setText("Shopkeeper " + deliveryShipFinalOrders1.getShopkeeperName());
                userid = deliveryShipFinalOrders1.getUserId();
                Chefid = deliveryShipFinalOrders1.getShopkeeperId();
                btn_maps.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Geocoder geocoder = new Geocoder(Delivery_ShippingOrder.this);
                        List<android.location.Address> addressList;

                        try {
                            addressList = geocoder.getFromLocationName(addressGiven, 1);
                            if (addressList != null){
                                double doubleLat = addressList.get(0).getLatitude();
                                double doubleLong = addressList.get(0).getLongitude();
                                Intent i = new Intent(Delivery_ShippingOrder.this, MapActivity.class);
                                i.putExtra("LONGITITUDES", doubleLong);
                                i.putExtra("LATITUDES",doubleLat);
                                startActivity(i);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
                Shipped.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(userid).child(randomuid).child("OtherInformation").child("Status").setValue("Your Order is delivered").addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                FirebaseDatabase.getInstance().getReference().child("Tokens").child(userid).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        String usertoken = dataSnapshot.getValue(String.class);
                                        sendNotifications(usertoken, "Home Chef", "Thank you for Ordering", "ThankYou");
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });
                            }
                        }).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                FirebaseDatabase.getInstance().getReference().child("Tokens").child(Chefid).child("token").addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                        String usertoken = dataSnapshot.getValue(String.class);
                                        sendNotifications(usertoken, "Order Placed", "Your food has been delivered to Customer's Doorstep", "Delivered");
                                    }

                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {

                                    }
                                });
                            }
                        }).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(Delivery_ShippingOrder.this);
                                builder.setMessage("Order is delivered, Now you can check for new Orders");
                                builder.setCancelable(false);
                                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {

                                        dialog.dismiss();
                                        Intent intent = new Intent(Delivery_ShippingOrder.this, Delivery_FoodPanelBottomNavigation.class);
                                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                        startActivity(intent);
                                        finish();


                                    }
                                });
                                AlertDialog alert = builder.create();
                                alert.show();
                            }
                        }).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(userid).child(randomuid).child("Items").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        FirebaseDatabase.getInstance().getReference("CustomerFinalOrders").child(userid).child(randomuid).child("OtherInformation").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                FirebaseDatabase.getInstance().getReference("DeliveryShipFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(randomuid).child("Items").removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                    @Override
                                                    public void onComplete(@NonNull Task<Void> task) {
                                                        FirebaseDatabase.getInstance().getReference("DeliveryShipFinalOrders").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(randomuid).child("OtherInformation").removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                                                            @Override
                                                            public void onSuccess(Void aVoid) {
                                                                FirebaseDatabase.getInstance().getReference("AlreadyOrdered").child(userid).child("isOrdered").setValue("false");
                                                            }
                                                        });
                                                    }
                                                });
                                            }
                                        });
                                    }
                                });
                            }
                        });
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void sendNotifications(String usertoken, String title, String message, String order) {

        Data data = new Data(title, message, order);
        NotificationSender sender = new NotificationSender(data, usertoken);
        apiService.sendNotification(sender).enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(retrofit2.Call<MyResponse> call, Response<MyResponse> response) {
                if (response.code() == 200) {
                    if (response.body().success != 1) {
                        Toast.makeText(Delivery_ShippingOrder.this, "Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {

            }
        });
    }
}
