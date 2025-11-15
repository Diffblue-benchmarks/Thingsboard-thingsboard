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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AttributeScopeDiffblueTest {
  /**
   * Test {@link AttributeScope#valueOf(int)} with {@code id}.
   * <p>
   * Method under test: {@link AttributeScope#valueOf(int)}
   */
  @Test
  @DisplayName("Test valueOf(int) with 'id'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AttributeScope AttributeScope.valueOf(int)"})
  void testValueOfWithId() {
    // Arrange, Act and Assert
    assertEquals(AttributeScope.CLIENT_SCOPE, AttributeScope.valueOf(1));
  }

  /**
   * Test {@link AttributeScope#getId()}.
   * <p>
   * Method under test: {@link AttributeScope#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AttributeScope.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertEquals(1, AttributeScope.valueOf(DataConstants.CLIENT_SCOPE).getId());
  }
}
