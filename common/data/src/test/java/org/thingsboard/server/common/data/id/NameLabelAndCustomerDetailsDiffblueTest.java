package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NameLabelAndCustomerDetailsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
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
