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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.transport.lwm2m.secure.TbX509DtlsSessionInfo;

class TbL2M2MDtlsSessionInMemoryStoreDiffblueTest {
  /**
   * Test {@link TbL2M2MDtlsSessionInMemoryStore#put(String, TbX509DtlsSessionInfo)}.
   *
   * <p>Method under test: {@link TbL2M2MDtlsSessionInMemoryStore#put(String,
   * TbX509DtlsSessionInfo)}
   */
  @Test
  @DisplayName("Test put(String, TbX509DtlsSessionInfo)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbL2M2MDtlsSessionInMemoryStore.put(String, TbX509DtlsSessionInfo)"})
  void testPut() {
    // Arrange
    TbL2M2MDtlsSessionInMemoryStore tbL2M2MDtlsSessionInMemoryStore =
        new TbL2M2MDtlsSessionInMemoryStore();
    TbX509DtlsSessionInfo msg = mock(TbX509DtlsSessionInfo.class);

    // Act
    tbL2M2MDtlsSessionInMemoryStore.put("https://config.us-east-2.amazonaws.com", msg);

    // Assert
    assertSame(msg, tbL2M2MDtlsSessionInMemoryStore.get("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Test {@link TbL2M2MDtlsSessionInMemoryStore#get(String)}.
   *
   * <p>Method under test: {@link TbL2M2MDtlsSessionInMemoryStore#get(String)}
   */
  @Test
  @DisplayName("Test get(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbX509DtlsSessionInfo TbL2M2MDtlsSessionInMemoryStore.get(String)"})
  void testGet() {
    // Arrange, Act and Assert
    assertNull(new TbL2M2MDtlsSessionInMemoryStore().get("https://config.us-east-2.amazonaws.com"));
  }
}
