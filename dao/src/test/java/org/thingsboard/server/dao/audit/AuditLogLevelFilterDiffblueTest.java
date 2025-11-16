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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.audit.ActionType;

public class AuditLogLevelFilterDiffblueTest {
  /**
   * Test {@link AuditLogLevelFilter#logEnabled(EntityType, ActionType)}.
   *
   * <p>Method under test: {@link AuditLogLevelFilter#logEnabled(EntityType, ActionType)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean AuditLogLevelFilter.logEnabled(EntityType, ActionType)"})
  public void testLogEnabled() {
    // Arrange, Act and Assert
    assertFalse(
        new AuditLogLevelFilter(new AuditLogLevelProperties())
            .logEnabled(EntityType.TENANT, ActionType.ADDED));
  }
}
