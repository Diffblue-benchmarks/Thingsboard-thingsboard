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
package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TsInsertExecutorTypeDiffblueTest {
  /**
   * Test {@link TsInsertExecutorType#parse(String)}.
   *
   * <ul>
   *   <li>When {@code CACHED}.
   *   <li>Then return {@link Optional#get()} is {@code CACHED}.
   * </ul>
   *
   * <p>Method under test: {@link TsInsertExecutorType#parse(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional TsInsertExecutorType.parse(String)"})
  public void testParse_whenCached_thenReturnGetIsCached() {
    // Arrange and Act
    Optional<TsInsertExecutorType> actualParseResult = TsInsertExecutorType.parse("CACHED");

    // Assert
    assertEquals(TsInsertExecutorType.CACHED, actualParseResult.get());
    assertTrue(actualParseResult.isPresent());
  }
}
