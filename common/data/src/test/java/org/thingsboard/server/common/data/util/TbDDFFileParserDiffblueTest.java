package org.thingsboard.server.common.data.util;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
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
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDDFFileParser#parse(InputStream, String)}
   */
  @Test
  @DisplayName(
      "Test parse(InputStream, String); given IllegalStateException(); then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List TbDDFFileParser.parse(InputStream, String)"})
  void testParse_givenIllegalStateException_thenThrowIllegalStateException()
      throws IOException, InvalidDDFFileException {
    // Arrange
    TbDDFFileParser tbDDFFileParser = new TbDDFFileParser();

    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(
        IllegalStateException.class, () -> tbDDFFileParser.parse(inputStream, "Stream Name"));
    verify(inputStream).read();
  }

  /**
   * Test {@link TbDDFFileParser#parse(InputStream, String)}.
   *
   * <ul>
   *   <li>Given {@link IllegalStateException#IllegalStateException()}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link TbDDFFileParser#parse(InputStream, String)}
   */
  @Test
  @DisplayName(
      "Test parse(InputStream, String); given IllegalStateException(); when 'null'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List TbDDFFileParser.parse(InputStream, String)"})
  void testParse_givenIllegalStateException_whenNull_thenThrowIllegalStateException()
      throws IOException, InvalidDDFFileException {
    // Arrange
    TbDDFFileParser tbDDFFileParser = new TbDDFFileParser();

    DataInputStream inputStream = mock(DataInputStream.class);
    when(inputStream.read()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> tbDDFFileParser.parse(inputStream, null));
    verify(inputStream).read();
  }

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
