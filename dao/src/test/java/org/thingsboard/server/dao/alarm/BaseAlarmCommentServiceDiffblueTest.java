package org.thingsboard.server.dao.alarm;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.alarm.AlarmCommentInfo;
import org.thingsboard.server.common.data.id.AlarmCommentId;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseAlarmCommentService.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class BaseAlarmCommentServiceDiffblueTest {
  @MockBean private AlarmCommentDao alarmCommentDao;

  @Autowired private BaseAlarmCommentService baseAlarmCommentService;

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
  @DisplayName("Test findAlarmComments(TenantId, AlarmId, PageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAlarmCommentService.findAlarmComments(TenantId, AlarmId, PageLink)"
  })
  void testFindAlarmComments_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AlarmCommentInfo> emptyPageDataResult = PageData.emptyPageData();
    when(alarmCommentDao.findAlarmComments(
            Mockito.<TenantId>any(), Mockito.<AlarmId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult =
        baseAlarmCommentService.findAlarmComments(
            ModelConstants.SYSTEM_TENANT, null, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmCommentDao).findAlarmComments(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAlarmCommentsResult);
  }

  /**
   * Test {@link BaseAlarmCommentService#findAlarmCommentByIdAsync(TenantId, AlarmCommentId)}.
   *
   * <p>Method under test: {@link BaseAlarmCommentService#findAlarmCommentByIdAsync(TenantId,
   * AlarmCommentId)}
   */
  @Test
  @DisplayName("Test findAlarmCommentByIdAsync(TenantId, AlarmCommentId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAlarmCommentService.findAlarmCommentByIdAsync(TenantId, AlarmCommentId)"
  })
  void testFindAlarmCommentByIdAsync() {
    // Arrange
    SettableFuture<AlarmComment> createResult = SettableFuture.create();
    when(alarmCommentDao.findAlarmCommentByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<AlarmComment> actualFindAlarmCommentByIdAsyncResult =
        baseAlarmCommentService.findAlarmCommentByIdAsync(
            ModelConstants.SYSTEM_TENANT,
            new AlarmCommentId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(alarmCommentDao).findAlarmCommentByIdAsync(isA(TenantId.class), isA(UUID.class));
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
  @DisplayName("Test findAlarmCommentByIdAsync(TenantId, AlarmCommentId); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAlarmCommentService.findAlarmCommentByIdAsync(TenantId, AlarmCommentId)"
  })
  void testFindAlarmCommentByIdAsync_thenCallsGetId() {
    // Arrange
    SettableFuture<AlarmComment> createResult = SettableFuture.create();
    when(alarmCommentDao.findAlarmCommentByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<AlarmComment> actualFindAlarmCommentByIdAsyncResult =
        baseAlarmCommentService.findAlarmCommentByIdAsync(
            ModelConstants.SYSTEM_TENANT, alarmCommentId);

    // Assert
    verify(alarmCommentId, atLeast(1)).getId();
    verify(alarmCommentDao).findAlarmCommentByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindAlarmCommentByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAlarmCommentByIdAsyncResult);
  }
}
