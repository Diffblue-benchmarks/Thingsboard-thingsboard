package org.thingsboard.server.controller;

import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.thingsboard.server.common.data.EntityType;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult EntitiesVersionControlController.saveEntitiesVersion(VersionCreateRequest)"
  })
  void testSaveEntitiesVersion() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/entities/vc/version");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            objectMapper.writeValueAsString(new ComplexVersionCreateRequest()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link EntitiesVersionControlController#getVersionCreateRequestStatus(UUID)}.
   *
   * <p>Method under test: {@link
   * EntitiesVersionControlController#getVersionCreateRequestStatus(UUID)}
   */
  @Test
  @DisplayName("Test getVersionCreateRequestStatus(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.sync.vc.VersionCreationResult EntitiesVersionControlController.getVersionCreateRequestStatus(UUID)"
  })
  void testGetVersionCreateRequestStatus() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/entities/vc/version/{requestId}/status", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult EntitiesVersionControlController.listEntityVersions(EntityType, UUID, String, int, int, String, String, String)"
  })
  void testListEntityVersions() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get(
                "/api/entities/vc/version/{entityType}/{externalEntityUuid}",
                "Uri Variables",
                "Uri Variables",
                "Uri Variables")
            .param("branch", "foo");
    MockHttpServletRequestBuilder paramResult2 = paramResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder =
        paramResult2.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult EntitiesVersionControlController.listEntityTypeVersions(EntityType, String, int, int, String, String, String)"
  })
  void testListEntityTypeVersions() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get(
                "/api/entities/vc/version/{entityType}", "Uri Variables", "Uri Variables")
            .param("branch", "foo");
    MockHttpServletRequestBuilder paramResult2 = paramResult.param("page", String.valueOf(1));
    MockHttpServletRequestBuilder requestBuilder =
        paramResult2.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult EntitiesVersionControlController.listVersions(String, int, int, String, String, String)"
  })
  void testListVersions() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder paramResult =
        MockMvcRequestBuilders.get("/api/entities/vc/version")
            .param("branch", "foo")
            .param("page", "https://example.org/example");
    MockHttpServletRequestBuilder requestBuilder = paramResult.param("pageSize", String.valueOf(1));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link EntitiesVersionControlController#listEntitiesAtVersion(EntityType, String)}.
   *
   * <p>Method under test: {@link EntitiesVersionControlController#listEntitiesAtVersion(EntityType,
   * String)}
   */
  @Test
  @DisplayName("Test listEntitiesAtVersion(EntityType, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult EntitiesVersionControlController.listEntitiesAtVersion(EntityType, String)"
  })
  void testListEntitiesAtVersion() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/entities/vc/entity/{entityType}/{versionId}",
            "Uri Variables",
            "Uri Variables",
            "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link EntitiesVersionControlController#getEntityDataInfo(String, EntityType, UUID)}.
   *
   * <p>Method under test: {@link EntitiesVersionControlController#getEntityDataInfo(String,
   * EntityType, UUID)}
   */
  @Test
  @DisplayName("Test getEntityDataInfo(String, EntityType, UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult EntitiesVersionControlController.getEntityDataInfo(String, EntityType, UUID)"
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
        .andExpect(MockMvcResultMatchers.status().is(400));
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.springframework.web.context.request.async.DeferredResult EntitiesVersionControlController.compareEntityDataToVersion(EntityType, UUID, String)"
  })
  void testCompareEntityDataToVersion() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
                "/api/entities/vc/diff/{entityType}/{internalEntityUuid}",
                "Uri Variables",
                "Uri Variables",
                "Uri Variables")
            .param("versionId", "foo");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }

  /**
   * Test {@link EntitiesVersionControlController#loadEntitiesVersion(VersionLoadRequest)}.
   *
   * <p>Method under test: {@link
   * EntitiesVersionControlController#loadEntitiesVersion(VersionLoadRequest)}
   */
  @Test
  @DisplayName("Test loadEntitiesVersion(VersionLoadRequest)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "UUID EntitiesVersionControlController.loadEntitiesVersion(VersionLoadRequest)"
  })
  void testLoadEntitiesVersion() throws Exception {
    // Arrange
    MockHttpServletRequestBuilder postResult =
        MockMvcRequestBuilders.post("/api/entities/vc/entity");
    postResult.characterEncoding("https://example.org/example");
    MockHttpServletRequestBuilder contentTypeResult =
        postResult.contentType(MediaType.APPLICATION_JSON);

    ObjectMapper objectMapper = new ObjectMapper();
    MockHttpServletRequestBuilder requestBuilder =
        contentTypeResult.content(
            objectMapper.writeValueAsString(new EntityTypeVersionLoadRequest()));

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(415));
  }

  /**
   * Test {@link EntitiesVersionControlController#getVersionLoadRequestStatus(UUID)}.
   *
   * <p>Method under test: {@link
   * EntitiesVersionControlController#getVersionLoadRequestStatus(UUID)}
   */
  @Test
  @DisplayName("Test getVersionLoadRequestStatus(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.sync.vc.VersionLoadResult EntitiesVersionControlController.getVersionLoadRequestStatus(UUID)"
  })
  void testGetVersionLoadRequestStatus() throws Exception {
    // Arrange
    UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MockHttpServletRequestBuilder requestBuilder =
        MockMvcRequestBuilders.get(
            "/api/entities/vc/entity/{requestId}/status", "Uri Variables", "Uri Variables");

    // Act and Assert
    MockMvcBuilders.standaloneSetup(entitiesVersionControlController)
        .setControllerAdvice(thingsboardErrorResponseHandler)
        .build()
        .perform(requestBuilder)
        .andExpect(MockMvcResultMatchers.status().is(400));
  }
}
