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
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;

class ShortCustomerInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ShortCustomerInfo#equals(Object)}
   *   <li>{@link ShortCustomerInfo#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link ShortCustomerInfo#equals(Object)}
   *   <li>{@link ShortCustomerInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true);

    // Act and Assert
    assertEquals(shortCustomerInfo, shortCustomerInfo);
    int expectedHashCodeResult = shortCustomerInfo.hashCode();
    assertEquals(expectedHashCodeResult, shortCustomerInfo.hashCode());
  }

  /**
   * Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ShortCustomerInfo shortCustomerInfo = new ShortCustomerInfo(new CustomerId(UUID.randomUUID()), "Dr", true);

    // Act and Assert
    assertNotEquals(shortCustomerInfo, new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true));
  }

  /**
   * Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true), mock(AdminSettingsId.class));
  }

  /**
   * Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true), null);
  }

  /**
   * Method under test: {@link ShortCustomerInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true),
        "Different type to ShortCustomerInfo");
  }

  /**
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
  void testGettersAndSetters() {
    // Arrange and Act
    ShortCustomerInfo actualShortCustomerInfo = new ShortCustomerInfo(new CustomerId(EntityId.NULL_UUID), "Dr", true);
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    actualShortCustomerInfo.setCustomerId(customerId);
    actualShortCustomerInfo.setPublic(true);
    actualShortCustomerInfo.setTitle("Dr");
    CustomerId actualCustomerId = actualShortCustomerInfo.getCustomerId();
    String actualTitle = actualShortCustomerInfo.getTitle();

    // Assert that nothing has changed
    assertEquals("Dr", actualTitle);
    assertTrue(actualShortCustomerInfo.isPublic());
    assertSame(customerId, actualCustomerId);
  }
}
