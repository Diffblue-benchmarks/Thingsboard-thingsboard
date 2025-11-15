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
package org.thingsboard.server.dao.device.claim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Customer;
import org.thingsboard.server.common.data.id.CustomerId;

class ReclaimResultDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReclaimResult#equals(Object)}
   *   <li>{@link ReclaimResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ReclaimResult reclaimResult = new ReclaimResult(new Customer());
    ReclaimResult reclaimResult2 = new ReclaimResult(new Customer());

    // Act and Assert
    assertEquals(reclaimResult, reclaimResult2);
    int expectedHashCodeResult = reclaimResult.hashCode();
    assertEquals(expectedHashCodeResult, reclaimResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReclaimResult#equals(Object)}
   *   <li>{@link ReclaimResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ReclaimResult reclaimResult = new ReclaimResult(null);
    ReclaimResult reclaimResult2 = new ReclaimResult(null);

    // Act and Assert
    assertEquals(reclaimResult, reclaimResult2);
    int expectedHashCodeResult = reclaimResult.hashCode();
    assertEquals(expectedHashCodeResult, reclaimResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReclaimResult#equals(Object)}
   *   <li>{@link ReclaimResult#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ReclaimResult reclaimResult = new ReclaimResult(new Customer());

    // Act and Assert
    assertEquals(reclaimResult, reclaimResult);
    int expectedHashCodeResult = reclaimResult.hashCode();
    assertEquals(expectedHashCodeResult, reclaimResult.hashCode());
  }

  /**
   * Method under test: {@link ReclaimResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ReclaimResult reclaimResult = new ReclaimResult(null);

    // Act and Assert
    assertNotEquals(reclaimResult, new ReclaimResult(new Customer()));
  }

  /**
   * Method under test: {@link ReclaimResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ReclaimResult reclaimResult = new ReclaimResult(new Customer(new CustomerId(UUID.randomUUID())));

    // Act and Assert
    assertNotEquals(reclaimResult, new ReclaimResult(new Customer()));
  }

  /**
   * Method under test: {@link ReclaimResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ReclaimResult reclaimResult = new ReclaimResult(mock(Customer.class));

    // Act and Assert
    assertNotEquals(reclaimResult, new ReclaimResult(new Customer()));
  }

  /**
   * Method under test: {@link ReclaimResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReclaimResult(new Customer()), null);
  }

  /**
   * Method under test: {@link ReclaimResult#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ReclaimResult(new Customer()), "Different type to ReclaimResult");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ReclaimResult#ReclaimResult(Customer)}
   *   <li>{@link ReclaimResult#setUnassignedCustomer(Customer)}
   *   <li>{@link ReclaimResult#toString()}
   *   <li>{@link ReclaimResult#getUnassignedCustomer()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ReclaimResult actualReclaimResult = new ReclaimResult(new Customer());
    Customer unassignedCustomer = new Customer();
    actualReclaimResult.setUnassignedCustomer(unassignedCustomer);
    String actualToStringResult = actualReclaimResult.toString();

    // Assert that nothing has changed
    assertEquals(
        "ReclaimResult(unassignedCustomer=Customer [title=null, tenantId=null, additionalInfo=null, country=null,"
            + " state=null, city=null, address=null, address2=null, zip=null, phone=null, email=null, createdTime=0,"
            + " id=null])",
        actualToStringResult);
    assertSame(unassignedCustomer, actualReclaimResult.getUnassignedCustomer());
  }
}
