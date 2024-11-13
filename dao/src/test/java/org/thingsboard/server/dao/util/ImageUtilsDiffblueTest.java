package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import org.junit.Test;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.util.ImageUtils.ProcessedImage;
import org.thingsboard.server.dao.util.ImageUtils.ScadaSymbolMetadataInfo;

public class ImageUtilsDiffblueTest {
  /**
   * Test {@link ImageUtils#mediaTypeToFileExtension(String)}.
   * <ul>
   *   <li>When {@code image/png}.</li>
   *   <li>Then return {@code png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#mediaTypeToFileExtension(String)}
   */
  @Test
  public void testMediaTypeToFileExtension_whenImagePng_thenReturnPng() {
    // Arrange, Act and Assert
    assertEquals("png", ImageUtils.mediaTypeToFileExtension("image/png"));
  }

  /**
   * Test {@link ImageUtils#fileExtensionToMediaType(String)}.
   * <ul>
   *   <li>When {@code Extension}.</li>
   *   <li>Then return {@code image/extension}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#fileExtensionToMediaType(String)}
   */
  @Test
  public void testFileExtensionToMediaType_whenExtension_thenReturnImageExtension() {
    // Arrange, Act and Assert
    assertEquals("image/extension", ImageUtils.fileExtensionToMediaType("Extension"));
  }

  /**
   * Test {@link ImageUtils#fileExtensionToMediaType(String)}.
   * <ul>
   *   <li>When {@code jpg}.</li>
   *   <li>Then return {@code image/jpeg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#fileExtensionToMediaType(String)}
   */
  @Test
  public void testFileExtensionToMediaType_whenJpg_thenReturnImageJpeg() {
    // Arrange, Act and Assert
    assertEquals("image/jpeg", ImageUtils.fileExtensionToMediaType("jpg"));
  }

