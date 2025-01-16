package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class VersionedEntityInfoDiffblueTest {
  /**
   * Test {@link VersionedEntityInfo#equals(Object)}, and
   * {@link VersionedEntityInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionedEntityInfo#equals(Object)}
   *   <li>{@link VersionedEntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo();
    VersionedEntityInfo versionedEntityInfo2 = new VersionedEntityInfo();

    // Act and Assert
    assertEquals(versionedEntityInfo, versionedEntityInfo2);
    int expectedHashCodeResult = versionedEntityInfo.hashCode();
    assertEquals(expectedHashCodeResult, versionedEntityInfo2.hashCode());
  }

  /**
   * Test {@link VersionedEntityInfo#equals(Object)}, and
   * {@link VersionedEntityInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionedEntityInfo#equals(Object)}
   *   <li>{@link VersionedEntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo(TenantId.SYS_TENANT_ID);
    VersionedEntityInfo versionedEntityInfo2 = new VersionedEntityInfo(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(versionedEntityInfo, versionedEntityInfo2);
    int expectedHashCodeResult = versionedEntityInfo.hashCode();
    assertEquals(expectedHashCodeResult, versionedEntityInfo2.hashCode());
  }

  /**
   * Test {@link VersionedEntityInfo#equals(Object)}, and
   * {@link VersionedEntityInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionedEntityInfo#equals(Object)}
   *   <li>{@link VersionedEntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo();

    // Act and Assert
    assertEquals(versionedEntityInfo, versionedEntityInfo);
    int expectedHashCodeResult = versionedEntityInfo.hashCode();
    assertEquals(expectedHashCodeResult, versionedEntityInfo.hashCode());
  }

  /**
   * Test {@link VersionedEntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(versionedEntityInfo, new VersionedEntityInfo());
  }

  /**
   * Test {@link VersionedEntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo();

    // Act and Assert
    assertNotEquals(versionedEntityInfo, new VersionedEntityInfo(TenantId.SYS_TENANT_ID));
  }

  /**
   * Test {@link VersionedEntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    VersionedEntityInfo versionedEntityInfo = new VersionedEntityInfo(mock(EntityId.class));

    // Act and Assert
    assertNotEquals(versionedEntityInfo, new VersionedEntityInfo());
  }

  /**
   * Test {@link VersionedEntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new VersionedEntityInfo(), null);
  }

  /**
   * Test {@link VersionedEntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link VersionedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new VersionedEntityInfo(), "Different type to VersionedEntityInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionedEntityInfo#VersionedEntityInfo()}
   *   <li>{@link VersionedEntityInfo#setExternalId(EntityId)}
   *   <li>{@link VersionedEntityInfo#toString()}
   *   <li>{@link VersionedEntityInfo#getExternalId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    VersionedEntityInfo actualVersionedEntityInfo = new VersionedEntityInfo();
    actualVersionedEntityInfo.setExternalId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualVersionedEntityInfo.toString();
    EntityId actualExternalId = actualVersionedEntityInfo.getExternalId();

    // Assert that nothing has changed
    assertEquals("VersionedEntityInfo(externalId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertSame(((TenantId) actualExternalId).SYS_TENANT_ID, actualExternalId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link VersionedEntityInfo#VersionedEntityInfo(EntityId)}
   *   <li>{@link VersionedEntityInfo#setExternalId(EntityId)}
   *   <li>{@link VersionedEntityInfo#toString()}
   *   <li>{@link VersionedEntityInfo#getExternalId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when SYS_TENANT_ID")
  void testGettersAndSetters_whenSys_tenant_id() {
    // Arrange and Act
    VersionedEntityInfo actualVersionedEntityInfo = new VersionedEntityInfo(TenantId.SYS_TENANT_ID);
    actualVersionedEntityInfo.setExternalId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualVersionedEntityInfo.toString();
    EntityId actualExternalId = actualVersionedEntityInfo.getExternalId();

    // Assert that nothing has changed
    assertEquals("VersionedEntityInfo(externalId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertSame(((TenantId) actualExternalId).SYS_TENANT_ID, actualExternalId);
  }
}
