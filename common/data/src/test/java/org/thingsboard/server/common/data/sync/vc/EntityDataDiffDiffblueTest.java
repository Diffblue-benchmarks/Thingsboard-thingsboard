package org.thingsboard.server.common.data.sync.vc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.ExportableEntity;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.sync.ie.DeviceExportData;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;

class EntityDataDiffDiffblueTest {
  /**
   * Test {@link EntityDataDiff#equals(Object)}, and
   * {@link EntityDataDiff#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataDiff#equals(Object)}
   *   <li>{@link EntityDataDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> currentVersion = new EntityExportData<>();
    EntityDataDiff entityDataDiff = new EntityDataDiff(currentVersion, new EntityExportData<>());
    EntityExportData<ExportableEntity<? extends EntityId>> currentVersion2 = new EntityExportData<>();
    EntityDataDiff entityDataDiff2 = new EntityDataDiff(currentVersion2, new EntityExportData<>());

    // Act and Assert
    assertEquals(entityDataDiff, entityDataDiff2);
    int expectedHashCodeResult = entityDataDiff.hashCode();
    assertEquals(expectedHashCodeResult, entityDataDiff2.hashCode());
  }

  /**
   * Test {@link EntityDataDiff#equals(Object)}, and
   * {@link EntityDataDiff#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataDiff#equals(Object)}
   *   <li>{@link EntityDataDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityDataDiff entityDataDiff = new EntityDataDiff(null, new EntityExportData<>());
    EntityDataDiff entityDataDiff2 = new EntityDataDiff(null, new EntityExportData<>());

    // Act and Assert
    assertEquals(entityDataDiff, entityDataDiff2);
    int expectedHashCodeResult = entityDataDiff.hashCode();
    assertEquals(expectedHashCodeResult, entityDataDiff2.hashCode());
  }

  /**
   * Test {@link EntityDataDiff#equals(Object)}, and
   * {@link EntityDataDiff#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataDiff#equals(Object)}
   *   <li>{@link EntityDataDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityDataDiff entityDataDiff = new EntityDataDiff(new EntityExportData<>(), null);
    EntityDataDiff entityDataDiff2 = new EntityDataDiff(new EntityExportData<>(), null);

    // Act and Assert
    assertEquals(entityDataDiff, entityDataDiff2);
    int expectedHashCodeResult = entityDataDiff.hashCode();
    assertEquals(expectedHashCodeResult, entityDataDiff2.hashCode());
  }

  /**
   * Test {@link EntityDataDiff#equals(Object)}, and
   * {@link EntityDataDiff#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataDiff#equals(Object)}
   *   <li>{@link EntityDataDiff#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> currentVersion = new EntityExportData<>();
    EntityDataDiff entityDataDiff = new EntityDataDiff(currentVersion, new EntityExportData<>());

    // Act and Assert
    assertEquals(entityDataDiff, entityDataDiff);
    int expectedHashCodeResult = entityDataDiff.hashCode();
    assertEquals(expectedHashCodeResult, entityDataDiff.hashCode());
  }

  /**
   * Test {@link EntityDataDiff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceExportData currentVersion = new DeviceExportData();
    EntityDataDiff entityDataDiff = new EntityDataDiff(currentVersion, new EntityExportData<>());
    EntityExportData<ExportableEntity<? extends EntityId>> currentVersion2 = new EntityExportData<>();

    // Act and Assert
    assertNotEquals(entityDataDiff, new EntityDataDiff(currentVersion2, new EntityExportData<>()));
  }

  /**
   * Test {@link EntityDataDiff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityDataDiff entityDataDiff = new EntityDataDiff(null, new EntityExportData<>());
    EntityExportData<ExportableEntity<? extends EntityId>> currentVersion = new EntityExportData<>();

    // Act and Assert
    assertNotEquals(entityDataDiff, new EntityDataDiff(currentVersion, new EntityExportData<>()));
  }

  /**
   * Test {@link EntityDataDiff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceExportData currentVersion = mock(DeviceExportData.class);
    EntityDataDiff entityDataDiff = new EntityDataDiff(currentVersion, new EntityExportData<>());
    EntityExportData<ExportableEntity<? extends EntityId>> currentVersion2 = new EntityExportData<>();

    // Act and Assert
    assertNotEquals(entityDataDiff, new EntityDataDiff(currentVersion2, new EntityExportData<>()));
  }

  /**
   * Test {@link EntityDataDiff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> currentVersion = new EntityExportData<>();
    EntityDataDiff entityDataDiff = new EntityDataDiff(currentVersion, new DeviceExportData());
    EntityExportData<ExportableEntity<? extends EntityId>> currentVersion2 = new EntityExportData<>();

    // Act and Assert
    assertNotEquals(entityDataDiff, new EntityDataDiff(currentVersion2, new EntityExportData<>()));
  }

  /**
   * Test {@link EntityDataDiff#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityDataDiff entityDataDiff = new EntityDataDiff(new EntityExportData<>(), null);
    EntityExportData<ExportableEntity<? extends EntityId>> currentVersion = new EntityExportData<>();

    // Act and Assert
    assertNotEquals(entityDataDiff, new EntityDataDiff(currentVersion, new EntityExportData<>()));
  }

  /**
   * Test {@link EntityDataDiff#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> currentVersion = new EntityExportData<>();

    // Act and Assert
    assertNotEquals(new EntityDataDiff(currentVersion, new EntityExportData<>()), null);
  }

  /**
   * Test {@link EntityDataDiff#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityDataDiff#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> currentVersion = new EntityExportData<>();

    // Act and Assert
    assertNotEquals(new EntityDataDiff(currentVersion, new EntityExportData<>()), "Different type to EntityDataDiff");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityDataDiff#EntityDataDiff(EntityExportData, EntityExportData)}
   *   <li>{@link EntityDataDiff#setCurrentVersion(EntityExportData)}
   *   <li>{@link EntityDataDiff#setOtherVersion(EntityExportData)}
   *   <li>{@link EntityDataDiff#toString()}
   *   <li>{@link EntityDataDiff#getCurrentVersion()}
   *   <li>{@link EntityDataDiff#getOtherVersion()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    EntityExportData<ExportableEntity<? extends EntityId>> currentVersion = new EntityExportData<>();

    // Act
    EntityDataDiff actualEntityDataDiff = new EntityDataDiff(currentVersion, new EntityExportData<>());
    EntityExportData<ExportableEntity<? extends EntityId>> currentVersion2 = new EntityExportData<>();
    actualEntityDataDiff.setCurrentVersion(currentVersion2);
    EntityExportData<ExportableEntity<? extends EntityId>> otherVersion = new EntityExportData<>();
    actualEntityDataDiff.setOtherVersion(otherVersion);
    String actualToStringResult = actualEntityDataDiff.toString();
    EntityExportData<?> actualCurrentVersion = actualEntityDataDiff.getCurrentVersion();

    // Assert that nothing has changed
    assertEquals("EntityDataDiff(currentVersion=EntityExportData(entity=null, entityType=null, relations=null,"
        + " attributes=null), otherVersion=EntityExportData(entity=null, entityType=null, relations=null,"
        + " attributes=null))", actualToStringResult);
    assertSame(currentVersion2, actualCurrentVersion);
    assertSame(otherVersion, actualEntityDataDiff.getOtherVersion());
  }
}
