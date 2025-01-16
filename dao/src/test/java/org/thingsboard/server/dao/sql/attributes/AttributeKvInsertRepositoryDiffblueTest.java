package org.thingsboard.server.dao.sql.attributes;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyDouble;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
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
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class AttributeKvInsertRepositoryDiffblueTest {
  @Autowired
  private AttributeKvInsertRepository attributeKvInsertRepository;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test
   * {@link AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}.
   * <ul>
   *   <li>Then calls {@link PreparedStatement#setBoolean(int, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AttributeKvInsertRepository#setOnBatchUpdateValues(PreparedStatement, int, List)}
   */
  @Test
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

    // Assert that nothing has changed
    verify(ps).setBoolean(eq(4), eq(true));
    verify(ps).setDouble(eq(3), eq(10.0d));
    verify(ps, atLeast(1)).setInt(anyInt(), eq(1));
    verify(ps, atLeast(1)).setLong(anyInt(), anyLong());
    verify(ps).setObject(eq(7), isA(Object.class));
    verify(ps, atLeast(1)).setString(anyInt(), eq("42"));
  }

  /**
   * Test
   * {@link AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}.
   * <ul>
   *   <li>Then calls {@link PreparedStatement#setBoolean(int, boolean)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AttributeKvInsertRepository#setOnInsertOrUpdateValues(PreparedStatement, int, List)}
   */
  @Test
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

    // Assert that nothing has changed
    verify(ps, atLeast(1)).setBoolean(anyInt(), eq(true));
    verify(ps, atLeast(1)).setDouble(anyInt(), eq(10.0d));
    verify(ps, atLeast(1)).setInt(anyInt(), eq(1));
    verify(ps, atLeast(1)).setLong(anyInt(), anyLong());
    verify(ps).setObject(eq(1), isA(Object.class));
    verify(ps, atLeast(1)).setString(anyInt(), eq("42"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeKvInsertRepository#getBatchUpdateQuery()}
   *   <li>{@link AttributeKvInsertRepository#getInsertOrUpdateQuery()}
   * </ul>
   */
  @Test
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
    assertEquals("UPDATE attribute_kv SET str_v = ?, long_v = ?, dbl_v = ?, bool_v = ?, json_v =  cast(? AS json),"
        + " last_update_ts = ?, version = nextval('attribute_kv_version_seq') WHERE entity_id = ? and attribute_type"
        + " =? and attribute_key = ? RETURNING version;", actualBatchUpdateQuery);
  }
}
