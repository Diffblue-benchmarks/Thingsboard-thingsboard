package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;

class EdgeCommunicationFailureNotificationInfoDiffblueTest {
  /**
   * Test {@link EdgeCommunicationFailureNotificationInfo#getTemplateData()}.
   * <ul>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link EdgeCommunicationFailureNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is three")
  void testGetTemplateData_thenReturnSizeIsThree() {
    // Arrange
    EdgeCommunicationFailureNotificationInfo edgeCommunicationFailureNotificationInfo = new EdgeCommunicationFailureNotificationInfo();
    edgeCommunicationFailureNotificationInfo.setEdgeId(new EdgeId(EntityId.NULL_UUID));

    // Act
    Map<String, String> actualTemplateData = edgeCommunicationFailureNotificationInfo.getTemplateData();

    // Assert
    assertEquals(3, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("edgeId"));
    assertNull(actualTemplateData.get("edgeName"));
    assertNull(actualTemplateData.get("failureMsg"));
  }
}
