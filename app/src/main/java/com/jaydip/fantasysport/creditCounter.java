package com.jaydip.fantasysport;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class creditCounter extends ViewModel {
   MutableLiveData<Double> total ;

   creditCounter(){
       total = new MutableLiveData<Double>();
       total.setValue(0.0);
   }
    public LiveData<Double> getTotal() {
        return total;
    }

    public  Double getValue(){
       return  this.total.getValue();

    }

    public  void settotal(Double value){
        this.total.setValue(value);
    }
}
