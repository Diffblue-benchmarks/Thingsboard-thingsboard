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
package org.thingsboard.server.common.msg.session.ex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SessionAuthExceptionDiffblueTest {
  /**
   * Test {@link SessionAuthException#SessionAuthException(String)}.
   * <p>
   * Method under test: {@link SessionAuthException#SessionAuthException(String)}
   */
  @Test
  @DisplayName("Test new SessionAuthException(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SessionAuthException.<init>(String)"})
  void testNewSessionAuthException() {
    // Arrange and Act
    SessionAuthException actualSessionAuthException = new SessionAuthException("0123456789ABCDEF");

    // Assert
    assertEquals("0123456789ABCDEF", actualSessionAuthException.getMessage());
    assertNull(actualSessionAuthException.getCause());
    assertEquals(0, actualSessionAuthException.getSuppressed().length);
  }
}
