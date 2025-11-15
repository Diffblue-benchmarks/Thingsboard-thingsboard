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

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.client.LwM2mClient;

class TbDummyLwM2MClientStoreDiffblueTest {
  /**
   * Test {@link TbDummyLwM2MClientStore#get(String)}.
   * <p>
   * Method under test: {@link TbDummyLwM2MClientStore#get(String)}
   */
  @Test
  @DisplayName("Test get(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2mClient TbDummyLwM2MClientStore.get(String)"})
  void testGet() {
    // Arrange, Act and Assert
    assertNull((new TbDummyLwM2MClientStore()).get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbDummyLwM2MClientStore#getAll()}.
   * <p>
   * Method under test: {@link TbDummyLwM2MClientStore#getAll()}
   */
  @Test
  @DisplayName("Test getAll()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.util.Set TbDummyLwM2MClientStore.getAll()"})
  void testGetAll() {
    // Arrange, Act and Assert
    assertTrue((new TbDummyLwM2MClientStore()).getAll().isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TbDummyLwM2MClientStore}
   *   <li>{@link TbDummyLwM2MClientStore#put(LwM2mClient)}
   *   <li>{@link TbDummyLwM2MClientStore#remove(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbDummyLwM2MClientStore.<init>()", "void TbDummyLwM2MClientStore.put(LwM2mClient)",
      "void TbDummyLwM2MClientStore.remove(String)"})
  void testGettersAndSetters() {
    // Arrange and Act
    TbDummyLwM2MClientStore actualTbDummyLwM2MClientStore = new TbDummyLwM2MClientStore();
    actualTbDummyLwM2MClientStore.put(new LwM2mClient("42", "https://config.us-east-2.amazonaws.com"));
    actualTbDummyLwM2MClientStore.remove("https://config.us-east-2.amazonaws.com");

    // Assert
    assertTrue(actualTbDummyLwM2MClientStore.getAll().isEmpty());
  }
}
