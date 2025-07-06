package org.thingsboard.rule.engine.action;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbSaveToCustomCassandraTableNodeConfigurationDiffblueTest {
  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#defaultConfiguration()}.
   *
   * <p>Method under test: {@link
   * TbSaveToCustomCassandraTableNodeConfiguration#defaultConfiguration()}
   */
  @Test
  @DisplayName("Test defaultConfiguration()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "TbSaveToCustomCassandraTableNodeConfiguration TbSaveToCustomCassandraTableNodeConfiguration.defaultConfiguration()"
  })
  void testDefaultConfiguration() {
    // Arrange and Act
    TbSaveToCustomCassandraTableNodeConfiguration actualDefaultConfigurationResult =
        new TbSaveToCustomCassandraTableNodeConfiguration().defaultConfiguration();

    // Assert
    Map<String, String> fieldsMapping = actualDefaultConfigurationResult.getFieldsMapping();
    assertEquals(1, fieldsMapping.size());
    assertEquals("", fieldsMapping.get(""));
    assertEquals("", actualDefaultConfigurationResult.getTableName());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}, and {@link
   * TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSaveToCustomCassandraTableNodeConfiguration.equals(Object)",
    "int TbSaveToCustomCassandraTableNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration =
        new TbSaveToCustomCassandraTableNodeConfiguration();
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration2 =
        new TbSaveToCustomCassandraTableNodeConfiguration();

    // Act and Assert
    assertEquals(
        tbSaveToCustomCassandraTableNodeConfiguration,
        tbSaveToCustomCassandraTableNodeConfiguration2);
    int expectedHashCodeResult = tbSaveToCustomCassandraTableNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSaveToCustomCassandraTableNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}, and {@link
   * TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSaveToCustomCassandraTableNodeConfiguration.equals(Object)",
    "int TbSaveToCustomCassandraTableNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration =
        new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration.setTableName("Table Name");

    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration2 =
        new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration2.setTableName("Table Name");

    // Act and Assert
    assertEquals(
        tbSaveToCustomCassandraTableNodeConfiguration,
        tbSaveToCustomCassandraTableNodeConfiguration2);
    int expectedHashCodeResult = tbSaveToCustomCassandraTableNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSaveToCustomCassandraTableNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}, and {@link
   * TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSaveToCustomCassandraTableNodeConfiguration.equals(Object)",
    "int TbSaveToCustomCassandraTableNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration =
        new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration.setFieldsMapping(new HashMap<>());

    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration2 =
        new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration2.setFieldsMapping(new HashMap<>());

    // Act and Assert
    assertEquals(
        tbSaveToCustomCassandraTableNodeConfiguration,
        tbSaveToCustomCassandraTableNodeConfiguration2);
    int expectedHashCodeResult = tbSaveToCustomCassandraTableNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSaveToCustomCassandraTableNodeConfiguration2.hashCode());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}, and {@link
   * TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSaveToCustomCassandraTableNodeConfiguration.equals(Object)",
    "int TbSaveToCustomCassandraTableNodeConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration =
        new TbSaveToCustomCassandraTableNodeConfiguration();

    // Act and Assert
    assertEquals(
        tbSaveToCustomCassandraTableNodeConfiguration,
        tbSaveToCustomCassandraTableNodeConfiguration);
    int expectedHashCodeResult = tbSaveToCustomCassandraTableNodeConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, tbSaveToCustomCassandraTableNodeConfiguration.hashCode());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSaveToCustomCassandraTableNodeConfiguration.equals(Object)",
    "int TbSaveToCustomCassandraTableNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSaveToCustomCassandraTableNodeConfiguration(), 1);
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSaveToCustomCassandraTableNodeConfiguration.equals(Object)",
    "int TbSaveToCustomCassandraTableNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration =
        new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration.setTableName("Table Name");

    // Act and Assert
    assertNotEquals(
        tbSaveToCustomCassandraTableNodeConfiguration,
        new TbSaveToCustomCassandraTableNodeConfiguration());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSaveToCustomCassandraTableNodeConfiguration.equals(Object)",
    "int TbSaveToCustomCassandraTableNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration =
        new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration.setFieldsMapping(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        tbSaveToCustomCassandraTableNodeConfiguration,
        new TbSaveToCustomCassandraTableNodeConfiguration());
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSaveToCustomCassandraTableNodeConfiguration.equals(Object)",
    "int TbSaveToCustomCassandraTableNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration =
        new TbSaveToCustomCassandraTableNodeConfiguration();

    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration2 =
        new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration2.setTableName("Table Name");

    // Act and Assert
    assertNotEquals(
        tbSaveToCustomCassandraTableNodeConfiguration,
        tbSaveToCustomCassandraTableNodeConfiguration2);
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSaveToCustomCassandraTableNodeConfiguration.equals(Object)",
    "int TbSaveToCustomCassandraTableNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration =
        new TbSaveToCustomCassandraTableNodeConfiguration();

    TbSaveToCustomCassandraTableNodeConfiguration tbSaveToCustomCassandraTableNodeConfiguration2 =
        new TbSaveToCustomCassandraTableNodeConfiguration();
    tbSaveToCustomCassandraTableNodeConfiguration2.setFieldsMapping(new HashMap<>());

    // Act and Assert
    assertNotEquals(
        tbSaveToCustomCassandraTableNodeConfiguration,
        tbSaveToCustomCassandraTableNodeConfiguration2);
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSaveToCustomCassandraTableNodeConfiguration.equals(Object)",
    "int TbSaveToCustomCassandraTableNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbSaveToCustomCassandraTableNodeConfiguration(), null);
  }

  /**
   * Test {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TbSaveToCustomCassandraTableNodeConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean TbSaveToCustomCassandraTableNodeConfiguration.equals(Object)",
    "int TbSaveToCustomCassandraTableNodeConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new TbSaveToCustomCassandraTableNodeConfiguration(),
        "Different type to TbSaveToCustomCassandraTableNodeConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link
   *       TbSaveToCustomCassandraTableNodeConfiguration}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#setFieldsMapping(Map)}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#setTableName(String)}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#toString()}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#getFieldsMapping()}
   *   <li>{@link TbSaveToCustomCassandraTableNodeConfiguration#getTableName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void TbSaveToCustomCassandraTableNodeConfiguration.<init>()",
    "Map TbSaveToCustomCassandraTableNodeConfiguration.getFieldsMapping()",
    "String TbSaveToCustomCassandraTableNodeConfiguration.getTableName()",
    "void TbSaveToCustomCassandraTableNodeConfiguration.setFieldsMapping(Map)",
    "void TbSaveToCustomCassandraTableNodeConfiguration.setTableName(String)",
    "String TbSaveToCustomCassandraTableNodeConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbSaveToCustomCassandraTableNodeConfiguration
        actualTbSaveToCustomCassandraTableNodeConfiguration =
            new TbSaveToCustomCassandraTableNodeConfiguration();
    HashMap<String, String> fieldsMapping = new HashMap<>();
    actualTbSaveToCustomCassandraTableNodeConfiguration.setFieldsMapping(fieldsMapping);
    actualTbSaveToCustomCassandraTableNodeConfiguration.setTableName("Table Name");
    String actualToStringResult = actualTbSaveToCustomCassandraTableNodeConfiguration.toString();
    Map<String, String> actualFieldsMapping =
        actualTbSaveToCustomCassandraTableNodeConfiguration.getFieldsMapping();

    // Assert
    assertEquals("Table Name", actualTbSaveToCustomCassandraTableNodeConfiguration.getTableName());
    assertEquals(
        "TbSaveToCustomCassandraTableNodeConfiguration(tableName=Table Name, fieldsMapping={})",
        actualToStringResult);
    assertTrue(actualFieldsMapping.isEmpty());
    assertSame(fieldsMapping, actualFieldsMapping);
  }
}
