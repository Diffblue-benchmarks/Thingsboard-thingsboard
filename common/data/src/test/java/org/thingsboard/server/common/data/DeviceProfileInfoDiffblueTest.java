package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceProfileInfoDiffblueTest {
  /**
   * Test {@link DeviceProfileInfo#DeviceProfileInfo(DeviceProfile)}.
   *
   * <p>Method under test: {@link DeviceProfileInfo#DeviceProfileInfo(DeviceProfile)}
   */
  @Test
  @DisplayName("Test new DeviceProfileInfo(DeviceProfile)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceProfileInfo.<init>(DeviceProfile)"})
  void testNewDeviceProfileInfo() {
    // Arrange and Act
    DeviceProfileInfo actualDeviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());

    // Assert
    assertNull(actualDeviceProfileInfo.getImage());
    assertNull(actualDeviceProfileInfo.getName());
    assertNull(actualDeviceProfileInfo.getType());
    assertNull(actualDeviceProfileInfo.getTransportType());
    assertNull(actualDeviceProfileInfo.getDefaultDashboardId());
    assertNull(actualDeviceProfileInfo.getId());
    assertNull(actualDeviceProfileInfo.getTenantId());
  }

  /**
   * Test {@link DeviceProfileInfo#DeviceProfileInfo(UUID, UUID, String, String, UUID,
   * DeviceProfileType, DeviceTransportType)}.
   *
   * <ul>
   *   <li>Then return DefaultDashboardId EntityType is {@code DASHBOARD}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#DeviceProfileInfo(UUID, UUID, String, String,
   * UUID, DeviceProfileType, DeviceTransportType)}
   */
  @Test
  @DisplayName(
      "Test new DeviceProfileInfo(UUID, UUID, String, String, UUID, DeviceProfileType, DeviceTransportType); then return DefaultDashboardId EntityType is 'DASHBOARD'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceProfileInfo.<init>(UUID, UUID, String, String, UUID, DeviceProfileType, DeviceTransportType)"
  })
  void testNewDeviceProfileInfo_thenReturnDefaultDashboardIdEntityTypeIsDashboard() {
    // Arrange
    UUID uuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID defaultDashboardId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DeviceProfileInfo actualDeviceProfileInfo =
        new DeviceProfileInfo(
            uuid,
            tenantId,
            "Name",
            "Image",
            defaultDashboardId,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Assert
    EntityId id = actualDeviceProfileInfo.getId();
    assertTrue(id instanceof DeviceProfileId);
    assertEquals("Image", actualDeviceProfileInfo.getImage());
    assertEquals("Name", actualDeviceProfileInfo.getName());
    assertEquals(DeviceProfileType.DEFAULT, actualDeviceProfileInfo.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualDeviceProfileInfo.getTransportType());
    DashboardId defaultDashboardId2 = actualDeviceProfileInfo.getDefaultDashboardId();
    assertEquals(EntityType.DASHBOARD, defaultDashboardId2.getEntityType());
    assertEquals(EntityType.DEVICE_PROFILE, id.getEntityType());
    TenantId tenantId2 = actualDeviceProfileInfo.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(defaultDashboardId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(id.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(uuid, id.getId());
    assertSame(defaultDashboardId, defaultDashboardId2.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DeviceProfileInfo#DeviceProfileInfo(UUID, UUID, String, String, UUID,
   * DeviceProfileType, DeviceTransportType)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return DefaultDashboardId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#DeviceProfileInfo(UUID, UUID, String, String,
   * UUID, DeviceProfileType, DeviceTransportType)}
   */
  @Test
  @DisplayName(
      "Test new DeviceProfileInfo(UUID, UUID, String, String, UUID, DeviceProfileType, DeviceTransportType); when 'null'; then return DefaultDashboardId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeviceProfileInfo.<init>(UUID, UUID, String, String, UUID, DeviceProfileType, DeviceTransportType)"
  })
  void testNewDeviceProfileInfo_whenNull_thenReturnDefaultDashboardIdIsNull() {
    // Arrange
    UUID uuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DeviceProfileInfo actualDeviceProfileInfo =
        new DeviceProfileInfo(
            uuid,
            tenantId,
            "Name",
            "Image",
            null,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Assert
    EntityId id = actualDeviceProfileInfo.getId();
    assertTrue(id instanceof DeviceProfileId);
    assertEquals("Image", actualDeviceProfileInfo.getImage());
    assertEquals("Name", actualDeviceProfileInfo.getName());
    assertNull(actualDeviceProfileInfo.getDefaultDashboardId());
    assertEquals(DeviceProfileType.DEFAULT, actualDeviceProfileInfo.getType());
    assertEquals(DeviceTransportType.DEFAULT, actualDeviceProfileInfo.getTransportType());
    assertEquals(EntityType.DEVICE_PROFILE, id.getEntityType());
    TenantId tenantId2 = actualDeviceProfileInfo.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(id.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(uuid, id.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}, and {@link DeviceProfileInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileInfo#equals(Object)}
   *   <li>{@link DeviceProfileInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());
    DeviceProfileInfo deviceProfileInfo2 = new DeviceProfileInfo(new DeviceProfile());

    // Act and Assert
    assertEquals(deviceProfileInfo, deviceProfileInfo2);
    int expectedHashCodeResult = deviceProfileInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceProfileInfo2.hashCode());
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}, and {@link DeviceProfileInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileInfo#equals(Object)}
   *   <li>{@link DeviceProfileInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UUID uuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            uuid,
            tenantId,
            "Name",
            "Image",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);
    UUID uuid2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceProfileInfo deviceProfileInfo2 =
        new DeviceProfileInfo(
            uuid2,
            tenantId2,
            "Name",
            "Image",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Act and Assert
    assertEquals(deviceProfileInfo, deviceProfileInfo2);
    int expectedHashCodeResult = deviceProfileInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceProfileInfo2.hashCode());
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}, and {@link DeviceProfileInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceProfileInfo#equals(Object)}
   *   <li>{@link DeviceProfileInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());

    // Act and Assert
    assertEquals(deviceProfileInfo, deviceProfileInfo);
    int expectedHashCodeResult = deviceProfileInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceProfileInfo.hashCode());
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID uuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            uuid,
            tenantId,
            "Name",
            "Image",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(deviceProfileInfo, new DeviceProfileInfo(new DeviceProfile()));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceProfile profile = new DeviceProfile();
    profile.setTenantId(TenantId.SYS_TENANT_ID);
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(profile);

    // Act and Assert
    assertNotEquals(deviceProfileInfo, new DeviceProfileInfo(new DeviceProfile()));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceProfile profile = new DeviceProfile();
    profile.setImage("Image");
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(profile);

    // Act and Assert
    assertNotEquals(deviceProfileInfo, new DeviceProfileInfo(new DeviceProfile()));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceProfile profile = new DeviceProfile();
    profile.setType(DeviceProfileType.DEFAULT);
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(profile);

    // Act and Assert
    assertNotEquals(deviceProfileInfo, new DeviceProfileInfo(new DeviceProfile()));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceProfile profile = new DeviceProfile();
    profile.setTransportType(DeviceTransportType.DEFAULT);
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(profile);

    // Act and Assert
    assertNotEquals(deviceProfileInfo, new DeviceProfileInfo(new DeviceProfile()));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());

    DeviceProfile profile = new DeviceProfile();
    profile.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(deviceProfileInfo, new DeviceProfileInfo(profile));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());

    DeviceProfile profile = new DeviceProfile();
    profile.setImage("Image");

    // Act and Assert
    assertNotEquals(deviceProfileInfo, new DeviceProfileInfo(profile));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());

    DeviceProfile profile = new DeviceProfile();
    profile.setType(DeviceProfileType.DEFAULT);

    // Act and Assert
    assertNotEquals(deviceProfileInfo, new DeviceProfileInfo(profile));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceProfileInfo deviceProfileInfo = new DeviceProfileInfo(new DeviceProfile());

    DeviceProfile profile = new DeviceProfile();
    profile.setTransportType(DeviceTransportType.DEFAULT);

    // Act and Assert
    assertNotEquals(deviceProfileInfo, new DeviceProfileInfo(profile));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    UUID uuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            uuid,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "Name",
            "Image",
            EntityId.NULL_UUID,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);
    UUID uuid2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(
        deviceProfileInfo,
        new DeviceProfileInfo(
            uuid2,
            tenantId,
            "Name",
            "Image",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    UUID uuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceProfileInfo deviceProfileInfo =
        new DeviceProfileInfo(
            uuid,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "Name",
            "Image",
            null,
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT);
    UUID uuid2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(
        deviceProfileInfo,
        new DeviceProfileInfo(
            uuid2,
            tenantId,
            "Name",
            "Image",
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            DeviceProfileType.DEFAULT,
            DeviceTransportType.DEFAULT));
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceProfileInfo(new DeviceProfile()), null);
  }

  /**
   * Test {@link DeviceProfileInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeviceProfileInfo.equals(Object)",
    "int DeviceProfileInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DeviceProfileInfo(new DeviceProfile()), "Different type to DeviceProfileInfo");
  }
}
