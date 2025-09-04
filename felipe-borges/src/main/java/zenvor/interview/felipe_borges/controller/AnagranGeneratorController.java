package zenvor.interview.felipe_borges.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import zenvor.interview.felipe_borges.service.AnagramGeneratorService;

/**
 * Esta classe é responsável por receber e tratar as requisições relacionadas a
 * AnagranGenerator.
 *
 * @author Felipe Borges
 * @version 0.0.0
 * @date 04-09-2025
 * @lastUpdate
 */
@RestController
@RequestMapping(path = "/anagram_generator")
public class AnagranGeneratorController {

  @Autowired
  private AnagramGeneratorService anagramGeneratorService;

  @GetMapping(path = "/{input}")
  public Set<String> getAnagranGenerator(@PathVariable String input) {
    return anagramGeneratorService.generateAnagrams(input);
  }

}
