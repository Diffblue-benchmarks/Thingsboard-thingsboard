package org.thingsboard.server.dao.rule;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.sql.SQLException;
import java.util.UUID;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.rule.RuleNodeState;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;

@ContextConfiguration(classes = {BaseRuleNodeStateService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class BaseRuleNodeStateServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private BaseRuleNodeStateService baseRuleNodeStateService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private RuleNodeStateDao ruleNodeStateDao;

  /**
   * Test
   * {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId, PageLink)}
   */
  @Test
  public void testFindByRuleNodeId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<RuleNodeState> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeStateDao.findByRuleNodeId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleNodeState> actualFindByRuleNodeIdResult = baseRuleNodeStateService.findByRuleNodeId(
        ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID), BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeStateDao).findByRuleNodeId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindByRuleNodeIdResult.EMPTY_PAGE_DATA, actualFindByRuleNodeIdResult);
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId, PageLink)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId, PageLink)}
   */
  @Test
  public void testFindByRuleNodeId_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRuleNodeStateService.findByRuleNodeId(null,
        new RuleNodeId(ModelConstants.NULL_UUID), BaseRelatedEdgesService.FIRST_PAGE));
    assertThrows(DataValidationException.class, () -> baseRuleNodeStateService
        .findByRuleNodeId(ModelConstants.SYSTEM_TENANT, null, BaseRelatedEdgesService.FIRST_PAGE));
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}.
   * <ul>
   *   <li>Then return {@link RuleNodeState#RuleNodeState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}
   */
  @Test
  public void testFindByRuleNodeIdAndEntityId_thenReturnRuleNodeState() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    when(ruleNodeStateDao.findByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(ruleNodeState);

    // Act
    RuleNodeState actualFindByRuleNodeIdAndEntityIdResult = baseRuleNodeStateService.findByRuleNodeIdAndEntityId(
        ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID), BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(ruleNodeStateDao).findByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertSame(ruleNodeState, actualFindByRuleNodeIdAndEntityIdResult);
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}
   */
  @Test
  public void testFindByRuleNodeIdAndEntityId_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRuleNodeStateService
        .findByRuleNodeIdAndEntityId(ModelConstants.SYSTEM_TENANT, null, BaseEntityService.NULL_CUSTOMER_ID));
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}.
   * <ul>
   *   <li>When {@link RuleNodeId#RuleNodeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}
   */
  @Test
  public void testFindByRuleNodeIdAndEntityId_whenRuleNodeIdWithIdIsNull_uuid() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRuleNodeStateService.findByRuleNodeIdAndEntityId(null,
        new RuleNodeId(ModelConstants.NULL_UUID), BaseEntityService.NULL_CUSTOMER_ID));
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}.
   * <ul>
   *   <li>When {@link RuleNodeId}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}
   */
  @Test
  public void testFindByRuleNodeIdAndEntityId_whenRuleNodeId_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRuleNodeStateService
        .findByRuleNodeIdAndEntityId(ModelConstants.SYSTEM_TENANT, mock(RuleNodeId.class), null));
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  public void testSave() {
    // Arrange
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRuleNodeStateService.save(ModelConstants.SYSTEM_TENANT, new RuleNodeState()));
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  public void testSave2() {
    // Arrange
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseRuleNodeStateService.save(ModelConstants.SYSTEM_TENANT, new RuleNodeState()));
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  public void testSave3() {
    // Arrange
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), null));

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseRuleNodeStateService.save(ModelConstants.SYSTEM_TENANT, new RuleNodeState()));
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   * <ul>
   *   <li>Given {@link RuleNodeStateDao} {@link Dao#save(TenantId, Object)} return
   * {@link RuleNodeState#RuleNodeState()}.</li>
   *   <li>Then return {@link RuleNodeState#RuleNodeState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  public void testSave_givenRuleNodeStateDaoSaveReturnRuleNodeState_thenReturnRuleNodeState() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any())).thenReturn(ruleNodeState);

    // Act
    RuleNodeState actualSaveResult = baseRuleNodeStateService.save(ModelConstants.SYSTEM_TENANT, new RuleNodeState());

    // Assert
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
    assertSame(ruleNodeState, actualSaveResult);
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  public void testSave_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRuleNodeStateService.save(null, new RuleNodeState()));
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}.
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}
   */
  @Test
  public void testRemoveByRuleNodeId() {
    // Arrange
    doThrow(new DataValidationException("An error occurred")).when(ruleNodeStateDao)
        .removeByRuleNodeId(Mockito.<UUID>any());

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseRuleNodeStateService
        .removeByRuleNodeId(ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID)));
    verify(ruleNodeStateDao).removeByRuleNodeId(isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}.
   * <ul>
   *   <li>Then calls {@link RuleNodeStateDao#removeByRuleNodeId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}
   */
  @Test
  public void testRemoveByRuleNodeId_thenCallsRemoveByRuleNodeId() {
    // Arrange
    doNothing().when(ruleNodeStateDao).removeByRuleNodeId(Mockito.<UUID>any());

    // Act
    baseRuleNodeStateService.removeByRuleNodeId(ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID));

    // Assert that nothing has changed
    verify(ruleNodeStateDao).removeByRuleNodeId(isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}
   */
  @Test
  public void testRemoveByRuleNodeId_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRuleNodeStateService.removeByRuleNodeId(null, new RuleNodeId(ModelConstants.NULL_UUID)));
    assertThrows(DataValidationException.class,
        () -> baseRuleNodeStateService.removeByRuleNodeId(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}.
   * <ul>
   *   <li>Then calls
   * {@link RuleNodeStateDao#removeByRuleNodeIdAndEntityId(UUID, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}
   */
  @Test
  public void testRemoveByRuleNodeIdAndEntityId_thenCallsRemoveByRuleNodeIdAndEntityId() {
    // Arrange
    doNothing().when(ruleNodeStateDao).removeByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any());

    // Act
    baseRuleNodeStateService.removeByRuleNodeIdAndEntityId(ModelConstants.SYSTEM_TENANT,
        new RuleNodeId(ModelConstants.NULL_UUID), BaseEntityService.NULL_CUSTOMER_ID);

    // Assert that nothing has changed
    verify(ruleNodeStateDao).removeByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}
   */
  @Test
  public void testRemoveByRuleNodeIdAndEntityId_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRuleNodeStateService
        .removeByRuleNodeIdAndEntityId(ModelConstants.SYSTEM_TENANT, null, BaseEntityService.NULL_CUSTOMER_ID));
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}.
   * <ul>
   *   <li>When {@link RuleNodeId}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}
   */
  @Test
  public void testRemoveByRuleNodeIdAndEntityId_whenRuleNodeId() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRuleNodeStateService
        .removeByRuleNodeIdAndEntityId(ModelConstants.SYSTEM_TENANT, mock(RuleNodeId.class), null));
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}.
   * <ul>
   *   <li>When {@link RuleNodeId#RuleNodeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)}
   */
  @Test
  public void testRemoveByRuleNodeIdAndEntityId_whenRuleNodeIdWithIdIsNull_uuid() {
    // Arrange, Act and Assert
    assertThrows(DataValidationException.class, () -> baseRuleNodeStateService.removeByRuleNodeIdAndEntityId(null,
        new RuleNodeId(ModelConstants.NULL_UUID), BaseEntityService.NULL_CUSTOMER_ID));
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}.
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}
   */
  @Test
  public void testSaveOrUpdate() {
    // Arrange
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));

    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(entityId);
    ruleNodeState.setRuleNodeId(ruleNodeId);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseRuleNodeStateService.saveOrUpdate(ModelConstants.SYSTEM_TENANT, ruleNodeState, true));
    verify(entityId).getId();
    verify(ruleNodeId).getId();
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}.
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}
   */
  @Test
  public void testSaveOrUpdate2() {
    // Arrange
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), null));

    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(entityId);
    ruleNodeState.setRuleNodeId(ruleNodeId);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseRuleNodeStateService.saveOrUpdate(ModelConstants.SYSTEM_TENANT, ruleNodeState, true));
    verify(entityId).getId();
    verify(ruleNodeId).getId();
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}.
   * <ul>
   *   <li>Given {@link EntityId}.</li>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@link RuleNodeState#RuleNodeState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}
   */
  @Test
  public void testSaveOrUpdate_givenEntityId_whenFalse_thenReturnRuleNodeState() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any())).thenReturn(ruleNodeState);

    RuleNodeState ruleNodeState2 = new RuleNodeState();
    ruleNodeState2.setEntityId(mock(EntityId.class));
    ruleNodeState2.setRuleNodeId(mock(RuleNodeId.class));

    // Act
    RuleNodeState actualSaveOrUpdateResult = baseRuleNodeStateService.saveOrUpdate(ModelConstants.SYSTEM_TENANT,
        ruleNodeState2, false);

    // Assert
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
    assertSame(ruleNodeState, actualSaveOrUpdateResult);
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}.
   * <ul>
   *   <li>Then calls
   * {@link RuleNodeStateDao#findByRuleNodeIdAndEntityId(UUID, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}
   */
  @Test
  public void testSaveOrUpdate_thenCallsFindByRuleNodeIdAndEntityId() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any())).thenReturn(ruleNodeState);
    when(ruleNodeStateDao.findByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(null);
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    RuleNodeState ruleNodeState2 = new RuleNodeState();
    ruleNodeState2.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    ruleNodeState2.setRuleNodeId(ruleNodeId);

    // Act
    RuleNodeState actualSaveOrUpdateResult = baseRuleNodeStateService.saveOrUpdate(ModelConstants.SYSTEM_TENANT,
        ruleNodeState2, true);

    // Assert
    verify(ruleNodeId).getId();
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
    verify(ruleNodeStateDao).findByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertSame(ruleNodeState, actualSaveOrUpdateResult);
  }

  /**
   * Test
   * {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}
   */
  @Test
  public void testSaveOrUpdate_thenThrowDataValidationException() {
    // Arrange
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenThrow(
        new ConstraintViolationException("An error occurred", new SQLException(), "rule_node_state_unq_key"));

    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(entityId);
    ruleNodeState.setRuleNodeId(ruleNodeId);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRuleNodeStateService.saveOrUpdate(ModelConstants.SYSTEM_TENANT, ruleNodeState, true));
    verify(entityId).getId();
    verify(ruleNodeId).getId();
  }
}
