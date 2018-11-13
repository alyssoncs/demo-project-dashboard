package com.example.demo;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.Connect;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.tapio.googlemaps.GoogleMap;
import com.vaadin.tapio.googlemaps.client.LatLon;
import com.vaadin.tapio.googlemaps.client.overlays.GoogleMapMarker;
import com.vaadin.ui.*;

@SpringUI(path = "/")
@Theme("valo")
@Widgetset("com.example.demo.IndexWidgetset")
public class IndexUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        GoogleMap googleMap = new GoogleMap("AIzaSyD672coS04l9IPr2LhNvhC4MrBgq4X4U1w", null, null);
        //GoogleMap googleMap = new GoogleMap("AIzaSyAtJ7j6CG0aWsUjQYslIiZtM9lKnsU0MDQ", null, null);
        //GoogleMap googleMap = new GoogleMap("AIzaSyB299emCUuKMkZHXIHQc5u1Po7ZnrEA3S0", null, null);
        //GoogleMap googleMap = new GoogleMap("AIzaSyBBIjF5E7BMJSIx1NHErBFzzZ-LtK2g9nI", null, null);

        googleMap.setSizeFull();
        GoogleMapMarker marker = new GoogleMapMarker("DRAGGABLE: Paavo Nurmi Stadion", new LatLon(-2.500051, -44.287207), true);
        googleMap.addMarker(marker);
        googleMap.setMinZoom(4);
        googleMap.setMaxZoom(16);

        googleMap.setSizeFull();

        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setSizeFull();
        verticalLayout.addComponent(googleMap);

        FormLayout form = new FormLayout();
        TextField nome = new TextField("Nome");
        form.addComponent(nome);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSizeFull();
        horizontalLayout.addComponents(verticalLayout, form);

        setContent(horizontalLayout);

    }

}
