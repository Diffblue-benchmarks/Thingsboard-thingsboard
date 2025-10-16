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
package org.thingsboard.server.dao.sqlts.insert.timescale;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sqlts.timescale.ts.TimescaleTsKvEntity;

@RunWith(MockitoJUnitRunner.class)
public class TimescaleInsertTsRepositoryDiffblueTest {
  @Mock private JdbcTemplate jdbcTemplate;

  @InjectMocks private TimescaleInsertTsRepository timescaleInsertTsRepository;

  /**
   * Test {@link TimescaleInsertTsRepository#saveOrUpdate(List)}.
   *
   * <ul>
   *   <li>Given {@link TimescaleTsKvEntity#TimescaleTsKvEntity()} AggValuesCount is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleInsertTsRepository#saveOrUpdate(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimescaleInsertTsRepository.saveOrUpdate(List)"})
  public void testSaveOrUpdate_givenTimescaleTsKvEntityAggValuesCountIsFortyTwo()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.batchUpdate(
            Mockito.<String>any(), Mockito.<BatchPreparedStatementSetter>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    timescaleTsKvEntity.setJsonValue("42");
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setLongValue(42L);
    timescaleTsKvEntity.setStrKey(
        "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES(?, ?, ?, ?, ?, ?,"
            + " ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v ="
            + " ?, dbl_v = ?, json_v = cast(? AS json);");
    timescaleTsKvEntity.setStrValue("42");
    timescaleTsKvEntity.setTs(1L);

    TimescaleTsKvEntity timescaleTsKvEntity2 = new TimescaleTsKvEntity();
    timescaleTsKvEntity2.setAggValuesCount(42L);
    timescaleTsKvEntity2.setAggValuesLastTs(1L);
    timescaleTsKvEntity2.setBooleanValue(false);
    timescaleTsKvEntity2.setDoubleValue(1.0d);
    timescaleTsKvEntity2.setEntityId(ModelConstants.NULL_UUID);
    timescaleTsKvEntity2.setJsonValue(
        "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES(?, ?, ?, ?, ?, ?,"
            + " ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v ="
            + " ?, dbl_v = ?, json_v = cast(? AS json);");
    timescaleTsKvEntity2.setKey(0);
    timescaleTsKvEntity2.setLongValue(1L);
    timescaleTsKvEntity2.setStrKey("Str Key");
    timescaleTsKvEntity2.setStrValue(
        "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES(?, ?, ?, ?, ?, ?,"
            + " ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v ="
            + " ?, dbl_v = ?, json_v = cast(? AS json);");
    timescaleTsKvEntity2.setTs(0L);

    ArrayList<TimescaleTsKvEntity> entities = new ArrayList<>();
    entities.add(timescaleTsKvEntity2);
    entities.add(timescaleTsKvEntity);

    // Act
    timescaleInsertTsRepository.saveOrUpdate(entities);

    // Assert
    verify(jdbcTemplate)
        .batchUpdate(
            eq(
                "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES(?, ?, ?, ?, ?, ?, ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v = ?, dbl_v = ?, json_v = cast(? AS json);"),
            isA(BatchPreparedStatementSetter.class));
  }

  /**
   * Test {@link TimescaleInsertTsRepository#saveOrUpdate(List)}.
   *
   * <ul>
   *   <li>Given {@link TimescaleTsKvEntity#TimescaleTsKvEntity()} AggValuesCount is three.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleInsertTsRepository#saveOrUpdate(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimescaleInsertTsRepository.saveOrUpdate(List)"})
  public void testSaveOrUpdate_givenTimescaleTsKvEntityAggValuesCountIsThree()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.batchUpdate(
            Mockito.<String>any(), Mockito.<BatchPreparedStatementSetter>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    TimescaleTsKvEntity timescaleTsKvEntity = new TimescaleTsKvEntity();
    timescaleTsKvEntity.setAggValuesCount(3L);
    timescaleTsKvEntity.setAggValuesLastTs(42L);
    timescaleTsKvEntity.setBooleanValue(true);
    timescaleTsKvEntity.setDoubleValue(10.0d);
    timescaleTsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    timescaleTsKvEntity.setJsonValue("42");
    timescaleTsKvEntity.setKey(1);
    timescaleTsKvEntity.setLongValue(42L);
    timescaleTsKvEntity.setStrKey(
        "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES(?, ?, ?, ?, ?, ?,"
            + " ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v ="
            + " ?, dbl_v = ?, json_v = cast(? AS json);");
    timescaleTsKvEntity.setStrValue("42");
    timescaleTsKvEntity.setTs(1L);

    ArrayList<TimescaleTsKvEntity> entities = new ArrayList<>();
    entities.add(timescaleTsKvEntity);

    // Act
    timescaleInsertTsRepository.saveOrUpdate(entities);

    // Assert
    verify(jdbcTemplate)
        .batchUpdate(
            eq(
                "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES(?, ?, ?, ?, ?, ?, ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v = ?, dbl_v = ?, json_v = cast(? AS json);"),
            isA(BatchPreparedStatementSetter.class));
  }

  /**
   * Test {@link TimescaleInsertTsRepository#saveOrUpdate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TimescaleInsertTsRepository#saveOrUpdate(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void TimescaleInsertTsRepository.saveOrUpdate(List)"})
  public void testSaveOrUpdate_whenArrayList() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.batchUpdate(
            Mockito.<String>any(), Mockito.<BatchPreparedStatementSetter>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    // Act
    timescaleInsertTsRepository.saveOrUpdate(new ArrayList<>());

    // Assert
    verify(jdbcTemplate)
        .batchUpdate(
            eq(
                "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES(?, ?, ?, ?, ?, ?, ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v = ?, dbl_v = ?, json_v = cast(? AS json);"),
            isA(BatchPreparedStatementSetter.class));
  }
}
