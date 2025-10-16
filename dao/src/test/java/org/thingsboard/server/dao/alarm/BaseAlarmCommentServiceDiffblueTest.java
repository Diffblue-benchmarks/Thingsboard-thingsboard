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
package org.thingsboard.server.dao.alarm;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
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
@RunWith(SpringJUnit4ClassRunner.class)
public class BaseAlarmCommentServiceDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData BaseAlarmCommentService.findAlarmComments(TenantId, AlarmId, PageLink)"
  })
  public void testFindAlarmComments_thenReturnEmpty_page_data() {
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
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AlarmCommentId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmCommentService#findAlarmCommentByIdAsync(TenantId,
   * AlarmCommentId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAlarmCommentService.findAlarmCommentByIdAsync(TenantId, AlarmCommentId)"
  })
  public void testFindAlarmCommentByIdAsync_givenNull_uuid_thenCallsGetId() {
    // Arrange
    SettableFuture<AlarmComment> createResult = SettableFuture.create();
    when(alarmCommentDao.findAlarmCommentByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenReturn(ModelConstants.NULL_UUID);

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

  /**
   * Test {@link BaseAlarmCommentService#findAlarmCommentByIdAsync(TenantId, AlarmCommentId)}.
   *
   * <ul>
   *   <li>When {@link AlarmCommentId#AlarmCommentId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link BaseAlarmCommentService#findAlarmCommentByIdAsync(TenantId,
   * AlarmCommentId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture BaseAlarmCommentService.findAlarmCommentByIdAsync(TenantId, AlarmCommentId)"
  })
  public void testFindAlarmCommentByIdAsync_whenAlarmCommentIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<AlarmComment> createResult = SettableFuture.create();
    when(alarmCommentDao.findAlarmCommentByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<AlarmComment> actualFindAlarmCommentByIdAsyncResult =
        baseAlarmCommentService.findAlarmCommentByIdAsync(
            ModelConstants.SYSTEM_TENANT, new AlarmCommentId(ModelConstants.NULL_UUID));

    // Assert
    verify(alarmCommentDao).findAlarmCommentByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindAlarmCommentByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAlarmCommentByIdAsyncResult);
  }
}
