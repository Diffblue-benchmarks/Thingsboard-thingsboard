package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
   * <ul>
   *   <li>When {@code image/png}.</li>
   *   <li>Then return {@code png}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#mediaTypeToFileExtension(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.mediaTypeToFileExtension(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.fileExtensionToMediaType(String)"})
  public void testFileExtensionToMediaType_whenExtension_thenReturnImageExtension() {
    // Arrange, Act and Assert
    assertEquals("image/extension", ImageUtils.fileExtensionToMediaType("Extension"));
  }

  /**
   * Test {@link ImageUtils#fileExtensionToMediaType(String)}.
   * <ul>
   *   <li>When {@code ico}.</li>
   *   <li>Then return {@code image/x-icon}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#fileExtensionToMediaType(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.fileExtensionToMediaType(String)"})
  public void testFileExtensionToMediaType_whenIco_thenReturnImageXIcon() {
    // Arrange, Act and Assert
    assertEquals("image/x-icon", ImageUtils.fileExtensionToMediaType("ico"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessedImage ImageUtils.processSvgImage(byte[], String, int)"})
  public void testProcessSvgImage_thenReturnPreviewMediaTypeIsMediaType() throws Exception {
    // Arrange and Act
    ProcessedImage actualProcessSvgImageResult = ImageUtils.processSvgImage("AXAXAXAX".getBytes("UTF-8"), "Media Type",
        1);

    // Assert
    ProcessedImage preview = actualProcessSvgImageResult.getPreview();
    assertEquals("Media Type", preview.getMediaType());
    assertEquals("Media Type", actualProcessSvgImageResult.getMediaType());
    assertNull(preview.getPreview());
    assertEquals(0, preview.getHeight());
    assertEquals(0, actualProcessSvgImageResult.getHeight());
    assertEquals(0, preview.getWidth());
    assertEquals(0, actualProcessSvgImageResult.getWidth());
    assertEquals(8L, preview.getSize());
    assertEquals(8L, actualProcessSvgImageResult.getSize());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, preview.getData());
    byte[] expectedData2 = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData2, actualProcessSvgImageResult.getData());
  }

  /**
   * Test ProcessedImage getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ProcessedImage#ProcessedImage()}
   *   <li>{@link ProcessedImage#setData(byte[])}
   *   <li>{@link ProcessedImage#setHeight(int)}
   *   <li>{@link ProcessedImage#setMediaType(String)}
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProcessedImage.<init>()", "byte[] ProcessedImage.getData()",
      "int ProcessedImage.getHeight()", "String ProcessedImage.getMediaType()",
      "ProcessedImage ProcessedImage.getPreview()", "long ProcessedImage.getSize()", "int ProcessedImage.getWidth()",
      "void ProcessedImage.setData(byte[])", "void ProcessedImage.setHeight(int)",
      "void ProcessedImage.setMediaType(String)", "void ProcessedImage.setPreview(ProcessedImage)",
      "void ProcessedImage.setSize(long)", "void ProcessedImage.setWidth(int)", "String ProcessedImage.toString()"})
  public void testProcessedImageGettersAndSetters() throws UnsupportedEncodingException {
    // Arrange and Act
    ProcessedImage actualProcessedImage = new ProcessedImage();
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    actualProcessedImage.setData(data);
    actualProcessedImage.setHeight(1);
    actualProcessedImage.setMediaType("Media Type");
    actualProcessedImage.setSize(3L);
    actualProcessedImage.setWidth(1);
    String actualToStringResult = actualProcessedImage.toString();
    byte[] actualData = actualProcessedImage.getData();
    int actualHeight = actualProcessedImage.getHeight();
    String actualMediaType = actualProcessedImage.getMediaType();
    ProcessedImage actualPreview = actualProcessedImage.getPreview();
    long actualSize = actualProcessedImage.getSize();

    // Assert
    assertEquals("ImageUtils.ProcessedImage(mediaType=Media Type, width=1, height=1, data=[65, 88, 65, 88, 65, 88, 65,"
        + " 88], size=3, preview=null)", actualToStringResult);
    assertEquals("Media Type", actualMediaType);
    assertNull(actualPreview);
    assertEquals(1, actualHeight);
    assertEquals(1, actualProcessedImage.getWidth());
    assertEquals(3L, actualSize);
    assertSame(data, actualData);
    assertArrayEquals("AXAXAXAX".getBytes("UTF-8"), actualData);
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#ProcessedImage(String, int, int, byte[], long, ProcessedImage)}.
   * <ul>
   *   <li>When {@link ProcessedImage#ProcessedImage()}.</li>
   *   <li>Then return {@code Media Type}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessedImage#ProcessedImage(String, int, int, byte[], long, ProcessedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ProcessedImage.<init>(String, int, int, byte[], long, ProcessedImage)"})
  public void testProcessedImageNewProcessedImage_whenProcessedImage_thenReturnMediaType()
      throws UnsupportedEncodingException {
    // Arrange
    byte[] data = "AXAXAXAX".getBytes("UTF-8");
    ProcessedImage preview = new ProcessedImage();

    // Act
    ProcessedImage actualProcessedImage = new ProcessedImage("Media Type", 1, 1, data, 3L, preview);

    // Assert
    assertEquals("Media Type", actualProcessedImage.getMediaType());
    assertEquals(1, actualProcessedImage.getHeight());
    assertEquals(1, actualProcessedImage.getWidth());
    assertEquals(3L, actualProcessedImage.getSize());
    assertSame(preview, actualProcessedImage.getPreview());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualProcessedImage.getData());
  }

  /**
   * Test ProcessedImage {@link ProcessedImage#withData(byte[])}.
   * <ul>
   *   <li>Given {@link ProcessedImage#ProcessedImage()}.</li>
   *   <li>Then return MediaType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ProcessedImage#withData(byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessedImage ProcessedImage.withData(byte[])"})
  public void testProcessedImageWithData_givenProcessedImage_thenReturnMediaTypeIsNull()
      throws UnsupportedEncodingException {
    // Arrange
    ProcessedImage processedImage = new ProcessedImage();

    // Act
    ProcessedImage actualWithDataResult = processedImage.withData("AXAXAXAX".getBytes("UTF-8"));

    // Assert
    assertNull(actualWithDataResult.getMediaType());
    assertNull(actualWithDataResult.getPreview());
    assertEquals(0, actualWithDataResult.getHeight());
    assertEquals(0, actualWithDataResult.getWidth());
    assertEquals(0L, actualWithDataResult.getSize());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, actualWithDataResult.getData());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}, and {@link ScadaSymbolMetadataInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ScadaSymbolMetadataInfo#equals(Object)}
   *   <li>{@link ScadaSymbolMetadataInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScadaSymbolMetadataInfo.equals(Object)", "int ScadaSymbolMetadataInfo.hashCode()"})
  public void testScadaSymbolMetadataInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils.processScadaSymbolMetadata("foo.txt",
        "AXAXAXAX".getBytes("UTF-8"));
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult2 = ImageUtils.processScadaSymbolMetadata("foo.txt",
        "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(processScadaSymbolMetadataResult, processScadaSymbolMetadataResult2);
    int expectedHashCodeResult = processScadaSymbolMetadataResult.hashCode();
    assertEquals(expectedHashCodeResult, processScadaSymbolMetadataResult2.hashCode());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}, and {@link ScadaSymbolMetadataInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ScadaSymbolMetadataInfo#equals(Object)}
   *   <li>{@link ScadaSymbolMetadataInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScadaSymbolMetadataInfo.equals(Object)", "int ScadaSymbolMetadataInfo.hashCode()"})
  public void testScadaSymbolMetadataInfoEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils.processScadaSymbolMetadata(null,
        "AXAXAXAX".getBytes("UTF-8"));
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult2 = ImageUtils.processScadaSymbolMetadata(null,
        "AXAXAXAX".getBytes("UTF-8"));

    // Act and Assert
    assertEquals(processScadaSymbolMetadataResult, processScadaSymbolMetadataResult2);
    int expectedHashCodeResult = processScadaSymbolMetadataResult.hashCode();
    assertEquals(expectedHashCodeResult, processScadaSymbolMetadataResult2.hashCode());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#equals(Object)}, and {@link ScadaSymbolMetadataInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ScadaSymbolMetadataInfo#equals(Object)}
   *   <li>{@link ScadaSymbolMetadataInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScadaSymbolMetadataInfo.equals(Object)", "int ScadaSymbolMetadataInfo.hashCode()"})
  public void testScadaSymbolMetadataInfoEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils.processScadaSymbolMetadata("foo.txt",
        "AXAXAXAX".getBytes("UTF-8"));

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
   * Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScadaSymbolMetadataInfo.equals(Object)", "int ScadaSymbolMetadataInfo.hashCode()"})
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual() throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils.processScadaSymbolMetadata("File Name",
        "AXAXAXAX".getBytes("UTF-8"));

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
   * Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScadaSymbolMetadataInfo.equals(Object)", "int ScadaSymbolMetadataInfo.hashCode()"})
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual2() throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils.processScadaSymbolMetadata(null,
        "AXAXAXAX".getBytes("UTF-8"));

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
   * Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScadaSymbolMetadataInfo.equals(Object)", "int ScadaSymbolMetadataInfo.hashCode()"})
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual3() throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils.processScadaSymbolMetadata("foo.txt",
        "AXAXAXAX".getBytes("UTF-8"));
    processScadaSymbolMetadataResult.setDescription("The characteristics of someone or something");

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
   * Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScadaSymbolMetadataInfo.equals(Object)", "int ScadaSymbolMetadataInfo.hashCode()"})
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual4() throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils.processScadaSymbolMetadata("foo.txt",
        "AXAXAXAX".getBytes("UTF-8"));
    processScadaSymbolMetadataResult.setSearchTags(new String[]{"foo.txt"});

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
   * Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScadaSymbolMetadataInfo.equals(Object)", "int ScadaSymbolMetadataInfo.hashCode()"})
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual5() throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils.processScadaSymbolMetadata("foo.txt",
        "AXAXAXAX".getBytes("UTF-8"));
    processScadaSymbolMetadataResult.setWidgetSizeX(1);

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
   * Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScadaSymbolMetadataInfo.equals(Object)", "int ScadaSymbolMetadataInfo.hashCode()"})
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual6() throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils.processScadaSymbolMetadata("foo.txt",
        "AXAXAXAX".getBytes("UTF-8"));
    processScadaSymbolMetadataResult.setWidgetSizeY(1);

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
   * Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScadaSymbolMetadataInfo.equals(Object)", "int ScadaSymbolMetadataInfo.hashCode()"})
  public void testScadaSymbolMetadataInfoEquals_whenOtherIsDifferent_thenReturnNotEqual7() throws Exception {
    // Arrange
    ScadaSymbolMetadataInfo processScadaSymbolMetadataResult = ImageUtils.processScadaSymbolMetadata("foo.txt",
        "AXAXAXAX".getBytes("UTF-8"));
    processScadaSymbolMetadataResult.setDescription(null);

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
   * Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScadaSymbolMetadataInfo.equals(Object)", "int ScadaSymbolMetadataInfo.hashCode()"})
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
   * Method under test: {@link ScadaSymbolMetadataInfo#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ScadaSymbolMetadataInfo.equals(Object)", "int ScadaSymbolMetadataInfo.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ScadaSymbolMetadataInfo.getDescription()",
      "String[] ScadaSymbolMetadataInfo.getSearchTags()", "String ScadaSymbolMetadataInfo.getTitle()",
      "int ScadaSymbolMetadataInfo.getWidgetSizeX()", "int ScadaSymbolMetadataInfo.getWidgetSizeY()",
      "void ScadaSymbolMetadataInfo.setDescription(String)", "void ScadaSymbolMetadataInfo.setSearchTags(String[])",
      "void ScadaSymbolMetadataInfo.setTitle(String)", "void ScadaSymbolMetadataInfo.setWidgetSizeX(int)",
      "void ScadaSymbolMetadataInfo.setWidgetSizeY(int)", "String ScadaSymbolMetadataInfo.toString()"})
  public void testScadaSymbolMetadataInfoGettersAndSetters() {
    // Arrange
    ScadaSymbolMetadataInfo scadaSymbolMetadataInfo = new ScadaSymbolMetadataInfo("foo.txt",
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

    // Assert
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
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}.
   * <p>
   * Method under test: {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ScadaSymbolMetadataInfo.<init>(String, JsonNode)"})
  public void testScadaSymbolMetadataInfoNewScadaSymbolMetadataInfo() {
    // Arrange and Act
    ScadaSymbolMetadataInfo actualScadaSymbolMetadataInfo = new ScadaSymbolMetadataInfo("foo.txt",
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Assert
    assertEquals("", actualScadaSymbolMetadataInfo.getDescription());
    assertEquals("foo.txt", actualScadaSymbolMetadataInfo.getTitle());
    assertEquals(0, actualScadaSymbolMetadataInfo.getSearchTags().length);
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeX());
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeY());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}.
   * <p>
   * Method under test: {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ScadaSymbolMetadataInfo.<init>(String, JsonNode)"})
  public void testScadaSymbolMetadataInfoNewScadaSymbolMetadataInfo2() {
    // Arrange and Act
    ScadaSymbolMetadataInfo actualScadaSymbolMetadataInfo = new ScadaSymbolMetadataInfo("foo.txt",
        new ArrayNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Assert
    assertEquals("", actualScadaSymbolMetadataInfo.getDescription());
    assertEquals("foo.txt", actualScadaSymbolMetadataInfo.getTitle());
    assertEquals(0, actualScadaSymbolMetadataInfo.getSearchTags().length);
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeX());
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeY());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}.
   * <p>
   * Method under test: {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ScadaSymbolMetadataInfo.<init>(String, JsonNode)"})
  public void testScadaSymbolMetadataInfoNewScadaSymbolMetadataInfo3() {
    // Arrange and Act
    ScadaSymbolMetadataInfo actualScadaSymbolMetadataInfo = new ScadaSymbolMetadataInfo("foo.txt",
        new BigIntegerNode(BigInteger.valueOf(3L)));

    // Assert
    assertEquals("", actualScadaSymbolMetadataInfo.getDescription());
    assertEquals("foo.txt", actualScadaSymbolMetadataInfo.getTitle());
    assertEquals(0, actualScadaSymbolMetadataInfo.getSearchTags().length);
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeX());
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeY());
  }

  /**
   * Test ScadaSymbolMetadataInfo {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ScadaSymbolMetadataInfo#ScadaSymbolMetadataInfo(String, JsonNode)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ScadaSymbolMetadataInfo.<init>(String, JsonNode)"})
  public void testScadaSymbolMetadataInfoNewScadaSymbolMetadataInfo_whenNull() {
    // Arrange and Act
    ScadaSymbolMetadataInfo actualScadaSymbolMetadataInfo = new ScadaSymbolMetadataInfo("foo.txt", null);

    // Assert
    assertEquals("", actualScadaSymbolMetadataInfo.getDescription());
    assertEquals("foo.txt", actualScadaSymbolMetadataInfo.getTitle());
    assertEquals(0, actualScadaSymbolMetadataInfo.getSearchTags().length);
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeX());
    assertEquals(3, actualScadaSymbolMetadataInfo.getWidgetSizeY());
  }

  /**
   * Test {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage)} with {@code originalImage}.
   * <p>
   * Method under test: {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessedImage ImageUtils.withPreviewAsOriginalImage(ProcessedImage)"})
  public void testWithPreviewAsOriginalImageWithOriginalImage() throws Exception {
    // Arrange and Act
    ProcessedImage actualWithPreviewAsOriginalImageResult = ImageUtils
        .withPreviewAsOriginalImage(ImageUtils.processSvgImage("AXAXAXAX".getBytes("UTF-8"), "Media Type", 1));

    // Assert
    ProcessedImage preview = actualWithPreviewAsOriginalImageResult.getPreview();
    ProcessedImage preview2 = preview.getPreview();
    assertEquals("Media Type", preview2.getMediaType());
    assertEquals("Media Type", preview.getMediaType());
    assertEquals("Media Type", actualWithPreviewAsOriginalImageResult.getMediaType());
    assertNull(preview.getData());
    assertNull(preview2.getPreview());
    assertEquals(0, preview2.getHeight());
    assertEquals(0, preview.getHeight());
    assertEquals(0, preview2.getWidth());
    assertEquals(0, preview.getWidth());
    assertEquals(8L, preview2.getSize());
    assertEquals(8L, preview.getSize());
    assertEquals(8L, actualWithPreviewAsOriginalImageResult.getSize());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, preview2.getData());
    byte[] expectedData2 = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData2, actualWithPreviewAsOriginalImageResult.getData());
  }

  /**
   * Test {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage, byte[])} with {@code originalImage}, {@code previewData}.
   * <p>
   * Method under test: {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessedImage ImageUtils.withPreviewAsOriginalImage(ProcessedImage, byte[])"})
  public void testWithPreviewAsOriginalImageWithOriginalImagePreviewData() throws UnsupportedEncodingException {
    // Arrange
    ProcessedImage originalImage = new ProcessedImage();

    // Act and Assert
    ProcessedImage preview = ImageUtils.withPreviewAsOriginalImage(originalImage, "AXAXAXAX".getBytes("UTF-8"))
        .getPreview();
    assertNull(preview.getMediaType());
    assertNull(preview.getPreview());
    assertEquals(0, preview.getHeight());
    assertEquals(0, preview.getWidth());
    assertEquals(8L, preview.getSize());
    byte[] expectedData = "AXAXAXAX".getBytes("UTF-8");
    assertArrayEquals(expectedData, preview.getData());
  }

  /**
   * Test {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage, byte[])} with {@code originalImage}, {@code previewData}.
   * <ul>
   *   <li>Then return Data is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessedImage ImageUtils.withPreviewAsOriginalImage(ProcessedImage, byte[])"})
  public void testWithPreviewAsOriginalImageWithOriginalImagePreviewData_thenReturnDataIsNull() {
    // Arrange
    ProcessedImage originalImage = new ProcessedImage();

    // Act
    ProcessedImage actualWithPreviewAsOriginalImageResult = ImageUtils.withPreviewAsOriginalImage(originalImage, null);

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
   * Test {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage)} with {@code originalImage}.
   * <ul>
   *   <li>Then return Data is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#withPreviewAsOriginalImage(ProcessedImage)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ProcessedImage ImageUtils.withPreviewAsOriginalImage(ProcessedImage)"})
  public void testWithPreviewAsOriginalImageWithOriginalImage_thenReturnDataIsNull() {
    // Arrange
    ProcessedImage originalImage = new ProcessedImage();

    // Act
    ProcessedImage actualWithPreviewAsOriginalImageResult = ImageUtils.withPreviewAsOriginalImage(originalImage);

    // Assert
    assertNull(actualWithPreviewAsOriginalImageResult.getData());
    assertNull(actualWithPreviewAsOriginalImageResult.getMediaType());
    assertEquals(0L, actualWithPreviewAsOriginalImageResult.getSize());
    assertSame(originalImage, originalImage.getPreview());
    assertSame(actualWithPreviewAsOriginalImageResult, actualWithPreviewAsOriginalImageResult.getPreview());
  }

  /**
   * Test {@link ImageUtils#processScadaSymbolMetadata(String, byte[])}.
   * <p>
   * Method under test: {@link ImageUtils#processScadaSymbolMetadata(String, byte[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ScadaSymbolMetadataInfo ImageUtils.processScadaSymbolMetadata(String, byte[])"})
  public void testProcessScadaSymbolMetadata() throws Exception {
    // Arrange and Act
    ScadaSymbolMetadataInfo actualProcessScadaSymbolMetadataResult = ImageUtils.processScadaSymbolMetadata("foo.txt",
        "AXAXAXAX".getBytes("UTF-8"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"byte[] ImageUtils.removeScadaSymbolMetadata(byte[])"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsl() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hsl#}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsl2() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl#"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hsl,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsl3() {
    // Arrange, Act and Assert
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsl09() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl[^0-9.,]"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsl42() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl42"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hsl[^0-9,]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsl092() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsl[^0-9,]"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHslFailedToGenerateEmbeddedImageForColor() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hslFailed to generate embedded image for color: {}"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hsl(?s)<tb:metadata[^>]*><!\[CDATA\[(.*)]]><\/tb:metadata>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenHsljavaAwtComponent() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("hsljava.awt.Component"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code hslString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgb() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgb#}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgb2() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb#"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgb,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgb3() {
    // Arrange, Act and Assert
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgb09() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb[^0-9,]"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgb42() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb42"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgb[^0-9.,]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgb092() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgb[^0-9.,]"));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbFailedToGenerateEmbeddedImageForColor() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbFailed to generate embedded image for color: {}"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgb(?s)<tb:metadata[^>]*><!\[CDATA\[(.*)]]><\/tb:metadata>}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbjavaAwtComponent() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbjava.awt.Component"));
  }

  /**
   * Test {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}.
   * <ul>
   *   <li>When {@code rgbString}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageUtils#getEmbeddedBase64EncodedImg(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String ImageUtils.getEmbeddedBase64EncodedImg(String)"})
  public void testGetEmbeddedBase64EncodedImg_whenRgbwidth() {
    // Arrange, Act and Assert
    assertNull(ImageUtils.getEmbeddedBase64EncodedImg("rgbwidth"));
  }
}
