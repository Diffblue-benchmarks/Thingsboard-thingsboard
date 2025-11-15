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
package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ServiceTypeDiffblueTest {
  /**
   * Test {@link ServiceType#of(String)}.
   * <ul>
   *   <li>When {@code JS_EXECUTOR}.</li>
   *   <li>Then return {@code JS_EXECUTOR}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ServiceType#of(String)}
   */
  @Test
  @DisplayName("Test of(String); when 'JS_EXECUTOR'; then return 'JS_EXECUTOR'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ServiceType ServiceType.of(String)"})
  void testOf_whenJsExecutor_thenReturnJsExecutor() {
    // Arrange, Act and Assert
    assertEquals(ServiceType.JS_EXECUTOR, ServiceType.of("JS_EXECUTOR"));
  }

  /**
   * Test {@link ServiceType#getLabel()}.
   * <p>
   * Method under test: {@link ServiceType#getLabel()}
   */
  @Test
  @DisplayName("Test getLabel()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ServiceType.getLabel()"})
  void testGetLabel() {
    // Arrange, Act and Assert
    assertEquals("TB Core", ServiceType.valueOf("TB_CORE").getLabel());
  }
}
