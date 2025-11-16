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
package org.thingsboard.server.common.data.query;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AbstractDataQueryDiffblueTest {
  /**
   * Test {@link AbstractDataQuery#getEntityFields()}.
   *
   * <p>Method under test: {@link AbstractDataQuery#getEntityFields()}
   */
  @Test
  @DisplayName("Test getEntityFields()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AbstractDataQuery.getEntityFields()"})
  void testGetEntityFields() {
    // Arrange, Act and Assert
    assertNull(new AlarmDataQuery().getEntityFields());
  }

  /**
   * Test {@link AbstractDataQuery#getLatestValues()}.
   *
   * <p>Method under test: {@link AbstractDataQuery#getLatestValues()}
   */
  @Test
  @DisplayName("Test getLatestValues()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AbstractDataQuery.getLatestValues()"})
  void testGetLatestValues() {
    // Arrange, Act and Assert
    assertNull(new AlarmDataQuery().getLatestValues());
  }

  /**
   * Test {@link AbstractDataQuery#getPageLink()}.
   *
   * <p>Method under test: {@link AbstractDataQuery#getPageLink()}
   */
  @Test
  @DisplayName("Test getPageLink()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.query.EntityDataPageLink AbstractDataQuery.getPageLink()"
  })
  void testGetPageLink() {
    // Arrange, Act and Assert
    assertNull(new AlarmDataQuery().getPageLink());
  }

  /**
   * Test {@link AbstractDataQuery#toString()}.
   *
   * <p>Method under test: {@link AbstractDataQuery#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String AbstractDataQuery.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "EntityDataQuery(super=AbstractDataQuery(super=EntityCountQuery(entityFilter=null, keyFilters=null),"
            + " pageLink=null, entityFields=null, latestValues=null))",
        new EntityDataQuery().toString());
  }
}
