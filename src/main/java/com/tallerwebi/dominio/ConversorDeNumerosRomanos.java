package com.tallerwebi.dominio;

import com.tallerwebi.dominio.exceptions.CombinacionRomanaInvalidaException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class ConversorDeNumerosRomanos {

  private static final int MAXIMO_REPETICIONES = 3;

  private static final Map<Character, Integer> MAPA_ROMANOS = new HashMap<>();

  static {
    MAPA_ROMANOS.put('I', 1);
    MAPA_ROMANOS.put('V', 5);
    MAPA_ROMANOS.put('X', 10);
    MAPA_ROMANOS.put('L', 50);
    MAPA_ROMANOS.put('C', 100);
  }

  public Integer convertirRomano(String romano) throws CombinacionRomanaInvalidaException {
    if (romano == null || romano.isEmpty()) {
      throw new CombinacionRomanaInvalidaException("La combinacion de números romanos es inválida");
    }
    if (!caracteresValidos(romano)) {
      throw new CombinacionRomanaInvalidaException("La combinacion de números romanos es inválida");
    }
    if (tieneRepeticionesInvalidas(romano)) {
      throw new CombinacionRomanaInvalidaException("La combinacion de números romanos es inválida");
    }
    return calcularTotal(romano);
  }

  private int calcularTotal(String romano) {
    String invertido = new StringBuilder(romano).reverse().toString();
    int[] state = { 0, 0 }; // state[0] = total, state[1] = valorPrevio
    invertido
      .chars()
      .map(c -> MAPA_ROMANOS.get((char) c))
      .forEach(valorActual -> {
        if (valorActual < state[1]) {
          state[0] -= valorActual;
        } else {
          state[0] += valorActual;
        }
        state[1] = valorActual;
      });
    return state[0];
  }

  private boolean tieneRepeticionesInvalidas(String romano) {
    long maxRepeticiones = IntStream
      .range(0, romano.length())
      .filter(i ->
        i == 0 || MAPA_ROMANOS.get(romano.charAt(i)).equals(MAPA_ROMANOS.get(romano.charAt(i - 1)))
      )
      .count();
    return maxRepeticiones > MAXIMO_REPETICIONES;
  }

  private static boolean caracteresValidos(String romano) {
    return romano.chars().allMatch(c -> MAPA_ROMANOS.containsKey((char) c));
  }
}
