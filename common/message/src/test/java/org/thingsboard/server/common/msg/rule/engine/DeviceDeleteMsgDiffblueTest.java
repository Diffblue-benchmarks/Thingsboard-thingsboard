package org.thingsboard.server.common.msg.rule.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

class DeviceDeleteMsgDiffblueTest {
  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}, and {@link DeviceDeleteMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceDeleteMsg#equals(Object)}
   *   <li>{@link DeviceDeleteMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(tenantId, null);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceDeleteMsg deviceDeleteMsg2 = new DeviceDeleteMsg(tenantId2, null);

    // Act and Assert
    assertEquals(deviceDeleteMsg, deviceDeleteMsg2);
    assertEquals(deviceDeleteMsg.hashCode(), deviceDeleteMsg2.hashCode());
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}, and {@link DeviceDeleteMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceDeleteMsg#equals(Object)}
   *   <li>{@link DeviceDeleteMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(null, null);
    DeviceDeleteMsg deviceDeleteMsg2 = new DeviceDeleteMsg(null, null);

    // Act and Assert
    assertEquals(deviceDeleteMsg, deviceDeleteMsg2);
    assertEquals(deviceDeleteMsg.hashCode(), deviceDeleteMsg2.hashCode());
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}, and {@link DeviceDeleteMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceDeleteMsg#equals(Object)}
   *   <li>{@link DeviceDeleteMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(tenantId, deviceId);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceId deviceId2 = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceDeleteMsg deviceDeleteMsg2 = new DeviceDeleteMsg(tenantId2, deviceId2);

    // Act and Assert
    assertEquals(deviceDeleteMsg, deviceDeleteMsg2);
    assertEquals(deviceDeleteMsg.hashCode(), deviceDeleteMsg2.hashCode());
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(new TenantId(UUID.randomUUID()), null);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceDeleteMsg deviceDeleteMsg2 = new DeviceDeleteMsg(tenantId, null);

    // Act and Assert
    assertNotEquals(deviceDeleteMsg, deviceDeleteMsg2);
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(null, null);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceDeleteMsg deviceDeleteMsg2 = new DeviceDeleteMsg(tenantId, null);

    // Act and Assert
    assertNotEquals(deviceDeleteMsg, deviceDeleteMsg2);
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(tenantId, deviceId);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceDeleteMsg deviceDeleteMsg2 = new DeviceDeleteMsg(tenantId2, null);

    // Act and Assert
    assertNotEquals(deviceDeleteMsg, deviceDeleteMsg2);
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(tenantId, null);

    // Act and Assert
    assertNotEquals(deviceDeleteMsg, 1);
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(null, null);
    DeviceId deviceId = new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceDeleteMsg deviceDeleteMsg2 = new DeviceDeleteMsg(null, deviceId);

    // Act and Assert
    assertNotEquals(deviceDeleteMsg, deviceDeleteMsg2);
  }
}
