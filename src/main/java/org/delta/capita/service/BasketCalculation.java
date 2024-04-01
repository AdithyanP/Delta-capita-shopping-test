package org.delta.capita.service;

import org.delta.capita.domain.BasketEnum;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class BasketCalculation {

    public BigDecimal calculate_total_cost_item(List<BasketEnum> basketEnums){
        if(Objects.isNull(basketEnums)){
            return BigDecimal.ZERO;
        }

        var offerItemMap = new HashMap<BasketEnum,Integer>();

       var totalCostOfNoOfferItem =  basketEnums.stream().map(item -> {
            if(item.isOfferAvailable()){
                if(offerItemMap.get(item) != null){
                    offerItemMap.put(item,offerItemMap.get(item) + 1);
                }else {
                    offerItemMap.put(item,1);
                }
                return 0.0;
            }else {
                return item.getPaisa();
            }

        }).reduce(0.0, Double::sum);

      var totalCostOfOfferItem =   offerItemMap.entrySet().stream().map(offerItem -> {
            if(offerItem.getKey().getOffer().equals("BUY_ONE_GET_ONE")){
              var offer =   offerItem.getValue() % 2 == 0 ? offerItem.getValue() / 2 : ((offerItem.getValue() -1) / 2) + 1;
                return offerItem.getKey().getPaisa() * offer;
            }

            if(offerItem.getKey().getOffer().equals("THREE_FOR_PRICE_OF_TWO")) {
               var offer =  offerItem.getValue() < 3 ? offerItem.getValue() :
                       offerItem.getValue() % 3 == 0 ? (offerItem.getValue() / 3) * 2 : ((offerItem.getValue() / 3) * 2) + offerItem.getValue() % 3;
                return offerItem.getKey().getPaisa() * offer;
            }
            return 0.0;
        }).reduce(0.0, Double::sum);

        return BigDecimal.valueOf(totalCostOfNoOfferItem + totalCostOfOfferItem);
    }
}
