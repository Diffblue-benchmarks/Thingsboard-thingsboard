package org.thingsboard.server.service.sync.ie.importing.csv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImportedEntityInfoDiffblueTest {
  /**
   * Test {@link ImportedEntityInfo#equals(Object)}, and {@link ImportedEntityInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImportedEntityInfo#equals(Object)}
   *   <li>{@link ImportedEntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportedEntityInfo.equals(Object)", "int ImportedEntityInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImportedEntityInfo<Object> importedEntityInfo = new ImportedEntityInfo<>();
    importedEntityInfo.setEntity("Entity");
    importedEntityInfo.setOldEntity("Old Entity");
    importedEntityInfo.setUpdated(true);

    ImportedEntityInfo<Object> importedEntityInfo2 = new ImportedEntityInfo<>();
    importedEntityInfo2.setEntity("Entity");
    importedEntityInfo2.setOldEntity("Old Entity");
    importedEntityInfo2.setUpdated(true);

    // Act and Assert
    assertEquals(importedEntityInfo, importedEntityInfo2);
    int expectedHashCodeResult = importedEntityInfo.hashCode();
    assertEquals(expectedHashCodeResult, importedEntityInfo2.hashCode());
  }

  /**
   * Test {@link ImportedEntityInfo#equals(Object)}, and {@link ImportedEntityInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImportedEntityInfo#equals(Object)}
   *   <li>{@link ImportedEntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportedEntityInfo.equals(Object)", "int ImportedEntityInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ImportedEntityInfo<Object> importedEntityInfo = new ImportedEntityInfo<>();
    importedEntityInfo.setEntity(null);
    importedEntityInfo.setOldEntity("Old Entity");
    importedEntityInfo.setUpdated(true);

    ImportedEntityInfo<Object> importedEntityInfo2 = new ImportedEntityInfo<>();
    importedEntityInfo2.setEntity(null);
    importedEntityInfo2.setOldEntity("Old Entity");
    importedEntityInfo2.setUpdated(true);

    // Act and Assert
    assertEquals(importedEntityInfo, importedEntityInfo2);
    int expectedHashCodeResult = importedEntityInfo.hashCode();
    assertEquals(expectedHashCodeResult, importedEntityInfo2.hashCode());
  }

  /**
   * Test {@link ImportedEntityInfo#equals(Object)}, and {@link ImportedEntityInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImportedEntityInfo#equals(Object)}
   *   <li>{@link ImportedEntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportedEntityInfo.equals(Object)", "int ImportedEntityInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ImportedEntityInfo<Object> importedEntityInfo = new ImportedEntityInfo<>();
    importedEntityInfo.setEntity("Entity");
    importedEntityInfo.setOldEntity(null);
    importedEntityInfo.setUpdated(true);

    ImportedEntityInfo<Object> importedEntityInfo2 = new ImportedEntityInfo<>();
    importedEntityInfo2.setEntity("Entity");
    importedEntityInfo2.setOldEntity(null);
    importedEntityInfo2.setUpdated(true);

    // Act and Assert
    assertEquals(importedEntityInfo, importedEntityInfo2);
    int expectedHashCodeResult = importedEntityInfo.hashCode();
    assertEquals(expectedHashCodeResult, importedEntityInfo2.hashCode());
  }

  /**
   * Test {@link ImportedEntityInfo#equals(Object)}, and {@link ImportedEntityInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImportedEntityInfo#equals(Object)}
   *   <li>{@link ImportedEntityInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportedEntityInfo.equals(Object)", "int ImportedEntityInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImportedEntityInfo<Object> importedEntityInfo = new ImportedEntityInfo<>();
    importedEntityInfo.setEntity("Entity");
    importedEntityInfo.setOldEntity("Old Entity");
    importedEntityInfo.setUpdated(true);

    // Act and Assert
    assertEquals(importedEntityInfo, importedEntityInfo);
    int expectedHashCodeResult = importedEntityInfo.hashCode();
    assertEquals(expectedHashCodeResult, importedEntityInfo.hashCode());
  }

  /**
   * Test {@link ImportedEntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportedEntityInfo.equals(Object)", "int ImportedEntityInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImportedEntityInfo<Object> importedEntityInfo = new ImportedEntityInfo<>();
    importedEntityInfo.setEntity("Entity");
    importedEntityInfo.setOldEntity("Old Entity");
    importedEntityInfo.setUpdated(true);

    ImportedEntityInfo<Object> importedEntityInfo2 = new ImportedEntityInfo<>();
    importedEntityInfo2.setEntity(importedEntityInfo);
    importedEntityInfo2.setOldEntity("Old Entity");
    importedEntityInfo2.setUpdated(true);

    ImportedEntityInfo<Object> importedEntityInfo3 = new ImportedEntityInfo<>();
    importedEntityInfo3.setEntity("Entity");
    importedEntityInfo3.setOldEntity("Old Entity");
    importedEntityInfo3.setUpdated(true);

    // Act and Assert
    assertNotEquals(importedEntityInfo2, importedEntityInfo3);
  }

  /**
   * Test {@link ImportedEntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportedEntityInfo.equals(Object)", "int ImportedEntityInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImportedEntityInfo<Object> importedEntityInfo = new ImportedEntityInfo<>();
    importedEntityInfo.setEntity(null);
    importedEntityInfo.setOldEntity("Old Entity");
    importedEntityInfo.setUpdated(true);

    ImportedEntityInfo<Object> importedEntityInfo2 = new ImportedEntityInfo<>();
    importedEntityInfo2.setEntity("Entity");
    importedEntityInfo2.setOldEntity("Old Entity");
    importedEntityInfo2.setUpdated(true);

    // Act and Assert
    assertNotEquals(importedEntityInfo, importedEntityInfo2);
  }

  /**
   * Test {@link ImportedEntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportedEntityInfo.equals(Object)", "int ImportedEntityInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImportedEntityInfo<Object> importedEntityInfo = new ImportedEntityInfo<>();
    importedEntityInfo.setEntity("Entity");
    importedEntityInfo.setOldEntity("Old Entity");
    importedEntityInfo.setUpdated(true);

    ImportedEntityInfo<Object> importedEntityInfo2 = new ImportedEntityInfo<>();
    importedEntityInfo2.setEntity("Entity");
    importedEntityInfo2.setOldEntity(importedEntityInfo);
    importedEntityInfo2.setUpdated(true);

    ImportedEntityInfo<Object> importedEntityInfo3 = new ImportedEntityInfo<>();
    importedEntityInfo3.setEntity("Entity");
    importedEntityInfo3.setOldEntity("Old Entity");
    importedEntityInfo3.setUpdated(true);

    // Act and Assert
    assertNotEquals(importedEntityInfo2, importedEntityInfo3);
  }

  /**
   * Test {@link ImportedEntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportedEntityInfo.equals(Object)", "int ImportedEntityInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImportedEntityInfo<Object> importedEntityInfo = new ImportedEntityInfo<>();
    importedEntityInfo.setEntity("Entity");
    importedEntityInfo.setOldEntity(null);
    importedEntityInfo.setUpdated(true);

    ImportedEntityInfo<Object> importedEntityInfo2 = new ImportedEntityInfo<>();
    importedEntityInfo2.setEntity("Entity");
    importedEntityInfo2.setOldEntity("Old Entity");
    importedEntityInfo2.setUpdated(true);

    // Act and Assert
    assertNotEquals(importedEntityInfo, importedEntityInfo2);
  }

  /**
   * Test {@link ImportedEntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportedEntityInfo.equals(Object)", "int ImportedEntityInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImportedEntityInfo<Object> importedEntityInfo = new ImportedEntityInfo<>();
    importedEntityInfo.setEntity("Entity");
    importedEntityInfo.setOldEntity("Old Entity");
    importedEntityInfo.setUpdated(false);

    ImportedEntityInfo<Object> importedEntityInfo2 = new ImportedEntityInfo<>();
    importedEntityInfo2.setEntity("Entity");
    importedEntityInfo2.setOldEntity("Old Entity");
    importedEntityInfo2.setUpdated(true);

    // Act and Assert
    assertNotEquals(importedEntityInfo, importedEntityInfo2);
  }

  /**
   * Test {@link ImportedEntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportedEntityInfo.equals(Object)", "int ImportedEntityInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ImportedEntityInfo<Object> importedEntityInfo = new ImportedEntityInfo<>();
    importedEntityInfo.setEntity("Entity");
    importedEntityInfo.setOldEntity("Old Entity");
    importedEntityInfo.setUpdated(true);

    // Act and Assert
    assertNotEquals(importedEntityInfo, null);
  }

  /**
   * Test {@link ImportedEntityInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ImportedEntityInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ImportedEntityInfo.equals(Object)", "int ImportedEntityInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ImportedEntityInfo<Object> importedEntityInfo = new ImportedEntityInfo<>();
    importedEntityInfo.setEntity("Entity");
    importedEntityInfo.setOldEntity("Old Entity");
    importedEntityInfo.setUpdated(true);

    // Act and Assert
    assertNotEquals(importedEntityInfo, "Different type to ImportedEntityInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link ImportedEntityInfo}
   *   <li>{@link ImportedEntityInfo#setEntity(Object)}
   *   <li>{@link ImportedEntityInfo#setOldEntity(Object)}
   *   <li>{@link ImportedEntityInfo#setUpdated(boolean)}
   *   <li>{@link ImportedEntityInfo#toString()}
   *   <li>{@link ImportedEntityInfo#getEntity()}
   *   <li>{@link ImportedEntityInfo#getOldEntity()}
   *   <li>{@link ImportedEntityInfo#isUpdated()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ImportedEntityInfo.<init>()", "Object ImportedEntityInfo.getEntity()",
      "Object ImportedEntityInfo.getOldEntity()", "boolean ImportedEntityInfo.isUpdated()",
      "void ImportedEntityInfo.setEntity(Object)", "void ImportedEntityInfo.setOldEntity(Object)",
      "void ImportedEntityInfo.setUpdated(boolean)", "String ImportedEntityInfo.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    ImportedEntityInfo<Object> actualImportedEntityInfo = new ImportedEntityInfo<>();
    actualImportedEntityInfo.setEntity("Entity");
    actualImportedEntityInfo.setOldEntity("Old Entity");
    actualImportedEntityInfo.setUpdated(true);
    String actualToStringResult = actualImportedEntityInfo.toString();
    Object actualEntity = actualImportedEntityInfo.getEntity();
    Object actualOldEntity = actualImportedEntityInfo.getOldEntity();

    // Assert
    assertEquals("Entity", actualEntity);
    assertEquals("ImportedEntityInfo(entity=Entity, isUpdated=true, oldEntity=Old Entity)", actualToStringResult);
    assertEquals("Old Entity", actualOldEntity);
    assertTrue(actualImportedEntityInfo.isUpdated());
  }
}
