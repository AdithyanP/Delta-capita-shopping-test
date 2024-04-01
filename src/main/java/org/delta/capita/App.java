package org.delta.capita;

import org.delta.capita.domain.BasketEnum;
import org.delta.capita.service.BasketCalculation;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Basket calculation application has started!!!" );
        BasketCalculation basketCalculation = new BasketCalculation();
        var listOfItems = List.of(BasketEnum.Apple,BasketEnum.Bananas,BasketEnum.Limes,BasketEnum.Limes,
                BasketEnum.Limes,BasketEnum.Limes,BasketEnum.Limes,BasketEnum.Limes,BasketEnum.Limes);
       var totalCostOfItems =  basketCalculation.calculate_total_cost_item(listOfItems);
       System.out.println("totalCostOfItems: "+totalCostOfItems);
    }
}
