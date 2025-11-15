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
package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class NameLabelAndCustomerDetailsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link NameLabelAndCustomerDetails#NameLabelAndCustomerDetails(String, String, CustomerId)}
   *   <li>{@link NameLabelAndCustomerDetails#getCustomerId()}
   *   <li>{@link NameLabelAndCustomerDetails#getLabel()}
   *   <li>{@link NameLabelAndCustomerDetails#getName()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);

    // Act
    NameLabelAndCustomerDetails actualNameLabelAndCustomerDetails = new NameLabelAndCustomerDetails("Name", "Label",
        customerId);
    CustomerId actualCustomerId = actualNameLabelAndCustomerDetails.getCustomerId();
    String actualLabel = actualNameLabelAndCustomerDetails.getLabel();

    // Assert
    assertEquals("Label", actualLabel);
    assertEquals("Name", actualNameLabelAndCustomerDetails.getName());
    assertSame(customerId, actualCustomerId);
  }
}
