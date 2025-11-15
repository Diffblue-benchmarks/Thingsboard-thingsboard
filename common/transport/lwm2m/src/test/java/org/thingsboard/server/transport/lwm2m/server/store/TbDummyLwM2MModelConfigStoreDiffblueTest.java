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
package org.thingsboard.server.transport.lwm2m.server.store;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfig;

class TbDummyLwM2MModelConfigStoreDiffblueTest {
  /**
   * Method under test: {@link TbDummyLwM2MModelConfigStore#getAll()}
   */
  @Test
  void testGetAll() {
    // Arrange, Act and Assert
    assertTrue((new TbDummyLwM2MModelConfigStore()).getAll().isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link TbDummyLwM2MModelConfigStore}
   *   <li>{@link TbDummyLwM2MModelConfigStore#put(LwM2MModelConfig)}
   *   <li>{@link TbDummyLwM2MModelConfigStore#remove(String)}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TbDummyLwM2MModelConfigStore actualTbDummyLwM2MModelConfigStore = new TbDummyLwM2MModelConfigStore();
    actualTbDummyLwM2MModelConfigStore.put(new LwM2MModelConfig("https://config.us-east-2.amazonaws.com"));
    actualTbDummyLwM2MModelConfigStore.remove("https://config.us-east-2.amazonaws.com");

    // Assert that nothing has changed
    assertTrue(actualTbDummyLwM2MModelConfigStore.getAll().isEmpty());
  }
}
