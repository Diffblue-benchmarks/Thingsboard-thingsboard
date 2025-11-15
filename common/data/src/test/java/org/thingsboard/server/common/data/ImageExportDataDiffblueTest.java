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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ImageExportDataDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImageExportData#equals(Object)}
   *   <li>{@link ImageExportData#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link ImageExportData#equals(Object)}
   *   <li>{@link ImageExportData#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.fileName(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.mediaType(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.mediaType(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.mediaType(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImageExportData.ImageExportDataBuilder builderResult = ImageExportData.builder();
    builderResult.mediaType("Media Type");
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.mediaType(Mockito.<String>any())).thenReturn(builderResult);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.publicResourceKey(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.resourceKey(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.subType(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.title(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.subType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder6.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder5);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder7 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.title(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.subType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder6.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder5);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder7 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ImageExportData.ImageExportDataBuilder builderResult = ImageExportData.builder();
    builderResult.fileName("foo.txt");
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.title(Mockito.<String>any())).thenReturn(builderResult);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.subType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder6.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder5);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder7 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.title(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.subType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder6.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder5);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder7 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ImageExportData.ImageExportDataBuilder builderResult = ImageExportData.builder();
    builderResult.title("Dr");
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.title(Mockito.<String>any())).thenReturn(builderResult);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.subType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder6.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder5);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder7 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder.title(Mockito.<String>any())).thenReturn(ImageExportData.builder());
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder2 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder2.subType(Mockito.<String>any())).thenReturn(imageExportDataBuilder);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder3 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder3.resourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder2);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder4 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder4.publicResourceKey(Mockito.<String>any())).thenReturn(imageExportDataBuilder3);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder5 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder5.mediaType(Mockito.<String>any())).thenReturn(imageExportDataBuilder4);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder6 = mock(ImageExportData.ImageExportDataBuilder.class);
    when(imageExportDataBuilder6.fileName(Mockito.<String>any())).thenReturn(imageExportDataBuilder5);
    ImageExportData.ImageExportDataBuilder imageExportDataBuilder7 = mock(ImageExportData.ImageExportDataBuilder.class);
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
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
   * Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
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

    // Assert that nothing has changed
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
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ImageExportData#ImageExportData(String, String, String, String, String, boolean, String, String)}
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
  void testGettersAndSetters2() {
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

    // Assert that nothing has changed
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
   * Methods under test:
   * <ul>
   *   <li>{@link ImageExportData.ImageExportDataBuilder#build()}
   *   <li>{@link ImageExportData.ImageExportDataBuilder#data(String)}
   *   <li>{@link ImageExportData.ImageExportDataBuilder#fileName(String)}
   *   <li>{@link ImageExportData.ImageExportDataBuilder#mediaType(String)}
   *   <li>{@link ImageExportData.ImageExportDataBuilder#publicResourceKey(String)}
   *   <li>{@link ImageExportData.ImageExportDataBuilder#resourceKey(String)}
   *   <li>{@link ImageExportData.ImageExportDataBuilder#subType(String)}
   *   <li>{@link ImageExportData.ImageExportDataBuilder#title(String)}
   * </ul>
   */
  @Test
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
