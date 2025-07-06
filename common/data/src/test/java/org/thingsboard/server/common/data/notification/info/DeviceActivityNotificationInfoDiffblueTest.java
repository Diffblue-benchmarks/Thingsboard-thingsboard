package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.notification.info.DeviceActivityNotificationInfo.DeviceActivityNotificationInfoBuilder;

@ContextConfiguration(classes = {DeviceActivityNotificationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class DeviceActivityNotificationInfoDiffblueTest {
  @Autowired private DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder;

  /**
   * Test DeviceActivityNotificationInfoBuilder {@link
   * DeviceActivityNotificationInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfoBuilder#build()}
   *   <li>{@link DeviceActivityNotificationInfoBuilder#deviceCustomerId(CustomerId)}
   *   <li>{@link DeviceActivityNotificationInfoBuilder#deviceId(UUID)}
   *   <li>{@link DeviceActivityNotificationInfoBuilder#deviceLabel(String)}
   *   <li>{@link DeviceActivityNotificationInfoBuilder#deviceName(String)}
   *   <li>{@link DeviceActivityNotificationInfoBuilder#deviceType(String)}
   *   <li>{@link DeviceActivityNotificationInfoBuilder#eventType(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test DeviceActivityNotificationInfoBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceActivityNotificationInfoBuilder.<init>()",
    "DeviceActivityNotificationInfo DeviceActivityNotificationInfoBuilder.build()",
    "DeviceActivityNotificationInfoBuilder DeviceActivityNotificationInfoBuilder.deviceCustomerId(CustomerId)",
    "DeviceActivityNotificationInfoBuilder DeviceActivityNotificationInfoBuilder.deviceId(UUID)",
    "DeviceActivityNotificationInfoBuilder DeviceActivityNotificationInfoBuilder.deviceLabel(String)",
    "DeviceActivityNotificationInfoBuilder DeviceActivityNotificationInfoBuilder.deviceName(String)",
    "DeviceActivityNotificationInfoBuilder DeviceActivityNotificationInfoBuilder.deviceType(String)",
    "DeviceActivityNotificationInfoBuilder DeviceActivityNotificationInfoBuilder.eventType(String)",
    "String DeviceActivityNotificationInfoBuilder.toString()"
  })
  void testDeviceActivityNotificationInfoBuilderBuild() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    CustomerId deviceCustomerId =
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        builderResult.deviceCustomerId(deviceCustomerId);
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DeviceActivityNotificationInfo actualBuildResult =
        deviceCustomerIdResult
            .deviceId(deviceId)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Assert
    assertTrue(actualBuildResult.getStateEntityId() instanceof DeviceId);
    Map<String, String> templateData = actualBuildResult.getTemplateData();
    assertEquals(5, templateData.size());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", templateData.get("deviceId"));
    UUID deviceId2 = actualBuildResult.getDeviceId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", deviceId2.toString());
    assertEquals("Device Label", templateData.get("deviceLabel"));
    assertEquals("Device Label", actualBuildResult.getDeviceLabel());
    assertEquals("Device Name", templateData.get("deviceName"));
    assertEquals("Device Name", actualBuildResult.getDeviceName());
    assertEquals("Device Type", templateData.get("deviceType"));
    assertEquals("Device Type", actualBuildResult.getDeviceType());
    assertEquals("Event Type", templateData.get("eventType"));
    assertEquals("Event Type", actualBuildResult.getEventType());
    assertNull(actualBuildResult.getDashboardId());
    assertNull(actualBuildResult.getAffectedTenantId());
    assertNull(actualBuildResult.getAffectedUserId());
    assertSame(deviceCustomerId, actualBuildResult.getAffectedCustomerId());
    assertSame(deviceCustomerId, actualBuildResult.getDeviceCustomerId());
    assertSame(deviceId, deviceId2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return size is five.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is five")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map DeviceActivityNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnSizeIsFive() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        builderResult.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act
    Map<String, String> actualTemplateData = buildResult.getTemplateData();

    // Assert
    assertEquals(5, actualTemplateData.size());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTemplateData.get("deviceId"));
    assertEquals("Device Label", actualTemplateData.get("deviceLabel"));
    assertEquals("Device Name", actualTemplateData.get("deviceName"));
    assertEquals("Device Type", actualTemplateData.get("deviceType"));
    assertEquals("Event Type", actualTemplateData.get("eventType"));
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#getStateEntityId()}.
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#getStateEntityId()}
   */
  @Test
  @DisplayName("Test getStateEntityId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityId DeviceActivityNotificationInfo.getStateEntityId()"})
  void testGetStateEntityId() {
    // Arrange and Act
    EntityId actualStateEntityId = new DeviceActivityNotificationInfo().getStateEntityId();

    // Assert
    assertTrue(actualStateEntityId instanceof DeviceId);
    assertNull(actualStateEntityId.getId());
    assertEquals(EntityType.DEVICE, actualStateEntityId.getEntityType());
    assertFalse(actualStateEntityId.isNullUid());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}, and {@link
   * DeviceActivityNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#equals(Object)}
   *   <li>{@link DeviceActivityNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        builderResult.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();
    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult2 =
        builderResult2.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult2 =
        deviceCustomerIdResult2
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}, and {@link
   * DeviceActivityNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#equals(Object)}
   *   <li>{@link DeviceActivityNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        builderResult.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult2 =
        builderResult.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult2 =
        deviceCustomerIdResult2
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceId(Mockito.<UUID>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder2.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult2 =
        builderResult.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult2 =
        deviceCustomerIdResult2
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceId(Mockito.<UUID>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder2.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType(null)
            .build();
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult2 =
        builderResult.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult2 =
        deviceCustomerIdResult2
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceId(Mockito.<UUID>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder2.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("42")
            .build();
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult2 =
        builderResult.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult2 =
        deviceCustomerIdResult2
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceId(Mockito.<UUID>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder2.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo buildResult2 =
        builderResult
            .deviceCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceId(null)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceId(Mockito.<UUID>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder2.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType(null)
            .build();
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult2 =
        builderResult.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult2 =
        deviceCustomerIdResult2
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType(null)
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceLabel(Mockito.<String>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder3.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo buildResult2 =
        builderResult
            .deviceCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceId(null)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceName(Mockito.<String>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder4.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo buildResult2 =
        builderResult
            .deviceCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceId(null)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceName(Mockito.<String>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder4.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo buildResult2 =
        builderResult
            .deviceCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceId(null)
            .deviceLabel("Device Label")
            .deviceName(null)
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    builderResult.deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceName(Mockito.<String>any()))
        .thenReturn(builderResult);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder4.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();
    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo buildResult2 =
        builderResult2
            .deviceCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceId(null)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    builderResult.deviceName("Event Type");
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceName(Mockito.<String>any()))
        .thenReturn(builderResult);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder4.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();
    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo buildResult2 =
        builderResult2
            .deviceCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceId(null)
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceName(Mockito.<String>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder4.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo buildResult2 =
        builderResult
            .deviceCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceId(null)
            .deviceLabel(null)
            .deviceName(null)
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    builderResult.deviceLabel("Event Type");
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceName(Mockito.<String>any()))
        .thenReturn(builderResult);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder4.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();
    DeviceActivityNotificationInfoBuilder builderResult2 = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo buildResult2 =
        builderResult2
            .deviceCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceId(null)
            .deviceLabel("Device Label")
            .deviceName(null)
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder.deviceType(Mockito.<String>any()))
        .thenReturn(DeviceActivityNotificationInfo.builder());
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder2 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder2.deviceName(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder3 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder3.deviceLabel(Mockito.<String>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder2);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder4 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder4.deviceId(Mockito.<UUID>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder3);
    DeviceActivityNotificationInfoBuilder deviceActivityNotificationInfoBuilder5 =
        mock(DeviceActivityNotificationInfoBuilder.class);
    when(deviceActivityNotificationInfoBuilder5.deviceCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(deviceActivityNotificationInfoBuilder4);
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        deviceActivityNotificationInfoBuilder5.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfo buildResult2 =
        builderResult
            .deviceCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .deviceId(null)
            .deviceLabel(null)
            .deviceName(null)
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        builderResult.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link DeviceActivityNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceActivityNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceActivityNotificationInfo.equals(Object)",
    "int DeviceActivityNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceActivityNotificationInfoBuilder builderResult = DeviceActivityNotificationInfo.builder();
    DeviceActivityNotificationInfoBuilder deviceCustomerIdResult =
        builderResult.deviceCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    DeviceActivityNotificationInfo buildResult =
        deviceCustomerIdResult
            .deviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .deviceLabel("Device Label")
            .deviceName("Device Name")
            .deviceType("Device Type")
            .eventType("Event Type")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to DeviceActivityNotificationInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#DeviceActivityNotificationInfo()}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceCustomerId(CustomerId)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceId(UUID)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceLabel(String)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceName(String)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceType(String)}
   *   <li>{@link DeviceActivityNotificationInfo#setEventType(String)}
   *   <li>{@link DeviceActivityNotificationInfo#toString()}
   *   <li>{@link DeviceActivityNotificationInfo#getAffectedCustomerId()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceCustomerId()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceId()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceLabel()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceName()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceType()}
   *   <li>{@link DeviceActivityNotificationInfo#getEventType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceActivityNotificationInfo.<init>()",
    "void DeviceActivityNotificationInfo.<init>(String, UUID, String, String, String, CustomerId)",
    "CustomerId DeviceActivityNotificationInfo.getAffectedCustomerId()",
    "CustomerId DeviceActivityNotificationInfo.getDeviceCustomerId()",
    "UUID DeviceActivityNotificationInfo.getDeviceId()",
    "String DeviceActivityNotificationInfo.getDeviceLabel()",
    "String DeviceActivityNotificationInfo.getDeviceName()",
    "String DeviceActivityNotificationInfo.getDeviceType()",
    "String DeviceActivityNotificationInfo.getEventType()",
    "void DeviceActivityNotificationInfo.setDeviceCustomerId(CustomerId)",
    "void DeviceActivityNotificationInfo.setDeviceId(UUID)",
    "void DeviceActivityNotificationInfo.setDeviceLabel(String)",
    "void DeviceActivityNotificationInfo.setDeviceName(String)",
    "void DeviceActivityNotificationInfo.setDeviceType(String)",
    "void DeviceActivityNotificationInfo.setEventType(String)",
    "String DeviceActivityNotificationInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    DeviceActivityNotificationInfo actualDeviceActivityNotificationInfo =
        new DeviceActivityNotificationInfo();
    CustomerId deviceCustomerId =
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualDeviceActivityNotificationInfo.setDeviceCustomerId(deviceCustomerId);
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDeviceActivityNotificationInfo.setDeviceId(deviceId);
    actualDeviceActivityNotificationInfo.setDeviceLabel("Device Label");
    actualDeviceActivityNotificationInfo.setDeviceName("Device Name");
    actualDeviceActivityNotificationInfo.setDeviceType("Device Type");
    actualDeviceActivityNotificationInfo.setEventType("Event Type");
    String actualToStringResult = actualDeviceActivityNotificationInfo.toString();
    CustomerId actualAffectedCustomerId =
        actualDeviceActivityNotificationInfo.getAffectedCustomerId();
    CustomerId actualDeviceCustomerId = actualDeviceActivityNotificationInfo.getDeviceCustomerId();
    UUID actualDeviceId = actualDeviceActivityNotificationInfo.getDeviceId();
    String actualDeviceLabel = actualDeviceActivityNotificationInfo.getDeviceLabel();
    String actualDeviceName = actualDeviceActivityNotificationInfo.getDeviceName();
    String actualDeviceType = actualDeviceActivityNotificationInfo.getDeviceType();

    // Assert
    assertEquals("Device Label", actualDeviceLabel);
    assertEquals("Device Name", actualDeviceName);
    assertEquals("Device Type", actualDeviceType);
    assertEquals(
        "DeviceActivityNotificationInfo(eventType=Event Type, deviceId=784f394c-42b6-435a-983c-b7beff2784f9,"
            + " deviceName=Device Name, deviceLabel=Device Label, deviceType=Device Type, deviceCustomerId=784f394c"
            + "-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertEquals("Event Type", actualDeviceActivityNotificationInfo.getEventType());
    assertSame(deviceCustomerId, actualAffectedCustomerId);
    assertSame(deviceCustomerId, actualDeviceCustomerId);
    assertSame(deviceId, actualDeviceId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Event Type}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceActivityNotificationInfo#DeviceActivityNotificationInfo(String, UUID,
   *       String, String, String, CustomerId)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceCustomerId(CustomerId)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceId(UUID)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceLabel(String)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceName(String)}
   *   <li>{@link DeviceActivityNotificationInfo#setDeviceType(String)}
   *   <li>{@link DeviceActivityNotificationInfo#setEventType(String)}
   *   <li>{@link DeviceActivityNotificationInfo#toString()}
   *   <li>{@link DeviceActivityNotificationInfo#getAffectedCustomerId()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceCustomerId()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceId()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceLabel()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceName()}
   *   <li>{@link DeviceActivityNotificationInfo#getDeviceType()}
   *   <li>{@link DeviceActivityNotificationInfo#getEventType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Event Type'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceActivityNotificationInfo.<init>()",
    "void DeviceActivityNotificationInfo.<init>(String, UUID, String, String, String, CustomerId)",
    "CustomerId DeviceActivityNotificationInfo.getAffectedCustomerId()",
    "CustomerId DeviceActivityNotificationInfo.getDeviceCustomerId()",
    "UUID DeviceActivityNotificationInfo.getDeviceId()",
    "String DeviceActivityNotificationInfo.getDeviceLabel()",
    "String DeviceActivityNotificationInfo.getDeviceName()",
    "String DeviceActivityNotificationInfo.getDeviceType()",
    "String DeviceActivityNotificationInfo.getEventType()",
    "void DeviceActivityNotificationInfo.setDeviceCustomerId(CustomerId)",
    "void DeviceActivityNotificationInfo.setDeviceId(UUID)",
    "void DeviceActivityNotificationInfo.setDeviceLabel(String)",
    "void DeviceActivityNotificationInfo.setDeviceName(String)",
    "void DeviceActivityNotificationInfo.setDeviceType(String)",
    "void DeviceActivityNotificationInfo.setEventType(String)",
    "String DeviceActivityNotificationInfo.toString()"
  })
  void testGettersAndSetters_whenEventType() {
    // Arrange
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DeviceActivityNotificationInfo actualDeviceActivityNotificationInfo =
        new DeviceActivityNotificationInfo(
            "Event Type",
            deviceId,
            "Device Name",
            "Device Label",
            "Device Type",
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    CustomerId deviceCustomerId =
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualDeviceActivityNotificationInfo.setDeviceCustomerId(deviceCustomerId);
    UUID deviceId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDeviceActivityNotificationInfo.setDeviceId(deviceId2);
    actualDeviceActivityNotificationInfo.setDeviceLabel("Device Label");
    actualDeviceActivityNotificationInfo.setDeviceName("Device Name");
    actualDeviceActivityNotificationInfo.setDeviceType("Device Type");
    actualDeviceActivityNotificationInfo.setEventType("Event Type");
    String actualToStringResult = actualDeviceActivityNotificationInfo.toString();
    CustomerId actualAffectedCustomerId =
        actualDeviceActivityNotificationInfo.getAffectedCustomerId();
    CustomerId actualDeviceCustomerId = actualDeviceActivityNotificationInfo.getDeviceCustomerId();
    UUID actualDeviceId = actualDeviceActivityNotificationInfo.getDeviceId();
    String actualDeviceLabel = actualDeviceActivityNotificationInfo.getDeviceLabel();
    String actualDeviceName = actualDeviceActivityNotificationInfo.getDeviceName();
    String actualDeviceType = actualDeviceActivityNotificationInfo.getDeviceType();

    // Assert
    assertEquals("Device Label", actualDeviceLabel);
    assertEquals("Device Name", actualDeviceName);
    assertEquals("Device Type", actualDeviceType);
    assertEquals(
        "DeviceActivityNotificationInfo(eventType=Event Type, deviceId=784f394c-42b6-435a-983c-b7beff2784f9,"
            + " deviceName=Device Name, deviceLabel=Device Label, deviceType=Device Type, deviceCustomerId=784f394c"
            + "-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertEquals("Event Type", actualDeviceActivityNotificationInfo.getEventType());
    assertSame(deviceCustomerId, actualAffectedCustomerId);
    assertSame(deviceCustomerId, actualDeviceCustomerId);
    assertSame(deviceId2, actualDeviceId);
  }
}
