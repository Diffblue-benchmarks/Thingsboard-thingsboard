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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.server.model.LwM2MModelConfig;

class TbDummyLwM2MModelConfigStoreDiffblueTest {
  /**
   * Test {@link TbDummyLwM2MModelConfigStore#getAll()}.
   *
   * <p>Method under test: {@link TbDummyLwM2MModelConfigStore#getAll()}
   */
  @Test
  @DisplayName("Test getAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List TbDummyLwM2MModelConfigStore.getAll()"})
  void testGetAll() {
    // Arrange, Act and Assert
    assertTrue(new TbDummyLwM2MModelConfigStore().getAll().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link TbDummyLwM2MModelConfigStore}
   *   <li>{@link TbDummyLwM2MModelConfigStore#put(LwM2MModelConfig)}
   *   <li>{@link TbDummyLwM2MModelConfigStore#remove(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbDummyLwM2MModelConfigStore.<init>()",
    "void TbDummyLwM2MModelConfigStore.put(LwM2MModelConfig)",
    "void TbDummyLwM2MModelConfigStore.remove(String)"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    TbDummyLwM2MModelConfigStore actualTbDummyLwM2MModelConfigStore =
        new TbDummyLwM2MModelConfigStore();
    actualTbDummyLwM2MModelConfigStore.put(
        new LwM2MModelConfig("https://config.us-east-2.amazonaws.com"));
    actualTbDummyLwM2MModelConfigStore.remove("https://config.us-east-2.amazonaws.com");

    // Assert
    assertTrue(actualTbDummyLwM2MModelConfigStore.getAll().isEmpty());
  }
}
