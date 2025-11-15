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
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AbstractDataQueryDiffblueTest {
  /**
   * Method under test: {@link AbstractDataQuery#getEntityFields()}
   */
  @Test
  void testGetEntityFields() {
    // Arrange, Act and Assert
    assertNull((new AlarmDataQuery()).getEntityFields());
  }

  /**
   * Method under test: {@link AbstractDataQuery#getEntityFields()}
   */
  @Test
  void testGetEntityFields2() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);

    // Act and Assert
    assertNull((new AlarmDataQuery(entityFilter, new ArrayList<>())).getEntityFields());
  }

  /**
   * Method under test: {@link AbstractDataQuery#getLatestValues()}
   */
  @Test
  void testGetLatestValues() {
    // Arrange, Act and Assert
    assertNull((new AlarmDataQuery()).getLatestValues());
  }

  /**
   * Method under test: {@link AbstractDataQuery#getLatestValues()}
   */
  @Test
  void testGetLatestValues2() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);

    // Act and Assert
    assertNull((new AlarmDataQuery(entityFilter, new ArrayList<>())).getLatestValues());
  }

  /**
   * Method under test: {@link AbstractDataQuery#getPageLink()}
   */
  @Test
  void testGetPageLink() {
    // Arrange, Act and Assert
    assertNull((new AlarmDataQuery()).getPageLink());
  }

  /**
   * Method under test: {@link AbstractDataQuery#getPageLink()}
   */
  @Test
  void testGetPageLink2() {
    // Arrange
    EntityFilter entityFilter = mock(EntityFilter.class);

    // Act and Assert
    assertNull((new AlarmDataQuery(entityFilter, new ArrayList<>())).getPageLink());
  }

  /**
   * Method under test: {@link AbstractDataQuery#toString()}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("EntityDataQuery(super=AbstractDataQuery(super=EntityCountQuery(entityFilter=null, keyFilters=null),"
        + " pageLink=null, entityFields=null, latestValues=null))", (new EntityDataQuery()).toString());
  }
}
