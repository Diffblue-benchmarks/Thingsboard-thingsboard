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
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.NullNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SaveOtaPackageInfoRequestDiffblueTest {
  /**
   * Test {@link SaveOtaPackageInfoRequest#equals(Object)}, and {@link SaveOtaPackageInfoRequest#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveOtaPackageInfoRequest#equals(Object)}
   *   <li>{@link SaveOtaPackageInfoRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SaveOtaPackageInfoRequest.equals(Object)", "int SaveOtaPackageInfoRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SaveOtaPackageInfoRequest saveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest();
    SaveOtaPackageInfoRequest saveOtaPackageInfoRequest2 = new SaveOtaPackageInfoRequest();

    // Act and Assert
    assertEquals(saveOtaPackageInfoRequest, saveOtaPackageInfoRequest2);
    int expectedHashCodeResult = saveOtaPackageInfoRequest.hashCode();
    assertEquals(expectedHashCodeResult, saveOtaPackageInfoRequest2.hashCode());
  }

  /**
   * Test {@link SaveOtaPackageInfoRequest#equals(Object)}, and {@link SaveOtaPackageInfoRequest#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveOtaPackageInfoRequest#equals(Object)}
   *   <li>{@link SaveOtaPackageInfoRequest#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SaveOtaPackageInfoRequest.equals(Object)", "int SaveOtaPackageInfoRequest.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SaveOtaPackageInfoRequest saveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest();

    // Act and Assert
    assertEquals(saveOtaPackageInfoRequest, saveOtaPackageInfoRequest);
    int expectedHashCodeResult = saveOtaPackageInfoRequest.hashCode();
    assertEquals(expectedHashCodeResult, saveOtaPackageInfoRequest.hashCode());
  }

  /**
   * Test {@link SaveOtaPackageInfoRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveOtaPackageInfoRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SaveOtaPackageInfoRequest.equals(Object)", "int SaveOtaPackageInfoRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SaveOtaPackageInfoRequest saveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(new OtaPackageInfo(), true);

    // Act and Assert
    assertNotEquals(saveOtaPackageInfoRequest, new SaveOtaPackageInfoRequest());
  }

  /**
   * Test {@link SaveOtaPackageInfoRequest#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveOtaPackageInfoRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SaveOtaPackageInfoRequest.equals(Object)", "int SaveOtaPackageInfoRequest.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SaveOtaPackageInfoRequest saveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest();
    saveOtaPackageInfoRequest.setUsesUrl(true);

    // Act and Assert
    assertNotEquals(saveOtaPackageInfoRequest, new SaveOtaPackageInfoRequest());
  }

  /**
   * Test {@link SaveOtaPackageInfoRequest#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveOtaPackageInfoRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SaveOtaPackageInfoRequest.equals(Object)", "int SaveOtaPackageInfoRequest.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SaveOtaPackageInfoRequest(), null);
  }

  /**
   * Test {@link SaveOtaPackageInfoRequest#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveOtaPackageInfoRequest#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SaveOtaPackageInfoRequest.equals(Object)", "int SaveOtaPackageInfoRequest.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new SaveOtaPackageInfoRequest(), "Different type to SaveOtaPackageInfoRequest");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest()}
   *   <li>{@link SaveOtaPackageInfoRequest#setUsesUrl(boolean)}
   *   <li>{@link SaveOtaPackageInfoRequest#toString()}
   *   <li>{@link SaveOtaPackageInfoRequest#isUsesUrl()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SaveOtaPackageInfoRequest.<init>()", "boolean SaveOtaPackageInfoRequest.isUsesUrl()",
      "void SaveOtaPackageInfoRequest.setUsesUrl(boolean)", "String SaveOtaPackageInfoRequest.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest();
    actualSaveOtaPackageInfoRequest.setUsesUrl(true);
    String actualToStringResult = actualSaveOtaPackageInfoRequest.toString();
    boolean actualIsUsesUrlResult = actualSaveOtaPackageInfoRequest.isUsesUrl();

    // Assert
    assertEquals("SaveOtaPackageInfoRequest(usesUrl=true)", actualToStringResult);
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(actualIsUsesUrlResult);
  }

  /**
   * Test {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)}.
   * <p>
   * Method under test: {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)}
   */
  @Test
  @DisplayName("Test new SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SaveOtaPackageInfoRequest.<init>(OtaPackageInfo, boolean)"})
  void testNewSaveOtaPackageInfoRequest() {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(
        new OtaPackageInfo(new OtaPackageInfo()), true);

    // Assert
    assertTrue(actualSaveOtaPackageInfoRequest.getAdditionalInfo() instanceof NullNode);
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(actualSaveOtaPackageInfoRequest.isUsesUrl());
  }

  /**
   * Test {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)}.
   * <p>
   * Method under test: {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)}
   */
  @Test
  @DisplayName("Test new SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SaveOtaPackageInfoRequest.<init>(OtaPackageInfo, boolean)"})
  void testNewSaveOtaPackageInfoRequest2() {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(
        new OtaPackageInfo(new OtaPackageInfo(new OtaPackageInfo())), true);

    // Assert
    assertTrue(actualSaveOtaPackageInfoRequest.getAdditionalInfo() instanceof NullNode);
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(actualSaveOtaPackageInfoRequest.isUsesUrl());
  }

  /**
   * Test {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(SaveOtaPackageInfoRequest)}.
   * <p>
   * Method under test: {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(SaveOtaPackageInfoRequest)}
   */
  @Test
  @DisplayName("Test new SaveOtaPackageInfoRequest(SaveOtaPackageInfoRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SaveOtaPackageInfoRequest.<init>(SaveOtaPackageInfoRequest)"})
  void testNewSaveOtaPackageInfoRequest3() {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(
        new SaveOtaPackageInfoRequest(new OtaPackageInfo(), true));

    // Assert
    assertTrue(actualSaveOtaPackageInfoRequest.getAdditionalInfo() instanceof NullNode);
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(actualSaveOtaPackageInfoRequest.isUsesUrl());
  }

  /**
   * Test {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(SaveOtaPackageInfoRequest)}.
   * <p>
   * Method under test: {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(SaveOtaPackageInfoRequest)}
   */
  @Test
  @DisplayName("Test new SaveOtaPackageInfoRequest(SaveOtaPackageInfoRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SaveOtaPackageInfoRequest.<init>(SaveOtaPackageInfoRequest)"})
  void testNewSaveOtaPackageInfoRequest4() {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(
        new SaveOtaPackageInfoRequest(new OtaPackageInfo(new OtaPackageInfo()), true));

    // Assert
    assertTrue(actualSaveOtaPackageInfoRequest.getAdditionalInfo() instanceof NullNode);
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(actualSaveOtaPackageInfoRequest.isUsesUrl());
  }

  /**
   * Test {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return HasData.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)}
   */
  @Test
  @DisplayName("Test new SaveOtaPackageInfoRequest(OtaPackageInfo, boolean); given 'true'; then return HasData")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SaveOtaPackageInfoRequest.<init>(OtaPackageInfo, boolean)"})
  void testNewSaveOtaPackageInfoRequest_givenTrue_thenReturnHasData() {
    // Arrange
    OtaPackageInfo otaPackageInfo = new OtaPackageInfo();
    otaPackageInfo.setHasData(true);

    // Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(otaPackageInfo, true);

    // Assert
    assertTrue(actualSaveOtaPackageInfoRequest.getAdditionalInfo() instanceof NullNode);
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertTrue(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(actualSaveOtaPackageInfoRequest.isUsesUrl());
  }

  /**
   * Test {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(SaveOtaPackageInfoRequest)}.
   * <ul>
   *   <li>Then return not UsesUrl.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(SaveOtaPackageInfoRequest)}
   */
  @Test
  @DisplayName("Test new SaveOtaPackageInfoRequest(SaveOtaPackageInfoRequest); then return not UsesUrl")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SaveOtaPackageInfoRequest.<init>(SaveOtaPackageInfoRequest)"})
  void testNewSaveOtaPackageInfoRequest_thenReturnNotUsesUrl() {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(
        new SaveOtaPackageInfoRequest());

    // Assert
    assertTrue(actualSaveOtaPackageInfoRequest.getAdditionalInfo() instanceof NullNode);
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertFalse(actualSaveOtaPackageInfoRequest.isUsesUrl());
  }

  /**
   * Test {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)}.
   * <ul>
   *   <li>When {@link OtaPackageInfo#OtaPackageInfo()}.</li>
   *   <li>Then return not HasData.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveOtaPackageInfoRequest#SaveOtaPackageInfoRequest(OtaPackageInfo, boolean)}
   */
  @Test
  @DisplayName("Test new SaveOtaPackageInfoRequest(OtaPackageInfo, boolean); when OtaPackageInfo(); then return not HasData")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SaveOtaPackageInfoRequest.<init>(OtaPackageInfo, boolean)"})
  void testNewSaveOtaPackageInfoRequest_whenOtaPackageInfo_thenReturnNotHasData() {
    // Arrange and Act
    SaveOtaPackageInfoRequest actualSaveOtaPackageInfoRequest = new SaveOtaPackageInfoRequest(new OtaPackageInfo(),
        true);

    // Assert
    assertTrue(actualSaveOtaPackageInfoRequest.getAdditionalInfo() instanceof NullNode);
    assertNull(actualSaveOtaPackageInfoRequest.getDataSize());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksum());
    assertNull(actualSaveOtaPackageInfoRequest.getContentType());
    assertNull(actualSaveOtaPackageInfoRequest.getFileName());
    assertNull(actualSaveOtaPackageInfoRequest.getName());
    assertNull(actualSaveOtaPackageInfoRequest.getTag());
    assertNull(actualSaveOtaPackageInfoRequest.getTitle());
    assertNull(actualSaveOtaPackageInfoRequest.getUrl());
    assertNull(actualSaveOtaPackageInfoRequest.getVersion());
    assertNull(actualSaveOtaPackageInfoRequest.getUuidId());
    assertNull(actualSaveOtaPackageInfoRequest.getDeviceProfileId());
    assertNull(actualSaveOtaPackageInfoRequest.getId());
    assertNull(actualSaveOtaPackageInfoRequest.getTenantId());
    assertNull(actualSaveOtaPackageInfoRequest.getChecksumAlgorithm());
    assertNull(actualSaveOtaPackageInfoRequest.getType());
    assertEquals(0L, actualSaveOtaPackageInfoRequest.getCreatedTime());
    assertFalse(actualSaveOtaPackageInfoRequest.hasUrl());
    assertFalse(actualSaveOtaPackageInfoRequest.isHasData());
    assertTrue(actualSaveOtaPackageInfoRequest.isUsesUrl());
  }
}
