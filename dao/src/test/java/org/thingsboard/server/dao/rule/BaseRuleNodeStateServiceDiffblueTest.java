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

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.UUID;
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
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleNodeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.rule.RuleNodeState;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {BaseRuleNodeStateService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseRuleNodeStateServiceDiffblueTest {
  @Autowired private BaseRuleNodeStateService baseRuleNodeStateService;

  @MockBean private RuleNodeStateDao ruleNodeStateDao;

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId, PageLink)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleNodeStateService.findByRuleNodeId(TenantId, RuleNodeId, PageLink)"
  })
  public void testFindByRuleNodeId() {
    // Arrange
    when(ruleNodeStateDao.findByRuleNodeId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.findByRuleNodeId(
                ModelConstants.SYSTEM_TENANT,
                new RuleNodeId(ModelConstants.NULL_UUID),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(ruleNodeStateDao).findByRuleNodeId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleNodeStateService.findByRuleNodeId(TenantId, RuleNodeId, PageLink)"
  })
  public void testFindByRuleNodeId_givenRuleNodeStateDao_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.findByRuleNodeId(
                null, null, BaseRelatedEdgesService.FIRST_PAGE));
  }

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleNodeStateService.findByRuleNodeId(TenantId, RuleNodeId, PageLink)"
  })
  public void testFindByRuleNodeId_givenRuleNodeStateDao_whenNull2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.findByRuleNodeId(
                ModelConstants.SYSTEM_TENANT, null, BaseRelatedEdgesService.FIRST_PAGE));
  }

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleNodeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleNodeStateService.findByRuleNodeId(TenantId, RuleNodeId, PageLink)"
  })
  public void testFindByRuleNodeId_thenCallsGetId() {
    // Arrange
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.findByRuleNodeId(
                ModelConstants.SYSTEM_TENANT, ruleNodeId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(ruleNodeId).getId();
  }

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId,
   * PageLink)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseRuleNodeStateService.findByRuleNodeId(TenantId, RuleNodeId, PageLink)"
  })
  public void testFindByRuleNodeId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<RuleNodeState> emptyPageDataResult = PageData.emptyPageData();
    when(ruleNodeStateDao.findByRuleNodeId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<RuleNodeState> actualFindByRuleNodeIdResult =
        baseRuleNodeStateService.findByRuleNodeId(
            ModelConstants.SYSTEM_TENANT,
            new RuleNodeId(ModelConstants.NULL_UUID),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeStateDao).findByRuleNodeId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindByRuleNodeIdResult);
  }

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testFindByRuleNodeIdAndEntityId() {
    // Arrange
    when(ruleNodeStateDao.findByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.findByRuleNodeIdAndEntityId(
                ModelConstants.SYSTEM_TENANT,
                new RuleNodeId(ModelConstants.NULL_UUID),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(ruleNodeStateDao).findByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testFindByRuleNodeIdAndEntityId_givenRuleNodeStateDao_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRuleNodeStateService.findByRuleNodeIdAndEntityId(null, null, null));
  }

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testFindByRuleNodeIdAndEntityId_givenRuleNodeStateDao_whenNull2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.findByRuleNodeIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, null, null));
  }

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testFindByRuleNodeIdAndEntityId_givenRuleNodeStateDao_whenNull3() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.findByRuleNodeIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID), null));
  }

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleNodeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testFindByRuleNodeIdAndEntityId_thenCallsGetId() {
    // Arrange
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.findByRuleNodeIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, ruleNodeId, BaseEntityService.NULL_CUSTOMER_ID));
    verify(ruleNodeId).getId();
  }

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testFindByRuleNodeIdAndEntityId_thenCallsGetId2() {
    // Arrange
    RuleNodeId ruleNodeId = new RuleNodeId(ModelConstants.NULL_UUID);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.findByRuleNodeIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, ruleNodeId, entityId));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Then return {@link RuleNodeState#RuleNodeState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testFindByRuleNodeIdAndEntityId_thenReturnRuleNodeState() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    when(ruleNodeStateDao.findByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(ruleNodeState);

    // Act
    RuleNodeState actualFindByRuleNodeIdAndEntityIdResult =
        baseRuleNodeStateService.findByRuleNodeIdAndEntityId(
            ModelConstants.SYSTEM_TENANT,
            new RuleNodeId(ModelConstants.NULL_UUID),
            BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(ruleNodeStateDao).findByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertSame(ruleNodeState, actualFindByRuleNodeIdAndEntityIdResult);
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState BaseRuleNodeStateService.save(TenantId, RuleNodeState)"})
  public void testSave() {
    // Arrange
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRuleNodeStateService.save(ModelConstants.SYSTEM_TENANT, new RuleNodeState()));
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState BaseRuleNodeStateService.save(TenantId, RuleNodeState)"})
  public void testSave2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseRuleNodeStateService.save(ModelConstants.SYSTEM_TENANT, new RuleNodeState()));
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState BaseRuleNodeStateService.save(TenantId, RuleNodeState)"})
  public void testSave3() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), null);
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseRuleNodeStateService.save(ModelConstants.SYSTEM_TENANT, new RuleNodeState()));
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState BaseRuleNodeStateService.save(TenantId, RuleNodeState)"})
  public void testSave4() {
    // Arrange
    when(ruleNodeStateDao.findByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "rule_node_state_unq_key");
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(constraintViolationException);

    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    ruleNodeState.setRuleNodeId(new RuleNodeId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRuleNodeStateService.save(ModelConstants.SYSTEM_TENANT, ruleNodeState));
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
    verify(ruleNodeStateDao).findByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState BaseRuleNodeStateService.save(TenantId, RuleNodeState)"})
  public void testSave5() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "rule_node_state_unq_key");
    when(ruleNodeStateDao.findByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);
    ConstraintViolationException constraintViolationException2 =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "rule_node_state_unq_key");
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(constraintViolationException2);

    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    ruleNodeState.setRuleNodeId(new RuleNodeId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRuleNodeStateService.save(ModelConstants.SYSTEM_TENANT, ruleNodeState));
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
    verify(ruleNodeStateDao).findByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao} {@link RuleNodeStateDao#findByRuleNodeIdAndEntityId(UUID,
   *       UUID)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState BaseRuleNodeStateService.save(TenantId, RuleNodeState)"})
  public void testSave_givenRuleNodeStateDaoFindByRuleNodeIdAndEntityIdReturnNull() {
    // Arrange
    when(ruleNodeStateDao.findByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(null);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "rule_node_state_unq_key");
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(constraintViolationException);

    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    ruleNodeState.setRuleNodeId(new RuleNodeId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRuleNodeStateService.save(ModelConstants.SYSTEM_TENANT, ruleNodeState));
    verify(ruleNodeStateDao, atLeast(1)).save(isA(TenantId.class), isA(RuleNodeState.class));
    verify(ruleNodeStateDao).findByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao} {@link RuleNodeStateDao#save(TenantId, Object)} return
   *       {@link RuleNodeState#RuleNodeState()}.
   *   <li>Then return {@link RuleNodeState#RuleNodeState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState BaseRuleNodeStateService.save(TenantId, RuleNodeState)"})
  public void testSave_givenRuleNodeStateDaoSaveReturnRuleNodeState_thenReturnRuleNodeState() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenReturn(ruleNodeState);

    // Act
    RuleNodeState actualSaveResult =
        baseRuleNodeStateService.save(ModelConstants.SYSTEM_TENANT, new RuleNodeState());

    // Assert
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
    assertSame(ruleNodeState, actualSaveResult);
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao}.
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState BaseRuleNodeStateService.save(TenantId, RuleNodeState)"})
  public void testSave_givenRuleNodeStateDao_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRuleNodeStateService.save(null, new RuleNodeState()));
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleNodeState#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"RuleNodeState BaseRuleNodeStateService.save(TenantId, RuleNodeState)"})
  public void testSave_thenCallsGetId() {
    // Arrange
    RuleNodeState ruleNodeState = mock(RuleNodeState.class);
    when(ruleNodeState.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(ruleNodeStateDao.findByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any()))
        .thenReturn(ruleNodeState);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "rule_node_state_unq_key");
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(constraintViolationException);

    RuleNodeState ruleNodeState2 = new RuleNodeState();
    ruleNodeState2.setEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    ruleNodeState2.setRuleNodeId(new RuleNodeId(UUID.randomUUID()));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRuleNodeStateService.save(ModelConstants.SYSTEM_TENANT, ruleNodeState2));
    verify(ruleNodeState).getId();
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
    verify(ruleNodeStateDao).findByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleNodeStateService.removeByRuleNodeId(TenantId, RuleNodeId)"})
  public void testRemoveByRuleNodeId() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(ruleNodeStateDao)
        .removeByRuleNodeId(Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.removeByRuleNodeId(
                ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID)));
    verify(ruleNodeStateDao).removeByRuleNodeId(isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao} {@link RuleNodeStateDao#removeByRuleNodeId(UUID)} does
   *       nothing.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleNodeStateService.removeByRuleNodeId(TenantId, RuleNodeId)"})
  public void testRemoveByRuleNodeId_givenRuleNodeStateDaoRemoveByRuleNodeIdDoesNothing() {
    // Arrange
    doNothing().when(ruleNodeStateDao).removeByRuleNodeId(Mockito.<UUID>any());

    // Act
    baseRuleNodeStateService.removeByRuleNodeId(
        ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID));

    // Assert
    verify(ruleNodeStateDao).removeByRuleNodeId(isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleNodeStateService.removeByRuleNodeId(TenantId, RuleNodeId)"})
  public void testRemoveByRuleNodeId_givenRuleNodeStateDao_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRuleNodeStateService.removeByRuleNodeId(null, null));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleNodeStateService.removeByRuleNodeId(TenantId, RuleNodeId)"})
  public void testRemoveByRuleNodeId_givenRuleNodeStateDao_whenNull2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRuleNodeStateService.removeByRuleNodeId(ModelConstants.SYSTEM_TENANT, null));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleNodeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void BaseRuleNodeStateService.removeByRuleNodeId(TenantId, RuleNodeId)"})
  public void testRemoveByRuleNodeId_thenCallsGetId() {
    // Arrange
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.removeByRuleNodeId(ModelConstants.SYSTEM_TENANT, ruleNodeId));
    verify(ruleNodeId).getId();
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRuleNodeStateService.removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testRemoveByRuleNodeIdAndEntityId() {
    // Arrange
    doNothing()
        .when(ruleNodeStateDao)
        .removeByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any());

    // Act
    baseRuleNodeStateService.removeByRuleNodeIdAndEntityId(
        ModelConstants.SYSTEM_TENANT,
        new RuleNodeId(ModelConstants.NULL_UUID),
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(ruleNodeStateDao).removeByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRuleNodeStateService.removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testRemoveByRuleNodeIdAndEntityId2() {
    // Arrange
    doThrow(new DataValidationException("An error occurred"))
        .when(ruleNodeStateDao)
        .removeByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.removeByRuleNodeIdAndEntityId(
                ModelConstants.SYSTEM_TENANT,
                new RuleNodeId(ModelConstants.NULL_UUID),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(ruleNodeStateDao).removeByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRuleNodeStateService.removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testRemoveByRuleNodeIdAndEntityId_givenRuleNodeStateDao_whenNull() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRuleNodeStateService.removeByRuleNodeIdAndEntityId(null, null, null));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRuleNodeStateService.removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testRemoveByRuleNodeIdAndEntityId_givenRuleNodeStateDao_whenNull2() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.removeByRuleNodeIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, null, null));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Given {@link RuleNodeStateDao}.
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRuleNodeStateService.removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testRemoveByRuleNodeIdAndEntityId_givenRuleNodeStateDao_whenNull3() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.removeByRuleNodeIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, new RuleNodeId(ModelConstants.NULL_UUID), null));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleNodeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRuleNodeStateService.removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testRemoveByRuleNodeIdAndEntityId_thenCallsGetId() {
    // Arrange
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.removeByRuleNodeIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, ruleNodeId, BaseEntityService.NULL_CUSTOMER_ID));
    verify(ruleNodeId).getId();
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void BaseRuleNodeStateService.removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testRemoveByRuleNodeIdAndEntityId_thenCallsGetId2() {
    // Arrange
    RuleNodeId ruleNodeId = new RuleNodeId(ModelConstants.NULL_UUID);

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.removeByRuleNodeIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, ruleNodeId, entityId));
    verify(entityId).getId();
  }

  /**
   * Test {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.saveOrUpdate(TenantId, RuleNodeState, boolean)"
  })
  public void testSaveOrUpdate() {
    // Arrange
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.saveOrUpdate(
                ModelConstants.SYSTEM_TENANT, new RuleNodeState(), false));
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.saveOrUpdate(TenantId, RuleNodeState, boolean)"
  })
  public void testSaveOrUpdate2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseRuleNodeStateService.saveOrUpdate(
                ModelConstants.SYSTEM_TENANT, new RuleNodeState(), false));
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.saveOrUpdate(TenantId, RuleNodeState, boolean)"
  })
  public void testSaveOrUpdate3() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException("An error occurred", new SQLException(), null);
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            baseRuleNodeStateService.saveOrUpdate(
                ModelConstants.SYSTEM_TENANT, new RuleNodeState(), false));
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}.
   *
   * <ul>
   *   <li>Given {@link BaseRuleNodeStateService} (default constructor).
   *   <li>Then calls {@link RuleNodeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.saveOrUpdate(TenantId, RuleNodeState, boolean)"
  })
  public void testSaveOrUpdate_givenBaseRuleNodeStateService_thenCallsGetId() {
    // Arrange
    BaseRuleNodeStateService baseRuleNodeStateService = new BaseRuleNodeStateService();

    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "rule_node_state_unq_key");
    when(ruleNodeId.getId()).thenThrow(constraintViolationException);

    RuleNodeState ruleNodeState = new RuleNodeState();
    ruleNodeState.setRuleNodeId(ruleNodeId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.saveOrUpdate(
                ModelConstants.SYSTEM_TENANT, ruleNodeState, true));
    verify(ruleNodeId).getId();
  }

  /**
   * Test {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link RuleNodeState#RuleNodeState()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState,
   * boolean)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.saveOrUpdate(TenantId, RuleNodeState, boolean)"
  })
  public void testSaveOrUpdate_thenReturnRuleNodeState() {
    // Arrange
    RuleNodeState ruleNodeState = new RuleNodeState();
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenReturn(ruleNodeState);

    // Act
    RuleNodeState actualSaveOrUpdateResult =
        baseRuleNodeStateService.saveOrUpdate(
            ModelConstants.SYSTEM_TENANT, new RuleNodeState(), false);

    // Assert
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
    assertSame(ruleNodeState, actualSaveOrUpdateResult);
  }
}
