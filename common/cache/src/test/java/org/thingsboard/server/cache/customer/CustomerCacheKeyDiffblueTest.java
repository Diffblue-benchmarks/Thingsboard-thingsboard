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
package org.thingsboard.server.cache.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class CustomerCacheKeyDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link CustomerCacheKey#equals(Object)}
   *   <li>{@link CustomerCacheKey#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    // Act and Assert
    assertEquals(customerCacheKey, customerCacheKey);
    int expectedHashCodeResult = customerCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, customerCacheKey.hashCode());
  }

  /**
   * Method under test: {@link CustomerCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomerCacheKey customerCacheKey = new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr");

    // Act and Assert
    assertNotEquals(customerCacheKey, new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr"));
  }

  /**
   * Method under test: {@link CustomerCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr"), null);
  }

  /**
   * Method under test: {@link CustomerCacheKey#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr"), "Different type to CustomerCacheKey");
  }

  /**
   * Method under test:
   * {@link CustomerCacheKey#CustomerCacheKey(TenantId, String)}
   */
  @Test
  void testNewCustomerCacheKey() {
    // Arrange, Act and Assert
    assertFalse((new CustomerCacheKey(new TenantId(UUID.randomUUID()), "Dr")).canEqual("Other"));
  }
}
