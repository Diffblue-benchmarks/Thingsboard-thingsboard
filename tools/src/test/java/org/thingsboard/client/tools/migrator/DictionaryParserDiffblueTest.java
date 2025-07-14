package org.thingsboard.client.tools.migrator;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import org.apache.groovy.nio.runtime.WritablePath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DictionaryParserDiffblueTest {
  /**
   * Test {@link DictionaryParser#DictionaryParser(File)}.
   *
   * <ul>
   *   <li>Given Property is {@code java.io.tmpdir}.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryParser#DictionaryParser(File)}
   */
  @Test
  @DisplayName("Test new DictionaryParser(File); given Property is 'java.io.tmpdir'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DictionaryParser.<init>(File)"})
  void testNewDictionaryParser_givenPropertyIsJavaIoTmpdir() throws IOException {
    // Arrange
    System.getProperty("java.io.tmpdir");

    // Act and Assert
    assertNull(
        new DictionaryParser(
                new WritablePath(
                        Paths.get(System.getProperty("java.io.tmpdir"), "test.txt"), "UTF-8")
                    .toFile())
            .getKeyByKeyId("42"));
  }

  /**
   * Test {@link DictionaryParser#DictionaryParser(File)}.
   *
   * <ul>
   *   <li>When Property is {@code java.io.tmpdir} is {@code test.txt} toFile.
   * </ul>
   *
   * <p>Method under test: {@link DictionaryParser#DictionaryParser(File)}
   */
  @Test
  @DisplayName(
      "Test new DictionaryParser(File); when Property is 'java.io.tmpdir' is 'test.txt' toFile")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DictionaryParser.<init>(File)"})
  void testNewDictionaryParser_whenPropertyIsJavaIoTmpdirIsTestTxtToFile() throws IOException {
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
