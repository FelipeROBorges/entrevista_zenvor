package zenvor.interview.felipe_borges.service;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

/**
 * Esta classe é responsável pelas regras de negócio de AnagranGenerator
 *
 * @author Felipe Borges
 * @version 0.0.0
 * @date 04-09-2025
 * @lastUpdate
 */
@Service
public class AnagramGeneratorService {

  /**
   * Gera todos os anagramas para uma string específica com letra diferentes
   *
   * @param input string contendo letras diferentes
   * @return lista de anagramas
   * @throws IllegalArgumentException se input é null, vazio, ou contem algo que
   *                                  não sejam letras
   */
  public Set<String> generateAnagrams(String input) {
    validateInput(input);
    Set<String> result = new LinkedHashSet<>();
    backtrack("", input, result);
    return result;
  }

  /**
   * Função recursiva que constroi os anagramas
   *
   * @param prefix    parcial do anagrama
   * @param remaining letras ainda não usadas
   * @param result    lista de anagramas validos
   */
  private void backtrack(String prefix, String remaining, Set<String> result) {
    if (remaining.isEmpty()) {
      result.add(prefix);
    } else {
      for (int i = 0; i < remaining.length(); i++) {
        // Escolha de uma letra para iterar recursivamente
        char chosen = remaining.charAt(i);
        String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
        backtrack(prefix + chosen, newRemaining, result);
      }
    }
  }

  /**
   * Valida se o input não é null ou vazio e se o mesmo só tem letras.
   *
   * @param input
   * @throws IllegalArgumentException se a validação falhar
   */
  private void validateInput(String input) {
    if (input == null || input.isEmpty()) {
      throw new IllegalArgumentException("O input não pode ser null ou vazio.");
    }
    if (!input.matches("[a-zA-Z]+")) {
      throw new IllegalArgumentException("O input precisa ter somente letras.");
    }
  }

}
