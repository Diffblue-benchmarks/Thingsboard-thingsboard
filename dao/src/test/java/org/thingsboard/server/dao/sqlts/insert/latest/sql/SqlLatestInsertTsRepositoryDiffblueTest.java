package org.thingsboard.server.dao.sqlts.insert.latest.sql;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sqlts.latest.TsKvLatestEntity;

public class SqlLatestInsertTsRepositoryDiffblueTest {
  /**
   * Test
   * {@link SqlLatestInsertTsRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}.
   * <ul>
   *   <li>Given {@link SQLException#SQLException()}.</li>
   *   <li>Then throw {@link SQLException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link SqlLatestInsertTsRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}
   */
  @Test
  public void testSetOnInsertOrUpdateValues_givenSQLException_thenThrowSQLException() throws SQLException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    SqlLatestInsertTsRepository sqlLatestInsertTsRepository = new SqlLatestInsertTsRepository();
    PreparedStatement ps = mock(PreparedStatement.class);
    doThrow(new SQLException()).when(ps).setObject(anyInt(), Mockito.<Object>any());

    TsKvLatestEntity tsKvLatestEntity = new TsKvLatestEntity();
    tsKvLatestEntity.setAggValuesCount(3L);
    tsKvLatestEntity.setAggValuesLastTs(42L);
    tsKvLatestEntity.setBooleanValue(true);
    tsKvLatestEntity.setDoubleValue(10.0d);
    tsKvLatestEntity.setEntityId(ModelConstants.NULL_UUID);
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
    tsKvLatestEntity2.setEntityId(ModelConstants.NULL_UUID);
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
