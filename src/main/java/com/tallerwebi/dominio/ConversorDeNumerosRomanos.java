package com.tallerwebi.dominio;

import com.tallerwebi.dominio.exceptions.CombinacionRomanaInvalidaException;
import java.util.HashMap;
import java.util.Map;

public class ConversorDeNumerosRomanos {

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

    int total = 0;
    int valorPrevio = 0;
    int cont = 1;
    int contMax = 1;

    for (int i = romano.length() - 1; i >= 0; i--) {
      int valorActual = MAPA_ROMANOS.get(romano.charAt(i));

      if (valorActual < valorPrevio) {
        total -= valorActual;
      } else {
        total += valorActual;
      }

      if (valorPrevio == valorActual) {
        cont++;
        if (cont > contMax) {
          contMax = cont;
        }
      } else {
        cont = 1;
      }
      valorPrevio = valorActual;
    }

    if (contMax > 3) {
      throw new CombinacionRomanaInvalidaException("La combinacion de números romanos es inválida");
    }
    return total;
  }

  private static boolean caracteresValidos(String romano) {
    return romano.chars().allMatch(c -> MAPA_ROMANOS.containsKey((char) c));
  }
}
