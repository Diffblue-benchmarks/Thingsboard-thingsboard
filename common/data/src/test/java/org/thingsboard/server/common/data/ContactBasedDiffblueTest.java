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
import org.junit.jupiter.api.Test;

class ContactBasedDiffblueTest {
  /**
   * Method under test: {@link ContactBased#setCountry(String)}
   */
  @Test
  void testSetCountry() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setCountry("GB");

    // Assert
    assertEquals("GB", customer.getCountry());
  }

  /**
   * Method under test: {@link ContactBased#setState(String)}
   */
  @Test
  void testSetState() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setState("MD");

    // Assert
    assertEquals("MD", customer.getState());
  }

  /**
   * Method under test: {@link ContactBased#setCity(String)}
   */
  @Test
  void testSetCity() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setCity("Oxford");

    // Assert
    assertEquals("Oxford", customer.getCity());
  }

  /**
   * Method under test: {@link ContactBased#setAddress(String)}
   */
  @Test
  void testSetAddress() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setAddress("42 Main St");

    // Assert
    assertEquals("42 Main St", customer.getAddress());
  }

  /**
   * Method under test: {@link ContactBased#setAddress2(String)}
   */
  @Test
  void testSetAddress2() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setAddress2("42 Main St");

    // Assert
    assertEquals("42 Main St", customer.getAddress2());
  }

  /**
   * Method under test: {@link ContactBased#setZip(String)}
   */
  @Test
  void testSetZip() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setZip("21654");

    // Assert
    assertEquals("21654", customer.getZip());
  }

  /**
   * Method under test: {@link ContactBased#setPhone(String)}
   */
  @Test
  void testSetPhone() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setPhone("6625550144");

    // Assert
    assertEquals("6625550144", customer.getPhone());
  }

  /**
   * Method under test: {@link ContactBased#setEmail(String)}
   */
  @Test
  void testSetEmail() {
    // Arrange
    Customer customer = new Customer();

    // Act
    customer.setEmail("jane.doe@example.org");

    // Assert
    assertEquals("jane.doe@example.org", customer.getEmail());
  }
}
