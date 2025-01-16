package org.thingsboard.server.dao;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.AttributeKvCompositeKey;
import org.thingsboard.server.dao.model.sql.AttributeKvEntity;
import org.thingsboard.server.dao.sql.attributes.AttributeKvInsertRepository;

@ContextConfiguration(classes = {AttributeKvInsertRepository.class})
@RunWith(SpringJUnit4ClassRunner.class)
@PropertySource("classpath:application-test.properties")
@EnableConfigurationProperties
@DisabledInAotMode
public class AbstractVersionedInsertRepositoryDiffblueTest {
  @Autowired
  private AbstractVersionedInsertRepository<AttributeKvEntity> abstractVersionedInsertRepository;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link AbstractVersionedInsertRepository#saveOrUpdate(List)}.
   * <ul>
   *   <li>Given {@link AttributeKvCompositeKey#AttributeKvCompositeKey()}
   * AttributeKey is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractVersionedInsertRepository#saveOrUpdate(List)}
   */
  @Test
  public void testSaveOrUpdate_givenAttributeKvCompositeKeyAttributeKeyIsOne() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn(new ArrayList<>());

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

    ArrayList<AttributeKvEntity> entities = new ArrayList<>();
    entities.add(attributeKvEntity);

    // Act
    List<Long> actualSaveOrUpdateResult = abstractVersionedInsertRepository.saveOrUpdate(entities);

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertTrue(actualSaveOrUpdateResult.isEmpty());
  }

  /**
   * Test {@link AbstractVersionedInsertRepository#saveOrUpdate(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractVersionedInsertRepository#saveOrUpdate(List)}
   */
  @Test
  public void testSaveOrUpdate_whenArrayList() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn(new ArrayList<>());

    // Act
    List<Long> actualSaveOrUpdateResult = abstractVersionedInsertRepository.saveOrUpdate(new ArrayList<>());

    // Assert
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
    assertTrue(actualSaveOrUpdateResult.isEmpty());
  }
}
