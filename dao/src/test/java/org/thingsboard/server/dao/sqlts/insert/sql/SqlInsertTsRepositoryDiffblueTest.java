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
import org.thingsboard.server.dao.model.sqlts.ts.TsKvEntity;

@RunWith(MockitoJUnitRunner.class)
public class SqlInsertTsRepositoryDiffblueTest {
  @Mock private JdbcTemplate jdbcTemplate;

  @InjectMocks private SqlInsertTsRepository sqlInsertTsRepository;

  /**
   * Test {@link SqlInsertTsRepository#saveOrUpdate(List)}.
   *
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()} AggValuesCount is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link SqlInsertTsRepository#saveOrUpdate(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SqlInsertTsRepository.saveOrUpdate(List)"})
  public void testSaveOrUpdate_givenTsKvEntityAggValuesCountIsFortyTwo()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.batchUpdate(
            Mockito.<String>any(), Mockito.<BatchPreparedStatementSetter>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setLongValue(42L);
    tsKvEntity.setStrKey(
        "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES (?, ?, ?, ?, ?,"
            + " ?, ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v"
            + " = ?, dbl_v = ?, json_v = cast(? AS json);");
    tsKvEntity.setStrValue("42");
    tsKvEntity.setTs(1L);

    TsKvEntity tsKvEntity2 = new TsKvEntity();
    tsKvEntity2.setAggValuesCount(42L);
    tsKvEntity2.setAggValuesLastTs(1L);
    tsKvEntity2.setBooleanValue(false);
    tsKvEntity2.setDoubleValue(1.0d);
    tsKvEntity2.setEntityId(ModelConstants.NULL_UUID);
    tsKvEntity2.setJsonValue(
        "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES (?, ?, ?, ?, ?,"
            + " ?, ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v"
            + " = ?, dbl_v = ?, json_v = cast(? AS json);");
    tsKvEntity2.setKey(0);
    tsKvEntity2.setLongValue(1L);
    tsKvEntity2.setStrKey("Str Key");
    tsKvEntity2.setStrValue(
        "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES (?, ?, ?, ?, ?,"
            + " ?, ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v"
            + " = ?, dbl_v = ?, json_v = cast(? AS json);");
    tsKvEntity2.setTs(0L);

    ArrayList<TsKvEntity> entities = new ArrayList<>();
    entities.add(tsKvEntity2);
    entities.add(tsKvEntity);

    // Act
    sqlInsertTsRepository.saveOrUpdate(entities);

    // Assert
    verify(jdbcTemplate)
        .batchUpdate(
            eq(
                "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES (?, ?, ?, ?, ?, ?, ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v = ?, dbl_v = ?, json_v = cast(? AS json);"),
            isA(BatchPreparedStatementSetter.class));
  }

  /**
   * Test {@link SqlInsertTsRepository#saveOrUpdate(List)}.
   *
   * <ul>
   *   <li>Given {@link TsKvEntity#TsKvEntity()} AggValuesCount is three.
   *   <li>When {@link ArrayList#ArrayList()} add {@link TsKvEntity#TsKvEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link SqlInsertTsRepository#saveOrUpdate(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SqlInsertTsRepository.saveOrUpdate(List)"})
  public void testSaveOrUpdate_givenTsKvEntityAggValuesCountIsThree_whenArrayListAddTsKvEntity()
      throws DataAccessException {
    // Arrange
    when(jdbcTemplate.batchUpdate(
            Mockito.<String>any(), Mockito.<BatchPreparedStatementSetter>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    TsKvEntity tsKvEntity = new TsKvEntity();
    tsKvEntity.setAggValuesCount(3L);
    tsKvEntity.setAggValuesLastTs(42L);
    tsKvEntity.setBooleanValue(true);
    tsKvEntity.setDoubleValue(10.0d);
    tsKvEntity.setEntityId(ModelConstants.NULL_UUID);
    tsKvEntity.setJsonValue("42");
    tsKvEntity.setKey(1);
    tsKvEntity.setLongValue(42L);
    tsKvEntity.setStrKey(
        "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES (?, ?, ?, ?, ?,"
            + " ?, ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v"
            + " = ?, dbl_v = ?, json_v = cast(? AS json);");
    tsKvEntity.setStrValue("42");
    tsKvEntity.setTs(1L);

    ArrayList<TsKvEntity> entities = new ArrayList<>();
    entities.add(tsKvEntity);

    // Act
    sqlInsertTsRepository.saveOrUpdate(entities);

    // Assert
    verify(jdbcTemplate)
        .batchUpdate(
            eq(
                "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES (?, ?, ?, ?, ?, ?, ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v = ?, dbl_v = ?, json_v = cast(? AS json);"),
            isA(BatchPreparedStatementSetter.class));
  }

  /**
   * Test {@link SqlInsertTsRepository#saveOrUpdate(List)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link SqlInsertTsRepository#saveOrUpdate(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void SqlInsertTsRepository.saveOrUpdate(List)"})
  public void testSaveOrUpdate_whenArrayList() throws DataAccessException {
    // Arrange
    when(jdbcTemplate.batchUpdate(
            Mockito.<String>any(), Mockito.<BatchPreparedStatementSetter>any()))
        .thenReturn(new int[] {1, -1, 1, -1});

    // Act
    sqlInsertTsRepository.saveOrUpdate(new ArrayList<>());

    // Assert
    verify(jdbcTemplate)
        .batchUpdate(
            eq(
                "INSERT INTO ts_kv (entity_id, key, ts, bool_v, str_v, long_v, dbl_v, json_v) VALUES (?, ?, ?, ?, ?, ?, ?, cast(? AS json)) ON CONFLICT (entity_id, key, ts) DO UPDATE SET bool_v = ?, str_v = ?, long_v = ?, dbl_v = ?, json_v = cast(? AS json);"),
            isA(BatchPreparedStatementSetter.class));
  }
}
