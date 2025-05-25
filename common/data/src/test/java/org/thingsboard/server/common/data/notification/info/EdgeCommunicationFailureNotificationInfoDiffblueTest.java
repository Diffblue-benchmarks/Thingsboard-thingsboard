package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EdgeId;

class EdgeCommunicationFailureNotificationInfoDiffblueTest {
  /**
   * Test {@link EdgeCommunicationFailureNotificationInfo#getTemplateData()}.
   * <ul>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeCommunicationFailureNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map EdgeCommunicationFailureNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnSizeIsThree() {
    // Arrange
    EdgeCommunicationFailureNotificationInfo edgeCommunicationFailureNotificationInfo = new EdgeCommunicationFailureNotificationInfo();
    edgeCommunicationFailureNotificationInfo
        .setEdgeId(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    Map<String, String> actualTemplateData = edgeCommunicationFailureNotificationInfo.getTemplateData();

    // Assert
    assertEquals(3, actualTemplateData.size());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTemplateData.get("edgeId"));
    assertNull(actualTemplateData.get("edgeName"));
    assertNull(actualTemplateData.get("failureMsg"));
  }
}