  /**
   * Test {@link ImageUtils#processSvgImage(byte[], String, int)}.
   * <ul>
   *   <li>Then return Preview MediaType is {@code Media Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#processSvgImage(byte[], String, int)}
   */
  @Test
  public void testProcessSvgImage_thenReturnPreviewMediaTypeIsMediaType() throws Exception {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ImageUtils.ProcessedImage actualProcessSvgImageResult = ImageUtils.processSvgImage(data, "Media Type", 1);

    // Assert
    ImageUtils.ProcessedImage preview = actualProcessSvgImageResult.getPreview();
    assertEquals("Media Type", preview.getMediaType());
    assertEquals("Media Type", actualProcessSvgImageResult.getMediaType());
    assertNull(preview.getPreview());
    assertEquals(0, preview.getHeight());
    assertEquals(0, actualProcessSvgImageResult.getHeight());
    assertEquals(0, preview.getWidth());
    assertEquals(0, actualProcessSvgImageResult.getWidth());
    assertEquals(8L, preview.getSize());
    assertEquals(8L, actualProcessSvgImageResult.getSize());
    assertSame(data, actualProcessSvgImageResult.getData());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, preview.getData());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}, and
   * {@link ProcessedImage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageUtils.ProcessedImage#equals(Object)}
   *   <li>{@link ImageUtils.ProcessedImage#hashCode()}
   * </ul>
   */
  @Test
  public void testProcessedImageEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImageUtils.ProcessedImage processedImage = new ImageUtils.ProcessedImage();
    ImageUtils.ProcessedImage processedImage2 = new ImageUtils.ProcessedImage();

    // Act and Assert
    assertEquals(processedImage, processedImage2);
    int expectedHashCodeResult = processedImage.hashCode();
    assertEquals(expectedHashCodeResult, processedImage2.hashCode());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}, and
   * {@link ProcessedImage#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageUtils.ProcessedImage#equals(Object)}
   *   <li>{@link ImageUtils.ProcessedImage#hashCode()}
   * </ul>
   */
  @Test
  public void testProcessedImageEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() throws Exception {
    // Arrange
    ImageUtils.ProcessedImage processSvgImageResult = ImageUtils.processSvgImage("AXAXAXAX".getBytes("UTF-8"),
        "Media Type", 1);
    ImageUtils.ProcessedImage processSvgImageResult2 = ImageUtils.processSvgImage("AXAXAXAX".getBytes("UTF-8"),
        "Media Type", 1);

    // Act and Assert
    assertEquals(processSvgImageResult, processSvgImageResult2);
    int expectedHashCodeResult = processSvgImageResult.hashCode();
    assertEquals(expectedHashCodeResult, processSvgImageResult2.hashCode());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}, and
   * {@link ProcessedImage#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageUtils.ProcessedImage#equals(Object)}
   *   <li>{@link ImageUtils.ProcessedImage#hashCode()}
   * </ul>
   */
  @Test
  public void testProcessedImageEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImageUtils.ProcessedImage processedImage = new ImageUtils.ProcessedImage();

    // Act and Assert
    assertEquals(processedImage, processedImage);
    int expectedHashCodeResult = processedImage.hashCode();
    assertEquals(expectedHashCodeResult, processedImage.hashCode());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ProcessedImage#equals(Object)}
   */
  @Test
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual() throws Exception {
    // Arrange
    ImageUtils.ProcessedImage processSvgImageResult = ImageUtils.processSvgImage("AXAXAXAX".getBytes("UTF-8"),
        "Media Type", 1);

    // Act and Assert
    assertNotEquals(processSvgImageResult, new ImageUtils.ProcessedImage());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ProcessedImage#equals(Object)}
   */
  @Test
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImageUtils.ProcessedImage processedImage = new ImageUtils.ProcessedImage();
    processedImage.setMediaType("Media Type");

    // Act and Assert
    assertNotEquals(processedImage, new ImageUtils.ProcessedImage());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ProcessedImage#equals(Object)}
   */
  @Test
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImageUtils.ProcessedImage processedImage = new ImageUtils.ProcessedImage();
    processedImage.setWidth(1);

    // Act and Assert
    assertNotEquals(processedImage, new ImageUtils.ProcessedImage());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ProcessedImage#equals(Object)}
   */
  @Test
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImageUtils.ProcessedImage processedImage = new ImageUtils.ProcessedImage();
    processedImage.setHeight(1);

    // Act and Assert
    assertNotEquals(processedImage, new ImageUtils.ProcessedImage());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ProcessedImage#equals(Object)}
   */
  @Test
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImageUtils.ProcessedImage processedImage = new ImageUtils.ProcessedImage();
    processedImage.setData(new byte[]{'A', 1, 'A', 1, 'A', 1, 'A', 1});

    // Act and Assert
    assertNotEquals(processedImage, new ImageUtils.ProcessedImage());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ProcessedImage#equals(Object)}
   */
  @Test
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImageUtils.ProcessedImage processedImage = new ImageUtils.ProcessedImage();
    processedImage.setPreview(new ImageUtils.ProcessedImage());

    // Act and Assert
    assertNotEquals(processedImage, new ImageUtils.ProcessedImage());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ProcessedImage#equals(Object)}
   */
  @Test
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImageUtils.ProcessedImage processedImage = new ImageUtils.ProcessedImage();

    ImageUtils.ProcessedImage processedImage2 = new ImageUtils.ProcessedImage();
    processedImage2.setMediaType("Media Type");

    // Act and Assert
    assertNotEquals(processedImage, processedImage2);
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ProcessedImage#equals(Object)}
   */
  @Test
  public void testProcessedImageEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImageUtils.ProcessedImage processedImage = new ImageUtils.ProcessedImage();

    ImageUtils.ProcessedImage processedImage2 = new ImageUtils.ProcessedImage();
    processedImage2.setPreview(new ImageUtils.ProcessedImage());

    // Act and Assert
    assertNotEquals(processedImage, processedImage2);
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ProcessedImage#equals(Object)}
   */
  @Test
  public void testProcessedImageEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ImageUtils.ProcessedImage(), null);
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ProcessedImage#equals(Object)}
   */
  @Test
  public void testProcessedImageEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ImageUtils.ProcessedImage(), "Different type to ProcessedImage");
  }

  /**
   * Test ProcessedImage getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageUtils.ProcessedImage#ProcessedImage()}
   *   <li>{@link ImageUtils.ProcessedImage#setData(byte[])}
   *   <li>{@link ImageUtils.ProcessedImage#setHeight(int)}
   *   <li>{@link ImageUtils.ProcessedImage#setMediaType(String)}
   *   <li>{@link ImageUtils.ProcessedImage#setPreview(ImageUtils.ProcessedImage)}
   *   <li>{@link ImageUtils.ProcessedImage#setSize(long)}
   *   <li>{@link ImageUtils.ProcessedImage#setWidth(int)}
   *   <li>{@link ImageUtils.ProcessedImage#toString()}
   *   <li>{@link ImageUtils.ProcessedImage#getData()}
   *   <li>{@link ImageUtils.ProcessedImage#getHeight()}
   *   <li>{@link ImageUtils.ProcessedImage#getMediaType()}
   *   <li>{@link ImageUtils.ProcessedImage#getPreview()}
   *   <li>{@link ImageUtils.ProcessedImage#getSize()}
   *   <li>{@link ImageUtils.ProcessedImage#getWidth()}
   * </ul>
   */
  @Test
  public void testProcessedImageGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    ImageUtils.ProcessedImage actualProcessedImage = new ImageUtils.ProcessedImage();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualProcessedImage.setData(data);
    actualProcessedImage.setHeight(1);
    actualProcessedImage.setMediaType("Media Type");
    ImageUtils.ProcessedImage preview = new ImageUtils.ProcessedImage();
    actualProcessedImage.setPreview(preview);
    actualProcessedImage.setSize(3L);
    actualProcessedImage.setWidth(1);
    String actualToStringResult = actualProcessedImage.toString();
    byte[] actualData = actualProcessedImage.getData();
    int actualHeight = actualProcessedImage.getHeight();
    String actualMediaType = actualProcessedImage.getMediaType();
    ImageUtils.ProcessedImage actualPreview = actualProcessedImage.getPreview();
    long actualSize = actualProcessedImage.getSize();

    // Assert that nothing has changed
    assertEquals("ImageUtils.ProcessedImage(mediaType=Media Type, width=1, height=1, data=[65, 88, 65, 88, 65, 88, 65,"
        + " 88], size=3, preview=ImageUtils.ProcessedImage(mediaType=null, width=0, height=0, data=null, size=0,"
        + " preview=null))", actualToStringResult);
    assertEquals("Media Type", actualMediaType);
    assertEquals(1, actualHeight);
    assertEquals(1, actualProcessedImage.getWidth());
    assertEquals(3L, actualSize);
    assertSame(preview, actualPreview);
    assertSame(data, actualData);
  }

  /**
   * Test ProcessedImage
   * {@link ProcessedImage#ProcessedImage(String, int, int, byte[], long, ProcessedImage)}.
   * <p>
   * Method under test:
   * {@link ImageUtils.ProcessedImage#ProcessedImage(String, int, int, byte[], long, ImageUtils.ProcessedImage)}
   */
  @Test
  public void testProcessedImageNewProcessedImage() throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ImageUtils.ProcessedImage preview = new ImageUtils.ProcessedImage();

    // Act
    ImageUtils.ProcessedImage actualProcessedImage = new ImageUtils.ProcessedImage("Media Type", 1, 1, data, 3L,
        preview);

    // Assert
    assertEquals("Media Type", actualProcessedImage.getMediaType());
    assertEquals(1, actualProcessedImage.getHeight());
    assertEquals(1, actualProcessedImage.getWidth());
    assertEquals(3L, actualProcessedImage.getSize());
    assertSame(preview, actualProcessedImage.getPreview());
    assertSame(data, actualProcessedImage.getData());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#withData(byte[])}.
   * <p>
   * Method under test: {@link ImageUtils.ProcessedImage#withData(byte[])}
   */
  @Test
  public void testProcessedImageWithData() throws UnsupportedEncodingException {
    // Arrange
    ImageUtils.ProcessedImage processedImage = new ImageUtils.ProcessedImage();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");

    // Act
    ImageUtils.ProcessedImage actualWithDataResult = processedImage.withData(data);

    // Assert
    assertNull(actualWithDataResult.getMediaType());
    assertNull(actualWithDataResult.getPreview());
    assertEquals(0, actualWithDataResult.getHeight());
    assertEquals(0, actualWithDataResult.getWidth());
    assertEquals(0L, actualWithDataResult.getSize());
    assertSame(data, actualWithDataResult.getData());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)},
   * and {@link ScadaSymbolMetadataInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#equals(Object)}
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testScadaSymbolMetadataInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws Exception {
    // Arrange
    ImageUtils.ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils
        .processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));
    ImageUtils.ScadaSymbolMetadataInfo processScadaSymbolMetadataResult2 = ImageUtils
        .processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(processScadaSymbolMetadataResult, processScadaSymbolMetadataResult2);
    int expectedHashCodeResult = processScadaSymbolMetadataResult.hashCode();
    assertEquals(expectedHashCodeResult, processScadaSymbolMetadataResult2.hashCode());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)},
   * and {@link ScadaSymbolMetadataInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#equals(Object)}
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testScadaSymbolMetadataInfoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws Exception {
    // Arrange
    ImageUtils.ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils
        .processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(processScadaSymbolMetadataResult, processScadaSymbolMetadataResult);
    int expectedHashCodeResult = processScadaSymbolMetadataResult.hashCode();
    assertEquals(expectedHashCodeResult, processScadaSymbolMetadataResult.hashCode());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual() throws Exception {
    // Arrange
    ImageUtils.ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils
        .processScadaSymbolMetadata("File Name", "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(processScadaSymbolMetadataResult,
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws Exception {
    // Arrange
    ImageUtils.ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils.processScadaSymbolMetadata(null,
        "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertNotEquals(processScadaSymbolMetadataResult,
        ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsNull_thenReturnNotEqual() throws Exception {
    // Arrange, Act and Assert
    assertNotEquals(ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8")), null);
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils.ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsWrongType_thenReturnNotEqual() throws Exception {
    // Arrange, Act and Assert
    assertNotEquals(ImageUtils.processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8")),
        "Different type to ScadaSymbolMetadataInfo");
  }

  /**
   * Test ScadaSymbolMetadataInfo getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#setDescription(String)}
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#setSearchTags(String[])}
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#setTitle(String)}
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#setWidgetSizeX(int)}
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#setWidgetSizeY(int)}
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#toString()}
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#getDescription()}
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#getSearchTags()}
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#getTitle()}
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#getWidgetSizeX()}
   *   <li>{@link ImageUtils.ScadaSymbolMetadataInfo#getWidgetSizeY()}
   * </ul>
   */
  @Test
  public void testScadaSymbolMetadataInfoGettersAndSetters() {
    // Arrange
    ImageUtils.ScadaSymbolMetadataInfo scadaSymbolMetadataInfo = new ImageUtils.ScadaSymbolMetadataInfo("foo.txt",
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act
    scadaSymbolMetadataInfo.setDescription("The characteristics of someone or something");
    String[] searchTags = new String[]{"Search Tags"};
    scadaSymbolMetadataInfo.setSearchTags(searchTags);
    scadaSymbolMetadataInfo.setTitle("Dr");
    scadaSymbolMetadataInfo.setWidgetSizeX(1);
    scadaSymbolMetadataInfo.setWidgetSizeY(1);
    String actualToStringResult = scadaSymbolMetadataInfo.toString();
    String actualDescription = scadaSymbolMetadataInfo.getDescription();
    String[] actualSearchTags = scadaSymbolMetadataInfo.getSearchTags();
    String actualTitle = scadaSymbolMetadataInfo.getTitle();
    int actualWidgetSizeX = scadaSymbolMetadataInfo.getWidgetSizeX();

    // Assert that nothing has changed
    assertEquals("Dr", actualTitle);
    assertEquals("ImageUtils.ScadaSymbolMetadataInfo(title=Dr, description=The characteristics of someone or something,"
        + " searchTags=[Search Tags], widgetSizeX=1, widgetSizeY=1)", actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(1, actualWidgetSizeX);
    assertEquals(1, scadaSymbolMetadataInfo.getWidgetSizeY());
    assertSame(searchTags, actualSearchTags);
    assertArrayEquals(new String[]{"Search Tags"}, actualSearchTags);
  }

  /**
   * Test ScadaSymbolMetadataInfo
   * {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}.
   * <p>
   * Method under test:
   * {@link ImageUtils.ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}
   */
  @Test
  public void testScadaSymbolMetadataInfoNewScadaSymbolMetadataInfo() {
    // Arrange and Act
    ImageUtils.ScadaSymbolMetadataInfo actualScadaSymbolMetadataInfo = new ImageUtils.ScadaSymbolMetadataInfo("foo.txt",
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Assert
    assertEquals("", actualScadaSymbolMetadataInfo.getDescription());
    assertEquals("foo.txt", actualScadaSymbolMetadataInfo.getTitle());
    assertEquals(0, actualScadaSymbolMetadataInfo.getSearchTags().length);
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeX());
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeY());
  }

  /**
   * Test ScadaSymbolMetadataInfo
   * {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}.
   * <p>
   * Method under test:
   * {@link ImageUtils.ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}
   */
  @Test
  public void testScadaSymbolMetadataInfoNewScadaSymbolMetadataInfo2() {
    // Arrange and Act
    ImageUtils.ScadaSymbolMetadataInfo actualScadaSymbolMetadataInfo = new ImageUtils.ScadaSymbolMetadataInfo("foo.txt",
        new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Assert
    assertEquals("", actualScadaSymbolMetadataInfo.getDescription());
    assertEquals("foo.txt", actualScadaSymbolMetadataInfo.getTitle());
    assertEquals(0, actualScadaSymbolMetadataInfo.getSearchTags().length);
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeX());
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeY());
  }

  /**
   * Test ScadaSymbolMetadataInfo
   * {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}.
   * <p>
   * Method under test:
   * {@link ImageUtils.ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}
   */
  @Test
  public void testScadaSymbolMetadataInfoNewScadaSymbolMetadataInfo3() {
    // Arrange and Act
    ImageUtils.ScadaSymbolMetadataInfo actualScadaSymbolMetadataInfo = new ImageUtils.ScadaSymbolMetadataInfo("foo.txt",
        new BigIntegerNode(BigInteger.valueOf(3L)));

    // Assert
    assertEquals("", actualScadaSymbolMetadataInfo.getDescription());
    assertEquals("foo.txt", actualScadaSymbolMetadataInfo.getTitle());
    assertEquals(0, actualScadaSymbolMetadataInfo.getSearchTags().length);
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeX());
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeY());
  }

  /**
   * Test ScadaSymbolMetadataInfo
   * {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageUtils.ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}
   */
  @Test
  public void testScadaSymbolMetadataInfoNewScadaSymbolMetadataInfo_whenNull() {
    // Arrange and Act
    ImageUtils.ScadaSymbolMetadataInfo actualScadaSymbolMetadataInfo = new ImageUtils.ScadaSymbolMetadataInfo("foo.txt",
        null);

    // Assert
    assertEquals("", actualScadaSymbolMetadataInfo.getDescription());
    assertEquals("foo.txt", actualScadaSymbolMetadataInfo.getTitle());
    assertEquals(0, actualScadaSymbolMetadataInfo.getSearchTags().length);
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeX());
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeY());
  }

  /**
   * Test {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage, byte[])}
   * with {@code originalImage}, {@code previewData}.
   * <p>
   * Method under test:
   * {@link ImageUtils#withPreviewAsOriginalImage(ImageUtils.ProcessedImage, byte[])}
   */
  @Test
  public void testWithPreviewAsOriginalImageWithOriginalImagePreviewData() throws UnsupportedEncodingException {
    // Arrange
    ImageUtils.ProcessedImage originalImage = new ImageUtils.ProcessedImage();
    byte[] previewData = "AXAXAXAX".getBytes("UTF-8");

    // Act and Assert
    ImageUtils.ProcessedImage preview = ImageUtils.withPreviewAsOriginalImage(originalImage, previewData).getPreview();
    assertNull(preview.getMediaType());
    assertNull(preview.getPreview());
    assertEquals(0, preview.getHeight());
    assertEquals(0, preview.getWidth());
    assertEquals(8L, preview.getSize());
    assertSame(previewData, preview.getData());
  }

  /**
   * Test {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage, byte[])}
   * with {@code originalImage}, {@code previewData}.
   * <ul>
   *   <li>Then return Data is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageUtils#withPreviewAsOriginalImage(ImageUtils.ProcessedImage, byte[])}
   */
  @Test
  public void testWithPreviewAsOriginalImageWithOriginalImagePreviewData_thenReturnDataIsNull() {
    // Arrange
    ImageUtils.ProcessedImage originalImage = new ImageUtils.ProcessedImage();

    // Act
    ImageUtils.ProcessedImage actualWithPreviewAsOriginalImageResult = ImageUtils
        .withPreviewAsOriginalImage(originalImage, null);

    // Assert
    assertNull(actualWithPreviewAsOriginalImageResult.getData());
    assertNull(actualWithPreviewAsOriginalImageResult.getMediaType());
    assertEquals(0, actualWithPreviewAsOriginalImageResult.getHeight());
    assertEquals(0, actualWithPreviewAsOriginalImageResult.getWidth());
    assertEquals(0L, actualWithPreviewAsOriginalImageResult.getSize());
    assertSame(originalImage, originalImage.getPreview());
    assertSame(actualWithPreviewAsOriginalImageResult, actualWithPreviewAsOriginalImageResult.getPreview());
  }

  /**
   * Test {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage)} with
   * {@code originalImage}.
   * <ul>
   *   <li>Then return Data is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageUtils#withPreviewAsOriginalImage(ImageUtils.ProcessedImage)}
   */
  @Test
  public void testWithPreviewAsOriginalImageWithOriginalImage_thenReturnDataIsNull() {
    // Arrange
    ImageUtils.ProcessedImage originalImage = new ImageUtils.ProcessedImage();

    // Act
    ImageUtils.ProcessedImage actualWithPreviewAsOriginalImageResult = ImageUtils
        .withPreviewAsOriginalImage(originalImage);

    // Assert
    assertNull(actualWithPreviewAsOriginalImageResult.getData());
    assertSame(originalImage, originalImage.getPreview());
    assertSame(actualWithPreviewAsOriginalImageResult, actualWithPreviewAsOriginalImageResult.getPreview());
  }

  /**
   * Test {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage)} with
   * {@code originalImage}.
   * <ul>
   *   <li>Then return Preview Data is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link ImageUtils#withPreviewAsOriginalImage(ImageUtils.ProcessedImage)}
   */
  @Test
  public void testWithPreviewAsOriginalImageWithOriginalImage_thenReturnPreviewDataIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    ImageUtils.ProcessedImage originalImage = new ImageUtils.ProcessedImage();
    originalImage.setData("AXAXAXAX".getBytes("UTF-8"));

    // Act
    ImageUtils.ProcessedImage actualWithPreviewAsOriginalImageResult = ImageUtils
        .withPreviewAsOriginalImage(originalImage);

    // Assert
    ImageUtils.ProcessedImage preview = actualWithPreviewAsOriginalImageResult.getPreview();
    assertNull(preview.getData());
    assertNull(preview.getMediaType());
    assertNull(preview.getPreview());
    assertEquals(0, preview.getHeight());
    assertEquals(0, preview.getWidth());
    assertEquals(0L, preview.getSize());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualWithPreviewAsOriginalImageResult.getData());
  }

  /**
   * Test {@link ImageUtils#processScadaSymbolMetadata(String, byte[])}.
   * <p>
   * Method under test:
   * {@link ImageUtils#processScadaSymbolMetadata(String, byte[])}
   */
  @Test
  public void testProcessScadaSymbolMetadata() throws Exception {
    // Arrange and Act
    ImageUtils.ScadaSymbolMetadataInfo actualProcessScadaSymbolMetadataResult = ImageUtils
        .processScadaSymbolMetadata("foo.txt", "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertEquals("", actualProcessScadaSymbolMetadataResult.getDescription());
    assertEquals("foo.txt", actualProcessScadaSymbolMetadataResult.getTitle());
    assertEquals(0, actualProcessScadaSymbolMetadataResult.getSearchTags().length);
    assertEquals(3, actualProcessScadaSymbolMetadataResult.getWidgetSizeX());
    assertEquals(3, actualProcessScadaSymbolMetadataResult.getWidgetSizeY());
  }

  /**
   * Test {@link ImageUtils#removeScadaSymbolMetadata(byte[])}.
   * <p>
   * Method under test: {@link ImageUtils#removeScadaSymbolMetadata(byte[])}
   */
  @Test
  public void testRemoveScadaSymbolMetadata() throws UnsupportedEncodingException {
    // Arrange and Act
    byte[] actualRemoveScadaSymbolMetadataResult = ImageUtils.removeScadaSymbolMetadata("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualRemoveScadaSymbolMetadataResult);
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code Color Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenColorStr() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("Color Str"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hsl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHsl() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl"));
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl#"));
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl,"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hsl[^0-9.,]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHsl09() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl[^0-9.,]"));
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl[^0-9,]"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hsl42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHsl42() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl42"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslColor Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslColorStr() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslColor Str"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslFailed to generate embedded image for color: {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslFailedToGenerateEmbeddedImageForColor() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslFailed to generate embedded image for color: {}"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When
   * {@code hsl(?s)<tb:metadata[^>]*><!\[CDATA\[(.*)]]><\/tb:metadata>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslSTbMetadataCdataTbMetadata() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl(?s)<tb:metadata[^>]*><!\\[CDATA\\[(.*)]]><\\/tb:metadata>"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslU() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslU"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslheight}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslheight() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslheight"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslhsl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslhsl() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslhsl"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslico}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslico() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslico"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslimage}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslimage() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslimage"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslimage/png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslimagePng() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslimage/png"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hsljava.awt.Component}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHsljavaAwtComponent() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsljava.awt.Component"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hsljava.lang.String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHsljavaLangString() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsljava.lang.String"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hsljpeg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHsljpeg() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsljpeg"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hsljpg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHsljpg() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsljpg"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslpng}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslpng() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslpng"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslrgb}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslrgb() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslrgb"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslsvg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslsvg() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslsvg"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslsvg+xml}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslsvgXml() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslsvg+xml"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslwidth}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenHslwidth() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslwidth"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code #}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenNumberSign() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("#"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgb}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgb() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb"));
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb#"));
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb,"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgb[^0-9,]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgb09() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb[^0-9,]"));
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb[^0-9.,]"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgb42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgb42() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb42"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbColor Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbColorStr() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbColor Str"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbFailed to generate embedded image for color: {}}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbFailedToGenerateEmbeddedImageForColor() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbFailed to generate embedded image for color: {}"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When
   * {@code rgb(?s)<tb:metadata[^>]*><!\[CDATA\[(.*)]]><\/tb:metadata>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbSTbMetadataCdataTbMetadata() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb(?s)<tb:metadata[^>]*><!\\[CDATA\\[(.*)]]><\\/tb:metadata>"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbU}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbU() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbU"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbheight}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbheight() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbheight"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbhsl}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbhsl() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbhsl"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbico}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbico() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbico"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbimage}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbimage() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbimage"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbimage/png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbimagePng() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbimage/png"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbjava.awt.Component}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbjavaAwtComponent() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbjava.awt.Component"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbjava.lang.String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbjavaLangString() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbjava.lang.String"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbjpeg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbjpeg() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbjpeg"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbjpg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbjpg() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbjpg"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbpng}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbpng() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbpng"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbrgb}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbrgb() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbrgb"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbsvg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbsvg() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbsvg"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbsvg+xml}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbsvgXml() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbsvg+xml"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbwidth}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  public void testGetEmbeddedBase64EncodedImg_whenRgbwidth() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbwidth"));
  }
}
