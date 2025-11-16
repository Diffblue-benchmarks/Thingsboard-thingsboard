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
package org.thingsboard.script.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BlockedScriptInfoDiffblueTest {
  /**
   * Test {@link BlockedScriptInfo#BlockedScriptInfo(int)}.
   *
   * <p>Method under test: {@link BlockedScriptInfo#BlockedScriptInfo(int)}
   */
  @Test
  @DisplayName("Test new BlockedScriptInfo(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void BlockedScriptInfo.<init>(int)"})
  void testNewBlockedScriptInfo() {
    // Arrange and Act
    BlockedScriptInfo actualBlockedScriptInfo = new BlockedScriptInfo(3);

    // Assert
    assertEquals(0, actualBlockedScriptInfo.get());
    assertEquals(0L, actualBlockedScriptInfo.getExpirationTime());
  }

  /**
   * Test {@link BlockedScriptInfo#get()}.
   *
   * <p>Method under test: {@link BlockedScriptInfo#get()}
   */
  @Test
  @DisplayName("Test get()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BlockedScriptInfo.get()"})
  void testGet() {
    // Arrange, Act and Assert
    assertEquals(0, new BlockedScriptInfo(3).get());
  }

  /**
   * Test {@link BlockedScriptInfo#incrementAndGet()}.
   *
   * <p>Method under test: {@link BlockedScriptInfo#incrementAndGet()}
   */
  @Test
  @DisplayName("Test incrementAndGet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int BlockedScriptInfo.incrementAndGet()"})
  void testIncrementAndGet() {
    // Arrange
    BlockedScriptInfo blockedScriptInfo = new BlockedScriptInfo(3);

    // Act
    int actualIncrementAndGetResult = blockedScriptInfo.incrementAndGet();

    // Assert
    assertEquals(1, blockedScriptInfo.get());
    assertEquals(1, actualIncrementAndGetResult);
  }

  /**
   * Test {@link BlockedScriptInfo#getExpirationTime()}.
   *
   * <p>Method under test: {@link BlockedScriptInfo#getExpirationTime()}
   */
  @Test
  @DisplayName("Test getExpirationTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long BlockedScriptInfo.getExpirationTime()"})
  void testGetExpirationTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new BlockedScriptInfo(3).getExpirationTime());
  }
}
