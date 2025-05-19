package com.example;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class SensorDataExample {

    public static void main(String[] args) {
        List<Double> temperatures = Arrays.asList(22.5, 27.0, 30.5, 22.5, 29.0, 26.5, 31.0, 30.5);

        Observable.fromIterable(temperatures)
                .filter(temp -> temp > 25.0) // Temperaturas mayores a 25°C
                .map(temp -> (temp * 9 / 5) + 32) // Convertir a Fahrenheit
                .distinct() // Eliminar duplicados
                .take(5) // Tomar solo las primeras 5
                .reduce((a, b) -> (a + b) / 2) // Promedio simple acumulado
                .subscribe(
                        avg -> System.out.println("Temperatura promedio (°F): " + avg),
                        error -> System.err.println("Error: " + error)
                );
    }
}
