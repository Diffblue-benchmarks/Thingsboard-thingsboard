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
package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class CustomerUsersFilterDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerUsersFilter#equals(Object)}
   *   <li>{@link CustomerUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(EntityId.NULL_UUID);

    CustomerUsersFilter customerUsersFilter2 = new CustomerUsersFilter();
    customerUsersFilter2.setCustomerId(EntityId.NULL_UUID);

    // Act and Assert
    assertEquals(customerUsersFilter, customerUsersFilter2);
    int expectedHashCodeResult = customerUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, customerUsersFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerUsersFilter#equals(Object)}
   *   <li>{@link CustomerUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(null);

    CustomerUsersFilter customerUsersFilter2 = new CustomerUsersFilter();
    customerUsersFilter2.setCustomerId(null);

    // Act and Assert
    assertEquals(customerUsersFilter, customerUsersFilter2);
    int expectedHashCodeResult = customerUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, customerUsersFilter2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerUsersFilter#equals(Object)}
   *   <li>{@link CustomerUsersFilter#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(EntityId.NULL_UUID);

    // Act and Assert
    assertEquals(customerUsersFilter, customerUsersFilter);
    int expectedHashCodeResult = customerUsersFilter.hashCode();
    assertEquals(expectedHashCodeResult, customerUsersFilter.hashCode());
  }

  /**
   * Method under test: {@link CustomerUsersFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(UUID.randomUUID());

    CustomerUsersFilter customerUsersFilter2 = new CustomerUsersFilter();
    customerUsersFilter2.setCustomerId(EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(customerUsersFilter, customerUsersFilter2);
  }

  /**
   * Method under test: {@link CustomerUsersFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(null);

    CustomerUsersFilter customerUsersFilter2 = new CustomerUsersFilter();
    customerUsersFilter2.setCustomerId(EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(customerUsersFilter, customerUsersFilter2);
  }

  /**
   * Method under test: {@link CustomerUsersFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(customerUsersFilter, null);
  }

  /**
   * Method under test: {@link CustomerUsersFilter#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomerUsersFilter customerUsersFilter = new CustomerUsersFilter();
    customerUsersFilter.setCustomerId(EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(customerUsersFilter, "Different type to CustomerUsersFilter");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomerUsersFilter}
   *   <li>{@link CustomerUsersFilter#setCustomerId(UUID)}
   *   <li>{@link CustomerUsersFilter#toString()}
   *   <li>{@link CustomerUsersFilter#getCustomerId()}
   *   <li>{@link CustomerUsersFilter#getType()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    CustomerUsersFilter actualCustomerUsersFilter = new CustomerUsersFilter();
    UUID customerId = EntityId.NULL_UUID;
    actualCustomerUsersFilter.setCustomerId(customerId);
    String actualToStringResult = actualCustomerUsersFilter.toString();
    UUID actualCustomerId = actualCustomerUsersFilter.getCustomerId();
    UsersFilterType actualType = actualCustomerUsersFilter.getType();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualCustomerId.toString());
    assertEquals("CustomerUsersFilter(customerId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals(UsersFilterType.CUSTOMER_USERS, actualType);
    assertSame(customerId, actualCustomerId);
  }
}
