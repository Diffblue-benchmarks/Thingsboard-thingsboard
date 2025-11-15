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
package org.thingsboard.server.transport.mqtt.util.sparkplug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.exception.ThingsboardException;

class SparkplugMessageTypeDiffblueTest {
  /**
   * Method under test: {@link SparkplugMessageType#isBirth()}
   */
  @Test
  void testIsBirth() {
    // Arrange, Act and Assert
    assertTrue(SparkplugMessageType.NBIRTH.isBirth());
    assertFalse(SparkplugMessageType.NDEATH.isBirth());
    assertTrue(SparkplugMessageType.DBIRTH.isBirth());
  }

  /**
   * Method under test: {@link SparkplugMessageType#isCommand()}
   */
  @Test
  void testIsCommand() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NBIRTH.isCommand());
    assertTrue(SparkplugMessageType.NCMD.isCommand());
    assertTrue(SparkplugMessageType.DCMD.isCommand());
  }

  /**
   * Method under test: {@link SparkplugMessageType#isData()}
   */
  @Test
  void testIsData() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NBIRTH.isData());
    assertTrue(SparkplugMessageType.NDATA.isData());
    assertTrue(SparkplugMessageType.DDATA.isData());
  }

  /**
   * Method under test: {@link SparkplugMessageType#isDeath()}
   */
  @Test
  void testIsDeath() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NBIRTH.isDeath());
    assertTrue(SparkplugMessageType.NDEATH.isDeath());
    assertTrue(SparkplugMessageType.DDEATH.isDeath());
  }

  /**
   * Method under test: {@link SparkplugMessageType#isRecord()}
   */
  @Test
  void testIsRecord() {
    // Arrange, Act and Assert
    assertFalse(SparkplugMessageType.NBIRTH.isRecord());
    assertTrue(SparkplugMessageType.DRECORD.isRecord());
    assertTrue(SparkplugMessageType.NRECORD.isRecord());
  }

  /**
   * Method under test:
   * {@link SparkplugMessageType#messageName(SparkplugMessageType)}
   */
  @Test
  void testMessageName() {
    // Arrange, Act and Assert
    assertEquals("NBIRTH", SparkplugMessageType.messageName(SparkplugMessageType.NBIRTH));
    assertEquals("sparkplugConnectionState", SparkplugMessageType.messageName(SparkplugMessageType.STATE));
  }

  /**
   * Method under test: {@link SparkplugMessageType#parseMessageType(String)}
   */
  @Test
  void testParseMessageType() throws ThingsboardException {
    // Arrange, Act and Assert
    assertThrows(ThingsboardException.class, () -> SparkplugMessageType.parseMessageType("Type"));
    assertEquals(SparkplugMessageType.NBIRTH, SparkplugMessageType.parseMessageType("NBIRTH"));
  }
}
