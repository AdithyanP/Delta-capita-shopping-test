package org.delta.capita.service;

import org.delta.capita.domain.BasketEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BasketCalculationTest {

    private final BasketCalculation basketCalculation = new BasketCalculation();

    @Test
    void calculate_total_cost_item() {

      var totalCost =   basketCalculation.calculate_total_cost_item(List.of(BasketEnum.Apple,BasketEnum.Apple,BasketEnum.Bananas,BasketEnum.Limes,BasketEnum.Limes));

        assertThat(totalCost).isEqualTo(BigDecimal.valueOf(120.00));
    }

    @Test
    @DisplayName("should give offer for 3 items of two price and actual price for individual item")
    void calculate_total_cost_item_When7LimeItems() {

        var totalCost =   basketCalculation.calculate_total_cost_item(List.of(BasketEnum.Apple,BasketEnum.Bananas,BasketEnum.Limes,BasketEnum.Limes,
                BasketEnum.Limes,BasketEnum.Limes,BasketEnum.Limes,BasketEnum.Limes,BasketEnum.Limes));

        assertThat(totalCost).isEqualTo(BigDecimal.valueOf(130.00));
    }
}