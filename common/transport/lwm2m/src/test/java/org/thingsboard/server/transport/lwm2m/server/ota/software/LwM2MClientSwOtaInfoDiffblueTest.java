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
package org.thingsboard.server.transport.lwm2m.server.ota.software;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ota.OtaPackageType;

class LwM2MClientSwOtaInfoDiffblueTest {
  /**
   * Test {@link LwM2MClientSwOtaInfo#equals(Object)}, and {@link LwM2MClientSwOtaInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MClientSwOtaInfo#equals(Object)}
   *   <li>{@link LwM2MClientSwOtaInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MClientSwOtaInfo.equals(Object)",
    "int LwM2MClientSwOtaInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo =
        new LwM2MClientSwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MSoftwareUpdateStrategy.BINARY);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo2 =
        new LwM2MClientSwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MSoftwareUpdateStrategy.BINARY);

    // Act and Assert
    assertEquals(lwM2MClientSwOtaInfo, lwM2MClientSwOtaInfo2);
    assertEquals(lwM2MClientSwOtaInfo.hashCode(), lwM2MClientSwOtaInfo2.hashCode());
  }

  /**
   * Test {@link LwM2MClientSwOtaInfo#equals(Object)}, and {@link LwM2MClientSwOtaInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MClientSwOtaInfo#equals(Object)}
   *   <li>{@link LwM2MClientSwOtaInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MClientSwOtaInfo.equals(Object)",
    "int LwM2MClientSwOtaInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo =
        new LwM2MClientSwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MSoftwareUpdateStrategy.BINARY);

    // Act and Assert
    assertEquals(lwM2MClientSwOtaInfo, lwM2MClientSwOtaInfo);
    int expectedHashCodeResult = lwM2MClientSwOtaInfo.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MClientSwOtaInfo.hashCode());
  }

  /**
   * Test {@link LwM2MClientSwOtaInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MClientSwOtaInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MClientSwOtaInfo.equals(Object)",
    "int LwM2MClientSwOtaInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo =
        new LwM2MClientSwOtaInfo(
            "https://example.org/example",
            "https://example.org/example",
            LwM2MSoftwareUpdateStrategy.BINARY);

    // Act and Assert
    assertNotEquals(
        lwM2MClientSwOtaInfo,
        new LwM2MClientSwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MSoftwareUpdateStrategy.BINARY));
  }

  /**
   * Test {@link LwM2MClientSwOtaInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MClientSwOtaInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MClientSwOtaInfo.equals(Object)",
    "int LwM2MClientSwOtaInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new LwM2MClientSwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MSoftwareUpdateStrategy.BINARY),
        null);
  }

  /**
   * Test {@link LwM2MClientSwOtaInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MClientSwOtaInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MClientSwOtaInfo.equals(Object)",
    "int LwM2MClientSwOtaInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new LwM2MClientSwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MSoftwareUpdateStrategy.BINARY),
        "Different type to LwM2MClientSwOtaInfo");
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return BaseUrl is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MClientSwOtaInfo#LwM2MClientSwOtaInfo()}
   *   <li>{@link LwM2MClientSwOtaInfo#toString()}
   *   <li>{@link LwM2MClientSwOtaInfo#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return BaseUrl is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MClientSwOtaInfo.<init>()",
    "void LwM2MClientSwOtaInfo.<init>(String, String, LwM2MSoftwareUpdateStrategy)",
    "OtaPackageType LwM2MClientSwOtaInfo.getType()",
    "String LwM2MClientSwOtaInfo.toString()"
  })
  void testGettersAndSetters_thenReturnBaseUrlIsNull() {
    // Arrange and Act
    LwM2MClientSwOtaInfo actualLwM2MClientSwOtaInfo = new LwM2MClientSwOtaInfo();
    String actualToStringResult = actualLwM2MClientSwOtaInfo.toString();
    OtaPackageType actualType = actualLwM2MClientSwOtaInfo.getType();

    // Assert
    assertEquals(
        "LwM2MClientSwOtaInfo(super=LwM2MClientOtaInfo(endpoint=null, baseUrl=null, targetName=null,"
            + " targetVersion=null, targetTag=null, targetUrl=null, strategy=null, updateState=null, result=null,"
            + " status=null, failedPackageId=null, retryAttempts=0, currentName=null, currentVersion3=null,"
            + " currentVersion=null))",
        actualToStringResult);
    assertNull(actualLwM2MClientSwOtaInfo.getBaseUrl());
    assertNull(actualLwM2MClientSwOtaInfo.getCurrentName());
    assertNull(actualLwM2MClientSwOtaInfo.getCurrentVersion());
    assertNull(actualLwM2MClientSwOtaInfo.getCurrentVersion3());
    assertNull(actualLwM2MClientSwOtaInfo.getEndpoint());
    assertNull(actualLwM2MClientSwOtaInfo.getFailedPackageId());
    assertNull(actualLwM2MClientSwOtaInfo.getTargetName());
    assertNull(actualLwM2MClientSwOtaInfo.getTargetTag());
    assertNull(actualLwM2MClientSwOtaInfo.getTargetUrl());
    assertNull(actualLwM2MClientSwOtaInfo.getTargetVersion());
    assertNull(actualLwM2MClientSwOtaInfo.getStatus());
    assertNull(actualLwM2MClientSwOtaInfo.getStrategy());
    assertNull(actualLwM2MClientSwOtaInfo.getResult());
    assertNull(actualLwM2MClientSwOtaInfo.getUpdateState());
    assertEquals(0, actualLwM2MClientSwOtaInfo.getRetryAttempts());
    assertEquals(OtaPackageType.SOFTWARE, actualType);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return Endpoint is {@code https://config.us-east-2.amazonaws.com}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MClientSwOtaInfo#LwM2MClientSwOtaInfo(String, String,
   *       LwM2MSoftwareUpdateStrategy)}
   *   <li>{@link LwM2MClientSwOtaInfo#toString()}
   *   <li>{@link LwM2MClientSwOtaInfo#getType()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; then return Endpoint is 'https://config.us-east-2.amazonaws.com'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MClientSwOtaInfo.<init>()",
    "void LwM2MClientSwOtaInfo.<init>(String, String, LwM2MSoftwareUpdateStrategy)",
    "OtaPackageType LwM2MClientSwOtaInfo.getType()",
    "String LwM2MClientSwOtaInfo.toString()"
  })
  void testGettersAndSetters_thenReturnEndpointIsHttpsConfigUsEast2AmazonawsCom() {
    // Arrange and Act
    LwM2MClientSwOtaInfo actualLwM2MClientSwOtaInfo =
        new LwM2MClientSwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MSoftwareUpdateStrategy.BINARY);
    String actualToStringResult = actualLwM2MClientSwOtaInfo.toString();
    OtaPackageType actualType = actualLwM2MClientSwOtaInfo.getType();

    // Assert
    assertEquals(
        "LwM2MClientSwOtaInfo(super=LwM2MClientOtaInfo(endpoint=https://config.us-east-2.amazonaws.com,"
            + " baseUrl=https://example.org/example, targetName=null, targetVersion=null, targetTag=null, targetUrl=null,"
            + " strategy=BINARY, updateState=null, result=null, status=null, failedPackageId=null, retryAttempts=0,"
            + " currentName=null, currentVersion3=null, currentVersion=null))",
        actualToStringResult);
    assertEquals(
        "https://config.us-east-2.amazonaws.com", actualLwM2MClientSwOtaInfo.getEndpoint());
    assertEquals("https://example.org/example", actualLwM2MClientSwOtaInfo.getBaseUrl());
    assertNull(actualLwM2MClientSwOtaInfo.getCurrentName());
    assertNull(actualLwM2MClientSwOtaInfo.getCurrentVersion());
    assertNull(actualLwM2MClientSwOtaInfo.getCurrentVersion3());
    assertNull(actualLwM2MClientSwOtaInfo.getFailedPackageId());
    assertNull(actualLwM2MClientSwOtaInfo.getTargetName());
    assertNull(actualLwM2MClientSwOtaInfo.getTargetTag());
    assertNull(actualLwM2MClientSwOtaInfo.getTargetUrl());
    assertNull(actualLwM2MClientSwOtaInfo.getTargetVersion());
    assertNull(actualLwM2MClientSwOtaInfo.getStatus());
    assertNull(actualLwM2MClientSwOtaInfo.getResult());
    assertNull(actualLwM2MClientSwOtaInfo.getUpdateState());
    assertEquals(0, actualLwM2MClientSwOtaInfo.getRetryAttempts());
    assertEquals(OtaPackageType.SOFTWARE, actualType);
    assertEquals(LwM2MSoftwareUpdateStrategy.BINARY, actualLwM2MClientSwOtaInfo.getStrategy());
  }

  /**
   * Test {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)} with {@code
   * SoftwareUpdateResult}.
   *
   * <p>Method under test: {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName("Test update(SoftwareUpdateResult) with 'SoftwareUpdateResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MClientSwOtaInfo.update(SoftwareUpdateResult)"})
  void testUpdateWithSoftwareUpdateResult() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo =
        new LwM2MClientSwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MSoftwareUpdateStrategy.BINARY);

    // Act
    lwM2MClientSwOtaInfo.update(SoftwareUpdateResult.INITIAL);

    // Assert
    assertNull(lwM2MClientSwOtaInfo.getFailedPackageId());
    assertEquals(SoftwareUpdateResult.INITIAL, lwM2MClientSwOtaInfo.getResult());
  }

  /**
   * Test {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)} with {@code
   * SoftwareUpdateResult}.
   *
   * <p>Method under test: {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName("Test update(SoftwareUpdateResult) with 'SoftwareUpdateResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MClientSwOtaInfo.update(SoftwareUpdateResult)"})
  void testUpdateWithSoftwareUpdateResult2() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo =
        new LwM2MClientSwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MSoftwareUpdateStrategy.BINARY);

    // Act
    lwM2MClientSwOtaInfo.update(SoftwareUpdateResult.DOWNLOADING);

    // Assert
    assertEquals("", lwM2MClientSwOtaInfo.getFailedPackageId());
    assertEquals(SoftwareUpdateResult.DOWNLOADING, lwM2MClientSwOtaInfo.getResult());
  }

  /**
   * Test {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)} with {@code
   * SoftwareUpdateResult}.
   *
   * <p>Method under test: {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName("Test update(SoftwareUpdateResult) with 'SoftwareUpdateResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MClientSwOtaInfo.update(SoftwareUpdateResult)"})
  void testUpdateWithSoftwareUpdateResult3() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo =
        new LwM2MClientSwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MSoftwareUpdateStrategy.BINARY);
    lwM2MClientSwOtaInfo.setTargetName("Target Name");

    // Act
    lwM2MClientSwOtaInfo.update(SoftwareUpdateResult.DOWNLOADING);

    // Assert
    assertEquals("Target Name", lwM2MClientSwOtaInfo.getFailedPackageId());
    assertEquals(SoftwareUpdateResult.DOWNLOADING, lwM2MClientSwOtaInfo.getResult());
  }

  /**
   * Test {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)} with {@code
   * SoftwareUpdateResult}.
   *
   * <p>Method under test: {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName("Test update(SoftwareUpdateResult) with 'SoftwareUpdateResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MClientSwOtaInfo.update(SoftwareUpdateResult)"})
  void testUpdateWithSoftwareUpdateResult4() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo =
        new LwM2MClientSwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MSoftwareUpdateStrategy.BINARY);
    lwM2MClientSwOtaInfo.setTargetVersion("1.0.2");

    // Act
    lwM2MClientSwOtaInfo.update(SoftwareUpdateResult.DOWNLOADING);

    // Assert
    assertEquals("1.0.2", lwM2MClientSwOtaInfo.getFailedPackageId());
    assertEquals(SoftwareUpdateResult.DOWNLOADING, lwM2MClientSwOtaInfo.getResult());
  }

  /**
   * Test {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)} with {@code
   * SoftwareUpdateResult}.
   *
   * <p>Method under test: {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)}
   */
  @Test
  @DisplayName("Test update(SoftwareUpdateResult) with 'SoftwareUpdateResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MClientSwOtaInfo.update(SoftwareUpdateResult)"})
  void testUpdateWithSoftwareUpdateResult5() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo =
        new LwM2MClientSwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MSoftwareUpdateStrategy.BINARY);
    lwM2MClientSwOtaInfo.setTargetName("");

    // Act
    lwM2MClientSwOtaInfo.update(SoftwareUpdateResult.DOWNLOADING);

    // Assert
    assertEquals("", lwM2MClientSwOtaInfo.getFailedPackageId());
    assertEquals(SoftwareUpdateResult.DOWNLOADING, lwM2MClientSwOtaInfo.getResult());
  }
}
