package com.apic2w.service;

import org.json.JSONObject;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
  



public class ApiService extends Application {
    static String imgURL="";

    public static void imageData() throws Exception{
        StringBuffer response=new DataUrls().getResponsData();
        if(response!=null){
            JSONObject obj=new JSONObject(response.toString());
            JSONObject urlObject=obj.getJSONObject("urls");
            
            imgURL=urlObject.getString("small");
          
        }
        else{
            System.out.println("No Data");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        imageData();
        Image image=new Image(imgURL);
        ImageView imageView=new ImageView(image);
        Label l1=new Label("Random image ! ");
        l1.setStyle("-fx-font-size: 20px; -fx-text-fill: blue; -fx-background-color: lightgray;");
        

        VBox v1=new VBox(10,l1,imageView);
       
        v1.setAlignment(Pos.CENTER);
        Scene scene=new Scene(v1,1000,720);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Image API");
        primaryStage.show();
    }
    
}
