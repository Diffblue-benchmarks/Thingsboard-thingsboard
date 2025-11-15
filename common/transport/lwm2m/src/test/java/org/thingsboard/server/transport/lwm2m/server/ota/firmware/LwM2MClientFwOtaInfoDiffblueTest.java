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
package org.thingsboard.server.transport.lwm2m.server.ota.firmware;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ota.OtaPackageType;
import org.thingsboard.server.transport.lwm2m.server.ota.software.LwM2MClientSwOtaInfo;

class LwM2MClientFwOtaInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MClientFwOtaInfo#equals(Object)}
   *   <li>{@link LwM2MClientFwOtaInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo2 = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act and Assert
    assertEquals(lwM2MClientFwOtaInfo, lwM2MClientFwOtaInfo2);
    int expectedHashCodeResult = lwM2MClientFwOtaInfo.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MClientFwOtaInfo2.hashCode());
  }

  /**
   * Method under test: {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)}
   */
  @Test
  void testUpdate() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.update(FirmwareUpdateResult.INITIAL);

    // Assert
    assertNull(lwM2MClientFwOtaInfo.getFailedPackageId());
    assertEquals(FirmwareUpdateResult.INITIAL, lwM2MClientFwOtaInfo.getResult());
  }

  /**
   * Method under test: {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)}
   */
  @Test
  void testUpdate2() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.update(FirmwareUpdateResult.UPDATE_SUCCESSFULLY);

    // Assert
    assertNull(lwM2MClientFwOtaInfo.getFailedPackageId());
    assertEquals(FirmwareUpdateResult.UPDATE_SUCCESSFULLY, lwM2MClientFwOtaInfo.getResult());
  }

  /**
   * Method under test: {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)}
   */
  @Test
  void testUpdate3() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.update(FirmwareUpdateResult.NOT_ENOUGH);

    // Assert
    assertEquals("", lwM2MClientFwOtaInfo.getFailedPackageId());
    assertEquals(FirmwareUpdateResult.NOT_ENOUGH, lwM2MClientFwOtaInfo.getResult());
  }

  /**
   * Method under test: {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)}
   */
  @Test
  void testUpdate4() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act
    lwM2MClientFwOtaInfo.update(FirmwareUpdateResult.NOT_ENOUGH);

    // Assert
    assertEquals("Target Name", lwM2MClientFwOtaInfo.getFailedPackageId());
    assertEquals(FirmwareUpdateResult.NOT_ENOUGH, lwM2MClientFwOtaInfo.getResult());
  }

  /**
   * Method under test: {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)}
   */
  @Test
  void testUpdate5() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");

    // Act
    lwM2MClientFwOtaInfo.update(FirmwareUpdateResult.NOT_ENOUGH);

    // Assert
    assertEquals("1.0.2", lwM2MClientFwOtaInfo.getFailedPackageId());
    assertEquals(FirmwareUpdateResult.NOT_ENOUGH, lwM2MClientFwOtaInfo.getResult());
  }

  /**
   * Method under test: {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)}
   */
  @Test
  void testUpdate6() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetName("");

    // Act
    lwM2MClientFwOtaInfo.update(FirmwareUpdateResult.NOT_ENOUGH);

    // Assert
    assertEquals("", lwM2MClientFwOtaInfo.getFailedPackageId());
    assertEquals(FirmwareUpdateResult.NOT_ENOUGH, lwM2MClientFwOtaInfo.getResult());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MClientFwOtaInfo#equals(Object)}
   *   <li>{@link LwM2MClientFwOtaInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setDeliveryMethod(1);

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo2 = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo2.setDeliveryMethod(1);

    // Act and Assert
    assertEquals(lwM2MClientFwOtaInfo, lwM2MClientFwOtaInfo2);
    int expectedHashCodeResult = lwM2MClientFwOtaInfo.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MClientFwOtaInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MClientFwOtaInfo#equals(Object)}
   *   <li>{@link LwM2MClientFwOtaInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act and Assert
    assertEquals(lwM2MClientFwOtaInfo, lwM2MClientFwOtaInfo);
    int expectedHashCodeResult = lwM2MClientFwOtaInfo.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MClientFwOtaInfo.hashCode());
  }

  /**
   * Method under test: {@link LwM2MClientFwOtaInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://example.org/example",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act and Assert
    assertNotEquals(lwM2MClientFwOtaInfo, new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
  }

  /**
   * Method under test: {@link LwM2MClientFwOtaInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY), mock(LwM2MClientSwOtaInfo.class));
  }

  /**
   * Method under test: {@link LwM2MClientFwOtaInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setDeliveryMethod(1);

    // Act and Assert
    assertNotEquals(lwM2MClientFwOtaInfo, new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
  }

  /**
   * Method under test: {@link LwM2MClientFwOtaInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo2 = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo2.setDeliveryMethod(1);

    // Act and Assert
    assertNotEquals(lwM2MClientFwOtaInfo, lwM2MClientFwOtaInfo2);
  }

  /**
   * Method under test: {@link LwM2MClientFwOtaInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY), null);
  }

  /**
   * Method under test: {@link LwM2MClientFwOtaInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY), "Different type to LwM2MClientFwOtaInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MClientFwOtaInfo#LwM2MClientFwOtaInfo()}
   *   <li>{@link LwM2MClientFwOtaInfo#setDeliveryMethod(Integer)}
   *   <li>{@link LwM2MClientFwOtaInfo#toString()}
   *   <li>{@link LwM2MClientFwOtaInfo#getDeliveryMethod()}
   *   <li>{@link LwM2MClientFwOtaInfo#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MClientFwOtaInfo actualLwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo();
    actualLwM2MClientFwOtaInfo.setDeliveryMethod(1);
    String actualToStringResult = actualLwM2MClientFwOtaInfo.toString();
    Integer actualDeliveryMethod = actualLwM2MClientFwOtaInfo.getDeliveryMethod();
    OtaPackageType actualType = actualLwM2MClientFwOtaInfo.getType();

    // Assert that nothing has changed
    assertEquals("LwM2MClientFwOtaInfo(super=LwM2MClientOtaInfo(endpoint=null, baseUrl=null, targetName=null,"
        + " targetVersion=null, targetTag=null, targetUrl=null, strategy=null, updateState=null, result=null,"
        + " status=null, failedPackageId=null, retryAttempts=0, currentName=null, currentVersion3=null,"
        + " currentVersion=null), deliveryMethod=1)", actualToStringResult);
    assertEquals(0, actualLwM2MClientFwOtaInfo.getRetryAttempts());
    assertEquals(1, actualDeliveryMethod.intValue());
    assertEquals(OtaPackageType.FIRMWARE, actualType);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link LwM2MClientFwOtaInfo#LwM2MClientFwOtaInfo(String, String, LwM2MFirmwareUpdateStrategy)}
   *   <li>{@link LwM2MClientFwOtaInfo#setDeliveryMethod(Integer)}
   *   <li>{@link LwM2MClientFwOtaInfo#toString()}
   *   <li>{@link LwM2MClientFwOtaInfo#getDeliveryMethod()}
   *   <li>{@link LwM2MClientFwOtaInfo#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    LwM2MClientFwOtaInfo actualLwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    actualLwM2MClientFwOtaInfo.setDeliveryMethod(1);
    String actualToStringResult = actualLwM2MClientFwOtaInfo.toString();
    Integer actualDeliveryMethod = actualLwM2MClientFwOtaInfo.getDeliveryMethod();
    OtaPackageType actualType = actualLwM2MClientFwOtaInfo.getType();

    // Assert that nothing has changed
    assertEquals("LwM2MClientFwOtaInfo(super=LwM2MClientOtaInfo(endpoint=https://config.us-east-2.amazonaws.com,"
        + " baseUrl=https://example.org/example, targetName=null, targetVersion=null, targetTag=null, targetUrl=null,"
        + " strategy=OBJ_5_BINARY, updateState=null, result=null, status=null, failedPackageId=null, retryAttempts=0,"
        + " currentName=null, currentVersion3=null, currentVersion=null), deliveryMethod=1)", actualToStringResult);
    assertEquals("https://config.us-east-2.amazonaws.com", actualLwM2MClientFwOtaInfo.getEndpoint());
    assertEquals("https://example.org/example", actualLwM2MClientFwOtaInfo.getBaseUrl());
    assertEquals(0, actualLwM2MClientFwOtaInfo.getRetryAttempts());
    assertEquals(1, actualDeliveryMethod.intValue());
    assertEquals(OtaPackageType.FIRMWARE, actualType);
    assertEquals(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY, actualLwM2MClientFwOtaInfo.getStrategy());
  }
}
