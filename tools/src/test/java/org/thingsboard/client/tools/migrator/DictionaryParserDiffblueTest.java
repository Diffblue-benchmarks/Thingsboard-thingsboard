package org.thingsboard.client.tools.migrator;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DictionaryParserDiffblueTest {
  /**
   * Test {@link DictionaryParser#DictionaryParser(File)}.
   *
   * <ul>
   *   <li>Then return KeyByKeyId is {@code 42} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryParser#DictionaryParser(File)}
   */
  @Test
  @DisplayName("Test new DictionaryParser(File); then return KeyByKeyId is '42' is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DictionaryParser.<init>(File)"})
  void testNewDictionaryParser_thenReturnKeyByKeyIdIs42IsNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        new DictionaryParser(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())
            .getKeyByKeyId("42"));
  }

  /**
   * Test {@link DictionaryParser#getKeyByKeyId(String)}.
   *
   * <p>Method under test: {@link DictionaryParser#getKeyByKeyId(String)}
   */
  @Test
  @DisplayName("Test getKeyByKeyId(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String DictionaryParser.getKeyByKeyId(String)"})
  void testGetKeyByKeyId() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        new DictionaryParser(Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile())
            .getKeyByKeyId("42"));
  }
}
