package org.thingsboard.server.common.data.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.eclipse.leshan.core.model.InvalidDDFFileException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TbDDFFileParserDiffblueTest {
  /**
   * Test {@link TbDDFFileParser#parse(InputStream, String)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>When {@code null}.</li>
   *   <li>Then calls {@link FilterInputStream#close()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDDFFileParser#parse(InputStream, String)}
   */
  @Test
  @DisplayName("Test parse(InputStream, String); given one; when 'null'; then calls close()")
  void testParse_givenOne_whenNull_thenCallsClose() throws IOException, InvalidDDFFileException {
    // Arrange
    TbDDFFileParser tbDDFFileParser = new TbDDFFileParser();
    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read()).thenReturn(1);
    doNothing().when(inputStream).close();

    // Act and Assert
    assertThrows(InvalidDDFFileException.class, () -> tbDDFFileParser.parse(inputStream, null));
    verify(inputStream).close();
    verify(inputStream, atLeast(1)).read();
  }

  /**
   * Test {@link TbDDFFileParser#parse(InputStream, String)}.
   * <ul>
   *   <li>When {@link ByteArrayInputStream#ByteArrayInputStream(byte[])} with
   * {@code AXAXAXAX} Bytes is {@code UTF-8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbDDFFileParser#parse(InputStream, String)}
   */
  @Test
  @DisplayName("Test parse(InputStream, String); when ByteArrayInputStream(byte[]) with 'AXAXAXAX' Bytes is 'UTF-8'")
  void testParse_whenByteArrayInputStreamWithAxaxaxaxBytesIsUtf8() throws IOException, InvalidDDFFileException {
    // Arrange
    TbDDFFileParser tbDDFFileParser = new TbDDFFileParser();

    // Act and Assert
    assertThrows(InvalidDDFFileException.class,
        () -> tbDDFFileParser.parse(new ByteArrayInputStream("AXAXAXAX".getBytes("UTF-8")), "Stream Name"));
  }
}
