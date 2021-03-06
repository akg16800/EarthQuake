 package com.example.earthquake;

 import android.app.Activity;
 import android.graphics.drawable.GradientDrawable;
 import android.view.LayoutInflater;
 import android.view.View;
 import android.view.ViewGroup;
 import android.widget.ArrayAdapter;
 import android.widget.TextView;

 import androidx.annotation.NonNull;
 import androidx.annotation.Nullable;
 import androidx.core.content.ContextCompat;

 import java.text.DecimalFormat;
 import java.text.SimpleDateFormat;
 import java.util.ArrayList;
 import java.util.Date;

 public class EarthQuakeAdapter extends ArrayAdapter<Earthquake> {
     private static final String LOCATION_SEPERATOR = " of ";

     public EarthQuakeAdapter(Activity context, ArrayList<Earthquake> earthquakes){
         super(context,0,earthquakes);
     }

     @NonNull
     @Override
     public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         View listItemView=convertView;
         if(listItemView==null)
         {
             listItemView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
         }
         Earthquake currentEarthQuake=getItem(position);
         TextView magnitudeView=listItemView.findViewById(R.id.magnitude);
         String formattedMagnitude=formatMagnitude(currentEarthQuake.getMagnitude());
         magnitudeView.setText(formattedMagnitude);

         GradientDrawable magnitudeCircle=(GradientDrawable) magnitudeView.getBackground();
         int magnitudeColor=getMagnitudeColor(currentEarthQuake.getMagnitude());
         magnitudeCircle.setColor(magnitudeColor);


         String originalLocation=currentEarthQuake.getmLocation();
         String primaryLocation;
         String locationOffset;
         if(originalLocation.contains(LOCATION_SEPERATOR))
         {
             String [] parts=originalLocation.split(LOCATION_SEPERATOR);
             locationOffset=parts[0]+LOCATION_SEPERATOR;
             primaryLocation=parts[1];
         }
         else
             {
             locationOffset=getContext().getString(R.string.near_the);
             primaryLocation=originalLocation;
         }
         TextView primaryLocationView=listItemView.findViewById(R.id.primary);
         primaryLocationView.setText(primaryLocation);
         TextView locationOffsetView=listItemView.findViewById(R.id.offset);
         locationOffsetView.setText(locationOffset);

         Date dateObject=new Date(currentEarthQuake.getmTimeInMilliseconds());
         TextView dateView=listItemView.findViewById(R.id.date);
         String formattedDate= formatDate(dateObject);
         dateView.setText(formattedDate);
         TextView timeView=listItemView.findViewById(R.id.time);
         String formattedTime=formatTime(dateObject);
         timeView.setText(formattedTime);
         return listItemView;
     }

     private int getMagnitudeColor(double magnitude) {
         int magnitudeColorResourceId;
         int magnitudeFloor=(int) Math.floor(magnitude);
         switch (magnitudeFloor)
         {
             case 0:
             case 1:
                 magnitudeColorResourceId= R.color.magnitude1;
                 break;
             case 2:
                 magnitudeColorResourceId= R.color.magnitude2;
                 break;
             case 3:
                 magnitudeColorResourceId = R.color.magnitude3;
                 break;
             case 4:
                 magnitudeColorResourceId = R.color.magnitude4;
                 break;
             case 5:
                 magnitudeColorResourceId = R.color.magnitude5;
                 break;
             case 6:
                 magnitudeColorResourceId = R.color.magnitude6;
                 break;
             case 7:
                 magnitudeColorResourceId = R.color.magnitude7;
                 break;
             case 8:
                 magnitudeColorResourceId = R.color.magnitude8;
                 break;
             case 9:
                 magnitudeColorResourceId = R.color.magnitude9;
                 break;
             default:
                 magnitudeColorResourceId = R.color.magnitude10plus;
                 break;
         }
         return ContextCompat.getColor(getContext(),magnitudeColorResourceId);
     }

     private String formatMagnitude(double magnitude) {
         DecimalFormat magnitudeFormat=new DecimalFormat("0.0");
         return magnitudeFormat.format(magnitude);
     }

     private String formatTime(Date dateObject) {
         SimpleDateFormat timeFormat=new SimpleDateFormat("h:mm a");
         return timeFormat.format(dateObject);
     }

     private String formatDate(Date dateObject) {
         SimpleDateFormat dateFormat=new SimpleDateFormat("LLL dd,yyyy");
         return dateFormat.format(dateObject);
     }
 }
