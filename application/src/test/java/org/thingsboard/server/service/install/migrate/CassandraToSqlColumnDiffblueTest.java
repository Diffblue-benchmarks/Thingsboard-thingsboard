package org.thingsboard.server.service.install.migrate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class CassandraToSqlColumnDiffblueTest {
  /**
   * Test {@link CassandraToSqlColumn#idColumn(String)}.
   *
   * <p>Method under test: {@link CassandraToSqlColumn#idColumn(String)}
   */
  @Test
  @DisplayName("Test idColumn(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CassandraToSqlColumn CassandraToSqlColumn.idColumn(String)"})
  void testIdColumn() {
    // Arrange and Act
    CassandraToSqlColumn actualIdColumnResult = CassandraToSqlColumn.idColumn("Name");

    // Assert
    assertEquals("Name", actualIdColumnResult.getCassandraColumnName());
    assertEquals("Name", actualIdColumnResult.getSqlColumnName());
    assertNull(actualIdColumnResult.getEnumClass());
    assertEquals(0, actualIdColumnResult.getIndex());
    assertEquals(0, actualIdColumnResult.getSize());
    assertEquals(0, actualIdColumnResult.getSqlIndex());
    assertEquals(0, actualIdColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.ID, actualIdColumnResult.getType());
    assertFalse(actualIdColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#stringColumn(String, String)} with {@code
   * cassandraColumnName}, {@code sqlColumnName}.
   *
   * <p>Method under test: {@link CassandraToSqlColumn#stringColumn(String, String)}
   */
  @Test
  @DisplayName("Test stringColumn(String, String) with 'cassandraColumnName', 'sqlColumnName'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CassandraToSqlColumn CassandraToSqlColumn.stringColumn(String, String)"})
  void testStringColumnWithCassandraColumnNameSqlColumnName() {
    // Arrange and Act
    CassandraToSqlColumn actualStringColumnResult =
        CassandraToSqlColumn.stringColumn("Cassandra Column Name", "Sql Column Name");

    // Assert
    assertEquals("Cassandra Column Name", actualStringColumnResult.getCassandraColumnName());
    assertEquals("Sql Column Name", actualStringColumnResult.getSqlColumnName());
    assertNull(actualStringColumnResult.getEnumClass());
    assertEquals(0, actualStringColumnResult.getIndex());
    assertEquals(0, actualStringColumnResult.getSize());
    assertEquals(0, actualStringColumnResult.getSqlIndex());
    assertEquals(0, actualStringColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.STRING, actualStringColumnResult.getType());
    assertFalse(actualStringColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#stringColumn(String)} with {@code name}.
   *
   * <p>Method under test: {@link CassandraToSqlColumn#stringColumn(String)}
   */
  @Test
  @DisplayName("Test stringColumn(String) with 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CassandraToSqlColumn CassandraToSqlColumn.stringColumn(String)"})
  void testStringColumnWithName() {
    // Arrange and Act
    CassandraToSqlColumn actualStringColumnResult = CassandraToSqlColumn.stringColumn("Name");

    // Assert
    assertEquals("Name", actualStringColumnResult.getCassandraColumnName());
    assertEquals("Name", actualStringColumnResult.getSqlColumnName());
    assertNull(actualStringColumnResult.getEnumClass());
    assertEquals(0, actualStringColumnResult.getIndex());
    assertEquals(0, actualStringColumnResult.getSize());
    assertEquals(0, actualStringColumnResult.getSqlIndex());
    assertEquals(0, actualStringColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.STRING, actualStringColumnResult.getType());
    assertFalse(actualStringColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#bigintColumn(String)}.
   *
   * <p>Method under test: {@link CassandraToSqlColumn#bigintColumn(String)}
   */
  @Test
  @DisplayName("Test bigintColumn(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CassandraToSqlColumn CassandraToSqlColumn.bigintColumn(String)"})
  void testBigintColumn() {
    // Arrange and Act
    CassandraToSqlColumn actualBigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");

    // Assert
    assertEquals("Name", actualBigintColumnResult.getCassandraColumnName());
    assertEquals("Name", actualBigintColumnResult.getSqlColumnName());
    assertNull(actualBigintColumnResult.getEnumClass());
    assertEquals(0, actualBigintColumnResult.getIndex());
    assertEquals(0, actualBigintColumnResult.getSize());
    assertEquals(0, actualBigintColumnResult.getSqlIndex());
    assertEquals(0, actualBigintColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.BIGINT, actualBigintColumnResult.getType());
    assertFalse(actualBigintColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#doubleColumn(String)}.
   *
   * <p>Method under test: {@link CassandraToSqlColumn#doubleColumn(String)}
   */
  @Test
  @DisplayName("Test doubleColumn(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CassandraToSqlColumn CassandraToSqlColumn.doubleColumn(String)"})
  void testDoubleColumn() {
    // Arrange and Act
    CassandraToSqlColumn actualDoubleColumnResult = CassandraToSqlColumn.doubleColumn("Name");

    // Assert
    assertEquals("Name", actualDoubleColumnResult.getCassandraColumnName());
    assertEquals("Name", actualDoubleColumnResult.getSqlColumnName());
    assertNull(actualDoubleColumnResult.getEnumClass());
    assertEquals(0, actualDoubleColumnResult.getIndex());
    assertEquals(0, actualDoubleColumnResult.getSize());
    assertEquals(0, actualDoubleColumnResult.getSqlIndex());
    assertEquals(0, actualDoubleColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.DOUBLE, actualDoubleColumnResult.getType());
    assertFalse(actualDoubleColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#booleanColumn(String)} with {@code name}.
   *
   * <p>Method under test: {@link CassandraToSqlColumn#booleanColumn(String)}
   */
  @Test
  @DisplayName("Test booleanColumn(String) with 'name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CassandraToSqlColumn CassandraToSqlColumn.booleanColumn(String)"})
  void testBooleanColumnWithName() {
    // Arrange and Act
    CassandraToSqlColumn actualBooleanColumnResult = CassandraToSqlColumn.booleanColumn("Name");

    // Assert
    assertEquals("Name", actualBooleanColumnResult.getCassandraColumnName());
    assertEquals("Name", actualBooleanColumnResult.getSqlColumnName());
    assertNull(actualBooleanColumnResult.getEnumClass());
    assertEquals(0, actualBooleanColumnResult.getIndex());
    assertEquals(0, actualBooleanColumnResult.getSize());
    assertEquals(0, actualBooleanColumnResult.getSqlIndex());
    assertEquals(0, actualBooleanColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.BOOLEAN, actualBooleanColumnResult.getType());
    assertFalse(actualBooleanColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#booleanColumn(String, boolean)} with {@code name}, {@code
   * allowNullBoolean}.
   *
   * <p>Method under test: {@link CassandraToSqlColumn#booleanColumn(String, boolean)}
   */
  @Test
  @DisplayName("Test booleanColumn(String, boolean) with 'name', 'allowNullBoolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CassandraToSqlColumn CassandraToSqlColumn.booleanColumn(String, boolean)"})
  void testBooleanColumnWithNameAllowNullBoolean() {
    // Arrange and Act
    CassandraToSqlColumn actualBooleanColumnResult =
        CassandraToSqlColumn.booleanColumn("Name", true);

    // Assert
    assertEquals("Name", actualBooleanColumnResult.getCassandraColumnName());
    assertEquals("Name", actualBooleanColumnResult.getSqlColumnName());
    assertNull(actualBooleanColumnResult.getEnumClass());
    assertEquals(0, actualBooleanColumnResult.getIndex());
    assertEquals(0, actualBooleanColumnResult.getSize());
    assertEquals(0, actualBooleanColumnResult.getSqlIndex());
    assertEquals(0, actualBooleanColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.BOOLEAN, actualBooleanColumnResult.getType());
    assertTrue(actualBooleanColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#jsonColumn(String)}.
   *
   * <p>Method under test: {@link CassandraToSqlColumn#jsonColumn(String)}
   */
  @Test
  @DisplayName("Test jsonColumn(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CassandraToSqlColumn CassandraToSqlColumn.jsonColumn(String)"})
  void testJsonColumn() {
    // Arrange and Act
    CassandraToSqlColumn actualJsonColumnResult = CassandraToSqlColumn.jsonColumn("Name");

    // Assert
    assertEquals("Name", actualJsonColumnResult.getCassandraColumnName());
    assertEquals("Name", actualJsonColumnResult.getSqlColumnName());
    assertNull(actualJsonColumnResult.getEnumClass());
    assertEquals(0, actualJsonColumnResult.getIndex());
    assertEquals(0, actualJsonColumnResult.getSize());
    assertEquals(0, actualJsonColumnResult.getSqlIndex());
    assertEquals(0, actualJsonColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.JSON, actualJsonColumnResult.getType());
    assertFalse(actualJsonColumnResult.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#enumToIntColumn(String, Class)}.
   *
   * <p>Method under test: {@link CassandraToSqlColumn#enumToIntColumn(String, Class)}
   */
  @Test
  @DisplayName("Test enumToIntColumn(String, Class)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"CassandraToSqlColumn CassandraToSqlColumn.enumToIntColumn(String, Class)"})
  void testEnumToIntColumn() {
    // Arrange
    Class<Enum> enumClass = Enum.class;

    // Act
    CassandraToSqlColumn actualEnumToIntColumnResult =
        CassandraToSqlColumn.enumToIntColumn("Name", enumClass);

    // Assert
    assertEquals("Name", actualEnumToIntColumnResult.getCassandraColumnName());
    assertEquals("Name", actualEnumToIntColumnResult.getSqlColumnName());
    assertEquals(0, actualEnumToIntColumnResult.getIndex());
    assertEquals(0, actualEnumToIntColumnResult.getSize());
    assertEquals(0, actualEnumToIntColumnResult.getSqlIndex());
    assertEquals(0, actualEnumToIntColumnResult.getSqlType());
    assertEquals(CassandraToSqlColumnType.ENUM_TO_INT, actualEnumToIntColumnResult.getType());
    assertFalse(actualEnumToIntColumnResult.isAllowNullBoolean());
    Class<Enum> expectedEnumClass = Enum.class;
    assertEquals(expectedEnumClass, actualEnumToIntColumnResult.getEnumClass());
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}, and {@link CassandraToSqlColumn#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraToSqlColumn#equals(Object)}
   *   <li>{@link CassandraToSqlColumn#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    CassandraToSqlColumn bigintColumnResult2 = CassandraToSqlColumn.bigintColumn("Name");

    // Act and Assert
    assertEquals(bigintColumnResult, bigintColumnResult2);
    int expectedHashCodeResult = bigintColumnResult.hashCode();
    assertEquals(expectedHashCodeResult, bigintColumnResult2.hashCode());
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}, and {@link CassandraToSqlColumn#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraToSqlColumn#equals(Object)}
   *   <li>{@link CassandraToSqlColumn#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn(null);
    CassandraToSqlColumn bigintColumnResult2 = CassandraToSqlColumn.bigintColumn(null);

    // Act and Assert
    assertEquals(bigintColumnResult, bigintColumnResult2);
    int expectedHashCodeResult = bigintColumnResult.hashCode();
    assertEquals(expectedHashCodeResult, bigintColumnResult2.hashCode());
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}, and {@link CassandraToSqlColumn#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraToSqlColumn#equals(Object)}
   *   <li>{@link CassandraToSqlColumn#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    Class<Enum> enumClass = Enum.class;
    bigintColumnResult.setEnumClass(enumClass);
    CassandraToSqlColumn bigintColumnResult2 = CassandraToSqlColumn.bigintColumn("Name");
    Class<Enum> enumClass2 = Enum.class;
    bigintColumnResult2.setEnumClass(enumClass2);

    // Act and Assert
    assertEquals(bigintColumnResult, bigintColumnResult2);
    int expectedHashCodeResult = bigintColumnResult.hashCode();
    assertEquals(expectedHashCodeResult, bigintColumnResult2.hashCode());
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}, and {@link CassandraToSqlColumn#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraToSqlColumn#equals(Object)}
   *   <li>{@link CassandraToSqlColumn#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");

    // Act and Assert
    assertEquals(bigintColumnResult, bigintColumnResult);
    int expectedHashCodeResult = bigintColumnResult.hashCode();
    assertEquals(expectedHashCodeResult, bigintColumnResult.hashCode());
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn(null);

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult =
        CassandraToSqlColumn.bigintColumn(
            "org.thingsboard.server.service.install.migrate.CassandraToSqlColumn");

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CassandraToSqlColumn doubleColumnResult = CassandraToSqlColumn.doubleColumn("Name");

    // Act and Assert
    assertNotEquals(doubleColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setIndex(1);

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setSqlIndex(1);

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setSqlType(1);

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setSize(3);

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    Class<Enum> enumClass = Enum.class;
    bigintColumnResult.setEnumClass(enumClass);

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult.setAllowNullBoolean(true);

    // Act and Assert
    assertNotEquals(bigintColumnResult, CassandraToSqlColumn.bigintColumn("Name"));
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    CassandraToSqlColumn bigintColumnResult2 = CassandraToSqlColumn.bigintColumn("Name");
    Class<Enum> enumClass = Enum.class;
    bigintColumnResult2.setEnumClass(enumClass);

    // Act and Assert
    assertNotEquals(bigintColumnResult, bigintColumnResult2);
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult =
        CassandraToSqlColumn.bigintColumn(
            "org.thingsboard.server.service.install.migrate.CassandraToSqlColumn");
    CassandraToSqlColumn bigintColumnResult2 = CassandraToSqlColumn.bigintColumn("Name");
    bigintColumnResult2.setCassandraColumnName(
        "org.thingsboard.server.service.install.migrate.CassandraToSqlColumn");

    // Act and Assert
    assertNotEquals(bigintColumnResult, bigintColumnResult2);
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn(null);
    CassandraToSqlColumn bigintColumnResult2 = CassandraToSqlColumn.bigintColumn(null);
    bigintColumnResult2.setSqlColumnName("Sql Column Name");

    // Act and Assert
    assertNotEquals(bigintColumnResult, bigintColumnResult2);
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(CassandraToSqlColumn.bigintColumn("Name"), null);
  }

  /**
   * Test {@link CassandraToSqlColumn#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean CassandraToSqlColumn.equals(Object)",
    "int CassandraToSqlColumn.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        CassandraToSqlColumn.bigintColumn("Name"), "Different type to CassandraToSqlColumn");
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Cassandra Column Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraToSqlColumn#CassandraToSqlColumn(String, String,
   *       CassandraToSqlColumnType, Class, boolean)}
   *   <li>{@link CassandraToSqlColumn#setAllowNullBoolean(boolean)}
   *   <li>{@link CassandraToSqlColumn#setCassandraColumnName(String)}
   *   <li>{@link CassandraToSqlColumn#setEnumClass(Class)}
   *   <li>{@link CassandraToSqlColumn#setIndex(int)}
   *   <li>{@link CassandraToSqlColumn#setSize(int)}
   *   <li>{@link CassandraToSqlColumn#setSqlColumnName(String)}
   *   <li>{@link CassandraToSqlColumn#setSqlIndex(int)}
   *   <li>{@link CassandraToSqlColumn#setSqlType(int)}
   *   <li>{@link CassandraToSqlColumn#setType(CassandraToSqlColumnType)}
   *   <li>{@link CassandraToSqlColumn#toString()}
   *   <li>{@link CassandraToSqlColumn#getCassandraColumnName()}
   *   <li>{@link CassandraToSqlColumn#getEnumClass()}
   *   <li>{@link CassandraToSqlColumn#getIndex()}
   *   <li>{@link CassandraToSqlColumn#getSize()}
   *   <li>{@link CassandraToSqlColumn#getSqlColumnName()}
   *   <li>{@link CassandraToSqlColumn#getSqlIndex()}
   *   <li>{@link CassandraToSqlColumn#getSqlType()}
   *   <li>{@link CassandraToSqlColumn#getType()}
   *   <li>{@link CassandraToSqlColumn#isAllowNullBoolean()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Cassandra Column Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void CassandraToSqlColumn.<init>(String, String, CassandraToSqlColumnType, Class, boolean)",
    "void CassandraToSqlColumn.<init>(String, CassandraToSqlColumnType)",
    "void CassandraToSqlColumn.<init>(String, CassandraToSqlColumnType, Class)",
    "String CassandraToSqlColumn.getCassandraColumnName()",
    "Class CassandraToSqlColumn.getEnumClass()",
    "int CassandraToSqlColumn.getIndex()",
    "int CassandraToSqlColumn.getSize()",
    "String CassandraToSqlColumn.getSqlColumnName()",
    "int CassandraToSqlColumn.getSqlIndex()",
    "int CassandraToSqlColumn.getSqlType()",
    "CassandraToSqlColumnType CassandraToSqlColumn.getType()",
    "boolean CassandraToSqlColumn.isAllowNullBoolean()",
    "void CassandraToSqlColumn.setAllowNullBoolean(boolean)",
    "void CassandraToSqlColumn.setCassandraColumnName(String)",
    "void CassandraToSqlColumn.setEnumClass(Class)",
    "void CassandraToSqlColumn.setIndex(int)",
    "void CassandraToSqlColumn.setSize(int)",
    "void CassandraToSqlColumn.setSqlColumnName(String)",
    "void CassandraToSqlColumn.setSqlIndex(int)",
    "void CassandraToSqlColumn.setSqlType(int)",
    "void CassandraToSqlColumn.setType(CassandraToSqlColumnType)",
    "String CassandraToSqlColumn.toString()"
  })
  void testGettersAndSetters_whenCassandraColumnName() {
    // Arrange
    Class<Enum> enumClass = Enum.class;

    // Act
    CassandraToSqlColumn actualCassandraToSqlColumn =
        new CassandraToSqlColumn(
            "Cassandra Column Name",
            "Sql Column Name",
            CassandraToSqlColumnType.ID,
            enumClass,
            true);
    actualCassandraToSqlColumn.setAllowNullBoolean(true);
    actualCassandraToSqlColumn.setCassandraColumnName("Cassandra Column Name");
    Class<Enum> enumClass2 = Enum.class;
    actualCassandraToSqlColumn.setEnumClass(enumClass2);
    actualCassandraToSqlColumn.setIndex(1);
    actualCassandraToSqlColumn.setSize(3);
    actualCassandraToSqlColumn.setSqlColumnName("Sql Column Name");
    actualCassandraToSqlColumn.setSqlIndex(1);
    actualCassandraToSqlColumn.setSqlType(1);
    actualCassandraToSqlColumn.setType(CassandraToSqlColumnType.ID);
    String actualToStringResult = actualCassandraToSqlColumn.toString();
    String actualCassandraColumnName = actualCassandraToSqlColumn.getCassandraColumnName();
    Class<? extends Enum> actualEnumClass = actualCassandraToSqlColumn.getEnumClass();
    int actualIndex = actualCassandraToSqlColumn.getIndex();
    int actualSize = actualCassandraToSqlColumn.getSize();
    String actualSqlColumnName = actualCassandraToSqlColumn.getSqlColumnName();
    int actualSqlIndex = actualCassandraToSqlColumn.getSqlIndex();
    int actualSqlType = actualCassandraToSqlColumn.getSqlType();
    CassandraToSqlColumnType actualType = actualCassandraToSqlColumn.getType();

    // Assert
    assertEquals("Cassandra Column Name", actualCassandraColumnName);
    assertEquals(
        "CassandraToSqlColumn(index=1, sqlIndex=1, cassandraColumnName=Cassandra Column Name, sqlColumnName=Sql"
            + " Column Name, type=ID, sqlType=1, size=3, enumClass=class java.lang.Enum, allowNullBoolean=true)",
        actualToStringResult);
    assertEquals("Sql Column Name", actualSqlColumnName);
    assertEquals(1, actualIndex);
    assertEquals(1, actualSqlIndex);
    assertEquals(1, actualSqlType);
    assertEquals(3, actualSize);
    assertEquals(CassandraToSqlColumnType.ID, actualType);
    assertTrue(actualCassandraToSqlColumn.isAllowNullBoolean());
    Class<Enum> expectedEnumClass = Enum.class;
    assertEquals(expectedEnumClass, actualEnumClass);
    assertSame(enumClass2, actualEnumClass);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Column Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraToSqlColumn#CassandraToSqlColumn(String, CassandraToSqlColumnType)}
   *   <li>{@link CassandraToSqlColumn#setAllowNullBoolean(boolean)}
   *   <li>{@link CassandraToSqlColumn#setCassandraColumnName(String)}
   *   <li>{@link CassandraToSqlColumn#setEnumClass(Class)}
   *   <li>{@link CassandraToSqlColumn#setIndex(int)}
   *   <li>{@link CassandraToSqlColumn#setSize(int)}
   *   <li>{@link CassandraToSqlColumn#setSqlColumnName(String)}
   *   <li>{@link CassandraToSqlColumn#setSqlIndex(int)}
   *   <li>{@link CassandraToSqlColumn#setSqlType(int)}
   *   <li>{@link CassandraToSqlColumn#setType(CassandraToSqlColumnType)}
   *   <li>{@link CassandraToSqlColumn#toString()}
   *   <li>{@link CassandraToSqlColumn#getCassandraColumnName()}
   *   <li>{@link CassandraToSqlColumn#getEnumClass()}
   *   <li>{@link CassandraToSqlColumn#getIndex()}
   *   <li>{@link CassandraToSqlColumn#getSize()}
   *   <li>{@link CassandraToSqlColumn#getSqlColumnName()}
   *   <li>{@link CassandraToSqlColumn#getSqlIndex()}
   *   <li>{@link CassandraToSqlColumn#getSqlType()}
   *   <li>{@link CassandraToSqlColumn#getType()}
   *   <li>{@link CassandraToSqlColumn#isAllowNullBoolean()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Column Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void CassandraToSqlColumn.<init>(String, String, CassandraToSqlColumnType, Class, boolean)",
    "void CassandraToSqlColumn.<init>(String, CassandraToSqlColumnType)",
    "void CassandraToSqlColumn.<init>(String, CassandraToSqlColumnType, Class)",
    "String CassandraToSqlColumn.getCassandraColumnName()",
    "Class CassandraToSqlColumn.getEnumClass()",
    "int CassandraToSqlColumn.getIndex()",
    "int CassandraToSqlColumn.getSize()",
    "String CassandraToSqlColumn.getSqlColumnName()",
    "int CassandraToSqlColumn.getSqlIndex()",
    "int CassandraToSqlColumn.getSqlType()",
    "CassandraToSqlColumnType CassandraToSqlColumn.getType()",
    "boolean CassandraToSqlColumn.isAllowNullBoolean()",
    "void CassandraToSqlColumn.setAllowNullBoolean(boolean)",
    "void CassandraToSqlColumn.setCassandraColumnName(String)",
    "void CassandraToSqlColumn.setEnumClass(Class)",
    "void CassandraToSqlColumn.setIndex(int)",
    "void CassandraToSqlColumn.setSize(int)",
    "void CassandraToSqlColumn.setSqlColumnName(String)",
    "void CassandraToSqlColumn.setSqlIndex(int)",
    "void CassandraToSqlColumn.setSqlType(int)",
    "void CassandraToSqlColumn.setType(CassandraToSqlColumnType)",
    "String CassandraToSqlColumn.toString()"
  })
  void testGettersAndSetters_whenColumnName() {
    // Arrange and Act
    CassandraToSqlColumn actualCassandraToSqlColumn =
        new CassandraToSqlColumn("Column Name", CassandraToSqlColumnType.ID);
    actualCassandraToSqlColumn.setAllowNullBoolean(true);
    actualCassandraToSqlColumn.setCassandraColumnName("Cassandra Column Name");
    Class<Enum> enumClass = Enum.class;
    actualCassandraToSqlColumn.setEnumClass(enumClass);
    actualCassandraToSqlColumn.setIndex(1);
    actualCassandraToSqlColumn.setSize(3);
    actualCassandraToSqlColumn.setSqlColumnName("Sql Column Name");
    actualCassandraToSqlColumn.setSqlIndex(1);
    actualCassandraToSqlColumn.setSqlType(1);
    actualCassandraToSqlColumn.setType(CassandraToSqlColumnType.ID);
    String actualToStringResult = actualCassandraToSqlColumn.toString();
    String actualCassandraColumnName = actualCassandraToSqlColumn.getCassandraColumnName();
    Class<? extends Enum> actualEnumClass = actualCassandraToSqlColumn.getEnumClass();
    int actualIndex = actualCassandraToSqlColumn.getIndex();
    int actualSize = actualCassandraToSqlColumn.getSize();
    String actualSqlColumnName = actualCassandraToSqlColumn.getSqlColumnName();
    int actualSqlIndex = actualCassandraToSqlColumn.getSqlIndex();
    int actualSqlType = actualCassandraToSqlColumn.getSqlType();
    CassandraToSqlColumnType actualType = actualCassandraToSqlColumn.getType();

    // Assert
    assertEquals("Cassandra Column Name", actualCassandraColumnName);
    assertEquals(
        "CassandraToSqlColumn(index=1, sqlIndex=1, cassandraColumnName=Cassandra Column Name, sqlColumnName=Sql"
            + " Column Name, type=ID, sqlType=1, size=3, enumClass=class java.lang.Enum, allowNullBoolean=true)",
        actualToStringResult);
    assertEquals("Sql Column Name", actualSqlColumnName);
    assertEquals(1, actualIndex);
    assertEquals(1, actualSqlIndex);
    assertEquals(1, actualSqlType);
    assertEquals(3, actualSize);
    assertEquals(CassandraToSqlColumnType.ID, actualType);
    assertTrue(actualCassandraToSqlColumn.isAllowNullBoolean());
    Class<Enum> expectedEnumClass = Enum.class;
    assertEquals(expectedEnumClass, actualEnumClass);
    assertSame(enumClass, actualEnumClass);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code Column Name}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link CassandraToSqlColumn#CassandraToSqlColumn(String, CassandraToSqlColumnType,
   *       Class)}
   *   <li>{@link CassandraToSqlColumn#setAllowNullBoolean(boolean)}
   *   <li>{@link CassandraToSqlColumn#setCassandraColumnName(String)}
   *   <li>{@link CassandraToSqlColumn#setEnumClass(Class)}
   *   <li>{@link CassandraToSqlColumn#setIndex(int)}
   *   <li>{@link CassandraToSqlColumn#setSize(int)}
   *   <li>{@link CassandraToSqlColumn#setSqlColumnName(String)}
   *   <li>{@link CassandraToSqlColumn#setSqlIndex(int)}
   *   <li>{@link CassandraToSqlColumn#setSqlType(int)}
   *   <li>{@link CassandraToSqlColumn#setType(CassandraToSqlColumnType)}
   *   <li>{@link CassandraToSqlColumn#toString()}
   *   <li>{@link CassandraToSqlColumn#getCassandraColumnName()}
   *   <li>{@link CassandraToSqlColumn#getEnumClass()}
   *   <li>{@link CassandraToSqlColumn#getIndex()}
   *   <li>{@link CassandraToSqlColumn#getSize()}
   *   <li>{@link CassandraToSqlColumn#getSqlColumnName()}
   *   <li>{@link CassandraToSqlColumn#getSqlIndex()}
   *   <li>{@link CassandraToSqlColumn#getSqlType()}
   *   <li>{@link CassandraToSqlColumn#getType()}
   *   <li>{@link CassandraToSqlColumn#isAllowNullBoolean()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Column Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void CassandraToSqlColumn.<init>(String, String, CassandraToSqlColumnType, Class, boolean)",
    "void CassandraToSqlColumn.<init>(String, CassandraToSqlColumnType)",
    "void CassandraToSqlColumn.<init>(String, CassandraToSqlColumnType, Class)",
    "String CassandraToSqlColumn.getCassandraColumnName()",
    "Class CassandraToSqlColumn.getEnumClass()",
    "int CassandraToSqlColumn.getIndex()",
    "int CassandraToSqlColumn.getSize()",
    "String CassandraToSqlColumn.getSqlColumnName()",
    "int CassandraToSqlColumn.getSqlIndex()",
    "int CassandraToSqlColumn.getSqlType()",
    "CassandraToSqlColumnType CassandraToSqlColumn.getType()",
    "boolean CassandraToSqlColumn.isAllowNullBoolean()",
    "void CassandraToSqlColumn.setAllowNullBoolean(boolean)",
    "void CassandraToSqlColumn.setCassandraColumnName(String)",
    "void CassandraToSqlColumn.setEnumClass(Class)",
    "void CassandraToSqlColumn.setIndex(int)",
    "void CassandraToSqlColumn.setSize(int)",
    "void CassandraToSqlColumn.setSqlColumnName(String)",
    "void CassandraToSqlColumn.setSqlIndex(int)",
    "void CassandraToSqlColumn.setSqlType(int)",
    "void CassandraToSqlColumn.setType(CassandraToSqlColumnType)",
    "String CassandraToSqlColumn.toString()"
  })
  void testGettersAndSetters_whenColumnName2() {
    // Arrange
    Class<Enum> enumClass = Enum.class;

    // Act
    CassandraToSqlColumn actualCassandraToSqlColumn =
        new CassandraToSqlColumn("Column Name", CassandraToSqlColumnType.ID, enumClass);
    actualCassandraToSqlColumn.setAllowNullBoolean(true);
    actualCassandraToSqlColumn.setCassandraColumnName("Cassandra Column Name");
    Class<Enum> enumClass2 = Enum.class;
    actualCassandraToSqlColumn.setEnumClass(enumClass2);
    actualCassandraToSqlColumn.setIndex(1);
    actualCassandraToSqlColumn.setSize(3);
    actualCassandraToSqlColumn.setSqlColumnName("Sql Column Name");
    actualCassandraToSqlColumn.setSqlIndex(1);
    actualCassandraToSqlColumn.setSqlType(1);
    actualCassandraToSqlColumn.setType(CassandraToSqlColumnType.ID);
    String actualToStringResult = actualCassandraToSqlColumn.toString();
    String actualCassandraColumnName = actualCassandraToSqlColumn.getCassandraColumnName();
    Class<? extends Enum> actualEnumClass = actualCassandraToSqlColumn.getEnumClass();
    int actualIndex = actualCassandraToSqlColumn.getIndex();
    int actualSize = actualCassandraToSqlColumn.getSize();
    String actualSqlColumnName = actualCassandraToSqlColumn.getSqlColumnName();
    int actualSqlIndex = actualCassandraToSqlColumn.getSqlIndex();
    int actualSqlType = actualCassandraToSqlColumn.getSqlType();
    CassandraToSqlColumnType actualType = actualCassandraToSqlColumn.getType();

    // Assert
    assertEquals("Cassandra Column Name", actualCassandraColumnName);
    assertEquals(
        "CassandraToSqlColumn(index=1, sqlIndex=1, cassandraColumnName=Cassandra Column Name, sqlColumnName=Sql"
            + " Column Name, type=ID, sqlType=1, size=3, enumClass=class java.lang.Enum, allowNullBoolean=true)",
        actualToStringResult);
    assertEquals("Sql Column Name", actualSqlColumnName);
    assertEquals(1, actualIndex);
    assertEquals(1, actualSqlIndex);
    assertEquals(1, actualSqlType);
    assertEquals(3, actualSize);
    assertEquals(CassandraToSqlColumnType.ID, actualType);
    assertTrue(actualCassandraToSqlColumn.isAllowNullBoolean());
    Class<Enum> expectedEnumClass = Enum.class;
    assertEquals(expectedEnumClass, actualEnumClass);
    assertSame(enumClass2, actualEnumClass);
  }

  /**
   * Test {@link CassandraToSqlColumn#CassandraToSqlColumn(String, String)}.
   *
   * <p>Method under test: {@link CassandraToSqlColumn#CassandraToSqlColumn(String, String)}
   */
  @Test
  @DisplayName("Test new CassandraToSqlColumn(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.<init>(String, String)"})
  void testNewCassandraToSqlColumn() {
    // Arrange and Act
    CassandraToSqlColumn actualCassandraToSqlColumn =
        new CassandraToSqlColumn("Cassandra Column Name", "Sql Column Name");

    // Assert
    assertEquals("Cassandra Column Name", actualCassandraToSqlColumn.getCassandraColumnName());
    assertEquals("Sql Column Name", actualCassandraToSqlColumn.getSqlColumnName());
    assertNull(actualCassandraToSqlColumn.getEnumClass());
    assertEquals(0, actualCassandraToSqlColumn.getIndex());
    assertEquals(0, actualCassandraToSqlColumn.getSize());
    assertEquals(0, actualCassandraToSqlColumn.getSqlIndex());
    assertEquals(0, actualCassandraToSqlColumn.getSqlType());
    assertEquals(CassandraToSqlColumnType.STRING, actualCassandraToSqlColumn.getType());
    assertFalse(actualCassandraToSqlColumn.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#CassandraToSqlColumn(String)}.
   *
   * <ul>
   *   <li>Then return CassandraColumnName is {@code Column Name}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#CassandraToSqlColumn(String)}
   */
  @Test
  @DisplayName(
      "Test new CassandraToSqlColumn(String); then return CassandraColumnName is 'Column Name'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.<init>(String)"})
  void testNewCassandraToSqlColumn_thenReturnCassandraColumnNameIsColumnName() {
    // Arrange and Act
    CassandraToSqlColumn actualCassandraToSqlColumn = new CassandraToSqlColumn("Column Name");

    // Assert
    assertEquals("Column Name", actualCassandraToSqlColumn.getCassandraColumnName());
    assertEquals("Column Name", actualCassandraToSqlColumn.getSqlColumnName());
    assertNull(actualCassandraToSqlColumn.getEnumClass());
    assertEquals(0, actualCassandraToSqlColumn.getIndex());
    assertEquals(0, actualCassandraToSqlColumn.getSize());
    assertEquals(0, actualCassandraToSqlColumn.getSqlIndex());
    assertEquals(0, actualCassandraToSqlColumn.getSqlType());
    assertEquals(CassandraToSqlColumnType.STRING, actualCassandraToSqlColumn.getType());
    assertFalse(actualCassandraToSqlColumn.isAllowNullBoolean());
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#setBoolean(int, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName(
      "Test setColumnValue(PreparedStatement, String); then calls setBoolean(int, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_thenCallsSetBoolean() throws SQLException {
    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = new CassandraToSqlColumn("Column Name");
    cassandraToSqlColumn.setType(CassandraToSqlColumnType.BOOLEAN);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setBoolean(anyInt(), anyBoolean());

    // Act
    cassandraToSqlColumn.setColumnValue(sqlInsertStatement, "1");

    // Assert
    verify(sqlInsertStatement).setBoolean(eq(0), eq(false));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#setInt(int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName("Test setColumnValue(PreparedStatement, String); then calls setInt(int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_thenCallsSetInt() throws SQLException {
    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = new CassandraToSqlColumn("Column Name");
    cassandraToSqlColumn.setType(CassandraToSqlColumnType.INTEGER);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setInt(anyInt(), anyInt());

    // Act
    cassandraToSqlColumn.setColumnValue(sqlInsertStatement, "1");

    // Assert
    verify(sqlInsertStatement).setInt(eq(0), eq(1));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setBoolean(int, boolean)} throw
   *       {@link SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName(
      "Test setColumnValue(PreparedStatement, String); when PreparedStatement setBoolean(int, boolean) throw SQLException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_whenPreparedStatementSetBooleanThrowSQLException() throws SQLException {
    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = new CassandraToSqlColumn("Column Name");
    cassandraToSqlColumn.setType(CassandraToSqlColumnType.BOOLEAN);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(sqlInsertStatement).setBoolean(anyInt(), anyBoolean());

    // Act and Assert
    assertThrows(
        SQLException.class, () -> cassandraToSqlColumn.setColumnValue(sqlInsertStatement, "1"));
    verify(sqlInsertStatement).setBoolean(eq(0), eq(false));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setDouble(int, double)} does
   *       nothing.
   *   <li>Then calls {@link PreparedStatement#setDouble(int, double)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName(
      "Test setColumnValue(PreparedStatement, String); when PreparedStatement setDouble(int, double) does nothing; then calls setDouble(int, double)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_whenPreparedStatementSetDoubleDoesNothing_thenCallsSetDouble()
      throws SQLException {
    // Arrange
    CassandraToSqlColumn doubleColumnResult = CassandraToSqlColumn.doubleColumn("Name");
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setDouble(anyInt(), anyDouble());

    // Act
    doubleColumnResult.setColumnValue(sqlInsertStatement, "42");

    // Assert
    verify(sqlInsertStatement).setDouble(eq(0), eq(42.0d));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setDouble(int, double)} throw
   *       {@link SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName(
      "Test setColumnValue(PreparedStatement, String); when PreparedStatement setDouble(int, double) throw SQLException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_whenPreparedStatementSetDoubleThrowSQLException() throws SQLException {
    // Arrange
    CassandraToSqlColumn doubleColumnResult = CassandraToSqlColumn.doubleColumn("Name");
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(sqlInsertStatement).setDouble(anyInt(), anyDouble());

    // Act and Assert
    assertThrows(
        SQLException.class, () -> doubleColumnResult.setColumnValue(sqlInsertStatement, "42"));
    verify(sqlInsertStatement).setDouble(eq(0), eq(42.0d));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setFloat(int, float)} does
   *       nothing.
   *   <li>Then calls {@link PreparedStatement#setFloat(int, float)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName(
      "Test setColumnValue(PreparedStatement, String); when PreparedStatement setFloat(int, float) does nothing; then calls setFloat(int, float)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_whenPreparedStatementSetFloatDoesNothing_thenCallsSetFloat()
      throws SQLException {
    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = new CassandraToSqlColumn("Column Name");
    cassandraToSqlColumn.setType(CassandraToSqlColumnType.FLOAT);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setFloat(anyInt(), anyFloat());

    // Act
    cassandraToSqlColumn.setColumnValue(sqlInsertStatement, "1");

    // Assert
    verify(sqlInsertStatement).setFloat(eq(0), eq(1.0f));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setFloat(int, float)} throw
   *       {@link SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName(
      "Test setColumnValue(PreparedStatement, String); when PreparedStatement setFloat(int, float) throw SQLException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_whenPreparedStatementSetFloatThrowSQLException() throws SQLException {
    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = new CassandraToSqlColumn("Column Name");
    cassandraToSqlColumn.setType(CassandraToSqlColumnType.FLOAT);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(sqlInsertStatement).setFloat(anyInt(), anyFloat());

    // Act and Assert
    assertThrows(
        SQLException.class, () -> cassandraToSqlColumn.setColumnValue(sqlInsertStatement, "1"));
    verify(sqlInsertStatement).setFloat(eq(0), eq(1.0f));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setInt(int, int)} throw {@link
   *       SQLException#SQLException()}.
   *   <li>Then calls {@link PreparedStatement#setInt(int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName(
      "Test setColumnValue(PreparedStatement, String); when PreparedStatement setInt(int, int) throw SQLException(); then calls setInt(int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_whenPreparedStatementSetIntThrowSQLException_thenCallsSetInt()
      throws SQLException {
    // Arrange
    CassandraToSqlColumn cassandraToSqlColumn = new CassandraToSqlColumn("Column Name");
    cassandraToSqlColumn.setType(CassandraToSqlColumnType.INTEGER);
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(sqlInsertStatement).setInt(anyInt(), anyInt());

    // Act and Assert
    assertThrows(
        SQLException.class, () -> cassandraToSqlColumn.setColumnValue(sqlInsertStatement, "1"));
    verify(sqlInsertStatement).setInt(eq(0), eq(1));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setLong(int, long)} does nothing.
   *   <li>Then calls {@link PreparedStatement#setLong(int, long)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName(
      "Test setColumnValue(PreparedStatement, String); when PreparedStatement setLong(int, long) does nothing; then calls setLong(int, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_whenPreparedStatementSetLongDoesNothing_thenCallsSetLong()
      throws SQLException {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setLong(anyInt(), anyLong());

    // Act
    bigintColumnResult.setColumnValue(sqlInsertStatement, "42");

    // Assert
    verify(sqlInsertStatement).setLong(eq(0), eq(42L));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setLong(int, long)} throw {@link
   *       SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName(
      "Test setColumnValue(PreparedStatement, String); when PreparedStatement setLong(int, long) throw SQLException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_whenPreparedStatementSetLongThrowSQLException() throws SQLException {
    // Arrange
    CassandraToSqlColumn bigintColumnResult = CassandraToSqlColumn.bigintColumn("Name");
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(sqlInsertStatement).setLong(anyInt(), anyLong());

    // Act and Assert
    assertThrows(
        SQLException.class, () -> bigintColumnResult.setColumnValue(sqlInsertStatement, "42"));
    verify(sqlInsertStatement).setLong(eq(0), eq(42L));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} does nothing.
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName(
      "Test setColumnValue(PreparedStatement, String); when PreparedStatement setNull(int, int) does nothing; then calls setNull(int, int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_whenPreparedStatementSetNullDoesNothing_thenCallsSetNull()
      throws SQLException {
    // Arrange
    CassandraToSqlColumn idColumnResult = CassandraToSqlColumn.idColumn("Name");
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setNull(anyInt(), anyInt());

    // Act
    idColumnResult.setColumnValue(sqlInsertStatement, null);

    // Assert
    verify(sqlInsertStatement).setNull(eq(0), eq(0));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} throw {@link
   *       SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName(
      "Test setColumnValue(PreparedStatement, String); when PreparedStatement setNull(int, int) throw SQLException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_whenPreparedStatementSetNullThrowSQLException() throws SQLException {
    // Arrange
    CassandraToSqlColumn idColumnResult = CassandraToSqlColumn.idColumn("Name");
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(sqlInsertStatement).setNull(anyInt(), anyInt());

    // Act and Assert
    assertThrows(SQLException.class, () -> idColumnResult.setColumnValue(sqlInsertStatement, null));
    verify(sqlInsertStatement).setNull(eq(0), eq(0));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setString(int, String)} does
   *       nothing.
   *   <li>Then calls {@link PreparedStatement#setString(int, String)}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName(
      "Test setColumnValue(PreparedStatement, String); when PreparedStatement setString(int, String) does nothing; then calls setString(int, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_whenPreparedStatementSetStringDoesNothing_thenCallsSetString()
      throws SQLException {
    // Arrange
    CassandraToSqlColumn idColumnResult = CassandraToSqlColumn.idColumn("Name");
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doNothing().when(sqlInsertStatement).setString(anyInt(), Mockito.<String>any());

    // Act
    idColumnResult.setColumnValue(sqlInsertStatement, "42");

    // Assert
    verify(sqlInsertStatement).setString(eq(0), eq("42"));
  }

  /**
   * Test {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setString(int, String)} throw
   *       {@link SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link CassandraToSqlColumn#setColumnValue(PreparedStatement, String)}
   */
  @Test
  @DisplayName(
      "Test setColumnValue(PreparedStatement, String); when PreparedStatement setString(int, String) throw SQLException()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CassandraToSqlColumn.setColumnValue(PreparedStatement, String)"})
  void testSetColumnValue_whenPreparedStatementSetStringThrowSQLException() throws SQLException {
    // Arrange
    CassandraToSqlColumn idColumnResult = CassandraToSqlColumn.idColumn("Name");
    PreparedStatement sqlInsertStatement = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(sqlInsertStatement).setString(anyInt(), Mockito.<String>any());

    // Act and Assert
    assertThrows(SQLException.class, () -> idColumnResult.setColumnValue(sqlInsertStatement, "42"));
    verify(sqlInsertStatement).setString(eq(0), eq("42"));
  }
}
