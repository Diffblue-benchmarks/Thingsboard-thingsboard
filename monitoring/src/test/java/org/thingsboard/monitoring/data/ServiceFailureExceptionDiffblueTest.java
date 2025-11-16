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
package org.thingsboard.monitoring.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServiceFailureExceptionDiffblueTest {
  /**
   * Test {@link ServiceFailureException#ServiceFailureException(String)}.
   *
   * <p>Method under test: {@link ServiceFailureException#ServiceFailureException(String)}
   */
  @Test
  @DisplayName("Test new ServiceFailureException(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServiceFailureException.<init>(String)"})
  void testNewServiceFailureException() {
    // Arrange and Act
    ServiceFailureException actualServiceFailureException =
        new ServiceFailureException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualServiceFailureException.getMessage());
    assertNull(actualServiceFailureException.getCause());
    assertEquals(0, actualServiceFailureException.getSuppressed().length);
  }

  /**
   * Test {@link ServiceFailureException#ServiceFailureException(Throwable)}.
   *
   * <p>Method under test: {@link ServiceFailureException#ServiceFailureException(Throwable)}
   */
  @Test
  @DisplayName("Test new ServiceFailureException(Throwable)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void ServiceFailureException.<init>(Throwable)"})
  void testNewServiceFailureException2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ServiceFailureException actualServiceFailureException = new ServiceFailureException(cause);

    // Assert
    assertNull(actualServiceFailureException.getLocalizedMessage());
    assertNull(actualServiceFailureException.getMessage());
    assertEquals(0, actualServiceFailureException.getSuppressed().length);
    assertSame(cause, actualServiceFailureException.getCause());
  }
}
