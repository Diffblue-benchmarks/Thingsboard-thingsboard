package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class EntityLimitKeyDiffblueTest {
  /**
   * Test {@link EntityLimitKey#equals(Object)}, and {@link EntityLimitKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLimitKey#equals(Object)}
   *   <li>{@link EntityLimitKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityLimitKey entityLimitKey =
        new EntityLimitKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Device Name");
    EntityLimitKey entityLimitKey2 =
        new EntityLimitKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Device Name");

    // Act and Assert
    assertEquals(entityLimitKey, entityLimitKey2);
    int expectedHashCodeResult = entityLimitKey.hashCode();
    assertEquals(expectedHashCodeResult, entityLimitKey2.hashCode());
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}, and {@link EntityLimitKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLimitKey#equals(Object)}
   *   <li>{@link EntityLimitKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(null, "Device Name");
    EntityLimitKey entityLimitKey2 = new EntityLimitKey(null, "Device Name");

    // Act and Assert
    assertEquals(entityLimitKey, entityLimitKey2);
    int expectedHashCodeResult = entityLimitKey.hashCode();
    assertEquals(expectedHashCodeResult, entityLimitKey2.hashCode());
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}, and {@link EntityLimitKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLimitKey#equals(Object)}
   *   <li>{@link EntityLimitKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityLimitKey entityLimitKey =
        new EntityLimitKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null);
    EntityLimitKey entityLimitKey2 =
        new EntityLimitKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null);

    // Act and Assert
    assertEquals(entityLimitKey, entityLimitKey2);
    int expectedHashCodeResult = entityLimitKey.hashCode();
    assertEquals(expectedHashCodeResult, entityLimitKey2.hashCode());
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}, and {@link EntityLimitKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLimitKey#equals(Object)}
   *   <li>{@link EntityLimitKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityLimitKey entityLimitKey =
        new EntityLimitKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Device Name");

    // Act and Assert
    assertEquals(entityLimitKey, entityLimitKey);
    int expectedHashCodeResult = entityLimitKey.hashCode();
    assertEquals(expectedHashCodeResult, entityLimitKey.hashCode());
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityLimitKey entityLimitKey =
        new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name");

    // Act and Assert
    assertNotEquals(
        entityLimitKey,
        new EntityLimitKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Device Name"));
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(null, "Device Name");

    // Act and Assert
    assertNotEquals(
        entityLimitKey,
        new EntityLimitKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Device Name"));
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityLimitKey entityLimitKey =
        new EntityLimitKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), null);

    // Act and Assert
    assertNotEquals(
        entityLimitKey,
        new EntityLimitKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Device Name"));
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityLimitKey entityLimitKey =
        new EntityLimitKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            "org.thingsboard.server.common.transport.limits.EntityLimitKey");

    // Act and Assert
    assertNotEquals(
        entityLimitKey,
        new EntityLimitKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Device Name"));
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EntityLimitKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Device Name"),
        null);
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityLimitKey.equals(Object)", "int EntityLimitKey.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new EntityLimitKey(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Device Name"),
        "Different type to EntityLimitKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityLimitKey#EntityLimitKey(TenantId, String)}
   *   <li>{@link EntityLimitKey#toString()}
   *   <li>{@link EntityLimitKey#getDeviceName()}
   *   <li>{@link EntityLimitKey#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntityLimitKey.<init>(TenantId, String)",
    "String EntityLimitKey.getDeviceName()",
    "TenantId EntityLimitKey.getTenantId()",
    "String EntityLimitKey.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    EntityLimitKey actualEntityLimitKey = new EntityLimitKey(tenantId, "Device Name");
    String actualToStringResult = actualEntityLimitKey.toString();
    String actualDeviceName = actualEntityLimitKey.getDeviceName();

    // Assert
    assertEquals("Device Name", actualDeviceName);
    assertEquals(
        "EntityLimitKey(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, deviceName=Device Name)",
        actualToStringResult);
    assertSame(tenantId, actualEntityLimitKey.getTenantId());
  }
}
