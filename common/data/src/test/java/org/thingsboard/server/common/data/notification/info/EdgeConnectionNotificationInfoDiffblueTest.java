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
package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;

class EdgeConnectionNotificationInfoDiffblueTest {
  /**
   * Test {@link EdgeConnectionNotificationInfo#getTemplateData()}.
   * <ul>
   *   <li>Then return size is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeConnectionNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is three")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map EdgeConnectionNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnSizeIsThree() {
    // Arrange
    EdgeConnectionNotificationInfo edgeConnectionNotificationInfo = new EdgeConnectionNotificationInfo();
    edgeConnectionNotificationInfo.setEdgeId(new EdgeId(EntityId.NULL_UUID));

    // Act
    Map<String, String> actualTemplateData = edgeConnectionNotificationInfo.getTemplateData();

    // Assert
    assertEquals(3, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("edgeId"));
    assertNull(actualTemplateData.get("edgeName"));
    assertNull(actualTemplateData.get("eventType"));
  }
}
