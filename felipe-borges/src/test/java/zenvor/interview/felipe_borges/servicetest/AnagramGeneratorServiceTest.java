package zenvor.interview.felipe_borges.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import zenvor.interview.felipe_borges.service.AnagramGeneratorService;

@SpringBootTest
public class AnagramGeneratorServiceTest {

  @Autowired
  private AnagramGeneratorService anagramGeneratorService;

  @Test
  void testThreeLetters() {
    Set<String> result = this.anagramGeneratorService.generateAnagrams("abc");
    assertEquals(6, result.size());
  }

  @Test
  void testSingleLetter() {
    Set<String> result = this.anagramGeneratorService.generateAnagrams("x");
    assertEquals(1, result.size());
  }

  @Test
  void testFourLettersTwoDuplicates() {
    Set<String> result = this.anagramGeneratorService.generateAnagrams("abca");
    assertEquals(12, result.size());
  }

}
