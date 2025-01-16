package org.thingsboard.server.common.transport.limits;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.TenantId;

class EntityLimitKeyDiffblueTest {
  /**
   * Test {@link EntityLimitKey#equals(Object)}, and
   * {@link EntityLimitKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityLimitKey#equals(Object)}
   *   <li>{@link EntityLimitKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(null, "Device Name");
    EntityLimitKey entityLimitKey2 = new EntityLimitKey(null, "Device Name");

    // Act and Assert
    assertEquals(entityLimitKey, entityLimitKey2);
    int expectedHashCodeResult = entityLimitKey.hashCode();
    assertEquals(expectedHashCodeResult, entityLimitKey2.hashCode());
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}, and
   * {@link EntityLimitKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityLimitKey#equals(Object)}
   *   <li>{@link EntityLimitKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(null, null);
    EntityLimitKey entityLimitKey2 = new EntityLimitKey(null, null);

    // Act and Assert
    assertEquals(entityLimitKey, entityLimitKey2);
    int expectedHashCodeResult = entityLimitKey.hashCode();
    assertEquals(expectedHashCodeResult, entityLimitKey2.hashCode());
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}, and
   * {@link EntityLimitKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityLimitKey#equals(Object)}
   *   <li>{@link EntityLimitKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(new TenantId(null), "Device Name");
    EntityLimitKey entityLimitKey2 = new EntityLimitKey(new TenantId(null), "Device Name");

    // Act and Assert
    assertEquals(entityLimitKey, entityLimitKey2);
    int expectedHashCodeResult = entityLimitKey.hashCode();
    assertEquals(expectedHashCodeResult, entityLimitKey2.hashCode());
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}, and
   * {@link EntityLimitKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityLimitKey#equals(Object)}
   *   <li>{@link EntityLimitKey#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name");

    // Act and Assert
    assertEquals(entityLimitKey, entityLimitKey);
    int expectedHashCodeResult = entityLimitKey.hashCode();
    assertEquals(expectedHashCodeResult, entityLimitKey.hashCode());
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name");

    // Act and Assert
    assertNotEquals(entityLimitKey, new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name"));
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(null, "Device Name");

    // Act and Assert
    assertNotEquals(entityLimitKey, new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name"));
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name"), mock(AdminSettingsId.class));
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(null, null);

    // Act and Assert
    assertNotEquals(entityLimitKey, new EntityLimitKey(null, "Device Name"));
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityLimitKey entityLimitKey = new EntityLimitKey(null,
        "org.thingsboard.server.common.transport.limits.EntityLimitKey");

    // Act and Assert
    assertNotEquals(entityLimitKey, new EntityLimitKey(null, "Device Name"));
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name"), null);
  }

  /**
   * Test {@link EntityLimitKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityLimitKey#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityLimitKey(new TenantId(UUID.randomUUID()), "Device Name"),
        "Different type to EntityLimitKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityLimitKey#EntityLimitKey(TenantId, String)}
   *   <li>{@link EntityLimitKey#toString()}
   *   <li>{@link EntityLimitKey#getDeviceName()}
   *   <li>{@link EntityLimitKey#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    EntityLimitKey actualEntityLimitKey = new EntityLimitKey(tenantId, "Device Name");
    actualEntityLimitKey.toString();
    String actualDeviceName = actualEntityLimitKey.getDeviceName();

    // Assert
    assertEquals("Device Name", actualDeviceName);
    assertSame(tenantId, actualEntityLimitKey.getTenantId());
  }
}
