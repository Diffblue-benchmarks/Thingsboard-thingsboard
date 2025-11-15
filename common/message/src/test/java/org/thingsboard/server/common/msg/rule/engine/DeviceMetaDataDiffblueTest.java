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
package org.thingsboard.server.common.msg.rule.engine;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.kv.AttributeKvEntry;

class DeviceMetaDataDiffblueTest {
  /**
   * Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceId deviceId = mock(DeviceId.class);
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();
    DeviceMetaData deviceMetaData = new DeviceMetaData(deviceId, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>()));
    ArrayList<AttributeKvEntry> clientSideAttributes2 = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(deviceMetaData, new DeviceMetaData(null, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes2, serverPrivateAttributes2, new ArrayList<>())));
  }

  /**
   * Method under test: {@link DeviceMetaData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceId deviceId = mock(DeviceId.class);
    ArrayList<AttributeKvEntry> clientSideAttributes = new ArrayList<>();
    ArrayList<AttributeKvEntry> serverPrivateAttributes = new ArrayList<>();

    // Act and Assert
    assertNotEquals(new DeviceMetaData(deviceId, "Device Name", "Device Type",
        new DeviceAttributes(clientSideAttributes, serverPrivateAttributes, new ArrayList<>())), "42");
  }
}
