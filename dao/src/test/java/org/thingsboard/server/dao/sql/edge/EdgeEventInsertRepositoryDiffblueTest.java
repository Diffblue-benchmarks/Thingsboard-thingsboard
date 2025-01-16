package org.thingsboard.server.dao.sql.edge;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.EdgeEventEntity;

@ContextConfiguration(classes = {EdgeEventInsertRepository.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class EdgeEventInsertRepositoryDiffblueTest {
  @Autowired
  private EdgeEventInsertRepository edgeEventInsertRepository;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link EdgeEventInsertRepository#save(List)}.
   * <ul>
   *   <li>Given {@link EdgeEventEntity#EdgeEventEntity()} CreatedTime is one.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link EdgeEventEntity#EdgeEventEntity()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventInsertRepository#save(List)}
   */
  @Test
  public void testSave_givenEdgeEventEntityCreatedTimeIsOne_whenArrayListAddEdgeEventEntity()
      throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn("Execute");

    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    ArrayList<EdgeEventEntity> entities = new ArrayList<>();
    entities.add(edgeEventEntity);

    // Act
    edgeEventInsertRepository.save(entities);

    // Assert that nothing has changed
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test {@link EdgeEventInsertRepository#save(List)}.
   * <ul>
   *   <li>Given {@link EdgeEventEntity#EdgeEventEntity()} CreatedTime is zero.</li>
   *   <li>When {@link ArrayList#ArrayList()} add
   * {@link EdgeEventEntity#EdgeEventEntity()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventInsertRepository#save(List)}
   */
  @Test
  public void testSave_givenEdgeEventEntityCreatedTimeIsZero_whenArrayListAddEdgeEventEntity()
      throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn("Execute");

    EdgeEventEntity edgeEventEntity = new EdgeEventEntity();
    edgeEventEntity.setCreatedTime(1L);
    edgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    edgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    edgeEventEntity.setEdgeEventUid("1234");
    edgeEventEntity.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity.setId(ModelConstants.NULL_UUID);
    edgeEventEntity.setSeqId(1L);
    edgeEventEntity.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity.setTs(1L);
    edgeEventEntity.setUuid(ModelConstants.NULL_UUID);

    EdgeEventEntity edgeEventEntity2 = new EdgeEventEntity();
    edgeEventEntity2.setCreatedTime(0L);
    edgeEventEntity2.setEdgeEventAction(EdgeEventActionType.UPDATED);
    edgeEventEntity2.setEdgeEventType(EdgeEventType.ASSET);
    edgeEventEntity2.setEdgeEventUid("Edge Event Uid");
    edgeEventEntity2.setEdgeId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setEntityBody(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    edgeEventEntity2.setEntityId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setSeqId(2L);
    edgeEventEntity2.setTenantId(ModelConstants.NULL_UUID);
    edgeEventEntity2.setTs(0L);
    edgeEventEntity2.setUuid(ModelConstants.NULL_UUID);

    ArrayList<EdgeEventEntity> entities = new ArrayList<>();
    entities.add(edgeEventEntity2);
    entities.add(edgeEventEntity);

    // Act
    edgeEventInsertRepository.save(entities);

    // Assert that nothing has changed
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }

  /**
   * Test {@link EdgeEventInsertRepository#save(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeEventInsertRepository#save(List)}
   */
  @Test
  public void testSave_whenArrayList() throws TransactionException {
    // Arrange
    when(transactionTemplate.execute(Mockito.<TransactionCallback<Object>>any())).thenReturn("Execute");

    // Act
    edgeEventInsertRepository.save(new ArrayList<>());

    // Assert that nothing has changed
    verify(transactionTemplate).execute(isA(TransactionCallback.class));
  }
}
