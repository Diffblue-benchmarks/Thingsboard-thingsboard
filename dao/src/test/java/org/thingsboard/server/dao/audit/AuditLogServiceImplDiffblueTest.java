package org.thingsboard.server.dao.audit;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.HasName;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.audit.AuditLog;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@RunWith(MockitoJUnitRunner.class)
public class AuditLogServiceImplDiffblueTest {
  @Mock private AuditLogDao auditLogDao;

  @Mock private AuditLogLevelFilter auditLogLevelFilter;

  @InjectMocks private AuditLogServiceImpl auditLogServiceImpl;

  @Mock private DataValidator<AuditLog> dataValidator;

  @Mock private JpaExecutorService jpaExecutorService;

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId,
   * List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ADDED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId,
   * CustomerId, List, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData AuditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndCustomerId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<CustomerId>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult =
        auditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes,
            new TimePageLink(3));

    // Assert
    verify(auditLogDao)
        .findAuditLogsByTenantIdAndCustomerId(
            isA(UUID.class), isA(CustomerId.class), isA(List.class), isA(TimePageLink.class));
    assertSame(
        actualFindAuditLogsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindAuditLogsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId,
   * List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DELETED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId,
   * CustomerId, List, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData AuditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndCustomerId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<CustomerId>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult =
        auditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes,
            new TimePageLink(3));

    // Assert
    verify(auditLogDao)
        .findAuditLogsByTenantIdAndCustomerId(
            isA(UUID.class), isA(CustomerId.class), isA(List.class), isA(TimePageLink.class));
    assertSame(
        actualFindAuditLogsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindAuditLogsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId,
   * List, TimePageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndCustomerId(TenantId,
   * CustomerId, List, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData AuditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(TenantId, CustomerId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndCustomerId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantIdAndCustomerId(
            Mockito.<UUID>any(),
            Mockito.<CustomerId>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndCustomerIdResult =
        auditLogServiceImpl.findAuditLogsByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes,
            new TimePageLink(3));

    // Assert
    verify(auditLogDao)
        .findAuditLogsByTenantIdAndCustomerId(
            isA(UUID.class), isA(CustomerId.class), isA(List.class), isA(TimePageLink.class));
    assertSame(
        actualFindAuditLogsByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindAuditLogsByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List,
   * TimePageLink)}.
   *
   * <p>Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId,
   * UserId, List, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData AuditLogServiceImpl.findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndUserId() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantIdAndUserId(
            Mockito.<UUID>any(),
            Mockito.<UserId>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);
    UserId userId = new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult =
        auditLogServiceImpl.findAuditLogsByTenantIdAndUserId(
            ModelConstants.SYSTEM_TENANT, userId, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogDao)
        .findAuditLogsByTenantIdAndUserId(
            isA(UUID.class), isA(UserId.class), isA(List.class), isA(TimePageLink.class));
    assertSame(
        actualFindAuditLogsByTenantIdAndUserIdResult.EMPTY_PAGE_DATA,
        actualFindAuditLogsByTenantIdAndUserIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId, UserId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link UserId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndUserId(TenantId,
   * UserId, List, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData AuditLogServiceImpl.findAuditLogsByTenantIdAndUserId(TenantId, UserId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndUserId_thenCallsGetId() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantIdAndUserId(
            Mockito.<UUID>any(),
            Mockito.<UserId>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);
    UserId userId = mock(UserId.class);
    when(userId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndUserIdResult =
        auditLogServiceImpl.findAuditLogsByTenantIdAndUserId(
            ModelConstants.SYSTEM_TENANT, userId, actionTypes, new TimePageLink(3));

    // Assert
    verify(userId).getId();
    verify(auditLogDao)
        .findAuditLogsByTenantIdAndUserId(
            isA(UUID.class), isA(UserId.class), isA(List.class), isA(TimePageLink.class));
    assertSame(
        actualFindAuditLogsByTenantIdAndUserIdResult.EMPTY_PAGE_DATA,
        actualFindAuditLogsByTenantIdAndUserIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ADDED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId,
   * EntityId, List, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData AuditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult =
        auditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT, entityId, actionTypes, new TimePageLink(3));

    // Assert
    verify(entityId).getId();
    verify(auditLogDao)
        .findAuditLogsByTenantIdAndEntityId(
            isA(UUID.class), isA(EntityId.class), isA(List.class), isA(TimePageLink.class));
    assertSame(
        actualFindAuditLogsByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA,
        actualFindAuditLogsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DELETED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId,
   * EntityId, List, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData AuditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult =
        auditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT, entityId, actionTypes, new TimePageLink(3));

    // Assert
    verify(entityId).getId();
    verify(auditLogDao)
        .findAuditLogsByTenantIdAndEntityId(
            isA(UUID.class), isA(EntityId.class), isA(List.class), isA(TimePageLink.class));
    assertSame(
        actualFindAuditLogsByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA,
        actualFindAuditLogsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId,
   * EntityId, List, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData AuditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId_thenCallsGetId() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult =
        auditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT, entityId, actionTypes, new TimePageLink(3));

    // Assert
    verify(entityId).getId();
    verify(auditLogDao)
        .findAuditLogsByTenantIdAndEntityId(
            isA(UUID.class), isA(EntityId.class), isA(List.class), isA(TimePageLink.class));
    assertSame(
        actualFindAuditLogsByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA,
        actualFindAuditLogsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List,
   * TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantIdAndEntityId(TenantId,
   * EntityId, List, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData AuditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(TenantId, EntityId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantIdAndEntityId_whenNull_customer_id() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<EntityId>any(),
            Mockito.<List<ActionType>>any(),
            Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdAndEntityIdResult =
        auditLogServiceImpl.findAuditLogsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            actionTypes,
            new TimePageLink(3));

    // Assert
    verify(auditLogDao)
        .findAuditLogsByTenantIdAndEntityId(
            isA(UUID.class), isA(EntityId.class), isA(List.class), isA(TimePageLink.class));
    assertSame(
        actualFindAuditLogsByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA,
        actualFindAuditLogsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code ADDED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List,
   * TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData AuditLogServiceImpl.findAuditLogsByTenantId(TenantId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantId(
            Mockito.<UUID>any(), Mockito.<List<ActionType>>any(), Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult =
        auditLogServiceImpl.findAuditLogsByTenantId(
            ModelConstants.SYSTEM_TENANT, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogDao)
        .findAuditLogsByTenantId(isA(UUID.class), isA(List.class), isA(TimePageLink.class));
    assertSame(
        actualFindAuditLogsByTenantIdResult.EMPTY_PAGE_DATA, actualFindAuditLogsByTenantIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}.
   *
   * <ul>
   *   <li>Given {@code DELETED}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List,
   * TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData AuditLogServiceImpl.findAuditLogsByTenantId(TenantId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantId(
            Mockito.<UUID>any(), Mockito.<List<ActionType>>any(), Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult =
        auditLogServiceImpl.findAuditLogsByTenantId(
            ModelConstants.SYSTEM_TENANT, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogDao)
        .findAuditLogsByTenantId(isA(UUID.class), isA(List.class), isA(TimePageLink.class));
    assertSame(
        actualFindAuditLogsByTenantIdResult.EMPTY_PAGE_DATA, actualFindAuditLogsByTenantIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List,
   * TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData AuditLogServiceImpl.findAuditLogsByTenantId(TenantId, List, TimePageLink)"
  })
  public void testFindAuditLogsByTenantId_whenSystem_tenant_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantId(
            Mockito.<UUID>any(), Mockito.<List<ActionType>>any(), Mockito.<TimePageLink>any()))
        .thenReturn(emptyPageDataResult);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult =
        auditLogServiceImpl.findAuditLogsByTenantId(
            ModelConstants.SYSTEM_TENANT, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogDao)
        .findAuditLogsByTenantId(isA(UUID.class), isA(List.class), isA(TimePageLink.class));
    assertSame(
        actualFindAuditLogsByTenantIdResult.EMPTY_PAGE_DATA, actualFindAuditLogsByTenantIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>Given {@link AuditLogLevelFilter} {@link AuditLogLevelFilter#logEnabled(EntityType,
   *       ActionType)} return {@code false}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_givenAuditLogLevelFilterLogEnabledReturnFalse_thenReturnNull() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(false);
    HasName hasName = mock(HasName.class);

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            BaseEntityService.NULL_CUSTOMER_ID,
            hasName,
            ActionType.ADDED,
            new Exception("foo"),
            "Additional Info");

    // Assert
    verify(auditLogLevelFilter).logEnabled(eq(EntityType.CUSTOMER), eq(ActionType.ADDED));
    assertNull(actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>Given {@link EntityType#DASHBOARD}.
   *   <li>When {@code CREDENTIALS_UPDATED}.
   *   <li>Then calls {@link EntityId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_givenDashboard_whenCredentialsUpdated_thenCallsGetEntityType() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            entityId,
            hasName,
            ActionType.CREDENTIALS_UPDATED,
            new Exception("foo"),
            "Additional Info");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(entityId).getEntityType();
    verify(auditLogLevelFilter)
        .logEnabled(eq(EntityType.DASHBOARD), eq(ActionType.CREDENTIALS_UPDATED));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>Given {@link EntityType#DASHBOARD}.
   *   <li>When empty string.
   *   <li>Then calls {@link EntityId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_givenDashboard_whenEmptyString_thenCallsGetEntityType() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            entityId,
            hasName,
            ActionType.RPC_CALL,
            new Exception("foo"),
            "");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(entityId).getEntityType();
    verify(auditLogLevelFilter).logEnabled(eq(EntityType.DASHBOARD), eq(ActionType.RPC_CALL));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>Given {@link EntityType#DASHBOARD}.
   *   <li>When {@link ActionType#RPC_CALL}.
   *   <li>Then calls {@link EntityId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_givenDashboard_whenRpc_call_thenCallsGetEntityType() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            entityId,
            hasName,
            ActionType.RPC_CALL,
            new Exception("foo"),
            "Additional Info");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(entityId).getEntityType();
    verify(auditLogLevelFilter).logEnabled(eq(EntityType.DASHBOARD), eq(ActionType.RPC_CALL));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>Given {@link EntityType#DASHBOARD}.
   *   <li>When {@code TIMESERIES_DELETED}.
   *   <li>Then calls {@link EntityId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_givenDashboard_whenTimeseriesDeleted_thenCallsGetEntityType() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            entityId,
            hasName,
            ActionType.TIMESERIES_DELETED,
            new Exception("foo"),
            "Additional Info");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(entityId).getEntityType();
    verify(auditLogLevelFilter)
        .logEnabled(eq(EntityType.DASHBOARD), eq(ActionType.TIMESERIES_DELETED));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>Given {@link EntityType#DASHBOARD}.
   *   <li>When {@code TIMESERIES_UPDATED}.
   *   <li>Then calls {@link EntityId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_givenDashboard_whenTimeseriesUpdated_thenCallsGetEntityType() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            entityId,
            hasName,
            ActionType.TIMESERIES_UPDATED,
            new Exception("foo"),
            "Additional Info");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(entityId).getEntityType();
    verify(auditLogLevelFilter)
        .logEnabled(eq(EntityType.DASHBOARD), eq(ActionType.TIMESERIES_UPDATED));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>Given {@link EntityType#DASHBOARD}.
   *   <li>When {@code true}.
   *   <li>Then calls {@link EntityId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_givenDashboard_whenTrue_thenCallsGetEntityType() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getEntityType()).thenReturn(EntityType.DASHBOARD);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            entityId,
            hasName,
            ActionType.RPC_CALL,
            new Exception("foo"),
            true);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(entityId).getEntityType();
    verify(auditLogLevelFilter).logEnabled(eq(EntityType.DASHBOARD), eq(ActionType.RPC_CALL));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>When {@code ASSIGNED_TO_CUSTOMER}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_whenAssignedToCustomer_thenReturnSettableFuture() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            BaseEntityService.NULL_CUSTOMER_ID,
            hasName,
            ActionType.ASSIGNED_TO_CUSTOMER,
            new Exception("foo"),
            "Additional Info");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(auditLogLevelFilter)
        .logEnabled(eq(EntityType.CUSTOMER), eq(ActionType.ASSIGNED_TO_CUSTOMER));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>When {@code CREDENTIALS_UPDATED}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_whenCredentialsUpdated_thenReturnSettableFuture() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            BaseEntityService.NULL_CUSTOMER_ID,
            hasName,
            ActionType.CREDENTIALS_UPDATED,
            new Exception("foo"),
            "Additional Info");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(auditLogLevelFilter)
        .logEnabled(eq(EntityType.CUSTOMER), eq(ActionType.CREDENTIALS_UPDATED));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>When {@code DELETED}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_whenDeleted_thenReturnSettableFuture() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            BaseEntityService.NULL_CUSTOMER_ID,
            hasName,
            ActionType.DELETED,
            new Exception("foo"),
            "Additional Info");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(auditLogLevelFilter).logEnabled(eq(EntityType.CUSTOMER), eq(ActionType.DELETED));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>When {@code DELETED}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_whenDeleted_thenReturnSettableFuture2() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            BaseEntityService.NULL_CUSTOMER_ID,
            hasName,
            ActionType.DELETED,
            null,
            "Additional Info");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(auditLogLevelFilter).logEnabled(eq(EntityType.CUSTOMER), eq(ActionType.DELETED));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>When {@code DELETED}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_whenDeleted_thenReturnSettableFuture3() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            BaseEntityService.NULL_CUSTOMER_ID,
            hasName,
            ActionType.DELETED,
            new Exception("foo"),
            null);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(auditLogLevelFilter).logEnabled(eq(EntityType.CUSTOMER), eq(ActionType.DELETED));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_whenEmptyString_thenReturnSettableFuture() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            BaseEntityService.NULL_CUSTOMER_ID,
            hasName,
            ActionType.DELETED,
            new Exception("foo"),
            "");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(auditLogLevelFilter).logEnabled(eq(EntityType.CUSTOMER), eq(ActionType.DELETED));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>When {@link ActionType#RPC_CALL}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_whenRpc_call_thenReturnSettableFuture() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            BaseEntityService.NULL_CUSTOMER_ID,
            hasName,
            ActionType.RPC_CALL,
            new Exception("foo"),
            "Additional Info");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(auditLogLevelFilter).logEnabled(eq(EntityType.CUSTOMER), eq(ActionType.RPC_CALL));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>When six.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_whenSix_thenReturnSettableFuture() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            BaseEntityService.NULL_CUSTOMER_ID,
            hasName,
            ActionType.DELETED,
            new Exception("foo"),
            6);

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(auditLogLevelFilter).logEnabled(eq(EntityType.CUSTOMER), eq(ActionType.DELETED));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>When {@code TIMESERIES_DELETED}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_whenTimeseriesDeleted_thenReturnSettableFuture() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            BaseEntityService.NULL_CUSTOMER_ID,
            hasName,
            ActionType.TIMESERIES_DELETED,
            new Exception("foo"),
            "Additional Info");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(auditLogLevelFilter)
        .logEnabled(eq(EntityType.CUSTOMER), eq(ActionType.TIMESERIES_DELETED));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>When {@code TIMESERIES_UPDATED}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_whenTimeseriesUpdated_thenReturnSettableFuture() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            BaseEntityService.NULL_CUSTOMER_ID,
            hasName,
            ActionType.TIMESERIES_UPDATED,
            new Exception("foo"),
            "Additional Info");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(auditLogLevelFilter)
        .logEnabled(eq(EntityType.CUSTOMER), eq(ActionType.TIMESERIES_UPDATED));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId, String, EntityId,
   * HasName, ActionType, Exception, Object[])}.
   *
   * <ul>
   *   <li>When {@code UNASSIGNED_FROM_CUSTOMER}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link AuditLogServiceImpl#logEntityAction(TenantId, CustomerId, UserId,
   * String, EntityId, HasName, ActionType, Exception, Object[])}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture AuditLogServiceImpl.logEntityAction(TenantId, CustomerId, UserId, String, EntityId, HasName, ActionType, Exception, Object[])"
  })
  public void testLogEntityAction_whenUnassignedFromCustomer_thenReturnSettableFuture() {
    // Arrange
    when(auditLogLevelFilter.logEnabled(Mockito.<EntityType>any(), Mockito.<ActionType>any()))
        .thenReturn(true);
    when(dataValidator.validate(
            Mockito.<AuditLog>any(), Mockito.<Function<AuditLog, TenantId>>any()))
        .thenReturn(new AuditLog());
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);
    HasName hasName = mock(HasName.class);
    when(hasName.getName()).thenReturn("Name");

    // Act
    ListenableFuture<Void> actualLogEntityActionResult =
        auditLogServiceImpl.logEntityAction(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            null,
            "janedoe",
            BaseEntityService.NULL_CUSTOMER_ID,
            hasName,
            ActionType.UNASSIGNED_FROM_CUSTOMER,
            new Exception("foo"),
            "Additional Info");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(hasName).getName();
    verify(auditLogLevelFilter)
        .logEnabled(eq(EntityType.CUSTOMER), eq(ActionType.UNASSIGNED_FROM_CUSTOMER));
    verify(dataValidator).validate(isA(AuditLog.class), isA(Function.class));
    assertTrue(actualLogEntityActionResult instanceof SettableFuture);
    assertSame(createResult, actualLogEntityActionResult);
  }
}
