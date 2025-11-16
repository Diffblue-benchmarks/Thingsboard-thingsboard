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
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.script.api.TbScriptException.ErrorCode;

class TbScriptExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbScriptException#TbScriptException(UUID, ErrorCode, String, Exception)}
   *   <li>{@link TbScriptException#getBody()}
   *   <li>{@link TbScriptException#getErrorCode()}
   *   <li>{@link TbScriptException#getScriptId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbScriptException.<init>(UUID, ErrorCode, String, Exception)",
    "String TbScriptException.getBody()",
    "ErrorCode TbScriptException.getErrorCode()",
    "UUID TbScriptException.getScriptId()"
  })
  void testGettersAndSetters() {
    // Arrange
    UUID scriptId = UUID.randomUUID();
    Exception cause = new Exception();

    // Act
    TbScriptException actualTbScriptException =
        new TbScriptException(
            scriptId, ErrorCode.COMPILATION, "Not all who wander are lost", cause);
    String actualBody = actualTbScriptException.getBody();
    ErrorCode actualErrorCode = actualTbScriptException.getErrorCode();
    UUID actualScriptId = actualTbScriptException.getScriptId();

    // Assert
    assertEquals("Not all who wander are lost", actualBody);
    assertEquals("java.lang.Exception", actualTbScriptException.getMessage());
    assertEquals(0, actualTbScriptException.getSuppressed().length);
    assertEquals(ErrorCode.COMPILATION, actualErrorCode);
    assertSame(cause, actualTbScriptException.getCause());
    assertSame(scriptId, actualScriptId);
  }
}
