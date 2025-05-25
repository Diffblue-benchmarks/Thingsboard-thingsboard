package org.thingsboard.server.dao.sqlts.insert.latest.sql;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.dao.model.sqlts.latest.TsKvLatestEntity;

@RunWith(MockitoJUnitRunner.class)
public class SqlLatestInsertTsRepositoryDiffblueTest {
  @InjectMocks
  private SqlLatestInsertTsRepository sqlLatestInsertTsRepository;

  /**
   * Test {@link SqlLatestInsertTsRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}.
   * <ul>
   *   <li>Then calls {@link PreparedStatement#setNull(int, int)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlLatestInsertTsRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SqlLatestInsertTsRepository.setOnBatchUpdateValues(PreparedStatement, int, List)"})
  public void testSetOnBatchUpdateValues_thenCallsSetNull() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(ps).setNull(anyInt(), anyInt());
    doNothing().when(ps).setLong(anyInt(), anyLong());

    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(null);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);

    TsKvLatestEntity tsKvLatestEntity2 = new TsKvLatestEntity();
    tsKvLatestEntity2.setAggValuesCount(42L);
    tsKvLatestEntity2.setAggValuesLastTs(1L);
    tsKvLatestEntity2.setBooleanValue(false);
    tsKvLatestEntity2.setDoubleValue(0.5d);
    tsKvLatestEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity2.setJsonValue("Json Value");
    tsKvLatestEntity2.setKey(0);
    tsKvLatestEntity2.setLongValue(1L);
    tsKvLatestEntity2.setStrKey("org.thingsboard.server.dao.model.sqlts.latest.TsKvLatestEntity");
    tsKvLatestEntity2.setStrValue("Str Value");
    tsKvLatestEntity2.setTs(0L);
    tsKvLatestEntity2.setVersion(0L);

    ArrayList<TsKvLatestEntity> entities = new ArrayList<>();
    entities.add(tsKvLatestEntity2);
    entities.add(tsKvLatestEntity);

    // Act and Assert
    assertThrows(SQLException.class, () -> sqlLatestInsertTsRepository.setOnBatchUpdateValues(ps, 1, entities));
    verify(ps).setLong(eq(1), eq(1L));
    verify(ps).setNull(eq(2), eq(16));
  }

  /**
   * Test {@link SqlLatestInsertTsRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}.
   * <ul>
   *   <li>When {@link PreparedStatement} {@link PreparedStatement#setLong(int, long)} throw {@link SQLException#SQLException()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlLatestInsertTsRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SqlLatestInsertTsRepository.setOnBatchUpdateValues(PreparedStatement, int, List)"})
  public void testSetOnBatchUpdateValues_whenPreparedStatementSetLongThrowSQLException() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(ps).setLong(anyInt(), anyLong());

    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);

    TsKvLatestEntity tsKvLatestEntity2 = new TsKvLatestEntity();
    tsKvLatestEntity2.setAggValuesCount(42L);
    tsKvLatestEntity2.setAggValuesLastTs(1L);
    tsKvLatestEntity2.setBooleanValue(false);
    tsKvLatestEntity2.setDoubleValue(0.5d);
    tsKvLatestEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity2.setJsonValue("Json Value");
    tsKvLatestEntity2.setKey(0);
    tsKvLatestEntity2.setLongValue(1L);
    tsKvLatestEntity2.setStrKey("org.thingsboard.server.dao.model.sqlts.latest.TsKvLatestEntity");
    tsKvLatestEntity2.setStrValue("Str Value");
    tsKvLatestEntity2.setTs(0L);
    tsKvLatestEntity2.setVersion(0L);

    ArrayList<TsKvLatestEntity> entities = new ArrayList<>();
    entities.add(tsKvLatestEntity2);
    entities.add(tsKvLatestEntity);

    // Act and Assert
    assertThrows(SQLException.class, () -> sqlLatestInsertTsRepository.setOnBatchUpdateValues(ps, 1, entities));
    verify(ps).setLong(eq(1), eq(1L));
  }

  /**
   * Test {@link SqlLatestInsertTsRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}.
   * <ul>
   *   <li>Given {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SqlLatestInsertTsRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SqlLatestInsertTsRepository.setOnInsertOrUpdateValues(PreparedStatement, int, List)"})
  public void testSetOnInsertOrUpdateValues_givenSQLException_thenThrowSQLException() throws SQLException {
    // Arrange
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(ps).setObject(anyInt(), Mockito.<Object>any());

    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity.setJsonValue("42");
    tsKvLatestEntity.setKey(1);
    tsKvLatestEntity.setLongValue(42L);
    tsKvLatestEntity.setStrKey("Str Key");
    tsKvLatestEntity.setStrValue("42");
    tsKvLatestEntity.setTs(1L);
    tsKvLatestEntity.setVersion(1L);

    TsKvLatestEntity tsKvLatestEntity2 = new TsKvLatestEntity();
    tsKvLatestEntity2.setAggValuesCount(42L);
    tsKvLatestEntity2.setAggValuesLastTs(1L);
    tsKvLatestEntity2.setBooleanValue(false);
    tsKvLatestEntity2.setDoubleValue(0.5d);
    tsKvLatestEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    tsKvLatestEntity2.setJsonValue("Json Value");
    tsKvLatestEntity2.setKey(0);
    tsKvLatestEntity2.setLongValue(1L);
    tsKvLatestEntity2.setStrKey("org.thingsboard.server.dao.model.sqlts.latest.TsKvLatestEntity");
    tsKvLatestEntity2.setStrValue("Str Value");
    tsKvLatestEntity2.setTs(0L);
    tsKvLatestEntity2.setVersion(0L);

    ArrayList<TsKvLatestEntity> insertEntities = new ArrayList<>();
    insertEntities.add(tsKvLatestEntity2);
    insertEntities.add(tsKvLatestEntity);

    // Act and Assert
    assertThrows(SQLException.class,
        () -> sqlLatestInsertTsRepository.setOnInsertOrUpdateValues(ps, 1, insertEntities));
    verify(ps).setObject(eq(1), isA(Object.class));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SqlLatestInsertTsRepository#getBatchUpdateQuery()}
   *   <li>{@link SqlLatestInsertTsRepository#getInsertOrUpdateQuery()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String SqlLatestInsertTsRepository.getBatchUpdateQuery()",
      "String SqlLatestInsertTsRepository.getInsertOrUpdateQuery()"})
  public void testGettersAndSetters() {
    // Arrange
    SqlLatestInsertTsRepository sqlLatestInsertTsRepository = new SqlLatestInsertTsRepository();

    // Act
    String actualBatchUpdateQuery = sqlLatestInsertTsRepository.getBatchUpdateQuery();

    // Assert
    assertNull(actualBatchUpdateQuery);
    assertNull(sqlLatestInsertTsRepository.getInsertOrUpdateQuery());
  }
}
