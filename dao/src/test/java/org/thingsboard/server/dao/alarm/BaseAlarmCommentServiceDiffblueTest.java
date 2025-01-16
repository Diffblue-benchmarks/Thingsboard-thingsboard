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
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.alarm.AlarmComment;
import org.thingsboard.server.common.data.alarm.AlarmCommentInfo;
import org.thingsboard.server.common.data.alarm.AlarmCommentType;
import org.thingsboard.server.common.data.id.AlarmCommentId;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.edge.EdgeService;
import org.thingsboard.server.dao.entityview.EntityViewService;
import org.thingsboard.server.dao.housekeeper.CleanUpService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {BaseAlarmCommentService.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class BaseAlarmCommentServiceDiffblueTest {
  @MockBean
  private AlarmCommentDao alarmCommentDao;

  @MockBean
  private AlarmService alarmService;

  @MockBean
  private ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  private BaseAlarmCommentService baseAlarmCommentService;

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
   * Test
   * {@link BaseAlarmCommentService#findAlarmComments(TenantId, AlarmId, PageLink)}.
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmCommentService#findAlarmComments(TenantId, AlarmId, PageLink)}
   */
  @Test
  public void testFindAlarmComments_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AlarmCommentInfo> emptyPageDataResult = PageData.emptyPageData();
    when(alarmCommentDao.findAlarmComments(Mockito.<TenantId>any(), Mockito.<AlarmId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<AlarmCommentInfo> actualFindAlarmCommentsResult = baseAlarmCommentService
        .findAlarmComments(ModelConstants.SYSTEM_TENANT, null, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(alarmCommentDao).findAlarmComments(isA(TenantId.class), isNull(), isA(PageLink.class));
    assertSame(actualFindAlarmCommentsResult.EMPTY_PAGE_DATA, actualFindAlarmCommentsResult);
  }

  /**
   * Test
   * {@link BaseAlarmCommentService#findAlarmCommentByIdAsync(TenantId, AlarmCommentId)}.
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmCommentService#findAlarmCommentByIdAsync(TenantId, AlarmCommentId)}
   */
  @Test
  public void testFindAlarmCommentByIdAsync_givenNull_uuid_thenCallsGetId() {
    // Arrange
    SettableFuture<AlarmComment> createResult = SettableFuture.create();
    when(alarmCommentDao.findAlarmCommentByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
    AlarmCommentId alarmCommentId = mock(AlarmCommentId.class);
    when(alarmCommentId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    ListenableFuture<AlarmComment> actualFindAlarmCommentByIdAsyncResult = baseAlarmCommentService
        .findAlarmCommentByIdAsync(ModelConstants.SYSTEM_TENANT, alarmCommentId);

    // Assert
    verify(alarmCommentId, atLeast(1)).getId();
    verify(alarmCommentDao).findAlarmCommentByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindAlarmCommentByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAlarmCommentByIdAsyncResult);
  }

  /**
   * Test
   * {@link BaseAlarmCommentService#findAlarmCommentByIdAsync(TenantId, AlarmCommentId)}.
   * <ul>
   *   <li>When {@link AlarmCommentId#AlarmCommentId(UUID)} with id is
   * {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmCommentService#findAlarmCommentByIdAsync(TenantId, AlarmCommentId)}
   */
  @Test
  public void testFindAlarmCommentByIdAsync_whenAlarmCommentIdWithIdIsNull_uuid() {
    // Arrange
    SettableFuture<AlarmComment> createResult = SettableFuture.create();
    when(alarmCommentDao.findAlarmCommentByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<AlarmComment> actualFindAlarmCommentByIdAsyncResult = baseAlarmCommentService
        .findAlarmCommentByIdAsync(ModelConstants.SYSTEM_TENANT, new AlarmCommentId(ModelConstants.NULL_UUID));

    // Assert
    verify(alarmCommentDao).findAlarmCommentByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindAlarmCommentByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindAlarmCommentByIdAsyncResult);
  }

  /**
   * Test
   * {@link BaseAlarmCommentService#findAlarmCommentById(TenantId, AlarmCommentId)}.
   * <ul>
   *   <li>Then return Comment is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmCommentService#findAlarmCommentById(TenantId, AlarmCommentId)}
   */
  @Test
  public void testFindAlarmCommentById_thenReturnCommentIsNull() {
    // Arrange
    AlarmComment.AlarmCommentBuilder alarmCommentBuilder = mock(AlarmComment.AlarmCommentBuilder.class);
    when(alarmCommentBuilder.type(Mockito.<AlarmCommentType>any())).thenReturn(AlarmComment.builder());
    AlarmComment.AlarmCommentBuilder alarmCommentBuilder2 = mock(AlarmComment.AlarmCommentBuilder.class);
    when(alarmCommentBuilder2.comment(Mockito.<JsonNode>any())).thenReturn(alarmCommentBuilder);
    AlarmComment.AlarmCommentBuilder alarmCommentBuilder3 = mock(AlarmComment.AlarmCommentBuilder.class);
    when(alarmCommentBuilder3.alarmId(Mockito.<AlarmId>any())).thenReturn(alarmCommentBuilder2);
    AlarmComment buildResult = alarmCommentBuilder3.alarmId(null)
        .comment(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)
        .type(AlarmCommentType.SYSTEM)
        .userId(null)
        .build();
    when(alarmCommentDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(buildResult);

    // Act
    AlarmComment actualFindAlarmCommentByIdResult = baseAlarmCommentService
        .findAlarmCommentById(ModelConstants.SYSTEM_TENANT, new AlarmCommentId(ModelConstants.NULL_UUID));

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
}
