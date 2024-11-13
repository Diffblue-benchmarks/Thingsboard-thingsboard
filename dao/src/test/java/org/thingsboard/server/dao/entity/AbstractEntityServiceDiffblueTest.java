package org.thingsboard.server.dao.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Optional;
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
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.dao.alarm.AlarmCommentDao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.alarm.BaseAlarmCommentService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseAlarmCommentService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class AbstractEntityServiceDiffblueTest {
  @Autowired
  private AbstractEntityService abstractEntityService;

  @MockBean
  private AlarmCommentDao alarmCommentDao;

  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<AlarmComment> dataValidator;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private RelationService relationService;

  /**
   * Test {@link AbstractEntityService#createRelation(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Then calls
   * {@link RelationService#saveRelation(TenantId, EntityRelation)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractEntityService#createRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testCreateRelation_thenCallsSaveRelation() {
    // Arrange
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());

    // Act
    abstractEntityService.createRelation(ModelConstants.SYSTEM_TENANT, new EntityRelation());

    // Assert
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link AbstractEntityService#deleteRelation(TenantId, EntityRelation)}.
   * <ul>
   *   <li>Then calls
   * {@link RelationService#deleteRelation(TenantId, EntityRelation)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractEntityService#deleteRelation(TenantId, EntityRelation)}
   */
  @Test
  public void testDeleteRelation_thenCallsDeleteRelation() {
    // Arrange
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any())).thenReturn(true);

    // Act
    abstractEntityService.deleteRelation(ModelConstants.SYSTEM_TENANT, new EntityRelation());

    // Assert
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test
   * {@link AbstractEntityService#extractConstraintViolationException(Exception)}.
   * <ul>
   *   <li>Then return not Present.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractEntityService#extractConstraintViolationException(Exception)}
   */
  @Test
  public void testExtractConstraintViolationException_thenReturnNotPresent() {
    // Arrange and Act
    Optional<ConstraintViolationException> actualExtractConstraintViolationExceptionResult = AbstractEntityService
        .extractConstraintViolationException(new Exception("foo"));

    // Assert
    assertFalse(actualExtractConstraintViolationExceptionResult.isPresent());
  }

  /**
   * Test
   * {@link AbstractEntityService#checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)}.
   * <ul>
   *   <li>Given {@link RelationService}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractEntityService#checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)}
   */
  @Test
  public void testCheckAssignedEntityViewsToEdge_givenRelationService() {
    // Arrange
    when(entityViewService.findEntityViewsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(new ArrayList<>());

    // Act
    abstractEntityService.checkAssignedEntityViewsToEdge(ModelConstants.SYSTEM_TENANT, mock(AlarmId.class), null);

    // Assert
    verify(entityViewService).findEntityViewsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test
   * {@link AbstractEntityService#checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)}.
   * <ul>
   *   <li>Given {@link RelationService}
   * {@link RelationService#checkRelation(TenantId, EntityId, EntityId, String, RelationTypeGroup)}
   * return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractEntityService#checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)}
   */
  @Test
  public void testCheckAssignedEntityViewsToEdge_givenRelationServiceCheckRelationReturnFalse() {
    // Arrange
    ArrayList<EntityView> entityViewList = new ArrayList<>();
    entityViewList.add(new EntityView());
    when(entityViewService.findEntityViewsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityViewList);
    when(relationService.checkRelation(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any())).thenReturn(false);

    // Act
    abstractEntityService.checkAssignedEntityViewsToEdge(ModelConstants.SYSTEM_TENANT, mock(AlarmId.class), null);

    // Assert
    verify(entityViewService).findEntityViewsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
    verify(relationService).checkRelation(isA(TenantId.class), isNull(), isNull(), eq("Contains"),
        eq(RelationTypeGroup.EDGE));
  }

  /**
   * Test
   * {@link AbstractEntityService#checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractEntityService#checkAssignedEntityViewsToEdge(TenantId, EntityId, EdgeId)}
   */
  @Test
  public void testCheckAssignedEntityViewsToEdge_thenThrowDataValidationException() {
    // Arrange
    ArrayList<EntityView> entityViewList = new ArrayList<>();
    entityViewList.add(new EntityView());
    when(entityViewService.findEntityViewsByTenantIdAndEntityId(Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(entityViewList);
    when(relationService.checkRelation(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<EntityId>any(),
        Mockito.<String>any(), Mockito.<RelationTypeGroup>any())).thenReturn(true);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> abstractEntityService
        .checkAssignedEntityViewsToEdge(ModelConstants.SYSTEM_TENANT, mock(AlarmId.class), null));
    verify(entityViewService).findEntityViewsByTenantIdAndEntityId(isA(TenantId.class), isA(EntityId.class));
    verify(relationService).checkRelation(isA(TenantId.class), isNull(), isNull(), eq("Contains"),
        eq(RelationTypeGroup.EDGE));
  }
}
