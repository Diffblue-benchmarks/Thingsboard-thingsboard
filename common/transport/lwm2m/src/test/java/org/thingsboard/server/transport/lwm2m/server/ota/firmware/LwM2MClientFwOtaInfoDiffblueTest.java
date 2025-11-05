package org.thingsboard.server.transport.lwm2m.server.ota.firmware;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ota.OtaPackageType;

class LwM2MClientFwOtaInfoDiffblueTest {
  /**
   * Test {@link LwM2MClientFwOtaInfo#equals(Object)}, and {@link LwM2MClientFwOtaInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MClientFwOtaInfo#equals(Object)}
   *   <li>{@link LwM2MClientFwOtaInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MClientFwOtaInfo.equals(Object)",
    "int LwM2MClientFwOtaInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo2 =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act and Assert
    assertEquals(lwM2MClientFwOtaInfo, lwM2MClientFwOtaInfo2);
    assertEquals(lwM2MClientFwOtaInfo.hashCode(), lwM2MClientFwOtaInfo2.hashCode());
  }

  /**
   * Test {@link LwM2MClientFwOtaInfo#equals(Object)}, and {@link LwM2MClientFwOtaInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MClientFwOtaInfo#equals(Object)}
   *   <li>{@link LwM2MClientFwOtaInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MClientFwOtaInfo.equals(Object)",
    "int LwM2MClientFwOtaInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setDeliveryMethod(1);

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo2 =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo2.setDeliveryMethod(1);

    // Act and Assert
    assertEquals(lwM2MClientFwOtaInfo, lwM2MClientFwOtaInfo2);
    assertEquals(lwM2MClientFwOtaInfo.hashCode(), lwM2MClientFwOtaInfo2.hashCode());
  }

  /**
   * Test {@link LwM2MClientFwOtaInfo#equals(Object)}, and {@link LwM2MClientFwOtaInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MClientFwOtaInfo#equals(Object)}
   *   <li>{@link LwM2MClientFwOtaInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MClientFwOtaInfo.equals(Object)",
    "int LwM2MClientFwOtaInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act and Assert
    assertEquals(lwM2MClientFwOtaInfo, lwM2MClientFwOtaInfo);
    int expectedHashCodeResult = lwM2MClientFwOtaInfo.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MClientFwOtaInfo.hashCode());
  }

  /**
   * Test {@link LwM2MClientFwOtaInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MClientFwOtaInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MClientFwOtaInfo.equals(Object)",
    "int LwM2MClientFwOtaInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo =
        new LwM2MClientFwOtaInfo(
            "https://example.org/example",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act and Assert
    assertNotEquals(
        lwM2MClientFwOtaInfo,
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
  }

  /**
   * Test {@link LwM2MClientFwOtaInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MClientFwOtaInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MClientFwOtaInfo.equals(Object)",
    "int LwM2MClientFwOtaInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setDeliveryMethod(1);

    // Act and Assert
    assertNotEquals(
        lwM2MClientFwOtaInfo,
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY));
  }

  /**
   * Test {@link LwM2MClientFwOtaInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MClientFwOtaInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MClientFwOtaInfo.equals(Object)",
    "int LwM2MClientFwOtaInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo2 =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo2.setDeliveryMethod(1);

    // Act and Assert
    assertNotEquals(lwM2MClientFwOtaInfo, lwM2MClientFwOtaInfo2);
  }

  /**
   * Test {@link LwM2MClientFwOtaInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MClientFwOtaInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MClientFwOtaInfo.equals(Object)",
    "int LwM2MClientFwOtaInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY),
        null);
  }

  /**
   * Test {@link LwM2MClientFwOtaInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MClientFwOtaInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MClientFwOtaInfo.equals(Object)",
    "int LwM2MClientFwOtaInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY),
        "Different type to LwM2MClientFwOtaInfo");
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
   *   <li>{@link LwM2MClientFwOtaInfo#LwM2MClientFwOtaInfo()}
   *   <li>{@link LwM2MClientFwOtaInfo#setDeliveryMethod(Integer)}
   *   <li>{@link LwM2MClientFwOtaInfo#toString()}
   *   <li>{@link LwM2MClientFwOtaInfo#getDeliveryMethod()}
   *   <li>{@link LwM2MClientFwOtaInfo#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return BaseUrl is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MClientFwOtaInfo.<init>()",
    "void LwM2MClientFwOtaInfo.<init>(String, String, LwM2MFirmwareUpdateStrategy)",
    "Integer LwM2MClientFwOtaInfo.getDeliveryMethod()",
    "OtaPackageType LwM2MClientFwOtaInfo.getType()",
    "void LwM2MClientFwOtaInfo.setDeliveryMethod(Integer)",
    "String LwM2MClientFwOtaInfo.toString()"
  })
  void testGettersAndSetters_thenReturnBaseUrlIsNull() {
    // Arrange and Act
    LwM2MClientFwOtaInfo actualLwM2MClientFwOtaInfo = new LwM2MClientFwOtaInfo();
    actualLwM2MClientFwOtaInfo.setDeliveryMethod(1);
    String actualToStringResult = actualLwM2MClientFwOtaInfo.toString();
    Integer actualDeliveryMethod = actualLwM2MClientFwOtaInfo.getDeliveryMethod();
    OtaPackageType actualType = actualLwM2MClientFwOtaInfo.getType();

    // Assert
    assertEquals(
        "LwM2MClientFwOtaInfo(super=LwM2MClientOtaInfo(endpoint=null, baseUrl=null, targetName=null,"
            + " targetVersion=null, targetTag=null, targetUrl=null, strategy=null, updateState=null, result=null,"
            + " status=null, failedPackageId=null, retryAttempts=0, currentName=null, currentVersion3=null,"
            + " currentVersion=null), deliveryMethod=1)",
        actualToStringResult);
    assertNull(actualLwM2MClientFwOtaInfo.getBaseUrl());
    assertNull(actualLwM2MClientFwOtaInfo.getCurrentName());
    assertNull(actualLwM2MClientFwOtaInfo.getCurrentVersion());
    assertNull(actualLwM2MClientFwOtaInfo.getCurrentVersion3());
    assertNull(actualLwM2MClientFwOtaInfo.getEndpoint());
    assertNull(actualLwM2MClientFwOtaInfo.getFailedPackageId());
    assertNull(actualLwM2MClientFwOtaInfo.getTargetName());
    assertNull(actualLwM2MClientFwOtaInfo.getTargetTag());
    assertNull(actualLwM2MClientFwOtaInfo.getTargetUrl());
    assertNull(actualLwM2MClientFwOtaInfo.getTargetVersion());
    assertNull(actualLwM2MClientFwOtaInfo.getStatus());
    assertNull(actualLwM2MClientFwOtaInfo.getResult());
    assertNull(actualLwM2MClientFwOtaInfo.getUpdateState());
    assertNull(actualLwM2MClientFwOtaInfo.getStrategy());
    assertEquals(0, actualLwM2MClientFwOtaInfo.getRetryAttempts());
    assertEquals(1, actualDeliveryMethod.intValue());
    assertEquals(OtaPackageType.FIRMWARE, actualType);
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
   *   <li>{@link LwM2MClientFwOtaInfo#LwM2MClientFwOtaInfo(String, String,
   *       LwM2MFirmwareUpdateStrategy)}
   *   <li>{@link LwM2MClientFwOtaInfo#setDeliveryMethod(Integer)}
   *   <li>{@link LwM2MClientFwOtaInfo#toString()}
   *   <li>{@link LwM2MClientFwOtaInfo#getDeliveryMethod()}
   *   <li>{@link LwM2MClientFwOtaInfo#getType()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; then return Endpoint is 'https://config.us-east-2.amazonaws.com'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MClientFwOtaInfo.<init>()",
    "void LwM2MClientFwOtaInfo.<init>(String, String, LwM2MFirmwareUpdateStrategy)",
    "Integer LwM2MClientFwOtaInfo.getDeliveryMethod()",
    "OtaPackageType LwM2MClientFwOtaInfo.getType()",
    "void LwM2MClientFwOtaInfo.setDeliveryMethod(Integer)",
    "String LwM2MClientFwOtaInfo.toString()"
  })
  void testGettersAndSetters_thenReturnEndpointIsHttpsConfigUsEast2AmazonawsCom() {
    // Arrange and Act
    LwM2MClientFwOtaInfo actualLwM2MClientFwOtaInfo =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    actualLwM2MClientFwOtaInfo.setDeliveryMethod(1);
    String actualToStringResult = actualLwM2MClientFwOtaInfo.toString();
    Integer actualDeliveryMethod = actualLwM2MClientFwOtaInfo.getDeliveryMethod();
    OtaPackageType actualType = actualLwM2MClientFwOtaInfo.getType();

    // Assert
    assertEquals(
        "LwM2MClientFwOtaInfo(super=LwM2MClientOtaInfo(endpoint=https://config.us-east-2.amazonaws.com,"
            + " baseUrl=https://example.org/example, targetName=null, targetVersion=null, targetTag=null, targetUrl=null,"
            + " strategy=OBJ_5_BINARY, updateState=null, result=null, status=null, failedPackageId=null, retryAttempts=0,"
            + " currentName=null, currentVersion3=null, currentVersion=null), deliveryMethod=1)",
        actualToStringResult);
    assertEquals(
        "https://config.us-east-2.amazonaws.com", actualLwM2MClientFwOtaInfo.getEndpoint());
    assertEquals("https://example.org/example", actualLwM2MClientFwOtaInfo.getBaseUrl());
    assertNull(actualLwM2MClientFwOtaInfo.getCurrentName());
    assertNull(actualLwM2MClientFwOtaInfo.getCurrentVersion());
    assertNull(actualLwM2MClientFwOtaInfo.getCurrentVersion3());
    assertNull(actualLwM2MClientFwOtaInfo.getFailedPackageId());
    assertNull(actualLwM2MClientFwOtaInfo.getTargetName());
    assertNull(actualLwM2MClientFwOtaInfo.getTargetTag());
    assertNull(actualLwM2MClientFwOtaInfo.getTargetUrl());
    assertNull(actualLwM2MClientFwOtaInfo.getTargetVersion());
    assertNull(actualLwM2MClientFwOtaInfo.getStatus());
    assertNull(actualLwM2MClientFwOtaInfo.getResult());
    assertNull(actualLwM2MClientFwOtaInfo.getUpdateState());
    assertEquals(0, actualLwM2MClientFwOtaInfo.getRetryAttempts());
    assertEquals(1, actualDeliveryMethod.intValue());
    assertEquals(OtaPackageType.FIRMWARE, actualType);
    assertEquals(
        LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY, actualLwM2MClientFwOtaInfo.getStrategy());
  }

  /**
   * Test {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)} with {@code
   * FirmwareUpdateResult}.
   *
   * <p>Method under test: {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)}
   */
  @Test
  @DisplayName("Test update(FirmwareUpdateResult) with 'FirmwareUpdateResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MClientFwOtaInfo.update(FirmwareUpdateResult)"})
  void testUpdateWithFirmwareUpdateResult() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.update(FirmwareUpdateResult.INITIAL);

    // Assert
    assertNull(lwM2MClientFwOtaInfo.getFailedPackageId());
    assertEquals(FirmwareUpdateResult.INITIAL, lwM2MClientFwOtaInfo.getResult());
  }

  /**
   * Test {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)} with {@code
   * FirmwareUpdateResult}.
   *
   * <p>Method under test: {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)}
   */
  @Test
  @DisplayName("Test update(FirmwareUpdateResult) with 'FirmwareUpdateResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MClientFwOtaInfo.update(FirmwareUpdateResult)"})
  void testUpdateWithFirmwareUpdateResult2() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.update(FirmwareUpdateResult.UPDATE_SUCCESSFULLY);

    // Assert
    assertNull(lwM2MClientFwOtaInfo.getFailedPackageId());
    assertEquals(FirmwareUpdateResult.UPDATE_SUCCESSFULLY, lwM2MClientFwOtaInfo.getResult());
  }

  /**
   * Test {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)} with {@code
   * FirmwareUpdateResult}.
   *
   * <p>Method under test: {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)}
   */
  @Test
  @DisplayName("Test update(FirmwareUpdateResult) with 'FirmwareUpdateResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MClientFwOtaInfo.update(FirmwareUpdateResult)"})
  void testUpdateWithFirmwareUpdateResult3() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);

    // Act
    lwM2MClientFwOtaInfo.update(FirmwareUpdateResult.NOT_ENOUGH);

    // Assert
    assertEquals("", lwM2MClientFwOtaInfo.getFailedPackageId());
    assertEquals(FirmwareUpdateResult.NOT_ENOUGH, lwM2MClientFwOtaInfo.getResult());
  }

  /**
   * Test {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)} with {@code
   * FirmwareUpdateResult}.
   *
   * <p>Method under test: {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)}
   */
  @Test
  @DisplayName("Test update(FirmwareUpdateResult) with 'FirmwareUpdateResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MClientFwOtaInfo.update(FirmwareUpdateResult)"})
  void testUpdateWithFirmwareUpdateResult4() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetName("Target Name");

    // Act
    lwM2MClientFwOtaInfo.update(FirmwareUpdateResult.NOT_ENOUGH);

    // Assert
    assertEquals("Target Name", lwM2MClientFwOtaInfo.getFailedPackageId());
    assertEquals(FirmwareUpdateResult.NOT_ENOUGH, lwM2MClientFwOtaInfo.getResult());
  }

  /**
   * Test {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)} with {@code
   * FirmwareUpdateResult}.
   *
   * <p>Method under test: {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)}
   */
  @Test
  @DisplayName("Test update(FirmwareUpdateResult) with 'FirmwareUpdateResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MClientFwOtaInfo.update(FirmwareUpdateResult)"})
  void testUpdateWithFirmwareUpdateResult5() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetVersion("1.0.2");

    // Act
    lwM2MClientFwOtaInfo.update(FirmwareUpdateResult.NOT_ENOUGH);

    // Assert
    assertEquals("1.0.2", lwM2MClientFwOtaInfo.getFailedPackageId());
    assertEquals(FirmwareUpdateResult.NOT_ENOUGH, lwM2MClientFwOtaInfo.getResult());
  }

  /**
   * Test {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)} with {@code
   * FirmwareUpdateResult}.
   *
   * <p>Method under test: {@link LwM2MClientFwOtaInfo#update(FirmwareUpdateResult)}
   */
  @Test
  @DisplayName("Test update(FirmwareUpdateResult) with 'FirmwareUpdateResult'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LwM2MClientFwOtaInfo.update(FirmwareUpdateResult)"})
  void testUpdateWithFirmwareUpdateResult6() {
    // Arrange
    LwM2MClientFwOtaInfo lwM2MClientFwOtaInfo =
        new LwM2MClientFwOtaInfo(
            "https://config.us-east-2.amazonaws.com",
            "https://example.org/example",
            LwM2MFirmwareUpdateStrategy.OBJ_5_BINARY);
    lwM2MClientFwOtaInfo.setTargetName("");

    // Act
    lwM2MClientFwOtaInfo.update(FirmwareUpdateResult.NOT_ENOUGH);

    // Assert
    assertEquals("", lwM2MClientFwOtaInfo.getFailedPackageId());
    assertEquals(FirmwareUpdateResult.NOT_ENOUGH, lwM2MClientFwOtaInfo.getResult());
  }
}
