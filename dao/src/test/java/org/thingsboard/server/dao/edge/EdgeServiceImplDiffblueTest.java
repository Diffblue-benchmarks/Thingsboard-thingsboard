package org.thingsboard.server.dao.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.edge.EdgeInfo;
import org.thingsboard.server.common.data.edge.EdgeSearchQuery;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.relation.RelationService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ExtendWith(MockitoExtension.class)
class EdgeServiceImplDiffblueTest {
  @Mock private ApplicationEventPublisher applicationEventPublisher;

  @Mock private EdgeDao edgeDao;

  @InjectMocks private EdgeServiceImpl edgeServiceImpl;

  @Mock private JpaExecutorService jpaExecutorService;

  @Mock private RelationService relationService;

  @Mock private RuleChainService ruleChainService;

  /**
   * Test {@link EdgeServiceImpl#findEdgeById(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Given {@link EdgeServiceImpl} (default constructor).
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeById(TenantId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test findEdgeById(TenantId, EdgeId); given EdgeServiceImpl (default constructor); then throw ConstraintViolationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeServiceImpl.findEdgeById(TenantId, EdgeId)"})
  void testFindEdgeById_givenEdgeServiceImpl_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findEdgeById [{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeById(ModelConstants.SYSTEM_TENANT, edgeId));
    verify(edgeId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeById(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeById(TenantId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test findEdgeById(TenantId, EdgeId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeServiceImpl.findEdgeById(TenantId, EdgeId)"})
  void testFindEdgeById_givenFromString784f394c42b6435a983cB7beff2784f9() {
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
  @DisplayName(
      "Test findEdgeById(TenantId, EdgeId); when EdgeId(UUID) with id is fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeServiceImpl.findEdgeById(TenantId, EdgeId)"})
  void testFindEdgeById_whenEdgeIdWithIdIsFromString784f394c42b6435a983cB7beff2784f9() {
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
  @DisplayName("Test findEdgeInfoById(TenantId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeServiceImpl.findEdgeInfoById(TenantId, EdgeId)"})
  void testFindEdgeInfoById() {
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
   *   <li>Given {@link EdgeServiceImpl} (default constructor).
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfoById(TenantId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test findEdgeInfoById(TenantId, EdgeId); given EdgeServiceImpl (default constructor); then throw ConstraintViolationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeServiceImpl.findEdgeInfoById(TenantId, EdgeId)"})
  void testFindEdgeInfoById_givenEdgeServiceImpl_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findEdgeInfoById [{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfoById(ModelConstants.SYSTEM_TENANT, edgeId));
    verify(edgeId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfoById(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfoById(TenantId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test findEdgeInfoById(TenantId, EdgeId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EdgeInfo EdgeServiceImpl.findEdgeInfoById(TenantId, EdgeId)"})
  void testFindEdgeInfoById_givenFromString784f394c42b6435a983cB7beff2784f9() {
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
  @DisplayName("Test findEdgeByIdAsync(TenantId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EdgeServiceImpl.findEdgeByIdAsync(TenantId, EdgeId)"})
  void testFindEdgeByIdAsync() {
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
   *   <li>Given {@link EdgeServiceImpl} (default constructor).
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByIdAsync(TenantId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test findEdgeByIdAsync(TenantId, EdgeId); given EdgeServiceImpl (default constructor); then throw ConstraintViolationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EdgeServiceImpl.findEdgeByIdAsync(TenantId, EdgeId)"})
  void testFindEdgeByIdAsync_givenEdgeServiceImpl_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findEdgeByIdAsync [{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeByIdAsync(ModelConstants.SYSTEM_TENANT, edgeId));
    verify(edgeId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeByIdAsync(TenantId, EdgeId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByIdAsync(TenantId, EdgeId)}
   */
  @Test
  @DisplayName(
      "Test findEdgeByIdAsync(TenantId, EdgeId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EdgeServiceImpl.findEdgeByIdAsync(TenantId, EdgeId)"})
  void testFindEdgeByIdAsync_givenFromString784f394c42b6435a983cB7beff2784f9() {
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
   * Test {@link EdgeServiceImpl#findEdgeByTenantIdAndName(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByTenantIdAndName(TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test findEdgeByTenantIdAndName(TenantId, String); then throw ConstraintViolationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeServiceImpl.findEdgeByTenantIdAndName(TenantId, String)"})
  void testFindEdgeByTenantIdAndName_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeByTenantIdAndName [{}][{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeByTenantIdAndName(tenantId, "Name"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  @DisplayName("Test findEdgeByTenantIdAndNameAsync(TenantId, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgeByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindEdgeByTenantIdAndNameAsync() {
    // Arrange
    SettableFuture<Object> createResult = SettableFuture.create();
    when(jpaExecutorService.submit(Mockito.<Callable<Object>>any())).thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    ListenableFuture<Edge> actualFindEdgeByTenantIdAndNameAsyncResult =
        edgeServiceImpl.findEdgeByTenantIdAndNameAsync(tenantId, "Name");

    // Assert
    verify(jpaExecutorService).submit(isA(Callable.class));
    verify(tenantId).getId();
    assertTrue(actualFindEdgeByTenantIdAndNameAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgeByTenantIdAndNameAsyncResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test findEdgeByTenantIdAndNameAsync(TenantId, String); then throw ConstraintViolationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgeByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindEdgeByTenantIdAndNameAsync_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeByTenantIdAndNameAsync [{}][{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeByTenantIdAndNameAsync(tenantId, "Name"));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeByTenantIdAndNameAsync(TenantId, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link SettableFuture}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByTenantIdAndNameAsync(TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test findEdgeByTenantIdAndNameAsync(TenantId, String); when SYSTEM_TENANT; then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgeByTenantIdAndNameAsync(TenantId, String)"
  })
  void testFindEdgeByTenantIdAndNameAsync_whenSystem_tenant_thenReturnSettableFuture() {
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
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeByRoutingKey(TenantId, String)}
   */
  @Test
  @DisplayName("Test findEdgeByRoutingKey(TenantId, String); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional EdgeServiceImpl.findEdgeByRoutingKey(TenantId, String)"})
  void testFindEdgeByRoutingKey_thenCallsGetId() {
    // Arrange
    Optional<Edge> ofResult = Optional.of(new Edge());
    when(edgeDao.findByRoutingKey(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(ofResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    Optional<Edge> actualFindEdgeByRoutingKeyResult =
        edgeServiceImpl.findEdgeByRoutingKey(tenantId, "Routing Key");

    // Assert
    verify(tenantId).getId();
    verify(edgeDao).findByRoutingKey(isA(UUID.class), eq("Routing Key"));
    assertSame(ofResult, actualFindEdgeByRoutingKeyResult);
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
  @DisplayName("Test findEdgeByRoutingKey(TenantId, String); then return of Edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional EdgeServiceImpl.findEdgeByRoutingKey(TenantId, String)"})
  void testFindEdgeByRoutingKey_thenReturnOfEdge() {
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
  @DisplayName(
      "Test findEdgeByRoutingKey(TenantId, String); then throw ConstraintViolationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional EdgeServiceImpl.findEdgeByRoutingKey(TenantId, String)"})
  void testFindEdgeByRoutingKey_thenThrowConstraintViolationException() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing findEdgeByRoutingKey [{}]");
    when(edgeDao.findByRoutingKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeByRoutingKey(ModelConstants.SYSTEM_TENANT, "Routing Key"));
    verify(edgeDao).findByRoutingKey(isA(UUID.class), eq("Routing Key"));
  }

  /**
   * Test {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link Edge#Edge()} CustomerId is {@link BaseEntityService#NULL_CUSTOMER_ID}.
   *   <li>Then return {@link Edge#Edge()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId,
   * CustomerId)}
   */
  @Test
  @DisplayName(
      "Test assignEdgeToCustomer(TenantId, EdgeId, CustomerId); given Edge() CustomerId is NULL_CUSTOMER_ID; then return Edge()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeServiceImpl.assignEdgeToCustomer(TenantId, EdgeId, CustomerId)"})
  void testAssignEdgeToCustomer_givenEdgeCustomerIdIsNull_customer_id_thenReturnEdge() {
    // Arrange
    Edge edge = new Edge();
    edge.setCustomerId(BaseEntityService.NULL_CUSTOMER_ID);
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(edge);

    // Act
    Edge actualAssignEdgeToCustomerResult =
        edgeServiceImpl.assignEdgeToCustomer(
            ModelConstants.SYSTEM_TENANT,
            new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            BaseEntityService.NULL_CUSTOMER_ID);

    // Assert
    verify(edgeDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(edge, actualAssignEdgeToCustomerResult);
  }

  /**
   * Test {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId, CustomerId)}.
   *
   * <ul>
   *   <li>Given {@link EdgeServiceImpl} (default constructor).
   *   <li>Then calls {@link EdgeId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId,
   * CustomerId)}
   */
  @Test
  @DisplayName(
      "Test assignEdgeToCustomer(TenantId, EdgeId, CustomerId); given EdgeServiceImpl (default constructor); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeServiceImpl.assignEdgeToCustomer(TenantId, EdgeId, CustomerId)"})
  void testAssignEdgeToCustomer_givenEdgeServiceImpl_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "[{}] Executing assignEdgeToCustomer [{}][{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.assignEdgeToCustomer(
                ModelConstants.SYSTEM_TENANT, edgeId, BaseEntityService.NULL_CUSTOMER_ID));
    verify(edgeId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId, CustomerId)}.
   *
   * <ul>
   *   <li>Then calls {@link ApplicationEventPublisher#publishEvent(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignEdgeToCustomer(TenantId, EdgeId,
   * CustomerId)}
   */
  @Test
  @DisplayName(
      "Test assignEdgeToCustomer(TenantId, EdgeId, CustomerId); then calls publishEvent(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Edge EdgeServiceImpl.assignEdgeToCustomer(TenantId, EdgeId, CustomerId)"})
  void testAssignEdgeToCustomer_thenCallsPublishEvent() {
    // Arrange
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(new Edge());
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "[{}] Executing assignEdgeToCustomer [{}][{}]");
    doThrow(constraintViolationException)
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
   * Test {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}
   */
  @Test
  @DisplayName("Test deleteEdge(TenantId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdge(TenantId, EdgeId)"})
  void testDeleteEdge() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteEdge [{}]");
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);

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
  @DisplayName("Test deleteEdge(TenantId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdge(TenantId, EdgeId)"})
  void testDeleteEdge2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteEdge [{}]");
    doThrow(constraintViolationException)
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
  @DisplayName(
      "Test deleteEdge(TenantId, EdgeId); given EdgeDao findById(TenantId, UUID) return 'null'; then calls findById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdge(TenantId, EdgeId)"})
  void testDeleteEdge_givenEdgeDaoFindByIdReturnNull_thenCallsFindById() {
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
   *   <li>Given {@link EdgeServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEdge(TenantId, EdgeId)}
   */
  @Test
  @DisplayName("Test deleteEdge(TenantId, EdgeId); given EdgeServiceImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdge(TenantId, EdgeId)"})
  void testDeleteEdge_givenEdgeServiceImpl() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteEdge [{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.deleteEdge(ModelConstants.SYSTEM_TENANT, edgeId));
    verify(edgeId).getId();
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
  @DisplayName("Test deleteEdge(TenantId, EdgeId); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdge(TenantId, EdgeId)"})
  void testDeleteEdge_thenCallsGetId() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteEdge [{}]");
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);

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
  @DisplayName("Test deleteEdge(TenantId, EdgeId); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdge(TenantId, EdgeId)"})
  void testDeleteEdge_thenCallsGetTenantId() {
    // Arrange
    Edge edge = mock(Edge.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(edge.getTenantId()).thenThrow(constraintViolationException);
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
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteEdge [{}]");
    when(edgeDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);

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
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteEdge [{}]");
    doThrow(constraintViolationException)
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
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given EdgeDao findById(TenantId, UUID) return 'null'; then calls findById(TenantId, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenEdgeDaoFindByIdReturnNull_thenCallsFindById() {
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
   *   <li>Given {@link EdgeServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given EdgeServiceImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenEdgeServiceImpl() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    EdgeId id = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Executing deleteEdge [{}]");
    when(id.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true));
    verify(id).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    Edge edge = mock(Edge.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(edge.getTenantId()).thenThrow(constraintViolationException);
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
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean); then calls getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_thenCallsGetTenantId() {
    // Arrange
    Edge edge = mock(Edge.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "Constraint Name");
    when(edge.getTenantId()).thenThrow(constraintViolationException);
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
  @DisplayName("Test findEdgesByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  void testFindEdgesByTenantId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantId, tenantId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

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
  @DisplayName("Test findEdgesByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  void testFindEdgesByTenantId2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantId, tenantId [{}], pageLink [{}]");
    when(pageLink.getPage()).thenThrow(constraintViolationException);
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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  void testFindEdgesByTenantId3() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantId, tenantId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  void testFindEdgesByTenantId4() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantId, tenantId [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  void testFindEdgesByTenantId5() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantId, tenantId [{}], pageLink [{}]");
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantId(TenantId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  void testFindEdgesByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult =
        edgeServiceImpl.findEdgesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantId(TenantId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  void testFindEdgesByTenantId_thenCallsGetId() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult =
        edgeServiceImpl.findEdgesByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdResult);
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
  @DisplayName("Test findEdgesByTenantId(TenantId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  void testFindEdgesByTenantId_thenCallsGetProperty() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdResult =
        edgeServiceImpl.findEdgesByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdResult);
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
  @DisplayName(
      "Test findEdgesByTenantId(TenantId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgesByTenantId(TenantId, PageLink)"})
  void testFindEdgesByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndType() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndType2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndType3() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantIdAndType(tenantId, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndType4() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(edgeDao.findEdgesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndType(TenantId, String, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndType(TenantId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndType_thenCallsGetId() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndType(tenantId, "Type", pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao).findEdgesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndTypeResult);
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
  @DisplayName(
      "Test findEdgesByTenantIdAndType(TenantId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndType(ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao).findEdgesByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndTypeResult);
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
  @DisplayName(
      "Test findEdgesByTenantIdAndType(TenantId, String, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndType_whenFirst_page_thenReturnEmpty_page_data() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndType() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndType2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndType3() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndType(tenantId, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndType4() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndType, tenantId [{}], type [{}], pageLink [{}]");
    when(edgeDao.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndType(TenantId, String, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndType_givenBy_created_time_desc() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndType(TenantId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndType(TenantId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndType_thenCallsGetId() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndType(tenantId, "Type", pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdAndTypeResult);
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
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndType(TenantId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndType(
            Mockito.<UUID>any(), Mockito.<String>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndTypeResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndType(
            ModelConstants.SYSTEM_TENANT, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndType(isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdAndTypeResult);
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
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndType(TenantId, String, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndType(TenantId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndType_whenFirst_page_thenReturnEmpty_page_data() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  void testFindEdgeInfosByTenantId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantId, tenantId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

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
  @DisplayName("Test findEdgeInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  void testFindEdgeInfosByTenantId2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantId, tenantId [{}], pageLink [{}]");
    when(pageLink.getPage()).thenThrow(constraintViolationException);
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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  void testFindEdgeInfosByTenantId3() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantId, tenantId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  void testFindEdgeInfosByTenantId4() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantId, tenantId [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeInfosByTenantId(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeInfosByTenantId(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  void testFindEdgeInfosByTenantId5() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantId, tenantId [{}], pageLink [{}]");
    when(edgeDao.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeInfosByTenantId(TenantId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  void testFindEdgeInfosByTenantId_givenBy_created_time_desc() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        edgeServiceImpl.findEdgeInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao).findEdgeInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantId(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeInfosByTenantId(TenantId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  void testFindEdgeInfosByTenantId_thenCallsGetId() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        edgeServiceImpl.findEdgeInfosByTenantId(tenantId, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao).findEdgeInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdResult);
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
  @DisplayName("Test findEdgeInfosByTenantId(TenantId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  void testFindEdgeInfosByTenantId_thenCallsGetProperty() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdResult =
        edgeServiceImpl.findEdgeInfosByTenantId(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao).findEdgeInfosByTenantId(isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdResult);
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
  @DisplayName(
      "Test findEdgeInfosByTenantId(TenantId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData EdgeServiceImpl.findEdgeInfosByTenantId(TenantId, PageLink)"})
  void testFindEdgeInfosByTenantId_whenFirst_page_thenReturnEmpty_page_data() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndIdsAsync(TenantId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindEdgesByTenantIdAndIdsAsync() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndIdsAsync, tenantId [{}], edgeIds [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantIdAndIdsAsync(tenantId, new ArrayList<>()));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndIdsAsync(TenantId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindEdgesByTenantIdAndIdsAsync2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndIdsAsync, tenantId [{}], edgeIds [{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(edgeId);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantIdAndIdsAsync(tenantId, edgeIds));
    verify(edgeId).getId();
    verify(tenantId, atLeast(1)).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndIdsAsync(TenantId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindEdgesByTenantIdAndIdsAsync3() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndIdsAsync, tenantId [{}], edgeIds [{}]");
    when(edgeDao.findEdgesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(constraintViolationException);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgesByTenantIdAndIdsAsync(tenantId, edgeIds));
    verify(tenantId, atLeast(1)).getId();
    verify(edgeDao).findEdgesByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
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
  @DisplayName("Test findEdgesByTenantIdAndIdsAsync(TenantId, List); then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindEdgesByTenantIdAndIdsAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<Edge>> createResult = SettableFuture.create();
    when(edgeDao.findEdgesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdAndIdsAsyncResult =
        edgeServiceImpl.findEdgesByTenantIdAndIdsAsync(tenantId, edgeIds);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(edgeDao).findEdgesByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
    assertTrue(actualFindEdgesByTenantIdAndIdsAsyncResult instanceof SettableFuture);
    assertSame(createResult, actualFindEdgesByTenantIdAndIdsAsyncResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndIdsAsync(TenantId, List)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndIdsAsync(TenantId, List); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdAndIdsAsync(TenantId, List)"
  })
  void testFindEdgesByTenantIdAndIdsAsync_thenThrowDataValidationException() {
    // Arrange
    when(edgeDao.findEdgesByTenantIdAndIdsAsync(Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(edgeId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> edgeServiceImpl.findEdgesByTenantIdAndIdsAsync(tenantId, edgeIds));
    verify(edgeId).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(edgeDao).findEdgesByTenantIdAndIdsAsync(isA(UUID.class), isA(List.class));
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
  @DisplayName(
      "Test deleteEdgesByTenantId(TenantId); given PageData hasNext() return 'false'; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdgesByTenantId(TenantId)"})
  void testDeleteEdgesByTenantId_givenPageDataHasNextReturnFalse_thenCallsGetData() {
    // Arrange
    PageData<Edge> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    edgeServiceImpl.deleteEdgesByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageData).getData();
    verify(pageData).hasNext();
    verify(edgeDao).findEdgesByTenantId(isA(UUID.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#deleteEdgesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link EdgeDao#findEdgesByTenantId(UUID, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEdgesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteEdgesByTenantId(TenantId); then calls findEdgesByTenantId(UUID, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdgesByTenantId(TenantId)"})
  void testDeleteEdgesByTenantId_thenCallsFindEdgesByTenantId() {
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
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteEdgesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteEdgesByTenantId(TenantId); then throw ConstraintViolationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteEdgesByTenantId(TenantId)"})
  void testDeleteEdgesByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing deleteEdgesByTenantId, tenantId [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> edgeServiceImpl.deleteEdgesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link EdgeServiceImpl} (default constructor).
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); given EdgeServiceImpl (default constructor); then throw ConstraintViolationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_givenEdgeServiceImpl_thenThrowConstraintViolationException() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing deleteEdgesByTenantId, tenantId [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class, () -> edgeServiceImpl.deleteByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link PageData} {@link PageData#hasNext()} return {@code false}.
   *   <li>Then calls {@link PageData#getData()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); given PageData hasNext() return 'false'; then calls getData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_givenPageDataHasNextReturnFalse_thenCallsGetData() {
    // Arrange
    PageData<Edge> pageData = mock(PageData.class);
    when(pageData.hasNext()).thenReturn(false);
    when(pageData.getData()).thenReturn(new ArrayList<>());
    when(edgeDao.findEdgesByTenantId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    edgeServiceImpl.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId, atLeast(1)).getId();
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
  @DisplayName("Test deleteByTenantId(TenantId); then calls findEdgesByTenantId(UUID, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenCallsFindEdgesByTenantId() {
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
  @DisplayName("Test findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerId2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerId3() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerId(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerId4() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerId_givenBy_created_time_desc() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerId(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerId_thenCallsGetId2() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerId(tenantId, customerId, pageLink);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndCustomerIdResult);
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
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerId_thenCallsGetProperty() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerId(isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndCustomerIdResult);
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
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerId_whenFirst_page_thenReturnEmpty_page_data() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerIdAndType() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

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
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerIdAndType2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(pageLink.getPage()).thenThrow(constraintViolationException);
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
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerIdAndType3() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerIdAndType4() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerIdAndType5() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(edgeDao.findEdgesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerIdAndType_givenBy_created_time_desc() {
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
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerIdAndType_thenCallsGetId() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerIdAndType_thenCallsGetId2() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
            tenantId, customerId, "Type", pageLink);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult);
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
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerIdAndType_thenCallsGetProperty() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndCustomerIdAndTypeResult =
        edgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, "Type", pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgesByTenantIdAndCustomerIdAndType(
            isA(UUID.class), isA(UUID.class), eq("Type"), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId,
   * String, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndCustomerIdAndType(TenantId,
   * CustomerId, String, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); when FIRST_PAGE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgesByTenantIdAndCustomerIdAndType_whenFirst_page() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

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
  @DisplayName("Test findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerId2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerId3() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerId4() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerId, tenantId [{}], customerId [{}], pageLink [{}]");
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerId_givenBy_created_time_desc() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerId_thenCallsGetId() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(
            tenantId, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdAndCustomerIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId,
   * PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link CustomerId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerId(TenantId,
   * CustomerId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerId_thenCallsGetId2() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(tenantId, customerId, pageLink);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdAndCustomerIdResult);
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
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerId_thenCallsGetProperty() {
    // Arrange
    PageData<EdgeInfo> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerId(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeInfo> actualFindEdgeInfosByTenantIdAndCustomerIdResult =
        edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(
            ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgeInfosByTenantIdAndCustomerId(
            isA(UUID.class), isA(UUID.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdAndCustomerIdResult);
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
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink); when FIRST_PAGE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerId(TenantId, CustomerId, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerId_whenFirst_page() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdAndCustomerIdResult);
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
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerIdAndType() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

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
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerIdAndType2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(pageLink.getPage()).thenThrow(constraintViolationException);
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
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerIdAndType3() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(edgeDao.findEdgeInfosByTenantIdAndCustomerIdAndType(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<String>any(),
            Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

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
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * EdgeServiceImpl#findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenCallsGetId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, "Type", mock(PageLink.class)));
    verify(tenantId).getId();
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
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenCallsGetProperty() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeInfosByTenantIdAndCustomerIdAndType, tenantId [{}], customerId [{}], type [{}],"
                + " pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

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
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenReturnEmpty_page_data() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult);
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
  @DisplayName(
      "Test findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeInfosByTenantIdAndCustomerIdAndType(TenantId, CustomerId, String, PageLink)"
  })
  void testFindEdgeInfosByTenantIdAndCustomerIdAndType_thenReturnEmpty_page_data2() {
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
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeInfosByTenantIdAndCustomerIdAndTypeResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId,
   * CustomerId, List)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  void testFindEdgesByTenantIdCustomerIdAndIdsAsync() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdCustomerIdAndIdsAsync, tenantId [{}], customerId [{}], edgeIds [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(
                tenantId, BaseEntityService.NULL_CUSTOMER_ID, new ArrayList<>()));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId,
   * CustomerId, List)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  void testFindEdgesByTenantIdCustomerIdAndIdsAsync2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeId edgeId = mock(EdgeId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdCustomerIdAndIdsAsync, tenantId [{}], customerId [{}], edgeIds [{}]");
    when(edgeId.getId()).thenThrow(constraintViolationException);

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(edgeId);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(
                tenantId, customerId, edgeIds));
    verify(edgeId).getId();
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId,
   * List)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId,
   * CustomerId, List)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  void testFindEdgesByTenantIdCustomerIdAndIdsAsync3() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdCustomerIdAndIdsAsync, tenantId [{}], customerId [{}], edgeIds [{}]");
    when(edgeDao.findEdgesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(constraintViolationException);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(
                tenantId, customerId, edgeIds));
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(edgeDao)
        .findEdgesByTenantIdCustomerIdAndIdsAsync(
            isA(UUID.class), isA(UUID.class), isA(List.class));
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
  @DisplayName(
      "Test findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List); then return SettableFuture")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  void testFindEdgesByTenantIdCustomerIdAndIdsAsync_thenReturnSettableFuture() {
    // Arrange
    SettableFuture<List<Edge>> createResult = SettableFuture.create();
    when(edgeDao.findEdgesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenReturn(createResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Act
    ListenableFuture<List<Edge>> actualFindEdgesByTenantIdCustomerIdAndIdsAsyncResult =
        edgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(tenantId, customerId, edgeIds);

    // Assert
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
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
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId,
   * CustomerId, List)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(TenantId, CustomerId, List)"
  })
  void testFindEdgesByTenantIdCustomerIdAndIdsAsync_thenThrowDataValidationException() {
    // Arrange
    when(edgeDao.findEdgesByTenantIdCustomerIdAndIdsAsync(
            Mockito.<UUID>any(), Mockito.<UUID>any(), Mockito.<List<UUID>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    CustomerId customerId = mock(CustomerId.class);
    when(customerId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ArrayList<EdgeId> edgeIds = new ArrayList<>();
    edgeIds.add(edgeId);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdCustomerIdAndIdsAsync(
                tenantId, customerId, edgeIds));
    verify(edgeId).getId();
    verify(customerId, atLeast(1)).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(edgeDao)
        .findEdgesByTenantIdCustomerIdAndIdsAsync(
            isA(UUID.class), isA(UUID.class), isA(List.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByQuery(TenantId, EdgeSearchQuery)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByQuery(TenantId, EdgeSearchQuery)}
   */
  @Test
  @DisplayName("Test findEdgesByQuery(TenantId, EdgeSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByQuery(TenantId, EdgeSearchQuery)"
  })
  void testFindEdgesByQuery() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "[{}] Executing findEdgesByQuery [{}]");
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByQuery(ModelConstants.SYSTEM_TENANT, new EdgeSearchQuery()));
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByQuery(TenantId, EdgeSearchQuery)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByQuery(TenantId, EdgeSearchQuery)}
   */
  @Test
  @DisplayName("Test findEdgesByQuery(TenantId, EdgeSearchQuery)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByQuery(TenantId, EdgeSearchQuery)"
  })
  void testFindEdgesByQuery2() {
    // Arrange
    ListenableFutureTask<List<EntityRelation>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred", new SQLException(), "[{}] Executing findEdgesByQuery [{}]");
    doThrow(constraintViolationException)
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(listenableFutureTask);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByQuery(ModelConstants.SYSTEM_TENANT, new EdgeSearchQuery()));
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByQuery(TenantId, EdgeSearchQuery)}.
   *
   * <ul>
   *   <li>Given {@link RelationService} {@link RelationService#findByQuery(TenantId,
   *       EntityRelationsQuery)} return create.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByQuery(TenantId, EdgeSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByQuery(TenantId, EdgeSearchQuery); given RelationService findByQuery(TenantId, EntityRelationsQuery) return create")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByQuery(TenantId, EdgeSearchQuery)"
  })
  void testFindEdgesByQuery_givenRelationServiceFindByQueryReturnCreate() {
    // Arrange
    SettableFuture<List<EntityRelation>> createResult = SettableFuture.create();
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(createResult);

    // Act
    edgeServiceImpl.findEdgesByQuery(ModelConstants.SYSTEM_TENANT, new EdgeSearchQuery());

    // Assert
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByQuery(TenantId, EdgeSearchQuery)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByQuery(TenantId, EdgeSearchQuery)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByQuery(TenantId, EdgeSearchQuery); then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ListenableFuture EdgeServiceImpl.findEdgesByQuery(TenantId, EdgeSearchQuery)"
  })
  void testFindEdgesByQuery_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<List<EntityRelation>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(relationService.findByQuery(Mockito.<TenantId>any(), Mockito.<EntityRelationsQuery>any()))
        .thenReturn(listenableFutureTask);

    // Act
    edgeServiceImpl.findEdgesByQuery(ModelConstants.SYSTEM_TENANT, new EdgeSearchQuery());

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(relationService).findByQuery(isA(TenantId.class), isA(EntityRelationsQuery.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test findEdgeTypesByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EdgeServiceImpl.findEdgeTypesByTenantId(TenantId)"})
  void testFindEdgeTypesByTenantId() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeTypesByTenantId, tenantId [{}]");
    when(edgeDao.findTenantEdgeTypesAsync(Mockito.<UUID>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeTypesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(edgeDao).findTenantEdgeTypesAsync(isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test findEdgeTypesByTenantId(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EdgeServiceImpl.findEdgeTypesByTenantId(TenantId)"})
  void testFindEdgeTypesByTenantId2() {
    // Arrange
    ListenableFutureTask<List<EntitySubtype>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeTypesByTenantId, tenantId [{}]");
    doThrow(constraintViolationException)
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(edgeDao.findTenantEdgeTypesAsync(Mockito.<UUID>any())).thenReturn(listenableFutureTask);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeTypesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(edgeDao).findTenantEdgeTypesAsync(isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link EdgeDao} {@link EdgeDao#findTenantEdgeTypesAsync(UUID)} return create.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test findEdgeTypesByTenantId(TenantId); given EdgeDao findTenantEdgeTypesAsync(UUID) return create")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EdgeServiceImpl.findEdgeTypesByTenantId(TenantId)"})
  void testFindEdgeTypesByTenantId_givenEdgeDaoFindTenantEdgeTypesAsyncReturnCreate() {
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
   *   <li>Given {@link EdgeServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test findEdgeTypesByTenantId(TenantId); given EdgeServiceImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EdgeServiceImpl.findEdgeTypesByTenantId(TenantId)"})
  void testFindEdgeTypesByTenantId_givenEdgeServiceImpl() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeTypesByTenantId, tenantId [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.findEdgeTypesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test findEdgeTypesByTenantId(TenantId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EdgeServiceImpl.findEdgeTypesByTenantId(TenantId)"})
  void testFindEdgeTypesByTenantId_givenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    ListenableFutureTask<List<EntitySubtype>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(edgeDao.findTenantEdgeTypesAsync(Mockito.<UUID>any())).thenReturn(listenableFutureTask);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    edgeServiceImpl.findEdgeTypesByTenantId(tenantId);

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(tenantId, atLeast(1)).getId();
    verify(edgeDao).findTenantEdgeTypesAsync(isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeTypesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test findEdgeTypesByTenantId(TenantId); then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ListenableFuture EdgeServiceImpl.findEdgeTypesByTenantId(TenantId)"})
  void testFindEdgeTypesByTenantId_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<List<EntitySubtype>> listenableFutureTask =
        mock(ListenableFutureTask.class);
    doNothing()
        .when(listenableFutureTask)
        .addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    when(edgeDao.findTenantEdgeTypesAsync(Mockito.<UUID>any())).thenReturn(listenableFutureTask);

    // Act
    edgeServiceImpl.findEdgeTypesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(listenableFutureTask).addListener(isA(Runnable.class), isA(Executor.class));
    verify(edgeDao).findTenantEdgeTypesAsync(isA(UUID.class));
  }

  /**
   * Test {@link EdgeServiceImpl#assignDefaultRuleChainsToEdge(TenantId, EdgeId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignDefaultRuleChainsToEdge(TenantId, EdgeId)}
   */
  @Test
  @DisplayName("Test assignDefaultRuleChainsToEdge(TenantId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.assignDefaultRuleChainsToEdge(TenantId, EdgeId)"})
  void testAssignDefaultRuleChainsToEdge() {
    // Arrange
    PageData<RuleChain> emptyPageDataResult = PageData.emptyPageData();
    when(ruleChainService.findAutoAssignToEdgeRuleChainsByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    edgeServiceImpl.assignDefaultRuleChainsToEdge(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(ruleChainService)
        .findAutoAssignToEdgeRuleChainsByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#assignDefaultRuleChainsToEdge(TenantId, EdgeId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignDefaultRuleChainsToEdge(TenantId, EdgeId)}
   */
  @Test
  @DisplayName("Test assignDefaultRuleChainsToEdge(TenantId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.assignDefaultRuleChainsToEdge(TenantId, EdgeId)"})
  void testAssignDefaultRuleChainsToEdge2() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing assignDefaultRuleChainsToEdge, tenantId [{}], edgeId [{}]");
    when(ruleChainService.findAutoAssignToEdgeRuleChainsByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.assignDefaultRuleChainsToEdge(ModelConstants.SYSTEM_TENANT, null));
    verify(ruleChainService)
        .findAutoAssignToEdgeRuleChainsByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#assignDefaultRuleChainsToEdge(TenantId, EdgeId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignDefaultRuleChainsToEdge(TenantId, EdgeId)}
   */
  @Test
  @DisplayName("Test assignDefaultRuleChainsToEdge(TenantId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.assignDefaultRuleChainsToEdge(TenantId, EdgeId)"})
  void testAssignDefaultRuleChainsToEdge3() {
    // Arrange
    PageData<RuleChain> pageData = new PageData<>(new ArrayList<>(), 1024, 1024L, true);
    when(ruleChainService.findAutoAssignToEdgeRuleChainsByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    edgeServiceImpl.assignDefaultRuleChainsToEdge(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(ruleChainService, atLeast(1))
        .findAutoAssignToEdgeRuleChainsByTenantId(isA(TenantId.class), Mockito.<PageLink>any());
  }

  /**
   * Test {@link EdgeServiceImpl#assignDefaultRuleChainsToEdge(TenantId, EdgeId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignDefaultRuleChainsToEdge(TenantId, EdgeId)}
   */
  @Test
  @DisplayName("Test assignDefaultRuleChainsToEdge(TenantId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.assignDefaultRuleChainsToEdge(TenantId, EdgeId)"})
  void testAssignDefaultRuleChainsToEdge4() {
    // Arrange
    ArrayList<RuleChain> data = new ArrayList<>();
    data.add(new RuleChain());
    PageData<RuleChain> pageData = new PageData<>(data, 1024, 1024L, true);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing assignDefaultRuleChainsToEdge, tenantId [{}], edgeId [{}]");
    when(ruleChainService.assignRuleChainToEdge(
            Mockito.<TenantId>any(), Mockito.<RuleChainId>any(), Mockito.<EdgeId>any()))
        .thenThrow(constraintViolationException);
    when(ruleChainService.findAutoAssignToEdgeRuleChainsByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> edgeServiceImpl.assignDefaultRuleChainsToEdge(ModelConstants.SYSTEM_TENANT, null));
    verify(ruleChainService).assignRuleChainToEdge(isA(TenantId.class), isNull(), isNull());
    verify(ruleChainService)
        .findAutoAssignToEdgeRuleChainsByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#assignDefaultRuleChainsToEdge(TenantId, EdgeId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#assignDefaultRuleChainsToEdge(TenantId, EdgeId)}
   */
  @Test
  @DisplayName("Test assignDefaultRuleChainsToEdge(TenantId, EdgeId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeServiceImpl.assignDefaultRuleChainsToEdge(TenantId, EdgeId)"})
  void testAssignDefaultRuleChainsToEdge5() {
    // Arrange
    ArrayList<RuleChain> data = new ArrayList<>();
    data.add(new RuleChain());
    PageData<RuleChain> pageData = new PageData<>(data, 1024, 1024L, false);
    when(ruleChainService.assignRuleChainToEdge(
            Mockito.<TenantId>any(), Mockito.<RuleChainId>any(), Mockito.<EdgeId>any()))
        .thenReturn(new RuleChain());
    when(ruleChainService.findAutoAssignToEdgeRuleChainsByTenantId(
            Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act
    edgeServiceImpl.assignDefaultRuleChainsToEdge(ModelConstants.SYSTEM_TENANT, null);

    // Assert
    verify(ruleChainService).assignRuleChainToEdge(isA(TenantId.class), isNull(), isNull());
    verify(ruleChainService)
        .findAutoAssignToEdgeRuleChainsByTenantId(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgesByTenantIdAndEntityId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    AlarmId entityId = mock(AlarmId.class);

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgesByTenantIdAndEntityId2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    AlarmId entityId = mock(AlarmId.class);

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgesByTenantIdAndEntityId3() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantIdAndEntityId(
                tenantId, mock(AlarmId.class), mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgesByTenantIdAndEntityId4() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(edgeDao.findEdgesByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgesByTenantIdAndEntityId_givenBy_created_time_desc() {
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

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult =
        edgeServiceImpl.findEdgesByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT, entityId, pageLink);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgesByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgesByTenantIdAndEntityId_thenCallsGetId() {
    // Arrange
    PageData<Edge> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgesByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult =
        edgeServiceImpl.findEdgesByTenantIdAndEntityId(tenantId, entityId, pageLink);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgesByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgesByTenantIdAndEntityId_thenCallsGetProperty() {
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

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<Edge> actualFindEdgesByTenantIdAndEntityIdResult =
        edgeServiceImpl.findEdgesByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT, entityId, pageLink);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgesByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink); when FIRST_PAGE; then calls getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgesByTenantIdAndEntityId_whenFirst_page_thenCallsGetEntityType() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndEntityIdResult);
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
  @DisplayName(
      "Test findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgesByTenantIdAndEntityId_whenFirst_page_thenReturnEmpty_page_data() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantIdAndEntityId(TenantId, EntityId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink); when NULL_CUSTOMER_ID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgesByTenantIdAndEntityId_whenNull_customer_id() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByTenantIdAndEntityId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    AlarmId entityId = mock(AlarmId.class);

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeIdsByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByTenantIdAndEntityId2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();
    AlarmId entityId = mock(AlarmId.class);

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeIdsByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByTenantIdAndEntityId3() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeIdsByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(tenantId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(
                tenantId, mock(AlarmId.class), mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @DisplayName("Test findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByTenantIdAndEntityId4() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgeIdsByTenantIdAndEntityId, tenantId [{}], entityId [{}], pageLink [{}]");
    when(edgeDao.findEdgeIdsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByTenantIdAndEntityId_givenBy_created_time_desc() {
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

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeId> actualFindEdgeIdsByTenantIdAndEntityIdResult =
        edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT, entityId, pageLink);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(edgeDao)
        .findEdgeIdsByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeIdsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByTenantIdAndEntityId_thenCallsGetId() {
    // Arrange
    PageData<EdgeId> emptyPageDataResult = PageData.emptyPageData();
    when(edgeDao.findEdgeIdsByTenantIdAndEntityId(
            Mockito.<UUID>any(),
            Mockito.<UUID>any(),
            Mockito.<EntityType>any(),
            Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AlarmId entityId = mock(AlarmId.class);
    when(entityId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(entityId.getEntityType()).thenReturn(EntityType.TENANT);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeId> actualFindEdgeIdsByTenantIdAndEntityIdResult =
        edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(tenantId, entityId, pageLink);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(tenantId, atLeast(1)).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgeIdsByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeIdsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink); then calls getProperty()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByTenantIdAndEntityId_thenCallsGetProperty() {
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

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<EdgeId> actualFindEdgeIdsByTenantIdAndEntityIdResult =
        edgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(
            ModelConstants.SYSTEM_TENANT, entityId, pageLink);

    // Assert
    verify(entityId).getEntityType();
    verify(entityId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(edgeDao)
        .findEdgeIdsByTenantIdAndEntityId(
            isA(UUID.class), isA(UUID.class), eq(EntityType.TENANT), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeIdsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then calls {@link AlarmId#getEntityType()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink); when FIRST_PAGE; then calls getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByTenantIdAndEntityId_whenFirst_page_thenCallsGetEntityType() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeIdsByTenantIdAndEntityIdResult);
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
  @DisplayName(
      "Test findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByTenantIdAndEntityId_whenFirst_page_thenReturnEmpty_page_data() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeIdsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgeIdsByTenantIdAndEntityId(TenantId,
   * EntityId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink); when NULL_CUSTOMER_ID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgeIdsByTenantIdAndEntityId(TenantId, EntityId, PageLink)"
  })
  void testFindEdgeIdsByTenantIdAndEntityId_whenNull_customer_id() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgeIdsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantProfileId(TenantProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  void testFindEdgesByTenantProfileId() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantProfileId, tenantProfileId [{}], pageLink [{}]");
    when(tenantProfileId.getId()).thenThrow(constraintViolationException);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            edgeServiceImpl.findEdgesByTenantProfileId(
                tenantProfileId, BaseRelatedEdgesService.FIRST_PAGE));
    verify(tenantProfileId).getId();
  }

  /**
   * Test {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId, PageLink)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantProfileId(TenantProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  void testFindEdgesByTenantProfileId2() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantProfileId, tenantProfileId [{}], pageLink [{}]");
    when(pageLink.getPageSize()).thenThrow(constraintViolationException);

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
  @DisplayName("Test findEdgesByTenantProfileId(TenantProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  void testFindEdgesByTenantProfileId3() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    PageLink pageLink = mock(PageLink.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantProfileId, tenantProfileId [{}], pageLink [{}]");
    when(pageLink.getPage()).thenThrow(constraintViolationException);
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
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @DisplayName("Test findEdgesByTenantProfileId(TenantProfileId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  void testFindEdgesByTenantProfileId4() {
    // Arrange
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantProfileId, tenantProfileId [{}], pageLink [{}]");
    when(edgeDao.findEdgesByTenantProfileId(Mockito.<UUID>any(), Mockito.<PageLink>any()))
        .thenThrow(constraintViolationException);

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
   * <ul>
   *   <li>Then calls {@link PageLink#getSortOrder()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantProfileId(TenantProfileId, PageLink); then calls getSortOrder()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  void testFindEdgesByTenantProfileId_thenCallsGetSortOrder() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    TenantProfileId tenantProfileId = mock(TenantProfileId.class);
    when(tenantProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    ConstraintViolationException constraintViolationException =
        new ConstraintViolationException(
            "An error occurred",
            new SQLException(),
            "Executing findEdgesByTenantProfileId, tenantProfileId [{}], pageLink [{}]");
    when(sortOrder.getProperty()).thenThrow(constraintViolationException);

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
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeServiceImpl#findEdgesByTenantProfileId(TenantProfileId,
   * PageLink)}
   */
  @Test
  @DisplayName(
      "Test findEdgesByTenantProfileId(TenantProfileId, PageLink); then return EMPTY_PAGE_DATA")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "PageData EdgeServiceImpl.findEdgesByTenantProfileId(TenantProfileId, PageLink)"
  })
  void testFindEdgesByTenantProfileId_thenReturnEmpty_page_data() {
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindEdgesByTenantProfileIdResult);
  }

  /**
   * Test {@link EdgeServiceImpl#findAllRelatedEdgeIds(TenantId, EntityId)}.
   *
   * <p>Method under test: {@link EdgeServiceImpl#findAllRelatedEdgeIds(TenantId, EntityId)}
   */
  @Test
  @DisplayName("Test findAllRelatedEdgeIds(TenantId, EntityId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List EdgeServiceImpl.findAllRelatedEdgeIds(TenantId, EntityId)"})
  void testFindAllRelatedEdgeIds() {
    // Arrange, Act and Assert
    assertNull(
        new EdgeServiceImpl()
            .findAllRelatedEdgeIds(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID));
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "EntityType EdgeServiceImpl.getEntityType()",
    "boolean EdgeServiceImpl.isEdgesEnabled()"
  })
  void testGettersAndSetters() {
    // Arrange
    EdgeServiceImpl edgeServiceImpl = new EdgeServiceImpl();

    // Act
    EntityType actualEntityType = edgeServiceImpl.getEntityType();

    // Assert
    assertEquals(EntityType.EDGE, actualEntityType);
    assertFalse(edgeServiceImpl.isEdgesEnabled());
  }
}
