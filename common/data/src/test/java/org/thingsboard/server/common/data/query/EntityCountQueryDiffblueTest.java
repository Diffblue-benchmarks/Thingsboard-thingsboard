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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EntityCountQueryDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountQuery#EntityCountQuery()}
   *   <li>{@link EntityCountQuery#toString()}
   *   <li>{@link EntityCountQuery#getEntityFilter()}
   *   <li>{@link EntityCountQuery#getKeyFilters()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityCountQuery.<init>()", "void EntityCountQuery.<init>(EntityFilter, List)",
      "EntityFilter EntityCountQuery.getEntityFilter()", "List EntityCountQuery.getKeyFilters()",
      "String EntityCountQuery.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    EntityCountQuery actualEntityCountQuery = new EntityCountQuery();
    String actualToStringResult = actualEntityCountQuery.toString();
    EntityFilter actualEntityFilter = actualEntityCountQuery.getEntityFilter();

    // Assert
    assertEquals("EntityCountQuery(entityFilter=null, keyFilters=null)", actualToStringResult);
    assertNull(actualEntityCountQuery.getKeyFilters());
    assertNull(actualEntityFilter);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link EntityFilter}.</li>
   *   <li>Then return KeyFilters Empty.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountQuery#EntityCountQuery(EntityFilter, List)}
   *   <li>{@link EntityCountQuery#toString()}
   *   <li>{@link EntityCountQuery#getEntityFilter()}
   *   <li>{@link EntityCountQuery#getKeyFilters()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when EntityFilter; then return KeyFilters Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityCountQuery.<init>()", "void EntityCountQuery.<init>(EntityFilter, List)",
      "EntityFilter EntityCountQuery.getEntityFilter()", "List EntityCountQuery.getKeyFilters()",
      "String EntityCountQuery.toString()"})
  void testGettersAndSetters_whenEntityFilter_thenReturnKeyFiltersEmpty() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);
    ArrayList<KeyFilter> keyFilters = new ArrayList<>();

    // Act
    EntityCountQuery actualEntityCountQuery = new EntityCountQuery(entityFilter, keyFilters);
    actualEntityCountQuery.toString();
    EntityFilter actualEntityFilter = actualEntityCountQuery.getEntityFilter();
    List<KeyFilter> actualKeyFilters = actualEntityCountQuery.getKeyFilters();

    // Assert
    assertTrue(actualKeyFilters.isEmpty());
    assertSame(keyFilters, actualKeyFilters);
    assertSame(entityFilter, actualEntityFilter);
  }

  /**
   * Test {@link EntityCountQuery#EntityCountQuery(EntityFilter)}.
   * <p>
   * Method under test: {@link EntityCountQuery#EntityCountQuery(EntityFilter)}
   */
  @Test
  @DisplayName("Test new EntityCountQuery(EntityFilter)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EntityCountQuery.<init>(EntityFilter)"})
  void testNewEntityCountQuery() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);

    // Act
    EntityCountQuery actualEntityCountQuery = new EntityCountQuery(entityFilter);

    // Assert
    assertTrue(actualEntityCountQuery.getKeyFilters().isEmpty());
    assertSame(entityFilter, actualEntityCountQuery.getEntityFilter());
  }
}
