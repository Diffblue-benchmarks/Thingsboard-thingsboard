package org.thingsboard.server.transport.lwm2m.server.ota;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ota.OtaPackageUpdateStatus;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.FirmwareUpdateResult;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.FirmwareUpdateState;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MClientFwOtaInfo;
import org.thingsboard.server.transport.lwm2m.server.ota.firmware.LwM2MFirmwareUpdateStrategy;

class LwM2MClientOtaInfoDiffblueTest {
  /**
   * Test
   * {@link LwM2MClientOtaInfo#updateTarget(String, String, Optional, Optional)}.
   * <p>
   * Method under test:
   * {@link LwM2MClientOtaInfo#updateTarget(String, String, Optional, Optional)}
   */
  @Test
  @DisplayName("Test updateTarget(String, String, Optional, Optional)")
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
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired()")
  void testIsUpdateRequired() {
    // Arrange, Act and Assert
    assertFalse((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).isUpdateRequired());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired()")
  void testIsUpdateRequired2() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetName("");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired()")
  void testIsUpdateRequired3() {
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
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired()")
  void testIsUpdateRequired4() {
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
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired()")
  void testIsUpdateRequired5() {
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
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired()")
  void testIsUpdateRequired6() {
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
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired()")
  void testIsUpdateRequired7() {
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
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired()")
  void testIsUpdateRequired8() {
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
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired()")
  void testIsUpdateRequired9() {
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
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired()")
  void testIsUpdateRequired10() {
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
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired()")
  void testIsUpdateRequired11() {
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
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired()")
  void testIsUpdateRequired12() {
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
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired()")
  void testIsUpdateRequired13() {
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
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired(); then return 'false'")
  void testIsUpdateRequired_thenReturnFalse() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#isUpdateRequired()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isUpdateRequired()}
   */
  @Test
  @DisplayName("Test isUpdateRequired(); then return 'false'")
  void testIsUpdateRequired_thenReturnFalse2() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act and Assert
    assertFalse(lwM2MClientFwOtaInfo.isUpdateRequired());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#isSupported()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isSupported()}
   */
  @Test
  @DisplayName("Test isSupported()")
  void testIsSupported() {
    // Arrange, Act and Assert
    assertFalse((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).isSupported());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#isSupported()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isSupported()}
   */
  @Test
  @DisplayName("Test isSupported()")
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
   * Test {@link LwM2MClientOtaInfo#isSupported()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isSupported()}
   */
  @Test
  @DisplayName("Test isSupported()")
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
   * Test {@link LwM2MClientOtaInfo#isSupported()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isSupported()}
   */
  @Test
  @DisplayName("Test isSupported()")
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
   * Test {@link LwM2MClientOtaInfo#isSupported()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isSupported()}
   */
  @Test
  @DisplayName("Test isSupported()")
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
   * Test {@link LwM2MClientOtaInfo#isAssigned()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isAssigned()}
   */
  @Test
  @DisplayName("Test isAssigned()")
  void testIsAssigned() {
    // Arrange, Act and Assert
    assertFalse((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).isAssigned());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#isAssigned()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isAssigned()}
   */
  @Test
  @DisplayName("Test isAssigned()")
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
   * Test {@link LwM2MClientOtaInfo#isAssigned()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isAssigned()}
   */
  @Test
  @DisplayName("Test isAssigned()")
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
   * Test {@link LwM2MClientOtaInfo#isAssigned()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#isAssigned()}
   */
  @Test
  @DisplayName("Test isAssigned(); then return 'true'")
  void testIsAssigned_thenReturnTrue() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetVersion("foo");
    lwM2MClientFwOtaInfo.setTargetName("foo");

    // Act and Assert
    assertTrue(lwM2MClientFwOtaInfo.isAssigned());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getBaseUrl()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getBaseUrl()}
   */
  @Test
  @DisplayName("Test getBaseUrl()")
  void testGetBaseUrl() {
    // Arrange, Act and Assert
    assertEquals("https://example.org/example", (new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com",
        "https://example.org/example", LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getBaseUrl());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getCurrentName()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getCurrentName()}
   */
  @Test
  @DisplayName("Test getCurrentName()")
  void testGetCurrentName() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getCurrentName());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getCurrentVersion()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getCurrentVersion()}
   */
  @Test
  @DisplayName("Test getCurrentVersion()")
  void testGetCurrentVersion() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getCurrentVersion());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getCurrentVersion3()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getCurrentVersion3()}
   */
  @Test
  @DisplayName("Test getCurrentVersion3()")
  void testGetCurrentVersion3() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getCurrentVersion3());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getEndpoint()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getEndpoint()}
   */
  @Test
  @DisplayName("Test getEndpoint()")
  void testGetEndpoint() {
    // Arrange, Act and Assert
    assertEquals("https://config.us-east-2.amazonaws.com",
        (new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getEndpoint());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getFailedPackageId()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getFailedPackageId()}
   */
  @Test
  @DisplayName("Test getFailedPackageId()")
  void testGetFailedPackageId() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getFailedPackageId());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getPackageId(String, String)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getPackageId(String, String)}
   */
  @Test
  @DisplayName("Test getPackageId(String, String); when empty string; then return empty string")
  void testGetPackageId_whenEmptyString_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", LwM2MClientOtaInfo.getPackageId(null, ""));
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getPackageId(String, String)}.
   * <ul>
   *   <li>When {@code Name}.</li>
   *   <li>Then return {@code Name1.0.2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getPackageId(String, String)}
   */
  @Test
  @DisplayName("Test getPackageId(String, String); when 'Name'; then return 'Name1.0.2'")
  void testGetPackageId_whenName_thenReturnName102() {
    // Arrange, Act and Assert
    assertEquals("Name1.0.2", LwM2MClientOtaInfo.getPackageId("Name", "1.0.2"));
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getPackageId(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getPackageId(String, String)}
   */
  @Test
  @DisplayName("Test getPackageId(String, String); when 'null'; then return empty string")
  void testGetPackageId_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", LwM2MClientOtaInfo.getPackageId(null, null));
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getTargetPackageId()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getTargetPackageId()}
   */
  @Test
  @DisplayName("Test getTargetPackageId()")
  void testGetTargetPackageId() {
    // Arrange, Act and Assert
    assertEquals("", (new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getTargetPackageId());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getTargetPackageId()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getTargetPackageId()}
   */
  @Test
  @DisplayName("Test getTargetPackageId()")
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
   * Test {@link LwM2MClientOtaInfo#getTargetPackageId()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getTargetPackageId()}
   */
  @Test
  @DisplayName("Test getTargetPackageId()")
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
   * Test {@link LwM2MClientOtaInfo#getTargetPackageId()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getTargetPackageId()}
   */
  @Test
  @DisplayName("Test getTargetPackageId()")
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
   * Test {@link LwM2MClientOtaInfo#getResult()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getResult()}
   */
  @Test
  @DisplayName("Test getResult()")
  void testGetResult() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getResult());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getRetryAttempts()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getRetryAttempts()}
   */
  @Test
  @DisplayName("Test getRetryAttempts()")
  void testGetRetryAttempts() {
    // Arrange, Act and Assert
    assertEquals(0, (new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getRetryAttempts());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getStatus()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getStatus()}
   */
  @Test
  @DisplayName("Test getStatus()")
  void testGetStatus() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getStatus());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getStrategy()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getStrategy()}
   */
  @Test
  @DisplayName("Test getStrategy()")
  void testGetStrategy() {
    // Arrange, Act and Assert
    assertEquals(LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY,
        (new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getStrategy());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getTargetName()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getTargetName()}
   */
  @Test
  @DisplayName("Test getTargetName()")
  void testGetTargetName() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getTargetName());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getTargetTag()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getTargetTag()}
   */
  @Test
  @DisplayName("Test getTargetTag()")
  void testGetTargetTag() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getTargetTag());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getTargetUrl()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getTargetUrl()}
   */
  @Test
  @DisplayName("Test getTargetUrl()")
  void testGetTargetUrl() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getTargetUrl());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getTargetVersion()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getTargetVersion()}
   */
  @Test
  @DisplayName("Test getTargetVersion()")
  void testGetTargetVersion() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getTargetVersion());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#getUpdateState()}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#getUpdateState()}
   */
  @Test
  @DisplayName("Test getUpdateState()")
  void testGetUpdateState() {
    // Arrange, Act and Assert
    assertNull((new LwM2MClientFwOtaInfo("https://config.us-east-2.amazonaws.com", "https://example.org/example",
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY)).getUpdateState());
  }

  /**
   * Test {@link LwM2MClientOtaInfo#setCurrentName(String)}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#setCurrentName(String)}
   */
  @Test
  @DisplayName("Test setCurrentName(String)")
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
   * Test {@link LwM2MClientOtaInfo#setCurrentVersion(String)}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#setCurrentVersion(String)}
   */
  @Test
  @DisplayName("Test setCurrentVersion(String)")
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
   * Test {@link LwM2MClientOtaInfo#setCurrentVersion3(String)}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#setCurrentVersion3(String)}
   */
  @Test
  @DisplayName("Test setCurrentVersion3(String)")
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
   * Test {@link LwM2MClientOtaInfo#setFailedPackageId(String)}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#setFailedPackageId(String)}
   */
  @Test
  @DisplayName("Test setFailedPackageId(String)")
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
   * Test {@link LwM2MClientOtaInfo#setResult(Object)}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#setResult(Object)}
   */
  @Test
  @DisplayName("Test setResult(Object)")
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
   * Test {@link LwM2MClientOtaInfo#setRetryAttempts(int)}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#setRetryAttempts(int)}
   */
  @Test
  @DisplayName("Test setRetryAttempts(int)")
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
   * Test {@link LwM2MClientOtaInfo#setStatus(OtaPackageUpdateStatus)}.
   * <p>
   * Method under test:
   * {@link LwM2MClientOtaInfo#setStatus(OtaPackageUpdateStatus)}
   */
  @Test
  @DisplayName("Test setStatus(OtaPackageUpdateStatus)")
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
   * Test {@link LwM2MClientOtaInfo#setTargetName(String)}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#setTargetName(String)}
   */
  @Test
  @DisplayName("Test setTargetName(String)")
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
   * Test {@link LwM2MClientOtaInfo#setTargetTag(String)}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#setTargetTag(String)}
   */
  @Test
  @DisplayName("Test setTargetTag(String)")
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
   * Test {@link LwM2MClientOtaInfo#setTargetUrl(String)}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#setTargetUrl(String)}
   */
  @Test
  @DisplayName("Test setTargetUrl(String)")
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
   * Test {@link LwM2MClientOtaInfo#setTargetVersion(String)}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#setTargetVersion(String)}
   */
  @Test
  @DisplayName("Test setTargetVersion(String)")
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
   * Test {@link LwM2MClientOtaInfo#setUpdateState(Object)}.
   * <p>
   * Method under test: {@link LwM2MClientOtaInfo#setUpdateState(Object)}
   */
  @Test
  @DisplayName("Test setUpdateState(Object)")
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
