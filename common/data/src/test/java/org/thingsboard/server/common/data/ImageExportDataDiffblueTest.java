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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.ImageExportData.ImageExportDataBuilder;

@ContextConfiguration(classes = {ImageExportDataBuilder.class})
@ExtendWith(SpringExtension.class)
class ImageExportDataDiffblueTest {
  @Autowired private ImageExportDataBuilder imageExportDataBuilder;

  /**
   * Test {@link ImageExportData#equals(Object)}, and {@link ImageExportData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImageExportData#equals(Object)}
   *   <li>{@link ImageExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();
    ImageExportData imageExportData2 =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertEquals(imageExportData, imageExportData2);
    assertEquals(imageExportData.hashCode(), imageExportData2.hashCode());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}, and {@link ImageExportData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImageExportData#equals(Object)}
   *   <li>{@link ImageExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data(null)
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();
    ImageExportData imageExportData2 =
        ImageExportData.builder()
            .data(null)
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertEquals(imageExportData, imageExportData2);
    assertEquals(imageExportData.hashCode(), imageExportData2.hashCode());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}, and {@link ImageExportData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImageExportData#equals(Object)}
   *   <li>{@link ImageExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName(null)
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();
    ImageExportData imageExportData2 =
        ImageExportData.builder()
            .data("Data")
            .fileName(null)
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertEquals(imageExportData, imageExportData2);
    assertEquals(imageExportData.hashCode(), imageExportData2.hashCode());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}, and {@link ImageExportData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImageExportData#equals(Object)}
   *   <li>{@link ImageExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType(null)
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();
    ImageExportData imageExportData2 =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType(null)
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertEquals(imageExportData, imageExportData2);
    assertEquals(imageExportData.hashCode(), imageExportData2.hashCode());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}, and {@link ImageExportData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImageExportData#equals(Object)}
   *   <li>{@link ImageExportData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertEquals(imageExportData, imageExportData);
    int expectedHashCodeResult = imageExportData.hashCode();
    assertEquals(expectedHashCodeResult, imageExportData.hashCode());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("text/plain")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data(null)
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("text/plain")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName(null)
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/html")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType(null)
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("text/plain")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey(null)
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("text/plain")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey(null)
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("text/plain")
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType(null)
            .title("Dr")
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Mr")
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ImageExportData imageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title(null)
            .build();

    // Act and Assert
    assertNotEquals(
        imageExportData,
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build());
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build(),
        null);
  }

  /**
   * Test {@link ImageExportData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageExportData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImageExportData.equals(Object)", "int ImageExportData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build(),
        "Different type to ImageExportData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImageExportData.<init>()",
    "void ImageExportData.<init>(String, String, String, String, String, boolean, String, String)",
    "String ImageExportData.getData()",
    "String ImageExportData.getFileName()",
    "String ImageExportData.getMediaType()",
    "String ImageExportData.getPublicResourceKey()",
    "String ImageExportData.getResourceKey()",
    "String ImageExportData.getSubType()",
    "String ImageExportData.getTitle()",
    "boolean ImageExportData.isPublic()",
    "void ImageExportData.setData(String)",
    "void ImageExportData.setFileName(String)",
    "void ImageExportData.setMediaType(String)",
    "void ImageExportData.setPublic(boolean)",
    "void ImageExportData.setPublicResourceKey(String)",
    "void ImageExportData.setResourceKey(String)",
    "void ImageExportData.setSubType(String)",
    "void ImageExportData.setTitle(String)",
    "String ImageExportData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ImageExportData actualImageExportData = new ImageExportData();
    actualImageExportData.setData("Data");
    actualImageExportData.setFileName("foo.txt");
    actualImageExportData.setMediaType("text/plain");
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
        "ImageExportData(mediaType=text/plain, fileName=foo.txt, title=Dr, subType=Sub Type, resourceKey=Resource"
            + " Key, isPublic=true, publicResourceKey=Public Resource Key, data=Data)",
        actualToStringResult);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("Sub Type", actualSubType);
    assertEquals("foo.txt", actualFileName);
    assertEquals("text/plain", actualMediaType);
    assertTrue(actualImageExportData.isPublic());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code text/plain}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImageExportData#ImageExportData(String, String, String, String, String, boolean,
   *       String, String)}
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
  @DisplayName("Test getters and setters; when 'text/plain'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImageExportData.<init>()",
    "void ImageExportData.<init>(String, String, String, String, String, boolean, String, String)",
    "String ImageExportData.getData()",
    "String ImageExportData.getFileName()",
    "String ImageExportData.getMediaType()",
    "String ImageExportData.getPublicResourceKey()",
    "String ImageExportData.getResourceKey()",
    "String ImageExportData.getSubType()",
    "String ImageExportData.getTitle()",
    "boolean ImageExportData.isPublic()",
    "void ImageExportData.setData(String)",
    "void ImageExportData.setFileName(String)",
    "void ImageExportData.setMediaType(String)",
    "void ImageExportData.setPublic(boolean)",
    "void ImageExportData.setPublicResourceKey(String)",
    "void ImageExportData.setResourceKey(String)",
    "void ImageExportData.setSubType(String)",
    "void ImageExportData.setTitle(String)",
    "String ImageExportData.toString()"
  })
  void testGettersAndSetters_whenTextPlain() {
    // Arrange and Act
    ImageExportData actualImageExportData =
        new ImageExportData(
            "text/plain",
            "foo.txt",
            "Dr",
            "Sub Type",
            "Resource Key",
            true,
            "Public Resource Key",
            "Data");
    actualImageExportData.setData("Data");
    actualImageExportData.setFileName("foo.txt");
    actualImageExportData.setMediaType("text/plain");
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
        "ImageExportData(mediaType=text/plain, fileName=foo.txt, title=Dr, subType=Sub Type, resourceKey=Resource"
            + " Key, isPublic=true, publicResourceKey=Public Resource Key, data=Data)",
        actualToStringResult);
    assertEquals("Public Resource Key", actualPublicResourceKey);
    assertEquals("Resource Key", actualResourceKey);
    assertEquals("Sub Type", actualSubType);
    assertEquals("foo.txt", actualFileName);
    assertEquals("text/plain", actualMediaType);
    assertTrue(actualImageExportData.isPublic());
  }

  /**
   * Test ImageExportDataBuilder {@link ImageExportDataBuilder#build()}.
   *
   * <p>Methods under test:
   *
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ImageExportDataBuilder.<init>()",
    "ImageExportData ImageExportDataBuilder.build()",
    "ImageExportDataBuilder ImageExportDataBuilder.data(String)",
    "ImageExportDataBuilder ImageExportDataBuilder.fileName(String)",
    "ImageExportDataBuilder ImageExportDataBuilder.isPublic(boolean)",
    "ImageExportDataBuilder ImageExportDataBuilder.mediaType(String)",
    "ImageExportDataBuilder ImageExportDataBuilder.publicResourceKey(String)",
    "ImageExportDataBuilder ImageExportDataBuilder.resourceKey(String)",
    "ImageExportDataBuilder ImageExportDataBuilder.subType(String)",
    "ImageExportDataBuilder ImageExportDataBuilder.title(String)",
    "String ImageExportDataBuilder.toString()"
  })
  void testImageExportDataBuilderBuild() {
    // Arrange and Act
    ImageExportData actualImageExportData =
        ImageExportData.builder()
            .data("Data")
            .fileName("foo.txt")
            .mediaType("text/plain")
            .publicResourceKey("Public Resource Key")
            .resourceKey("Resource Key")
            .subType("Sub Type")
            .title("Dr")
            .build();

    // Assert
    assertEquals("Data", actualImageExportData.getData());
    assertEquals("Dr", actualImageExportData.getTitle());
    assertEquals("Public Resource Key", actualImageExportData.getPublicResourceKey());
    assertEquals("Resource Key", actualImageExportData.getResourceKey());
    assertEquals("Sub Type", actualImageExportData.getSubType());
    assertEquals("foo.txt", actualImageExportData.getFileName());
    assertEquals("text/plain", actualImageExportData.getMediaType());
    assertFalse(actualImageExportData.isPublic());
  }
}
