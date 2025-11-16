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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TemplateUtilsDiffblueTest {
  /**
   * Test {@link TemplateUtils#processTemplate(String, Map)}.
   *
   * <ul>
   *   <li>When {@code Template}.
   *   <li>Then return {@code Template}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateUtils#processTemplate(String, Map)}
   */
  @Test
  @DisplayName("Test processTemplate(String, Map); when 'Template'; then return 'Template'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TemplateUtils.processTemplate(String, Map)"})
  void testProcessTemplate_whenTemplate_thenReturnTemplate() {
    // Arrange, Act and Assert
    assertEquals("Template", TemplateUtils.processTemplate("Template", new HashMap<>()));
  }

  /**
   * Test {@link TemplateUtils#processTemplate(String, Map)}.
   *
   * <ul>
   *   <li>When {@code ${UUU:U}}.
   *   <li>Then return {@code ${UUU:U}}.
   * </ul>
   *
   * <p>Method under test: {@link TemplateUtils#processTemplate(String, Map)}
   */
  @Test
  @DisplayName("Test processTemplate(String, Map); when '${UUU:U}'; then return '${UUU:U}'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TemplateUtils.processTemplate(String, Map)"})
  void testProcessTemplate_whenUuuU_thenReturnUuuU() {
    // Arrange, Act and Assert
    assertEquals("${UUU:U}", TemplateUtils.processTemplate("${UUU:U}", new HashMap<>()));
  }
}
