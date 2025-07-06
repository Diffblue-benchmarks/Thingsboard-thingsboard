package org.thingsboard.server.dao.rule;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
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
  @Category(MaintainedByDiffblue.class)
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
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeId(TenantId, RuleNodeId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(ruleNodeStateDao).findByRuleNodeId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindByRuleNodeIdResult.EMPTY_PAGE_DATA, actualFindByRuleNodeIdResult);
  }

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(ruleNodeStateDao).findByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
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
  @Category(MaintainedByDiffblue.class)
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
            new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(ruleNodeStateDao).findByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertSame(ruleNodeState, actualFindByRuleNodeIdAndEntityIdResult);
  }

  /**
   * Test {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testFindByRuleNodeIdAndEntityId_whenNull_thenThrowDataValidationException() {
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
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testFindByRuleNodeIdAndEntityId_whenNull_thenThrowDataValidationException2() {
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
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#findByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.findByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testFindByRuleNodeIdAndEntityId_whenNull_thenThrowDataValidationException3() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.findByRuleNodeIdAndEntityId(
                ModelConstants.SYSTEM_TENANT,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                null));
  }

  /**
   * Test {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#save(TenantId, RuleNodeState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RuleNodeState BaseRuleNodeStateService.save(TenantId, RuleNodeState)"})
  public void testSave2() {
    // Arrange
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RuleNodeState BaseRuleNodeStateService.save(TenantId, RuleNodeState)"})
  public void testSave3() {
    // Arrange
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), null));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> baseRuleNodeStateService.save(ModelConstants.SYSTEM_TENANT, new RuleNodeState()));
    verify(ruleNodeStateDao).save(isA(TenantId.class), isA(RuleNodeState.class));
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"RuleNodeState BaseRuleNodeStateService.save(TenantId, RuleNodeState)"})
  public void testSave_givenRuleNodeStateDao_whenNull_thenThrowDataValidationException() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> baseRuleNodeStateService.save(null, new RuleNodeState()));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
                ModelConstants.SYSTEM_TENANT,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
   *   <li>Then calls {@link RuleNodeStateDao#removeByRuleNodeId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeId(TenantId, RuleNodeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void BaseRuleNodeStateService.removeByRuleNodeId(TenantId, RuleNodeId)"})
  public void testRemoveByRuleNodeId_thenCallsRemoveByRuleNodeId() {
    // Arrange
    doNothing().when(ruleNodeStateDao).removeByRuleNodeId(Mockito.<UUID>any());

    // Act
    baseRuleNodeStateService.removeByRuleNodeId(
        ModelConstants.SYSTEM_TENANT,
        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(ruleNodeStateDao).removeByRuleNodeId(isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BaseRuleNodeStateService.removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testRemoveByRuleNodeIdAndEntityId() {
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
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(ruleNodeStateDao).removeByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>Then calls {@link RuleNodeStateDao#removeByRuleNodeIdAndEntityId(UUID, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BaseRuleNodeStateService.removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testRemoveByRuleNodeIdAndEntityId_thenCallsRemoveByRuleNodeIdAndEntityId() {
    // Arrange
    doNothing()
        .when(ruleNodeStateDao)
        .removeByRuleNodeIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any());

    // Act
    baseRuleNodeStateService.removeByRuleNodeIdAndEntityId(
        ModelConstants.SYSTEM_TENANT,
        new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
        BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(ruleNodeStateDao).removeByRuleNodeIdAndEntityId(isA(UUID.class), isA(UUID.class));
  }

  /**
   * Test {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId,
   * EntityId)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BaseRuleNodeStateService.removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testRemoveByRuleNodeIdAndEntityId_whenNull_thenThrowDataValidationException() {
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
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BaseRuleNodeStateService.removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testRemoveByRuleNodeIdAndEntityId_whenNull_thenThrowDataValidationException2() {
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
   *   <li>When {@code null}.
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#removeByRuleNodeIdAndEntityId(TenantId,
   * RuleNodeId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void BaseRuleNodeStateService.removeByRuleNodeIdAndEntityId(TenantId, RuleNodeId, EntityId)"
  })
  public void testRemoveByRuleNodeIdAndEntityId_whenNull_thenThrowDataValidationException3() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            baseRuleNodeStateService.removeByRuleNodeIdAndEntityId(
                ModelConstants.SYSTEM_TENANT,
                new RuleNodeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                null));
  }

  /**
   * Test {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState, boolean)}.
   *
   * <p>Method under test: {@link BaseRuleNodeStateService#saveOrUpdate(TenantId, RuleNodeState,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.saveOrUpdate(TenantId, RuleNodeState, boolean)"
  })
  public void testSaveOrUpdate2() {
    // Arrange
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.saveOrUpdate(TenantId, RuleNodeState, boolean)"
  })
  public void testSaveOrUpdate3() {
    // Arrange
    when(ruleNodeStateDao.save(Mockito.<TenantId>any(), Mockito.<RuleNodeState>any()))
        .thenThrow(new ConstraintViolationException("An error occurred", new SQLException(), null));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "RuleNodeState BaseRuleNodeStateService.saveOrUpdate(TenantId, RuleNodeState, boolean)"
  })
  public void testSaveOrUpdate_givenBaseRuleNodeStateService_thenCallsGetId() {
    // Arrange
    BaseRuleNodeStateService baseRuleNodeStateService = new BaseRuleNodeStateService();
    RuleNodeId ruleNodeId = mock(RuleNodeId.class);
    when(ruleNodeId.getId())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "rule_node_state_unq_key"));

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
  @Category(MaintainedByDiffblue.class)
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
