package org.thingsboard.server.common.data.id;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class NameLabelAndCustomerDetailsDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NameLabelAndCustomerDetails#NameLabelAndCustomerDetails(String, String,
   *       CustomerId)}
   *   <li>{@link NameLabelAndCustomerDetails#getCustomerId()}
   *   <li>{@link NameLabelAndCustomerDetails#getLabel()}
   *   <li>{@link NameLabelAndCustomerDetails#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NameLabelAndCustomerDetails.<init>(String, String, CustomerId)",
    "CustomerId NameLabelAndCustomerDetails.getCustomerId()",
    "String NameLabelAndCustomerDetails.getLabel()",
    "String NameLabelAndCustomerDetails.getName()"
  })
  void testGettersAndSetters() {
    // Arrange
    CustomerId customerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    NameLabelAndCustomerDetails actualNameLabelAndCustomerDetails =
        new NameLabelAndCustomerDetails("Name", "Label", customerId);
    CustomerId actualCustomerId = actualNameLabelAndCustomerDetails.getCustomerId();
    String actualLabel = actualNameLabelAndCustomerDetails.getLabel();

    // Assert
    assertEquals("Label", actualLabel);
    assertEquals("Name", actualNameLabelAndCustomerDetails.getName());
    assertSame(customerId, actualCustomerId);
  }
}
