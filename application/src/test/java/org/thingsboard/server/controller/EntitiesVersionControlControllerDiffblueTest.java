package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.api.core.ApiFutureToListenableFuture;
import com.google.api.core.ForwardingApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.SettableFuture;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.sync.vc.request.create.ComplexVersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.create.VersionCreateRequest;
import org.thingsboard.server.common.data.sync.vc.request.load.EntityTypeVersionLoadRequest;
import org.thingsboard.server.common.data.sync.vc.request.load.VersionLoadRequest;
import org.thingsboard.server.exception.ThingsboardErrorResponseHandler;

@ExtendWith(MockitoExtension.class)
class EntitiesVersionControlControllerDiffblueTest {
  @InjectMocks private EntitiesVersionControlController entitiesVersionControlController;

  @Mock private ThingsboardErrorResponseHandler thingsboardErrorResponseHandler;

  /**
   * Test {@link EntitiesVersionControlController#saveEntitiesVersion(VersionCreateRequest)}.
   *
   * <p>Method under test: {@link
   * EntitiesVersionControlController#saveEntitiesVersion(VersionCreateRequest)}
   */
  @Test
  @DisplayName("Test saveEntitiesVersion(VersionCreateRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult EntitiesVersionControlController.saveEntitiesVersion(VersionCreateRequest)"
  })
  void testSaveEntitiesVersion() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntitiesVersionControlController entitiesVersionControlController =
        new EntitiesVersionControlController(null);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            entitiesVersionControlController.saveEntitiesVersion(
                new ComplexVersionCreateRequest()));
  }

  /**
   * Test {@link EntitiesVersionControlController#getVersionCreateRequestStatus(UUID)}.
   *
   * <p>Method under test: {@link
   * EntitiesVersionControlController#getVersionCreateRequestStatus(UUID)}
   */
  @Test
  @DisplayName("Test getVersionCreateRequestStatus(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.sync.vc.VersionCreationResult EntitiesVersionControlController.getVersionCreateRequestStatus(UUID)"
  })
  void testGetVersionCreateRequestStatus() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/entities/vc/version/{requestId}/status", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link EntitiesVersionControlController#listEntityVersions(EntityType, UUID, String, int,
   * int, String, String, String)}.
   *
   * <p>Method under test: {@link EntitiesVersionControlController#listEntityVersions(EntityType,
   * UUID, String, int, int, String, String, String)}
   */
  @Test
  @DisplayName(
      "Test listEntityVersions(EntityType, UUID, String, int, int, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult EntitiesVersionControlController.listEntityVersions(EntityType, UUID, String, int, int, String, String, String)"
  })
  void testListEntityVersions() throws Exception {
    // Arrange
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get(
            "/api/entities/vc/version/{entityType}/{externalEntityUuid}",
            "Entity Type",
            fromStringResult);

    MockHttpServletRequestBuilder requestBuilder =
        getResult
            .param("branch", "foo")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link EntitiesVersionControlController#listEntityTypeVersions(EntityType, String, int,
   * int, String, String, String)}.
   *
   * <p>Method under test: {@link
   * EntitiesVersionControlController#listEntityTypeVersions(EntityType, String, int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName("Test listEntityTypeVersions(EntityType, String, int, int, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult EntitiesVersionControlController.listEntityTypeVersions(EntityType, String, int, int, String, String, String)"
  })
  void testListEntityTypeVersions() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/entities/vc/version/{entityType}", "Entity Type")
            .param("branch", "foo")
            .param("page", String.valueOf(1))
            .param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link EntitiesVersionControlController#listVersions(String, int, int, String, String,
   * String)}.
   *
   * <p>Method under test: {@link EntitiesVersionControlController#listVersions(String, int, int,
   * String, String, String)}
   */
  @Test
  @DisplayName("Test listVersions(String, int, int, String, String, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult EntitiesVersionControlController.listVersions(String, int, int, String, String, String)"
  })
  void testListVersions() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            new EntitiesVersionControlController(null)
                .listVersions(
                    "janedoe/featurebranch", 3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link EntitiesVersionControlController#listEntitiesAtVersion(EntityType, String)}.
   *
   * <p>Method under test: {@link EntitiesVersionControlController#listEntitiesAtVersion(EntityType,
   * String)}
   */
  @Test
  @DisplayName("Test listEntitiesAtVersion(EntityType, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult EntitiesVersionControlController.listEntitiesAtVersion(EntityType, String)"
  })
  void testListEntitiesAtVersion() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/entities/vc/entity/{entityType}/{versionId}", "Entity Type", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link EntitiesVersionControlController#listAllEntitiesAtVersion(String)}.
   *
   * <p>Method under test: {@link EntitiesVersionControlController#listAllEntitiesAtVersion(String)}
   */
  @Test
  @DisplayName("Test listAllEntitiesAtVersion(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult EntitiesVersionControlController.listAllEntitiesAtVersion(String)"
  })
  void testListAllEntitiesAtVersion() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new EntitiesVersionControlController(null).listAllEntitiesAtVersion("42"));
  }

  /**
   * Test {@link EntitiesVersionControlController#getEntityDataInfo(String, EntityType, UUID)}.
   *
   * <p>Method under test: {@link EntitiesVersionControlController#getEntityDataInfo(String,
   * EntityType, UUID)}
   */
  @Test
  @DisplayName("Test getEntityDataInfo(String, EntityType, UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult EntitiesVersionControlController.getEntityDataInfo(String, EntityType, UUID)"
  })
  void testGetEntityDataInfo() throws Exception {
    // Arrange
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/entities/vc/info/{versionId}/{entityType}/{externalEntityUuid}",
            "42",
            "Entity Type",
            fromStringResult);

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link EntitiesVersionControlController#compareEntityDataToVersion(EntityType, UUID,
   * String)}.
   *
   * <p>Method under test: {@link
   * EntitiesVersionControlController#compareEntityDataToVersion(EntityType, UUID, String)}
   */
  @Test
  @DisplayName("Test compareEntityDataToVersion(EntityType, UUID, String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult EntitiesVersionControlController.compareEntityDataToVersion(EntityType, UUID, String)"
  })
  void testCompareEntityDataToVersion() throws Exception {
    // Arrange
    UUID fromStringResult = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    MockHttpServletRequestBuilder getResult =
        MockMvcRequestBuilders.get(
            "/api/entities/vc/diff/{entityType}/{internalEntityUuid}",
            "Entity Type",
            fromStringResult);

    MockHttpServletRequestBuilder requestBuilder = getResult.param("versionId", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link EntitiesVersionControlController#loadEntitiesVersion(VersionLoadRequest)}.
   *
   * <p>Method under test: {@link
   * EntitiesVersionControlController#loadEntitiesVersion(VersionLoadRequest)}
   */
  @Test
  @DisplayName("Test loadEntitiesVersion(VersionLoadRequest)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "UUID EntitiesVersionControlController.loadEntitiesVersion(VersionLoadRequest)"
  })
  void testLoadEntitiesVersion() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    EntitiesVersionControlController entitiesVersionControlController =
        new EntitiesVersionControlController(null);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            entitiesVersionControlController.loadEntitiesVersion(
                new EntityTypeVersionLoadRequest()));
  }

  /**
   * Test {@link EntitiesVersionControlController#getVersionLoadRequestStatus(UUID)}.
   *
   * <p>Method under test: {@link
   * EntitiesVersionControlController#getVersionLoadRequestStatus(UUID)}
   */
  @Test
  @DisplayName("Test getVersionLoadRequestStatus(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.sync.vc.VersionLoadResult EntitiesVersionControlController.getVersionLoadRequestStatus(UUID)"
  })
  void testGetVersionLoadRequestStatus() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get("/api/entities/vc/entity/{requestId}/status", "42");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(status().is(400));
  }

  /**
   * Test {@link EntitiesVersionControlController#listBranches()}.
   *
   * <p>Method under test: {@link EntitiesVersionControlController#listBranches()}
   */
  @Test
  @DisplayName("Test listBranches()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeferredResult EntitiesVersionControlController.listBranches()"})
  void testListBranches() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange, Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> new EntitiesVersionControlController(null).listBranches());
  }

  /**
   * Test {@link EntitiesVersionControlController#wrapFuture(ListenableFuture)} with {@code future}.
   *
   * <ul>
   *   <li>Then calls {@link ListenableFutureTask#addListener(Runnable, Executor)}.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesVersionControlController#wrapFuture(ListenableFuture)}
   */
  @Test
  @DisplayName(
      "Test wrapFuture(ListenableFuture) with 'future'; then calls addListener(Runnable, Executor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult EntitiesVersionControlController.wrapFuture(ListenableFuture)"
  })
  void testWrapFutureWithFuture_thenCallsAddListener() {
    // Arrange
    ListenableFutureTask<Object> delegate = mock(ListenableFutureTask.class);
    doNothing().when(delegate).addListener(Mockito.<Runnable>any(), Mockito.<Executor>any());
    ListenableFutureToApiFuture<Object> delegate2 = new ListenableFutureToApiFuture<>(delegate);
    ForwardingApiFuture<Object> apiFuture = new ForwardingApiFuture<>(delegate2);

    // Act
    DeferredResult<Object> actualWrapFutureResult =
        entitiesVersionControlController.wrapFuture(new ApiFutureToListenableFuture<>(apiFuture));

    // Assert
    verify(delegate).addListener(isA(Runnable.class), isA(Executor.class));
    assertNull(actualWrapFutureResult.getResult());
    assertFalse(actualWrapFutureResult.hasResult());
    assertFalse(actualWrapFutureResult.isSetOrExpired());
  }

  /**
   * Test {@link EntitiesVersionControlController#wrapFuture(ListenableFuture)} with {@code future}.
   *
   * <ul>
   *   <li>When {@link ListenableFutureToApiFuture#ListenableFutureToApiFuture(ListenableFuture)}
   *       with delegate is create.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesVersionControlController#wrapFuture(ListenableFuture)}
   */
  @Test
  @DisplayName(
      "Test wrapFuture(ListenableFuture) with 'future'; when ListenableFutureToApiFuture(ListenableFuture) with delegate is create")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeferredResult EntitiesVersionControlController.wrapFuture(ListenableFuture)"
  })
  void testWrapFutureWithFuture_whenListenableFutureToApiFutureWithDelegateIsCreate() {
    // Arrange
    SettableFuture<Object> delegate = SettableFuture.create();
    ForwardingApiFuture<Object> apiFuture =
        new ForwardingApiFuture<>(new ListenableFutureToApiFuture<>(delegate));

    // Act
    DeferredResult<Object> actualWrapFutureResult =
        entitiesVersionControlController.wrapFuture(new ApiFutureToListenableFuture<>(apiFuture));

    // Assert
    assertNull(actualWrapFutureResult.getResult());
    assertFalse(actualWrapFutureResult.hasResult());
    assertFalse(actualWrapFutureResult.isSetOrExpired());
  }
}
