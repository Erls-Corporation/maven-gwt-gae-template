package com.jverrecchia.template.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.jverrecchia.template.client.place.View1Place;
import com.jverrecchia.template.client.place.View2Place;
import com.jverrecchia.template.client.place.View3Place;


@WithTokenizers( { View1Place.Tokenizer.class, View2Place.Tokenizer.class ,View3Place.Tokenizer.class })
public interface AppPlaceHistoryMapper extends PlaceHistoryMapper{

}
