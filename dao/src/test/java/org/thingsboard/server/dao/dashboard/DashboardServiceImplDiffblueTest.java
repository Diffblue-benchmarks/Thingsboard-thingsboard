package org.thingsboard.server.dao.dashboard;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.Dashboard;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.DashboardId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.edge.EdgeDao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@RunWith(MockitoJUnitRunner.class)
public class DashboardServiceImplDiffblueTest {
  @Mock private DashboardDao dashboardDao;

  @InjectMocks private DashboardServiceImpl dashboardServiceImpl;

  @Mock private EdgeDao edgeDao;

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT,
                dashboardId,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge2() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT,
                dashboardId,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(edge).getTenantId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <ul>
   *   <li>Given {@link EdgeDao} {@link EdgeDao#findById(TenantId, UUID)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge_givenEdgeDaoFindByIdReturnNull() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT,
                dashboardId,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link DashboardServiceImpl#assignDashboardToEdge(TenantId, DashboardId,
   * EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.assignDashboardToEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testAssignDashboardToEdge_thenThrowDataValidationException() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    Edge edge = mock(Edge.class);
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.assignDashboardToEdge(
                ModelConstants.SYSTEM_TENANT,
                dashboardId,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(edge).getTenantId();
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#unassignDashboardFromEdge(TenantId,
   * DashboardId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "Dashboard DashboardServiceImpl.unassignDashboardFromEdge(TenantId, DashboardId, EdgeId)"
  })
  public void testUnassignDashboardFromEdge() {
    // Arrange
    when(dashboardDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new Dashboard());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    DashboardId dashboardId = mock(DashboardId.class);
    when(dashboardId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            dashboardServiceImpl.unassignDashboardFromEdge(
                ModelConstants.SYSTEM_TENANT,
                dashboardId,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(dashboardId, atLeast(1)).getId();
    verify(dashboardDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DashboardServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link DashboardServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType DashboardServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DASHBOARD, new DashboardServiceImpl().getEntityType());
  }
}
