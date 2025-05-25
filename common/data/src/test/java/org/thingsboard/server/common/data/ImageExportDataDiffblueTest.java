package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.ImageExportData.ImageExportDataBuilder;

@ContextConfiguration(classes = {ImageExportDataBuilder.class})
@ExtendWith(SpringExtension.class)
class ImageExportDataDiffblueTest {
  @Autowired
  private ImageExportDataBuilder imageExportDataBuilder;

  /**
   * Test {@link ImageExportData#equals(Object)}, and {@link ImageExportData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageExportData#equals(Object)}
   *   <li>{@link ImageExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImageExportData buildResult = ImageExportData.builder()
        .data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}, and {@link ImageExportData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageExportData#equals(Object)}
   *   <li>{@link ImageExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImageExportData buildResult = ImageExportData.builder()
        .data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.data(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportData buildResult = imageExportDataBuilder.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.fileName(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData buildResult = imageExportDataBuilder2.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.mediaType(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportData buildResult = imageExportDataBuilder3.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.mediaType(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportData buildResult = imageExportDataBuilder3.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName("foo.txt")
        .mediaType(null)
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.mediaType(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportData buildResult = imageExportDataBuilder3.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName(null)
        .mediaType(null)
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImageExportDataBuilder builderResult = ImageExportData.builder();
    builderResult.mediaType("Media Type");
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.mediaType(Mockito.<String>any())).thenReturn(builderResult);
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportData buildResult = imageExportDataBuilder3.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName("foo.txt")
        .mediaType(null)
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.publicResourceKey(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportData buildResult = imageExportDataBuilder4.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName(null)
        .mediaType(null)
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.resourceKey(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportData buildResult = imageExportDataBuilder5.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName(null)
        .mediaType(null)
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.subType(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder6.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder5);
    ImageExportData buildResult = imageExportDataBuilder6.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName(null)
        .mediaType(null)
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.title(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.subType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder6.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder5);
    ImageExportDataBuilder imageExportDataBuilder7 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder7.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder6);
    ImageExportData buildResult = imageExportDataBuilder7.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName(null)
        .mediaType(null)
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.title(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.subType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder6.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder5);
    ImageExportDataBuilder imageExportDataBuilder7 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder7.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder6);
    ImageExportData buildResult = imageExportDataBuilder7.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName(null)
        .mediaType(null)
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ImageExportDataBuilder builderResult = ImageExportData.builder();
    builderResult.fileName("foo.txt");
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.title(Mockito.<String>any())).thenReturn(builderResult);
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.subType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder6.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder5);
    ImageExportDataBuilder imageExportDataBuilder7 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder7.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder6);
    ImageExportData buildResult = imageExportDataBuilder7.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName(null)
        .mediaType(null)
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.title(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.subType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder6.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder5);
    ImageExportDataBuilder imageExportDataBuilder7 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder7.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder6);
    ImageExportData buildResult = imageExportDataBuilder7.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName(null)
        .mediaType(null)
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType(null)
        .title(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ImageExportDataBuilder builderResult = ImageExportData.builder();
    builderResult.title("Dr");
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.title(Mockito.<String>any())).thenReturn(builderResult);
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.subType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder6.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder5);
    ImageExportDataBuilder imageExportDataBuilder7 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder7.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder6);
    ImageExportData buildResult = imageExportDataBuilder7.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName(null)
        .mediaType(null)
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder.title(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.subType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder6.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder5);
    ImageExportDataBuilder imageExportDataBuilder7 = mock(ImageExportDataBuilder.class);
    when(imageExportDataBuilder7.data(Mockito.<String>any())).thenReturn(imageExportDataBuilder6);
    ImageExportData buildResult = imageExportDataBuilder7.data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();
    ImageExportData buildResult2 = ImageExportData.builder()
        .data("Data")
        .fileName(null)
        .mediaType(null)
        .publicResourceKey("Public Resource Key")
        .resourceKey(null)
        .subType(null)
        .title(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImageExportData buildResult = ImageExportData.builder()
        .data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImageExportData buildResult = ImageExportData.builder()
        .data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ImageExportData");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageExportData#ImageExportData()}
   *   <li>{@link ImageExportData#setData(String)}
   *   <li>{@link ImageExportData#setFileName(String)}
   *   <li>{@link ImageExportData#setMediaType(String)}
   *   <li>{@link ImageExportData#setPublic(boolean)}
   *   <li>{@link ImageExportData#setPublicResourceKey(String)}
   *   <li>{@link ImageExportData#setResourceKey(String)}
   *   <li>{@link ImageExportData#setSubType(String)}
   *   <li>{@link ImageExportData#setTitle(String)}
   *   <li>{@link ImageExportData#toString()}
   *   <li>{@link ImageExportData#getData()}
   *   <li>{@link ImageExportData#getFileName()}
   *   <li>{@link ImageExportData#getMediaType()}
   *   <li>{@link ImageExportData#getPublicResourceKey()}
   *   <li>{@link ImageExportData#getResourceKey()}
   *   <li>{@link ImageExportData#getSubType()}
   *   <li>{@link ImageExportData#getTitle()}
   *   <li>{@link ImageExportData#isPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImageExportData.<init>()",
      "void ImageExportData.<init>(String, String, String, String, String, boolean, String, String)",
      "String ImageExportData.getData()", "String ImageExportData.getFileName()",
      "String ImageExportData.getMediaType()", "String ImageExportData.getPublicResourceKey()",
      "String ImageExportData.getResourceKey()", "String ImageExportData.getSubType()",
      "String ImageExportData.getTitle()", "boolean ImageExportData.isPublic()", "void ImageExportData.setData(String)",
      "void ImageExportData.setFileName(String)", "void ImageExportData.setMediaType(String)",
      "void ImageExportData.setPublic(boolean)", "void ImageExportData.setPublicResourceKey(String)",
      "void ImageExportData.setResourceKey(String)", "void ImageExportData.setSubType(String)",
      "void ImageExportData.setTitle(String)", "String ImageExportData.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ImageExportData actualImageExportData = new ImageExportData();
    actualImageExportData.setData("Data");
    actualImageExportData.setFileName("foo.txt");
    actualImageExportData.setMediaType("Media Type");
    actualImageExportData.setPublic(true);
    actualImageExportData.setPublicResourceKey("Public Resource Key");
    actualImageExportData.setResourceKey("Resource Key");
    actualImageExportData.setSubType("Sub Type");
    actualImageExportData.setTitle("Dr");
    String actualToStringResult = actualImageExportData.toString();
    String actualData = actualImageExportData.getData();
    String actualFileName = actualImageExportData.getFileName();
    String actualMediaType = actualImageExportData.getMediaType();
    String actualPublicResourceKey = actualImageExportData.getPublicResourceKey();
    String actualResourceKey = actualImageExportData.getResourceKey();
    String actualSubType = actualImageExportData.getSubType();
    String actualTitle = actualImageExportData.getTitle();

    // Assert
    assertEquals("Data", actualData);
    assertEquals("Dr", actualTitle);
    assertEquals(
        "ImageExportData(mediaType=Media Type, fileName=foo.txt, title=Dr, subType=Sub Type, resourceKey=Resource"
            + " Key, isPublic=true, publicResourceKey=Public Resource Key, data=Data)",
        actualToStringResult);
    assertEquals("Media Type", actualMediaType);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("Sub Type", actualSubType);
    assertEquals("foo.txt", actualFileName);
    assertTrue(actualImageExportData.isPublic());
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@code Media Type}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageExportData#ImageExportData(String, String, String, String, String, boolean, String, String)}
   *   <li>{@link ImageExportData#setData(String)}
   *   <li>{@link ImageExportData#setFileName(String)}
   *   <li>{@link ImageExportData#setMediaType(String)}
   *   <li>{@link ImageExportData#setPublic(boolean)}
   *   <li>{@link ImageExportData#setPublicResourceKey(String)}
   *   <li>{@link ImageExportData#setResourceKey(String)}
   *   <li>{@link ImageExportData#setSubType(String)}
   *   <li>{@link ImageExportData#setTitle(String)}
   *   <li>{@link ImageExportData#toString()}
   *   <li>{@link ImageExportData#getData()}
   *   <li>{@link ImageExportData#getFileName()}
   *   <li>{@link ImageExportData#getMediaType()}
   *   <li>{@link ImageExportData#getPublicResourceKey()}
   *   <li>{@link ImageExportData#getResourceKey()}
   *   <li>{@link ImageExportData#getSubType()}
   *   <li>{@link ImageExportData#getTitle()}
   *   <li>{@link ImageExportData#isPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Media Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImageExportData.<init>()",
      "void ImageExportData.<init>(String, String, String, String, String, boolean, String, String)",
      "String ImageExportData.getData()", "String ImageExportData.getFileName()",
      "String ImageExportData.getMediaType()", "String ImageExportData.getPublicResourceKey()",
      "String ImageExportData.getResourceKey()", "String ImageExportData.getSubType()",
      "String ImageExportData.getTitle()", "boolean ImageExportData.isPublic()", "void ImageExportData.setData(String)",
      "void ImageExportData.setFileName(String)", "void ImageExportData.setMediaType(String)",
      "void ImageExportData.setPublic(boolean)", "void ImageExportData.setPublicResourceKey(String)",
      "void ImageExportData.setResourceKey(String)", "void ImageExportData.setSubType(String)",
      "void ImageExportData.setTitle(String)", "String ImageExportData.toString()"})
  void testGettersAndSetters_whenMediaType() {
    // Arrange and Act
    ImageExportData actualImageExportData = new ImageExportData("Media Type", "foo.txt", "Dr", "Sub Type",
        "Resource Key", true, "Public Resource Key", "Data");
    actualImageExportData.setData("Data");
    actualImageExportData.setFileName("foo.txt");
    actualImageExportData.setMediaType("Media Type");
    actualImageExportData.setPublic(true);
    actualImageExportData.setPublicResourceKey("Public Resource Key");
    actualImageExportData.setResourceKey("Resource Key");
    actualImageExportData.setSubType("Sub Type");
    actualImageExportData.setTitle("Dr");
    String actualToStringResult = actualImageExportData.toString();
    String actualData = actualImageExportData.getData();
    String actualFileName = actualImageExportData.getFileName();
    String actualMediaType = actualImageExportData.getMediaType();
    String actualPublicResourceKey = actualImageExportData.getPublicResourceKey();
    String actualResourceKey = actualImageExportData.getResourceKey();
    String actualSubType = actualImageExportData.getSubType();
    String actualTitle = actualImageExportData.getTitle();

    // Assert
    assertEquals("Data", actualData);
    assertEquals("Dr", actualTitle);
    assertEquals(
        "ImageExportData(mediaType=Media Type, fileName=foo.txt, title=Dr, subType=Sub Type, resourceKey=Resource"
            + " Key, isPublic=true, publicResourceKey=Public Resource Key, data=Data)",
        actualToStringResult);
    assertEquals("Media Type", actualMediaType);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("Sub Type", actualSubType);
    assertEquals("foo.txt", actualFileName);
    assertTrue(actualImageExportData.isPublic());
  }

  /**
   * Test ImageExportDataBuilder {@link ImageExportDataBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImageExportDataBuilder#build()}
   *   <li>{@link ImageExportDataBuilder#data(String)}
   *   <li>{@link ImageExportDataBuilder#fileName(String)}
   *   <li>{@link ImageExportDataBuilder#mediaType(String)}
   *   <li>{@link ImageExportDataBuilder#publicResourceKey(String)}
   *   <li>{@link ImageExportDataBuilder#resourceKey(String)}
   *   <li>{@link ImageExportDataBuilder#subType(String)}
   *   <li>{@link ImageExportDataBuilder#title(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test ImageExportDataBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImageExportDataBuilder.<init>()", "ImageExportData ImageExportDataBuilder.build()",
      "ImageExportDataBuilder ImageExportDataBuilder.data(String)",
      "ImageExportDataBuilder ImageExportDataBuilder.fileName(String)",
      "ImageExportDataBuilder ImageExportDataBuilder.isPublic(boolean)",
      "ImageExportDataBuilder ImageExportDataBuilder.mediaType(String)",
      "ImageExportDataBuilder ImageExportDataBuilder.publicResourceKey(String)",
      "ImageExportDataBuilder ImageExportDataBuilder.resourceKey(String)",
      "ImageExportDataBuilder ImageExportDataBuilder.subType(String)",
      "ImageExportDataBuilder ImageExportDataBuilder.title(String)", "String ImageExportDataBuilder.toString()"})
  void testImageExportDataBuilderBuild() {
    // Arrange and Act
    ImageExportData actualBuildResult = ImageExportData.builder()
        .data("Data")
        .fileName("foo.txt")
        .mediaType("Media Type")
        .publicResourceKey("Public Resource Key")
        .resourceKey("Resource Key")
        .subType("Sub Type")
        .title("Dr")
        .build();

    // Assert
    assertEquals("Data", actualBuildResult.getData());
    assertEquals("Dr", actualBuildResult.getTitle());
    assertEquals("Media Type", actualBuildResult.getMediaType());
    assertEquals("Public Resource Key", actualBuildResult.getPublicResourceKey());
    assertEquals("Resource Key", actualBuildResult.getResourceKey());
    assertEquals("Sub Type", actualBuildResult.getSubType());
    assertEquals("foo.txt", actualBuildResult.getFileName());
    assertFalse(actualBuildResult.isPublic());
  }
}
