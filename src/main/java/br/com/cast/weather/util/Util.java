package br.com.cast.weather.util;

public class Util {

	public static String primeiraLetraMaiuscula(String palavra) {
		return palavra.substring(0, 1).toUpperCase() + palavra.substring(1);
	}
}
