package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EntityInfoDiffblueTest {
  /**
   * Test {@link EntityInfo#equals(Object)}, and {@link EntityInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityInfo#equals(Object)}
   *   <li>{@link EntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");
    EntityInfo entityInfo2 = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");

    // Act and Assert
    assertEquals(entityInfo, entityInfo2);
    int expectedHashCodeResult = entityInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityInfo2.hashCode());
  }

  /**
   * Test {@link EntityInfo#equals(Object)}, and {@link EntityInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityInfo#equals(Object)}
   *   <li>{@link EntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(null, "Name");
    EntityInfo entityInfo2 = new EntityInfo(null, "Name");

    // Act and Assert
    assertEquals(entityInfo, entityInfo2);
    int expectedHashCodeResult = entityInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityInfo2.hashCode());
  }

  /**
   * Test {@link EntityInfo#equals(Object)}, and {@link EntityInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityInfo#equals(Object)}
   *   <li>{@link EntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, null);
    EntityInfo entityInfo2 = new EntityInfo(TenantId.SYS_TENANT_ID, null);

    // Act and Assert
    assertEquals(entityInfo, entityInfo2);
    int expectedHashCodeResult = entityInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityInfo2.hashCode());
  }

  /**
   * Test {@link EntityInfo#equals(Object)}, and {@link EntityInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityInfo#equals(Object)}
   *   <li>{@link EntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");

    // Act and Assert
    assertEquals(entityInfo, entityInfo);
    int expectedHashCodeResult = entityInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityInfo.hashCode());
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(null, "Name");

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(new AlarmId(EntityId.NULL_UUID), "Name");

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(mock(EntityId.class), "Name");

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, null);

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, "org.thingsboard.server.common.data.EntityInfo");

    // Act and Assert
    assertNotEquals(entityInfo, new EntityInfo(TenantId.SYS_TENANT_ID, "Name"));
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityInfo entityInfo = new EntityInfo(TenantId.SYS_TENANT_ID, "Name");

    // Act and Assert
    assertNotEquals(entityInfo, new DeviceProfileInfo(new DeviceProfile()));
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityInfo(TenantId.SYS_TENANT_ID, "Name"), null);
  }

  /**
   * Test {@link EntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityInfo(TenantId.SYS_TENANT_ID, "Name"), "Different type to EntityInfo");
  }

  /**
   * Test {@link EntityInfo#getId()}.
   * <p>
   * Method under test: {@link EntityInfo#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  void testGetId() {
    // Arrange and Act
    EntityId actualId = (new EntityInfo(TenantId.SYS_TENANT_ID, "Name")).getId();

    // Assert
    assertSame(((TenantId) actualId).SYS_TENANT_ID, actualId);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityInfo#EntityInfo(EntityId, String)}
   *   <li>{@link EntityInfo#toString()}
   *   <li>{@link EntityInfo#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TenantId id = TenantId.SYS_TENANT_ID;

    // Act
    EntityInfo actualEntityInfo = new EntityInfo(id, "Name");
    String actualToStringResult = actualEntityInfo.toString();

    // Assert
    assertEquals("EntityInfo(id=13814000-1dd2-11b2-8080-808080808080, name=Name)", actualToStringResult);
    assertEquals("Name", actualEntityInfo.getName());
    TenantId expectedId = id.SYS_TENANT_ID;
    assertSame(expectedId, actualEntityInfo.getId());
  }
}
