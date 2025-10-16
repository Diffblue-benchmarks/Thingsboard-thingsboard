/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.util.ImageUtils.ProcessedImage;
import org.thingsboard.server.dao.util.ImageUtils.ScadaSymbolMetadataInfo;

public class ImageUtilsDiffblueTest {
  /**
   * Test {@link ImageUtils#mediaTypeToFileExtension(String)}.
   *
   * <ul>
   *   <li>When {@code text/plain}.
   *   <li>Then return {@code plain}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#mediaTypeToFileExtension(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.mediaTypeToFileExtension(String)"})
  public void testMediaTypeToFileExtension_whenTextPlain_thenReturnPlain() {
    // Arrange, Act and Assert
    assertEquals("plain", ImageUtils.mediaTypeToFileExtension("text/plain"));
  }

  /**
   * Test {@link ImageUtils#fileExtensionToMediaType(String)}.
   *
   * <ul>
   *   <li>When {@code Extension}.
   *   <li>Then return {@code image/extension}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#fileExtensionToMediaType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.fileExtensionToMediaType(String)"})
  public void testFileExtensionToMediaType_whenExtension_thenReturnImageExtension() {
    // Arrange, Act and Assert
    assertEquals("image/extension", ImageUtils.fileExtensionToMediaType("Extension"));
  }

  /**
   * Test {@link ImageUtils#fileExtensionToMediaType(String)}.
   *
   * <ul>
   *   <li>When {@code jpg}.
   *   <li>Then return {@code image/jpeg}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#fileExtensionToMediaType(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.fileExtensionToMediaType(String)"})
  public void testFileExtensionToMediaType_whenJpg_thenReturnImageJpeg() {
    // Arrange, Act and Assert
    assertEquals("image/jpeg", ImageUtils.fileExtensionToMediaType("jpg"));
  }

  /**
   * Test {@link ImageUtils#processImage(byte[], String, int)}.
   *
   * <ul>
   *   <li>Then return Preview MediaType is {@code text/plain}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#processImage(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessedImage ImageUtils.processImage(byte[], String, int)"})
  public void testProcessImage_thenReturnPreviewMediaTypeIsTextPlain() throws Exception {
    // Arrange and Act
    ProcessedImage actualProcessImageResult =
        ImageUtils.processImage(new byte[] {-1, -1, 'A', 'X', 'A', 'X', 'A', 'X'}, "text/plain", 1);

    // Assert
    ProcessedImage preview = actualProcessImageResult.getPreview();
    assertEquals("text/plain", preview.getMediaType());
    assertEquals("text/plain", actualProcessImageResult.getMediaType());
    assertNull(preview.getData());
    assertNull(preview.getPreview());
    assertEquals(0, preview.getHeight());
    assertEquals(0, actualProcessImageResult.getHeight());
    assertEquals(0, preview.getWidth());
    assertEquals(0, actualProcessImageResult.getWidth());
    assertEquals(8L, preview.getSize());
    assertEquals(8L, actualProcessImageResult.getSize());
    assertArrayEquals(
        new byte[] {-1, -1, 'A', 'X', 'A', 'X', 'A', 'X'}, actualProcessImageResult.getData());
  }

  /**
   * Test {@link ImageUtils#processImage(byte[], String, int)}.
   *
   * <ul>
   *   <li>Then return Preview MediaType is {@code text/plain}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#processImage(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessedImage ImageUtils.processImage(byte[], String, int)"})
  public void testProcessImage_thenReturnPreviewMediaTypeIsTextPlain2() throws Exception {
    // Arrange and Act
    ProcessedImage actualProcessImageResult =
        ImageUtils.processImage(new byte[] {-1, -1, -1, 'X', 'A', 'X', 'A', 'X'}, "text/plain", 1);

    // Assert
    ProcessedImage preview = actualProcessImageResult.getPreview();
    assertEquals("text/plain", preview.getMediaType());
    assertEquals("text/plain", actualProcessImageResult.getMediaType());
    assertNull(preview.getData());
    assertNull(preview.getPreview());
    assertEquals(0, preview.getHeight());
    assertEquals(0, actualProcessImageResult.getHeight());
    assertEquals(0, preview.getWidth());
    assertEquals(0, actualProcessImageResult.getWidth());
    assertEquals(8L, preview.getSize());
    assertEquals(8L, actualProcessImageResult.getSize());
    assertArrayEquals(
        new byte[] {-1, -1, -1, 'X', 'A', 'X', 'A', 'X'}, actualProcessImageResult.getData());
  }

  /**
   * Test {@link ImageUtils#processSvgImage(byte[], String, int)}.
   *
   * <ul>
   *   <li>Then return Preview Data is {@code AXAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#processSvgImage(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessedImage ImageUtils.processSvgImage(byte[], String, int)"})
  public void testProcessSvgImage_thenReturnPreviewDataIsAxaxaxaxBytesIsUtf8() throws Exception {
    // Arrange and Act
    ProcessedImage actualProcessSvgImageResult =
        ImageUtils.processSvgImage("AXAXAXAX".getBytes("UTF-8"), "text/plain", 1);

    // Assert
    ProcessedImage preview = actualProcessSvgImageResult.getPreview();
    assertEquals("text/plain", preview.getMediaType());
    assertEquals("text/plain", actualProcessSvgImageResult.getMediaType());
    assertNull(preview.getPreview());
    assertEquals(0, preview.getHeight());
    assertEquals(0, actualProcessSvgImageResult.getHeight());
    assertEquals(0, preview.getWidth());
    assertEquals(0, actualProcessSvgImageResult.getWidth());
    assertEquals(8L, preview.getSize());
    assertEquals(8L, actualProcessSvgImageResult.getSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), preview.getData());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualProcessSvgImageResult.getData());
  }

  /**
   * Test {@link ImageUtils#processSvgImage(byte[], String, int)}.
   *
   * <ul>
   *   <li>Then return Preview Data is {@code XAXAXAX} Bytes is {@code UTF-8}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#processSvgImage(byte[], String, int)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessedImage ImageUtils.processSvgImage(byte[], String, int)"})
  public void testProcessSvgImage_thenReturnPreviewDataIsXaxaxaxBytesIsUtf8() throws Exception {
    // Arrange and Act
    ProcessedImage actualProcessSvgImageResult =
        ImageUtils.processSvgImage("\bXAXAXAX".getBytes("UTF-8"), "text/plain", 1);

    // Assert
    ProcessedImage preview = actualProcessSvgImageResult.getPreview();
    assertEquals("text/plain", preview.getMediaType());
    assertEquals("text/plain", actualProcessSvgImageResult.getMediaType());
    assertNull(preview.getPreview());
    assertEquals(0, preview.getHeight());
    assertEquals(0, actualProcessSvgImageResult.getHeight());
    assertEquals(0, preview.getWidth());
    assertEquals(0, actualProcessSvgImageResult.getWidth());
    assertEquals(8L, preview.getSize());
    assertEquals(8L, actualProcessSvgImageResult.getSize());
    assertArrayEquals("\bXAXAXAX".getBytes("UTF-8"), preview.getData());
    assertArrayEquals("\bXAXAXAX".getBytes("UTF-8"), actualProcessSvgImageResult.getData());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}, and {@link
   * ProcessedImage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProcessedImage#equals(Object)}
   *   <li>{@link ProcessedImage#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessedImage.equals(Object)", "int ProcessedImage.hashCode()"})
  public void testProcessedImageEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProcessedImage processedImage = new ProcessedImage();
    ProcessedImage processedImage2 = new ProcessedImage();

    // Act and Assert
    assertEquals(processedImage, processedImage2);
    assertEquals(processedImage.hashCode(), processedImage2.hashCode());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}, and {@link
   * ProcessedImage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProcessedImage#equals(Object)}
   *   <li>{@link ProcessedImage#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessedImage.equals(Object)", "int ProcessedImage.hashCode()"})
  public void testProcessedImageEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2()
      throws Exception {
    // Arrange
    ProcessedImage processSvgImageResult =
        ImageUtils.processSvgImage(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, "text/plain", 1);
    ProcessedImage processSvgImageResult2 =
        ImageUtils.processSvgImage(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, "text/plain", 1);

    // Act and Assert
    assertEquals(processSvgImageResult, processSvgImageResult2);
    assertEquals(processSvgImageResult.hashCode(), processSvgImageResult2.hashCode());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}, and {@link
   * ProcessedImage#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProcessedImage#equals(Object)}
   *   <li>{@link ProcessedImage#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessedImage.equals(Object)", "int ProcessedImage.hashCode()"})
  public void testProcessedImageEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProcessedImage processedImage = new ProcessedImage();

    // Act and Assert
    assertEquals(processedImage, processedImage);
    int expectedHashCodeResult = processedImage.hashCode();
    assertEquals(expectedHashCodeResult, processedImage.hashCode());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProcessedImage#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessedImage.equals(Object)", "int ProcessedImage.hashCode()"})
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual() throws Exception {
    // Arrange
    ProcessedImage processSvgImageResult =
        ImageUtils.processSvgImage(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1}, "text/plain", 1);

    // Act and Assert
    assertNotEquals(processSvgImageResult, new ProcessedImage());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProcessedImage#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessedImage.equals(Object)", "int ProcessedImage.hashCode()"})
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ProcessedImage processedImage = new ProcessedImage();
    processedImage.setMediaType("text/plain");

    // Act and Assert
    assertNotEquals(processedImage, new ProcessedImage());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProcessedImage#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessedImage.equals(Object)", "int ProcessedImage.hashCode()"})
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProcessedImage processedImage = new ProcessedImage();
    processedImage.setWidth(1);

    // Act and Assert
    assertNotEquals(processedImage, new ProcessedImage());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProcessedImage#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessedImage.equals(Object)", "int ProcessedImage.hashCode()"})
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProcessedImage processedImage = new ProcessedImage();
    processedImage.setHeight(1);

    // Act and Assert
    assertNotEquals(processedImage, new ProcessedImage());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProcessedImage#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessedImage.equals(Object)", "int ProcessedImage.hashCode()"})
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ProcessedImage processedImage = new ProcessedImage();
    processedImage.setData(new byte[] {'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(processedImage, new ProcessedImage());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProcessedImage#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessedImage.equals(Object)", "int ProcessedImage.hashCode()"})
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ProcessedImage processedImage = new ProcessedImage();
    processedImage.setPreview(new ProcessedImage());

    // Act and Assert
    assertNotEquals(processedImage, new ProcessedImage());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProcessedImage#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessedImage.equals(Object)", "int ProcessedImage.hashCode()"})
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ProcessedImage processedImage = new ProcessedImage();

    ProcessedImage processedImage2 = new ProcessedImage();
    processedImage2.setMediaType("text/plain");

    // Act and Assert
    assertNotEquals(processedImage, processedImage2);
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProcessedImage#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessedImage.equals(Object)", "int ProcessedImage.hashCode()"})
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ProcessedImage processedImage = new ProcessedImage();

    ProcessedImage processedImage2 = new ProcessedImage();
    processedImage2.setPreview(new ProcessedImage());

    // Act and Assert
    assertNotEquals(processedImage, processedImage2);
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProcessedImage#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessedImage.equals(Object)", "int ProcessedImage.hashCode()"})
  public void testProcessedImageEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProcessedImage(), null);
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProcessedImage#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ProcessedImage.equals(Object)", "int ProcessedImage.hashCode()"})
  public void testProcessedImageEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ProcessedImage(), "Different type to ProcessedImage");
  }

  /**
   * Test ProcessedImage getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProcessedImage#ProcessedImage()}
   *   <li>{@link ProcessedImage#setData(byte[])}
   *   <li>{@link ProcessedImage#setHeight(int)}
   *   <li>{@link ProcessedImage#setMediaType(String)}
   *   <li>{@link ProcessedImage#setPreview(ProcessedImage)}
   *   <li>{@link ProcessedImage#setSize(long)}
   *   <li>{@link ProcessedImage#setWidth(int)}
   *   <li>{@link ProcessedImage#toString()}
   *   <li>{@link ProcessedImage#getData()}
   *   <li>{@link ProcessedImage#getHeight()}
   *   <li>{@link ProcessedImage#getMediaType()}
   *   <li>{@link ProcessedImage#getPreview()}
   *   <li>{@link ProcessedImage#getSize()}
   *   <li>{@link ProcessedImage#getWidth()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProcessedImage.<init>()",
    "byte[] ProcessedImage.getData()",
    "int ProcessedImage.getHeight()",
    "String ProcessedImage.getMediaType()",
    "ProcessedImage ProcessedImage.getPreview()",
    "long ProcessedImage.getSize()",
    "int ProcessedImage.getWidth()",
    "void ProcessedImage.setData(byte[])",
    "void ProcessedImage.setHeight(int)",
    "void ProcessedImage.setMediaType(String)",
    "void ProcessedImage.setPreview(ProcessedImage)",
    "void ProcessedImage.setSize(long)",
    "void ProcessedImage.setWidth(int)",
    "String ProcessedImage.toString()"
  })
  public void testProcessedImageGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    ProcessedImage actualProcessedImage = new ProcessedImage();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualProcessedImage.setData(data);
    actualProcessedImage.setHeight(1);
    actualProcessedImage.setMediaType("text/plain");
    ProcessedImage preview = new ProcessedImage();
    actualProcessedImage.setPreview(preview);
    actualProcessedImage.setSize(3L);
    actualProcessedImage.setWidth(1);
    String actualToStringResult = actualProcessedImage.toString();
    byte[] actualData = actualProcessedImage.getData();
    int actualHeight = actualProcessedImage.getHeight();
    String actualMediaType = actualProcessedImage.getMediaType();
    ProcessedImage actualPreview = actualProcessedImage.getPreview();
    long actualSize = actualProcessedImage.getSize();

    // Assert
    assertEquals(
        "ImageUtils.ProcessedImage(mediaType=text/plain, width=1, height=1, data=[65, 88, 65, 88, 65, 88, 65,"
            + " 88], size=3, preview=ImageUtils.ProcessedImage(mediaType=null, width=0, height=0, data=null, size=0,"
            + " preview=null))",
        actualToStringResult);
    assertEquals("text/plain", actualMediaType);
    assertEquals(1, actualHeight);
    assertEquals(1, actualProcessedImage.getWidth());
    assertEquals(3L, actualSize);
    assertSame(preview, actualPreview);
    assertSame(data, actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#ProcessedImage(String, int, int, byte[], long,
   * ProcessedImage)}.
   *
   * <p>Method under test: {@link ProcessedImage#ProcessedImage(String, int, int, byte[], long,
   * ProcessedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ProcessedImage.<init>(String, int, int, byte[], long, ProcessedImage)"})
  public void testProcessedImageNewProcessedImage() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ProcessedImage preview = new ProcessedImage();

    // Act
    ProcessedImage actualProcessedImage = new ProcessedImage("text/plain", 1, 1, data, 3L, preview);

    // Assert
    assertEquals("text/plain", actualProcessedImage.getMediaType());
    assertEquals(1, actualProcessedImage.getHeight());
    assertEquals(1, actualProcessedImage.getWidth());
    assertEquals(3L, actualProcessedImage.getSize());
    assertSame(preview, actualProcessedImage.getPreview());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualProcessedImage.getData());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#withData(byte[])}.
   *
   * <p>Method under test: {@link ProcessedImage#withData(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessedImage ProcessedImage.withData(byte[])"})
  public void testProcessedImageWithData() throws UnsupportedEncodingException {
    // Arrange and Act
    ProcessedImage actualWithDataResult =
        new ProcessedImage().withData("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualWithDataResult.getMediaType());
    assertNull(actualWithDataResult.getPreview());
    assertEquals(0, actualWithDataResult.getHeight());
    assertEquals(0, actualWithDataResult.getWidth());
    assertEquals(0L, actualWithDataResult.getSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualWithDataResult.getData());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}, and {@link
   * ScadaSymbolMetadataInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ScadaSymbolMetadataInfo#equals(Object)}
   *   <li>{@link ScadaSymbolMetadataInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScadaSymbolMetadataInfo.equals(Object)",
    "int ScadaSymbolMetadataInfo.hashCode()"
  })
  public void testScadaSymbolMetadataInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual()
      throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult2 =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(processScadaSymbolMetadataResult, processScadaSymbolMetadataResult2);
    assertEquals(
        processScadaSymbolMetadataResult.hashCode(), processScadaSymbolMetadataResult2.hashCode());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}, and {@link
   * ScadaSymbolMetadataInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ScadaSymbolMetadataInfo#equals(Object)}
   *   <li>{@link ScadaSymbolMetadataInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScadaSymbolMetadataInfo.equals(Object)",
    "int ScadaSymbolMetadataInfo.hashCode()"
  })
  public void testScadaSymbolMetadataInfoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual()
      throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(processScadaSymbolMetadataResult, processScadaSymbolMetadataResult);
    int expectedHashCodeResult = processScadaSymbolMetadataResult.hashCode();
    assertEquals(expectedHashCodeResult, processScadaSymbolMetadataResult.hashCode());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScadaSymbolMetadataInfo.equals(Object)",
    "int ScadaSymbolMetadataInfo.hashCode()"
  })
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual()
      throws Exception {
    // Arrange, Act and Assert
    assertNotEquals(
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8")), 1);
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScadaSymbolMetadataInfo.equals(Object)",
    "int ScadaSymbolMetadataInfo.hashCode()"
  })
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual2()
      throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));
    processScadaSymbolMetadataResult.setTitle("Dr");
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult2 =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(processScadaSymbolMetadataResult, processScadaSymbolMetadataResult2);
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScadaSymbolMetadataInfo.equals(Object)",
    "int ScadaSymbolMetadataInfo.hashCode()"
  })
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual3()
      throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));
    processScadaSymbolMetadataResult.setDescription("The characteristics of someone or something");
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult2 =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(processScadaSymbolMetadataResult, processScadaSymbolMetadataResult2);
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScadaSymbolMetadataInfo.equals(Object)",
    "int ScadaSymbolMetadataInfo.hashCode()"
  })
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual4()
      throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));
    processScadaSymbolMetadataResult.setSearchTags(new String[] {"foo.txt"});
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult2 =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(processScadaSymbolMetadataResult, processScadaSymbolMetadataResult2);
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScadaSymbolMetadataInfo.equals(Object)",
    "int ScadaSymbolMetadataInfo.hashCode()"
  })
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual5()
      throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));
    processScadaSymbolMetadataResult.setWidgetSizeX(1);
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult2 =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(processScadaSymbolMetadataResult, processScadaSymbolMetadataResult2);
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScadaSymbolMetadataInfo.equals(Object)",
    "int ScadaSymbolMetadataInfo.hashCode()"
  })
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual6()
      throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));
    processScadaSymbolMetadataResult.setWidgetSizeY(1);
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult2 =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(processScadaSymbolMetadataResult, processScadaSymbolMetadataResult2);
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScadaSymbolMetadataInfo.equals(Object)",
    "int ScadaSymbolMetadataInfo.hashCode()"
  })
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual7()
      throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));
    processScadaSymbolMetadataResult.setTitle(null);
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult2 =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(processScadaSymbolMetadataResult, processScadaSymbolMetadataResult2);
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScadaSymbolMetadataInfo.equals(Object)",
    "int ScadaSymbolMetadataInfo.hashCode()"
  })
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual8()
      throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));
    processScadaSymbolMetadataResult.setDescription(null);
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult2 =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(processScadaSymbolMetadataResult, processScadaSymbolMetadataResult2);
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScadaSymbolMetadataInfo.equals(Object)",
    "int ScadaSymbolMetadataInfo.hashCode()"
  })
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsNull_thenReturnNotEqual()
      throws Exception {
    // Arrange, Act and Assert
    assertNotEquals(
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ScadaSymbolMetadataInfo.equals(Object)",
    "int ScadaSymbolMetadataInfo.hashCode()"
  })
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsWrongType_thenReturnNotEqual()
      throws Exception {
    // Arrange, Act and Assert
    assertNotEquals(
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8")),
        "Different type to ScadaSymbolMetadataInfo");
  }

  /**
   * Test ScadaSymbolMetadataInfo getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ScadaSymbolMetadataInfo#setDescription(String)}
   *   <li>{@link ScadaSymbolMetadataInfo#setSearchTags(String[])}
   *   <li>{@link ScadaSymbolMetadataInfo#setTitle(String)}
   *   <li>{@link ScadaSymbolMetadataInfo#setWidgetSizeX(int)}
   *   <li>{@link ScadaSymbolMetadataInfo#setWidgetSizeY(int)}
   *   <li>{@link ScadaSymbolMetadataInfo#toString()}
   *   <li>{@link ScadaSymbolMetadataInfo#getDescription()}
   *   <li>{@link ScadaSymbolMetadataInfo#getSearchTags()}
   *   <li>{@link ScadaSymbolMetadataInfo#getTitle()}
   *   <li>{@link ScadaSymbolMetadataInfo#getWidgetSizeX()}
   *   <li>{@link ScadaSymbolMetadataInfo#getWidgetSizeY()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ScadaSymbolMetadataInfo.getDescription()",
    "String[] ScadaSymbolMetadataInfo.getSearchTags()",
    "String ScadaSymbolMetadataInfo.getTitle()",
    "int ScadaSymbolMetadataInfo.getWidgetSizeX()",
    "int ScadaSymbolMetadataInfo.getWidgetSizeY()",
    "void ScadaSymbolMetadataInfo.setDescription(String)",
    "void ScadaSymbolMetadataInfo.setSearchTags(String[])",
    "void ScadaSymbolMetadataInfo.setTitle(String)",
    "void ScadaSymbolMetadataInfo.setWidgetSizeX(int)",
    "void ScadaSymbolMetadataInfo.setWidgetSizeY(int)",
    "String ScadaSymbolMetadataInfo.toString()"
  })
  public void testScadaSymbolMetadataInfoGettersAndSetters() {
    // Arrange
    ScadaSymbolMetadataInfo scadaSymbolMetadataInfo =
        new ScadaSymbolMetadataInfo(
            "foo.txt", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act
    scadaSymbolMetadataInfo.setDescription("The characteristics of someone or something");
    String[] searchTags = new String[] {"Search Tags"};
    scadaSymbolMetadataInfo.setSearchTags(searchTags);
    scadaSymbolMetadataInfo.setTitle("Dr");
    scadaSymbolMetadataInfo.setWidgetSizeX(1);
    scadaSymbolMetadataInfo.setWidgetSizeY(1);
    String actualToStringResult = scadaSymbolMetadataInfo.toString();
    String actualDescription = scadaSymbolMetadataInfo.getDescription();
    String[] actualSearchTags = scadaSymbolMetadataInfo.getSearchTags();
    String actualTitle = scadaSymbolMetadataInfo.getTitle();
    int actualWidgetSizeX = scadaSymbolMetadataInfo.getWidgetSizeX();

    // Assert
    assertEquals("Dr", actualTitle);
    assertEquals(
        "ImageUtils.ScadaSymbolMetadataInfo(title=Dr, description=The characteristics of someone or something,"
            + " searchTags=[Search Tags], widgetSizeX=1, widgetSizeY=1)",
        actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1, actualWidgetSizeX);
    assertEquals(1, scadaSymbolMetadataInfo.getWidgetSizeY());
    assertSame(searchTags, actualSearchTags);
    assertArrayEquals(new String[] {"Search Tags"}, actualSearchTags);
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String,
   * JsonNode)}.
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScadaSymbolMetadataInfo.<init>(String, JsonNode)"})
  public void testScadaSymbolMetadataInfoNewScadaSymbolMetadataInfo() {
    // Arrange and Act
    ScadaSymbolMetadataInfo actualScadaSymbolMetadataInfo =
        new ScadaSymbolMetadataInfo(
            "foo.txt", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Assert
    assertEquals("", actualScadaSymbolMetadataInfo.getDescription());
    assertEquals("foo.txt", actualScadaSymbolMetadataInfo.getTitle());
    assertEquals(0, actualScadaSymbolMetadataInfo.getSearchTags().length);
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeX());
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeY());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String,
   * JsonNode)}.
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScadaSymbolMetadataInfo.<init>(String, JsonNode)"})
  public void testScadaSymbolMetadataInfoNewScadaSymbolMetadataInfo2() {
    // Arrange
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);
    ArrayNode metaData = new ArrayNode(nf);

    // Act
    ScadaSymbolMetadataInfo actualScadaSymbolMetadataInfo =
        new ScadaSymbolMetadataInfo("foo.txt", metaData);

    // Assert
    assertEquals("", actualScadaSymbolMetadataInfo.getDescription());
    assertEquals("foo.txt", actualScadaSymbolMetadataInfo.getTitle());
    assertEquals(0, actualScadaSymbolMetadataInfo.getSearchTags().length);
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeX());
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeY());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String,
   * JsonNode)}.
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScadaSymbolMetadataInfo.<init>(String, JsonNode)"})
  public void testScadaSymbolMetadataInfoNewScadaSymbolMetadataInfo3() {
    // Arrange
    BigInteger v = BigInteger.valueOf(3L);
    BigIntegerNode metaData = new BigIntegerNode(v);

    // Act
    ScadaSymbolMetadataInfo actualScadaSymbolMetadataInfo =
        new ScadaSymbolMetadataInfo("foo.txt", metaData);

    // Assert
    assertEquals("", actualScadaSymbolMetadataInfo.getDescription());
    assertEquals("foo.txt", actualScadaSymbolMetadataInfo.getTitle());
    assertEquals(0, actualScadaSymbolMetadataInfo.getSearchTags().length);
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeX());
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeY());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String,
   * JsonNode)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void ScadaSymbolMetadataInfo.<init>(String, JsonNode)"})
  public void testScadaSymbolMetadataInfoNewScadaSymbolMetadataInfo_whenNull() {
    // Arrange and Act
    ScadaSymbolMetadataInfo actualScadaSymbolMetadataInfo =
        new ScadaSymbolMetadataInfo("foo.txt", null);

    // Assert
    assertEquals("", actualScadaSymbolMetadataInfo.getDescription());
    assertEquals("foo.txt", actualScadaSymbolMetadataInfo.getTitle());
    assertEquals(0, actualScadaSymbolMetadataInfo.getSearchTags().length);
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeX());
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeY());
  }

  /**
   * Test {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage)} with {@code originalImage}.
   *
   * <p>Method under test: {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessedImage ImageUtils.withPreviewAsOriginalImage(ProcessedImage)"})
  public void testWithPreviewAsOriginalImageWithOriginalImage()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ProcessedImage preview = new ProcessedImage();

    // Act
    ProcessedImage actualWithPreviewAsOriginalImageResult =
        ImageUtils.withPreviewAsOriginalImage(
            new ProcessedImage("text/plain", 1, 1, data, 3L, preview));

    // Assert
    ProcessedImage preview2 = actualWithPreviewAsOriginalImageResult.getPreview();
    assertEquals("text/plain", preview2.getMediaType());
    assertEquals("text/plain", actualWithPreviewAsOriginalImageResult.getMediaType());
    assertNull(preview2.getData());
    assertEquals(1, preview2.getHeight());
    assertEquals(1, actualWithPreviewAsOriginalImageResult.getHeight());
    assertEquals(1, preview2.getWidth());
    assertEquals(1, actualWithPreviewAsOriginalImageResult.getWidth());
    assertEquals(3L, preview2.getSize());
    assertEquals(3L, actualWithPreviewAsOriginalImageResult.getSize());
    assertSame(preview, preview2.getPreview());
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"), actualWithPreviewAsOriginalImageResult.getData());
  }

  /**
   * Test {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage, byte[])} with {@code
   * originalImage}, {@code previewData}.
   *
   * <p>Method under test: {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessedImage ImageUtils.withPreviewAsOriginalImage(ProcessedImage, byte[])"
  })
  public void testWithPreviewAsOriginalImageWithOriginalImagePreviewData()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    ProcessedImage preview =
        ImageUtils.withPreviewAsOriginalImage(new ProcessedImage(), "AXAXAXAX".getBytes("UTF-8"))
            .getPreview();
    assertNull(preview.getMediaType());
    assertNull(preview.getPreview());
    assertEquals(0, preview.getHeight());
    assertEquals(0, preview.getWidth());
    assertEquals(8L, preview.getSize());
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), preview.getData());
  }

  /**
   * Test {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage, byte[])} with {@code
   * originalImage}, {@code previewData}.
   *
   * <ul>
   *   <li>Then return Data is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ProcessedImage ImageUtils.withPreviewAsOriginalImage(ProcessedImage, byte[])"
  })
  public void testWithPreviewAsOriginalImageWithOriginalImagePreviewData_thenReturnDataIsNull() {
    // Arrange
    ProcessedImage originalImage = new ProcessedImage();

    // Act
    ProcessedImage actualWithPreviewAsOriginalImageResult =
        ImageUtils.withPreviewAsOriginalImage(originalImage, null);

    // Assert
    assertNull(actualWithPreviewAsOriginalImageResult.getData());
    assertNull(actualWithPreviewAsOriginalImageResult.getMediaType());
    assertEquals(0, actualWithPreviewAsOriginalImageResult.getHeight());
    assertEquals(0, actualWithPreviewAsOriginalImageResult.getWidth());
    assertEquals(0L, actualWithPreviewAsOriginalImageResult.getSize());
    ProcessedImage actualPreview = originalImage.getPreview();
    assertSame(originalImage, actualPreview);
    ProcessedImage actualPreview2 = actualWithPreviewAsOriginalImageResult.getPreview();
    assertSame(actualWithPreviewAsOriginalImageResult, actualPreview2);
  }

  /**
   * Test {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage)} with {@code originalImage}.
   *
   * <ul>
   *   <li>Then return Data is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"ProcessedImage ImageUtils.withPreviewAsOriginalImage(ProcessedImage)"})
  public void testWithPreviewAsOriginalImageWithOriginalImage_thenReturnDataIsNull() {
    // Arrange
    ProcessedImage originalImage = new ProcessedImage();

    // Act
    ProcessedImage actualWithPreviewAsOriginalImageResult =
        ImageUtils.withPreviewAsOriginalImage(originalImage);

    // Assert
    assertNull(actualWithPreviewAsOriginalImageResult.getData());
    assertNull(actualWithPreviewAsOriginalImageResult.getMediaType());
    assertEquals(0, actualWithPreviewAsOriginalImageResult.getHeight());
    assertEquals(0, actualWithPreviewAsOriginalImageResult.getWidth());
    assertEquals(0L, actualWithPreviewAsOriginalImageResult.getSize());
    ProcessedImage actualPreview = originalImage.getPreview();
    assertSame(originalImage, actualPreview);
    ProcessedImage actualPreview2 = actualWithPreviewAsOriginalImageResult.getPreview();
    assertSame(actualWithPreviewAsOriginalImageResult, actualPreview2);
  }

  /**
   * Test {@link ImageUtils#processScadaSymbolMetadata(String, byte[])}.
   *
   * <p>Method under test: {@link ImageUtils#processScadaSymbolMetadata(String, byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ScadaSymbolMetadataInfo ImageUtils.processScadaSymbolMetadata(String, byte[])"
  })
  public void testProcessScadaSymbolMetadata() throws Exception {
    // Arrange and Act
    ScadaSymbolMetadataInfo actualProcessScadaSymbolMetadataResult =
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("", actualProcessScadaSymbolMetadataResult.getDescription());
    assertEquals("foo.txt", actualProcessScadaSymbolMetadataResult.getTitle());
    assertEquals(0, actualProcessScadaSymbolMetadataResult.getSearchTags().length);
    assertEquals(3, actualProcessScadaSymbolMetadataResult.getWidgetSizeX());
    assertEquals(3, actualProcessScadaSymbolMetadataResult.getWidgetSizeY());
  }

  /**
   * Test {@link ImageUtils#removeScadaSymbolMetadata(byte[])}.
   *
   * <p>Method under test: {@link ImageUtils#removeScadaSymbolMetadata(byte[])}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] ImageUtils.removeScadaSymbolMetadata(byte[])"})
  public void testRemoveScadaSymbolMetadata() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        "AXAXAXAX".getBytes("UTF-8"),
        ImageUtils.removeScadaSymbolMetadata("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code #42}.
   *   <li>Then return a string.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_when42_thenReturnAString() {
    // Arrange, Act and Assert
    assertEquals(
        "data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAEAAAABCAIAAACQd1PeAAAADElEQVR4XmNgYHACAABGAEPOCOkzAA"
            + "AAAElFTkSuQmCC",
        ImageUtils.getEmbeddedBase64EncodedImg("#42"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code Color Str}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenColorStr_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("Color Str"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hsl42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsl42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl42"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hslColor Str}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslColorStr_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslColor Str"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hslFailed to generate embedded image for color: {}}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslFailedToGenerateEmbeddedImageForColor() {
    // Arrange, Act and Assert
    assertNull(
        ImageUtils.getEmbeddedBase64EncodedImg(
            "hslFailed to generate embedded image for color: {}"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hsl(?s)<tb:metadata[^>]*><!\[CDATA\[(.*)]]><\/tb:metadata>}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslSTbMetadataCdataTbMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        ImageUtils.getEmbeddedBase64EncodedImg(
            "hsl(?s)<tb:metadata[^>]*><!\\[CDATA\\[(.*)]]><\\/tb:metadata>"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hsl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hsl#}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsl_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl#"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hslheight}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslheight_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslheight"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hslhsl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslhsl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslhsl"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hslico}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslico_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslico"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hslimage/png}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslimagePng_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslimage/png"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hslimage}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslimage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslimage"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hsljava.awt.Component}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsljavaAwtComponent_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsljava.awt.Component"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hslString}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsljavaLangString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsljava.lang.String"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hsljpeg}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsljpeg_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsljpeg"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hsljpg}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsljpg_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsljpg"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hslpng}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslpng_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslpng"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hslrgb}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslrgb_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslrgb"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hslsvg+xml}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslsvgXml_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslsvg+xml"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hslsvg}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslsvg_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslsvg"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code hslwidth}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslwidth_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslwidth"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code #}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenNumberSign_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("#"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgb42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgb42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb42"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbColor Str}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbColorStr_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbColor Str"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbFailed to generate embedded image for color: {}}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbFailedToGenerateEmbeddedImageForColor() {
    // Arrange, Act and Assert
    assertNull(
        ImageUtils.getEmbeddedBase64EncodedImg(
            "rgbFailed to generate embedded image for color: {}"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgb(?s)<tb:metadata[^>]*><!\[CDATA\[(.*)]]><\/tb:metadata>}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbSTbMetadataCdataTbMetadata_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(
        ImageUtils.getEmbeddedBase64EncodedImg(
            "rgb(?s)<tb:metadata[^>]*><!\\[CDATA\\[(.*)]]><\\/tb:metadata>"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgb}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgb_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgb#}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgb_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb#"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbheight}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbheight_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbheight"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbhsl}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbhsl_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbhsl"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbico}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbico_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbico"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbimage/png}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbimagePng_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbimage/png"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbimage}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbimage_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbimage"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbjava.awt.Component}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbjavaAwtComponent_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbjava.awt.Component"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbString}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbjavaLangString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbjava.lang.String"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbjpeg}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbjpeg_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbjpeg"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbjpg}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbjpg_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbjpg"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbpng}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbpng_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbpng"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbrgb}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbrgb_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbrgb"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbsvg+xml}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbsvgXml_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbsvg+xml"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbsvg}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbsvg_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbsvg"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   *
   * <ul>
   *   <li>When {@code rgbwidth}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbwidth_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbwidth"));
  }
}
