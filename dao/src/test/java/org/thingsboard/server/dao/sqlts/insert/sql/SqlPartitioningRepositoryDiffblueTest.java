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
package org.thingsboard.server.dao.sqlts.insert.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = {SqlPartitioningRepository.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class SqlPartitioningRepositoryDiffblueTest {
  @MockBean private JdbcTemplate jdbcTemplate;

  @Autowired private SqlPartitioningRepository sqlPartitioningRepository;

  /**
   * Test {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long SqlPartitioningRepository.calculatePartitionStartTime(long, long)"})
  public void testCalculatePartitionStartTime_whenFive_thenReturnFive() {
    // Arrange, Act and Assert
    assertEquals(5L, sqlPartitioningRepository.calculatePartitionStartTime(5L, 5L));
  }

  /**
   * Test {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long SqlPartitioningRepository.calculatePartitionStartTime(long, long)"})
  public void testCalculatePartitionStartTime_whenMinusOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, sqlPartitioningRepository.calculatePartitionStartTime(-1L, 5L));
  }

  /**
   * Test {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long SqlPartitioningRepository.calculatePartitionStartTime(long, long)"})
  public void testCalculatePartitionStartTime_whenOne_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, sqlPartitioningRepository.calculatePartitionStartTime(1L, 5L));
  }

  /**
   * Test {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link SqlPartitioningRepository#calculatePartitionStartTime(long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long SqlPartitioningRepository.calculatePartitionStartTime(long, long)"})
  public void testCalculatePartitionStartTime_whenZero_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, sqlPartitioningRepository.calculatePartitionStartTime(0L, 5L));
  }

  /**
   * Test {@link SqlPartitioningRepository#getJdbcTemplate()}.
   *
   * <p>Method under test: {@link SqlPartitioningRepository#getJdbcTemplate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JdbcTemplate SqlPartitioningRepository.getJdbcTemplate()"})
  public void testGetJdbcTemplate() {
    // Arrange, Act and Assert
    assertNull(new SqlPartitioningRepository().getJdbcTemplate());
  }
}
