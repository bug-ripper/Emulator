package com.denisbondd111;

import java.util.HashMap;
import java.util.Map;

public class LampTemperatureSimulation {
    private static final double ALPHA = 0.0048; // Температурный коэффициент для вольфрама
    private static final double INITIAL_TEMP = 0.0; // Начальная температура в °C
    private static final double TOLERANCE = 0.001; // Порог для сходимости температуры

    private LampTemperatureSimulation(){}

//    public static Map<String, Double> calculateTemperatureAndResistance1(double voltage, double power, double initialResistance) {
//        double currentTemperature = INITIAL_TEMP;
//        double previousTemperature;
//        double resistance;
//        double current;
//
//        do {
//            previousTemperature = currentTemperature;
//            System.out.println("***********************************");
//            // Сопротивление при текущей температуре
//            resistance = initialResistance * (1 + ALPHA * (currentTemperature - INITIAL_TEMP));
//            System.out.println("resistance: " + resistance);
//            // Ток с использованием закона Ома
//            current = voltage / resistance;
//            System.out.println("current: " + current);
//            // Выделяющаяся мощность
//            double dissipatedPower = current * current * resistance;
//            System.out.println("dissipated power: " + dissipatedPower);
//
//            // Обновление температуры в зависимости от выделяемой мощности и номинальной мощности лампы
//            currentTemperature = previousTemperature + (dissipatedPower - power) / (initialResistance * ALPHA);
//            System.out.println("current temp: " + currentTemperature);
//            System.out.println("***********************************");
//        } while ((currentTemperature - previousTemperature) > TOLERANCE);
//        Map<String, Double> result = new HashMap<>();
//        result.put("temperature", currentTemperature);
//        result.put("current", current);
//        return result;
//    }
    public static Map<String, Double> calculateTemperatureAndResistance(double voltage, double power, double initialResistance){
        double currentResistance = 0;
        double current = 0;
        double temperature = 0;
        if(Math.round(power) == 25)
        {
             currentResistance = 8.095 * voltage + 155;
             current = voltage / currentResistance;
             temperature = (currentResistance / initialResistance - 1) / 0.0041;
        }
        else if(Math.round(power) == 40)
        {
             currentResistance = 5.032 * voltage + 103;
             current = voltage / currentResistance;
             temperature = (currentResistance / initialResistance - 1) / 0.0048;
        }
        else if(Math.round(power) == 60)
        {
             currentResistance = 3.427 * voltage + 61;
             current = voltage / currentResistance;
             temperature = (currentResistance / initialResistance - 1) / 0.0048;
        }
        else if(Math.round(power) == 75)
        {
             currentResistance = 2.723 * voltage + 51;
             current = voltage / currentResistance;
             temperature = (currentResistance / initialResistance - 1) / 0.0048;
        }
        else if(Math.round(power) == 100)
        {
             currentResistance = 2.045 * voltage + 40;
             current = voltage / currentResistance;
             temperature = (currentResistance / initialResistance - 1) / 0.0048;
        }else {throw new RuntimeException();}
        System.out.println("current resistance: " + currentResistance);
        System.out.println("current power: " + (current*voltage));
        Map<String, Double> result = new HashMap<>();
        result.put("temperature", temperature);
        result.put("current", current);
        return result;
    }
}
