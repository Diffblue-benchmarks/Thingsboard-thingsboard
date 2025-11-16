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

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AuditLogLevelPropertiesDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AuditLogLevelProperties#setMask(Map)}
   *   <li>{@link AuditLogLevelProperties#getMask()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map AuditLogLevelProperties.getMask()",
    "void AuditLogLevelProperties.setMask(Map)"
  })
  public void testGettersAndSetters() {
    // Arrange
    AuditLogLevelProperties auditLogLevelProperties = new AuditLogLevelProperties();
    HashMap<String, String> mask = new HashMap<>();

    // Act
    auditLogLevelProperties.setMask(mask);
    Map<String, String> actualMask = auditLogLevelProperties.getMask();

    // Assert
    assertTrue(actualMask.isEmpty());
    assertSame(mask, actualMask);
  }
}
