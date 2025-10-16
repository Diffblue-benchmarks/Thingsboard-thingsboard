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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OtaPackageDiffblueTest {
  /**
   * Test {@link OtaPackage#OtaPackage(OtaPackage)}.
   *
   * <ul>
   *   <li>Given {@code true}.
   *   <li>When {@link OtaPackage#OtaPackage()} HasData is {@code true}.
   *   <li>Then return HasData.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackage#OtaPackage(OtaPackage)}
   */
  @Test
  @DisplayName(
      "Test new OtaPackage(OtaPackage); given 'true'; when OtaPackage() HasData is 'true'; then return HasData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackage.<init>(OtaPackage)"})
  void testNewOtaPackage_givenTrue_whenOtaPackageHasDataIsTrue_thenReturnHasData() {
    // Arrange
    OtaPackage otaPackage = new OtaPackage();
    otaPackage.setHasData(true);

    // Act
    OtaPackage actualOtaPackage = new OtaPackage(otaPackage);

    // Assert
    assertTrue(actualOtaPackage.getAdditionalInfo() instanceof NullNode);
    assertNull(actualOtaPackage.getDataSize());
    assertNull(actualOtaPackage.getChecksum());
    assertNull(actualOtaPackage.getContentType());
    assertNull(actualOtaPackage.getFileName());
    assertNull(actualOtaPackage.getName());
    assertNull(actualOtaPackage.getTag());
    assertNull(actualOtaPackage.getTitle());
    assertNull(actualOtaPackage.getUrl());
    assertNull(actualOtaPackage.getVersion());
    assertNull(actualOtaPackage.getData());
    assertNull(actualOtaPackage.getUuidId());
    assertNull(actualOtaPackage.getDeviceProfileId());
    assertNull(actualOtaPackage.getId());
    assertNull(actualOtaPackage.getTenantId());
    assertNull(actualOtaPackage.getChecksumAlgorithm());
    assertNull(actualOtaPackage.getType());
    assertEquals(0L, actualOtaPackage.getCreatedTime());
    assertFalse(actualOtaPackage.hasUrl());
    assertTrue(actualOtaPackage.isHasData());
  }

  /**
   * Test {@link OtaPackage#OtaPackage(OtaPackage)}.
   *
   * <ul>
   *   <li>When {@link OtaPackage#OtaPackage(OtaPackage)} with otaPackage is {@link
   *       OtaPackage#OtaPackage()}.
   *   <li>Then return not HasData.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackage#OtaPackage(OtaPackage)}
   */
  @Test
  @DisplayName(
      "Test new OtaPackage(OtaPackage); when OtaPackage(OtaPackage) with otaPackage is OtaPackage(); then return not HasData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackage.<init>(OtaPackage)"})
  void testNewOtaPackage_whenOtaPackageWithOtaPackageIsOtaPackage_thenReturnNotHasData() {
    // Arrange and Act
    OtaPackage actualOtaPackage = new OtaPackage(new OtaPackage(new OtaPackage()));

    // Assert
    assertTrue(actualOtaPackage.getAdditionalInfo() instanceof NullNode);
    assertNull(actualOtaPackage.getDataSize());
    assertNull(actualOtaPackage.getChecksum());
    assertNull(actualOtaPackage.getContentType());
    assertNull(actualOtaPackage.getFileName());
    assertNull(actualOtaPackage.getName());
    assertNull(actualOtaPackage.getTag());
    assertNull(actualOtaPackage.getTitle());
    assertNull(actualOtaPackage.getUrl());
    assertNull(actualOtaPackage.getVersion());
    assertNull(actualOtaPackage.getData());
    assertNull(actualOtaPackage.getUuidId());
    assertNull(actualOtaPackage.getDeviceProfileId());
    assertNull(actualOtaPackage.getId());
    assertNull(actualOtaPackage.getTenantId());
    assertNull(actualOtaPackage.getChecksumAlgorithm());
    assertNull(actualOtaPackage.getType());
    assertEquals(0L, actualOtaPackage.getCreatedTime());
    assertFalse(actualOtaPackage.hasUrl());
    assertFalse(actualOtaPackage.isHasData());
  }

  /**
   * Test {@link OtaPackage#OtaPackage(OtaPackage)}.
   *
   * <ul>
   *   <li>When {@link OtaPackage#OtaPackage(OtaPackage)} with otaPackage is {@link
   *       OtaPackage#OtaPackage(OtaPackage)}.
   *   <li>Then return not HasData.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackage#OtaPackage(OtaPackage)}
   */
  @Test
  @DisplayName(
      "Test new OtaPackage(OtaPackage); when OtaPackage(OtaPackage) with otaPackage is OtaPackage(OtaPackage); then return not HasData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackage.<init>(OtaPackage)"})
  void testNewOtaPackage_whenOtaPackageWithOtaPackageIsOtaPackage_thenReturnNotHasData2() {
    // Arrange
    OtaPackage otaPackage = new OtaPackage(new OtaPackage(new OtaPackage()));

    // Act
    OtaPackage actualOtaPackage = new OtaPackage(otaPackage);

    // Assert
    assertTrue(actualOtaPackage.getAdditionalInfo() instanceof NullNode);
    assertNull(actualOtaPackage.getDataSize());
    assertNull(actualOtaPackage.getChecksum());
    assertNull(actualOtaPackage.getContentType());
    assertNull(actualOtaPackage.getFileName());
    assertNull(actualOtaPackage.getName());
    assertNull(actualOtaPackage.getTag());
    assertNull(actualOtaPackage.getTitle());
    assertNull(actualOtaPackage.getUrl());
    assertNull(actualOtaPackage.getVersion());
    assertNull(actualOtaPackage.getData());
    assertNull(actualOtaPackage.getUuidId());
    assertNull(actualOtaPackage.getDeviceProfileId());
    assertNull(actualOtaPackage.getId());
    assertNull(actualOtaPackage.getTenantId());
    assertNull(actualOtaPackage.getChecksumAlgorithm());
    assertNull(actualOtaPackage.getType());
    assertEquals(0L, actualOtaPackage.getCreatedTime());
    assertFalse(actualOtaPackage.hasUrl());
    assertFalse(actualOtaPackage.isHasData());
  }

  /**
   * Test {@link OtaPackage#OtaPackage(OtaPackage)}.
   *
   * <ul>
   *   <li>When {@link OtaPackage#OtaPackage()}.
   *   <li>Then return not HasData.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackage#OtaPackage(OtaPackage)}
   */
  @Test
  @DisplayName("Test new OtaPackage(OtaPackage); when OtaPackage(); then return not HasData")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void OtaPackage.<init>(OtaPackage)"})
  void testNewOtaPackage_whenOtaPackage_thenReturnNotHasData() {
    // Arrange and Act
    OtaPackage actualOtaPackage = new OtaPackage(new OtaPackage());

    // Assert
    assertTrue(actualOtaPackage.getAdditionalInfo() instanceof NullNode);
    assertNull(actualOtaPackage.getDataSize());
    assertNull(actualOtaPackage.getChecksum());
    assertNull(actualOtaPackage.getContentType());
    assertNull(actualOtaPackage.getFileName());
    assertNull(actualOtaPackage.getName());
    assertNull(actualOtaPackage.getTag());
    assertNull(actualOtaPackage.getTitle());
    assertNull(actualOtaPackage.getUrl());
    assertNull(actualOtaPackage.getVersion());
    assertNull(actualOtaPackage.getData());
    assertNull(actualOtaPackage.getUuidId());
    assertNull(actualOtaPackage.getDeviceProfileId());
    assertNull(actualOtaPackage.getId());
    assertNull(actualOtaPackage.getTenantId());
    assertNull(actualOtaPackage.getChecksumAlgorithm());
    assertNull(actualOtaPackage.getType());
    assertEquals(0L, actualOtaPackage.getCreatedTime());
    assertFalse(actualOtaPackage.hasUrl());
    assertFalse(actualOtaPackage.isHasData());
  }

  /**
   * Test {@link OtaPackage#equals(Object)}, and {@link OtaPackage#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackage#equals(Object)}
   *   <li>{@link OtaPackage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackage.equals(Object)", "int OtaPackage.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OtaPackage otaPackage = new OtaPackage();
    OtaPackage otaPackage2 = new OtaPackage();

    // Act and Assert
    assertEquals(otaPackage, otaPackage2);
    assertEquals(otaPackage.hashCode(), otaPackage2.hashCode());
  }

  /**
   * Test {@link OtaPackage#equals(Object)}, and {@link OtaPackage#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link OtaPackage#equals(Object)}
   *   <li>{@link OtaPackage#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackage.equals(Object)", "int OtaPackage.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OtaPackage otaPackage = new OtaPackage();

    // Act and Assert
    assertEquals(otaPackage, otaPackage);
    int expectedHashCodeResult = otaPackage.hashCode();
    assertEquals(expectedHashCodeResult, otaPackage.hashCode());
  }

  /**
   * Test {@link OtaPackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackage.equals(Object)", "int OtaPackage.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OtaPackage otaPackage = new OtaPackage(new OtaPackage());

    // Act and Assert
    assertNotEquals(otaPackage, new OtaPackage());
  }

  /**
   * Test {@link OtaPackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackage.equals(Object)", "int OtaPackage.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OtaPackage(), null);
  }

  /**
   * Test {@link OtaPackage#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link OtaPackage#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean OtaPackage.equals(Object)", "int OtaPackage.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new OtaPackage(), "Different type to OtaPackage");
  }
}
