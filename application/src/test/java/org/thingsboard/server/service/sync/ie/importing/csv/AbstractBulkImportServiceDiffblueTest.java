package org.thingsboard.server.service.sync.ie.importing.csv;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportColumnType;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportRequest;
import org.thingsboard.server.common.data.sync.ie.importing.csv.BulkImportRequest.ColumnMapping;
import org.thingsboard.server.service.sync.ie.importing.csv.AbstractBulkImportService.EntityData;
import org.thingsboard.server.service.sync.ie.importing.csv.AbstractBulkImportService.ParsedValue;

@ExtendWith(MockitoExtension.class)
class AbstractBulkImportServiceDiffblueTest {
  @Mock
  private DataType dataType;

  @InjectMocks
  private ParsedValue parsedValue;

  /**
   * Test EntityData {@link EntityData#equals(Object)}, and {@link EntityData#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityData#equals(Object)}
   *   <li>{@link EntityData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityData equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEntityDataEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityData entityData = new EntityData();
    entityData.setLineNumber(2);

    EntityData entityData2 = new EntityData();
    entityData2.setLineNumber(2);

    // Act and Assert
    assertEquals(entityData, entityData2);
    int expectedHashCodeResult = entityData.hashCode();
    assertEquals(expectedHashCodeResult, entityData2.hashCode());
  }

  /**
   * Test EntityData {@link EntityData#equals(Object)}, and {@link EntityData#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityData#equals(Object)}
   *   <li>{@link EntityData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityData equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEntityDataEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityData entityData = new EntityData();
    entityData.setLineNumber(2);

    // Act and Assert
    assertEquals(entityData, entityData);
    int expectedHashCodeResult = entityData.hashCode();
    assertEquals(expectedHashCodeResult, entityData.hashCode());
  }

  /**
   * Test EntityData {@link EntityData#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test EntityData equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEntityDataEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityData entityData = new EntityData();
    entityData.setLineNumber(10);

    EntityData entityData2 = new EntityData();
    entityData2.setLineNumber(2);

    // Act and Assert
    assertNotEquals(entityData, entityData2);
  }

  /**
   * Test EntityData {@link EntityData#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test EntityData equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEntityDataEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityData entityData = new EntityData();
    entityData.setLineNumber(2);

    // Act and Assert
    assertNotEquals(entityData, null);
  }

  /**
   * Test EntityData {@link EntityData#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityData#equals(Object)}
   */
  @Test
  @DisplayName("Test EntityData equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EntityData.equals(Object)", "int EntityData.hashCode()"})
  void testEntityDataEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityData entityData = new EntityData();
    entityData.setLineNumber(2);

    // Act and Assert
    assertNotEquals(entityData, "Different type to EntityData");
  }

  /**
   * Test EntityData getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityData}
   *   <li>{@link EntityData#setLineNumber(int)}
   *   <li>{@link EntityData#toString()}
   *   <li>{@link EntityData#getFields()}
   *   <li>{@link EntityData#getKvs()}
   *   <li>{@link EntityData#getLineNumber()}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityData getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityData.<init>()", "Map EntityData.getFields()", "Map EntityData.getKvs()",
      "int EntityData.getLineNumber()", "void EntityData.setLineNumber(int)", "String EntityData.toString()"})
  void testEntityDataGettersAndSetters() {
    // Arrange and Act
    EntityData actualEntityData = new EntityData();
    actualEntityData.setLineNumber(2);
    String actualToStringResult = actualEntityData.toString();
    Map<BulkImportColumnType, String> actualFields = actualEntityData.getFields();
    Map<ColumnMapping, ParsedValue> actualKvs = actualEntityData.getKvs();

    // Assert
    assertEquals("AbstractBulkImportService.EntityData(fields={}, kvs={}, lineNumber=2)", actualToStringResult);
    assertEquals(2, actualEntityData.getLineNumber());
    assertTrue(actualFields.isEmpty());
    assertTrue(actualKvs.isEmpty());
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}, and {@link ParsedValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParsedValue#equals(Object)}
   *   <li>{@link ParsedValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParsedValue.equals(Object)", "int ParsedValue.hashCode()"})
  void testParsedValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ParsedValue parsedValue = new ParsedValue("Value", DataType.BOOLEAN);
    ParsedValue parsedValue2 = new ParsedValue("Value", DataType.BOOLEAN);

    // Act and Assert
    assertEquals(parsedValue, parsedValue2);
    int expectedHashCodeResult = parsedValue.hashCode();
    assertEquals(expectedHashCodeResult, parsedValue2.hashCode());
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}, and {@link ParsedValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParsedValue#equals(Object)}
   *   <li>{@link ParsedValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParsedValue.equals(Object)", "int ParsedValue.hashCode()"})
  void testParsedValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ParsedValue parsedValue = new ParsedValue(null, DataType.BOOLEAN);
    ParsedValue parsedValue2 = new ParsedValue(null, DataType.BOOLEAN);

    // Act and Assert
    assertEquals(parsedValue, parsedValue2);
    int expectedHashCodeResult = parsedValue.hashCode();
    assertEquals(expectedHashCodeResult, parsedValue2.hashCode());
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}, and {@link ParsedValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParsedValue#equals(Object)}
   *   <li>{@link ParsedValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParsedValue.equals(Object)", "int ParsedValue.hashCode()"})
  void testParsedValueEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ParsedValue parsedValue = new ParsedValue("Value", null);
    ParsedValue parsedValue2 = new ParsedValue("Value", null);

    // Act and Assert
    assertEquals(parsedValue, parsedValue2);
    int expectedHashCodeResult = parsedValue.hashCode();
    assertEquals(expectedHashCodeResult, parsedValue2.hashCode());
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}, and {@link ParsedValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParsedValue#equals(Object)}
   *   <li>{@link ParsedValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParsedValue.equals(Object)", "int ParsedValue.hashCode()"})
  void testParsedValueEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ParsedValue parsedValue = new ParsedValue("Value", DataType.BOOLEAN);

    // Act and Assert
    assertEquals(parsedValue, parsedValue);
    int expectedHashCodeResult = parsedValue.hashCode();
    assertEquals(expectedHashCodeResult, parsedValue.hashCode());
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParsedValue.equals(Object)", "int ParsedValue.hashCode()"})
  void testParsedValueEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ParsedValue parsedValue = new ParsedValue(42, DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(parsedValue, new ParsedValue("Value", DataType.BOOLEAN));
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParsedValue.equals(Object)", "int ParsedValue.hashCode()"})
  void testParsedValueEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ParsedValue parsedValue = new ParsedValue(new ParsedValue("Value", DataType.BOOLEAN), DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(parsedValue, new ParsedValue("Value", DataType.BOOLEAN));
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParsedValue.equals(Object)", "int ParsedValue.hashCode()"})
  void testParsedValueEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ParsedValue parsedValue = new ParsedValue(null, DataType.BOOLEAN);

    // Act and Assert
    assertNotEquals(parsedValue, new ParsedValue("Value", DataType.BOOLEAN));
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParsedValue.equals(Object)", "int ParsedValue.hashCode()"})
  void testParsedValueEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ParsedValue parsedValue = new ParsedValue("Value", null);

    // Act and Assert
    assertNotEquals(parsedValue, new ParsedValue("Value", DataType.BOOLEAN));
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParsedValue.equals(Object)", "int ParsedValue.hashCode()"})
  void testParsedValueEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ParsedValue parsedValue = new ParsedValue("Value", DataType.LONG);

    // Act and Assert
    assertNotEquals(parsedValue, new ParsedValue("Value", DataType.BOOLEAN));
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParsedValue.equals(Object)", "int ParsedValue.hashCode()"})
  void testParsedValueEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParsedValue("Value", DataType.BOOLEAN), null);
  }

  /**
   * Test ParsedValue {@link ParsedValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParsedValue#equals(Object)}
   */
  @Test
  @DisplayName("Test ParsedValue equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ParsedValue.equals(Object)", "int ParsedValue.hashCode()"})
  void testParsedValueEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ParsedValue("Value", DataType.BOOLEAN), "Different type to ParsedValue");
  }

  /**
   * Test ParsedValue getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ParsedValue#ParsedValue(Object, DataType)}
   *   <li>{@link ParsedValue#toString()}
   *   <li>{@link ParsedValue#getDataType()}
   *   <li>{@link ParsedValue#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test ParsedValue getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ParsedValue.<init>(Object, DataType)", "DataType ParsedValue.getDataType()",
      "Object ParsedValue.getValue()", "String ParsedValue.toString()"})
  void testParsedValueGettersAndSetters() {
    // Arrange and Act
    ParsedValue actualParsedValue = new ParsedValue("Value", DataType.BOOLEAN);
    String actualToStringResult = actualParsedValue.toString();
    DataType actualDataType = actualParsedValue.getDataType();

    // Assert
    assertEquals("AbstractBulkImportService.ParsedValue(value=Value, dataType=BOOLEAN)", actualToStringResult);
    assertEquals("Value", actualParsedValue.getValue());
    assertEquals(DataType.BOOLEAN, actualDataType);
  }

  /**
   * Test ParsedValue {@link ParsedValue#stringValue()}.
   * <p>
   * Method under test: {@link ParsedValue#stringValue()}
   */
  @Test
  @DisplayName("Test ParsedValue stringValue()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ParsedValue.stringValue()"})
  void testParsedValueStringValue() {
    // Arrange, Act and Assert
    assertEquals("dataType", parsedValue.stringValue());
  }

  /**
   * Test ParsedValue {@link ParsedValue#toJsonPrimitive()}.
   * <ul>
   *   <li>Given {@link DataType} {@link Enum#ordinal()} return four.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParsedValue#toJsonPrimitive()}
   */
  @Test
  @DisplayName("Test ParsedValue toJsonPrimitive(); given DataType ordinal() return four; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonPrimitive ParsedValue.toJsonPrimitive()"})
  void testParsedValueToJsonPrimitive_givenDataTypeOrdinalReturnFour_thenReturnNull() {
    // Arrange
    when(dataType.ordinal()).thenReturn(4);

    // Act
    JsonPrimitive actualToJsonPrimitiveResult = parsedValue.toJsonPrimitive();

    // Assert
    verify(dataType).ordinal();
    assertNull(actualToJsonPrimitiveResult);
  }

  /**
   * Test ParsedValue {@link ParsedValue#toJsonPrimitive()}.
   * <ul>
   *   <li>Then AsNumber return {@link LazilyParsedNumber}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParsedValue#toJsonPrimitive()}
   */
  @Test
  @DisplayName("Test ParsedValue toJsonPrimitive(); then AsNumber return LazilyParsedNumber")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonPrimitive ParsedValue.toJsonPrimitive()"})
  void testParsedValueToJsonPrimitive_thenAsNumberReturnLazilyParsedNumber() {
    // Arrange and Act
    JsonPrimitive actualToJsonPrimitiveResult = (new ParsedValue("42", DataType.STRING)).toJsonPrimitive();

    // Assert
    Number asNumber = actualToJsonPrimitiveResult.getAsNumber();
    assertTrue(asNumber instanceof LazilyParsedNumber);
    assertEquals("42", asNumber.toString());
    assertTrue(actualToJsonPrimitiveResult.isString());
    assertSame(actualToJsonPrimitiveResult, actualToJsonPrimitiveResult.getAsJsonPrimitive());
    assertArrayEquals(new byte[]{'*'}, actualToJsonPrimitiveResult.getAsBigInteger().toByteArray());
  }

  /**
   * Test ParsedValue {@link ParsedValue#toJsonPrimitive()}.
   * <ul>
   *   <li>Then return AsCharacter is {@code t}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParsedValue#toJsonPrimitive()}
   */
  @Test
  @DisplayName("Test ParsedValue toJsonPrimitive(); then return AsCharacter is 't'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonPrimitive ParsedValue.toJsonPrimitive()"})
  void testParsedValueToJsonPrimitive_thenReturnAsCharacterIsT() {
    // Arrange and Act
    JsonPrimitive actualToJsonPrimitiveResult = (new ParsedValue(true, DataType.BOOLEAN)).toJsonPrimitive();

    // Assert
    assertEquals('t', actualToJsonPrimitiveResult.getAsCharacter());
    assertTrue(actualToJsonPrimitiveResult.getAsBoolean());
    assertTrue(actualToJsonPrimitiveResult.isBoolean());
    String expectedAsString = Boolean.TRUE.toString();
    assertEquals(expectedAsString, actualToJsonPrimitiveResult.getAsString());
    assertSame(actualToJsonPrimitiveResult, actualToJsonPrimitiveResult.getAsJsonPrimitive());
  }

  /**
   * Test ParsedValue {@link ParsedValue#toJsonPrimitive()}.
   * <ul>
   *   <li>Then return AsNumber longValue is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParsedValue#toJsonPrimitive()}
   */
  @Test
  @DisplayName("Test ParsedValue toJsonPrimitive(); then return AsNumber longValue is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonPrimitive ParsedValue.toJsonPrimitive()"})
  void testParsedValueToJsonPrimitive_thenReturnAsNumberLongValueIsFortyTwo() {
    // Arrange and Act
    JsonPrimitive actualToJsonPrimitiveResult = (new ParsedValue(42L, DataType.LONG)).toJsonPrimitive();

    // Assert
    assertEquals(42L, actualToJsonPrimitiveResult.getAsNumber().longValue());
    assertSame(actualToJsonPrimitiveResult, actualToJsonPrimitiveResult.getAsJsonPrimitive());
    assertArrayEquals(new byte[]{'*'}, actualToJsonPrimitiveResult.getAsBigInteger().toByteArray());
  }

  /**
   * Test ParsedValue {@link ParsedValue#toJsonPrimitive()}.
   * <ul>
   *   <li>Then return AsString is {@code 10.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ParsedValue#toJsonPrimitive()}
   */
  @Test
  @DisplayName("Test ParsedValue toJsonPrimitive(); then return AsString is '10.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"JsonPrimitive ParsedValue.toJsonPrimitive()"})
  void testParsedValueToJsonPrimitive_thenReturnAsStringIs100() {
    // Arrange and Act
    JsonPrimitive actualToJsonPrimitiveResult = (new ParsedValue(10.0d, DataType.DOUBLE)).toJsonPrimitive();

    // Assert
    assertEquals("10.0", actualToJsonPrimitiveResult.getAsString());
    assertEquals('1', actualToJsonPrimitiveResult.getAsCharacter());
    assertEquals(10, actualToJsonPrimitiveResult.getAsInt());
    assertEquals(10.0d, actualToJsonPrimitiveResult.getAsDouble());
    assertEquals(10.0d, actualToJsonPrimitiveResult.getAsNumber().doubleValue());
    assertEquals(10.0f, actualToJsonPrimitiveResult.getAsFloat());
    assertEquals(10L, actualToJsonPrimitiveResult.getAsLong());
    assertEquals((short) 10, actualToJsonPrimitiveResult.getAsShort());
    BigDecimal expectedAsBigDecimal = new BigDecimal("10.0");
    assertEquals(expectedAsBigDecimal, actualToJsonPrimitiveResult.getAsBigDecimal());
    assertEquals('\n', actualToJsonPrimitiveResult.getAsByte());
    assertSame(actualToJsonPrimitiveResult, actualToJsonPrimitiveResult.getAsJsonPrimitive());
  }
}
