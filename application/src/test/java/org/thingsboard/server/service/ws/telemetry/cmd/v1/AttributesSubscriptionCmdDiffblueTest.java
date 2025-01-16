package org.thingsboard.server.service.ws.telemetry.cmd.v1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.service.ws.WsCmdType;

class AttributesSubscriptionCmdDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link AttributesSubscriptionCmd}
   *   <li>{@link AttributesSubscriptionCmd#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    AttributesSubscriptionCmd actualAttributesSubscriptionCmd = new AttributesSubscriptionCmd();
    WsCmdType actualType = actualAttributesSubscriptionCmd.getType();

    // Assert
    assertNull(actualAttributesSubscriptionCmd.getEntityId());
    assertNull(actualAttributesSubscriptionCmd.getEntityType());
    assertNull(actualAttributesSubscriptionCmd.getKeys());
    assertNull(actualAttributesSubscriptionCmd.getScope());
    assertEquals(0, actualAttributesSubscriptionCmd.getCmdId());
    assertEquals(WsCmdType.ATTRIBUTES, actualType);
    assertFalse(actualAttributesSubscriptionCmd.isUnsubscribe());
  }
}
