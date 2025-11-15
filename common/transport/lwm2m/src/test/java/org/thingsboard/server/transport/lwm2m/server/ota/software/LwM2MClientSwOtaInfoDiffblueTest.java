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
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MClientFwOtaInfo;

class LwM2MClientSwOtaInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MClientSwOtaInfo#equals(Object)}
   *   <li>{@link LwM2MClientSwOtaInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY);
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo2 = new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY);

    // Act and Assert
    assertEquals(lwM2MClientSwOtaInfo, lwM2MClientSwOtaInfo2);
    int expectedHashCodeResult = lwM2MClientSwOtaInfo.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MClientSwOtaInfo2.hashCode());
  }

  /**
   * Method under test: {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)}
   */
  @Test
  void testUpdate() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY);

    // Act
    lwM2MClientSwOtaInfo.update(SoftwareUpdateResult.INITIAL);

    // Assert
    assertNull(lwM2MClientSwOtaInfo.getFailedPackageId());
    assertEquals(SoftwareUpdateResult.INITIAL, lwM2MClientSwOtaInfo.getResult());
  }

  /**
   * Method under test: {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY);

    // Act
    lwM2MClientSwOtaInfo.update(SoftwareUpdateResult.DOWNLOADING);

    // Assert
    assertEquals("", lwM2MClientSwOtaInfo.getFailedPackageId());
    assertEquals(SoftwareUpdateResult.DOWNLOADING, lwM2MClientSwOtaInfo.getResult());
  }

  /**
   * Method under test: {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)}
   */
  @Test
  void testUpdate3() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY);
    lwM2MClientSwOtaInfo.setTargetName("Target Name");

    // Act
    lwM2MClientSwOtaInfo.update(SoftwareUpdateResult.DOWNLOADING);

    // Assert
    assertEquals("Target Name", lwM2MClientSwOtaInfo.getFailedPackageId());
    assertEquals(SoftwareUpdateResult.DOWNLOADING, lwM2MClientSwOtaInfo.getResult());
  }

  /**
   * Method under test: {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)}
   */
  @Test
  void testUpdate4() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY);
    lwM2MClientSwOtaInfo.setTargetVersion("1.0.2");

    // Act
    lwM2MClientSwOtaInfo.update(SoftwareUpdateResult.DOWNLOADING);

    // Assert
    assertEquals("1.0.2", lwM2MClientSwOtaInfo.getFailedPackageId());
    assertEquals(SoftwareUpdateResult.DOWNLOADING, lwM2MClientSwOtaInfo.getResult());
  }

  /**
   * Method under test: {@link LwM2MClientSwOtaInfo#update(SoftwareUpdateResult)}
   */
  @Test
  void testUpdate5() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY);
    lwM2MClientSwOtaInfo.setTargetName("");

    // Act
    lwM2MClientSwOtaInfo.update(SoftwareUpdateResult.DOWNLOADING);

    // Assert
    assertEquals("", lwM2MClientSwOtaInfo.getFailedPackageId());
    assertEquals(SoftwareUpdateResult.DOWNLOADING, lwM2MClientSwOtaInfo.getResult());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MClientSwOtaInfo#equals(Object)}
   *   <li>{@link LwM2MClientSwOtaInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY);

    // Act and Assert
    assertEquals(lwM2MClientSwOtaInfo, lwM2MClientSwOtaInfo);
    int expectedHashCodeResult = lwM2MClientSwOtaInfo.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MClientSwOtaInfo.hashCode());
  }

  /**
   * Method under test: {@link LwM2MClientSwOtaInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MClientSwOtaInfo lwM2MClientSwOtaInfo = new LwM2MClientSwOtaInfo("https://example.org/example",
        "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY);

    // Act and Assert
    assertNotEquals(lwM2MClientSwOtaInfo, new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY));
  }

  /**
   * Method under test: {@link LwM2MClientSwOtaInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MSoftwareUpdateStrategy.BINARY), mock(LwM2MClientFwOtaInfo.class));
  }

  /**
   * Method under test: {@link LwM2MClientSwOtaInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MSoftwareUpdateStrategy.BINARY), null);
  }

  /**
   * Method under test: {@link LwM2MClientSwOtaInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MSoftwareUpdateStrategy.BINARY), "Different type to LwM2MClientSwOtaInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MClientSwOtaInfo#LwM2MClientSwOtaInfo()}
   *   <li>{@link LwM2MClientSwOtaInfo#toString()}
   *   <li>{@link LwM2MClientSwOtaInfo#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MClientSwOtaInfo actualLwM2MClientSwOtaInfo = new LwM2MClientSwOtaInfo();
    String actualToStringResult = actualLwM2MClientSwOtaInfo.toString();
    OtaPackageType actualType = actualLwM2MClientSwOtaInfo.getType();

    // Assert
    assertEquals("LwM2MClientSwOtaInfo(super=LwM2MClientOtaInfo(endpoint=null, baseUrl=null, targetName=null,"
        + " targetVersion=null, targetTag=null, targetUrl=null, strategy=null, updateState=null, result=null,"
        + " status=null, failedPackageId=null, retryAttempts=0, currentName=null, currentVersion3=null,"
        + " currentVersion=null))", actualToStringResult);
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
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LwM2MClientSwOtaInfo#LwM2MClientSwOtaInfo(String, String, LwM2MSoftwareUpdateStrategy)}
   *   <li>{@link LwM2MClientSwOtaInfo#toString()}
   *   <li>{@link LwM2MClientSwOtaInfo#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    LwM2MClientSwOtaInfo actualLwM2MClientSwOtaInfo = new LwM2MClientSwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MSoftwareUpdateStrategy.BINARY);
    String actualToStringResult = actualLwM2MClientSwOtaInfo.toString();
    OtaPackageType actualType = actualLwM2MClientSwOtaInfo.getType();

    // Assert
    assertEquals("LwM2MClientSwOtaInfo(super=LwM2MClientOtaInfo(endpoint=https://config.us-east-2.amazonaws.com,"
        + " baseUrl=https://example.org/example, targetName=null, targetVersion=null, targetTag=null, targetUrl=null,"
        + " strategy=BINARY, updateState=null, result=null, status=null, failedPackageId=null, retryAttempts=0,"
        + " currentName=null, currentVersion3=null, currentVersion=null))", actualToStringResult);
    assertEquals("https://config.us-east-2.amazonaws.com", actualLwM2MClientSwOtaInfo.getEndpoint());
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
}
