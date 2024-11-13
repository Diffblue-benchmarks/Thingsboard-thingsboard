package org.thingsboard.server.dao.rule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.exception.EntityVersionMismatchException;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainConnectionInfo;
import org.thingsboard.server.common.data.rule.RuleChainData;
import org.thingsboard.server.common.data.rule.RuleChainImportResult;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.common.data.rule.RuleChainUpdateResult;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.TenantEntityDao;
import org.thingsboard.server.dao.alarm.AlarmService;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityCountService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseRuleChainService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class BaseRuleChainServiceDiffblueTest {
  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private BaseRuleChainService baseRuleChainService;

  @MockBean
  private CleanUpService cleanUpService;

  @MockBean
  private DataValidator<RuleChain> dataValidator;

  @MockBean
  private EdgeService edgeService;

  @MockBean
  private EntityCountService entityCountService;

  @MockBean
  private EntityViewService entityViewService;

  @MockBean
  private RelationService relationService;

  @MockBean
  private RuleChainDao ruleChainDao;

  @MockBean
  private RuleNodeDao ruleNodeDao;

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain)} with
   * {@code ruleChain}.
   * <p>
   * Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain)}
   */
  @Test
  public void testSaveRuleChainWithRuleChain() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getTenantId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(ruleChain);
    when(dataValidator.validate(Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseRuleChainService.saveRuleChain(new RuleChain()));
    verify(ruleChain).getTenantId();
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.RULE_CHAIN));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain)} with
   * {@code ruleChain}.
   * <p>
   * Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain)}
   */
  @Test
  public void testSaveRuleChainWithRuleChain2() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getTenantId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), null));
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(ruleChain);
    when(dataValidator.validate(Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseRuleChainService.saveRuleChain(new RuleChain()));
    verify(ruleChain).getTenantId();
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.RULE_CHAIN));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain)} with
   * {@code ruleChain}.
   * <p>
   * Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain)}
   */
  @Test
  public void testSaveRuleChainWithRuleChain3() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getTenantId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), ""));
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(ruleChain);
    when(dataValidator.validate(Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseRuleChainService.saveRuleChain(new RuleChain()));
    verify(ruleChain).getTenantId();
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.RULE_CHAIN));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with
   * {@code ruleChain}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  public void testSaveRuleChainWithRuleChainPublishSaveEvent() {
    // Arrange
    when(dataValidator.validate(Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService.saveRuleChain(new RuleChain(), true));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with
   * {@code ruleChain}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  public void testSaveRuleChainWithRuleChainPublishSaveEvent2() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getTenantId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(ruleChain);
    when(dataValidator.validate(Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseRuleChainService.saveRuleChain(new RuleChain(), true));
    verify(ruleChain).getTenantId();
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.RULE_CHAIN));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with
   * {@code ruleChain}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  public void testSaveRuleChainWithRuleChainPublishSaveEvent3() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getTenantId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), null));
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(ruleChain);
    when(dataValidator.validate(Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseRuleChainService.saveRuleChain(new RuleChain(), true));
    verify(ruleChain).getTenantId();
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.RULE_CHAIN));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with
   * {@code ruleChain}, {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  public void testSaveRuleChainWithRuleChainPublishSaveEvent4() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getTenantId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), ""));
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(ruleChain);
    when(dataValidator.validate(Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseRuleChainService.saveRuleChain(new RuleChain(), true));
    verify(ruleChain).getTenantId();
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.RULE_CHAIN));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with
   * {@code ruleChain}, {@code publishSaveEvent}.
   * <ul>
   *   <li>Then return {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  public void testSaveRuleChainWithRuleChainPublishSaveEvent_thenReturnRuleChain() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(ruleChain);
    when(dataValidator.validate(Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    // Act
    RuleChain actualSaveRuleChainResult = baseRuleChainService.saveRuleChain(new RuleChain(), true);

    // Assert
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.RULE_CHAIN));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
    assertSame(ruleChain, actualSaveRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with
   * {@code ruleChain}, {@code publishSaveEvent}.
   * <ul>
   *   <li>When {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  public void testSaveRuleChainWithRuleChainPublishSaveEvent_whenFalse() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenReturn(mock(RuleChain.class));
    when(dataValidator.validate(Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    // Act
    baseRuleChainService.saveRuleChain(new RuleChain(), false);

    // Assert
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.RULE_CHAIN));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with
   * {@code ruleChain}, {@code publishSaveEvent}.
   * <ul>
   *   <li>When {@link RuleChainId#RuleChainId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  public void testSaveRuleChainWithRuleChainPublishSaveEvent_whenRuleChainIdWithIdIsNull_uuid() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getTenantId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(ruleChain);
    when(dataValidator.validate(Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseRuleChainService.saveRuleChain(new RuleChain(new RuleChainId(ModelConstants.NULL_UUID)), true));
    verify(ruleChain).getTenantId();
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain)} with
   * {@code ruleChain}.
   * <ul>
   *   <li>Then return {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain)}
   */
  @Test
  public void testSaveRuleChainWithRuleChain_thenReturnRuleChain() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(ruleChain);
    when(dataValidator.validate(Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    // Act
    RuleChain actualSaveRuleChainResult = baseRuleChainService.saveRuleChain(new RuleChain());

    // Assert
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(entityCountService).publishCountEntityEvictEvent(isNull(), eq(EntityType.RULE_CHAIN));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
    assertSame(ruleChain, actualSaveRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain)} with
   * {@code ruleChain}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain)}
   */
  @Test
  public void testSaveRuleChainWithRuleChain_thenThrowEntityVersionMismatchException() {
    // Arrange
    when(dataValidator.validate(Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService.saveRuleChain(new RuleChain()));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain)} with
   * {@code ruleChain}.
   * <ul>
   *   <li>When {@link RuleChainId#RuleChainId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain)}
   */
  @Test
  public void testSaveRuleChainWithRuleChain_whenRuleChainIdWithIdIsNull_uuid() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getTenantId())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(ruleChain);
    when(dataValidator.validate(Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseRuleChainService.saveRuleChain(new RuleChain(new RuleChainId(ModelConstants.NULL_UUID))));
    verify(ruleChain).getTenantId();
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  public void testSetRootRuleChain() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(new RuleChain());
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(null);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    boolean actualSetRootRuleChainResult = baseRuleChainService.setRootRuleChain(ModelConstants.SYSTEM_TENANT,
        new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).save(isA(TenantId.class), isA(RuleChain.class));
    verify(ruleChainDao).findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE));
    assertTrue(actualSetRootRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  public void testSetRootRuleChain_givenNull_uuid_thenCallsGetId() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    doNothing().when(ruleChain).setTenantId(Mockito.<TenantId>any());
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualSetRootRuleChainResult = baseRuleChainService.setRootRuleChain(ModelConstants.SYSTEM_TENANT,
        ruleChainId);

    // Assert
    verify(ruleChainId).getId();
    verify(ruleChain).isRoot();
    verify(ruleChain).setTenantId(isA(TenantId.class));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualSetRootRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()} Id is
   * {@link RuleChainId#RuleChainId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  public void testSetRootRuleChain_givenRuleChainIdIsRuleChainIdWithIdIsNull_uuid() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setId(new RuleChainId(ModelConstants.NULL_UUID));
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(new RuleChain());
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain2);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    boolean actualSetRootRuleChainResult = baseRuleChainService.setRootRuleChain(ModelConstants.SYSTEM_TENANT,
        new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao, atLeast(1)).save(isA(TenantId.class), Mockito.<RuleChain>any());
    verify(ruleChainDao).findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE));
    assertTrue(actualSetRootRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link RuleChain} {@link RuleChain#isRoot()} return
   * {@code true}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  public void testSetRootRuleChain_givenRuleChainIsRootReturnTrue_thenReturnFalse() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    doNothing().when(ruleChain).setTenantId(Mockito.<TenantId>any());
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    boolean actualSetRootRuleChainResult = baseRuleChainService.setRootRuleChain(ModelConstants.SYSTEM_TENANT,
        new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChain).isRoot();
    verify(ruleChain).setTenantId(isA(TenantId.class));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualSetRootRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  public void testSetRootRuleChain_thenThrowEntityVersionMismatchException() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    RuleChain ruleChain2 = mock(RuleChain.class);
    when(ruleChain2.getId()).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain2);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .setRootRuleChain(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChain2).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE));
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater2() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getVersion())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater3() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenThrow(
        new ConstraintViolationException("An error occurred", new SQLException(), "Incorrect rule chain id."));
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater4() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(new RuleChain());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(null);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act
    RuleChainUpdateResult actualSaveRuleChainMetaDataResult = baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class));

    // Assert
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData).getFirstNodeIndex();
    verify(ruleChainMetaData).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).save(isA(TenantId.class), isA(RuleChain.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertTrue(actualSaveRuleChainMetaDataResult.getUpdatedRuleNodes().isEmpty());
    assertTrue(actualSaveRuleChainMetaDataResult.isSuccess());
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater5() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(null);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData).getFirstNodeIndex();
    verify(ruleChainMetaData).getNodes();
    verify(ruleChainMetaData).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater6() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(new RuleChain());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    when(ruleNodeDao.save(Mockito.<TenantId>any(), Mockito.<RuleNode>any())).thenReturn(ruleNode);
    RuleChainConnectionInfo ruleChainConnectionInfo = mock(RuleChainConnectionInfo.class);
    when(ruleChainConnectionInfo.getFromIndex())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainConnectionInfo.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleChainConnectionInfo.getTargetRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    doNothing().when(ruleChainConnectionInfo).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainConnectionInfo).setFromIndex(anyInt());
    doNothing().when(ruleChainConnectionInfo).setTargetRuleChainId(Mockito.<RuleChainId>any());
    doNothing().when(ruleChainConnectionInfo).setType(Mockito.<String>any());
    ruleChainConnectionInfo.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));
    ruleChainConnectionInfo.setType("Incorrect rule chain id.");

    ArrayList<RuleChainConnectionInfo> ruleChainConnectionInfoList = new ArrayList<>();
    ruleChainConnectionInfoList.add(ruleChainConnectionInfo);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(ruleChainConnectionInfoList);
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(null);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChainConnectionInfo).getAdditionalInfo();
    verify(ruleChainConnectionInfo).getFromIndex();
    verify(ruleChainConnectionInfo).getTargetRuleChainId();
    verify(ruleChainConnectionInfo).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainConnectionInfo).setFromIndex(eq(1));
    verify(ruleChainConnectionInfo).setTargetRuleChainId(isA(RuleChainId.class));
    verify(ruleChainConnectionInfo).setType(eq("Incorrect rule chain id."));
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData).getFirstNodeIndex();
    verify(ruleChainMetaData).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleNode).getId();
    verify(ruleChainDao, atLeast(1)).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleNodeDao).save(isA(TenantId.class), isA(RuleNode.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater7() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(new RuleChain());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    when(ruleNodeDao.save(Mockito.<TenantId>any(), Mockito.<RuleNode>any())).thenReturn(ruleNode);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);
    RuleChainConnectionInfo ruleChainConnectionInfo = mock(RuleChainConnectionInfo.class);
    when(ruleChainConnectionInfo.getFromIndex())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainConnectionInfo.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleChainConnectionInfo.getTargetRuleChainId()).thenReturn(ruleChainId);
    doNothing().when(ruleChainConnectionInfo).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainConnectionInfo).setFromIndex(anyInt());
    doNothing().when(ruleChainConnectionInfo).setTargetRuleChainId(Mockito.<RuleChainId>any());
    doNothing().when(ruleChainConnectionInfo).setType(Mockito.<String>any());
    ruleChainConnectionInfo.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));
    ruleChainConnectionInfo.setType("Incorrect rule chain id.");

    ArrayList<RuleChainConnectionInfo> ruleChainConnectionInfoList = new ArrayList<>();
    ruleChainConnectionInfoList.add(ruleChainConnectionInfo);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(ruleChainConnectionInfoList);
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(null);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainConnectionInfo).getAdditionalInfo();
    verify(ruleChainConnectionInfo).getFromIndex();
    verify(ruleChainConnectionInfo).getTargetRuleChainId();
    verify(ruleChainConnectionInfo).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainConnectionInfo).setFromIndex(eq(1));
    verify(ruleChainConnectionInfo).setTargetRuleChainId(isA(RuleChainId.class));
    verify(ruleChainConnectionInfo).setType(eq("Incorrect rule chain id."));
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData).getFirstNodeIndex();
    verify(ruleChainMetaData).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleNode).getId();
    verify(ruleChainDao, atLeast(1)).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleNodeDao).save(isA(TenantId.class), isA(RuleNode.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater},
   * {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), true));
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater},
   * {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent2() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getVersion())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), true));
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater},
   * {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent3() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenThrow(
        new ConstraintViolationException("An error occurred", new SQLException(), "Incorrect rule chain id."));
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), true));
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater},
   * {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent4() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(new RuleChain());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(null);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act
    RuleChainUpdateResult actualSaveRuleChainMetaDataResult = baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), true);

    // Assert
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData).getFirstNodeIndex();
    verify(ruleChainMetaData).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).save(isA(TenantId.class), isA(RuleChain.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertTrue(actualSaveRuleChainMetaDataResult.getUpdatedRuleNodes().isEmpty());
    assertTrue(actualSaveRuleChainMetaDataResult.isSuccess());
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater},
   * {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent5() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(null);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), true));
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData).getFirstNodeIndex();
    verify(ruleChainMetaData).getNodes();
    verify(ruleChainMetaData).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater},
   * {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent6() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(new RuleChain());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    when(ruleNodeDao.save(Mockito.<TenantId>any(), Mockito.<RuleNode>any())).thenReturn(ruleNode);
    RuleChainConnectionInfo ruleChainConnectionInfo = mock(RuleChainConnectionInfo.class);
    when(ruleChainConnectionInfo.getFromIndex())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainConnectionInfo.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleChainConnectionInfo.getTargetRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    doNothing().when(ruleChainConnectionInfo).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainConnectionInfo).setFromIndex(anyInt());
    doNothing().when(ruleChainConnectionInfo).setTargetRuleChainId(Mockito.<RuleChainId>any());
    doNothing().when(ruleChainConnectionInfo).setType(Mockito.<String>any());
    ruleChainConnectionInfo.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));
    ruleChainConnectionInfo.setType("Incorrect rule chain id.");

    ArrayList<RuleChainConnectionInfo> ruleChainConnectionInfoList = new ArrayList<>();
    ruleChainConnectionInfoList.add(ruleChainConnectionInfo);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(ruleChainConnectionInfoList);
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(null);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), true));
    verify(ruleChainConnectionInfo).getAdditionalInfo();
    verify(ruleChainConnectionInfo).getFromIndex();
    verify(ruleChainConnectionInfo).getTargetRuleChainId();
    verify(ruleChainConnectionInfo).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainConnectionInfo).setFromIndex(eq(1));
    verify(ruleChainConnectionInfo).setTargetRuleChainId(isA(RuleChainId.class));
    verify(ruleChainConnectionInfo).setType(eq("Incorrect rule chain id."));
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData).getFirstNodeIndex();
    verify(ruleChainMetaData).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleNode).getId();
    verify(ruleChainDao, atLeast(1)).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleNodeDao).save(isA(TenantId.class), isA(RuleNode.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater},
   * {@code publishSaveEvent}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)}
   */
  @Test
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent7() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(new RuleChain());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    when(ruleNodeDao.save(Mockito.<TenantId>any(), Mockito.<RuleNode>any())).thenReturn(ruleNode);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);
    RuleChainConnectionInfo ruleChainConnectionInfo = mock(RuleChainConnectionInfo.class);
    when(ruleChainConnectionInfo.getFromIndex())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainConnectionInfo.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleChainConnectionInfo.getTargetRuleChainId()).thenReturn(ruleChainId);
    doNothing().when(ruleChainConnectionInfo).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainConnectionInfo).setFromIndex(anyInt());
    doNothing().when(ruleChainConnectionInfo).setTargetRuleChainId(Mockito.<RuleChainId>any());
    doNothing().when(ruleChainConnectionInfo).setType(Mockito.<String>any());
    ruleChainConnectionInfo.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));
    ruleChainConnectionInfo.setType("Incorrect rule chain id.");

    ArrayList<RuleChainConnectionInfo> ruleChainConnectionInfoList = new ArrayList<>();
    ruleChainConnectionInfoList.add(ruleChainConnectionInfo);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(ruleChainConnectionInfoList);
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(null);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .saveRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), true));
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainConnectionInfo).getAdditionalInfo();
    verify(ruleChainConnectionInfo).getFromIndex();
    verify(ruleChainConnectionInfo).getTargetRuleChainId();
    verify(ruleChainConnectionInfo).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainConnectionInfo).setFromIndex(eq(1));
    verify(ruleChainConnectionInfo).setTargetRuleChainId(isA(RuleChainId.class));
    verify(ruleChainConnectionInfo).setType(eq("Incorrect rule chain id."));
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData).getFirstNodeIndex();
    verify(ruleChainMetaData).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleNode).getId();
    verify(ruleChainDao, atLeast(1)).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleNodeDao).save(isA(TenantId.class), isA(RuleNode.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test
   * {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return FirstNodeIndex is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}
   */
  @Test
  public void testLoadRuleChainMetaData_givenNull_uuid_thenReturnFirstNodeIndexIsNull() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenReturn(1L);
    when(ruleChain.getFirstRuleNodeId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    RuleChainMetaData actualLoadRuleChainMetaDataResult = baseRuleChainService
        .loadRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertNull(actualLoadRuleChainMetaDataResult.getFirstNodeIndex());
    assertNull(actualLoadRuleChainMetaDataResult.getConnections());
    assertNull(actualLoadRuleChainMetaDataResult.getRuleChainConnections());
    assertEquals(1L, actualLoadRuleChainMetaDataResult.getVersion().longValue());
    assertTrue(actualLoadRuleChainMetaDataResult.getNodes().isEmpty());
    assertSame(ruleChainId, actualLoadRuleChainMetaDataResult.getRuleChainId());
  }

  /**
   * Test
   * {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link RuleChainDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}
   */
  @Test
  public void testLoadRuleChainMetaData_givenRuleChainDaoFindByIdReturnNull_thenReturnNull() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    RuleChainMetaData actualLoadRuleChainMetaDataResult = baseRuleChainService
        .loadRuleChainMetaData(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualLoadRuleChainMetaDataResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then return Version is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}
   */
  @Test
  public void testLoadRuleChainMetaData_thenReturnVersionIsNull() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());
    RuleChainId ruleChainId = new RuleChainId(ModelConstants.NULL_UUID);

    // Act
    RuleChainMetaData actualLoadRuleChainMetaDataResult = baseRuleChainService
        .loadRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertNull(actualLoadRuleChainMetaDataResult.getVersion());
    assertSame(ruleChainId, actualLoadRuleChainMetaDataResult.getRuleChainId());
  }

  /**
   * Test
   * {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then return Version longValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}
   */
  @Test
  public void testLoadRuleChainMetaData_thenReturnVersionLongValueIsOne() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenReturn(1L);
    when(ruleChain.getFirstRuleNodeId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainId ruleChainId = new RuleChainId(ModelConstants.NULL_UUID);

    // Act
    RuleChainMetaData actualLoadRuleChainMetaDataResult = baseRuleChainService
        .loadRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertEquals(1L, actualLoadRuleChainMetaDataResult.getVersion().longValue());
    assertSame(ruleChainId, actualLoadRuleChainMetaDataResult.getRuleChainId());
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainById(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  public void testFindRuleChainById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    RuleChain actualFindRuleChainByIdResult = baseRuleChainService.findRuleChainById(ModelConstants.SYSTEM_TENANT,
        ruleChainId);

    // Assert
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(ruleChain, actualFindRuleChainByIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainById(TenantId, RuleChainId)}.
   * <ul>
   *   <li>When {@link RuleChainId#RuleChainId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  public void testFindRuleChainById_whenRuleChainIdWithIdIsNull_uuid_thenReturnRuleChain() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    RuleChain actualFindRuleChainByIdResult = baseRuleChainService.findRuleChainById(ModelConstants.SYSTEM_TENANT,
        new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(ruleChain, actualFindRuleChainByIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodeById(TenantId, RuleNodeId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleNodeById(TenantId, RuleNodeId)}
   */
  @Test
  public void testFindRuleNodeById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleNode);
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    RuleNode actualFindRuleNodeByIdResult = baseRuleChainService.findRuleNodeById(ModelConstants.SYSTEM_TENANT,
        ruleNodeId);

    // Assert
    verify(ruleNodeId, atLeast(1)).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(ruleNode, actualFindRuleNodeByIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodeById(TenantId, RuleNodeId)}.
   * <ul>
   *   <li>When {@link RuleNodeId#RuleNodeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@link RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleNodeById(TenantId, RuleNodeId)}
   */
  @Test
  public void testFindRuleNodeById_whenRuleNodeIdWithIdIsNull_uuid_thenReturnRuleNode() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleNode);

    // Act
    RuleNode actualFindRuleNodeByIdResult = baseRuleChainService.findRuleNodeById(ModelConstants.SYSTEM_TENANT,
        new RuleNodeId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(ruleNode, actualFindRuleNodeByIdResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findRuleChainByIdAsync(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleChainByIdAsync(TenantId, RuleChainId)}
   */
  @Test
  public void testFindRuleChainByIdAsync_givenNull_uuid_thenCallsGetId() {
    // Arrange
    SettableFuture<RuleChain> createResult = SettableFuture.create();
    when(ruleChainDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<RuleChain> actualFindRuleChainByIdAsyncResult = baseRuleChainService
        .findRuleChainByIdAsync(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindRuleChainByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindRuleChainByIdAsyncResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findRuleChainByIdAsync(TenantId, RuleChainId)}.
   * <ul>
   *   <li>When {@link RuleChainId#RuleChainId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleChainByIdAsync(TenantId, RuleChainId)}
   */
  @Test
  public void testFindRuleChainByIdAsync_whenRuleChainIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<RuleChain> createResult = SettableFuture.create();
    when(ruleChainDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<RuleChain> actualFindRuleChainByIdAsyncResult = baseRuleChainService
        .findRuleChainByIdAsync(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindRuleChainByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindRuleChainByIdAsyncResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findRuleNodeByIdAsync(TenantId, RuleNodeId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleNodeByIdAsync(TenantId, RuleNodeId)}
   */
  @Test
  public void testFindRuleNodeByIdAsync_givenNull_uuid_thenCallsGetId() {
    // Arrange
    SettableFuture<RuleNode> createResult = SettableFuture.create();
    when(ruleNodeDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<RuleNode> actualFindRuleNodeByIdAsyncResult = baseRuleChainService
        .findRuleNodeByIdAsync(ModelConstants.SYSTEM_TENANT, ruleNodeId);

    // Assert
    verify(ruleNodeId, atLeast(1)).getId();
    verify(ruleNodeDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindRuleNodeByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindRuleNodeByIdAsyncResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findRuleNodeByIdAsync(TenantId, RuleNodeId)}.
   * <ul>
   *   <li>When {@link RuleNodeId#RuleNodeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleNodeByIdAsync(TenantId, RuleNodeId)}
   */
  @Test
  public void testFindRuleNodeByIdAsync_whenRuleNodeIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<RuleNode> createResult = SettableFuture.create();
    when(ruleNodeDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    ListenableFuture<RuleNode> actualFindRuleNodeByIdAsyncResult = baseRuleChainService
        .findRuleNodeByIdAsync(ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleNodeDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindRuleNodeByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindRuleNodeByIdAsyncResult);
  }

  /**
   * Test {@link BaseRuleChainService#getRootTenantRuleChain(TenantId)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getRootTenantRuleChain(TenantId)}
   */
  @Test
  public void testGetRootTenantRuleChain_thenThrowEntityVersionMismatchException() {
    // Arrange
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.getRootTenantRuleChain(ModelConstants.SYSTEM_TENANT));
    verify(ruleChainDao).findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseRuleChainService#getRootTenantRuleChain(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getRootTenantRuleChain(TenantId)}
   */
  @Test
  public void testGetRootTenantRuleChain_whenSystem_tenant_thenReturnRuleChain() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain);

    // Act
    RuleChain actualRootTenantRuleChain = baseRuleChainService.getRootTenantRuleChain(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(ruleChainDao).findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE));
    assertSame(ruleChain, actualRootTenantRuleChain);
  }

  /**
   * Test {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}
   */
  @Test
  public void testGetRuleChainNodes_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualRuleChainNodes = baseRuleChainService.getRuleChainNodes(ModelConstants.SYSTEM_TENANT,
        ruleChainId);

    // Assert
    verify(ruleChainId).getId();
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertTrue(actualRuleChainNodes.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link RuleNodeDao} {@link Dao#findById(TenantId, UUID)} return
   * {@link RuleNode#RuleNode()}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}
   */
  @Test
  public void testGetRuleChainNodes_givenRuleNodeDaoFindByIdReturnRuleNode_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList
        .add(new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type"));
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleNode);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualRuleChainNodes = baseRuleChainService.getRuleChainNodes(ModelConstants.SYSTEM_TENANT,
        ruleChainId);

    // Assert
    verify(ruleChainId).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertEquals(1, actualRuleChainNodes.size());
    assertSame(ruleNode, actualRuleChainNodes.get(0));
  }

  /**
   * Test {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}
   */
  @Test
  public void testGetRuleChainNodes_thenThrowEntityVersionMismatchException() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList
        .add(new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type"));
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.getRuleChainNodes(ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}.
   * <ul>
   *   <li>When {@link RuleChainId#RuleChainId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}
   */
  @Test
  public void testGetRuleChainNodes_whenRuleChainIdWithIdIsNull_uuid_thenReturnEmpty() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<RuleNode> actualRuleChainNodes = baseRuleChainService.getRuleChainNodes(ModelConstants.SYSTEM_TENANT,
        new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertTrue(actualRuleChainNodes.isEmpty());
  }

  /**
   * Test
   * {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId, RuleChainId)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId, RuleChainId)}
   */
  @Test
  public void testGetReferencingRuleChainNodes() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList
        .add(new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type"));
    when(relationService.findByTo(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleNode);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualReferencingRuleChainNodes = baseRuleChainService
        .getReferencingRuleChainNodes(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChainId).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
    assertEquals(1, actualReferencingRuleChainNodes.size());
    assertSame(ruleNode, actualReferencingRuleChainNodes.get(0));
  }

  /**
   * Test
   * {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId, RuleChainId)}
   */
  @Test
  public void testGetReferencingRuleChainNodes_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(relationService.findByTo(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualReferencingRuleChainNodes = baseRuleChainService
        .getReferencingRuleChainNodes(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChainId).getId();
    verify(relationService).findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
    assertTrue(actualReferencingRuleChainNodes.isEmpty());
  }

  /**
   * Test
   * {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId, RuleChainId)}
   */
  @Test
  public void testGetReferencingRuleChainNodes_thenCallsGetId() {
    // Arrange
    EntityId from = mock(EntityId.class);
    when(from.getId()).thenReturn(ModelConstants.NULL_UUID);
    EntityRelation entityRelation = new EntityRelation(from, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);
    when(relationService.findByTo(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleNode);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualReferencingRuleChainNodes = baseRuleChainService
        .getReferencingRuleChainNodes(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(from).getId();
    verify(ruleChainId).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
    assertEquals(1, actualReferencingRuleChainNodes.size());
    assertSame(ruleNode, actualReferencingRuleChainNodes.get(0));
  }

  /**
   * Test
   * {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId, RuleChainId)}
   */
  @Test
  public void testGetReferencingRuleChainNodes_thenReturnEmpty() {
    // Arrange
    when(relationService.findByTo(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<RuleNode> actualReferencingRuleChainNodes = baseRuleChainService
        .getReferencingRuleChainNodes(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(relationService).findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
    assertTrue(actualReferencingRuleChainNodes.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}
   */
  @Test
  public void testGetRuleNodeRelations_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EntityRelation> actualRuleNodeRelations = baseRuleChainService
        .getRuleNodeRelations(ModelConstants.SYSTEM_TENANT, ruleNodeId);

    // Assert
    verify(ruleNodeId).getId();
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
    assertTrue(actualRuleNodeRelations.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}.
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}
   */
  @Test
  public void testGetRuleNodeRelations_thenReturnArrayList() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList
        .add(new EntityRelation(BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type"));
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EntityRelation> actualRuleNodeRelations = baseRuleChainService
        .getRuleNodeRelations(ModelConstants.SYSTEM_TENANT, ruleNodeId);

    // Assert
    verify(ruleNodeId).getId();
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
    assertEquals(entityRelationList, actualRuleNodeRelations);
  }

  /**
   * Test {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}.
   * <ul>
   *   <li>When {@link RuleNodeId#RuleNodeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}
   */
  @Test
  public void testGetRuleNodeRelations_whenRuleNodeIdWithIdIsNull_uuid_thenReturnEmpty() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualRuleNodeRelations = baseRuleChainService
        .getRuleNodeRelations(ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID));

    // Assert
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
    assertTrue(actualRuleNodeRelations.isEmpty());
  }

  /**
   * Test
   * {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)}
   */
  @Test
  public void testFindTenantRuleChainsByType() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<RuleChain> actualFindTenantRuleChainsByTypeResult = baseRuleChainService
        .findTenantRuleChainsByType(ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleChainDao).findRuleChainsByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE), isA(PageLink.class));
    assertSame(actualFindTenantRuleChainsByTypeResult.EMPTY_PAGE_DATA, actualFindTenantRuleChainsByTypeResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)}
   */
  @Test
  public void testFindTenantRuleChainsByType_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<RuleChain> actualFindTenantRuleChainsByTypeResult = baseRuleChainService
        .findTenantRuleChainsByType(ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleChainDao).findRuleChainsByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE), isA(PageLink.class));
    assertSame(actualFindTenantRuleChainsByTypeResult.EMPTY_PAGE_DATA, actualFindTenantRuleChainsByTypeResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)}
   */
  @Test
  public void testFindTenantRuleChainsByType_thenThrowConstraintViolationException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseRuleChainService
        .findTenantRuleChainsByType(ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)}
   */
  @Test
  public void testFindTenantRuleChainsByType_thenThrowEntityVersionMismatchException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .findTenantRuleChainsByType(ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)}
   */
  @Test
  public void testFindTenantRuleChainsByType_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleChain> actualFindTenantRuleChainsByTypeResult = baseRuleChainService.findTenantRuleChainsByType(
        ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainDao).findRuleChainsByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE), isA(PageLink.class));
    assertSame(actualFindTenantRuleChainsByTypeResult.EMPTY_PAGE_DATA, actualFindTenantRuleChainsByTypeResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findTenantRuleChainsByTypeAndName(TenantId, RuleChainType, String)}.
   * <ul>
   *   <li>Then return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findTenantRuleChainsByTypeAndName(TenantId, RuleChainType, String)}
   */
  @Test
  public void testFindTenantRuleChainsByTypeAndName_thenReturnList() {
    // Arrange
    ArrayList<RuleChain> ruleChainList = new ArrayList<>();
    when(ruleChainDao.findByTenantIdAndTypeAndName(Mockito.<TenantId>any(), Mockito.<RuleChainType>any(),
        Mockito.<String>any())).thenReturn(ruleChainList);

    // Act
    Collection<RuleChain> actualFindTenantRuleChainsByTypeAndNameResult = baseRuleChainService
        .findTenantRuleChainsByTypeAndName(ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, "Name");

    // Assert
    verify(ruleChainDao).findByTenantIdAndTypeAndName(isA(TenantId.class), eq(RuleChainType.CORE), eq("Name"));
    assertTrue(actualFindTenantRuleChainsByTypeAndNameResult instanceof List);
    assertTrue(actualFindTenantRuleChainsByTypeAndNameResult.isEmpty());
    assertSame(ruleChainList, actualFindTenantRuleChainsByTypeAndNameResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findTenantRuleChainsByTypeAndName(TenantId, RuleChainType, String)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findTenantRuleChainsByTypeAndName(TenantId, RuleChainType, String)}
   */
  @Test
  public void testFindTenantRuleChainsByTypeAndName_thenThrowEntityVersionMismatchException() {
    // Arrange
    when(ruleChainDao.findByTenantIdAndTypeAndName(Mockito.<TenantId>any(), Mockito.<RuleChainType>any(),
        Mockito.<String>any())).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .findTenantRuleChainsByTypeAndName(ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, "Name"));
    verify(ruleChainDao).findByTenantIdAndTypeAndName(isA(TenantId.class), eq(RuleChainType.CORE), eq("Name"));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  public void testDeleteRuleChainById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    when(relationService.findByTo(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRuleChainService.deleteRuleChainById(ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChain).isRoot();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link RuleChainDao} {@link Dao#findById(TenantId, UUID)} return
   * {@code null}.</li>
   *   <li>Then calls {@link Dao#findById(TenantId, UUID)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  public void testDeleteRuleChainById_givenRuleChainDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    baseRuleChainService.deleteRuleChainById(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert that nothing has changed
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()} Id is
   * {@link RuleChainId#RuleChainId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  public void testDeleteRuleChainById_givenRuleChainIdIsRuleChainIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(relationService.findByTo(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setId(new RuleChainId(ModelConstants.NULL_UUID));
    doNothing().when(ruleChainDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    baseRuleChainService.deleteRuleChainById(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    verify(relationService).findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then calls
   * {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  public void testDeleteRuleChainById_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<Object>>any());
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(relationService.findByTo(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(ruleChainDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());

    // Act
    baseRuleChainService.deleteRuleChainById(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(relationService).findByFrom(isA(TenantId.class), isNull(), eq(RelationTypeGroup.RULE_CHAIN));
    verify(relationService).findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  public void testDeleteRuleChainById_thenThrowConstraintViolationException() {
    // Arrange
    when(relationService.findByTo(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Incorrect rule chain id for delete request.")).when(ruleChainDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseRuleChainService
        .deleteRuleChainById(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(relationService).findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  public void testDeleteRuleChainById_thenThrowDataValidationException() {
    // Arrange
    when(relationService.findByTo(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act and Assert
    assertThrows(DataValidationException.class, () -> baseRuleChainService
        .deleteRuleChainById(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChain).isRoot();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  public void testDeleteRuleChainById_thenThrowEntityVersionMismatchException() {
    // Arrange
    when(relationService.findByTo(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable())).when(ruleChainDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .deleteRuleChainById(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(relationService).findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainsByTenantId(TenantId)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#deleteRuleChainsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteRuleChainsByTenantId() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseRuleChainService.deleteRuleChainsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainsByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#deleteRuleChainsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteRuleChainsByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    ArrayList<RuleChain> data = new ArrayList<>();
    data.add(new RuleChain());
    PageData<RuleChain> pageData = new PageData<>(data, 100, 100L, true);

    doThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Incorrect tenant id for delete rule chains request.")).when(ruleChainDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseRuleChainService.deleteRuleChainsByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(ruleChainDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainsByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#deleteRuleChainsByTenantId(TenantId)}
   */
  @Test
  public void testDeleteRuleChainsByTenantId_thenThrowEntityVersionMismatchException() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    ArrayList<RuleChain> data = new ArrayList<>();
    data.add(new RuleChain());
    PageData<RuleChain> pageData = new PageData<>(data, 100, 100L, true);

    doThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable())).when(ruleChainDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.deleteRuleChainsByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(ruleChainDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteByTenantId(TenantId)}.
   * <p>
   * Method under test: {@link BaseRuleChainService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    baseRuleChainService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    ArrayList<RuleChain> data = new ArrayList<>();
    data.add(new RuleChain());
    PageData<RuleChain> pageData = new PageData<>(data, 100, 100L, true);

    doThrow(new ConstraintViolationException("An error occurred", new SQLException(),
        "Incorrect tenant id for delete rule chains request.")).when(ruleChainDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseRuleChainService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(ruleChainDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainService#deleteByTenantId(TenantId)}
   */
  @Test
  public void testDeleteByTenantId_thenThrowEntityVersionMismatchException() {
    // Arrange
    doNothing().when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    ArrayList<RuleChain> data = new ArrayList<>();
    data.add(new RuleChain());
    PageData<RuleChain> pageData = new PageData<>(data, 100, 100L, true);

    doThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable())).when(ruleChainDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(ruleChainDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService).publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  public void testExportTenantRuleChains() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    RuleChainData actualExportTenantRuleChainsResult = baseRuleChainService
        .exportTenantRuleChains(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertTrue(actualExportTenantRuleChainsResult.getMetadata().isEmpty());
    assertTrue(actualExportTenantRuleChainsResult.getRuleChains().isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  public void testExportTenantRuleChains_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    RuleChainData actualExportTenantRuleChainsResult = baseRuleChainService
        .exportTenantRuleChains(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertTrue(actualExportTenantRuleChainsResult.getMetadata().isEmpty());
    assertTrue(actualExportTenantRuleChainsResult.getRuleChains().isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  public void testExportTenantRuleChains_thenThrowConstraintViolationException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseRuleChainService.exportTenantRuleChains(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  public void testExportTenantRuleChains_thenThrowEntityVersionMismatchException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.exportTenantRuleChains(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return Metadata Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  public void testExportTenantRuleChains_whenFirst_page_thenReturnMetadataEmpty() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    RuleChainData actualExportTenantRuleChainsResult = baseRuleChainService
        .exportTenantRuleChains(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertTrue(actualExportTenantRuleChainsResult.getMetadata().isEmpty());
    assertTrue(actualExportTenantRuleChainsResult.getRuleChains().isEmpty());
  }

  /**
   * Test
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}
   */
  @Test
  public void testImportTenantRuleChains() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getVersion())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .importTenantRuleChains(ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}
   */
  @Test
  public void testImportTenantRuleChains2() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(null);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .importTenantRuleChains(ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData).getFirstNodeIndex();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}.
   * <ul>
   *   <li>Given {@link RuleChainDao} {@link Dao#save(TenantId, Object)} return
   * {@link RuleChain#RuleChain()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}
   */
  @Test
  public void testImportTenantRuleChains_givenRuleChainDaoSaveReturnRuleChain_thenReturnEmpty() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(new RuleChain());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(null);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act
    List<RuleChainImportResult> actualImportTenantRuleChainsResult = baseRuleChainService
        .importTenantRuleChains(ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class));

    // Assert
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData).getFirstNodeIndex();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).save(isA(TenantId.class), isA(RuleChain.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertTrue(actualImportTenantRuleChainsResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}.
   * <ul>
   *   <li>Given {@link RuleChainDao}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}
   */
  @Test
  public void testImportTenantRuleChains_givenRuleChainDao_thenReturnEmpty() {
    // Arrange
    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertTrue(baseRuleChainService
        .importTenantRuleChains(ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class))
        .isEmpty());
  }

  /**
   * Test
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}.
   * <ul>
   *   <li>Then calls {@link RuleChainConnectionInfo#getAdditionalInfo()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}
   */
  @Test
  public void testImportTenantRuleChains_thenCallsGetAdditionalInfo() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(new RuleChain());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleNode ruleNode = mock(RuleNode.class);
    when(ruleNode.getId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    when(ruleNodeDao.save(Mockito.<TenantId>any(), Mockito.<RuleNode>any())).thenReturn(ruleNode);
    RuleChainConnectionInfo ruleChainConnectionInfo = mock(RuleChainConnectionInfo.class);
    when(ruleChainConnectionInfo.getFromIndex())
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainConnectionInfo.getAdditionalInfo())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(ruleChainConnectionInfo.getTargetRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    doNothing().when(ruleChainConnectionInfo).setAdditionalInfo(Mockito.<JsonNode>any());
    doNothing().when(ruleChainConnectionInfo).setFromIndex(anyInt());
    doNothing().when(ruleChainConnectionInfo).setTargetRuleChainId(Mockito.<RuleChainId>any());
    doNothing().when(ruleChainConnectionInfo).setType(Mockito.<String>any());
    ruleChainConnectionInfo.setAdditionalInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));
    ruleChainConnectionInfo.setType("Incorrect rule chain id.");

    ArrayList<RuleChainConnectionInfo> ruleChainConnectionInfoList = new ArrayList<>();
    ruleChainConnectionInfoList.add(ruleChainConnectionInfo);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(ruleChainConnectionInfoList);
    when(ruleChainMetaData.getFirstNodeIndex()).thenReturn(null);
    when(ruleChainMetaData.getConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .importTenantRuleChains(ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChainConnectionInfo).getAdditionalInfo();
    verify(ruleChainConnectionInfo).getFromIndex();
    verify(ruleChainConnectionInfo).getTargetRuleChainId();
    verify(ruleChainConnectionInfo).setAdditionalInfo(isA(JsonNode.class));
    verify(ruleChainConnectionInfo).setFromIndex(eq(1));
    verify(ruleChainConnectionInfo).setTargetRuleChainId(isA(RuleChainId.class));
    verify(ruleChainConnectionInfo).setType(eq("Incorrect rule chain id."));
    verify(ruleChainMetaData, atLeast(1)).getConnections();
    verify(ruleChainMetaData).getFirstNodeIndex();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleNode).getId();
    verify(ruleChainDao, atLeast(1)).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleNodeDao).save(isA(TenantId.class), isA(RuleNode.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}
   */
  @Test
  public void testImportTenantRuleChains_thenThrowConstraintViolationException() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getConnections()).thenThrow(
        new ConstraintViolationException("An error occurred", new SQLException(), "Incorrect rule chain id."));
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> baseRuleChainService
        .importTenantRuleChains(ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean, Function)}
   */
  @Test
  public void testImportTenantRuleChains_thenThrowEntityVersionMismatchException() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .importTenantRuleChains(ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}.
   * <ul>
   *   <li>Given {@link Edge} {@link Edge#getTenantId()} return
   * {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}
   */
  @Test
  public void testAssignRuleChainToEdge_givenEdgeGetTenantIdReturnSystem_tenant() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(edge);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRuleChainService.assignRuleChainToEdge(ModelConstants.SYSTEM_TENANT, ruleChainId, null));
    verify(edge).getTenantId();
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}.
   * <ul>
   *   <li>Given {@link Edge} {@link Edge#getTenantId()} return
   * {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}
   */
  @Test
  public void testAssignRuleChainToEdge_givenEdgeGetTenantIdReturnSystem_tenant2() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(edge);

    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRuleChainService.assignRuleChainToEdge(ModelConstants.SYSTEM_TENANT, ruleChainId, null));
    verify(edge).getTenantId();
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}.
   * <ul>
   *   <li>Given {@link Edge} {@link Edge#getTenantId()} return
   * {@link TenantId#TenantId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}
   */
  @Test
  public void testAssignRuleChainToEdge_givenEdgeGetTenantIdReturnTenantIdWithIdIsNull() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(new TenantId(null));
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(edge);

    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRuleChainService.assignRuleChainToEdge(ModelConstants.SYSTEM_TENANT, ruleChainId, null));
    verify(edge).getTenantId();
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}.
   * <ul>
   *   <li>Given {@link Edge} {@link Edge#getTenantId()} return
   * {@link TenantId#TenantId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}
   */
  @Test
  public void testAssignRuleChainToEdge_givenEdgeGetTenantIdReturnTenantIdWithIdIsNull_uuid() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(new TenantId(ModelConstants.NULL_UUID));
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(edge);

    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRuleChainService.assignRuleChainToEdge(ModelConstants.SYSTEM_TENANT, ruleChainId, null));
    verify(edge).getTenantId();
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}.
   * <ul>
   *   <li>Given {@link Edge} {@link Edge#getTenantId()} return
   * {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}
   */
  @Test
  public void testAssignRuleChainToEdge_givenEdgeGetTenantIdReturnTenantIdWithIdIsRandomUUID() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(edge);

    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRuleChainService.assignRuleChainToEdge(ModelConstants.SYSTEM_TENANT, ruleChainId, null));
    verify(edge).getTenantId();
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}.
   * <ul>
   *   <li>Given {@link EdgeService}
   * {@link EdgeService#findEdgeById(TenantId, EdgeId)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}
   */
  @Test
  public void testAssignRuleChainToEdge_givenEdgeServiceFindEdgeByIdReturnNull() {
    // Arrange
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(null);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRuleChainService.assignRuleChainToEdge(ModelConstants.SYSTEM_TENANT, ruleChainId, null));
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}
   */
  @Test
  public void testAssignRuleChainToEdge_thenThrowEntityVersionMismatchException() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.assignRuleChainToEdge(ModelConstants.SYSTEM_TENANT, ruleChainId, null));
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId, boolean)}.
   * <ul>
   *   <li>Then return {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId, boolean)}
   */
  @Test
  public void testUnassignRuleChainFromEdge_thenReturnRuleChain() {
    // Arrange
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(new Edge());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any())).thenReturn(true);
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    RuleChain actualUnassignRuleChainFromEdgeResult = baseRuleChainService
        .unassignRuleChainFromEdge(ModelConstants.SYSTEM_TENANT, ruleChainId, null, true);

    // Assert
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(ruleChain, actualUnassignRuleChainFromEdgeResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId, boolean)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId, boolean)}
   */
  @Test
  public void testUnassignRuleChainFromEdge_thenThrowDataValidationException() {
    // Arrange
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(null);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> baseRuleChainService.unassignRuleChainFromEdge(ModelConstants.SYSTEM_TENANT, ruleChainId, null, true));
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId, boolean)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId, boolean)}
   */
  @Test
  public void testUnassignRuleChainFromEdge_thenThrowEntityVersionMismatchException() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.unassignRuleChainFromEdge(ModelConstants.SYSTEM_TENANT, ruleChainId, null, true));
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId, boolean)}.
   * <ul>
   *   <li>When {@code false}.</li>
   *   <li>Then return {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId, boolean)}
   */
  @Test
  public void testUnassignRuleChainFromEdge_whenFalse_thenReturnRuleChain() {
    // Arrange
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(new Edge());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any())).thenReturn(true);
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    RuleChain actualUnassignRuleChainFromEdgeResult = baseRuleChainService
        .unassignRuleChainFromEdge(ModelConstants.SYSTEM_TENANT, ruleChainId, null, false);

    // Assert
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(ruleChain, actualUnassignRuleChainFromEdgeResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantIdAndEdgeId() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult = baseRuleChainService
        .findRuleChainsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleChainDao).findRuleChainsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindRuleChainsByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA,
        actualFindRuleChainsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantIdAndEdgeId2() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult = baseRuleChainService
        .findRuleChainsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleChainDao).findRuleChainsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindRuleChainsByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA,
        actualFindRuleChainsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantIdAndEdgeId_thenThrowEntityVersionMismatchException() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.findRuleChainsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>When {@link EdgeId#EdgeId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantIdAndEdgeId_whenEdgeIdWithIdIsNull_uuid() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult = baseRuleChainService
        .findRuleChainsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, new EdgeId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainDao).findRuleChainsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindRuleChainsByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA,
        actualFindRuleChainsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)}
   */
  @Test
  public void testFindRuleChainsByTenantIdAndEdgeId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndEdgeId(Mockito.<UUID>any(), Mockito.<UUID>any(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult = baseRuleChainService
        .findRuleChainsByTenantIdAndEdgeId(ModelConstants.SYSTEM_TENANT, edgeId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(ruleChainDao).findRuleChainsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindRuleChainsByTenantIdAndEdgeIdResult.EMPTY_PAGE_DATA,
        actualFindRuleChainsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#getEdgeTemplateRootRuleChain(TenantId)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getEdgeTemplateRootRuleChain(TenantId)}
   */
  @Test
  public void testGetEdgeTemplateRootRuleChain_thenThrowEntityVersionMismatchException() {
    // Arrange
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.getEdgeTemplateRootRuleChain(ModelConstants.SYSTEM_TENANT));
    verify(ruleChainDao).findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
  }

  /**
   * Test {@link BaseRuleChainService#getEdgeTemplateRootRuleChain(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#getEdgeTemplateRootRuleChain(TenantId)}
   */
  @Test
  public void testGetEdgeTemplateRootRuleChain_whenSystem_tenant_thenReturnRuleChain() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain);

    // Act
    RuleChain actualEdgeTemplateRootRuleChain = baseRuleChainService
        .getEdgeTemplateRootRuleChain(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(ruleChainDao).findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
    assertSame(ruleChain, actualEdgeTemplateRootRuleChain);
  }

  /**
   * Test
   * {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  public void testSetEdgeTemplateRootRuleChain() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(new RuleChain());
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(null);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    boolean actualSetEdgeTemplateRootRuleChainResult = baseRuleChainService
        .setEdgeTemplateRootRuleChain(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).save(isA(TenantId.class), isA(RuleChain.class));
    verify(ruleChainDao).findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
    assertTrue(actualSetEdgeTemplateRootRuleChainResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  public void testSetEdgeTemplateRootRuleChain_givenNull_uuid_thenCallsGetId() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    RuleChain ruleChain2 = mock(RuleChain.class);
    when(ruleChain2.getId()).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain2);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.setEdgeTemplateRootRuleChain(ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId).getId();
    verify(ruleChain2).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
  }

  /**
   * Test
   * {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()} Id is
   * {@link RuleChainId#RuleChainId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  public void testSetEdgeTemplateRootRuleChain_givenRuleChainIdIsRuleChainIdWithIdIsNull_uuid() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setId(new RuleChainId(ModelConstants.NULL_UUID));
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any())).thenReturn(new RuleChain());
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain2);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    boolean actualSetEdgeTemplateRootRuleChainResult = baseRuleChainService
        .setEdgeTemplateRootRuleChain(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao, atLeast(1)).save(isA(TenantId.class), Mockito.<RuleChain>any());
    verify(ruleChainDao).findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
    assertTrue(actualSetEdgeTemplateRootRuleChainResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  public void testSetEdgeTemplateRootRuleChain_thenThrowEntityVersionMismatchException() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    RuleChain ruleChain2 = mock(RuleChain.class);
    when(ruleChain2.getId()).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain2);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .setEdgeTemplateRootRuleChain(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChain2).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
  }

  /**
   * Test
   * {@link BaseRuleChainService#setAutoAssignToEdgeRuleChain(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#setAutoAssignToEdgeRuleChain(TenantId, RuleChainId)}
   */
  @Test
  public void testSetAutoAssignToEdgeRuleChain_thenReturnTrue() {
    // Arrange
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());

    // Act
    boolean actualSetAutoAssignToEdgeRuleChainResult = baseRuleChainService
        .setAutoAssignToEdgeRuleChain(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertTrue(actualSetAutoAssignToEdgeRuleChainResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#setAutoAssignToEdgeRuleChain(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#setAutoAssignToEdgeRuleChain(TenantId, RuleChainId)}
   */
  @Test
  public void testSetAutoAssignToEdgeRuleChain_thenThrowRuntimeException() {
    // Arrange
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseRuleChainService
        .setAutoAssignToEdgeRuleChain(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#unsetAutoAssignToEdgeRuleChain(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#unsetAutoAssignToEdgeRuleChain(TenantId, RuleChainId)}
   */
  @Test
  public void testUnsetAutoAssignToEdgeRuleChain_thenReturnTrue() {
    // Arrange
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any())).thenReturn(true);

    // Act
    boolean actualUnsetAutoAssignToEdgeRuleChainResult = baseRuleChainService
        .unsetAutoAssignToEdgeRuleChain(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertTrue(actualUnsetAutoAssignToEdgeRuleChainResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#unsetAutoAssignToEdgeRuleChain(TenantId, RuleChainId)}.
   * <ul>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#unsetAutoAssignToEdgeRuleChain(TenantId, RuleChainId)}
   */
  @Test
  public void testUnsetAutoAssignToEdgeRuleChain_thenThrowRuntimeException() {
    // Arrange
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> baseRuleChainService
        .unsetAutoAssignToEdgeRuleChain(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAutoAssignToEdgeRuleChainsByTenantId() {
    // Arrange
    when(ruleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService
        .findAutoAssignToEdgeRuleChainsByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(ruleChainDao).findAutoAssignToEdgeRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test
   * {@link BaseRuleChainService#findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)}
   */
  @Test
  public void testFindAutoAssignToEdgeRuleChainsByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleChain> actualFindAutoAssignToEdgeRuleChainsByTenantIdResult = baseRuleChainService
        .findAutoAssignToEdgeRuleChainsByTenantId(ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainDao).findAutoAssignToEdgeRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindAutoAssignToEdgeRuleChainsByTenantIdResult.EMPTY_PAGE_DATA,
        actualFindAutoAssignToEdgeRuleChainsByTenantIdResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String)}
   * with {@code tenantId}, {@code type}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String)}
   */
  @Test
  public void testFindRuleNodesByTenantIdAndTypeWithTenantIdType() {
    // Arrange
    when(ruleNodeDao.findRuleNodesByTenantIdAndType(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.findRuleNodesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type"));
    verify(ruleNodeDao).findRuleNodesByTenantIdAndType(isA(TenantId.class), eq("Type"), eq(""));
  }

  /**
   * Test
   * {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String, String)}
   * with {@code tenantId}, {@code type}, {@code search}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String, String)}
   */
  @Test
  public void testFindRuleNodesByTenantIdAndTypeWithTenantIdTypeSearch() {
    // Arrange
    when(ruleNodeDao.findRuleNodesByTenantIdAndType(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.findRuleNodesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", "Search"));
    verify(ruleNodeDao).findRuleNodesByTenantIdAndType(isA(TenantId.class), eq("Type"), eq("Search"));
  }

  /**
   * Test
   * {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String, String)}
   * with {@code tenantId}, {@code type}, {@code search}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String, String)}
   */
  @Test
  public void testFindRuleNodesByTenantIdAndTypeWithTenantIdTypeSearch_thenReturnEmpty() {
    // Arrange
    when(ruleNodeDao.findRuleNodesByTenantIdAndType(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<RuleNode> actualFindRuleNodesByTenantIdAndTypeResult = baseRuleChainService
        .findRuleNodesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", "Search");

    // Assert
    verify(ruleNodeDao).findRuleNodesByTenantIdAndType(isA(TenantId.class), eq("Type"), eq("Search"));
    assertTrue(actualFindRuleNodesByTenantIdAndTypeResult.isEmpty());
  }

  /**
   * Test
   * {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String)}
   * with {@code tenantId}, {@code type}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String)}
   */
  @Test
  public void testFindRuleNodesByTenantIdAndTypeWithTenantIdType_thenReturnEmpty() {
    // Arrange
    when(ruleNodeDao.findRuleNodesByTenantIdAndType(Mockito.<TenantId>any(), Mockito.<String>any(),
        Mockito.<String>any())).thenReturn(new ArrayList<>());

    // Act
    List<RuleNode> actualFindRuleNodesByTenantIdAndTypeResult = baseRuleChainService
        .findRuleNodesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type");

    // Assert
    verify(ruleNodeDao).findRuleNodesByTenantIdAndType(isA(TenantId.class), eq("Type"), eq(""));
    assertTrue(actualFindRuleNodesByTenantIdAndTypeResult.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByType() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByType(Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult = baseRuleChainService.findAllRuleNodesByType("Type",
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleNodeDao).findAllRuleNodesByType(eq("Type"), isA(PageLink.class));
    assertSame(actualFindAllRuleNodesByTypeResult.EMPTY_PAGE_DATA, actualFindAllRuleNodesByTypeResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}.
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is
   * {@code ASC}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByType_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByType(Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult = baseRuleChainService.findAllRuleNodesByType("Type",
        pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleNodeDao).findAllRuleNodesByType(eq("Type"), isA(PageLink.class));
    assertSame(actualFindAllRuleNodesByTypeResult.EMPTY_PAGE_DATA, actualFindAllRuleNodesByTypeResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByType_thenThrowConstraintViolationException() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseRuleChainService.findAllRuleNodesByType("Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByType_thenThrowEntityVersionMismatchException() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.findAllRuleNodesByType("Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}.
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByType_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByType(Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult = baseRuleChainService.findAllRuleNodesByType("Type",
        BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeDao).findAllRuleNodesByType(eq("Type"), isA(PageLink.class));
    assertSame(actualFindAllRuleNodesByTypeResult.EMPTY_PAGE_DATA, actualFindAllRuleNodesByTypeResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByTypeAndVersionLessThan() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult = baseRuleChainService
        .findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleNodeDao).findAllRuleNodesByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(actualFindAllRuleNodesByTypeAndVersionLessThanResult.EMPTY_PAGE_DATA,
        actualFindAllRuleNodesByTypeAndVersionLessThanResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByTypeAndVersionLessThan2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByTypeAndVersionLessThan3() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult = baseRuleChainService
        .findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleNodeDao).findAllRuleNodesByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(actualFindAllRuleNodesByTypeAndVersionLessThanResult.EMPTY_PAGE_DATA,
        actualFindAllRuleNodesByTypeAndVersionLessThanResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByTypeAndVersionLessThan4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodesByTypeAndVersionLessThan_thenReturnEmpty_page_data() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult = baseRuleChainService
        .findAllRuleNodesByTypeAndVersionLessThan("Type", 1, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeDao).findAllRuleNodesByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(actualFindAllRuleNodesByTypeAndVersionLessThanResult.EMPTY_PAGE_DATA,
        actualFindAllRuleNodesByTypeAndVersionLessThanResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan() {
    // Arrange
    PageData<RuleNodeId> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult = baseRuleChainService
        .findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleNodeDao).findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.EMPTY_PAGE_DATA,
        actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), "Constraint Name"));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(ConstraintViolationException.class,
        () -> baseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test
   * {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan3() {
    // Arrange
    PageData<RuleNodeId> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("", SortOrder.Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(3);

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult = baseRuleChainService
        .findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleNodeDao).findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.EMPTY_PAGE_DATA,
        actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult);
  }

  /**
   * Test
   * {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(3);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test
   * {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan_thenReturnEmpty_page_data() {
    // Arrange
    PageData<RuleNodeId> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(Mockito.<String>any(), anyInt(),
        Mockito.<PageLink>any())).thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult = baseRuleChainService
        .findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeDao).findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult.EMPTY_PAGE_DATA,
        actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByIds(List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainService#findAllRuleNodesByIds(List)}
   */
  @Test
  public void testFindAllRuleNodesByIds_thenReturnEmpty() {
    // Arrange
    when(ruleNodeDao.findAllRuleNodeByIds(Mockito.<List<RuleNodeId>>any())).thenReturn(new ArrayList<>());

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    List<RuleNode> actualFindAllRuleNodesByIdsResult = baseRuleChainService.findAllRuleNodesByIds(ruleNodeIds);

    // Assert
    verify(ruleNodeDao).findAllRuleNodeByIds(isA(List.class));
    assertTrue(actualFindAllRuleNodesByIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByIds(List)}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainService#findAllRuleNodesByIds(List)}
   */
  @Test
  public void testFindAllRuleNodesByIds_thenReturnEmpty2() {
    // Arrange
    when(ruleNodeDao.findAllRuleNodeByIds(Mockito.<List<RuleNodeId>>any())).thenReturn(new ArrayList<>());

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    List<RuleNode> actualFindAllRuleNodesByIdsResult = baseRuleChainService.findAllRuleNodesByIds(ruleNodeIds);

    // Assert
    verify(ruleNodeDao).findAllRuleNodeByIds(isA(List.class));
    assertTrue(actualFindAllRuleNodesByIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByIds(List)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainService#findAllRuleNodesByIds(List)}
   */
  @Test
  public void testFindAllRuleNodesByIds_thenThrowEntityVersionMismatchException() {
    // Arrange
    when(ruleNodeDao.findAllRuleNodeByIds(Mockito.<List<RuleNodeId>>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class, () -> baseRuleChainService.findAllRuleNodesByIds(ruleNodeIds));
    verify(ruleNodeDao).findAllRuleNodeByIds(isA(List.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleNode(TenantId, RuleNode)}.
   * <ul>
   *   <li>Given {@link RuleNodeDao} {@link Dao#save(TenantId, Object)} return
   * {@link RuleNode#RuleNode()}.</li>
   *   <li>Then return {@link RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleNode(TenantId, RuleNode)}
   */
  @Test
  public void testSaveRuleNode_givenRuleNodeDaoSaveReturnRuleNode_thenReturnRuleNode() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeDao.save(Mockito.<TenantId>any(), Mockito.<RuleNode>any())).thenReturn(ruleNode);

    // Act
    RuleNode actualSaveRuleNodeResult = baseRuleChainService.saveRuleNode(ModelConstants.SYSTEM_TENANT, new RuleNode());

    // Assert
    verify(ruleNodeDao).save(isA(TenantId.class), isA(RuleNode.class));
    assertSame(ruleNode, actualSaveRuleNodeResult);
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleNode(TenantId, RuleNode)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#saveRuleNode(TenantId, RuleNode)}
   */
  @Test
  public void testSaveRuleNode_thenThrowEntityVersionMismatchException() {
    // Arrange
    when(ruleNodeDao.save(Mockito.<TenantId>any(), Mockito.<RuleNode>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.saveRuleNode(ModelConstants.SYSTEM_TENANT, new RuleNode()));
    verify(ruleNodeDao).save(isA(TenantId.class), isA(RuleNode.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleNodes(TenantId, RuleChainId)} with
   * {@code tenantId}, {@code ruleChainId}.
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#deleteRuleNodes(TenantId, RuleChainId)}
   */
  @Test
  public void testDeleteRuleNodesWithTenantIdRuleChainId() {
    // Arrange
    doNothing().when(cleanUpService).cleanUpRelatedData(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    EntityRelation entityRelation = new EntityRelation();
    entityRelation.setTo(BaseEntityService.NULL_CUSTOMER_ID);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    doNothing().when(ruleNodeDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    baseRuleChainService.deleteRuleNodes(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleNodeDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).cleanUpRelatedData(isA(TenantId.class), isA(EntityId.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleNodes(TenantId, RuleChainId)} with
   * {@code tenantId}, {@code ruleChainId}.
   * <ul>
   *   <li>Then calls
   * {@link RelationService#findByFrom(TenantId, EntityId, RelationTypeGroup)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#deleteRuleNodes(TenantId, RuleChainId)}
   */
  @Test
  public void testDeleteRuleNodesWithTenantIdRuleChainId_thenCallsFindByFrom() {
    // Arrange
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    // Act
    baseRuleChainService.deleteRuleNodes(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleNodes(TenantId, RuleChainId)} with
   * {@code tenantId}, {@code ruleChainId}.
   * <ul>
   *   <li>Then calls {@link EntityId#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#deleteRuleNodes(TenantId, RuleChainId)}
   */
  @Test
  public void testDeleteRuleNodesWithTenantIdRuleChainId_thenCallsGetId() {
    // Arrange
    doNothing().when(cleanUpService).cleanUpRelatedData(Mockito.<TenantId>any(), Mockito.<EntityId>any());
    EntityId resultTo = mock(EntityId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityRelation entityRelation = new EntityRelation();
    entityRelation.setTo(resultTo);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);
    when(relationService.findByFrom(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    doNothing().when(ruleNodeDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    baseRuleChainService.deleteRuleNodes(ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(resultTo).getId();
    verify(ruleNodeDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).cleanUpRelatedData(isA(TenantId.class), isA(EntityId.class));
    verify(relationService).findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link RuleNodeDao} {@link Dao#findById(TenantId, UUID)} return
   * {@link RuleNode#RuleNode()}.</li>
   *   <li>Then return {@link Optional#get()} is {@link RuleNode#RuleNode()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenRuleNodeDaoFindByIdReturnRuleNode_thenReturnGetIsRuleNode() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleNode);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_NODE);

    // Act
    Optional<HasId<?>> actualFindEntityResult = baseRuleChainService.findEntity(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(ruleNode, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseRuleChainService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@link RuleNodeDao}.</li>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.</li>
   *   <li>Then return {@link Optional#get()} is {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenRuleNodeDao_whenNull_customer_id_thenReturnGetIsRuleChain() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    Optional<HasId<?>> actualFindEntityResult = baseRuleChainService.findEntity(ModelConstants.SYSTEM_TENANT,
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(ruleChain, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseRuleChainService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Given {@code TENANT}.</li>
   *   <li>Then return {@link Optional#get()} is {@link RuleChain#RuleChain()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_givenTenant_thenReturnGetIsRuleChain() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    Optional<HasId<?>> actualFindEntityResult = baseRuleChainService.findEntity(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(ruleChain, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseRuleChainService#findEntity(TenantId, EntityId)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRuleChainService#findEntity(TenantId, EntityId)}
   */
  @Test
  public void testFindEntity_thenThrowEntityVersionMismatchException() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new RuleChain());
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_NODE);

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.findEntity(ModelConstants.SYSTEM_TENANT, entityId));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#countByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link RuleChainDao}
   * {@link TenantEntityDao#countByTenantId(TenantId)} return one.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainService#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_givenRuleChainDaoCountByTenantIdReturnOne_thenReturnOne() {
    // Arrange
    when(ruleChainDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountByTenantIdResult = baseRuleChainService.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(ruleChainDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountByTenantIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#countByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRuleChainService#countByTenantId(TenantId)}
   */
  @Test
  public void testCountByTenantId_thenThrowEntityVersionMismatchException() {
    // Arrange
    when(ruleChainDao.countByTenantId(Mockito.<TenantId>any()))
        .thenThrow(new EntityVersionMismatchException("0123456789ABCDEF", new Throwable()));

    // Act and Assert
    assertThrows(EntityVersionMismatchException.class,
        () -> baseRuleChainService.countByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(ruleChainDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseRuleChainService#getEntityType()}.
   * <p>
   * Method under test: {@link BaseRuleChainService#getEntityType()}
   */
  @Test
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.RULE_CHAIN, (new BaseRuleChainService()).getEntityType());
  }
}
