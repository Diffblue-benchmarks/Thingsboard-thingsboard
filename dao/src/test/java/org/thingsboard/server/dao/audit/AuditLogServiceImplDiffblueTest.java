package org.thingsboard.server.dao.audit;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.audit.AuditLog;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.dao.model.ModelConstants;

@RunWith(MockitoJUnitRunner.class)
public class AuditLogServiceImplDiffblueTest {
  @Mock
  private AuditLogDao auditLogDao;

  @InjectMocks
  private AuditLogServiceImpl auditLogServiceImpl;

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code ADDED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ADDED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData AuditLogServiceImpl.findAuditLogsByTenantId(TenantId, List, TimePageLink)"})
  public void testFindAuditLogsByTenantId_givenAdded_whenArrayListAddAdded() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantId(Mockito.<UUID>any(), Mockito.<List<ActionType>>any(),
        Mockito.<TimePageLink>any())).thenReturn(emptyPageDataResult);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult = auditLogServiceImpl
        .findAuditLogsByTenantId(ModelConstants.SYSTEM_TENANT, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogDao).findAuditLogsByTenantId(isA(UUID.class), isA(List.class), isA(TimePageLink.class));
    assertSame(actualFindAuditLogsByTenantIdResult.EMPTY_PAGE_DATA, actualFindAuditLogsByTenantIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}.
   * <ul>
   *   <li>Given {@code DELETED}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code DELETED}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData AuditLogServiceImpl.findAuditLogsByTenantId(TenantId, List, TimePageLink)"})
  public void testFindAuditLogsByTenantId_givenDeleted_whenArrayListAddDeleted() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantId(Mockito.<UUID>any(), Mockito.<List<ActionType>>any(),
        Mockito.<TimePageLink>any())).thenReturn(emptyPageDataResult);

    ArrayList<ActionType> actionTypes = new ArrayList<>();
    actionTypes.add(ActionType.DELETED);
    actionTypes.add(ActionType.ADDED);

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult = auditLogServiceImpl
        .findAuditLogsByTenantId(ModelConstants.SYSTEM_TENANT, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogDao).findAuditLogsByTenantId(isA(UUID.class), isA(List.class), isA(TimePageLink.class));
    assertSame(actualFindAuditLogsByTenantIdResult.EMPTY_PAGE_DATA, actualFindAuditLogsByTenantIdResult);
  }

  /**
   * Test {@link AuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AuditLogServiceImpl#findAuditLogsByTenantId(TenantId, List, TimePageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData AuditLogServiceImpl.findAuditLogsByTenantId(TenantId, List, TimePageLink)"})
  public void testFindAuditLogsByTenantId_whenSystem_tenant_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AuditLog> emptyPageDataResult = PageData.emptyPageData();
    when(auditLogDao.findAuditLogsByTenantId(Mockito.<UUID>any(), Mockito.<List<ActionType>>any(),
        Mockito.<TimePageLink>any())).thenReturn(emptyPageDataResult);
    ArrayList<ActionType> actionTypes = new ArrayList<>();

    // Act
    PageData<AuditLog> actualFindAuditLogsByTenantIdResult = auditLogServiceImpl
        .findAuditLogsByTenantId(ModelConstants.SYSTEM_TENANT, actionTypes, new TimePageLink(3));

    // Assert
    verify(auditLogDao).findAuditLogsByTenantId(isA(UUID.class), isA(List.class), isA(TimePageLink.class));
    assertSame(actualFindAuditLogsByTenantIdResult.EMPTY_PAGE_DATA, actualFindAuditLogsByTenantIdResult);
  }
}
