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
package org.thingsboard.rule.engine.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.DataType;

class EntityKeyValueDiffblueTest {
  /**
   * Test {@link EntityKeyValue#getLngValue()}.
   *
   * <p>Method under test: {@link EntityKeyValue#getLngValue()}
   */
  @Test
  @DisplayName("Test getLngValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long EntityKeyValue.getLngValue()"})
  void testGetLngValue() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act and Assert
    assertNull(fromBoolResult.getLngValue());
  }

  /**
   * Test {@link EntityKeyValue#setLngValue(Long)}.
   *
   * <p>Method under test: {@link EntityKeyValue#setLngValue(Long)}
   */
  @Test
  @DisplayName("Test setLngValue(Long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityKeyValue.setLngValue(Long)"})
  void testSetLngValue() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act
    fromBoolResult.setLngValue(42L);

    // Assert
    assertNull(fromBoolResult.getBoolValue());
    assertEquals(42L, fromBoolResult.getLngValue().longValue());
    assertEquals(DataType.LONG, fromBoolResult.getDataType());
  }

  /**
   * Test {@link EntityKeyValue#getDblValue()}.
   *
   * <ul>
   *   <li>Given fromBool {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#getDblValue()}
   */
  @Test
  @DisplayName("Test getDblValue(); given fromBool 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double EntityKeyValue.getDblValue()"})
  void testGetDblValue_givenFromBoolTrue_thenReturnNull() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act and Assert
    assertNull(fromBoolResult.getDblValue());
  }

  /**
   * Test {@link EntityKeyValue#getDblValue()}.
   *
   * <ul>
   *   <li>Given fromDouble ten.
   *   <li>Then return doubleValue is ten.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#getDblValue()}
   */
  @Test
  @DisplayName("Test getDblValue(); given fromDouble ten; then return doubleValue is ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double EntityKeyValue.getDblValue()"})
  void testGetDblValue_givenFromDoubleTen_thenReturnDoubleValueIsTen() {
    // Arrange
    EntityKeyValue fromDoubleResult = EntityKeyValue.fromDouble(10.0d);

    // Act and Assert
    assertEquals(10.0d, fromDoubleResult.getDblValue().doubleValue());
  }

  /**
   * Test {@link EntityKeyValue#setDblValue(Double)}.
   *
   * <p>Method under test: {@link EntityKeyValue#setDblValue(Double)}
   */
  @Test
  @DisplayName("Test setDblValue(Double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityKeyValue.setDblValue(Double)"})
  void testSetDblValue() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act
    fromBoolResult.setDblValue(10.0d);

    // Assert
    assertNull(fromBoolResult.getBoolValue());
    assertEquals(10.0d, fromBoolResult.getDblValue().doubleValue());
    assertEquals(DataType.DOUBLE, fromBoolResult.getDataType());
  }

  /**
   * Test {@link EntityKeyValue#getBoolValue()}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyValue} (default constructor).
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#getBoolValue()}
   */
  @Test
  @DisplayName(
      "Test getBoolValue(); given EntityKeyValue (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean EntityKeyValue.getBoolValue()"})
  void testGetBoolValue_givenEntityKeyValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new EntityKeyValue().getBoolValue());
  }

  /**
   * Test {@link EntityKeyValue#getBoolValue()}.
   *
   * <ul>
   *   <li>Given fromBool {@code false}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#getBoolValue()}
   */
  @Test
  @DisplayName("Test getBoolValue(); given fromBool 'false'; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean EntityKeyValue.getBoolValue()"})
  void testGetBoolValue_givenFromBoolFalse_thenReturnFalse() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(false);

    // Act and Assert
    assertFalse(fromBoolResult.getBoolValue());
  }

  /**
   * Test {@link EntityKeyValue#getBoolValue()}.
   *
   * <ul>
   *   <li>Given fromBool {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#getBoolValue()}
   */
  @Test
  @DisplayName("Test getBoolValue(); given fromBool 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Boolean EntityKeyValue.getBoolValue()"})
  void testGetBoolValue_givenFromBoolTrue_thenReturnTrue() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act and Assert
    assertTrue(fromBoolResult.getBoolValue());
  }

  /**
   * Test {@link EntityKeyValue#getStrValue()}.
   *
   * <p>Method under test: {@link EntityKeyValue#getStrValue()}
   */
  @Test
  @DisplayName("Test getStrValue()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyValue.getStrValue()"})
  void testGetStrValue() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act and Assert
    assertNull(fromBoolResult.getStrValue());
  }

  /**
   * Test {@link EntityKeyValue#setStrValue(String)}.
   *
   * <p>Method under test: {@link EntityKeyValue#setStrValue(String)}
   */
  @Test
  @DisplayName("Test setStrValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityKeyValue.setStrValue(String)"})
  void testSetStrValue() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act
    fromBoolResult.setStrValue("42");

    // Assert
    assertEquals("42", fromBoolResult.getStrValue());
    assertNull(fromBoolResult.getBoolValue());
    assertEquals(DataType.STRING, fromBoolResult.getDataType());
  }

  /**
   * Test {@link EntityKeyValue#setJsonValue(String)}.
   *
   * <p>Method under test: {@link EntityKeyValue#setJsonValue(String)}
   */
  @Test
  @DisplayName("Test setJsonValue(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityKeyValue.setJsonValue(String)"})
  void testSetJsonValue() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act
    fromBoolResult.setJsonValue("42");

    // Assert
    assertEquals("42", fromBoolResult.getJsonValue());
    assertNull(fromBoolResult.getBoolValue());
    assertEquals(DataType.JSON, fromBoolResult.getDataType());
  }

  /**
   * Test {@link EntityKeyValue#getJsonValue()}.
   *
   * <ul>
   *   <li>Given fromBool {@code true}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#getJsonValue()}
   */
  @Test
  @DisplayName("Test getJsonValue(); given fromBool 'true'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyValue.getJsonValue()"})
  void testGetJsonValue_givenFromBoolTrue_thenReturnNull() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act and Assert
    assertNull(fromBoolResult.getJsonValue());
  }

  /**
   * Test {@link EntityKeyValue#getJsonValue()}.
   *
   * <ul>
   *   <li>Given fromJson {@code foo}.
   *   <li>Then return {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#getJsonValue()}
   */
  @Test
  @DisplayName("Test getJsonValue(); given fromJson 'foo'; then return 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EntityKeyValue.getJsonValue()"})
  void testGetJsonValue_givenFromJsonFoo_thenReturnFoo() {
    // Arrange, Act and Assert
    assertEquals("foo", EntityKeyValue.fromJson("foo").getJsonValue());
  }

  /**
   * Test {@link EntityKeyValue#isSet()}.
   *
   * <ul>
   *   <li>Given {@link EntityKeyValue} (default constructor).
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#isSet()}
   */
  @Test
  @DisplayName("Test isSet(); given EntityKeyValue (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.isSet()"})
  void testIsSet_givenEntityKeyValue_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new EntityKeyValue().isSet());
  }

  /**
   * Test {@link EntityKeyValue#isSet()}.
   *
   * <ul>
   *   <li>Given fromBool {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#isSet()}
   */
  @Test
  @DisplayName("Test isSet(); given fromBool 'true'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.isSet()"})
  void testIsSet_givenFromBoolTrue_thenReturnTrue() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act and Assert
    assertTrue(fromBoolResult.isSet());
  }

  /**
   * Test {@link EntityKeyValue#fromString(String)}.
   *
   * <p>Method under test: {@link EntityKeyValue#fromString(String)}
   */
  @Test
  @DisplayName("Test fromString(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKeyValue EntityKeyValue.fromString(String)"})
  void testFromString() {
    // Arrange and Act
    EntityKeyValue actualFromStringResult = EntityKeyValue.fromString("foo");

    // Assert
    assertEquals("foo", actualFromStringResult.getStrValue());
    assertNull(actualFromStringResult.getBoolValue());
    assertNull(actualFromStringResult.getDblValue());
    assertNull(actualFromStringResult.getLngValue());
    assertNull(actualFromStringResult.getJsonValue());
    assertEquals(DataType.STRING, actualFromStringResult.getDataType());
    assertTrue(actualFromStringResult.isSet());
  }

  /**
   * Test {@link EntityKeyValue#fromBool(boolean)}.
   *
   * <p>Method under test: {@link EntityKeyValue#fromBool(boolean)}
   */
  @Test
  @DisplayName("Test fromBool(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKeyValue EntityKeyValue.fromBool(boolean)"})
  void testFromBool() {
    // Arrange and Act
    EntityKeyValue actualFromBoolResult = EntityKeyValue.fromBool(true);

    // Assert
    assertNull(actualFromBoolResult.getDblValue());
    assertNull(actualFromBoolResult.getLngValue());
    assertNull(actualFromBoolResult.getJsonValue());
    assertNull(actualFromBoolResult.getStrValue());
    assertEquals(DataType.BOOLEAN, actualFromBoolResult.getDataType());
    assertTrue(actualFromBoolResult.getBoolValue());
    assertTrue(actualFromBoolResult.isSet());
  }

  /**
   * Test {@link EntityKeyValue#fromLong(long)}.
   *
   * <p>Method under test: {@link EntityKeyValue#fromLong(long)}
   */
  @Test
  @DisplayName("Test fromLong(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKeyValue EntityKeyValue.fromLong(long)"})
  void testFromLong() {
    // Arrange and Act
    EntityKeyValue actualFromLongResult = EntityKeyValue.fromLong(1L);

    // Assert
    assertNull(actualFromLongResult.getBoolValue());
    assertNull(actualFromLongResult.getDblValue());
    assertNull(actualFromLongResult.getJsonValue());
    assertNull(actualFromLongResult.getStrValue());
    assertEquals(1L, actualFromLongResult.getLngValue().longValue());
    assertEquals(DataType.LONG, actualFromLongResult.getDataType());
    assertTrue(actualFromLongResult.isSet());
  }

  /**
   * Test {@link EntityKeyValue#fromDouble(double)}.
   *
   * <p>Method under test: {@link EntityKeyValue#fromDouble(double)}
   */
  @Test
  @DisplayName("Test fromDouble(double)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKeyValue EntityKeyValue.fromDouble(double)"})
  void testFromDouble() {
    // Arrange and Act
    EntityKeyValue actualFromDoubleResult = EntityKeyValue.fromDouble(10.0d);

    // Assert
    assertNull(actualFromDoubleResult.getBoolValue());
    assertNull(actualFromDoubleResult.getLngValue());
    assertNull(actualFromDoubleResult.getJsonValue());
    assertNull(actualFromDoubleResult.getStrValue());
    assertEquals(10.0d, actualFromDoubleResult.getDblValue().doubleValue());
    assertEquals(DataType.DOUBLE, actualFromDoubleResult.getDataType());
    assertTrue(actualFromDoubleResult.isSet());
  }

  /**
   * Test {@link EntityKeyValue#fromJson(String)}.
   *
   * <p>Method under test: {@link EntityKeyValue#fromJson(String)}
   */
  @Test
  @DisplayName("Test fromJson(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKeyValue EntityKeyValue.fromJson(String)"})
  void testFromJson() {
    // Arrange and Act
    EntityKeyValue actualFromJsonResult = EntityKeyValue.fromJson("foo");

    // Assert
    assertEquals("foo", actualFromJsonResult.getJsonValue());
    assertNull(actualFromJsonResult.getBoolValue());
    assertNull(actualFromJsonResult.getDblValue());
    assertNull(actualFromJsonResult.getLngValue());
    assertNull(actualFromJsonResult.getStrValue());
    assertEquals(DataType.JSON, actualFromJsonResult.getDataType());
    assertTrue(actualFromJsonResult.isSet());
  }

  /**
   * Test {@link EntityKeyValue#equals(Object)}, and {@link EntityKeyValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityKeyValue#equals(Object)}
   *   <li>{@link EntityKeyValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.equals(Object)", "int EntityKeyValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);
    EntityKeyValue fromBoolResult2 = EntityKeyValue.fromBool(true);

    // Act and Assert
    assertEquals(fromBoolResult, fromBoolResult2);
    assertEquals(fromBoolResult.hashCode(), fromBoolResult2.hashCode());
  }

  /**
   * Test {@link EntityKeyValue#equals(Object)}, and {@link EntityKeyValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityKeyValue#equals(Object)}
   *   <li>{@link EntityKeyValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.equals(Object)", "int EntityKeyValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityKeyValue entityKeyValue = new EntityKeyValue();
    EntityKeyValue entityKeyValue2 = new EntityKeyValue();

    // Act and Assert
    assertEquals(entityKeyValue, entityKeyValue2);
    assertEquals(entityKeyValue.hashCode(), entityKeyValue2.hashCode());
  }

  /**
   * Test {@link EntityKeyValue#equals(Object)}, and {@link EntityKeyValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityKeyValue#equals(Object)}
   *   <li>{@link EntityKeyValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.equals(Object)", "int EntityKeyValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityKeyValue fromDoubleResult = EntityKeyValue.fromDouble(10.0d);
    EntityKeyValue fromDoubleResult2 = EntityKeyValue.fromDouble(10.0d);

    // Act and Assert
    assertEquals(fromDoubleResult, fromDoubleResult2);
    assertEquals(fromDoubleResult.hashCode(), fromDoubleResult2.hashCode());
  }

  /**
   * Test {@link EntityKeyValue#equals(Object)}, and {@link EntityKeyValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityKeyValue#equals(Object)}
   *   <li>{@link EntityKeyValue#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.equals(Object)", "int EntityKeyValue.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act and Assert
    assertEquals(fromBoolResult, fromBoolResult);
    int expectedHashCodeResult = fromBoolResult.hashCode();
    assertEquals(expectedHashCodeResult, fromBoolResult.hashCode());
  }

  /**
   * Test {@link EntityKeyValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.equals(Object)", "int EntityKeyValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityKeyValue entityKeyValue = new EntityKeyValue();

    // Act and Assert
    assertNotEquals(entityKeyValue, EntityKeyValue.fromBool(true));
  }

  /**
   * Test {@link EntityKeyValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.equals(Object)", "int EntityKeyValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityKeyValue fromDoubleResult = EntityKeyValue.fromDouble(10.0d);

    // Act and Assert
    assertNotEquals(fromDoubleResult, EntityKeyValue.fromBool(true));
  }

  /**
   * Test {@link EntityKeyValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.equals(Object)", "int EntityKeyValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act and Assert
    assertNotEquals(fromBoolResult, new EntityKeyValue());
  }

  /**
   * Test {@link EntityKeyValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.equals(Object)", "int EntityKeyValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act and Assert
    assertNotEquals(fromBoolResult, EntityKeyValue.fromDouble(10.0d));
  }

  /**
   * Test {@link EntityKeyValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.equals(Object)", "int EntityKeyValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityKeyValue entityKeyValue = new EntityKeyValue();

    // Act and Assert
    assertNotEquals(entityKeyValue, EntityKeyValue.fromJson("foo"));
  }

  /**
   * Test {@link EntityKeyValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.equals(Object)", "int EntityKeyValue.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityKeyValue fromJsonResult = EntityKeyValue.fromJson("foo");

    // Act and Assert
    assertNotEquals(fromJsonResult, new EntityKeyValue());
  }

  /**
   * Test {@link EntityKeyValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.equals(Object)", "int EntityKeyValue.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act and Assert
    assertNotEquals(fromBoolResult, null);
  }

  /**
   * Test {@link EntityKeyValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityKeyValue#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EntityKeyValue.equals(Object)", "int EntityKeyValue.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityKeyValue fromBoolResult = EntityKeyValue.fromBool(true);

    // Act and Assert
    assertNotEquals(fromBoolResult, "Different type to EntityKeyValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link EntityKeyValue}
   *   <li>{@link EntityKeyValue#getDataType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EntityKeyValue.<init>()", "DataType EntityKeyValue.getDataType()"})
  void testGettersAndSetters() {
    // Arrange, Act and Assert
    assertNull(new EntityKeyValue().getDataType());
  }
}
