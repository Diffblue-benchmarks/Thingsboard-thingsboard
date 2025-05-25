package org.thingsboard.server.common.msg.rule.engine;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceDeleteMsg#equals(Object)}
   *   <li>{@link DeviceDeleteMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null);
    DeviceDeleteMsg deviceDeleteMsg2 = new DeviceDeleteMsg(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null);

    // Act and Assert
    assertEquals(deviceDeleteMsg, deviceDeleteMsg2);
    int expectedHashCodeResult = deviceDeleteMsg.hashCode();
    assertEquals(expectedHashCodeResult, deviceDeleteMsg2.hashCode());
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}, and {@link DeviceDeleteMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceDeleteMsg#equals(Object)}
   *   <li>{@link DeviceDeleteMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(null, null);
    DeviceDeleteMsg deviceDeleteMsg2 = new DeviceDeleteMsg(null, null);

    // Act and Assert
    assertEquals(deviceDeleteMsg, deviceDeleteMsg2);
    int expectedHashCodeResult = deviceDeleteMsg.hashCode();
    assertEquals(expectedHashCodeResult, deviceDeleteMsg2.hashCode());
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}, and {@link DeviceDeleteMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeviceDeleteMsg#equals(Object)}
   *   <li>{@link DeviceDeleteMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(tenantId,
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceDeleteMsg deviceDeleteMsg2 = new DeviceDeleteMsg(tenantId2,
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertEquals(deviceDeleteMsg, deviceDeleteMsg2);
    int expectedHashCodeResult = deviceDeleteMsg.hashCode();
    assertEquals(expectedHashCodeResult, deviceDeleteMsg2.hashCode());
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(new TenantId(UUID.randomUUID()), null);

    // Act and Assert
    assertNotEquals(deviceDeleteMsg,
        new DeviceDeleteMsg(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null));
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(null, null);

    // Act and Assert
    assertNotEquals(deviceDeleteMsg,
        new DeviceDeleteMsg(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null));
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(tenantId,
        new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertNotEquals(deviceDeleteMsg,
        new DeviceDeleteMsg(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null));
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceDeleteMsg(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null),
        1);
  }

  /**
   * Test {@link DeviceDeleteMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceDeleteMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean DeviceDeleteMsg.equals(Object)", "int DeviceDeleteMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceDeleteMsg deviceDeleteMsg = new DeviceDeleteMsg(null, null);

    // Act and Assert
    assertNotEquals(deviceDeleteMsg,
        new DeviceDeleteMsg(null, new DeviceId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
  }
}
