package org.thingsboard.server.common.data.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.eclipse.leshan.core.model.InvalidDDFFileException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbDDFFileParserDiffblueTest {
  /**
   * Test {@link TbDDFFileParser#parse(InputStream, String)}.
   *
   * <ul>
   *   <li>Then throw {@link InvalidDDFFileException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDDFFileParser#parse(InputStream, String)}
   */
  @Test
  @DisplayName("Test parse(InputStream, String); then throw InvalidDDFFileException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.List TbDDFFileParser.parse(InputStream, String)"})
  void testParse_thenThrowInvalidDDFFileException() throws IOException, InvalidDDFFileException {
    // Arrange
    TbDDFFileParser tbDDFFileParser = new TbDDFFileParser();

    // Act and Assert
    assertThrows(
        InvalidDDFFileException.class,
        () ->
            tbDDFFileParser.parse(
                new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Stream Name"));
  }
}
