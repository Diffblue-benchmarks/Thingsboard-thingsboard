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
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.exception.EntityVersionMismatchException;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.common.data.rule.RuleChainConnectionInfo;
import org.thingsboard.server.common.data.rule.RuleChainData;
import org.thingsboard.server.common.data.rule.RuleChainMetaData;
import org.thingsboard.server.common.data.rule.RuleChainType;
import org.thingsboard.server.common.data.rule.RuleChainUpdateResult;
import org.thingsboard.server.common.data.rule.RuleNode;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityCountService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseRuleChainService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseRuleChainServiceDiffblueTest {
  @Autowired private BaseRuleChainService baseRuleChainService;

  @MockBean private CleanUpService cleanUpService;

  @MockBean private DataValidator<RuleChain> dataValidator;

  @MockBean private EdgeService edgeService;

  @MockBean private EntityCountService entityCountService;

  @MockBean private RelationService relationService;

  @MockBean private RuleChainDao ruleChainDao;

  @MockBean private RuleNodeDao ruleNodeDao;

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain)} with {@code ruleChain}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain)"})
  public void testSaveRuleChainWithRuleChain() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.saveRuleChain(new RuleChain()));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain)} with {@code ruleChain}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain)"})
  public void testSaveRuleChainWithRuleChain2() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenThrow(entityVersionMismatchException);
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.saveRuleChain(new RuleChain()));
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain)} with {@code ruleChain}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain)"})
  public void testSaveRuleChainWithRuleChain3() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    RuleChain ruleChain = mock(RuleChain.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(ruleChain.getTenantId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseRuleChainService.saveRuleChain(ruleChain));
    verify(ruleChain).getTenantId();
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain)} with {@code ruleChain}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain)"})
  public void testSaveRuleChainWithRuleChain4() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    RuleChain ruleChain = mock(RuleChain.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), "");
    when(ruleChain.getTenantId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseRuleChainService.saveRuleChain(ruleChain));
    verify(ruleChain).getTenantId();
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with {@code ruleChain},
   * {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain, boolean)"})
  public void testSaveRuleChainWithRuleChainPublishSaveEvent() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.saveRuleChain(new RuleChain(), true));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with {@code ruleChain},
   * {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain, boolean)"})
  public void testSaveRuleChainWithRuleChainPublishSaveEvent2() {
    // Arrange
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenReturn(new RuleChain());
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act
    RuleChain actualSaveRuleChainResult = baseRuleChainService.saveRuleChain(ruleChain, true);

    // Assert
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
    assertNull(actualSaveRuleChainResult.getConfigurationBytes());
    assertNull(actualSaveRuleChainResult.getAdditionalInfo());
    assertNull(actualSaveRuleChainResult.getConfiguration());
    assertNull(actualSaveRuleChainResult.getVersion());
    assertNull(actualSaveRuleChainResult.getName());
    assertNull(actualSaveRuleChainResult.getUuidId());
    assertNull(actualSaveRuleChainResult.getExternalId());
    assertNull(actualSaveRuleChainResult.getId());
    assertNull(actualSaveRuleChainResult.getFirstRuleNodeId());
    assertNull(actualSaveRuleChainResult.getTenantId());
    assertNull(actualSaveRuleChainResult.getType());
    assertEquals(0L, actualSaveRuleChainResult.getCreatedTime());
    assertFalse(actualSaveRuleChainResult.isDebugMode());
    assertFalse(actualSaveRuleChainResult.isDefault());
    assertFalse(actualSaveRuleChainResult.isRoot());
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with {@code ruleChain},
   * {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain, boolean)"})
  public void testSaveRuleChainWithRuleChainPublishSaveEvent3() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenThrow(entityVersionMismatchException);
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.saveRuleChain(new RuleChain(), true));
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with {@code ruleChain},
   * {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain, boolean)"})
  public void testSaveRuleChainWithRuleChainPublishSaveEvent4() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    RuleChain ruleChain = mock(RuleChain.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(ruleChain.getTenantId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseRuleChainService.saveRuleChain(ruleChain, true));
    verify(ruleChain).getTenantId();
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with {@code ruleChain},
   * {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain, boolean)"})
  public void testSaveRuleChainWithRuleChainPublishSaveEvent5() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    RuleChain ruleChain = mock(RuleChain.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), "");
    when(ruleChain.getTenantId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseRuleChainService.saveRuleChain(ruleChain, true));
    verify(ruleChain).getTenantId();
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with {@code ruleChain},
   * {@code publishSaveEvent}.
   *
   * <ul>
   *   <li>Then return {@link RuleChain#RuleChain()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain, boolean)"})
  public void testSaveRuleChainWithRuleChainPublishSaveEvent_thenReturnRuleChain() {
    // Arrange
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenReturn(ruleChain);
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
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
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)} with {@code ruleChain},
   * {@code publishSaveEvent}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain, boolean)"})
  public void testSaveRuleChainWithRuleChainPublishSaveEvent_thenThrowDataValidationException() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    RuleChain ruleChain = mock(RuleChain.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "rule_chain_external_id_unq_key");
    when(ruleChain.getTenantId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> baseRuleChainService.saveRuleChain(ruleChain, true));
    verify(ruleChain).getTenantId();
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain)} with {@code ruleChain}.
   *
   * <ul>
   *   <li>Then return ConfigurationBytes is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain)"})
  public void testSaveRuleChainWithRuleChain_thenReturnConfigurationBytesIsNull() {
    // Arrange
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenReturn(new RuleChain());
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act
    RuleChain actualSaveRuleChainResult = baseRuleChainService.saveRuleChain(ruleChain);

    // Assert
    verify(ruleChainDao).saveAndFlush(isNull(), isA(RuleChain.class));
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
    assertNull(actualSaveRuleChainResult.getConfigurationBytes());
    assertNull(actualSaveRuleChainResult.getAdditionalInfo());
    assertNull(actualSaveRuleChainResult.getConfiguration());
    assertNull(actualSaveRuleChainResult.getVersion());
    assertNull(actualSaveRuleChainResult.getName());
    assertNull(actualSaveRuleChainResult.getUuidId());
    assertNull(actualSaveRuleChainResult.getExternalId());
    assertNull(actualSaveRuleChainResult.getId());
    assertNull(actualSaveRuleChainResult.getFirstRuleNodeId());
    assertNull(actualSaveRuleChainResult.getTenantId());
    assertNull(actualSaveRuleChainResult.getType());
    assertEquals(0L, actualSaveRuleChainResult.getCreatedTime());
    assertFalse(actualSaveRuleChainResult.isDebugMode());
    assertFalse(actualSaveRuleChainResult.isDefault());
    assertFalse(actualSaveRuleChainResult.isRoot());
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain)} with {@code ruleChain}.
   *
   * <ul>
   *   <li>Then return {@link RuleChain#RuleChain()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain)"})
  public void testSaveRuleChainWithRuleChain_thenReturnRuleChain() {
    // Arrange
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenReturn(ruleChain);
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
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
   * Test {@link BaseRuleChainService#saveRuleChain(RuleChain)} with {@code ruleChain}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChain(RuleChain)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.saveRuleChain(RuleChain)"})
  public void testSaveRuleChainWithRuleChain_thenThrowDataValidationException() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<RuleChain>any(), Mockito.<Function<RuleChain, TenantId>>any()))
        .thenReturn(new RuleChain());

    RuleChain ruleChain = mock(RuleChain.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "rule_chain_external_id_unq_key");
    when(ruleChain.getTenantId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> baseRuleChainService.saveRuleChain(ruleChain));
    verify(ruleChain).getTenantId();
    verify(dataValidator).validate(isA(RuleChain.class), isA(Function.class));
  }

  /**
   * Test {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRuleChainService.setRootRuleChain(TenantId, RuleChainId)"})
  public void testSetRootRuleChain() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.setRootRuleChain(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRuleChainService.setRootRuleChain(TenantId, RuleChainId)"})
  public void testSetRootRuleChain2() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.setRootRuleChain(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRuleChainService.setRootRuleChain(TenantId, RuleChainId)"})
  public void testSetRootRuleChain3() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenReturn(new RuleChain());
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(null);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    boolean actualSetRootRuleChainResult =
        baseRuleChainService.setRootRuleChain(
            ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).save(isA(TenantId.class), isA(RuleChain.class));
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE));
    assertTrue(actualSetRootRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link RuleChainId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRuleChainService.setRootRuleChain(TenantId, RuleChainId)"})
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
    boolean actualSetRootRuleChainResult =
        baseRuleChainService.setRootRuleChain(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChainId).getId();
    verify(ruleChain).isRoot();
    verify(ruleChain).setTenantId(isA(TenantId.class));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualSetRootRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()} Id is {@link RuleChainId#RuleChainId(UUID)} with id
   *       is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRuleChainService.setRootRuleChain(TenantId, RuleChainId)"})
  public void testSetRootRuleChain_givenRuleChainIdIsRuleChainIdWithIdIsNull_uuid() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setId(new RuleChainId(ModelConstants.NULL_UUID));
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenReturn(new RuleChain());
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain2);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    boolean actualSetRootRuleChainResult =
        baseRuleChainService.setRootRuleChain(
            ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao, atLeast(1)).save(isA(TenantId.class), Mockito.<RuleChain>any());
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE));
    assertTrue(actualSetRootRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link RuleChain} {@link RuleChain#isRoot()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRuleChainService.setRootRuleChain(TenantId, RuleChainId)"})
  public void testSetRootRuleChain_givenRuleChainIsRootReturnTrue_thenReturnFalse() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    doNothing().when(ruleChain).setTenantId(Mockito.<TenantId>any());
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    boolean actualSetRootRuleChainResult =
        baseRuleChainService.setRootRuleChain(
            ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChain).isRoot();
    verify(ruleChain).setTenantId(isA(TenantId.class));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualSetRootRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleChain#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#setRootRuleChain(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean BaseRuleChainService.setRootRuleChain(TenantId, RuleChainId)"})
  public void testSetRootRuleChain_thenCallsGetId() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);

    RuleChain ruleChain2 = mock(RuleChain.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain2.getId()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain2);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.setRootRuleChain(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChain2).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)"
  })
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(null);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)"
  })
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater2() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenReturn(new RuleChain());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new RuleChain());

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(null);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act
    RuleChainUpdateResult actualSaveRuleChainMetaDataResult =
        baseRuleChainService.saveRuleChainMetaData(
            ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).save(isA(TenantId.class), isA(RuleChain.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertTrue(actualSaveRuleChainMetaDataResult.getUpdatedRuleNodes().isEmpty());
    assertTrue(actualSaveRuleChainMetaDataResult.isSuccess());
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)"
  })
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater3() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new RuleChain());

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(null);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).save(isA(TenantId.class), isA(RuleChain.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)"
  })
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater4() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(null);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act
    RuleChainUpdateResult actualSaveRuleChainMetaDataResult =
        baseRuleChainService.saveRuleChainMetaData(
            ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualSaveRuleChainMetaDataResult.getUpdatedRuleNodes());
    assertFalse(actualSaveRuleChainMetaDataResult.isSuccess());
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)"
  })
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater5() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = mock(RuleChain.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getId()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(null);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChain).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)"
  })
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater6() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenReturn(1L);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getId()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(1L);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChain).getId();
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)"
  })
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater7() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getVersion()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(1L);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)"
  })
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater8() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenReturn(1L);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getId()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(1L);
    ruleChainMetaData.setNodes(new ArrayList<>());
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChain).getId();
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)"
  })
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater9() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenReturn(1L);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getId()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(1L);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(new ArrayList<>());
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChain).getId();
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)"
  })
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater10() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenThrow(new DataValidationException("An error occurred"));
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(1L);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(ruleChainId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function,
   * boolean)} with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}, {@code
   * publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)"
  })
  public void
      testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(null);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), false));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function,
   * boolean)} with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}, {@code
   * publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)"
  })
  public void
      testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent2() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenReturn(new RuleChain());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new RuleChain());

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(null);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act
    RuleChainUpdateResult actualSaveRuleChainMetaDataResult =
        baseRuleChainService.saveRuleChainMetaData(
            ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), false);

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).save(isA(TenantId.class), isA(RuleChain.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertTrue(actualSaveRuleChainMetaDataResult.getUpdatedRuleNodes().isEmpty());
    assertTrue(actualSaveRuleChainMetaDataResult.isSuccess());
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function,
   * boolean)} with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}, {@code
   * publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)"
  })
  public void
      testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent3() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new RuleChain());

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(null);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), false));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).save(isA(TenantId.class), isA(RuleChain.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function,
   * boolean)} with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}, {@code
   * publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)"
  })
  public void
      testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent4() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(null);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act
    RuleChainUpdateResult actualSaveRuleChainMetaDataResult =
        baseRuleChainService.saveRuleChainMetaData(
            ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), false);

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualSaveRuleChainMetaDataResult.getUpdatedRuleNodes());
    assertFalse(actualSaveRuleChainMetaDataResult.isSuccess());
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function,
   * boolean)} with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}, {@code
   * publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)"
  })
  public void
      testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent5() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = mock(RuleChain.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getId()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(null);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), false));
    verify(ruleChain).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function,
   * boolean)} with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}, {@code
   * publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)"
  })
  public void
      testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent6() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenReturn(1L);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getId()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(1L);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), false));
    verify(ruleChain).getId();
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function,
   * boolean)} with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}, {@code
   * publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)"
  })
  public void
      testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent7() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getVersion()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(1L);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), false));
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function,
   * boolean)} with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}, {@code
   * publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)"
  })
  public void
      testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent8() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenReturn(1L);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(0L);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), false));
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function,
   * boolean)} with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}, {@code
   * publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)"
  })
  public void
      testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent9() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenReturn(1L);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getId()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(1L);
    ruleChainMetaData.setNodes(new ArrayList<>());
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), false));
    verify(ruleChain).getId();
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function,
   * boolean)} with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}, {@code
   * publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)"
  })
  public void
      testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent10() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenReturn(1L);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getId()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(1L);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(new ArrayList<>());
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), false));
    verify(ruleChain).getId();
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function,
   * boolean)} with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}, {@code
   * publishSaveEvent}.
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function, boolean)"
  })
  public void
      testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdaterPublishSaveEvent11() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenThrow(new DataValidationException("An error occurred"));
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(1L);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(ruleChainId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class), false));
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)}
   * with {@code tenantId}, {@code ruleChainMetaData}, {@code ruleNodeUpdater}.
   *
   * <ul>
   *   <li>Given zero.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleChainMetaData(TenantId,
   * RuleChainMetaData, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainUpdateResult BaseRuleChainService.saveRuleChainMetaData(TenantId, RuleChainMetaData, Function)"
  })
  public void testSaveRuleChainMetaDataWithTenantIdRuleChainMetaDataRuleNodeUpdater_givenZero() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenReturn(1L);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainMetaData ruleChainMetaData = new RuleChainMetaData();
    ruleChainMetaData.setVersion(0L);
    ruleChainMetaData.setNodes(null);
    ruleChainMetaData.setFirstNodeIndex(null);
    ruleChainMetaData.setConnections(null);
    ruleChainMetaData.setRuleChainConnections(null);
    ruleChainMetaData.setRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.saveRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, ruleChainMetaData, mock(Function.class)));
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainMetaData BaseRuleChainService.loadRuleChainMetaData(TenantId, RuleChainId)"
  })
  public void testLoadRuleChainMetaData() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.loadRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainMetaData BaseRuleChainService.loadRuleChainMetaData(TenantId, RuleChainId)"
  })
  public void testLoadRuleChainMetaData2() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getVersion()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.loadRuleChainMetaData(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainMetaData BaseRuleChainService.loadRuleChainMetaData(TenantId, RuleChainId)"
  })
  public void testLoadRuleChainMetaData3() {
    // Arrange
    RuleChainId ruleChainId = mock(RuleChainId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.loadRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return FirstNodeIndex is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainMetaData BaseRuleChainService.loadRuleChainMetaData(TenantId, RuleChainId)"
  })
  public void testLoadRuleChainMetaData_givenNull_uuid_thenReturnFirstNodeIndexIsNull() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenReturn(1L);
    when(ruleChain.getFirstRuleNodeId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    RuleChainMetaData actualLoadRuleChainMetaDataResult =
        baseRuleChainService.loadRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertNull(actualLoadRuleChainMetaDataResult.getFirstNodeIndex());
    assertNull(actualLoadRuleChainMetaDataResult.getConnections());
    assertNull(actualLoadRuleChainMetaDataResult.getRuleChainConnections());
    assertTrue(actualLoadRuleChainMetaDataResult.getNodes().isEmpty());
    assertSame(ruleChainId, actualLoadRuleChainMetaDataResult.getRuleChainId());
  }

  /**
   * Test {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link RuleChainDao} {@link RuleChainDao#findById(TenantId, UUID)} return {@code
   *       null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainMetaData BaseRuleChainService.loadRuleChainMetaData(TenantId, RuleChainId)"
  })
  public void testLoadRuleChainMetaData_givenRuleChainDaoFindByIdReturnNull_thenReturnNull() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    RuleChainMetaData actualLoadRuleChainMetaDataResult =
        baseRuleChainService.loadRuleChainMetaData(
            ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualLoadRuleChainMetaDataResult);
  }

  /**
   * Test {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then return Version is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainMetaData BaseRuleChainService.loadRuleChainMetaData(TenantId, RuleChainId)"
  })
  public void testLoadRuleChainMetaData_thenReturnVersionIsNull() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new RuleChain());
    RuleChainId ruleChainId = new RuleChainId(ModelConstants.NULL_UUID);

    // Act
    RuleChainMetaData actualLoadRuleChainMetaDataResult =
        baseRuleChainService.loadRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertNull(actualLoadRuleChainMetaDataResult.getVersion());
    assertSame(ruleChainId, actualLoadRuleChainMetaDataResult.getRuleChainId());
  }

  /**
   * Test {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then return Version longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#loadRuleChainMetaData(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainMetaData BaseRuleChainService.loadRuleChainMetaData(TenantId, RuleChainId)"
  })
  public void testLoadRuleChainMetaData_thenReturnVersionLongValueIsOne() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getVersion()).thenReturn(1L);
    when(ruleChain.getFirstRuleNodeId()).thenReturn(new RuleNodeId(ModelConstants.NULL_UUID));
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);
    RuleChainId ruleChainId = new RuleChainId(ModelConstants.NULL_UUID);

    // Act
    RuleChainMetaData actualLoadRuleChainMetaDataResult =
        baseRuleChainService.loadRuleChainMetaData(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChain, atLeast(1)).getFirstRuleNodeId();
    verify(ruleChain).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertEquals(1L, actualLoadRuleChainMetaDataResult.getVersion().longValue());
    assertSame(ruleChainId, actualLoadRuleChainMetaDataResult.getRuleChainId());
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainById(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.findRuleChainById(TenantId, RuleChainId)"})
  public void testFindRuleChainById() {
    // Arrange
    RuleChainId ruleChainId = mock(RuleChainId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findRuleChainById(ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainById(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link RuleChainId} {@link RuleChainId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.findRuleChainById(TenantId, RuleChainId)"})
  public void testFindRuleChainById_givenNull_uuid_whenRuleChainIdGetIdReturnNull_uuid() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findRuleChainById(ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainById(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then return {@link RuleChain#RuleChain()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.findRuleChainById(TenantId, RuleChainId)"})
  public void testFindRuleChainById_thenReturnRuleChain() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    RuleChain actualFindRuleChainByIdResult =
        baseRuleChainService.findRuleChainById(
            ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(ruleChain, actualFindRuleChainByIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainById(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>When {@link RuleChainId#RuleChainId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.findRuleChainById(TenantId, RuleChainId)"})
  public void testFindRuleChainById_whenRuleChainIdWithIdIsNull_uuid() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findRuleChainById(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodeById(TenantId, RuleNodeId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodeById(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNode BaseRuleChainService.findRuleNodeById(TenantId, RuleNodeId)"})
  public void testFindRuleNodeById() {
    // Arrange
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findRuleNodeById(ModelConstants.SYSTEM_TENANT, ruleNodeId));
    verify(ruleNodeId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodeById(TenantId, RuleNodeId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link RuleNodeId} {@link RuleNodeId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodeById(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNode BaseRuleChainService.findRuleNodeById(TenantId, RuleNodeId)"})
  public void testFindRuleNodeById_givenNull_uuid_whenRuleNodeIdGetIdReturnNull_uuid() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findRuleNodeById(ModelConstants.SYSTEM_TENANT, ruleNodeId));
    verify(ruleNodeId, atLeast(1)).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodeById(TenantId, RuleNodeId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDao} {@link RuleNodeDao#findById(TenantId, UUID)} return {@link
   *       RuleNode#RuleNode()}.
   *   <li>Then return {@link RuleNode#RuleNode()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodeById(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNode BaseRuleChainService.findRuleNodeById(TenantId, RuleNodeId)"})
  public void testFindRuleNodeById_givenRuleNodeDaoFindByIdReturnRuleNode_thenReturnRuleNode() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleNode);

    // Act
    RuleNode actualFindRuleNodeByIdResult =
        baseRuleChainService.findRuleNodeById(
            ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(ruleNode, actualFindRuleNodeByIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodeById(TenantId, RuleNodeId)}.
   *
   * <ul>
   *   <li>When {@link RuleNodeId#RuleNodeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodeById(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNode BaseRuleChainService.findRuleNodeById(TenantId, RuleNodeId)"})
  public void testFindRuleNodeById_whenRuleNodeIdWithIdIsNull_uuid() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findRuleNodeById(
                ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID)));
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainByIdAsync(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainByIdAsync(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRuleChainService.findRuleChainByIdAsync(TenantId, RuleChainId)"
  })
  public void testFindRuleChainByIdAsync() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findRuleChainByIdAsync(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChainDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainByIdAsync(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainByIdAsync(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRuleChainService.findRuleChainByIdAsync(TenantId, RuleChainId)"
  })
  public void testFindRuleChainByIdAsync2() {
    // Arrange
    RuleChainId ruleChainId = mock(RuleChainId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findRuleChainByIdAsync(ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainByIdAsync(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link RuleChainId} {@link RuleChainId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainByIdAsync(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRuleChainService.findRuleChainByIdAsync(TenantId, RuleChainId)"
  })
  public void testFindRuleChainByIdAsync_givenNull_uuid_whenRuleChainIdGetIdReturnNull_uuid() {
    // Arrange
    SettableFuture<RuleChain> createResult = SettableFuture.create();
    when(ruleChainDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<RuleChain> actualFindRuleChainByIdAsyncResult =
        baseRuleChainService.findRuleChainByIdAsync(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindRuleChainByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindRuleChainByIdAsyncResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainByIdAsync(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainByIdAsync(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRuleChainService.findRuleChainByIdAsync(TenantId, RuleChainId)"
  })
  public void testFindRuleChainByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<RuleChain> createResult = SettableFuture.create();
    when(ruleChainDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<RuleChain> actualFindRuleChainByIdAsyncResult =
        baseRuleChainService.findRuleChainByIdAsync(
            ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindRuleChainByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindRuleChainByIdAsyncResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodeByIdAsync(TenantId, RuleNodeId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodeByIdAsync(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRuleChainService.findRuleNodeByIdAsync(TenantId, RuleNodeId)"
  })
  public void testFindRuleNodeByIdAsync() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findRuleNodeByIdAsync(
                ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID)));
    verify(ruleNodeDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodeByIdAsync(TenantId, RuleNodeId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodeByIdAsync(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRuleChainService.findRuleNodeByIdAsync(TenantId, RuleNodeId)"
  })
  public void testFindRuleNodeByIdAsync2() {
    // Arrange
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findRuleNodeByIdAsync(ModelConstants.SYSTEM_TENANT, ruleNodeId));
    verify(ruleNodeId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodeByIdAsync(TenantId, RuleNodeId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link RuleNodeId} {@link RuleNodeId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodeByIdAsync(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRuleChainService.findRuleNodeByIdAsync(TenantId, RuleNodeId)"
  })
  public void testFindRuleNodeByIdAsync_givenNull_uuid_whenRuleNodeIdGetIdReturnNull_uuid() {
    // Arrange
    SettableFuture<RuleNode> createResult = SettableFuture.create();
    when(ruleNodeDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<RuleNode> actualFindRuleNodeByIdAsyncResult =
        baseRuleChainService.findRuleNodeByIdAsync(ModelConstants.SYSTEM_TENANT, ruleNodeId);

    // Assert
    verify(ruleNodeId, atLeast(1)).getId();
    verify(ruleNodeDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindRuleNodeByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindRuleNodeByIdAsyncResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodeByIdAsync(TenantId, RuleNodeId)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodeByIdAsync(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseRuleChainService.findRuleNodeByIdAsync(TenantId, RuleNodeId)"
  })
  public void testFindRuleNodeByIdAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<RuleNode> createResult = SettableFuture.create();
    when(ruleNodeDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<RuleNode> actualFindRuleNodeByIdAsyncResult =
        baseRuleChainService.findRuleNodeByIdAsync(
            ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleNodeDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindRuleNodeByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindRuleNodeByIdAsyncResult);
  }

  /**
   * Test {@link BaseRuleChainService#getRootTenantRuleChain(TenantId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#getRootTenantRuleChain(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.getRootTenantRuleChain(TenantId)"})
  public void testGetRootTenantRuleChain() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.getRootTenantRuleChain(ModelConstants.SYSTEM_TENANT));
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE));
  }

  /**
   * Test {@link BaseRuleChainService#getRootTenantRuleChain(TenantId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#getRootTenantRuleChain(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.getRootTenantRuleChain(TenantId)"})
  public void testGetRootTenantRuleChain2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(tenantId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.getRootTenantRuleChain(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#getRootTenantRuleChain(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getRootTenantRuleChain(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.getRootTenantRuleChain(TenantId)"})
  public void testGetRootTenantRuleChain_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    RuleChain actualRootTenantRuleChain = baseRuleChainService.getRootTenantRuleChain(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE));
    assertSame(ruleChain, actualRootTenantRuleChain);
  }

  /**
   * Test {@link BaseRuleChainService#getRootTenantRuleChain(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link RuleChain#RuleChain()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getRootTenantRuleChain(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.getRootTenantRuleChain(TenantId)"})
  public void testGetRootTenantRuleChain_whenSystem_tenant_thenReturnRuleChain() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain);

    // Act
    RuleChain actualRootTenantRuleChain =
        baseRuleChainService.getRootTenantRuleChain(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.CORE));
    assertSame(ruleChain, actualRootTenantRuleChain);
  }

  /**
   * Test {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.getRuleChainNodes(TenantId, RuleChainId)"})
  public void testGetRuleChainNodes() {
    // Arrange
    RuleChainId ruleChainId = mock(RuleChainId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.getRuleChainNodes(ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.getRuleChainNodes(TenantId, RuleChainId)"})
  public void testGetRuleChainNodes2() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    EntityRelation entityRelation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type");
    entityRelationList.add(entityRelation);
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.getRuleChainNodes(ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.getRuleChainNodes(TenantId, RuleChainId)"})
  public void testGetRuleChainNodes_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualRuleChainNodes =
        baseRuleChainService.getRuleChainNodes(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChainId).getId();
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertTrue(actualRuleChainNodes.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.getRuleChainNodes(TenantId, RuleChainId)"})
  public void testGetRuleChainNodes_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    EntityRelation entityRelation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type");
    entityRelationList.add(entityRelation);
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleNode);

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualRuleChainNodes =
        baseRuleChainService.getRuleChainNodes(ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChainId).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertEquals(1, actualRuleChainNodes.size());
    assertSame(ruleNode, actualRuleChainNodes.get(0));
  }

  /**
   * Test {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>When {@link RuleChainId#RuleChainId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getRuleChainNodes(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.getRuleChainNodes(TenantId, RuleChainId)"})
  public void testGetRuleChainNodes_whenRuleChainIdWithIdIsNull_uuid_thenReturnEmpty() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<RuleNode> actualRuleChainNodes =
        baseRuleChainService.getRuleChainNodes(
            ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    assertTrue(actualRuleChainNodes.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.getReferencingRuleChainNodes(TenantId, RuleChainId)"
  })
  public void testGetReferencingRuleChainNodes() {
    // Arrange
    RuleChainId ruleChainId = mock(RuleChainId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.getReferencingRuleChainNodes(
                ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.getReferencingRuleChainNodes(TenantId, RuleChainId)"
  })
  public void testGetReferencingRuleChainNodes2() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    EntityRelation entityRelation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type");
    entityRelationList.add(entityRelation);
    when(relationService.findByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.getReferencingRuleChainNodes(
                ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.getReferencingRuleChainNodes(TenantId, RuleChainId)"
  })
  public void testGetReferencingRuleChainNodes_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(relationService.findByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualReferencingRuleChainNodes =
        baseRuleChainService.getReferencingRuleChainNodes(
            ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChainId).getId();
    verify(relationService)
        .findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
    assertTrue(actualReferencingRuleChainNodes.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.getReferencingRuleChainNodes(TenantId, RuleChainId)"
  })
  public void testGetReferencingRuleChainNodes_thenReturnEmpty() {
    // Arrange
    when(relationService.findByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<RuleNode> actualReferencingRuleChainNodes =
        baseRuleChainService.getReferencingRuleChainNodes(
            ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(relationService)
        .findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
    assertTrue(actualReferencingRuleChainNodes.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getReferencingRuleChainNodes(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.getReferencingRuleChainNodes(TenantId, RuleChainId)"
  })
  public void testGetReferencingRuleChainNodes_thenReturnSizeIsOne() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    EntityRelation entityRelation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type");
    entityRelationList.add(entityRelation);
    when(relationService.findByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleNode);

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualReferencingRuleChainNodes =
        baseRuleChainService.getReferencingRuleChainNodes(
            ModelConstants.SYSTEM_TENANT, ruleChainId);

    // Assert
    verify(ruleChainId).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
    assertEquals(1, actualReferencingRuleChainNodes.size());
    assertSame(ruleNode, actualReferencingRuleChainNodes.get(0));
  }

  /**
   * Test {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.getRuleNodeRelations(TenantId, RuleNodeId)"})
  public void testGetRuleNodeRelations_givenNull_uuid_thenReturnEmpty() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EntityRelation> actualRuleNodeRelations =
        baseRuleChainService.getRuleNodeRelations(ModelConstants.SYSTEM_TENANT, ruleNodeId);

    // Assert
    verify(ruleNodeId).getId();
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
    assertTrue(actualRuleNodeRelations.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}.
   *
   * <ul>
   *   <li>Then return {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.getRuleNodeRelations(TenantId, RuleNodeId)"})
  public void testGetRuleNodeRelations_thenReturnArrayList() {
    // Arrange
    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    EntityRelation entityRelation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type");
    entityRelationList.add(entityRelation);
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);

    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<EntityRelation> actualRuleNodeRelations =
        baseRuleChainService.getRuleNodeRelations(ModelConstants.SYSTEM_TENANT, ruleNodeId);

    // Assert
    verify(ruleNodeId).getId();
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
    assertEquals(entityRelationList, actualRuleNodeRelations);
  }

  /**
   * Test {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}.
   *
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.getRuleNodeRelations(TenantId, RuleNodeId)"})
  public void testGetRuleNodeRelations_thenThrowEntityVersionMismatchException() {
    // Arrange
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.getRuleNodeRelations(ModelConstants.SYSTEM_TENANT, ruleNodeId));
    verify(ruleNodeId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}.
   *
   * <ul>
   *   <li>When {@link RuleNodeId#RuleNodeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getRuleNodeRelations(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.getRuleNodeRelations(TenantId, RuleNodeId)"})
  public void testGetRuleNodeRelations_whenRuleNodeIdWithIdIsNull_uuid_thenReturnEmpty() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityRelation> actualRuleNodeRelations =
        baseRuleChainService.getRuleNodeRelations(
            ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID));

    // Assert
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
    assertTrue(actualRuleNodeRelations.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)"
  })
  public void testFindTenantRuleChainsByType() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findRuleChainsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any(), Mockito.<PageLink>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findTenantRuleChainsByType(
                ModelConstants.SYSTEM_TENANT,
                RuleChainType.CORE,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(ruleChainDao)
        .findRuleChainsByTenantIdAndType(
            isA(UUID.class), eq(RuleChainType.CORE), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)"
  })
  public void testFindTenantRuleChainsByType2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(pageLink.getPageSize()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findTenantRuleChainsByType(
                ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)"
  })
  public void testFindTenantRuleChainsByType3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(pageLink.getPage()).thenThrow(entityVersionMismatchException);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findTenantRuleChainsByType(
                ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)"
  })
  public void testFindTenantRuleChainsByType4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(sortOrder.getProperty()).thenThrow(entityVersionMismatchException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findTenantRuleChainsByType(
                ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)"
  })
  public void testFindTenantRuleChainsByType5() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(tenantId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findTenantRuleChainsByType(
                tenantId, RuleChainType.CORE, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)"
  })
  public void testFindTenantRuleChainsByType_givenBy_created_time_desc() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleChain> actualFindTenantRuleChainsByTypeResult =
        baseRuleChainService.findTenantRuleChainsByType(
            ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleChainDao)
        .findRuleChainsByTenantIdAndType(
            isA(UUID.class), eq(RuleChainType.CORE), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantRuleChainsByTypeResult);
  }

  /**
   * Test {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)"
  })
  public void testFindTenantRuleChainsByType_givenNull_uuid_thenCallsGetId() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleChain> actualFindTenantRuleChainsByTypeResult =
        baseRuleChainService.findTenantRuleChainsByType(tenantId, RuleChainType.CORE, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleChainDao)
        .findRuleChainsByTenantIdAndType(
            isA(UUID.class), eq(RuleChainType.CORE), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantRuleChainsByTypeResult);
  }

  /**
   * Test {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)"
  })
  public void testFindTenantRuleChainsByType_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleChain> actualFindTenantRuleChainsByTypeResult =
        baseRuleChainService.findTenantRuleChainsByType(
            ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleChainDao)
        .findRuleChainsByTenantIdAndType(
            isA(UUID.class), eq(RuleChainType.CORE), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantRuleChainsByTypeResult);
  }

  /**
   * Test {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)"
  })
  public void testFindTenantRuleChainsByType_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleChain> actualFindTenantRuleChainsByTypeResult =
        baseRuleChainService.findTenantRuleChainsByType(
            ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleChainDao)
        .findRuleChainsByTenantIdAndType(
            isA(UUID.class), eq(RuleChainType.CORE), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantRuleChainsByTypeResult);
  }

  /**
   * Test {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId, RuleChainType,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findTenantRuleChainsByType(TenantId,
   * RuleChainType, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findTenantRuleChainsByType(TenantId, RuleChainType, PageLink)"
  })
  public void testFindTenantRuleChainsByType_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleChain> actualFindTenantRuleChainsByTypeResult =
        baseRuleChainService.findTenantRuleChainsByType(
            ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainDao)
        .findRuleChainsByTenantIdAndType(
            isA(UUID.class), eq(RuleChainType.CORE), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindTenantRuleChainsByTypeResult);
  }

  /**
   * Test {@link BaseRuleChainService#findTenantRuleChainsByTypeAndName(TenantId, RuleChainType,
   * String)}.
   *
   * <ul>
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findTenantRuleChainsByTypeAndName(TenantId,
   * RuleChainType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection BaseRuleChainService.findTenantRuleChainsByTypeAndName(TenantId, RuleChainType, String)"
  })
  public void testFindTenantRuleChainsByTypeAndName_thenReturnList() {
    // Arrange
    ArrayList<RuleChain> ruleChainList = new ArrayList<>();
    when(ruleChainDao.findByTenantIdAndTypeAndName(
            Mockito.<TenantId>any(), Mockito.<RuleChainType>any(), Mockito.<String>any()))
        .thenReturn(ruleChainList);

    // Act
    Collection<RuleChain> actualFindTenantRuleChainsByTypeAndNameResult =
        baseRuleChainService.findTenantRuleChainsByTypeAndName(
            ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, "Name");

    // Assert
    verify(ruleChainDao)
        .findByTenantIdAndTypeAndName(isA(TenantId.class), eq(RuleChainType.CORE), eq("Name"));
    assertTrue(actualFindTenantRuleChainsByTypeAndNameResult instanceof List);
    assertTrue(actualFindTenantRuleChainsByTypeAndNameResult.isEmpty());
    assertSame(ruleChainList, actualFindTenantRuleChainsByTypeAndNameResult);
  }

  /**
   * Test {@link BaseRuleChainService#findTenantRuleChainsByTypeAndName(TenantId, RuleChainType,
   * String)}.
   *
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findTenantRuleChainsByTypeAndName(TenantId,
   * RuleChainType, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Collection BaseRuleChainService.findTenantRuleChainsByTypeAndName(TenantId, RuleChainType, String)"
  })
  public void testFindTenantRuleChainsByTypeAndName_thenThrowEntityVersionMismatchException() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findByTenantIdAndTypeAndName(
            Mockito.<TenantId>any(), Mockito.<RuleChainType>any(), Mockito.<String>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findTenantRuleChainsByTypeAndName(
                ModelConstants.SYSTEM_TENANT, RuleChainType.CORE, "Name"));
    verify(ruleChainDao)
        .findByTenantIdAndTypeAndName(isA(TenantId.class), eq(RuleChainType.CORE), eq("Name"));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleChainById(TenantId, RuleChainId)"})
  public void testDeleteRuleChainById() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.deleteRuleChainById(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleChainById(TenantId, RuleChainId)"})
  public void testDeleteRuleChainById2() {
    // Arrange
    when(relationService.findByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    doThrow(entityVersionMismatchException)
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.deleteRuleChainById(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(relationService)
        .findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleChainById(TenantId, RuleChainId)"})
  public void testDeleteRuleChainById3() {
    // Arrange
    when(relationService.findByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    doThrow(entityVersionMismatchException)
        .when(ruleChainDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.deleteRuleChainById(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(relationService)
        .findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleChainById(TenantId, RuleChainId)"})
  public void testDeleteRuleChainById4() {
    // Arrange
    when(relationService.findByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = mock(RuleChain.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.isRoot()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.deleteRuleChainById(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChain).isRoot();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleChainById(TenantId, RuleChainId)"})
  public void testDeleteRuleChainById5() {
    // Arrange
    RuleChainId ruleChainId = mock(RuleChainId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.deleteRuleChainById(ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link RuleChainId} {@link RuleChainId#getId()} return {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleChainById(TenantId, RuleChainId)"})
  public void testDeleteRuleChainById_givenNull_uuid_whenRuleChainIdGetIdReturnNull_uuid() {
    // Arrange
    when(relationService.findByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRuleChainService.deleteRuleChainById(ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChain).isRoot();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link RuleChainDao} {@link RuleChainDao#findById(TenantId, UUID)} return {@code
   *       null}.
   *   <li>Then calls {@link RuleChainDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleChainById(TenantId, RuleChainId)"})
  public void testDeleteRuleChainById_givenRuleChainDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    baseRuleChainService.deleteRuleChainById(
        ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()} Id is {@link RuleChainId#RuleChainId(UUID)} with id
   *       is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleChainById(TenantId, RuleChainId)"})
  public void testDeleteRuleChainById_givenRuleChainIdIsRuleChainIdWithIdIsNull_uuid() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(relationService.findByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    RuleChain ruleChain = new RuleChain();
    ruleChain.setId(new RuleChainId(ModelConstants.NULL_UUID));
    doNothing().when(ruleChainDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    baseRuleChainService.deleteRuleChainById(
        ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
    verify(relationService)
        .findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then calls {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleChainById(TenantId, RuleChainId)"})
  public void testDeleteRuleChainById_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    when(relationService.findByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    doNothing().when(ruleChainDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new RuleChain());

    // Act
    baseRuleChainService.deleteRuleChainById(
        ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isNull(), eq(RelationTypeGroup.RULE_CHAIN));
    verify(relationService)
        .findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleChainById(TenantId, RuleChainId)"})
  public void testDeleteRuleChainById_thenThrowConstraintViolationException() {
    // Arrange
    when(relationService.findByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Incorrect rule chain id for delete request.");
    doThrow(constraintViolationException)
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseRuleChainService.deleteRuleChainById(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(relationService)
        .findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleChainById(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleChainById(TenantId, RuleChainId)"})
  public void testDeleteRuleChainById_thenThrowDataValidationException() {
    // Arrange
    when(relationService.findByTo(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.isRoot()).thenReturn(true);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleChainService.deleteRuleChainById(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChain).isRoot();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByTo(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_NODE));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleChainsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleChainsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleChainsByTenantId(TenantId)"})
  public void testDeleteRuleChainsByTenantId_thenCallsFindRuleChainsByTenantId() {
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
   *
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleChainsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleChainsByTenantId(TenantId)"})
  public void testDeleteRuleChainsByTenantId_thenThrowEntityVersionMismatchException() {
    // Arrange
    BaseRuleChainService baseRuleChainService = new BaseRuleChainService();

    TenantId tenantId = mock(TenantId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(tenantId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.deleteRuleChainsByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteByTenantId(TenantId)"})
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
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId2() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseRuleChainService.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId3() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(tenantId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.deleteByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId4() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    doThrow(entityVersionMismatchException)
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    ArrayList<RuleChain> data = new ArrayList<>();
    data.add(new RuleChain());
    PageData<RuleChain> pageData = new PageData<>(data, 100, 100L, true);
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.deleteByTenantId(tenantId));
    verify(tenantId, atLeast(1)).getId();
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId5() {
    // Arrange
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    ArrayList<RuleChain> data = new ArrayList<>();
    data.add(new RuleChain());
    PageData<RuleChain> pageData = new PageData<>(data, 100, 100L, true);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    doThrow(entityVersionMismatchException)
        .when(ruleChainDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.deleteByTenantId(tenantId));
    verify(tenantId, atLeast(1)).getId();
    verify(ruleChainDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link CleanUpService#handleEntityDeletionEvent(DeleteEntityEvent)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsHandleEntityDeletionEvent() {
    // Arrange
    doNothing().when(cleanUpService).handleEntityDeletionEvent(Mockito.<DeleteEntityEvent<?>>any());
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());
    doNothing()
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    ArrayList<RuleChain> data = new ArrayList<>();
    data.add(new RuleChain());
    PageData<RuleChain> pageData = new PageData<>(data, 100, 100L, false);
    doNothing().when(ruleChainDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    baseRuleChainService.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(ruleChainDao).removeById(isA(TenantId.class), isNull());
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(cleanUpService).handleEntityDeletionEvent(isA(DeleteEntityEvent.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isNull(), eq(RelationTypeGroup.RULE_CHAIN));
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Incorrect tenant id for delete rule chains request.");
    doThrow(constraintViolationException)
        .when(entityCountService)
        .publishCountEntityEvictEvent(Mockito.<TenantId>any(), Mockito.<EntityType>any());

    ArrayList<RuleChain> data = new ArrayList<>();
    data.add(new RuleChain());
    PageData<RuleChain> pageData = new PageData<>(data, 100, 100L, true);
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> baseRuleChainService.deleteByTenantId(tenantId));
    verify(tenantId, atLeast(1)).getId();
    verify(entityCountService)
        .publishCountEntityEvictEvent(isA(TenantId.class), eq(EntityType.RULE_CHAIN));
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainData BaseRuleChainService.exportTenantRuleChains(TenantId, PageLink)"
  })
  public void testExportTenantRuleChains() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(pageLink.getPageSize()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.exportTenantRuleChains(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainData BaseRuleChainService.exportTenantRuleChains(TenantId, PageLink)"
  })
  public void testExportTenantRuleChains2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(pageLink.getPage()).thenThrow(entityVersionMismatchException);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.exportTenantRuleChains(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainData BaseRuleChainService.exportTenantRuleChains(TenantId, PageLink)"
  })
  public void testExportTenantRuleChains3() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(sortOrder.getProperty()).thenThrow(entityVersionMismatchException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.exportTenantRuleChains(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainData BaseRuleChainService.exportTenantRuleChains(TenantId, PageLink)"
  })
  public void testExportTenantRuleChains4() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(tenantId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.exportTenantRuleChains(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainData BaseRuleChainService.exportTenantRuleChains(TenantId, PageLink)"
  })
  public void testExportTenantRuleChains_givenBy_created_time_desc() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(entityVersionMismatchException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.exportTenantRuleChains(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainData BaseRuleChainService.exportTenantRuleChains(TenantId, PageLink)"
  })
  public void testExportTenantRuleChains_givenNull_uuid_thenCallsGetId() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(entityVersionMismatchException);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.exportTenantRuleChains(tenantId, pageLink));
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainData BaseRuleChainService.exportTenantRuleChains(TenantId, PageLink)"
  })
  public void testExportTenantRuleChains_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(entityVersionMismatchException);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.exportTenantRuleChains(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainData BaseRuleChainService.exportTenantRuleChains(TenantId, PageLink)"
  })
  public void testExportTenantRuleChains_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(entityVersionMismatchException);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.exportTenantRuleChains(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return Metadata Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainData BaseRuleChainService.exportTenantRuleChains(TenantId, PageLink)"
  })
  public void testExportTenantRuleChains_thenReturnMetadataEmpty() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    RuleChainData actualExportTenantRuleChainsResult =
        baseRuleChainService.exportTenantRuleChains(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertTrue(actualExportTenantRuleChainsResult.getMetadata().isEmpty());
    assertTrue(actualExportTenantRuleChainsResult.getRuleChains().isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then calls {@link RuleChainDao#findRuleChainsByTenantId(UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#exportTenantRuleChains(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChainData BaseRuleChainService.exportTenantRuleChains(TenantId, PageLink)"
  })
  public void testExportTenantRuleChains_whenFirst_page_thenCallsFindRuleChainsByTenantId() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findRuleChainsByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.exportTenantRuleChains(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(ruleChainDao).findRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean,
   * Function)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#importTenantRuleChains(TenantId,
   * RuleChainData, boolean, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.importTenantRuleChains(TenantId, RuleChainData, boolean, Function)"
  })
  public void testImportTenantRuleChains() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.importTenantRuleChains(
                ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean,
   * Function)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#importTenantRuleChains(TenantId,
   * RuleChainData, boolean, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.importTenantRuleChains(TenantId, RuleChainData, boolean, Function)"
  })
  public void testImportTenantRuleChains2() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new RuleChain());

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainMetaData.getVersion()).thenThrow(entityVersionMismatchException);
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.importTenantRuleChains(
                ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean,
   * Function)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#importTenantRuleChains(TenantId,
   * RuleChainData, boolean, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.importTenantRuleChains(TenantId, RuleChainData, boolean, Function)"
  })
  public void testImportTenantRuleChains3() {
    // Arrange
    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainMetaData.getRuleChainConnections()).thenThrow(entityVersionMismatchException);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(mock(RuleChainId.class));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    ArrayList<RuleChain> ruleChains = new ArrayList<>();
    ruleChains.add(new RuleChain());

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(ruleChains);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.importTenantRuleChains(
                ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChainMetaData).getRuleChainConnections();
    verify(ruleChainMetaData).getRuleChainId();
  }

  /**
   * Test {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean,
   * Function)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#importTenantRuleChains(TenantId,
   * RuleChainData, boolean, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.importTenantRuleChains(TenantId, RuleChainData, boolean, Function)"
  })
  public void testImportTenantRuleChains4() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getId()).thenThrow(entityVersionMismatchException);

    ArrayList<RuleChain> ruleChainList = new ArrayList<>();
    ruleChainList.add(ruleChain);
    when(ruleChainDao.findByTenantIdAndTypeAndName(
            Mockito.<TenantId>any(), Mockito.<RuleChainType>any(), Mockito.<String>any()))
        .thenReturn(ruleChainList);

    RuleChainConnectionInfo ruleChainConnectionInfo = new RuleChainConnectionInfo();
    ruleChainConnectionInfo.setAdditionalInfo(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    ruleChainConnectionInfo.setFromIndex(1);
    ruleChainConnectionInfo.setTargetRuleChainId(new RuleChainId(ModelConstants.NULL_UUID));
    ruleChainConnectionInfo.setType("Type");

    ArrayList<RuleChainConnectionInfo> ruleChainConnectionInfoList = new ArrayList<>();
    ruleChainConnectionInfoList.add(ruleChainConnectionInfo);

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(ruleChainConnectionInfoList);
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(mock(RuleChainId.class));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    ArrayList<RuleChain> ruleChains = new ArrayList<>();
    ruleChains.add(new RuleChain());

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(ruleChains);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.importTenantRuleChains(
                ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChain).getId();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData).getRuleChainId();
    verify(ruleChainDao)
        .findByTenantIdAndTypeAndName(isA(TenantId.class), eq(RuleChainType.CORE), isNull());
  }

  /**
   * Test {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean,
   * Function)}.
   *
   * <ul>
   *   <li>Given {@link BaseRuleChainService} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#importTenantRuleChains(TenantId,
   * RuleChainData, boolean, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.importTenantRuleChains(TenantId, RuleChainData, boolean, Function)"
  })
  public void testImportTenantRuleChains_givenBaseRuleChainService() {
    // Arrange
    BaseRuleChainService baseRuleChainService = new BaseRuleChainService();

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainMetaData.getRuleChainConnections()).thenThrow(entityVersionMismatchException);
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    ArrayList<RuleChain> ruleChains = new ArrayList<>();
    ruleChains.add(new RuleChain());

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(ruleChains);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.importTenantRuleChains(
                ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChainMetaData).getRuleChainConnections();
    verify(ruleChainMetaData).getRuleChainId();
  }

  /**
   * Test {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean,
   * Function)}.
   *
   * <ul>
   *   <li>Given {@link RuleChainDao}.
   *   <li>When {@code true}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#importTenantRuleChains(TenantId,
   * RuleChainData, boolean, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.importTenantRuleChains(TenantId, RuleChainData, boolean, Function)"
  })
  public void testImportTenantRuleChains_givenRuleChainDao_whenTrue_thenReturnEmpty() {
    // Arrange
    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(new ArrayList<>());
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertTrue(
        baseRuleChainService
            .importTenantRuleChains(
                ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class))
            .isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean,
   * Function)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleChainMetaData#getConnections()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#importTenantRuleChains(TenantId,
   * RuleChainData, boolean, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.importTenantRuleChains(TenantId, RuleChainData, boolean, Function)"
  })
  public void testImportTenantRuleChains_thenCallsGetConnections() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setVersion(1L);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainMetaData.getConnections()).thenThrow(entityVersionMismatchException);
    when(ruleChainMetaData.getVersion()).thenReturn(1L);
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(new ArrayList<>());

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.importTenantRuleChains(
                ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChainMetaData).getConnections();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean,
   * Function)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleChain#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#importTenantRuleChains(TenantId,
   * RuleChainData, boolean, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.importTenantRuleChains(TenantId, RuleChainData, boolean, Function)"
  })
  public void testImportTenantRuleChains_thenCallsGetId() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getId()).thenThrow(entityVersionMismatchException);

    ArrayList<RuleChain> ruleChainList = new ArrayList<>();
    ruleChainList.add(ruleChain);
    when(ruleChainDao.findByTenantIdAndTypeAndName(
            Mockito.<TenantId>any(), Mockito.<RuleChainType>any(), Mockito.<String>any()))
        .thenReturn(ruleChainList);

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(mock(RuleChainId.class));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    ArrayList<RuleChain> ruleChains = new ArrayList<>();
    ruleChains.add(new RuleChain());

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(ruleChains);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.importTenantRuleChains(
                ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChain).getId();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData).getRuleChainConnections();
    verify(ruleChainMetaData).getRuleChainId();
    verify(ruleChainDao)
        .findByTenantIdAndTypeAndName(isA(TenantId.class), eq(RuleChainType.CORE), isNull());
  }

  /**
   * Test {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean,
   * Function)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleChain#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#importTenantRuleChains(TenantId,
   * RuleChainData, boolean, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.importTenantRuleChains(TenantId, RuleChainData, boolean, Function)"
  })
  public void testImportTenantRuleChains_thenCallsGetId2() {
    // Arrange
    RuleChain ruleChain = mock(RuleChain.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain.getId()).thenThrow(entityVersionMismatchException);

    ArrayList<RuleChain> ruleChainList = new ArrayList<>();
    ruleChainList.add(ruleChain);
    when(ruleChainDao.findByTenantIdAndTypeAndName(
            Mockito.<TenantId>any(), Mockito.<RuleChainType>any(), Mockito.<String>any()))
        .thenReturn(ruleChainList);

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    when(ruleChainMetaData.getRuleChainConnections()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getNodes()).thenReturn(new ArrayList<>());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(mock(RuleChainId.class));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    ArrayList<RuleChain> ruleChains = new ArrayList<>();
    ruleChains.add(new RuleChain());
    ruleChains.add(new RuleChain());

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(ruleChains);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.importTenantRuleChains(
                ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChain).getId();
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainConnections();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainDao)
        .findByTenantIdAndTypeAndName(isA(TenantId.class), eq(RuleChainType.CORE), isNull());
  }

  /**
   * Test {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean,
   * Function)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleChainMetaData#getVersion()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#importTenantRuleChains(TenantId,
   * RuleChainData, boolean, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.importTenantRuleChains(TenantId, RuleChainData, boolean, Function)"
  })
  public void testImportTenantRuleChains_thenCallsGetVersion() {
    // Arrange
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new RuleChain());

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
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.importTenantRuleChains(
                ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChainMetaData, atLeast(1)).getNodes();
    verify(ruleChainMetaData, atLeast(1)).getRuleChainId();
    verify(ruleChainMetaData, atLeast(1)).getVersion();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#importTenantRuleChains(TenantId, RuleChainData, boolean,
   * Function)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleChainMetaData#setRuleChainId(RuleChainId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#importTenantRuleChains(TenantId,
   * RuleChainData, boolean, Function)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.importTenantRuleChains(TenantId, RuleChainData, boolean, Function)"
  })
  public void testImportTenantRuleChains_thenCallsSetRuleChainId() {
    // Arrange
    BaseRuleChainService baseRuleChainService = new BaseRuleChainService();

    RuleChainMetaData ruleChainMetaData = mock(RuleChainMetaData.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    doThrow(entityVersionMismatchException)
        .when(ruleChainMetaData)
        .setRuleChainId(Mockito.<RuleChainId>any());
    when(ruleChainMetaData.getRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));

    ArrayList<RuleChainMetaData> metadata = new ArrayList<>();
    metadata.add(ruleChainMetaData);

    ArrayList<RuleChain> ruleChains = new ArrayList<>();
    ruleChains.add(new RuleChain(new RuleChainId(ModelConstants.NULL_UUID)));

    RuleChainData ruleChainData = new RuleChainData();
    ruleChainData.setMetadata(metadata);
    ruleChainData.setRuleChains(ruleChains);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.importTenantRuleChains(
                ModelConstants.SYSTEM_TENANT, ruleChainData, true, mock(Function.class)));
    verify(ruleChainMetaData).getRuleChainId();
    verify(ruleChainMetaData).setRuleChainId(isA(RuleChainId.class));
  }

  /**
   * Test {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link RuleChainId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChain BaseRuleChainService.assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)"
  })
  public void testAssignRuleChainToEdge_givenNull_uuid_thenCallsGetId() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.assignRuleChainToEdge(
                ModelConstants.SYSTEM_TENANT, ruleChainId, null));
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChain BaseRuleChainService.assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)"
  })
  public void testAssignRuleChainToEdge_thenThrowDataValidationException() {
    // Arrange
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any())).thenReturn(null);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new RuleChain());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleChainService.assignRuleChainToEdge(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID), null));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#assignRuleChainToEdge(TenantId, RuleChainId,
   * EdgeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChain BaseRuleChainService.assignRuleChainToEdge(TenantId, RuleChainId, EdgeId)"
  })
  public void testAssignRuleChainToEdge_thenThrowEntityVersionMismatchException() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.assignRuleChainToEdge(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID), null));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId,
   * boolean)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link RuleChainId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId,
   * RuleChainId, EdgeId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChain BaseRuleChainService.unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId, boolean)"
  })
  public void testUnassignRuleChainFromEdge_givenNull_uuid_thenCallsGetId() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.unassignRuleChainFromEdge(
                ModelConstants.SYSTEM_TENANT, ruleChainId, null, true));
    verify(ruleChainId, atLeast(1)).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId,
   * boolean)}.
   *
   * <ul>
   *   <li>Then return {@link RuleChain#RuleChain()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId,
   * RuleChainId, EdgeId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChain BaseRuleChainService.unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId, boolean)"
  })
  public void testUnassignRuleChainFromEdge_thenReturnRuleChain() {
    // Arrange
    when(edgeService.findEdgeById(Mockito.<TenantId>any(), Mockito.<EdgeId>any()))
        .thenReturn(new Edge());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(true);
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    RuleChain actualUnassignRuleChainFromEdgeResult =
        baseRuleChainService.unassignRuleChainFromEdge(
            ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID), null, true);

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeService).findEdgeById(isA(TenantId.class), isNull());
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertSame(ruleChain, actualUnassignRuleChainFromEdgeResult);
  }

  /**
   * Test {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId,
   * boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#unassignRuleChainFromEdge(TenantId,
   * RuleChainId, EdgeId, boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleChain BaseRuleChainService.unassignRuleChainFromEdge(TenantId, RuleChainId, EdgeId, boolean)"
  })
  public void testUnassignRuleChainFromEdge_thenThrowEntityVersionMismatchException() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.unassignRuleChainFromEdge(
                ModelConstants.SYSTEM_TENANT,
                new RuleChainId(ModelConstants.NULL_UUID),
                null,
                true));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findRuleChainsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findRuleChainsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(ModelConstants.NULL_UUID),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(ruleChainDao)
        .findRuleChainsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId2() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(edgeId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findRuleChainsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId3() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(pageLink.getPageSize()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findRuleChainsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId4() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(sortOrder.getProperty()).thenThrow(entityVersionMismatchException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findRuleChainsByTenantIdAndEdgeId(
                ModelConstants.SYSTEM_TENANT, edgeId, pageLink));
    verify(edgeId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId_givenBy_created_time_desc() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult =
        baseRuleChainService.findRuleChainsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleChainDao)
        .findRuleChainsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRuleChainsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult =
        baseRuleChainService.findRuleChainsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleChainDao)
        .findRuleChainsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRuleChainsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult =
        baseRuleChainService.findRuleChainsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleChainDao)
        .findRuleChainsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRuleChainsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId_thenCallsGetId() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult =
        baseRuleChainService.findRuleChainsByTenantIdAndEdgeId(tenantId, edgeId, pageLink);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleChainDao)
        .findRuleChainsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRuleChainsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link EdgeId#EdgeId(UUID)} with id is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId_whenEdgeIdWithIdIsNull_uuid() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult =
        baseRuleChainService.findRuleChainsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainDao)
        .findRuleChainsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRuleChainsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleChainsByTenantIdAndEdgeId(TenantId,
   * EdgeId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findRuleChainsByTenantIdAndEdgeId(TenantId, EdgeId, PageLink)"
  })
  public void testFindRuleChainsByTenantIdAndEdgeId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findRuleChainsByTenantIdAndEdgeId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<RuleChain> actualFindRuleChainsByTenantIdAndEdgeIdResult =
        baseRuleChainService.findRuleChainsByTenantIdAndEdgeId(
            ModelConstants.SYSTEM_TENANT, edgeId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(ruleChainDao)
        .findRuleChainsByTenantIdAndEdgeId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindRuleChainsByTenantIdAndEdgeIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#getEdgeTemplateRootRuleChain(TenantId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#getEdgeTemplateRootRuleChain(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.getEdgeTemplateRootRuleChain(TenantId)"})
  public void testGetEdgeTemplateRootRuleChain() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.getEdgeTemplateRootRuleChain(ModelConstants.SYSTEM_TENANT));
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
  }

  /**
   * Test {@link BaseRuleChainService#getEdgeTemplateRootRuleChain(TenantId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#getEdgeTemplateRootRuleChain(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.getEdgeTemplateRootRuleChain(TenantId)"})
  public void testGetEdgeTemplateRootRuleChain2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(tenantId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.getEdgeTemplateRootRuleChain(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#getEdgeTemplateRootRuleChain(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>When {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getEdgeTemplateRootRuleChain(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.getEdgeTemplateRootRuleChain(TenantId)"})
  public void testGetEdgeTemplateRootRuleChain_givenNull_uuid_whenTenantIdGetIdReturnNull_uuid() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    RuleChain actualEdgeTemplateRootRuleChain =
        baseRuleChainService.getEdgeTemplateRootRuleChain(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
    assertSame(ruleChain, actualEdgeTemplateRootRuleChain);
  }

  /**
   * Test {@link BaseRuleChainService#getEdgeTemplateRootRuleChain(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link RuleChain#RuleChain()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#getEdgeTemplateRootRuleChain(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleChain BaseRuleChainService.getEdgeTemplateRootRuleChain(TenantId)"})
  public void testGetEdgeTemplateRootRuleChain_whenSystem_tenant_thenReturnRuleChain() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain);

    // Act
    RuleChain actualEdgeTemplateRootRuleChain =
        baseRuleChainService.getEdgeTemplateRootRuleChain(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
    assertSame(ruleChain, actualEdgeTemplateRootRuleChain);
  }

  /**
   * Test {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRuleChainService.setEdgeTemplateRootRuleChain(TenantId, RuleChainId)"
  })
  public void testSetEdgeTemplateRootRuleChain() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.setEdgeTemplateRootRuleChain(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRuleChainService.setEdgeTemplateRootRuleChain(TenantId, RuleChainId)"
  })
  public void testSetEdgeTemplateRootRuleChain2() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.setEdgeTemplateRootRuleChain(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
  }

  /**
   * Test {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRuleChainService.setEdgeTemplateRootRuleChain(TenantId, RuleChainId)"
  })
  public void testSetEdgeTemplateRootRuleChain3() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenReturn(new RuleChain());
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(null);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    boolean actualSetEdgeTemplateRootRuleChainResult =
        baseRuleChainService.setEdgeTemplateRootRuleChain(
            ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao).save(isA(TenantId.class), isA(RuleChain.class));
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
    assertTrue(actualSetEdgeTemplateRootRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRuleChainService.setEdgeTemplateRootRuleChain(TenantId, RuleChainId)"
  })
  public void testSetEdgeTemplateRootRuleChain4() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(tenantId.getId()).thenThrow(entityVersionMismatchException);

    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(tenantId);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.setEdgeTemplateRootRuleChain(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(tenantId).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link RuleChain#RuleChain()} Id is {@link RuleChainId#RuleChainId(UUID)} with id
   *       is {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRuleChainService.setEdgeTemplateRootRuleChain(TenantId, RuleChainId)"
  })
  public void testSetEdgeTemplateRootRuleChain_givenRuleChainIdIsRuleChainIdWithIdIsNull_uuid() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);

    RuleChain ruleChain2 = new RuleChain();
    ruleChain2.setId(new RuleChainId(ModelConstants.NULL_UUID));
    when(ruleChainDao.save(Mockito.<TenantId>any(), Mockito.<RuleChain>any()))
        .thenReturn(new RuleChain());
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain2);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    boolean actualSetEdgeTemplateRootRuleChainResult =
        baseRuleChainService.setEdgeTemplateRootRuleChain(
            ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao, atLeast(1)).save(isA(TenantId.class), Mockito.<RuleChain>any());
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
    assertTrue(actualSetEdgeTemplateRootRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Given {@link TenantId} {@link TenantId#getId()} return {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRuleChainService.setEdgeTemplateRootRuleChain(TenantId, RuleChainId)"
  })
  public void testSetEdgeTemplateRootRuleChain_givenTenantIdGetIdReturnNull_uuid() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(tenantId);

    RuleChain ruleChain2 = mock(RuleChain.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain2.getId()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain2);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.setEdgeTemplateRootRuleChain(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(tenantId, atLeast(1)).getId();
    verify(ruleChain2).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
  }

  /**
   * Test {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleChain#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRuleChainService.setEdgeTemplateRootRuleChain(TenantId, RuleChainId)"
  })
  public void testSetEdgeTemplateRootRuleChain_thenCallsGetId() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(ModelConstants.SYSTEM_TENANT);

    RuleChain ruleChain2 = mock(RuleChain.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChain2.getId()).thenThrow(entityVersionMismatchException);
    when(ruleChainDao.findRootRuleChainByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<RuleChainType>any()))
        .thenReturn(ruleChain2);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.setEdgeTemplateRootRuleChain(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(ruleChain2).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(ruleChainDao)
        .findRootRuleChainByTenantIdAndType(isA(UUID.class), eq(RuleChainType.EDGE));
  }

  /**
   * Test {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#setEdgeTemplateRootRuleChain(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRuleChainService.setEdgeTemplateRootRuleChain(TenantId, RuleChainId)"
  })
  public void testSetEdgeTemplateRootRuleChain_thenThrowDataValidationException() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    RuleChain ruleChain = new RuleChain();
    ruleChain.setTenantId(tenantId);
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    RuleChainId ruleChainId = mock(RuleChainId.class);
    when(ruleChainId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleChainService.setEdgeTemplateRootRuleChain(
                ModelConstants.SYSTEM_TENANT, ruleChainId));
    verify(ruleChainId).getId();
    verify(tenantId).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#setAutoAssignToEdgeRuleChain(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#setAutoAssignToEdgeRuleChain(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRuleChainService.setAutoAssignToEdgeRuleChain(TenantId, RuleChainId)"
  })
  public void testSetAutoAssignToEdgeRuleChain_thenReturnTrue() {
    // Arrange
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(new EntityRelation());

    // Act
    boolean actualSetAutoAssignToEdgeRuleChainResult =
        baseRuleChainService.setAutoAssignToEdgeRuleChain(
            ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertTrue(actualSetAutoAssignToEdgeRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#setAutoAssignToEdgeRuleChain(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#setAutoAssignToEdgeRuleChain(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRuleChainService.setAutoAssignToEdgeRuleChain(TenantId, RuleChainId)"
  })
  public void testSetAutoAssignToEdgeRuleChain_thenThrowRuntimeException() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(relationService.saveRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRuleChainService.setAutoAssignToEdgeRuleChain(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(relationService).saveRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRuleChainService#unsetAutoAssignToEdgeRuleChain(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#unsetAutoAssignToEdgeRuleChain(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRuleChainService.unsetAutoAssignToEdgeRuleChain(TenantId, RuleChainId)"
  })
  public void testUnsetAutoAssignToEdgeRuleChain_thenReturnTrue() {
    // Arrange
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenReturn(true);

    // Act
    boolean actualUnsetAutoAssignToEdgeRuleChainResult =
        baseRuleChainService.unsetAutoAssignToEdgeRuleChain(
            ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
    assertTrue(actualUnsetAutoAssignToEdgeRuleChainResult);
  }

  /**
   * Test {@link BaseRuleChainService#unsetAutoAssignToEdgeRuleChain(TenantId, RuleChainId)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#unsetAutoAssignToEdgeRuleChain(TenantId,
   * RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean BaseRuleChainService.unsetAutoAssignToEdgeRuleChain(TenantId, RuleChainId)"
  })
  public void testUnsetAutoAssignToEdgeRuleChain_thenThrowRuntimeException() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(relationService.deleteRelation(Mockito.<TenantId>any(), Mockito.<EntityRelation>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () ->
            baseRuleChainService.unsetAutoAssignToEdgeRuleChain(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(relationService).deleteRelation(isA(TenantId.class), isA(EntityRelation.class));
  }

  /**
   * Test {@link BaseRuleChainService#findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)"
  })
  public void testFindAutoAssignToEdgeRuleChainsByTenantId() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findAutoAssignToEdgeRuleChainsByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(ruleChainDao)
        .findAutoAssignToEdgeRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)"
  })
  public void testFindAutoAssignToEdgeRuleChainsByTenantId2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(tenantId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findAutoAssignToEdgeRuleChainsByTenantId(
                tenantId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)"
  })
  public void testFindAutoAssignToEdgeRuleChainsByTenantId_givenNull_uuid() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    PageData<RuleChain> actualFindAutoAssignToEdgeRuleChainsByTenantIdResult =
        baseRuleChainService.findAutoAssignToEdgeRuleChainsByTenantId(
            tenantId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(ruleChainDao)
        .findAutoAssignToEdgeRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAutoAssignToEdgeRuleChainsByTenantId(TenantId, PageLink)"
  })
  public void testFindAutoAssignToEdgeRuleChainsByTenantId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainDao.findAutoAssignToEdgeRuleChainsByTenantId(
            Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleChain> actualFindAutoAssignToEdgeRuleChainsByTenantIdResult =
        baseRuleChainService.findAutoAssignToEdgeRuleChainsByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleChainDao)
        .findAutoAssignToEdgeRuleChainsByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAutoAssignToEdgeRuleChainsByTenantIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String)} with {@code
   * tenantId}, {@code type}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.findRuleNodesByTenantIdAndType(TenantId, String)"})
  public void testFindRuleNodesByTenantIdAndTypeWithTenantIdType() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeDao.findRuleNodesByTenantIdAndType(
            Mockito.<TenantId>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findRuleNodesByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type"));
    verify(ruleNodeDao).findRuleNodesByTenantIdAndType(isA(TenantId.class), eq("Type"), eq(""));
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String)} with {@code
   * tenantId}, {@code type}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.findRuleNodesByTenantIdAndType(TenantId, String)"})
  public void testFindRuleNodesByTenantIdAndTypeWithTenantIdType2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(tenantId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findRuleNodesByTenantIdAndType(tenantId, "Type"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String, String)} with
   * {@code tenantId}, {@code type}, {@code search}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.findRuleNodesByTenantIdAndType(TenantId, String, String)"
  })
  public void testFindRuleNodesByTenantIdAndTypeWithTenantIdTypeSearch() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeDao.findRuleNodesByTenantIdAndType(
            Mockito.<TenantId>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findRuleNodesByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", "Search"));
    verify(ruleNodeDao)
        .findRuleNodesByTenantIdAndType(isA(TenantId.class), eq("Type"), eq("Search"));
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String, String)} with
   * {@code tenantId}, {@code type}, {@code search}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.findRuleNodesByTenantIdAndType(TenantId, String, String)"
  })
  public void testFindRuleNodesByTenantIdAndTypeWithTenantIdTypeSearch2() {
    // Arrange
    TenantId tenantId = mock(TenantId.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(tenantId.getId()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findRuleNodesByTenantIdAndType(tenantId, "Type", "Search"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String, String)} with
   * {@code tenantId}, {@code type}, {@code search}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.findRuleNodesByTenantIdAndType(TenantId, String, String)"
  })
  public void testFindRuleNodesByTenantIdAndTypeWithTenantIdTypeSearch_givenNull_uuid() {
    // Arrange
    when(ruleNodeDao.findRuleNodesByTenantIdAndType(
            Mockito.<TenantId>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualFindRuleNodesByTenantIdAndTypeResult =
        baseRuleChainService.findRuleNodesByTenantIdAndType(tenantId, "Type", "Search");

    // Assert
    verify(tenantId).getId();
    verify(ruleNodeDao)
        .findRuleNodesByTenantIdAndType(isA(TenantId.class), eq("Type"), eq("Search"));
    assertTrue(actualFindRuleNodesByTenantIdAndTypeResult.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String, String)} with
   * {@code tenantId}, {@code type}, {@code search}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId,
   * String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List BaseRuleChainService.findRuleNodesByTenantIdAndType(TenantId, String, String)"
  })
  public void testFindRuleNodesByTenantIdAndTypeWithTenantIdTypeSearch_thenReturnEmpty() {
    // Arrange
    when(ruleNodeDao.findRuleNodesByTenantIdAndType(
            Mockito.<TenantId>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<RuleNode> actualFindRuleNodesByTenantIdAndTypeResult =
        baseRuleChainService.findRuleNodesByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", "Search");

    // Assert
    verify(ruleNodeDao)
        .findRuleNodesByTenantIdAndType(isA(TenantId.class), eq("Type"), eq("Search"));
    assertTrue(actualFindRuleNodesByTenantIdAndTypeResult.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String)} with {@code
   * tenantId}, {@code type}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.findRuleNodesByTenantIdAndType(TenantId, String)"})
  public void testFindRuleNodesByTenantIdAndTypeWithTenantIdType_givenNull_uuid() {
    // Arrange
    when(ruleNodeDao.findRuleNodesByTenantIdAndType(
            Mockito.<TenantId>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    List<RuleNode> actualFindRuleNodesByTenantIdAndTypeResult =
        baseRuleChainService.findRuleNodesByTenantIdAndType(tenantId, "Type");

    // Assert
    verify(tenantId).getId();
    verify(ruleNodeDao).findRuleNodesByTenantIdAndType(isA(TenantId.class), eq("Type"), eq(""));
    assertTrue(actualFindRuleNodesByTenantIdAndTypeResult.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId, String)} with {@code
   * tenantId}, {@code type}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findRuleNodesByTenantIdAndType(TenantId,
   * String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.findRuleNodesByTenantIdAndType(TenantId, String)"})
  public void testFindRuleNodesByTenantIdAndTypeWithTenantIdType_thenReturnEmpty() {
    // Arrange
    when(ruleNodeDao.findRuleNodesByTenantIdAndType(
            Mockito.<TenantId>any(), Mockito.<String>any(), Mockito.<String>any()))
        .thenReturn(new ArrayList<>());

    // Act
    List<RuleNode> actualFindRuleNodesByTenantIdAndTypeResult =
        baseRuleChainService.findRuleNodesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type");

    // Assert
    verify(ruleNodeDao).findRuleNodesByTenantIdAndType(isA(TenantId.class), eq("Type"), eq(""));
    assertTrue(actualFindRuleNodesByTenantIdAndTypeResult.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseRuleChainService.findAllRuleNodesByType(String, PageLink)"})
  public void testFindAllRuleNodesByType() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeDao.findAllRuleNodesByType(Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findAllRuleNodesByType(
                "Type", BaseRelatedEdgesService.FIRST_PAGE));
    verify(ruleNodeDao).findAllRuleNodesByType(eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseRuleChainService.findAllRuleNodesByType(String, PageLink)"})
  public void testFindAllRuleNodesByType2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(pageLink.getPageSize()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findAllRuleNodesByType("Type", pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseRuleChainService.findAllRuleNodesByType(String, PageLink)"})
  public void testFindAllRuleNodesByType3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(pageLink.getPage()).thenThrow(entityVersionMismatchException);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findAllRuleNodesByType("Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseRuleChainService.findAllRuleNodesByType(String, PageLink)"})
  public void testFindAllRuleNodesByType4() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(sortOrder.getProperty()).thenThrow(entityVersionMismatchException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findAllRuleNodesByType("Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseRuleChainService.findAllRuleNodesByType(String, PageLink)"})
  public void testFindAllRuleNodesByType_givenBy_created_time_desc() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByType(Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult =
        baseRuleChainService.findAllRuleNodesByType("Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleNodeDao).findAllRuleNodesByType(eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllRuleNodesByTypeResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return empty string.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseRuleChainService.findAllRuleNodesByType(String, PageLink)"})
  public void testFindAllRuleNodesByType_givenSortOrderGetPropertyReturnEmptyString() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByType(Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult =
        baseRuleChainService.findAllRuleNodesByType("Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleNodeDao).findAllRuleNodesByType(eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllRuleNodesByTypeResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseRuleChainService.findAllRuleNodesByType(String, PageLink)"})
  public void testFindAllRuleNodesByType_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByType(Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult =
        baseRuleChainService.findAllRuleNodesByType("Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleNodeDao).findAllRuleNodesByType(eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllRuleNodesByTypeResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findAllRuleNodesByType(String, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData BaseRuleChainService.findAllRuleNodesByType(String, PageLink)"})
  public void testFindAllRuleNodesByType_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByType(Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeResult =
        baseRuleChainService.findAllRuleNodesByType("Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeDao).findAllRuleNodesByType(eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllRuleNodesByTypeResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodesByTypeAndVersionLessThan() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeDao.findAllRuleNodesByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<PageLink>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan(
                "Type", 1, BaseRelatedEdgesService.FIRST_PAGE));
    verify(ruleNodeDao)
        .findAllRuleNodesByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodesByTypeAndVersionLessThan2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(pageLink.getPageSize()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodesByTypeAndVersionLessThan3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(pageLink.getPage()).thenThrow(entityVersionMismatchException);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodesByTypeAndVersionLessThan4() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult =
        baseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleNodeDao)
        .findAllRuleNodesByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllRuleNodesByTypeAndVersionLessThanResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodesByTypeAndVersionLessThan5() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(sortOrder.getProperty()).thenThrow(entityVersionMismatchException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodesByTypeAndVersionLessThan_givenBy_created_time_desc() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult =
        baseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleNodeDao)
        .findAllRuleNodesByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllRuleNodesByTypeAndVersionLessThanResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} {@link SortOrder#getProperty()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodesByTypeAndVersionLessThan_givenSortOrderGetPropertyReturnNull() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult =
        baseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleNodeDao)
        .findAllRuleNodesByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllRuleNodesByTypeAndVersionLessThanResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodesByTypeAndVersionLessThan_whenFirst_page() {
    // Arrange
    PageData<RuleNode> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodesByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleNode> actualFindAllRuleNodesByTypeAndVersionLessThanResult =
        baseRuleChainService.findAllRuleNodesByTypeAndVersionLessThan(
            "Type", 1, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeDao)
        .findAllRuleNodesByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllRuleNodesByTypeAndVersionLessThanResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<PageLink>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan(
                "Type", 1, BaseRelatedEdgesService.FIRST_PAGE));
    verify(ruleNodeDao)
        .findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(pageLink.getPageSize()).thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(pageLink.getPage()).thenThrow(entityVersionMismatchException);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan4() {
    // Arrange
    PageData<RuleNodeId> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult =
        baseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleNodeDao)
        .findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan5() {
    // Arrange
    PageData<RuleNodeId> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn(null);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult =
        baseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(ruleNodeDao)
        .findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan6() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(sortOrder.getProperty()).thenThrow(entityVersionMismatchException);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan_givenBy_created_time_desc() {
    // Arrange
    PageData<RuleNodeId> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult =
        baseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan("Type", 1, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(ruleNodeDao)
        .findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseRuleChainService#findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan(String, int, PageLink)"
  })
  public void testFindAllRuleNodeIdsByTypeAndVersionLessThan_whenFirst_page() {
    // Arrange
    PageData<RuleNodeId> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeDao.findAllRuleNodeIdsByTypeAndVersionLessThan(
            Mockito.<String>any(), anyInt(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleNodeId> actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult =
        baseRuleChainService.findAllRuleNodeIdsByTypeAndVersionLessThan(
            "Type", 1, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeDao)
        .findAllRuleNodeIdsByTypeAndVersionLessThan(eq("Type"), eq(1), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAllRuleNodeIdsByTypeAndVersionLessThanResult);
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByIds(List)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findAllRuleNodesByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.findAllRuleNodesByIds(List)"})
  public void testFindAllRuleNodesByIds_thenReturnEmpty() {
    // Arrange
    when(ruleNodeDao.findAllRuleNodeByIds(Mockito.<List<RuleNodeId>>any()))
        .thenReturn(new ArrayList<>());

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act
    List<RuleNode> actualFindAllRuleNodesByIdsResult =
        baseRuleChainService.findAllRuleNodesByIds(ruleNodeIds);

    // Assert
    verify(ruleNodeDao).findAllRuleNodeByIds(isA(List.class));
    assertTrue(actualFindAllRuleNodesByIdsResult.isEmpty());
  }

  /**
   * Test {@link BaseRuleChainService#findAllRuleNodesByIds(List)}.
   *
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findAllRuleNodesByIds(List)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"List BaseRuleChainService.findAllRuleNodesByIds(List)"})
  public void testFindAllRuleNodesByIds_thenThrowEntityVersionMismatchException() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeDao.findAllRuleNodeByIds(Mockito.<List<RuleNodeId>>any()))
        .thenThrow(entityVersionMismatchException);

    ArrayList<RuleNodeId> ruleNodeIds = new ArrayList<>();
    ruleNodeIds.add(new RuleNodeId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findAllRuleNodesByIds(ruleNodeIds));
    verify(ruleNodeDao).findAllRuleNodeByIds(isA(List.class));
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleNode(TenantId, RuleNode)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDao} {@link RuleNodeDao#save(TenantId, Object)} return {@link
   *       RuleNode#RuleNode()}.
   *   <li>Then return {@link RuleNode#RuleNode()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleNode(TenantId, RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNode BaseRuleChainService.saveRuleNode(TenantId, RuleNode)"})
  public void testSaveRuleNode_givenRuleNodeDaoSaveReturnRuleNode_thenReturnRuleNode() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeDao.save(Mockito.<TenantId>any(), Mockito.<RuleNode>any())).thenReturn(ruleNode);

    // Act
    RuleNode actualSaveRuleNodeResult =
        baseRuleChainService.saveRuleNode(ModelConstants.SYSTEM_TENANT, new RuleNode());

    // Assert
    verify(ruleNodeDao).save(isA(TenantId.class), isA(RuleNode.class));
    assertSame(ruleNode, actualSaveRuleNodeResult);
  }

  /**
   * Test {@link BaseRuleChainService#saveRuleNode(TenantId, RuleNode)}.
   *
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#saveRuleNode(TenantId, RuleNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNode BaseRuleChainService.saveRuleNode(TenantId, RuleNode)"})
  public void testSaveRuleNode_thenThrowEntityVersionMismatchException() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeDao.save(Mockito.<TenantId>any(), Mockito.<RuleNode>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.saveRuleNode(ModelConstants.SYSTEM_TENANT, new RuleNode()));
    verify(ruleNodeDao).save(isA(TenantId.class), isA(RuleNode.class));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleNodes(TenantId, RuleChainId)} with {@code tenantId},
   * {@code ruleChainId}.
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleNodes(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleNodes(TenantId, RuleChainId)"})
  public void testDeleteRuleNodesWithTenantIdRuleChainId() {
    // Arrange
    AlarmId resultTo = mock(AlarmId.class);
    when(resultTo.getId()).thenReturn(ModelConstants.NULL_UUID);

    EntityRelation entityRelation = new EntityRelation();
    entityRelation.setTo(resultTo);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    doThrow(entityVersionMismatchException)
        .when(ruleNodeDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.deleteRuleNodes(
                ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID)));
    verify(resultTo).getId();
    verify(ruleNodeDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleNodes(TenantId, RuleChainId)} with {@code tenantId},
   * {@code ruleChainId}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDao}.
   *   <li>Then calls {@link RelationService#findByFrom(TenantId, EntityId, RelationTypeGroup)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleNodes(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleNodes(TenantId, RuleChainId)"})
  public void testDeleteRuleNodesWithTenantIdRuleChainId_givenRuleNodeDao_thenCallsFindByFrom() {
    // Arrange
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(new ArrayList<>());

    // Act
    baseRuleChainService.deleteRuleNodes(
        ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#deleteRuleNodes(TenantId, RuleChainId)} with {@code tenantId},
   * {@code ruleChainId}.
   *
   * <ul>
   *   <li>Then calls {@link CleanUpService#cleanUpRelatedData(TenantId, EntityId)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#deleteRuleNodes(TenantId, RuleChainId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleChainService.deleteRuleNodes(TenantId, RuleChainId)"})
  public void testDeleteRuleNodesWithTenantIdRuleChainId_thenCallsCleanUpRelatedData() {
    // Arrange
    doNothing()
        .when(cleanUpService)
        .cleanUpRelatedData(Mockito.<TenantId>any(), Mockito.<EntityId>any());

    EntityRelation entityRelation = new EntityRelation();
    entityRelation.setTo(BaseEntityService.NULL_CUSTOMER_ID);

    ArrayList<EntityRelation> entityRelationList = new ArrayList<>();
    entityRelationList.add(entityRelation);
    when(relationService.findByFrom(
            Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<RelationTypeGroup>any()))
        .thenReturn(entityRelationList);
    doNothing().when(ruleNodeDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());

    // Act
    baseRuleChainService.deleteRuleNodes(
        ModelConstants.SYSTEM_TENANT, new RuleChainId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleNodeDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(cleanUpService).cleanUpRelatedData(isA(TenantId.class), isA(EntityId.class));
    verify(relationService)
        .findByFrom(isA(TenantId.class), isA(EntityId.class), eq(RelationTypeGroup.RULE_CHAIN));
  }

  /**
   * Test {@link BaseRuleChainService#findEntity(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link BaseRuleChainService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseRuleChainService.findEntity(TenantId, EntityId)"})
  public void testFindEntity() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_NODE);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findEntity(ModelConstants.SYSTEM_TENANT, entityId));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleChainDao} {@link RuleChainDao#findById(TenantId, UUID)} return {@link
   *       RuleChain#RuleChain()}.
   *   <li>Then return {@link Optional#get()} is {@link RuleChain#RuleChain()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseRuleChainService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenRuleChainDaoFindByIdReturnRuleChain_thenReturnGetIsRuleChain() {
    // Arrange
    RuleChain ruleChain = new RuleChain();
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleChain);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        baseRuleChainService.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(ruleChain, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseRuleChainService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeDao} {@link RuleNodeDao#findById(TenantId, UUID)} return {@link
   *       RuleNode#RuleNode()}.
   *   <li>Then return {@link Optional#get()} is {@link RuleNode#RuleNode()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseRuleChainService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenRuleNodeDaoFindByIdReturnRuleNode_thenReturnGetIsRuleNode() {
    // Arrange
    RuleNode ruleNode = new RuleNode();
    when(ruleNodeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(ruleNode);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.RULE_NODE);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        baseRuleChainService.findEntity(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(ruleNodeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(ruleNode, actualFindEntityResult.get());
  }

  /**
   * Test {@link BaseRuleChainService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given {@code TENANT}.
   *   <li>When {@link AlarmId} {@link AlarmId#getEntityType()} return {@code TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseRuleChainService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenTenant_whenAlarmIdGetEntityTypeReturnTenant() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.findEntity(ModelConstants.SYSTEM_TENANT, entityId));
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then throw {@link EntityVersionMismatchException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional BaseRuleChainService.findEntity(TenantId, EntityId)"})
  public void testFindEntity_whenNull_customer_id_thenThrowEntityVersionMismatchException() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () ->
            baseRuleChainService.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(ruleChainDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleChainService#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link RuleChainDao} {@link RuleChainDao#countByTenantId(TenantId)} return one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseRuleChainService.countByTenantId(TenantId)"})
  public void testCountByTenantId_givenRuleChainDaoCountByTenantIdReturnOne_thenReturnOne() {
    // Arrange
    when(ruleChainDao.countByTenantId(Mockito.<TenantId>any())).thenReturn(1L);

    // Act
    long actualCountByTenantIdResult =
        baseRuleChainService.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(ruleChainDao).countByTenantId(isA(TenantId.class));
    assertEquals(1L, actualCountByTenantIdResult);
  }

  /**
   * Test {@link BaseRuleChainService#countByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link EntityVersionMismatchException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleChainService#countByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long BaseRuleChainService.countByTenantId(TenantId)"})
  public void testCountByTenantId_thenThrowEntityVersionMismatchException() {
    // Arrange
    EntityVersionMismatchException entityVersionMismatchException =
        new EntityVersionMismatchException("0123456789ABCDEF", new Throwable());
    when(ruleChainDao.countByTenantId(Mockito.<TenantId>any()))
        .thenThrow(entityVersionMismatchException);

    // Act and Assert
    assertThrows(
        EntityVersionMismatchException.class,
        () -> baseRuleChainService.countByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(ruleChainDao).countByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link BaseRuleChainService#getEntityType()}.
   *
   * <p>Method under test: {@link BaseRuleChainService#getEntityType()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType BaseRuleChainService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.RULE_CHAIN, new BaseRuleChainService().getEntityType());
  }
}
