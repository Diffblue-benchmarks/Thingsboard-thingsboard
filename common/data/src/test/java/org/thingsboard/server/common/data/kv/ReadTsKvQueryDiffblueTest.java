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
package org.thingsboard.server.common.data.kv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class ReadTsKvQueryDiffblueTest {
  /**
   * Method under test: {@link ReadTsKvQuery#getInterval()}
   */
  @Test
  void testGetInterval() {
    // Arrange, Act and Assert
    assertEquals(0L, (new BaseReadTsKvQuery("Key", 1L, 1L)).getInterval());
  }

  /**
   * Method under test: {@link ReadTsKvQuery#getAggregation()}
   */
  @Test
  void testGetAggregation() {
    // Arrange, Act and Assert
    assertEquals(Aggregation.AVG, (new BaseReadTsKvQuery("Key", 1L, 1L)).getAggregation());
  }
}
