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
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class EntityCountQueryDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountQuery#EntityCountQuery()}
   *   <li>{@link EntityCountQuery#toString()}
   *   <li>{@link EntityCountQuery#getEntityFilter()}
   *   <li>{@link EntityCountQuery#getKeyFilters()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link EntityCountQuery#EntityCountQuery(EntityFilter, List)}
   *   <li>{@link EntityCountQuery#toString()}
   *   <li>{@link EntityCountQuery#getEntityFilter()}
   *   <li>{@link EntityCountQuery#getKeyFilters()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
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
   * Method under test: {@link EntityCountQuery#EntityCountQuery(EntityFilter)}
   */
  @Test
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
