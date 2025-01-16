package org.thingsboard.server.service.sync.ie.exporting.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;

class NotificationTemplateExportServiceDiffblueTest {
  /**
   * Test {@link NotificationTemplateExportService#getSupportedEntityTypes()}.
   * <p>
   * Method under test:
   * {@link NotificationTemplateExportService#getSupportedEntityTypes()}
   */
  @Test
  @DisplayName("Test getSupportedEntityTypes()")
  void testGetSupportedEntityTypes() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    Set<EntityType> actualSupportedEntityTypes = (new NotificationTemplateExportService()).getSupportedEntityTypes();

    // Assert
    assertEquals(1, actualSupportedEntityTypes.size());
    assertTrue(actualSupportedEntityTypes.contains(EntityType.NOTIFICATION_TEMPLATE));
  }
}
