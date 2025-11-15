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
package org.thingsboard.server.transport.lwm2m.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.eclipse.leshan.core.LwM2m;
import org.eclipse.leshan.core.request.ContentFormat;
import org.junit.jupiter.api.Test;

class TbLwM2mVersionDiffblueTest {
  /**
   * Method under test: {@link TbLwM2mVersion#fromCode(int)}
   */
  @Test
  void testFromCode() {
    // Arrange, Act and Assert
    assertEquals(TbLwM2mVersion.VERSION_1_1, TbLwM2mVersion.fromCode(1));
    assertThrows(IllegalArgumentException.class, () -> TbLwM2mVersion.fromCode(2));
  }

  /**
   * Method under test: {@link TbLwM2mVersion#fromVersion(LwM2m.LwM2mVersion)}
   */
  @Test
  void testFromVersion() {
    // Arrange, Act and Assert
    assertEquals(TbLwM2mVersion.VERSION_1_0, TbLwM2mVersion.fromVersion(LwM2m.LwM2mVersion.getDefault()));
    assertEquals(TbLwM2mVersion.VERSION_1_1, TbLwM2mVersion.fromVersion(LwM2m.LwM2mVersion.lastSupported()));
    assertThrows(IllegalArgumentException.class, () -> TbLwM2mVersion.fromVersion(null));
  }

  /**
   * Method under test: {@link TbLwM2mVersion#fromVersionStr(String)}
   */
  @Test
  void testFromVersionStr() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbLwM2mVersion.fromVersionStr("1.0.2"));
    assertEquals(TbLwM2mVersion.VERSION_1_0, TbLwM2mVersion.fromVersionStr("1.0"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbLwM2mVersion#getCode()}
   *   <li>{@link TbLwM2mVersion#getContentFormat()}
   *   <li>{@link TbLwM2mVersion#getVersion()}
   *   <li>{@link TbLwM2mVersion#isComposite()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbLwM2mVersion valueOfResult = TbLwM2mVersion.valueOf("VERSION_1_0");

    // Act
    int actualCode = valueOfResult.getCode();
    ContentFormat actualContentFormat = valueOfResult.getContentFormat();
    LwM2m.LwM2mVersion actualVersion = valueOfResult.getVersion();

    // Assert
    assertEquals(0, actualCode);
    assertFalse(valueOfResult.isComposite());
    assertTrue(actualVersion.isSupported());
    assertSame(actualContentFormat.TLV, actualContentFormat);
  }
}
