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
package org.thingsboard.server.dao.sql.attributes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AttributeKvCompositeKey;
import org.thingsboard.server.dao.model.sql.AttributeKvEntity;

@ContextConfiguration(classes = {AttributeKvInsertRepository.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class AttributeKvInsertRepositoryDiffblueTest {
  @Autowired private AttributeKvInsertRepository attributeKvInsertRepository;

  @MockBean private JdbcTemplate jdbcTemplate;

  @MockBean private TransactionTemplate transactionTemplate;

  /**
   * Test {@link AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnBatchUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnBatchUpdateValues_givenAttributeKvEntityDoubleValueIsNull()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setNull(anyInt(), anyInt());
    doNothing().when(ps).setInt(anyInt(), anyInt());
    doNothing().when(ps).setLong(anyInt(), anyLong());
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> entities = new ArrayList<>();
    entities.add(attributeKvEntity2);
    entities.add(attributeKvEntity);

    // Act
    attributeKvInsertRepository.setOnBatchUpdateValues(ps, 1, entities);

    // Assert
    verify(ps, atLeast(1)).setInt(anyInt(), eq(1));
    verify(ps, atLeast(1)).setLong(anyInt(), anyLong());
    verify(ps, atLeast(1)).setNull(anyInt(), anyInt());
    verify(ps).setObject(eq(7), isA(Object.class));
    verify(ps, atLeast(1)).setString(anyInt(), eq("42"));
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnBatchUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnBatchUpdateValues_givenAttributeKvEntityDoubleValueIsNull2()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(ps).setNull(anyInt(), anyInt());
    doNothing().when(ps).setLong(anyInt(), anyLong());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> entities = new ArrayList<>();
    entities.add(attributeKvEntity2);
    entities.add(attributeKvEntity);

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> attributeKvInsertRepository.setOnBatchUpdateValues(ps, 1, entities));
    verify(ps).setLong(2, 42L);
    verify(ps).setNull(3, 8);
    verify(ps).setString(1, "42");
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) LongValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnBatchUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnBatchUpdateValues_givenAttributeKvEntityLongValueIsNull()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setNull(anyInt(), anyInt());
    doNothing().when(ps).setDouble(anyInt(), anyDouble());
    doNothing().when(ps).setInt(anyInt(), anyInt());
    doNothing().when(ps).setLong(anyInt(), anyLong());
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> entities = new ArrayList<>();
    entities.add(attributeKvEntity2);
    entities.add(attributeKvEntity);

    // Act
    attributeKvInsertRepository.setOnBatchUpdateValues(ps, 1, entities);

    // Assert
    verify(ps).setDouble(3, 10.0d);
    verify(ps, atLeast(1)).setInt(anyInt(), eq(1));
    verify(ps).setLong(6, 1L);
    verify(ps, atLeast(1)).setNull(anyInt(), anyInt());
    verify(ps).setObject(eq(7), isA(Object.class));
    verify(ps, atLeast(1)).setString(anyInt(), eq("42"));
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) LongValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnBatchUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnBatchUpdateValues_givenAttributeKvEntityLongValueIsNull2()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(ps).setNull(anyInt(), anyInt());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> entities = new ArrayList<>();
    entities.add(attributeKvEntity2);
    entities.add(attributeKvEntity);

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> attributeKvInsertRepository.setOnBatchUpdateValues(ps, 1, entities));
    verify(ps).setNull(2, -5);
    verify(ps).setString(1, "42");
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#setBoolean(int, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnBatchUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnBatchUpdateValues_thenCallsSetBoolean() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setBoolean(anyInt(), anyBoolean());
    doNothing().when(ps).setDouble(anyInt(), anyDouble());
    doNothing().when(ps).setInt(anyInt(), anyInt());
    doNothing().when(ps).setLong(anyInt(), anyLong());
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> entities = new ArrayList<>();
    entities.add(attributeKvEntity2);
    entities.add(attributeKvEntity);

    // Act
    attributeKvInsertRepository.setOnBatchUpdateValues(ps, 1, entities);

    // Assert
    verify(ps).setBoolean(4, true);
    verify(ps).setDouble(3, 10.0d);
    verify(ps, atLeast(1)).setInt(anyInt(), eq(1));
    verify(ps, atLeast(1)).setLong(anyInt(), anyLong());
    verify(ps).setObject(eq(7), isA(Object.class));
    verify(ps, atLeast(1)).setString(anyInt(), eq("42"));
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#setDouble(int, double)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnBatchUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnBatchUpdateValues_thenCallsSetDouble() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setNull(anyInt(), anyInt());
    doNothing().when(ps).setDouble(anyInt(), anyDouble());
    doNothing().when(ps).setInt(anyInt(), anyInt());
    doNothing().when(ps).setLong(anyInt(), anyLong());
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> entities = new ArrayList<>();
    entities.add(attributeKvEntity2);
    entities.add(attributeKvEntity);

    // Act
    attributeKvInsertRepository.setOnBatchUpdateValues(ps, 1, entities);

    // Assert
    verify(ps).setDouble(3, 10.0d);
    verify(ps, atLeast(1)).setInt(anyInt(), eq(1));
    verify(ps, atLeast(1)).setLong(anyInt(), anyLong());
    verify(ps).setNull(4, 16);
    verify(ps).setObject(eq(7), isA(Object.class));
    verify(ps, atLeast(1)).setString(anyInt(), eq("42"));
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} throw {@link
   *       SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnBatchUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnBatchUpdateValues_whenPreparedStatementSetNullThrowSQLException()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(ps).setNull(anyInt(), anyInt());
    doNothing().when(ps).setDouble(anyInt(), anyDouble());
    doNothing().when(ps).setLong(anyInt(), anyLong());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> entities = new ArrayList<>();
    entities.add(attributeKvEntity2);
    entities.add(attributeKvEntity);

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> attributeKvInsertRepository.setOnBatchUpdateValues(ps, 1, entities));
    verify(ps).setDouble(3, 10.0d);
    verify(ps).setLong(2, 42L);
    verify(ps).setNull(4, 16);
    verify(ps).setString(1, "42");
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setString(int, String)} throw
   *       {@link SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnBatchUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnBatchUpdateValues_whenPreparedStatementSetStringThrowSQLException()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> entities = new ArrayList<>();
    entities.add(attributeKvEntity2);
    entities.add(attributeKvEntity);

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> attributeKvInsertRepository.setOnBatchUpdateValues(ps, 1, entities));
    verify(ps).setString(1, "42");
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnInsertOrUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnInsertOrUpdateValues_givenAttributeKvEntityDoubleValueIsNull()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setNull(anyInt(), anyInt());
    doNothing().when(ps).setInt(anyInt(), anyInt());
    doNothing().when(ps).setLong(anyInt(), anyLong());
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> insertEntities = new ArrayList<>();
    insertEntities.add(attributeKvEntity2);
    insertEntities.add(attributeKvEntity);

    // Act
    attributeKvInsertRepository.setOnInsertOrUpdateValues(ps, 1, insertEntities);

    // Assert
    verify(ps, atLeast(1)).setInt(anyInt(), eq(1));
    verify(ps, atLeast(1)).setLong(anyInt(), anyLong());
    verify(ps, atLeast(1)).setNull(anyInt(), anyInt());
    verify(ps).setObject(eq(1), isA(Object.class));
    verify(ps, atLeast(1)).setString(anyInt(), eq("42"));
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) DoubleValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnInsertOrUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnInsertOrUpdateValues_givenAttributeKvEntityDoubleValueIsNull2()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(ps).setNull(anyInt(), anyInt());
    doNothing().when(ps).setInt(anyInt(), anyInt());
    doNothing().when(ps).setLong(anyInt(), anyLong());
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(null);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> insertEntities = new ArrayList<>();
    insertEntities.add(attributeKvEntity2);
    insertEntities.add(attributeKvEntity);

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> attributeKvInsertRepository.setOnInsertOrUpdateValues(ps, 1, insertEntities));
    verify(ps, atLeast(1)).setInt(anyInt(), eq(1));
    verify(ps, atLeast(1)).setLong(anyInt(), eq(42L));
    verify(ps).setNull(6, 8);
    verify(ps).setObject(eq(1), isA(Object.class));
    verify(ps, atLeast(1)).setString(anyInt(), eq("42"));
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) LongValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnInsertOrUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnInsertOrUpdateValues_givenAttributeKvEntityLongValueIsNull()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setNull(anyInt(), anyInt());
    doNothing().when(ps).setDouble(anyInt(), anyDouble());
    doNothing().when(ps).setInt(anyInt(), anyInt());
    doNothing().when(ps).setLong(anyInt(), anyLong());
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> insertEntities = new ArrayList<>();
    insertEntities.add(attributeKvEntity2);
    insertEntities.add(attributeKvEntity);

    // Act
    attributeKvInsertRepository.setOnInsertOrUpdateValues(ps, 1, insertEntities);

    // Assert
    verify(ps, atLeast(1)).setDouble(anyInt(), eq(10.0d));
    verify(ps, atLeast(1)).setInt(anyInt(), eq(1));
    verify(ps, atLeast(1)).setLong(anyInt(), eq(1L));
    verify(ps, atLeast(1)).setNull(anyInt(), anyInt());
    verify(ps).setObject(eq(1), isA(Object.class));
    verify(ps, atLeast(1)).setString(anyInt(), eq("42"));
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int,
   * List)}.
   *
   * <ul>
   *   <li>Given {@link AttributeKvEntity} (default constructor) LongValue is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnInsertOrUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnInsertOrUpdateValues_givenAttributeKvEntityLongValueIsNull2()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(ps).setNull(anyInt(), anyInt());
    doNothing().when(ps).setInt(anyInt(), anyInt());
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(null);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> insertEntities = new ArrayList<>();
    insertEntities.add(attributeKvEntity2);
    insertEntities.add(attributeKvEntity);

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> attributeKvInsertRepository.setOnInsertOrUpdateValues(ps, 1, insertEntities));
    verify(ps, atLeast(1)).setInt(anyInt(), eq(1));
    verify(ps).setNull(5, -5);
    verify(ps).setObject(eq(1), isA(Object.class));
    verify(ps, atLeast(1)).setString(anyInt(), eq("42"));
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#setBoolean(int, boolean)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnInsertOrUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnInsertOrUpdateValues_thenCallsSetBoolean() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setBoolean(anyInt(), anyBoolean());
    doNothing().when(ps).setDouble(anyInt(), anyDouble());
    doNothing().when(ps).setInt(anyInt(), anyInt());
    doNothing().when(ps).setLong(anyInt(), anyLong());
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> insertEntities = new ArrayList<>();
    insertEntities.add(attributeKvEntity2);
    insertEntities.add(attributeKvEntity);

    // Act
    attributeKvInsertRepository.setOnInsertOrUpdateValues(ps, 1, insertEntities);

    // Assert
    verify(ps, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(ps, atLeast(1)).setDouble(anyInt(), eq(10.0d));
    verify(ps, atLeast(1)).setInt(anyInt(), eq(1));
    verify(ps, atLeast(1)).setLong(anyInt(), anyLong());
    verify(ps).setObject(eq(1), isA(Object.class));
    verify(ps, atLeast(1)).setString(anyInt(), eq("42"));
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link PreparedStatement#setDouble(int, double)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnInsertOrUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnInsertOrUpdateValues_thenCallsSetDouble() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doNothing().when(ps).setNull(anyInt(), anyInt());
    doNothing().when(ps).setDouble(anyInt(), anyDouble());
    doNothing().when(ps).setInt(anyInt(), anyInt());
    doNothing().when(ps).setLong(anyInt(), anyLong());
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> insertEntities = new ArrayList<>();
    insertEntities.add(attributeKvEntity2);
    insertEntities.add(attributeKvEntity);

    // Act
    attributeKvInsertRepository.setOnInsertOrUpdateValues(ps, 1, insertEntities);

    // Assert
    verify(ps, atLeast(1)).setDouble(anyInt(), eq(10.0d));
    verify(ps, atLeast(1)).setInt(anyInt(), eq(1));
    verify(ps, atLeast(1)).setLong(anyInt(), anyLong());
    verify(ps, atLeast(1)).setNull(anyInt(), eq(16));
    verify(ps).setObject(eq(1), isA(Object.class));
    verify(ps, atLeast(1)).setString(anyInt(), eq("42"));
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int,
   * List)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setNull(int, int)} throw {@link
   *       SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnInsertOrUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnInsertOrUpdateValues_whenPreparedStatementSetNullThrowSQLException()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(ps).setNull(anyInt(), anyInt());
    doNothing().when(ps).setDouble(anyInt(), anyDouble());
    doNothing().when(ps).setInt(anyInt(), anyInt());
    doNothing().when(ps).setLong(anyInt(), anyLong());
    doNothing().when(ps).setObject(anyInt(), Mockito.<Object>any());
    doNothing().when(ps).setString(anyInt(), Mockito.<String>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(null);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> insertEntities = new ArrayList<>();
    insertEntities.add(attributeKvEntity2);
    insertEntities.add(attributeKvEntity);

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> attributeKvInsertRepository.setOnInsertOrUpdateValues(ps, 1, insertEntities));
    verify(ps, atLeast(1)).setDouble(anyInt(), eq(10.0d));
    verify(ps, atLeast(1)).setInt(anyInt(), eq(1));
    verify(ps, atLeast(1)).setLong(anyInt(), eq(42L));
    verify(ps).setNull(7, 16);
    verify(ps).setObject(eq(1), isA(Object.class));
    verify(ps, atLeast(1)).setString(anyInt(), eq("42"));
  }

  /**
   * Test {@link AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int,
   * List)}.
   *
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setObject(int, Object)} throw
   *       {@link SQLException#SQLException()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void AttributeKvInsertRepository.setOnInsertOrUpdateValues(PreparedStatement, int, List)"
  })
  public void testSetOnInsertOrUpdateValues_whenPreparedStatementSetObjectThrowSQLException()
      throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(ps).setObject(anyInt(), Mockito.<Object>any());

    AttributeKvCompositeKey id = new AttributeKvCompositeKey();
    id.setAttributeKey(1);
    id.setAttributeType(1);
    id.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity = new AttributeKvEntity();
    attributeKvEntity.setBooleanValue(true);
    attributeKvEntity.setDoubleValue(10.0d);
    attributeKvEntity.setId(id);
    attributeKvEntity.setJsonValue("42");
    attributeKvEntity.setLastUpdateTs(1L);
    attributeKvEntity.setLongValue(42L);
    attributeKvEntity.setStrKey("Str Key");
    attributeKvEntity.setStrValue("42");
    attributeKvEntity.setVersion(1L);

    AttributeKvCompositeKey id2 = new AttributeKvCompositeKey();
    id2.setAttributeKey(0);
    id2.setAttributeType(0);
    id2.setEntityId(ModelConstants.NULL_UUID);

    AttributeKvEntity attributeKvEntity2 = new AttributeKvEntity();
    attributeKvEntity2.setBooleanValue(false);
    attributeKvEntity2.setDoubleValue(0.5d);
    attributeKvEntity2.setId(id2);
    attributeKvEntity2.setJsonValue("Json Value");
    attributeKvEntity2.setLastUpdateTs(0L);
    attributeKvEntity2.setLongValue(1L);
    attributeKvEntity2.setStrKey("org.thingsboard.server.dao.model.sql.AttributeKvEntity");
    attributeKvEntity2.setStrValue("Str Value");
    attributeKvEntity2.setVersion(0L);

    ArrayList<AttributeKvEntity> insertEntities = new ArrayList<>();
    insertEntities.add(attributeKvEntity2);
    insertEntities.add(attributeKvEntity);

    // Act and Assert
    assertThrows(
        SQLException.class,
        () -> attributeKvInsertRepository.setOnInsertOrUpdateValues(ps, 1, insertEntities));
    verify(ps).setObject(eq(1), isA(Object.class));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AttributeKvInsertRepository#getBatchUpdateQuery()}
   *   <li>{@link AttributeKvInsertRepository#getInsertOrUpdateQuery()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String AttributeKvInsertRepository.getBatchUpdateQuery()",
    "String AttributeKvInsertRepository.getInsertOrUpdateQuery()"
  })
  public void testGettersAndSetters() {
    // Arrange
    AttributeKvInsertRepository attributeKvInsertRepository = new AttributeKvInsertRepository();

    // Act
    String actualBatchUpdateQuery = attributeKvInsertRepository.getBatchUpdateQuery();

    // Assert
    assertEquals(
        "INSERT INTO attribute_kv (entity_id, attribute_type, attribute_key, str_v, long_v, dbl_v, bool_v,"
            + " json_v, last_update_ts, version) VALUES(?, ?, ?, ?, ?, ?, ?,  cast(? AS json), ?, nextval('attribute"
            + "_kv_version_seq')) ON CONFLICT (entity_id, attribute_type, attribute_key) DO UPDATE SET str_v = ?,"
            + " long_v = ?, dbl_v = ?, bool_v = ?, json_v =  cast(? AS json), last_update_ts = ?, version ="
            + " nextval('attribute_kv_version_seq') RETURNING version;",
        attributeKvInsertRepository.getInsertOrUpdateQuery());
    assertEquals(
        "UPDATE attribute_kv SET str_v = ?, long_v = ?, dbl_v = ?, bool_v = ?, json_v =  cast(? AS json),"
            + " last_update_ts = ?, version = nextval('attribute_kv_version_seq') WHERE entity_id = ? and attribute_type"
            + " =? and attribute_key = ? RETURNING version;",
        actualBatchUpdateQuery);
  }
}
