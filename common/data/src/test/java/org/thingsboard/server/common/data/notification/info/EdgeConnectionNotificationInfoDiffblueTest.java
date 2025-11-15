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
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;

class EdgeConnectionNotificationInfoDiffblueTest {
  /**
   * Method under test: {@link EdgeConnectionNotificationInfo#getTemplateData()}
   */
  @Test
  void testGetTemplateData() {
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
