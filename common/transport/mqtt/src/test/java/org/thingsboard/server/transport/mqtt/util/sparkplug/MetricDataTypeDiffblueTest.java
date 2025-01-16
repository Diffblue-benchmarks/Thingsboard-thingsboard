package org.thingsboard.server.transport.mqtt.util.sparkplug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.adaptor.AdaptorException;

class MetricDataTypeDiffblueTest {
  /**
   * Test {@link MetricDataType#checkType(Object)}.
   * <ul>
   *   <li>Given {@code Int8}.</li>
   *   <li>When {@code Value}.</li>
   *   <li>Then throw {@link AdaptorException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#checkType(Object)}
   */
  @Test
  @DisplayName("Test checkType(Object); given 'Int8'; when 'Value'; then throw AdaptorException")
  void testCheckType_givenInt8_whenValue_thenThrowAdaptorException() throws AdaptorException {
    // Arrange, Act and Assert
    assertThrows(AdaptorException.class, () -> MetricDataType.Int8.checkType("Value"));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When eight.</li>
   *   <li>Then return {@code UInt64}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when eight; then return 'UInt64'")
  void testFromInteger_whenEight_thenReturnUInt64() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.UInt64, MetricDataType.fromInteger(8));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When eighteen.</li>
   *   <li>Then return {@code File}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when eighteen; then return 'File'")
  void testFromInteger_whenEighteen_thenReturnFile() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.File, MetricDataType.fromInteger(18));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When eleven.</li>
   *   <li>Then return {@code Boolean}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when eleven; then return 'Boolean'")
  void testFromInteger_whenEleven_thenReturnBoolean() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Boolean, MetricDataType.fromInteger(11));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When fifteen.</li>
   *   <li>Then return {@code UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when fifteen; then return 'UUID'")
  void testFromInteger_whenFifteen_thenReturnUuid() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.UUID, MetricDataType.fromInteger(15));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When five.</li>
   *   <li>Then return {@code UInt8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when five; then return 'UInt8'")
  void testFromInteger_whenFive_thenReturnUInt8() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.UInt8, MetricDataType.fromInteger(5));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When four.</li>
   *   <li>Then return {@code Int64}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when four; then return 'Int64'")
  void testFromInteger_whenFour_thenReturnInt64() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Int64, MetricDataType.fromInteger(4));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When fourteen.</li>
   *   <li>Then return {@code Text}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when fourteen; then return 'Text'")
  void testFromInteger_whenFourteen_thenReturnText() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Text, MetricDataType.fromInteger(14));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When nine.</li>
   *   <li>Then return {@code Float}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when nine; then return 'Float'")
  void testFromInteger_whenNine_thenReturnFloat() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Float, MetricDataType.fromInteger(9));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When nineteen.</li>
   *   <li>Then return {@code Template}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when nineteen; then return 'Template'")
  void testFromInteger_whenNineteen_thenReturnTemplate() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Template, MetricDataType.fromInteger(19));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code Int8}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when one; then return 'Int8'")
  void testFromInteger_whenOne_thenReturnInt8() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Int8, MetricDataType.fromInteger(1));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When seven.</li>
   *   <li>Then return {@code UInt32}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when seven; then return 'UInt32'")
  void testFromInteger_whenSeven_thenReturnUInt32() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.UInt32, MetricDataType.fromInteger(7));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When seventeen.</li>
   *   <li>Then return {@code Bytes}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when seventeen; then return 'Bytes'")
  void testFromInteger_whenSeventeen_thenReturnBytes() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Bytes, MetricDataType.fromInteger(17));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When six.</li>
   *   <li>Then return {@code UInt16}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when six; then return 'UInt16'")
  void testFromInteger_whenSix_thenReturnUInt16() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.UInt16, MetricDataType.fromInteger(6));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When {@link Short#SIZE}.</li>
   *   <li>Then return {@code DataSet}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when SIZE; then return 'DataSet'")
  void testFromInteger_whenSize_thenReturnDataSet() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.DataSet, MetricDataType.fromInteger(Short.SIZE));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When ten.</li>
   *   <li>Then return {@code Double}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when ten; then return 'Double'")
  void testFromInteger_whenTen_thenReturnDouble() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Double, MetricDataType.fromInteger(10));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When thirteen.</li>
   *   <li>Then return {@code DateTime}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when thirteen; then return 'DateTime'")
  void testFromInteger_whenThirteen_thenReturnDateTime() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.DateTime, MetricDataType.fromInteger(13));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return {@code Int32}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when three; then return 'Int32'")
  void testFromInteger_whenThree_thenReturnInt32() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Int32, MetricDataType.fromInteger(3));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When twelve.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when twelve; then return 'String'")
  void testFromInteger_whenTwelve_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.String, MetricDataType.fromInteger(12));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When two.</li>
   *   <li>Then return {@code Int16}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when two; then return 'Int16'")
  void testFromInteger_whenTwo_thenReturnInt16() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Int16, MetricDataType.fromInteger(2));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code Unknown}.</li>
   * </ul>
   * <p>
   * Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when zero; then return 'Unknown'")
  void testFromInteger_whenZero_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Unknown, MetricDataType.fromInteger(0));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MetricDataType#getClazz()}
   *   <li>{@link MetricDataType#toIntValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    MetricDataType valueOfResult = MetricDataType.valueOf("Int8");

    // Act
    Class<?> actualClazz = valueOfResult.getClazz();

    // Assert
    assertEquals(1, valueOfResult.toIntValue());
    Class<Byte> expectedClazz = Byte.class;
    assertEquals(expectedClazz, actualClazz);
  }
}
