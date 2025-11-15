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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;

class ShortCustomerInfoDiffblueTest {
  /**
   * Test {@link ShortCustomerInfo#equals(Object)}, and {@link ShortCustomerInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ShortCustomerInfo#equals(Object)}
   *   <li>{@link ShortCustomerInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ShortCustomerInfo.equals(Object)", "int ShortCustomerInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true);
    ShortCustomerInfo shortCustomerInfo2 = new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true);

    // Act and Assert
    assertEquals(shortCustomerInfo, shortCustomerInfo2);
    int expectedHashCodeResult = shortCustomerInfo.hashCode();
    assertEquals(expectedHashCodeResult, shortCustomerInfo2.hashCode());
  }

  /**
   * Test {@link ShortCustomerInfo#equals(Object)}, and {@link ShortCustomerInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ShortCustomerInfo#equals(Object)}
   *   <li>{@link ShortCustomerInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ShortCustomerInfo.equals(Object)", "int ShortCustomerInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true);

    // Act and Assert
    assertEquals(shortCustomerInfo, shortCustomerInfo);
    int expectedHashCodeResult = shortCustomerInfo.hashCode();
    assertEquals(expectedHashCodeResult, shortCustomerInfo.hashCode());
  }

  /**
   * Test {@link ShortCustomerInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ShortCustomerInfo.equals(Object)", "int ShortCustomerInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(new CustomerId(UUID.randomUUID()), "Dr", true);

    // Act and Assert
    assertNotEquals(shortCustomerInfo, new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true));
  }

  /**
   * Test {@link ShortCustomerInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ShortCustomerInfo.equals(Object)", "int ShortCustomerInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true), null);
  }

  /**
   * Test {@link ShortCustomerInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ShortCustomerInfo.equals(Object)", "int ShortCustomerInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true),
        "Different type to ShortCustomerInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ShortCustomerInfo#ShortCustomerInfo(CustomerId, String, boolean)}
   *   <li>{@link ShortCustomerInfo#setCustomerId(CustomerId)}
   *   <li>{@link ShortCustomerInfo#setPublic(boolean)}
   *   <li>{@link ShortCustomerInfo#setTitle(String)}
   *   <li>{@link ShortCustomerInfo#getCustomerId()}
   *   <li>{@link ShortCustomerInfo#getTitle()}
   *   <li>{@link ShortCustomerInfo#isPublic()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ShortCustomerInfo.<init>(CustomerId, String, boolean)",
      "CustomerId ShortCustomerInfo.getCustomerId()", "String ShortCustomerInfo.getTitle()",
      "boolean ShortCustomerInfo.isPublic()", "void ShortCustomerInfo.setCustomerId(CustomerId)",
      "void ShortCustomerInfo.setPublic(boolean)", "void ShortCustomerInfo.setTitle(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    ShortCustomerInfo actualShortCustomerInfo = new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true);
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    actualShortCustomerInfo.setCustomerId(customerId);
    actualShortCustomerInfo.setPublic(true);
    actualShortCustomerInfo.setTitle("Dr");
    CustomerId actualCustomerId = actualShortCustomerInfo.getCustomerId();
    String actualTitle = actualShortCustomerInfo.getTitle();

    // Assert
    assertEquals("Dr", actualTitle);
    assertTrue(actualShortCustomerInfo.isPublic());
    assertSame(customerId, actualCustomerId);
  }
}
