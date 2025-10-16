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
package org.thingsboard.server.dao.audit;

import static org.junit.Assert.assertFalse;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AuditLogLevelMaskDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLogLevelMask#isRead()}
   *   <li>{@link AuditLogLevelMask#isWrite()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLogLevelMask.isRead()", "boolean AuditLogLevelMask.isWrite()"})
  public void testGettersAndSetters() {
    // Arrange
    AuditLogLevelMask valueOfResult = AuditLogLevelMask.valueOf("OFF");

    // Act
    boolean actualIsReadResult = valueOfResult.isRead();

    // Assert
    assertFalse(actualIsReadResult);
    assertFalse(valueOfResult.isWrite());
  }
}
