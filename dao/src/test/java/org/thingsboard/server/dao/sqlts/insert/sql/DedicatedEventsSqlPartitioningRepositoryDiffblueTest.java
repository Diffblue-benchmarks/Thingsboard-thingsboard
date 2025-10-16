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

import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.thingsboard.server.dao.timeseries.SqlPartition;

@RunWith(MockitoJUnitRunner.class)
public class DedicatedEventsSqlPartitioningRepositoryDiffblueTest {
  @InjectMocks
  private DedicatedEventsSqlPartitioningRepository dedicatedEventsSqlPartitioningRepository;

  @Mock private JdbcTemplate jdbcTemplate;

  /**
   * Test {@link DedicatedEventsSqlPartitioningRepository#save(SqlPartition)}.
   *
   * <p>Method under test: {@link DedicatedEventsSqlPartitioningRepository#save(SqlPartition)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DedicatedEventsSqlPartitioningRepository.save(SqlPartition)"})
  public void testSave() throws DataAccessException {
    // Arrange
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());
    SqlPartition partition = new SqlPartition("Table", 1L, 1L, "2020-03-01");

    // Act
    dedicatedEventsSqlPartitioningRepository.save(partition);

    // Assert
    verify(jdbcTemplate)
        .execute(
            "CREATE TABLE IF NOT EXISTS Table_2020-03-01 PARTITION OF Table FOR VALUES FROM (1) TO (1)");
  }

  /**
   * Test {@link DedicatedEventsSqlPartitioningRepository#createPartitionIfNotExists(String, long,
   * long)}.
   *
   * <ul>
   *   <li>When {@code Table}.
   *   <li>Then calls {@link JdbcTemplate#execute(String)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DedicatedEventsSqlPartitioningRepository#createPartitionIfNotExists(String, long, long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DedicatedEventsSqlPartitioningRepository.createPartitionIfNotExists(String, long, long)"
  })
  public void testCreatePartitionIfNotExists_whenTable_thenCallsExecute()
      throws DataAccessException {
    // Arrange
    doNothing().when(jdbcTemplate).execute(Mockito.<String>any());

    // Act
    dedicatedEventsSqlPartitioningRepository.createPartitionIfNotExists("Table", 1L, 1L);

    // Assert
    verify(jdbcTemplate)
        .execute(
            "CREATE TABLE IF NOT EXISTS Table_1 PARTITION OF Table FOR VALUES FROM (1) TO (2)");
  }

  /**
   * Test {@link DedicatedEventsSqlPartitioningRepository#getJdbcTemplate()}.
   *
   * <p>Method under test: {@link DedicatedEventsSqlPartitioningRepository#getJdbcTemplate()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JdbcTemplate DedicatedEventsSqlPartitioningRepository.getJdbcTemplate()"})
  public void testGetJdbcTemplate() {
    // Arrange, Act and Assert
    assertNull(new DedicatedEventsSqlPartitioningRepository().getJdbcTemplate());
  }
}
