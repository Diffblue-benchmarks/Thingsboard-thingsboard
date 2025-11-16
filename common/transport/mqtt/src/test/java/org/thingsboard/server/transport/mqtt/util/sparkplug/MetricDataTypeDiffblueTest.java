/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.transport.mqtt.util.sparkplug;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.adaptor.AdaptorException;

class MetricDataTypeDiffblueTest {
  /**
   * Test {@link MetricDataType#checkType(Object)}.
   *
   * <ul>
   *   <li>Given {@code Int8}.
   *   <li>When {@code null}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#checkType(Object)}
   */
  @Test
  @DisplayName("Test checkType(Object); given 'Int8'; when 'null'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetricDataType.checkType(Object)"})
  void testCheckType_givenInt8_whenNull_thenDoesNotThrow() throws AdaptorException {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> MetricDataType.Int8.checkType(null));
  }

  /**
   * Test {@link MetricDataType#checkType(Object)}.
   *
   * <ul>
   *   <li>Given {@code Int8}.
   *   <li>When {@code Value}.
   *   <li>Then throw {@link AdaptorException}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#checkType(Object)}
   */
  @Test
  @DisplayName("Test checkType(Object); given 'Int8'; when 'Value'; then throw AdaptorException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetricDataType.checkType(Object)"})
  void testCheckType_givenInt8_whenValue_thenThrowAdaptorException() throws AdaptorException {
    // Arrange, Act and Assert
    assertThrows(AdaptorException.class, () -> MetricDataType.Int8.checkType("Value"));
  }

  /**
   * Test {@link MetricDataType#checkType(Object)}.
   *
   * <ul>
   *   <li>Given {@code String}.
   *   <li>When {@code Value}.
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#checkType(Object)}
   */
  @Test
  @DisplayName("Test checkType(Object); given 'String'; when 'Value'; then does not throw")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void MetricDataType.checkType(Object)"})
  void testCheckType_givenString_whenValue_thenDoesNotThrow() throws AdaptorException {
    // Arrange, Act and Assert
    assertDoesNotThrow(() -> MetricDataType.String.checkType("Value"));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code UInt64}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when eight; then return 'UInt64'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenEight_thenReturnUInt64() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.UInt64, MetricDataType.fromInteger(8));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When eighteen.
   *   <li>Then return {@code File}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when eighteen; then return 'File'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenEighteen_thenReturnFile() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.File, MetricDataType.fromInteger(18));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When eleven.
   *   <li>Then return {@code Boolean}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when eleven; then return 'Boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenEleven_thenReturnBoolean() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Boolean, MetricDataType.fromInteger(11));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When fifteen.
   *   <li>Then return {@code UUID}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when fifteen; then return 'UUID'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenFifteen_thenReturnUuid() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.UUID, MetricDataType.fromInteger(15));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return {@code UInt8}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when five; then return 'UInt8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenFive_thenReturnUInt8() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.UInt8, MetricDataType.fromInteger(5));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code Int64}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when four; then return 'Int64'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenFour_thenReturnInt64() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Int64, MetricDataType.fromInteger(4));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When fourteen.
   *   <li>Then return {@code Text}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when fourteen; then return 'Text'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenFourteen_thenReturnText() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Text, MetricDataType.fromInteger(14));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When nine.
   *   <li>Then return {@code Float}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when nine; then return 'Float'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenNine_thenReturnFloat() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Float, MetricDataType.fromInteger(9));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When nineteen.
   *   <li>Then return {@code Template}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when nineteen; then return 'Template'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenNineteen_thenReturnTemplate() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Template, MetricDataType.fromInteger(19));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code Int8}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when one; then return 'Int8'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenOne_thenReturnInt8() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Int8, MetricDataType.fromInteger(1));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When seven.
   *   <li>Then return {@code UInt32}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when seven; then return 'UInt32'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenSeven_thenReturnUInt32() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.UInt32, MetricDataType.fromInteger(7));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When seventeen.
   *   <li>Then return {@code Bytes}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when seventeen; then return 'Bytes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenSeventeen_thenReturnBytes() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Bytes, MetricDataType.fromInteger(17));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@code UInt16}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when six; then return 'UInt16'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenSix_thenReturnUInt16() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.UInt16, MetricDataType.fromInteger(6));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return {@code DataSet}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when SIZE; then return 'DataSet'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenSize_thenReturnDataSet() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.DataSet, MetricDataType.fromInteger(Short.SIZE));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code Double}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when ten; then return 'Double'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenTen_thenReturnDouble() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Double, MetricDataType.fromInteger(10));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When thirteen.
   *   <li>Then return {@code DateTime}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when thirteen; then return 'DateTime'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenThirteen_thenReturnDateTime() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.DateTime, MetricDataType.fromInteger(13));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code Int32}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when three; then return 'Int32'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenThree_thenReturnInt32() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Int32, MetricDataType.fromInteger(3));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When twelve.
   *   <li>Then return {@code String}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when twelve; then return 'String'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenTwelve_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.String, MetricDataType.fromInteger(12));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code Int16}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when two; then return 'Int16'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenTwo_thenReturnInt16() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Int16, MetricDataType.fromInteger(2));
  }

  /**
   * Test {@link MetricDataType#fromInteger(int)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return {@code Unknown}.
   * </ul>
   *
   * <p>Method under test: {@link MetricDataType#fromInteger(int)}
   */
  @Test
  @DisplayName("Test fromInteger(int); when zero; then return 'Unknown'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"MetricDataType MetricDataType.fromInteger(int)"})
  void testFromInteger_whenZero_thenReturnUnknown() {
    // Arrange, Act and Assert
    assertEquals(MetricDataType.Unknown, MetricDataType.fromInteger(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link MetricDataType#getClazz()}
   *   <li>{@link MetricDataType#toIntValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Class MetricDataType.getClazz()", "int MetricDataType.toIntValue()"})
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
