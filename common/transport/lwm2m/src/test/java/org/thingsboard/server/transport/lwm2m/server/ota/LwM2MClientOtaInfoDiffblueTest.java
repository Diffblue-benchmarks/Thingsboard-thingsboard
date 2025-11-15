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
package org.thingsboard.server.transport.lwm2m.server.ota;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ota.OtaPackageUpdateStatus;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.FirmwareUpdateResult;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.FirmwareUpdateState;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MClientFwOtaInfo;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MFirmwareUpdateStrategy;

class LwM2MClientOtaInfoDiffblueTest {
  /**
   * Method under test:
   * {@link LwM2MClientOtaInfo#updateTarget(String, String, Optional, Optional)}
   */
  @Test
  void testUpdateTarget() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    Optional<String> newTargetUrl = Optional.of("foo");
    Optional<String> newTargetTag = Optional.of("foo");

    // Act
    lwM2MClientFwOtaInfo.updateTarget("Target Name", "1.0.2", newTargetUrl, newTargetTag);

    // Assert
    assertEquals("1.0.2", lwM2MClientFwOtaInfo.getTargetVersion());
    assertEquals("Target Name", lwM2MClientFwOtaInfo.getTargetName());
    assertEquals("Target Name1.0.2", lwM2MClientFwOtaInfo.getTargetPackageId());
    assertEquals("foo", lwM2MClientFwOtaInfo.getTargetTag());
    assertEquals("foo", lwM2MClientFwOtaInfo.getTargetUrl());
    assertTrue(lwM2MClientFwOtaInfo.isAssigned());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired() {
    // Arrange, Act and Assert
    assertFalse((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired2() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired3() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetName("");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired4() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired5() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setCurrentName("Current Name");
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertTrue(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired6() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setCurrentName("Target Name1.0.2");
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired7() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setCurrentName("");
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired8() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setFailedPackageId("42");
    lwM2MClientFwOtaInfo.setCurrentName("Target Name1.0.2");
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired9() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setCurrentVersion3("1.0.2");
    lwM2MClientFwOtaInfo.setCurrentName("");
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertTrue(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired10() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setCurrentVersion("1.0.2");
    lwM2MClientFwOtaInfo.setCurrentName("");
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertTrue(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired11() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setFailedPackageId("Target Name1.0.2");
    lwM2MClientFwOtaInfo.setCurrentName("Target Name1.0.2");
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired12() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setCurrentVersion3("Target Name1.0.2");
    lwM2MClientFwOtaInfo.setCurrentName("");
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired13() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetTag("Target Name1.0.2");
    lwM2MClientFwOtaInfo.setCurrentVersion3("Target Name1.0.2");
    lwM2MClientFwOtaInfo.setCurrentName("");
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired14() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetTag("Target Tag");
    lwM2MClientFwOtaInfo.setCurrentVersion3("Target Name1.0.2");
    lwM2MClientFwOtaInfo.setCurrentName("");
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  void testIsUpdateRequired15() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetTag("Target Tag");
    lwM2MClientFwOtaInfo.setCurrentVersion3("Target Name1.0.2");
    lwM2MClientFwOtaInfo.setCurrentName("Target Tag");
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isSupported()}
   */
  @Test
  void testIsSupported() {
    // Arrange, Act and Assert
    assertFalse((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).isSupported());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isSupported()}
   */
  @Test
  void testIsSupported2() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setCurrentVersion(null);
    lwM2MClientFwOtaInfo.setCurrentVersion3(null);
    lwM2MClientFwOtaInfo.setCurrentName("");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isSupported());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isSupported()}
   */
  @Test
  void testIsSupported3() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setCurrentVersion(null);
    lwM2MClientFwOtaInfo.setCurrentVersion3(null);
    lwM2MClientFwOtaInfo.setCurrentName("foo");

    // Act and Assert
    assertTrue(lwM2MClientFwOtaInfo.isSupported());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isSupported()}
   */
  @Test
  void testIsSupported4() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setCurrentVersion(null);
    lwM2MClientFwOtaInfo.setCurrentVersion3("foo");
    lwM2MClientFwOtaInfo.setCurrentName(null);

    // Act and Assert
    assertTrue(lwM2MClientFwOtaInfo.isSupported());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isSupported()}
   */
  @Test
  void testIsSupported5() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setCurrentVersion("foo");
    lwM2MClientFwOtaInfo.setCurrentVersion3(null);
    lwM2MClientFwOtaInfo.setCurrentName(null);

    // Act and Assert
    assertTrue(lwM2MClientFwOtaInfo.isSupported());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isAssigned()}
   */
  @Test
  void testIsAssigned() {
    // Arrange, Act and Assert
    assertFalse((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).isAssigned());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isAssigned()}
   */
  @Test
  void testIsAssigned2() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetVersion(null);
    lwM2MClientFwOtaInfo.setTargetName("");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isAssigned());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isAssigned()}
   */
  @Test
  void testIsAssigned3() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetVersion(null);
    lwM2MClientFwOtaInfo.setTargetName("foo");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isAssigned());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#isAssigned()}
   */
  @Test
  void testIsAssigned4() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetVersion("foo");
    lwM2MClientFwOtaInfo.setTargetName("foo");

    // Act and Assert
    assertTrue(lwM2MClientFwOtaInfo.isAssigned());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getBaseUrl()}
   */
  @Test
  void testGetBaseUrl() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", (new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getBaseUrl());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getCurrentName()}
   */
  @Test
  void testGetCurrentName() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getCurrentName());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getCurrentVersion()}
   */
  @Test
  void testGetCurrentVersion() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getCurrentVersion());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getCurrentVersion3()}
   */
  @Test
  void testGetCurrentVersion3() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getCurrentVersion3());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getEndpoint()}
   */
  @Test
  void testGetEndpoint() {
    // Arrange, Act and Assert
    assertEquals("https://config.us-east-2.amazonaws.com",
        (new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getEndpoint());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getFailedPackageId()}
   */
  @Test
  void testGetFailedPackageId() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getFailedPackageId());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getPackageId(String, String)}
   */
  @Test
  void testGetPackageId() {
    // Arrange, Act and Assert
    assertEquals("Name1.0.2", LwM2MClientOtaInfo.getPackageId("Name", "1.0.2"));
    assertEquals("", LwM2MClientOtaInfo.getPackageId(null, null));
    assertEquals("", LwM2MClientOtaInfo.getPackageId(null, ""));
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getTargetPackageId()}
   */
  @Test
  void testGetTargetPackageId() {
    // Arrange, Act and Assert
    assertEquals("", (new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getTargetPackageId());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getTargetPackageId()}
   */
  @Test
  void testGetTargetPackageId2() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetVersion(null);
    lwM2MClientFwOtaInfo.setTargetName("");

    // Act and Assert
    assertEquals("", lwM2MClientFwOtaInfo.getTargetPackageId());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getTargetPackageId()}
   */
  @Test
  void testGetTargetPackageId3() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetVersion(null);
    lwM2MClientFwOtaInfo.setTargetName("foo");

    // Act and Assert
    assertEquals("foo", lwM2MClientFwOtaInfo.getTargetPackageId());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getTargetPackageId()}
   */
  @Test
  void testGetTargetPackageId4() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetVersion("foo");
    lwM2MClientFwOtaInfo.setTargetName(null);

    // Act and Assert
    assertEquals("foo", lwM2MClientFwOtaInfo.getTargetPackageId());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getResult()}
   */
  @Test
  void testGetResult() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getResult());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getRetryAttempts()}
   */
  @Test
  void testGetRetryAttempts() {
    // Arrange, Act and Assert
    assertEquals(0, (new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getRetryAttempts());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getStatus()}
   */
  @Test
  void testGetStatus() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getStatus());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getStrategy()}
   */
  @Test
  void testGetStrategy() {
    // Arrange, Act and Assert
    assertEquals(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY,
        (new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getStrategy());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getTargetName()}
   */
  @Test
  void testGetTargetName() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getTargetName());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getTargetTag()}
   */
  @Test
  void testGetTargetTag() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getTargetTag());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getTargetUrl()}
   */
  @Test
  void testGetTargetUrl() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getTargetUrl());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getTargetVersion()}
   */
  @Test
  void testGetTargetVersion() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getTargetVersion());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#getUpdateState()}
   */
  @Test
  void testGetUpdateState() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getUpdateState());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#setCurrentName(String)}
   */
  @Test
  void testSetCurrentName() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.setCurrentName("Current Name");

    // Assert
    assertEquals("Current Name", lwM2MClientFwOtaInfo.getCurrentName());
    assertTrue(lwM2MClientFwOtaInfo.isSupported());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#setCurrentVersion(String)}
   */
  @Test
  void testSetCurrentVersion() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.setCurrentVersion("1.0.2");

    // Assert
    assertEquals("1.0.2", lwM2MClientFwOtaInfo.getCurrentVersion());
    assertTrue(lwM2MClientFwOtaInfo.isSupported());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#setCurrentVersion3(String)}
   */
  @Test
  void testSetCurrentVersion3() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.setCurrentVersion3("1.0.2");

    // Assert
    assertEquals("1.0.2", lwM2MClientFwOtaInfo.getCurrentVersion3());
    assertTrue(lwM2MClientFwOtaInfo.isSupported());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#setFailedPackageId(String)}
   */
  @Test
  void testSetFailedPackageId() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.setFailedPackageId("42");

    // Assert
    assertEquals("42", lwM2MClientFwOtaInfo.getFailedPackageId());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#setResult(Object)}
   */
  @Test
  void testSetResult() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.setResult(FirmwareUpdateResult.INITIAL);

    // Assert
    assertEquals(FirmwareUpdateResult.INITIAL, lwM2MClientFwOtaInfo.getResult());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#setRetryAttempts(int)}
   */
  @Test
  void testSetRetryAttempts() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.setRetryAttempts(1);

    // Assert
    assertEquals(1, lwM2MClientFwOtaInfo.getRetryAttempts());
  }

  /**
   * Method under test:
   * {@link LwM2MClientOtaInfo#setStatus(OtaPackageUpdateStatus)}
   */
  @Test
  void testSetStatus() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.setStatus(OtaPackageUpdateStatus.QUEUED);

    // Assert
    assertEquals(OtaPackageUpdateStatus.QUEUED, lwM2MClientFwOtaInfo.getStatus());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#setTargetName(String)}
   */
  @Test
  void testSetTargetName() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Assert
    assertEquals("Target Name", lwM2MClientFwOtaInfo.getTargetName());
    assertEquals("Target Name", lwM2MClientFwOtaInfo.getTargetPackageId());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#setTargetTag(String)}
   */
  @Test
  void testSetTargetTag() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.setTargetTag("Target Tag");

    // Assert
    assertEquals("Target Tag", lwM2MClientFwOtaInfo.getTargetTag());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#setTargetUrl(String)}
   */
  @Test
  void testSetTargetUrl() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.setTargetUrl("https://example.org/example");

    // Assert
    assertEquals("https://example.org/example", lwM2MClientFwOtaInfo.getTargetUrl());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#setTargetVersion(String)}
   */
  @Test
  void testSetTargetVersion() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");

    // Assert
    assertEquals("1.0.2", lwM2MClientFwOtaInfo.getTargetPackageId());
    assertEquals("1.0.2", lwM2MClientFwOtaInfo.getTargetVersion());
  }

  /**
   * Method under test: {@link LwM2MClientOtaInfo#setUpdateState(Object)}
   */
  @Test
  void testSetUpdateState() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.setUpdateState(FirmwareUpdateState.IDLE);

    // Assert
    assertEquals(FirmwareUpdateState.IDLE, lwM2MClientFwOtaInfo.getUpdateState());
  }
}
