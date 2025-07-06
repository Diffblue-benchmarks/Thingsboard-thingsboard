package org.thingsboard.server.dao.edge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.function.Function;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeInfo;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.HasId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.SortOrder.Direction;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@RunWith(MockitoJUnitRunner.class)
public class EdgeServiceImplDiffblueTest {
  @Mock private ApplicationEventPublisher applicationEventPublisher;

  @Mock private DataValidator<Edge> dataValidator;

  @Mock private EdgeDao edgeDao;

  @InjectMocks private EdgeServiceImpl edgeServiceImpl;

  @Mock private JpaExecutorService jpaExecutorService;

  /**
   * Test {@link EdgeServiceImpl#findEdgeById(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeById(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.findEdgeById(TenantId, EdgeId)"})
  public void testFindEdgeById_givenFromString784f394c42b6435a983cB7beff2784f9_thenCallsGetId() {
    // Arrange
    Edge edge = new Edge();
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Edge actualFindEdgeByIdResult =
        edgeServiceImpl.findEdgeById(ModelConstants.SYSTEM_TENANT, edgeId);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(edge, actualFindEdgeByIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeById(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>When {@link EdgeId#EdgeId(UUID)} with id is fromString {@code
   *       784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeById(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.findEdgeById(TenantId, EdgeId)"})
  public void testFindEdgeById_whenEdgeIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    Edge edge = new Edge();
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);

    // Act
    Edge actualFindEdgeByIdResult =
        edgeServiceImpl.findEdgeById(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(edge, actualFindEdgeByIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfoById(TenantId, EdgeId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfoById(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EdgeInfo EdgeServiceImpl.findEdgeInfoById(TenantId, EdgeId)"})
  public void testFindEdgeInfoById() {
    // Arrange
    EdgeInfo edgeInfo = new EdgeInfo();
    when(edgeDao.findEdgeInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(edgeInfo);

    // Act
    EdgeInfo actualFindEdgeInfoByIdResult =
        edgeServiceImpl.findEdgeInfoById(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(edgeDao).findEdgeInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(edgeInfo, actualFindEdgeInfoByIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfoById(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfoById(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EdgeInfo EdgeServiceImpl.findEdgeInfoById(TenantId, EdgeId)"})
  public void testFindEdgeInfoById_thenCallsGetId() {
    // Arrange
    EdgeInfo edgeInfo = new EdgeInfo();
    when(edgeDao.findEdgeInfoById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(edgeInfo);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    EdgeInfo actualFindEdgeInfoByIdResult =
        edgeServiceImpl.findEdgeInfoById(ModelConstants.SYSTEM_TENANT, edgeId);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(edgeDao).findEdgeInfoById(isA(TenantId.class), isA(UUID.class));
    assertSame(edgeInfo, actualFindEdgeInfoByIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeByIdAsync(TenantId, EdgeId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByIdAsync(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture EdgeServiceImpl.findEdgeByIdAsync(TenantId, EdgeId)"})
  public void testFindEdgeByIdAsync() {
    // Arrange
    SettableFuture<Edge> createResult = SettableFuture.create();
    when(edgeDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);

    // Act
    ListenableFuture<Edge> actualFindEdgeByIdAsyncResult =
        edgeServiceImpl.findEdgeByIdAsync(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(edgeDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEdgeByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgeByIdAsyncResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeByIdAsync(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByIdAsync(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture EdgeServiceImpl.findEdgeByIdAsync(TenantId, EdgeId)"})
  public void testFindEdgeByIdAsync_thenCallsGetId() {
    // Arrange
    SettableFuture<Edge> createResult = SettableFuture.create();
    when(edgeDao.findByIdAsync(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(createResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Edge> actualFindEdgeByIdAsyncResult =
        edgeServiceImpl.findEdgeByIdAsync(ModelConstants.SYSTEM_TENANT, edgeId);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(edgeDao).findByIdAsync(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEdgeByIdAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgeByIdAsyncResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgeByTenantIdAndNameAsync(TenantId, String)"
  })
  public void testFindEdgeByTenantIdAndNameAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    // Act
    ListenableFuture<Edge> actualFindEdgeByTenantIdAndNameAsyncResult =
        edgeServiceImpl.findEdgeByTenantIdAndNameAsync(ModelConstants.SYSTEM_TENANT, "Name");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    assertTrue(actualFindEdgeByTenantIdAndNameAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgeByTenantIdAndNameAsyncResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeByRoutingKey(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return of {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByRoutingKey(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional EdgeServiceImpl.findEdgeByRoutingKey(TenantId, String)"})
  public void testFindEdgeByRoutingKey_thenReturnOfEdge() {
    // Arrange
    Optional<Edge> ofResult = Optional.of(new Edge());
    when(edgeDao.findByRoutingKey(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(ofResult);

    // Act
    Optional<Edge> actualFindEdgeByRoutingKeyResult =
        edgeServiceImpl.findEdgeByRoutingKey(ModelConstants.SYSTEM_TENANT, "Routing Key");

    // Assert
    verify(edgeDao).findByRoutingKey(isA(UUID.class), eq("Routing Key"));
    assertSame(ofResult, actualFindEdgeByRoutingKeyResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeByRoutingKey(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByRoutingKey(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional EdgeServiceImpl.findEdgeByRoutingKey(TenantId, String)"})
  public void testFindEdgeByRoutingKey_thenThrowConstraintViolationException() {
    // Arrange
    when(edgeDao.findByRoutingKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing findEdgeByRoutingKey [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeByRoutingKey(ModelConstants.SYSTEM_TENANT, "Routing Key"));
    verify(edgeDao).findByRoutingKey(isA(UUID.class), eq("Routing Key"));
  }

  /**
   * Test {@link EdgeServiceImpl#saveEdge(Edge)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#saveEdge(Edge)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.saveEdge(Edge)"})
  public void testSaveEdge() {
    // Arrange
    when(dataValidator.validate(Mockito.<Edge>any(), Mockito.<Function<Edge, TenantId>>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing saveEdge [{}]"));

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> edgeServiceImpl.saveEdge(new Edge()));
    verify(dataValidator).validate(isA(Edge.class), isA(Function.class));
  }

  /**
   * Test {@link EdgeServiceImpl#saveEdge(Edge)}.
   *
   * <ul>
   *   <li>Then calls {@link Edge#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#saveEdge(Edge)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.saveEdge(Edge)"})
  public void testSaveEdge_thenCallsGetName() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getName())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    when(dataValidator.validate(Mockito.<Edge>any(), Mockito.<Function<Edge, TenantId>>any()))
        .thenReturn(edge);

    // Act and Assert
    assertThrows(ConstraintViolationException.class, () -> edgeServiceImpl.saveEdge(new Edge()));
    verify(edge).getName();
    verify(dataValidator).validate(isA(Edge.class), isA(Function.class));
  }

  /**
   * Test {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId, CustomerId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId,
   * CustomerId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.assignEdgeToCustomer(TenantId, EdgeId, CustomerId)"})
  public void testAssignEdgeToCustomer() {
    // Arrange
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());
    doThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "[{}] Executing assignEdgeToCustomer [{}][{}]"))
        .when(applicationEventPublisher)
        .publishEvent(Mockito.<Object>any());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.assignEdgeToCustomer(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(applicationEventPublisher).publishEvent(isA(Object.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()} CustomerId is {@link CustomerId#CustomerId(UUID)} with id is
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId,
   * CustomerId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.assignEdgeToCustomer(TenantId, EdgeId, CustomerId)"})
  public void testAssignEdgeToCustomer_givenEdgeCustomerIdIsCustomerIdWithIdIsNull() {
    // Arrange
    Edge edge = new Edge();
    edge.setCustomerId(new CustomerId(null));
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    EdgeId edgeId = new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Edge actualAssignEdgeToCustomerResult =
        edgeServiceImpl.assignEdgeToCustomer(
            ModelConstants.SYSTEM_TENANT, edgeId, new CustomerId(null));

    // Assert
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(edge, actualAssignEdgeToCustomerResult);
  }

  /**
   * Test {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId, CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId,
   * CustomerId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.assignEdgeToCustomer(TenantId, EdgeId, CustomerId)"})
  public void testAssignEdgeToCustomer_thenCallsGetId() {
    // Arrange
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "[{}] Executing assignEdgeToCustomer [{}][{}]"));
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.assignEdgeToCustomer(
                ModelConstants.SYSTEM_TENANT, edgeId, BaseEntityService.NULL_CUSTOMER_ID));
    verify(edgeId, atLeast(1)).getId();
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId, CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link DataValidator#validate(BaseData, Function)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId,
   * CustomerId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.assignEdgeToCustomer(TenantId, EdgeId, CustomerId)"})
  public void testAssignEdgeToCustomer_thenCallsValidate() {
    // Arrange
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());
    when(dataValidator.validate(Mockito.<Edge>any(), Mockito.<Function<Edge, TenantId>>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "[{}] Executing assignEdgeToCustomer [{}][{}]"));
    doNothing().when(applicationEventPublisher).publishEvent(Mockito.<Object>any());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.assignEdgeToCustomer(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseEntityService.NULL_CUSTOMER_ID));
    verify(applicationEventPublisher).publishEvent(isA(Object.class));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dataValidator).validate(isA(Edge.class), isA(Function.class));
  }

  /**
   * Test {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId, CustomerId)}.
   *
   * <ul>
   *   <li>Then return CustomerId is {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId,
   * CustomerId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.assignEdgeToCustomer(TenantId, EdgeId, CustomerId)"})
  public void testAssignEdgeToCustomer_thenReturnCustomerIdIsNull_customer_id() {
    // Arrange
    Edge edge = new Edge();
    edge.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    CustomerId customerId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    Edge actualAssignEdgeToCustomerResult =
        edgeServiceImpl.assignEdgeToCustomer(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            customerId);

    // Assert
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(customerId, actualAssignEdgeToCustomerResult.getCustomerId());
  }

  /**
   * Test {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId, CustomerId)}.
   *
   * <ul>
   *   <li>Then return {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId,
   * CustomerId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.assignEdgeToCustomer(TenantId, EdgeId, CustomerId)"})
  public void testAssignEdgeToCustomer_thenReturnEdge() {
    // Arrange
    Edge edge = new Edge();
    edge.setCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    EdgeId edgeId = new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Edge actualAssignEdgeToCustomerResult =
        edgeServiceImpl.assignEdgeToCustomer(
            ModelConstants.SYSTEM_TENANT,
            edgeId,
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(edge, actualAssignEdgeToCustomerResult);
  }

  /**
   * Test {@link EdgeServiceImpl#unassignEdgeFromCustomer(TenantId, EdgeId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#unassignEdgeFromCustomer(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.unassignEdgeFromCustomer(TenantId, EdgeId)"})
  public void testUnassignEdgeFromCustomer() {
    // Arrange
    Edge edge = mock(Edge.class);
    doThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "[{}] Executing unassignEdgeFromCustomer [{}]"))
        .when(edge)
        .setCustomerId(Mockito.<CustomerId>any());
    when(edge.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.unassignEdgeFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(edge).getCustomerId();
    verify(edge).setCustomerId(isNull());
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#unassignEdgeFromCustomer(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Given {@link EdgeDao} {@link EdgeDao#findById(TenantId, UUID)} return {@link
   *       Edge#Edge()}.
   *   <li>Then return {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#unassignEdgeFromCustomer(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.unassignEdgeFromCustomer(TenantId, EdgeId)"})
  public void testUnassignEdgeFromCustomer_givenEdgeDaoFindByIdReturnEdge_thenReturnEdge() {
    // Arrange
    Edge edge = new Edge();
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);

    // Act
    Edge actualUnassignEdgeFromCustomerResult =
        edgeServiceImpl.unassignEdgeFromCustomer(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(edge, actualUnassignEdgeFromCustomerResult);
  }

  /**
   * Test {@link EdgeServiceImpl#unassignEdgeFromCustomer(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#unassignEdgeFromCustomer(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.unassignEdgeFromCustomer(TenantId, EdgeId)"})
  public void testUnassignEdgeFromCustomer_thenCallsGetId() {
    // Arrange
    Edge edge = new Edge();
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Edge actualUnassignEdgeFromCustomerResult =
        edgeServiceImpl.unassignEdgeFromCustomer(ModelConstants.SYSTEM_TENANT, edgeId);

    // Assert
    verify(edgeId, atLeast(1)).getId();
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(edge, actualUnassignEdgeFromCustomerResult);
  }

  /**
   * Test {@link EdgeServiceImpl#unassignEdgeFromCustomer(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Then calls {@link Edge#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#unassignEdgeFromCustomer(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.unassignEdgeFromCustomer(TenantId, EdgeId)"})
  public void testUnassignEdgeFromCustomer_thenCallsGetName() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getName()).thenReturn("Name");
    when(edge.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(edge).setCustomerId(Mockito.<CustomerId>any());
    when(edge.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    Edge edge2 = mock(Edge.class);
    when(edge2.getName())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "[{}] Executing unassignEdgeFromCustomer [{}]"));
    when(dataValidator.validate(Mockito.<Edge>any(), Mockito.<Function<Edge, TenantId>>any()))
        .thenReturn(edge2);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.unassignEdgeFromCustomer(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(edge).getCustomerId();
    verify(edge).getName();
    verify(edge2).getName();
    verify(edge).getTenantId();
    verify(edge).setCustomerId(isNull());
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(dataValidator).validate(isA(Edge.class), isA(Function.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdge(TenantId, EdgeId)"})
  public void testDeleteEdge() {
    // Arrange
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing deleteEdge [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.deleteEdge(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdge(TenantId, EdgeId)"})
  public void testDeleteEdge2() {
    // Arrange
    doThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing deleteEdge [{}]"))
        .when(edgeDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.deleteEdge(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Given {@link EdgeDao} {@link EdgeDao#findById(TenantId, UUID)} return {@code null}.
   *   <li>Then calls {@link EdgeDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdge(TenantId, EdgeId)"})
  public void testDeleteEdge_givenEdgeDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    edgeServiceImpl.deleteEdge(
        ModelConstants.SYSTEM_TENANT,
        new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdge(TenantId, EdgeId)"})
  public void testDeleteEdge_thenCallsGetId() {
    // Arrange
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing deleteEdge [{}]"));
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.deleteEdge(ModelConstants.SYSTEM_TENANT, edgeId));
    verify(edgeId, atLeast(1)).getId();
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Then calls {@link Edge#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdge(TenantId, EdgeId)"})
  public void testDeleteEdge_thenCallsGetTenantId() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getTenantId())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    doNothing().when(edgeDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.deleteEdge(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(edge).getTenantId();
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity() {
    // Arrange
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing deleteEdge [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                true));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity2() {
    // Arrange
    doThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing deleteEdge [{}]"))
        .when(edgeDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                true));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link EdgeDao} {@link EdgeDao#findById(TenantId, UUID)} return {@code null}.
   *   <li>Then calls {@link EdgeDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_givenEdgeDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    edgeServiceImpl.deleteEntity(
        ModelConstants.SYSTEM_TENANT,
        new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
        true);

    // Assert
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_givenFromString784f394c42b6435a983cB7beff2784f9_thenCallsGetId() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getTenantId())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    doNothing().when(edgeDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    EdgeId id = mock(EdgeId.class);
    when(id.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true));
    verify(edge).getTenantId();
    verify(id, atLeast(1)).getId();
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link Edge#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_thenCallsGetTenantId() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getTenantId())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    doNothing().when(edgeDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT,
                new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                true));
    verify(edge).getTenantId();
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  public void testFindEdgesByTenantId() {
    // Arrange
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantId, tenantId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  public void testFindEdgesByTenantId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantId, tenantId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  public void testFindEdgesByTenantId3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantId, tenantId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  public void testFindEdgesByTenantId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult =
        edgeServiceImpl.findEdgesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindEdgesByTenantIdResult.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  public void testFindEdgesByTenantId_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult =
        edgeServiceImpl.findEdgesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindEdgesByTenantIdResult.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  public void testFindEdgesByTenantId_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult =
        edgeServiceImpl.findEdgesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindEdgesByTenantIdResult.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  public void testFindEdgesByTenantId_thenCallsGetProperty() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  public void testFindEdgesByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult =
        edgeServiceImpl.findEdgesByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(actualFindEdgesByTenantIdResult.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndType() {
    // Arrange
    when(edgeDao.findEdgesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeDao).findEdgesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndType2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndType_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndType_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndType_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndType_thenCallsGetProperty() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndType_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao).findEdgesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndType() {
    // Arrange
    when(edgeDao.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgeInfosByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndType2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgeInfosByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndType_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgeInfosByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndType_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgeInfosByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndType_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgeInfosByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndType_thenCallsGetProperty() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndType(
                ModelConstants.SYSTEM_TENANT, "Type", pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndType_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgeInfosByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  public void testFindEdgeInfosByTenantId() {
    // Arrange
    when(edgeDao.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgeInfosByTenantId, tenantId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantId(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeDao).findEdgeInfosByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  public void testFindEdgeInfosByTenantId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgeInfosByTenantId, tenantId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  public void testFindEdgeInfosByTenantId3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgeInfosByTenantId, tenantId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  public void testFindEdgeInfosByTenantId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        edgeServiceImpl.findEdgeInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgeInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdResult.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  public void testFindEdgeInfosByTenantId_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        edgeServiceImpl.findEdgeInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgeInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdResult.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  public void testFindEdgeInfosByTenantId_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        edgeServiceImpl.findEdgeInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgeInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdResult.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  public void testFindEdgeInfosByTenantId_thenCallsGetProperty() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  public void testFindEdgeInfosByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        edgeServiceImpl.findEdgeInfosByTenantId(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao).findEdgeInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdResult.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdAndIdsAsync(TenantId, List)"
  })
  public void testFindEdgesByTenantIdAndIdsAsync_thenCallsGetId() {
    // Arrange
    SettableFuture<List<Edge>> createResult = SettableFuture.create();
    when(edgeDao.findEdgesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(edgeId);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdAndIdsAsyncResult =
        edgeServiceImpl.findEdgesByTenantIdAndIdsAsync(ModelConstants.SYSTEM_TENANT, edgeIds);

    // Assert
    verify(edgeId).getId();
    verify(edgeDao).findEdgesByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
    assertTrue(actualFindEdgesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdAndIdsAsync(TenantId, List)"
  })
  public void testFindEdgesByTenantIdAndIdsAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<Edge>> createResult = SettableFuture.create();
    when(edgeDao.findEdgesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdAndIdsAsyncResult =
        edgeServiceImpl.findEdgesByTenantIdAndIdsAsync(ModelConstants.SYSTEM_TENANT, edgeIds);

    // Assert
    verify(edgeDao).findEdgesByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
    assertTrue(actualFindEdgesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdAndIdsAsync(TenantId, List)"
  })
  public void testFindEdgesByTenantIdAndIdsAsync_thenThrowConstraintViolationException() {
    // Arrange
    when(edgeDao.findEdgesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantIdAndIdsAsync, tenantId [{}], edgeIds [{}]"));

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndIdsAsync(ModelConstants.SYSTEM_TENANT, edgeIds));
    verify(edgeDao).findEdgesByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEdgesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link EdgeDao} {@link EdgeDao#findEdgesByTenantId(UUID, PageLink)} return
   *       emptyPageData.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEdgesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdgesByTenantId(TenantId)"})
  public void testDeleteEdgesByTenantId_givenEdgeDaoFindEdgesByTenantIdReturnEmptyPageData() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    edgeServiceImpl.deleteEdgesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEdgesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link PageData#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEdgesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdgesByTenantId(TenantId)"})
  public void testDeleteEdgesByTenantId_givenPageDataHasNextReturnFalse_thenCallsGetData() {
    // Arrange
    PageData<Edge> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    edgeServiceImpl.deleteEdgesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeDao#findEdgesByTenantId(UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsFindEdgesByTenantId() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    edgeServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerId() {
    // Arrange
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerId_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerId_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerId_thenCallsGetProperty() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType() {
    // Arrange
    when(edgeDao.findEdgesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                    + " pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                    + " pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType3() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType4() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                    + " pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType5() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType_thenCallsGetProperty() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgesByTenantIdAndCustomerIdAndType_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId() {
    // Arrange
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgeInfosByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgeInfosByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId3() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindEdgeInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindEdgeInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindEdgeInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId_thenCallsGetProperty() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerId_whenFirst_page() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdAndCustomerIdResult.EMPTY_PAGE_DATA,
        actualFindEdgeInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType() {
    // Arrange
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgeInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                    + " pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgeInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                    + " pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType3() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType4() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgeInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                    + " pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link
   * EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType5() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenCallsGetProperty() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                "Type",
                pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  public void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            "Type",
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(
        actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult.EMPTY_PAGE_DATA,
        actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId,
   * CustomerId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  public void testFindEdgesByTenantIdCustomerIdAndIdsAsync() {
    // Arrange
    when(edgeDao.findEdgesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantIdCustomerIdAndIdsAsync, tenantId [{}], customerId [{}], edgeIds [{}]"));

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, edgeIds));
    verify(edgeDao)
        .findEdgesByTenantIdCustomerIdAndIdsAsync(
            isA(UUID.class), isA(UUID.class), isA(List.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId,
   * CustomerId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  public void testFindEdgesByTenantIdCustomerIdAndIdsAsync_thenCallsGetId() {
    // Arrange
    SettableFuture<List<Edge>> createResult = SettableFuture.create();
    when(edgeDao.findEdgesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(edgeId);

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult =
        edgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, edgeIds);

    // Assert
    verify(edgeId).getId();
    verify(edgeDao)
        .findEdgesByTenantIdCustomerIdAndIdsAsync(
            isA(UUID.class), isA(UUID.class), isA(List.class));
    assertTrue(actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <ul>
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId,
   * CustomerId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  public void testFindEdgesByTenantIdCustomerIdAndIdsAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<Edge>> createResult = SettableFuture.create();
    when(edgeDao.findEdgesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult =
        edgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, edgeIds);

    // Assert
    verify(edgeDao)
        .findEdgesByTenantIdCustomerIdAndIdsAsync(
            isA(UUID.class), isA(UUID.class), isA(List.class));
    assertTrue(actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult);
  }

  /**
   * Test {@link EdgeServiceImpl#unassignCustomerEdges(TenantId, CustomerId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#unassignCustomerEdges(TenantId, CustomerId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.unassignCustomerEdges(TenantId, CustomerId)"})
  public void testUnassignCustomerEdges() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    edgeServiceImpl.unassignCustomerEdges(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#unassignCustomerEdges(TenantId, CustomerId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#unassignCustomerEdges(TenantId, CustomerId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.unassignCustomerEdges(TenantId, CustomerId)"})
  public void testUnassignCustomerEdges2() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<Edge> edgeList = new ArrayList<>();
    edgeList.add(edge);
    PageData<Edge> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(edgeList);
    Edge edge2 = mock(Edge.class);
    doThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing unassignCustomerEdges, tenantId [{}], customerId [{}]"))
        .when(edge2)
        .setCustomerId(Mockito.<CustomerId>any());
    when(edge2.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge2);
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.unassignCustomerEdges(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(edge2).getCustomerId();
    verify(edge2).setCustomerId(isNull());
    verify(edge).getUuidId();
    verify(pageData).getData();
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#unassignCustomerEdges(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link PageData#hasNext()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#unassignCustomerEdges(TenantId, CustomerId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.unassignCustomerEdges(TenantId, CustomerId)"})
  public void testUnassignCustomerEdges_givenPageDataHasNextReturnFalse_thenCallsHasNext() {
    // Arrange
    PageData<Edge> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    edgeServiceImpl.unassignCustomerEdges(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#unassignCustomerEdges(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link PageData#hasNext()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#unassignCustomerEdges(TenantId, CustomerId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.unassignCustomerEdges(TenantId, CustomerId)"})
  public void testUnassignCustomerEdges_givenPageDataHasNextReturnFalse_thenCallsHasNext2() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<Edge> edgeList = new ArrayList<>();
    edgeList.add(edge);
    PageData<Edge> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(edgeList);
    Edge edge2 = mock(Edge.class);
    when(edge2.getCustomerId()).thenReturn(null);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge2);
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    edgeServiceImpl.unassignCustomerEdges(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(edge2).getCustomerId();
    verify(edge).getUuidId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#unassignCustomerEdges(TenantId, CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link Edge#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#unassignCustomerEdges(TenantId, CustomerId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeServiceImpl.unassignCustomerEdges(TenantId, CustomerId)"})
  public void testUnassignCustomerEdges_thenCallsGetName() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getUuidId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<Edge> edgeList = new ArrayList<>();
    edgeList.add(edge);
    PageData<Edge> pageData = mock(PageData.class);
    when(pageData.getData()).thenReturn(edgeList);
    Edge edge2 = mock(Edge.class);
    when(edge2.getName()).thenReturn("Name");
    when(edge2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    doNothing().when(edge2).setCustomerId(Mockito.<CustomerId>any());
    when(edge2.getCustomerId()).thenReturn(BaseEntityService.NULL_CUSTOMER_ID);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge2);
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);
    Edge edge3 = mock(Edge.class);
    when(edge3.getName())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing unassignCustomerEdges, tenantId [{}], customerId [{}]"));
    when(dataValidator.validate(Mockito.<Edge>any(), Mockito.<Function<Edge, TenantId>>any()))
        .thenReturn(edge3);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.unassignCustomerEdges(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(edge2).getCustomerId();
    verify(edge2).getName();
    verify(edge3).getName();
    verify(edge2).getTenantId();
    verify(edge2).setCustomerId(isNull());
    verify(edge).getUuidId();
    verify(pageData).getData();
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    verify(dataValidator).validate(isA(Edge.class), isA(Function.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeDao#findTenantEdgeTypesAsync(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture EdgeServiceImpl.findEdgeTypesByTenantId(TenantId)"})
  public void testFindEdgeTypesByTenantId_thenCallsFindTenantEdgeTypesAsync() {
    // Arrange
    SettableFuture<List<EntitySubtype>> createResult = SettableFuture.create();
    when(edgeDao.findTenantEdgeTypesAsync(Mockito.<UUID>any())).thenReturn(createResult);

    // Act
    edgeServiceImpl.findEdgeTypesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(edgeDao).findTenantEdgeTypesAsync(isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ListenableFuture EdgeServiceImpl.findEdgeTypesByTenantId(TenantId)"})
  public void testFindEdgeTypesByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    when(edgeDao.findTenantEdgeTypesAsync(Mockito.<UUID>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgeTypesByTenantId, tenantId [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeTypesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(edgeDao).findTenantEdgeTypesAsync(isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndEntityId() {
    // Arrange
    when(edgeDao.findEdgesByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<PageLink>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndEntityId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeDao)
        .findEdgesByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.CUSTOMER), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndEntityId2() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, entityId, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndEntityId_thenCallsGetEntityType() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult =
        edgeServiceImpl.findEdgesByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT, entityId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(edgeDao)
        .findEdgesByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndEntityId_thenCallsGetPage() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, entityId, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndEntityId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult =
        edgeServiceImpl.findEdgesByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao)
        .findEdgesByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.CUSTOMER), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgesByTenantIdAndEntityId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult =
        edgeServiceImpl.findEdgesByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT,
            ModelConstants.SYSTEM_TENANT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao)
        .findEdgesByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgeIdsByTenantIdAndEntityId() {
    // Arrange
    when(edgeDao.findEdgeIdsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<PageLink>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgeIdsByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeDao)
        .findEdgeIdsByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.CUSTOMER), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgeIdsByTenantIdAndEntityId2() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgeIdsByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, entityId, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgeIdsByTenantIdAndEntityId_thenCallsGetEntityType() {
    // Arrange
    PageData<EdgeId> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeIdsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    // Act
    PageData<EdgeId> actualFindEdgeIdsByTenantIdAndEntityIdResult =
        edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT, entityId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(edgeDao)
        .findEdgeIdsByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(
        actualFindEdgeIdsByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA,
        actualFindEdgeIdsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageLink#getPage()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgeIdsByTenantIdAndEntityId_thenCallsGetPage() {
    // Arrange
    AlarmId entityId = mock(AlarmId.class);
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(
                ModelConstants.SYSTEM_TENANT, entityId, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgeIdsByTenantIdAndEntityId_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EdgeId> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeIdsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeId> actualFindEdgeIdsByTenantIdAndEntityIdResult =
        edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao)
        .findEdgeIdsByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.CUSTOMER), isA(PageLink.class));
    assertSame(
        actualFindEdgeIdsByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA,
        actualFindEdgeIdsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindEdgeIdsByTenantIdAndEntityId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<EdgeId> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeIdsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeId> actualFindEdgeIdsByTenantIdAndEntityIdResult =
        edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT,
            ModelConstants.SYSTEM_TENANT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao)
        .findEdgeIdsByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(
        actualFindEdgeIdsByTenantIdAndEntityIdResult.EMPTY_PAGE_DATA,
        actualFindEdgeIdsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  public void testFindEdgesByTenantProfileId() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantProfileId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<Edge> actualFindEdgesByTenantProfileIdResult =
        edgeServiceImpl.findEdgesByTenantProfileId(
            new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao).findEdgesByTenantProfileId(isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantProfileIdResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantProfileIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  public void testFindEdgesByTenantProfileId2() {
    // Arrange
    when(edgeDao.findEdgesByTenantProfileId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantProfileId, tenantProfileId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantProfileId(
                new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeDao).findEdgesByTenantProfileId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  public void testFindEdgesByTenantProfileId3() {
    // Arrange
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantProfileId, tenantProfileId [{}], pageLink [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantProfileId(tenantProfileId, pageLink));
    verify(tenantProfileId).getId();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  public void testFindEdgesByTenantProfileId4() {
    // Arrange
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing findEdgesByTenantProfileId, tenantProfileId [{}], pageLink [{}]"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantProfileId(tenantProfileId, pageLink));
    verify(tenantProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  public void testFindEdgesByTenantProfileId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantProfileId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantProfileIdResult =
        edgeServiceImpl.findEdgesByTenantProfileId(tenantProfileId, pageLink);

    // Assert
    verify(tenantProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgesByTenantProfileId(isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantProfileIdResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantProfileIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  public void testFindEdgesByTenantProfileId_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantProfileId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantProfileIdResult =
        edgeServiceImpl.findEdgesByTenantProfileId(tenantProfileId, pageLink);

    // Assert
    verify(tenantProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgesByTenantProfileId(isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantProfileIdResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantProfileIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  public void testFindEdgesByTenantProfileId_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantProfileId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantProfileIdResult =
        edgeServiceImpl.findEdgesByTenantProfileId(tenantProfileId, pageLink);

    // Assert
    verify(tenantProfileId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgesByTenantProfileId(isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantProfileIdResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantProfileIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  public void testFindEdgesByTenantProfileId_thenCallsGetProperty() {
    // Arrange
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantProfileId(tenantProfileId, pageLink));
    verify(tenantProfileId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  public void testFindEdgesByTenantProfileId_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantProfileId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    PageData<Edge> actualFindEdgesByTenantProfileIdResult =
        edgeServiceImpl.findEdgesByTenantProfileId(
            tenantProfileId, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(tenantProfileId, atLeast(1)).getId();
    verify(edgeDao).findEdgesByTenantProfileId(isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindEdgesByTenantProfileIdResult.EMPTY_PAGE_DATA,
        actualFindEdgesByTenantProfileIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findAllRelatedEdgeIds(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findAllRelatedEdgeIds(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List EdgeServiceImpl.findAllRelatedEdgeIds(TenantId, EntityId)"})
  public void testFindAllRelatedEdgeIds() {
    // Arrange, Act and Assert
    assertNull(
        edgeServiceImpl.findAllRelatedEdgeIds(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeId> actualFindRelatedEdgeIdsByEntityIdResult =
        edgeServiceImpl.findRelatedEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertEquals(
        actualFindRelatedEdgeIdsByEntityIdResult.EMPTY_PAGE_DATA,
        actualFindRelatedEdgeIdsByEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId2() {
    // Arrange
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findRelatedEdgeIdsByEntityId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId3() {
    // Arrange
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(null);

    // Act
    PageData<EdgeId> actualFindRelatedEdgeIdsByEntityIdResult =
        edgeServiceImpl.findRelatedEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(
        actualFindRelatedEdgeIdsByEntityIdResult.EMPTY_PAGE_DATA,
        actualFindRelatedEdgeIdsByEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId4() {
    // Arrange
    PageData<Edge> pageData = new PageData<>(new ArrayList<>(), 3, 3L, true);

    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    PageData<EdgeId> actualFindRelatedEdgeIdsByEntityIdResult =
        edgeServiceImpl.findRelatedEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertEquals(pageData, actualFindRelatedEdgeIdsByEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId5() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<EdgeId> actualFindRelatedEdgeIdsByEntityIdResult =
        edgeServiceImpl.findRelatedEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT,
            ModelConstants.SYSTEM_TENANT,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertEquals(
        actualFindRelatedEdgeIdsByEntityIdResult.EMPTY_PAGE_DATA,
        actualFindRelatedEdgeIdsByEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId6() {
    // Arrange
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findRelatedEdgeIdsByEntityId(
                ModelConstants.SYSTEM_TENANT,
                ModelConstants.SYSTEM_TENANT,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId7() {
    // Arrange and Act
    PageData<EdgeId> actualFindRelatedEdgeIdsByEntityIdResult =
        edgeServiceImpl.findRelatedEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT,
            new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    assertSame(
        actualFindRelatedEdgeIdsByEntityIdResult.EMPTY_PAGE_DATA,
        actualFindRelatedEdgeIdsByEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId8() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findRelatedEdgeIdsByEntityId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeDao} {@link EdgeDao#findEdgesByTenantId(UUID, PageLink)} return {@link
   *       PageData}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId_givenEdgeDaoFindEdgesByTenantIdReturnPageData() {
    // Arrange
    PageData<Edge> pageData = mock(PageData.class);
    when(pageData.getData())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]"));
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findRelatedEdgeIdsByEntityId(
                ModelConstants.SYSTEM_TENANT,
                ModelConstants.SYSTEM_TENANT,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(pageData).getData();
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link EdgeServiceImpl} (default constructor).
   *   <li>Then return Data size is one.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId_givenEdgeServiceImpl_thenReturnDataSizeIsOne() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    AlarmId entityId = mock(AlarmId.class);
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    when(entityId.getId()).thenReturn(fromStringResult);
    when(entityId.getEntityType()).thenReturn(EntityType.EDGE);

    // Act
    PageData<EdgeId> actualFindRelatedEdgeIdsByEntityIdResult =
        edgeServiceImpl.findRelatedEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT, entityId, mock(PageLink.class));

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    List<EdgeId> data = actualFindRelatedEdgeIdsByEntityIdResult.getData();
    assertEquals(1, data.size());
    EdgeId getResult = data.get(0);
    UUID id = getResult.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(1, actualFindRelatedEdgeIdsByEntityIdResult.getTotalPages());
    assertEquals(1L, actualFindRelatedEdgeIdsByEntityIdResult.getTotalElements());
    assertEquals(EntityType.EDGE, getResult.getEntityType());
    assertFalse(getResult.isNullUid());
    assertSame(fromStringResult, id);
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link PageLink} {@link PageLink#getSortOrder()} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId_givenNull_whenPageLinkGetSortOrderReturnNull() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(null);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeId> actualFindRelatedEdgeIdsByEntityIdResult =
        edgeServiceImpl.findRelatedEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink).getSortOrder();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertEquals(
        actualFindRelatedEdgeIdsByEntityIdResult.EMPTY_PAGE_DATA,
        actualFindRelatedEdgeIdsByEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeId> actualFindRelatedEdgeIdsByEntityIdResult =
        edgeServiceImpl.findRelatedEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertEquals(
        actualFindRelatedEdgeIdsByEntityIdResult.EMPTY_PAGE_DATA,
        actualFindRelatedEdgeIdsByEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageData#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId_thenCallsGetData() {
    // Arrange
    PageData<Edge> pageData = mock(PageData.class);
    when(pageData.getData())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]"));
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findRelatedEdgeIdsByEntityId(
                ModelConstants.SYSTEM_TENANT,
                BaseEntityService.NULL_CUSTOMER_ID,
                BaseRelatedEdgesService.FIRST_PAGE));
    verify(pageData).getData();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId_thenCallsGetProperty() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "[{}] Executing findRelatedEdgeIdsByEntityId [{}] [{}]"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findRelatedEdgeIdsByEntityId(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link PageData#getTotalElements()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId_thenCallsGetTotalElements() {
    // Arrange
    PageData<Edge> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(true);
    when(pageData.getTotalPages()).thenReturn(1);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(pageData.getTotalElements()).thenReturn(1L);
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    PageData<EdgeId> actualFindRelatedEdgeIdsByEntityIdResult =
        edgeServiceImpl.findRelatedEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(pageData, atLeast(1)).getData();
    verify(pageData).getTotalElements();
    verify(pageData).getTotalPages();
    verify(pageData).hasNext();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertEquals(1, actualFindRelatedEdgeIdsByEntityIdResult.getTotalPages());
    assertEquals(1L, actualFindRelatedEdgeIdsByEntityIdResult.getTotalElements());
    assertTrue(actualFindRelatedEdgeIdsByEntityIdResult.getData().isEmpty());
    assertTrue(actualFindRelatedEdgeIdsByEntityIdResult.hasNext());
  }

  /**
   * Test {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then return TotalPages is three.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findRelatedEdgeIdsByEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findRelatedEdgeIdsByEntityId(TenantId, EntityId, PageLink)"
  })
  public void testFindRelatedEdgeIdsByEntityId_thenReturnTotalPagesIsThree() {
    // Arrange
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(new PageData<>(null, 3, 3L, true));

    // Act
    PageData<EdgeId> actualFindRelatedEdgeIdsByEntityIdResult =
        edgeServiceImpl.findRelatedEdgeIdsByEntityId(
            ModelConstants.SYSTEM_TENANT,
            BaseEntityService.NULL_CUSTOMER_ID,
            BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertEquals(3, actualFindRelatedEdgeIdsByEntityIdResult.getTotalPages());
    assertEquals(3L, actualFindRelatedEdgeIdsByEntityIdResult.getTotalElements());
    assertTrue(actualFindRelatedEdgeIdsByEntityIdResult.getData().isEmpty());
    assertTrue(actualFindRelatedEdgeIdsByEntityIdResult.hasNext());
  }

  /**
   * Test {@link EdgeServiceImpl#setEdgeRootRuleChain(TenantId, Edge, RuleChainId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#setEdgeRootRuleChain(TenantId, Edge, RuleChainId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.setEdgeRootRuleChain(TenantId, Edge, RuleChainId)"})
  public void testSetEdgeRootRuleChain() {
    // Arrange
    when(dataValidator.validate(Mockito.<Edge>any(), Mockito.<Function<Edge, TenantId>>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing saveEdge [{}]"));
    Edge edge = new Edge();

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.setEdgeRootRuleChain(
                ModelConstants.SYSTEM_TENANT,
                edge,
                new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(dataValidator).validate(isA(Edge.class), isA(Function.class));
  }

  /**
   * Test {@link EdgeServiceImpl#setEdgeRootRuleChain(TenantId, Edge, RuleChainId)}.
   *
   * <ul>
   *   <li>Then calls {@link Edge#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#setEdgeRootRuleChain(TenantId, Edge, RuleChainId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Edge EdgeServiceImpl.setEdgeRootRuleChain(TenantId, Edge, RuleChainId)"})
  public void testSetEdgeRootRuleChain_thenCallsGetName() {
    // Arrange
    Edge edge = mock(Edge.class);
    when(edge.getName())
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Constraint Name"));
    when(dataValidator.validate(Mockito.<Edge>any(), Mockito.<Function<Edge, TenantId>>any()))
        .thenReturn(edge);
    Edge edge2 = new Edge();

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.setEdgeRootRuleChain(
                ModelConstants.SYSTEM_TENANT,
                edge2,
                new RuleChainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(edge).getName();
    verify(dataValidator).validate(isA(Edge.class), isA(Function.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   *   <li>Then calls {@link EntityId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional EdgeServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_givenFromString784f394c42b6435a983cB7beff2784f9_thenCallsGetId() {
    // Arrange
    Edge edge = new Edge();
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);
    EntityId entityId = mock(EntityId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        edgeServiceImpl.findEntity(ModelConstants.SYSTEM_TENANT, entityId);

    // Assert
    verify(entityId).getId();
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(edge, actualFindEntityResult.get());
  }

  /**
   * Test {@link EdgeServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional EdgeServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_thenThrowConstraintViolationException() {
    // Arrange
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing findEdgeById [{}]"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEntity(TenantId, EntityId)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return Present.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEntity(TenantId, EntityId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Optional EdgeServiceImpl.findEntity(TenantId, EntityId)"})
  public void testFindEntity_whenNull_customer_id_thenReturnPresent() {
    // Arrange
    Edge edge = new Edge();
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);

    // Act
    Optional<HasId<?>> actualFindEntityResult =
        edgeServiceImpl.findEntity(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertTrue(actualFindEntityResult.isPresent());
    assertSame(edge, actualFindEntityResult.get());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeServiceImpl#getEntityType()}
   *   <li>{@link EdgeServiceImpl#isEdgesEnabled()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "EntityType EdgeServiceImpl.getEntityType()",
    "boolean EdgeServiceImpl.isEdgesEnabled()"
  })
  public void testGettersAndSetters() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    // Act
    EntityType actualEntityType = edgeServiceImpl.getEntityType();

    // Assert
    assertEquals(EntityType.EDGE, actualEntityType);
    assertFalse(edgeServiceImpl.isEdgesEnabled());
  }
}
