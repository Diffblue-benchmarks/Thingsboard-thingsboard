package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceIdInfoDiffblueTest {
  /**
   * Test {@link DeviceIdInfo#DeviceIdInfo(UUID, UUID, UUID)}.
   * <ul>
   *   <li>Then return CustomerId EntityType is {@code CUSTOMER}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceIdInfo#DeviceIdInfo(UUID, UUID, UUID)}
   */
  @Test
  @DisplayName("Test new DeviceIdInfo(UUID, UUID, UUID); then return CustomerId EntityType is 'CUSTOMER'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceIdInfo.<init>(UUID, UUID, UUID)"})
  void testNewDeviceIdInfo_thenReturnCustomerIdEntityTypeIsCustomer() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DeviceIdInfo actualDeviceIdInfo = new DeviceIdInfo(tenantId, customerId, deviceId);

    // Assert
    CustomerId customerId2 = actualDeviceIdInfo.getCustomerId();
    assertEquals(EntityType.CUSTOMER, customerId2.getEntityType());
    DeviceId deviceId2 = actualDeviceIdInfo.getDeviceId();
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    TenantId tenantId2 = actualDeviceIdInfo.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(customerId2.isNullUid());
    assertFalse(deviceId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(customerId, customerId2.getId());
    assertSame(deviceId, deviceId2.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DeviceIdInfo#DeviceIdInfo(UUID, UUID, UUID)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return CustomerId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceIdInfo#DeviceIdInfo(UUID, UUID, UUID)}
   */
  @Test
  @DisplayName("Test new DeviceIdInfo(UUID, UUID, UUID); when 'null'; then return CustomerId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void DeviceIdInfo.<init>(UUID, UUID, UUID)"})
  void testNewDeviceIdInfo_whenNull_thenReturnCustomerIdIsNull() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DeviceIdInfo actualDeviceIdInfo = new DeviceIdInfo(tenantId, null, deviceId);

    // Assert
    assertNull(actualDeviceIdInfo.getCustomerId());
    DeviceId deviceId2 = actualDeviceIdInfo.getDeviceId();
    assertEquals(EntityType.DEVICE, deviceId2.getEntityType());
    TenantId tenantId2 = actualDeviceIdInfo.getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(deviceId2.isNullUid());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(deviceId, deviceId2.getId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}, and {@link DeviceIdInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceIdInfo#equals(Object)}
   *   <li>{@link DeviceIdInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(tenantId, customerId,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID tenantId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceIdInfo deviceIdInfo2 = new DeviceIdInfo(tenantId2, customerId2,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(deviceIdInfo, deviceIdInfo2);
    int expectedHashCodeResult = deviceIdInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceIdInfo2.hashCode());
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}, and {@link DeviceIdInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceIdInfo#equals(Object)}
   *   <li>{@link DeviceIdInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(tenantId, null,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID tenantId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceIdInfo deviceIdInfo2 = new DeviceIdInfo(tenantId2, null,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(deviceIdInfo, deviceIdInfo2);
    int expectedHashCodeResult = deviceIdInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceIdInfo2.hashCode());
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}, and {@link DeviceIdInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceIdInfo#equals(Object)}
   *   <li>{@link DeviceIdInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(tenantId, customerId,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(deviceIdInfo, deviceIdInfo);
    int expectedHashCodeResult = deviceIdInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceIdInfo.hashCode());
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(EntityId.NULL_UUID, customerId,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(deviceIdInfo,
        new DeviceIdInfo(tenantId, customerId2, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(tenantId, EntityId.NULL_UUID,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID tenantId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(deviceIdInfo,
        new DeviceIdInfo(tenantId2, customerId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(tenantId, null,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID tenantId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(deviceIdInfo,
        new DeviceIdInfo(tenantId2, customerId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(tenantId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
        EntityId.NULL_UUID);
    UUID tenantId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(deviceIdInfo,
        new DeviceIdInfo(tenantId2, customerId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(new DeviceIdInfo(tenantId, customerId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
        null);
  }

  /**
   * Test {@link DeviceIdInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceIdInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceIdInfo.equals(Object)", "int DeviceIdInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(new DeviceIdInfo(tenantId, customerId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
        "Different type to DeviceIdInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceIdInfo#toString()}
   *   <li>{@link DeviceIdInfo#getCustomerId()}
   *   <li>{@link DeviceIdInfo#getDeviceId()}
   *   <li>{@link DeviceIdInfo#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CustomerId DeviceIdInfo.getCustomerId()", "DeviceId DeviceIdInfo.getDeviceId()",
      "TenantId DeviceIdInfo.getTenantId()", "String DeviceIdInfo.toString()"})
  void testGettersAndSetters() {
    // Arrange
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID customerId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    UUID deviceId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DeviceIdInfo deviceIdInfo = new DeviceIdInfo(tenantId, customerId, deviceId);

    // Act
    String actualToStringResult = deviceIdInfo.toString();
    CustomerId actualCustomerId = deviceIdInfo.getCustomerId();
    DeviceId actualDeviceId = deviceIdInfo.getDeviceId();
    TenantId actualTenantId = deviceIdInfo.getTenantId();

    // Assert
    UUID id = actualCustomerId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    UUID id2 = actualDeviceId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    UUID id3 = actualTenantId.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id3.toString());
    assertEquals(
        "DeviceIdInfo(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, customerId=784f394c-42b6-435a-983c-b7beff2784f9,"
            + " deviceId=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertEquals(EntityType.CUSTOMER, actualCustomerId.getEntityType());
    assertEquals(EntityType.DEVICE, actualDeviceId.getEntityType());
    assertEquals(EntityType.TENANT, actualTenantId.getEntityType());
    assertFalse(actualCustomerId.isNullUid());
    assertFalse(actualDeviceId.isNullUid());
    assertFalse(actualTenantId.isNullUid());
    assertFalse(actualTenantId.isSysTenantId());
    assertSame(customerId, id);
    assertSame(deviceId, id2);
    assertSame(tenantId, id3);
  }
}
