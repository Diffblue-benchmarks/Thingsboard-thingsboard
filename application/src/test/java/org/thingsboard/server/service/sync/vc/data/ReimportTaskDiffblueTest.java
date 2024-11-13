package org.thingsboard.server.service.sync.vc.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.sync.ie.DeviceExportData;
import org.thingsboard.server.common.data.sync.ie.EntityExportData;
import org.thingsboard.server.common.data.sync.ie.EntityImportSettings;

class ReimportTaskDiffblueTest {
  /**
   * Test {@link ReimportTask#equals(Object)}, and
   * {@link ReimportTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReimportTask#equals(Object)}
   *   <li>{@link ReimportTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityExportData data = new EntityExportData();
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    ReimportTask reimportTask = new ReimportTask(data, settings);
    EntityExportData data2 = new EntityExportData();
    EntityImportSettings settings2 = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    ReimportTask reimportTask2 = new ReimportTask(data2, settings2);

    // Act and Assert
    assertEquals(reimportTask, reimportTask2);
    int expectedHashCodeResult = reimportTask.hashCode();
    assertEquals(expectedHashCodeResult, reimportTask2.hashCode());
  }

  /**
   * Test {@link ReimportTask#equals(Object)}, and
   * {@link ReimportTask#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReimportTask#equals(Object)}
   *   <li>{@link ReimportTask#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityExportData data = new EntityExportData();
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    ReimportTask reimportTask = new ReimportTask(data, settings);

    // Act and Assert
    assertEquals(reimportTask, reimportTask);
    int expectedHashCodeResult = reimportTask.hashCode();
    assertEquals(expectedHashCodeResult, reimportTask.hashCode());
  }

  /**
   * Test {@link ReimportTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReimportTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceExportData data = new DeviceExportData();
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    ReimportTask reimportTask = new ReimportTask(data, settings);
    EntityExportData data2 = new EntityExportData();
    EntityImportSettings settings2 = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(reimportTask, new ReimportTask(data2, settings2));
  }

  /**
   * Test {@link ReimportTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReimportTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    ReimportTask reimportTask = new ReimportTask(null, settings);
    EntityExportData data = new EntityExportData();
    EntityImportSettings settings2 = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(reimportTask, new ReimportTask(data, settings2));
  }

  /**
   * Test {@link ReimportTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReimportTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceExportData data = mock(DeviceExportData.class);
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    ReimportTask reimportTask = new ReimportTask(data, settings);
    EntityExportData data2 = new EntityExportData();
    EntityImportSettings settings2 = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(reimportTask, new ReimportTask(data2, settings2));
  }

  /**
   * Test {@link ReimportTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReimportTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityImportSettings.EntityImportSettingsBuilder entityImportSettingsBuilder = mock(
        EntityImportSettings.EntityImportSettingsBuilder.class);
    when(entityImportSettingsBuilder.saveAttributes(anyBoolean())).thenReturn(EntityImportSettings.builder());
    EntityImportSettings settings = entityImportSettingsBuilder.saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    ReimportTask reimportTask = new ReimportTask(new EntityExportData(), settings);
    EntityExportData data = new EntityExportData();
    EntityImportSettings settings2 = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(reimportTask, new ReimportTask(data, settings2));
  }

  /**
   * Test {@link ReimportTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReimportTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityImportSettings.EntityImportSettingsBuilder entityImportSettingsBuilder = mock(
        EntityImportSettings.EntityImportSettingsBuilder.class);
    when(entityImportSettingsBuilder.saveAttributes(anyBoolean())).thenReturn(EntityImportSettings.builder());
    EntityImportSettings settings = entityImportSettingsBuilder.saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();
    ReimportTask reimportTask = new ReimportTask(null, settings);
    EntityImportSettings settings2 = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(reimportTask, new ReimportTask(null, settings2));
  }

  /**
   * Test {@link ReimportTask#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReimportTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityExportData data = new EntityExportData();
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(new ReimportTask(data, settings), null);
  }

  /**
   * Test {@link ReimportTask#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ReimportTask#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityExportData data = new EntityExportData();
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act and Assert
    assertNotEquals(new ReimportTask(data, settings), "Different type to ReimportTask");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ReimportTask#ReimportTask(EntityExportData, EntityImportSettings)}
   *   <li>{@link ReimportTask#toString()}
   *   <li>{@link ReimportTask#getData()}
   *   <li>{@link ReimportTask#getSettings()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    EntityExportData data = new EntityExportData();
    EntityImportSettings settings = EntityImportSettings.builder()
        .saveAttributes(true)
        .saveCredentials(true)
        .updateRelations(true)
        .build();

    // Act
    ReimportTask actualReimportTask = new ReimportTask(data, settings);
    String actualToStringResult = actualReimportTask.toString();
    EntityExportData actualData = actualReimportTask.getData();

    // Assert
    assertEquals("ReimportTask(data=EntityExportData(entity=null, entityType=null, relations=null, attributes=null),"
        + " settings=EntityImportSettings(findExistingByName=false, updateRelations=true, saveAttributes=true,"
        + " saveCredentials=true))", actualToStringResult);
    assertSame(data, actualData);
    assertSame(settings, actualReimportTask.getSettings());
  }
}
