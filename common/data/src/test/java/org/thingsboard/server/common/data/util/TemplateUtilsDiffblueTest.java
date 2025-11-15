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
package org.thingsboard.server.common.data.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class TemplateUtilsDiffblueTest {
  /**
   * Method under test: {@link TemplateUtils#processTemplate(String, Map)}
   */
  @Test
  void testProcessTemplate() {
    // Arrange, Act and Assert
    assertEquals("Template", TemplateUtils.processTemplate("Template", new HashMap<>()));
    assertEquals("${UUU:U}", TemplateUtils.processTemplate("${UUU:U}", new HashMap<>()));
  }

  /**
   * Method under test: {@link TemplateUtils#processTemplate(String, Map)}
   */
  @Test
  void testProcessTemplate2() {
    // Arrange
    HashMap<String, String> context = new HashMap<>();
    context.computeIfPresent("${UUU:U}", mock(BiFunction.class));

    // Act and Assert
    assertEquals("Template", TemplateUtils.processTemplate("Template", context));
  }
}
