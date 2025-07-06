package org.thingsboard.server.dao.alarm;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.alarm.AlarmComment.AlarmCommentBuilder;
import org.thingsboard.server.common.data.alarm.AlarmCommentInfo;
import org.thingsboard.server.common.data.alarm.AlarmCommentType;
import org.thingsboard.server.common.data.id.AlarmCommentId;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseAlarmCommentService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class BaseAlarmCommentServiceDiffblueTest {
  @Mock private AlarmCommentDao alarmCommentDao;

  @MockBean private AlarmCommentDao alarmCommentDao2;

  @InjectMocks private BaseAlarmCommentService baseAlarmCommentService;

  @Autowired private BaseAlarmCommentService baseAlarmCommentService2;

  @MockBean private DataValidator<AlarmComment> dataValidator;

  /**
   * Test {@link BaseAlarmCommentService#findAlarmComments(TenantId, AlarmId, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmCommentService#findAlarmComments(TenantId, AlarmId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData BaseAlarmCommentService.findAlarmComments(TenantId, AlarmId, PageLink)"
  })
  public void testFindAlarmComments_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AlarmCommentInfo> emptyPageDataResult = PageData.emptyPageData();
    when(alarmCommentDao2.findAlarmComments(
            Mockito.<TenantId>any(), Mockito.<AlarmId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult =
        baseAlarmCommentService2.findAlarmComments(
            ModelConstants.SYSTEM_TENANT, null, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmCommentDao2).findAlarmComments(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(actualFindAlarmCommentsResult.EMPTY_PAGE_DATA, actualFindAlarmCommentsResult);
  }

  /**
   * Test {@link BaseAlarmCommentService#findAlarmCommentByIdAsync(TenantId, AlarmCommentId)}.
   *
   * <p>Method under test: {@link BaseAlarmCommentService#findAlarmCommentByIdAsync(TenantId,
   * AlarmCommentId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAlarmCommentService.findAlarmCommentByIdAsync(TenantId, AlarmCommentId)"
  })
  public void testFindAlarmCommentByIdAsync() {
    // Arrange
    SettableFuture<AlarmComment> createResult = SettableFuture.create();
    when(alarmCommentDao2.findAlarmCommentByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<AlarmComment> actualFindAlarmCommentByIdAsyncResult =
        baseAlarmCommentService2.findAlarmCommentByIdAsync(
            ModelConstants.SYSTEM_TENANT,
            new AlarmCommentId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(alarmCommentDao2).findAlarmCommentByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindAlarmCommentByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAlarmCommentByIdAsyncResult);
  }

  /**
   * Test {@link BaseAlarmCommentService#findAlarmCommentByIdAsync(TenantId, AlarmCommentId)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmCommentId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmCommentService#findAlarmCommentByIdAsync(TenantId,
   * AlarmCommentId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture BaseAlarmCommentService.findAlarmCommentByIdAsync(TenantId, AlarmCommentId)"
  })
  public void testFindAlarmCommentByIdAsync_thenCallsGetId() {
    // Arrange
    SettableFuture<AlarmComment> createResult = SettableFuture.create();
    when(alarmCommentDao2.findAlarmCommentByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<AlarmComment> actualFindAlarmCommentByIdAsyncResult =
        baseAlarmCommentService2.findAlarmCommentByIdAsync(
            ModelConstants.SYSTEM_TENANT, alarmCommentId);

    // Assert
    verify(alarmCommentId, atLeast(1)).getId();
    verify(alarmCommentDao2).findAlarmCommentByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindAlarmCommentByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAlarmCommentByIdAsyncResult);
  }

  /**
   * Test {@link BaseAlarmCommentService#findAlarmCommentById(TenantId, AlarmCommentId)}.
   *
   * <p>Method under test: {@link BaseAlarmCommentService#findAlarmCommentById(TenantId,
   * AlarmCommentId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "AlarmComment BaseAlarmCommentService.findAlarmCommentById(TenantId, AlarmCommentId)"
  })
  public void testFindAlarmCommentById() {
    // Arrange
    AlarmCommentBuilder alarmCommentBuilder = mock(AlarmCommentBuilder.class);
    when(alarmCommentBuilder.type(Mockito.<AlarmCommentType>any()))
        .thenReturn(AlarmComment.builder());
    AlarmCommentBuilder alarmCommentBuilder2 = mock(AlarmCommentBuilder.class);
    when(alarmCommentBuilder2.comment(Mockito.<JsonNode>any())).thenReturn(alarmCommentBuilder);
    AlarmCommentBuilder alarmCommentBuilder3 = mock(AlarmCommentBuilder.class);
    when(alarmCommentBuilder3.alarmId(Mockito.<AlarmId>any())).thenReturn(alarmCommentBuilder2);
    AlarmComment buildResult =
        alarmCommentBuilder3
            .alarmId(null)
            .comment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .type(AlarmCommentType.SYSTEM)
            .userId(null)
            .build();
    when(alarmCommentDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(buildResult);

    // Act
    AlarmComment actualFindAlarmCommentByIdResult =
        baseAlarmCommentService.findAlarmCommentById(
            ModelConstants.SYSTEM_TENANT,
            new AlarmCommentId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(alarmCommentBuilder3).alarmId(isNull());
    verify(alarmCommentBuilder2).comment(isA(JsonNode.class));
    verify(alarmCommentBuilder).type(eq(AlarmCommentType.SYSTEM));
    verify(alarmCommentDao).findById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualFindAlarmCommentByIdResult.getComment());
    assertNull(actualFindAlarmCommentByIdResult.getUuidId());
    assertNull(actualFindAlarmCommentByIdResult.getType());
    assertNull(actualFindAlarmCommentByIdResult.getId());
    assertNull(actualFindAlarmCommentByIdResult.getAlarmId());
    assertNull(actualFindAlarmCommentByIdResult.getUserId());
    assertEquals(0L, actualFindAlarmCommentByIdResult.getCreatedTime());
  }

  /**
   * Test {@link BaseAlarmCommentService#findAlarmCommentById(TenantId, AlarmCommentId)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmCommentId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmCommentService#findAlarmCommentById(TenantId,
   * AlarmCommentId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "AlarmComment BaseAlarmCommentService.findAlarmCommentById(TenantId, AlarmCommentId)"
  })
  public void testFindAlarmCommentById_thenCallsGetId() {
    // Arrange
    AlarmCommentBuilder alarmCommentBuilder = mock(AlarmCommentBuilder.class);
    when(alarmCommentBuilder.type(Mockito.<AlarmCommentType>any()))
        .thenReturn(AlarmComment.builder());
    AlarmCommentBuilder alarmCommentBuilder2 = mock(AlarmCommentBuilder.class);
    when(alarmCommentBuilder2.comment(Mockito.<JsonNode>any())).thenReturn(alarmCommentBuilder);
    AlarmCommentBuilder alarmCommentBuilder3 = mock(AlarmCommentBuilder.class);
    when(alarmCommentBuilder3.alarmId(Mockito.<AlarmId>any())).thenReturn(alarmCommentBuilder2);
    AlarmComment buildResult =
        alarmCommentBuilder3
            .alarmId(null)
            .comment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
            .type(AlarmCommentType.SYSTEM)
            .userId(null)
            .build();
    when(alarmCommentDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(buildResult);
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AlarmComment actualFindAlarmCommentByIdResult =
        baseAlarmCommentService.findAlarmCommentById(ModelConstants.SYSTEM_TENANT, alarmCommentId);

    // Assert
    verify(alarmCommentBuilder3).alarmId(isNull());
    verify(alarmCommentBuilder2).comment(isA(JsonNode.class));
    verify(alarmCommentBuilder).type(eq(AlarmCommentType.SYSTEM));
    verify(alarmCommentId, atLeast(1)).getId();
    verify(alarmCommentDao).findById(isA(TenantId.class), isA(UUID.class));
    assertNull(actualFindAlarmCommentByIdResult.getComment());
    assertNull(actualFindAlarmCommentByIdResult.getUuidId());
    assertNull(actualFindAlarmCommentByIdResult.getType());
    assertNull(actualFindAlarmCommentByIdResult.getId());
    assertNull(actualFindAlarmCommentByIdResult.getAlarmId());
    assertNull(actualFindAlarmCommentByIdResult.getUserId());
    assertEquals(0L, actualFindAlarmCommentByIdResult.getCreatedTime());
  }
}
